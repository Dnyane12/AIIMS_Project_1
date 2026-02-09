package pageObjects.inventory.transaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;

public class PRNPrintingRepPage {
WebDriver driver;
	
public PRNPrintingRepPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


//Locators
By reportLink= By.xpath("//igx-nav-drawer//span[normalize-space(text())='Report' and contains(@class,'fs-13')]");

@FindBy(xpath="//igx-nav-drawer//span[contains(normalize-space(.),'PRN Printing') and contains(@class,'fs-12')]")
private WebElement prnRepLink;

By dotSpinner =By.xpath("/html/body/app-root/div/div/div/div/div");

@FindBy(xpath="//button[contains(normalize-space(.),'View') and contains(@class,'mt-3')]")
private WebElement viewButton;

@FindBy(xpath="//input[contains(@class,'p-0') and contains(@placeholder,'PRN Printing Search')]")
private WebElement searchBar;

@FindBy(xpath="(//label[text()='From Date']/following::input[contains(@class,'igx-date-picker__input-date') and @role='combobox'])[1]")
private WebElement fromDate;
		
@FindBy(xpath="//igx-icon[text()='print' and contains(@class,'material-icons')]")
private WebElement printIcon;






//Action Methods

public void clickReportLink(){
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	WaitHelper.waitForRefreshAndClick(driver, reportLink, 10);
}


public void clickPRNRepLink(){	
	WaitHelper.waitForClickable(driver, prnRepLink, 10);
	prnRepLink.click();
}

public void clickViewButton(){
	WaitHelper.waitForClickable(driver, viewButton, 10);
	viewButton.click();
}

public void serchPRNNoInSerchBar(String prnNo) {
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	WaitHelper.waitForClickable(driver, searchBar, 10);
	searchBar.click();
	searchBar.sendKeys(prnNo);
	
}

public void enterFromDate(String fromDateValue) {
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	WaitHelper.waitForClickable(driver, fromDate, 10);
	fromDate.click();
	fromDate.sendKeys(fromDateValue);
}

public void clickPrintIcon() {
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	WaitHelper.waitForClickable(driver, printIcon, 10);
	printIcon.click();	
}

}
