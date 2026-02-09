package utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
public class MobileNumberInputUtil {

		/**
		 * Utility methods for working with Mobile/Contact Number fields in Web UI automation.
		 * Supports:
		 * <ul>
		 *   <li>Cleaning raw input (strip non-digits).</li>
		 *   <li>Validating length.</li>
		 *   <li>Formatting to pattern: (+91)xxx-xxx-xxxx.</li>
		 *   <li>Setting value via JavaScript + input/change events (framework-friendly).</li>
		 *   <li>Typing value via sendKeys (mask-friendly).</li>
		 *   <li>Select/replace last N characters.</li>
		 *   <li>Flexible element lookup WaitHelpers.</li>
		 * </ul>
		 *
		 * Usage pattern:
		 * <pre>
		 *   String mob = "9876543210"; // raw digits (or may include +91, spaces, etc.)
		 *   WebElement mobileInput = MobileNumberInputUtil.findInputByNthTextType(driver, 17); // replace with robust locator!
		 *   MobileNumberInputUtil.enterMobileFormattedJS(driver, mobileInput, mob);
		 * </pre>
		 */
	public MobileNumberInputUtil() {}

	    /* =======================================================
	     * private High-Level APIs
	     * ======================================================= */

	    /** Enter a mobile number formatted as (+91)xxx-xxx-xxxx using JS, dispatching input/change events. */
	    private static void enterMobileFormattedJS(WebDriver driver, WebElement input, String rawMob) {
	        Objects.requireNonNull(driver, "driver");
	        Objects.requireNonNull(input, "input");
	        String cleaned = cleanDigits(rawMob);
	        validateLength(cleaned, 10);
	        String formatted = formatIndianMobile(cleaned);
	        setInputValueViaJS(driver, input, formatted, true, true);
	    }

	    /** Enter a mobile number by typing (sendKeys). Lets any field masking/formatting scripts run naturally. */
	    private static void enterMobileByTyping(WebDriver driver, WebElement input, String rawMob, boolean clearFirst) {
	        Objects.requireNonNull(driver, "driver");
	        Objects.requireNonNull(input, "input");
	        String cleaned = cleanDigits(rawMob);
	        validateLength(cleaned, 10);
	        if (clearFirst) input.clear();
	        input.sendKeys(cleaned);
	    }

	    /** Replace last N characters in an input using JS selection + sendKeys. */
	    private static void replaceLastN(WebDriver driver, WebElement input, int n, String replacement) {
	        Objects.requireNonNull(driver, "driver");
	        Objects.requireNonNull(input, "input");
	        if (n < 0) throw new IllegalArgumentException("n must be >=0");
	        focusAndSelectLastN(driver, input, n);
	        input.sendKeys(replacement);
	    }

	    /* =======================================================
	     * Cleaning, Validation, Formatting
	     * ======================================================= */

	    /** Strip all non-digit characters. */
	    private static String cleanDigits(String s) {
	        return s == null ? "" : s.replaceAll("\\D", "");
	    }

	    /** Throw if string length != expected. */
	    private static void validateLength(String s, int expected) {
	        if (s.length() != expected) {
	            throw new IllegalArgumentException("Expected " + expected + " digits, got " + s.length() + ": '" + s + "'");
	        }
	    }

	    /** Format 10-digit Indian mobile as (+91)xxx-xxx-xxxx. */
	    private static String formatIndianMobile(String digits10) {
	        validateLength(digits10, 10);
	        return String.format("%s-%s-%s",
	                digits10.substring(0,3),
	                digits10.substring(3,6),
	                digits10.substring(6));
	    }

	    /* =======================================================
	     * JS WaitHelpers
	     * ======================================================= */

	    /** Set the value property via JS; optionally dispatch input and/or change events. */
	    private static void setInputValueViaJS(WebDriver driver, WebElement input, String value,
	                                          boolean fireInput, boolean fireChange) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        StringBuilder sb = new StringBuilder();
	        sb.append("arguments[0].value = arguments[1];");
	        if (fireInput)  sb.append("arguments[0].dispatchEvent(new Event('input', {bubbles:true}));");
	        if (fireChange) sb.append("arguments[0].dispatchEvent(new Event('change', {bubbles:true}));");
	        js.executeScript(sb.toString(), input, value);
	    }

	    /** Focus the element and select the last N characters using selectionStart/End. */
	    private static void focusAndSelectLastN(WebDriver driver, WebElement input, int n) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript(
	                "var el=arguments[0];" +
	                "el.focus();" +
	                "var len=el.value.length;" +
	                "var start=len-Math.max(0,arguments[1]);" +
	                "if(start<0)start=0;" +
	                "if(el.setSelectionRange){el.setSelectionRange(start,len);}"
	                , input, n);
	    }

	    /** Return currently selected text in an input (for debugging). */
	    private static String getSelectedText(WebDriver driver, WebElement input) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        Object o = js.executeScript(
	                "var el=arguments[0];" +
	                "return el.value.substring(el.selectionStart||0, el.selectionEnd||0);", input);
	        return o == null ? "" : o.toString();
	    }

	    /* =======================================================
	     * Locator Convenience Methods (sample patterns) — adjust to your AUT
	     * ======================================================= */

	    /** Find the Nth <input type='text'> (1-indexed) — brittle; prefer semantic locator. */
	    private static WebElement findInputByNthTextType(WebDriver driver, int n) {
	        return driver.findElement(By.xpath("(//input[@type='text'])[" + n + "]"));
	    }

	    /** Find an input that follows a label with the given visible text. */
	    private static WebElement findInputByLabel(WebDriver driver, String labelText) {
	        String xp = "//label[normalize-space()=" + xpathLiteral(labelText) + "]/following::input[1]";
	        return driver.findElement(By.xpath(xp));
	    }

	    /** Safe literal builder for XPath strings with quotes. */
	    private static String xpathLiteral(String s) {
	        if (s.contains("'")) {
	            // concat split by '
	            String[] parts = s.split("'");
	            StringBuilder sb = new StringBuilder("concat(");
	            for (int i = 0; i < parts.length; i++) {
	                sb.append("'").append(parts[i]).append("'");
	                if (i < parts.length - 1) sb.append(",\"'\", ");
	            }
	            sb.append(")");
	            return sb.toString();
	        } else {
	            return "'" + s + "'";
	        }
	    }

	    /* =======================================================
	     *  WaitHelper (optional convenience)
	     * ======================================================= */

	    private static WebElement Clickable(WebDriver driver, By locator, long timeoutSec) {
	        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSec)).until(ExpectedConditions.elementToBeClickable(locator));
	    }

	    /* =======================================================
	     * Demo Glue — mimic the code you posted
	     * ======================================================= */

	    /**
	     * Example: replicate your try/catch snippet but safer.
	     * @param driver WebDriver
	     * @param mobno raw mobile string (may include +91, spaces, etc.)
	     */
	    private static void demoEnterMobile(WebDriver driver, String mobno) {
	        try {
	            WebElement mobileNo = findInputByNthTextType(driver, 17); // TODO replace with stable locator
	            enterMobileFormattedJS(driver, mobileNo, mobno); // sets (+91)xxx-xxx-xxxx & fires events
	            System.out.println("Entered mobile number (formatted): " + mobileNo.getAttribute("value"));
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Failed to enter mobile number: " + mobno);
	        }
	    }
	}


