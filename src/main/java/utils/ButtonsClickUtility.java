package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.SetUp;

//import integrationFlowPack.SalesModuleFlow.setupFlow.SetUp;

public class ButtonsClickUtility extends SetUp{
	public void clickButtonByLabel(String buttonText) {
	    String xpath = "//button[contains(@id,'l_action') and normalize-space(text())='" + buttonText + "']";
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	    button.click();  // Or use JS if needed
	}

}
