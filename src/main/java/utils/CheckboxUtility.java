package utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.SetUp;

public class CheckboxUtility extends SetUp{
	public void clickCheckboxByLabel(String labelText) {
	    String xpath = "//span[normalize-space(text())='" + labelText + "']/preceding::div[contains(@class,'igx-checkbox__composite-wrapper')][1]";
	    WebDriverWait  wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	}

}
