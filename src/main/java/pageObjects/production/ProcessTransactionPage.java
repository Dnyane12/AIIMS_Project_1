package pageObjects.production;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitHelper;

public class ProcessTransactionPage {
WebDriver driver;


public ProcessTransactionPage(WebDriver driver) {
	this.driver = driver;
}

@FindBy(xpath = "//span[text()='Process Transaction']")
private WebElement processTransMenu;


@FindBy(xpath = "//label[normalize-space(.)='From Date']   /ancestor::igx-date-picker   //input[@role='combobox']")
private WebElement fromDate;







//Acions
public void clickProcessTransMenu() {
	WaitHelper.waitForClickable(driver, processTransMenu, 10);
	processTransMenu.click();
}







public WebElement getProcessTransMenu() {
	return processTransMenu;

}
}

