package pageObjects.sales.reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitHelper;

public class SaleOrderPrintingPage {
WebDriver driver;

public SaleOrderPrintingPage(WebDriver driver) {
	this.driver=driver;
}

@FindBy(xpath="//div[@class='mb-50']//span[normalize-space(text())='Report' and contains(@class,'fs-13')]")
private WebElement reportLink;
	
@FindBy(xpath="//span[contains(@class,'fs-12') and contains(text(),'Sale Order Printing')]")
private WebElement saleOrderPrintingLink;

@FindBy(xpath="//button[contains(@id,'l_slih_view-width-selector') and contains(text(),'View')]")
private WebElement viewButton;

@FindBy(xpath="//igx-icon[contains(@class,'material-icons')]/following::igx-icon[normalize-space(text())='today']")
private WebElement dateFilter;

@FindBy(xpath="//button[@id='l_action_print_btn-width-selector' and normalize-space(text())='Print']")
private WebElement printBtn;

@FindBy(xpath="//button[@id='l_action_reset_btn-width-selector' and normalize-space(text())='Reset']")
private WebElement resetBtn;


public void clickReportLink() {
	WaitHelper.waitForClickable(driver, reportLink, 10);
	reportLink.click();	
}

public void clickSaleOrderPrintLink() {
	WaitHelper.waitForClickable(driver, saleOrderPrintingLink, 10);
	saleOrderPrintingLink.click();
}

public void clickViewButton() {
	WaitHelper.waitForClickable(driver, viewButton, 10);
	viewButton.click();
}

public void clickDateFilter() {
	WaitHelper.waitForClickable(driver, dateFilter, 10);
	dateFilter.click();
}

public void clickPrintBtn() {
	WaitHelper.waitForClickable(driver, printBtn, 10);
	printBtn.click();
}

public void clickResetBtn() {
	WaitHelper.waitForClickable(driver, resetBtn, 10);
	resetBtn.click();
}

public WebElement getDateFilter() {
	return dateFilter;
}

public void setDateFilter(WebElement dateFilter) {
	this.dateFilter = dateFilter;
}

public WebElement getReportLink() {
	return reportLink;
}

public WebElement getSaleOrderPrintingLink() {
	return saleOrderPrintingLink;
}

public WebElement getViewButton() {
	return viewButton;
}

public WebElement getPrintBtn() {
	return printBtn;
}

public WebElement getResetBtn() {
	return resetBtn;
}




}
