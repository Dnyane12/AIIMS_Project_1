package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtilForDropdown {
	private static By SPINNER = By.xpath("//your-spinner-xpath");

    public static void selectFromIgxDropdown(WebDriver driver,
                                             WebElement dropdownElement,
                                             String value) {

        WaitHelper.waitForInvisibilityOfElementLocated(driver, SPINNER, 20);

        WaitHelper.waitForClickable(driver, dropdownElement, 20);
        dropdownElement.click();

        WaitHelper.waitForInvisibilityOfElementLocated(driver, SPINNER, 20);

        dropdownElement.sendKeys(value);

        String xpath = "//span[contains(@class,'igx-drop-down__inner')]//span[contains(normalize-space(text()),'" + value + "')]";

        WebElement option = driver.findElement(By.xpath(xpath));

        WaitHelper.waitForClickable(driver, option, 20);
        option.click();
    }
}
