package utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilityDuplicate {

	// Select dropdown option by visible text without typing into input
	public static void selectFromComboWithoutSearch(WebDriver driver, String labelText, String optionText) {
		try {
			try {
				WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				shortWait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/div/div")));
			} catch (Exception ignored) {
		    }

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			// Locate dropdown icon next to the label
			String dropdIcon = "//label[normalize-space(text())='" + labelText + "']/following::igx-icon[1]";
			By iconLocator = By.xpath(dropdIcon);

			System.out.println("Trying dropdown for label: " + labelText);

			try {
				WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				shortWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/div/div")));
			 } catch (Exception ignored) {
			}

			wait.until(ExpectedConditions.elementToBeClickable(iconLocator)).click();

			// Faster for overlay with reduced timeout
			WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 3 seconds max

			// Construct dropdown option XPath
			String optionXpath = String.format(
					"//div[contains(@class,'igx-overlay__content')]//igx-combo-item[@role='option']//span[contains(text(),'%s')]",
					optionText.trim());
			System.out.println("ing for dropdown option: " + optionText);

			// Click dropdown option faster
			WebElement option = shortWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(optionXpath)));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

		} catch (TimeoutException e) {
			throw new RuntimeException(
					"Timeout: Could not locate dropdown or option '" + optionText + "' for label '" + labelText + "'.",
					e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Dropdown selection failed for label '" + labelText + "' and option '" + optionText + "'.", e);
		}
	}
}
