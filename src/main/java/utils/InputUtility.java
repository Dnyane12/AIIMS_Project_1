package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class InputUtility {
	    /**
	     * Enters value into an input field located using its label text.
	     * Copy-paste ready single-line XPath for DevTools is included below.
	     *
	     * Example XPath (replace 'Party Name' with your label):
	     * (//label[normalize-space(text())='Party Name']/following::div[contains(@class,'igx-input-group__bundle')]//input[contains(@class,'igx-input-group__input')])[1]
	     */
	public static void enterValueByLabel(WebDriver driver, String labelText, String inputValue) {
	        String xpath = "(//label[normalize-space(text())='" + labelText + "']/following::div[contains(@class,'igx-input-group__bundle')]//input[contains(@class,'igx-input-group__input')])[1]";
	        try {
	            WebElement input = driver.findElement(By.xpath(xpath));
	            input.clear();
	            input.sendKeys(inputValue);
	            System.out.println("✅ Entered value for label: " + labelText);
	        } catch (Exception e) {
	            System.out.println("❌ Failed to enter value for label: " + labelText);
	            e.printStackTrace();
	        }
	    }
	}

