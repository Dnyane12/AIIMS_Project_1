package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptScrollUtility {

	public static void scrollElementRight(WebDriver driver, WebElement scrollable, int pixels) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollLeft += arguments[1];", scrollable, pixels);
	}

}
