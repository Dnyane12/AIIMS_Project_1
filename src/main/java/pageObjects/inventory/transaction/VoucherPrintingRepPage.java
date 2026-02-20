package pageObjects.inventory.transaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;

public class VoucherPrintingRepPage {
WebDriver driver;

	
public VoucherPrintingRepPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}



By reportLink = By.xpath("(//span[contains(@class,'fs-13') and normalize-space(text())='Report'])[1]");

@FindBy(xpath="(//span[contains(@class,'fs-12') and contains(normalize-space(text()),'Voucher Printing')])[1]")
private WebElement voucherPrintingLink;

By dotSpinner = By.xpath("/html/body/app-root/div/div/div/div/div");

//(//div[contains(@class,'display-cell')])[7]
@FindBy(xpath="(//igx-display-container[contains(@class,'igx-display-container')])[1]")
private WebElement gridHeaders;

@FindBy(xpath="(//label[normalize-space(text())='Document Type' and @class='igx-input-group__label']/following::input[@class='igx-input-group__input'])[1]")
private WebElement DocTypeDrop;


@FindBy(xpath="//span[normalize-space(text())='Account Payable']")
private WebElement DocTypeOptField;


@FindBy(xpath="(//label[normalize-space(text())='From Date' and @class='igx-input-group__label']/following::input[contains(@class,'igx-date-picker__input-date')])[1]")
private WebElement fromDate;


@FindBy(xpath="//button[normalize-space(text())='View' and contains(@class,'mt-3')]")
private WebElement viewButton;


@FindBy(xpath="//input[@type='text' and contains(@placeholder,'Voucher Printing Search')]")
private WebElement voucherPrintingSearchBar;



@FindBy(xpath="//igx-icon[normalize-space(text())='print' and contains(@class,'material-icons')]")
private WebElement printButtonIcon;









//Action Methods
public void clickReportLink() {
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 20);
	WaitHelper.waitForClickable(driver, reportLink, 20);
	WaitHelper.waitForRefreshAndClick(driver, reportLink, 10);
}

public void clickVoucherPrintingLink() {
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	WaitHelper.waitForClickable(driver, voucherPrintingLink, 10);
	voucherPrintingLink.click();
}

public void selectDocType(String docTypeOpt) {
	WaitHelper.waitForClickable(driver, DocTypeDrop, 20);
	DocTypeDrop.click();
	DocTypeDrop.sendKeys(docTypeOpt);
	
	WaitHelper.waitForClickable(driver, DocTypeOptField, 10);
	DocTypeOptField.click();
	
}

public void selectFromDate(String fromDateValue) {
	WaitHelper.waitForClickable(driver, fromDate, 10);
	fromDate.click();
	fromDate.sendKeys(fromDateValue);
}


public void clickViewButton() {
	WaitHelper.waitForClickable(driver, viewButton, 10);
	viewButton.click();
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
}

public void searchVoucherNo(String voucherNo) {
	//WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	WaitHelper.waitForVisible(driver,gridHeaders, 10);
	WaitHelper.waitForVisible(driver, voucherPrintingSearchBar, 20);
	WaitHelper.scrollIntoView(driver, voucherPrintingSearchBar);
	voucherPrintingSearchBar.clear();
	voucherPrintingSearchBar.sendKeys(voucherNo);
}


public void clickPrintButtonIcon() throws InterruptedException {
	//WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	Thread.sleep(3000);
	WaitHelper.waitForClickable(driver, printButtonIcon, 50);
	WaitHelper.scrollIntoView(driver, printButtonIcon);
	printButtonIcon.click();
}







//Getters and Setters
public By getReportLink() {
	return reportLink;
}

public WebElement getVoucherPrintingLink() {
	return voucherPrintingLink;
}

public By getDotSpinner() {
	return dotSpinner;
}

public WebElement getDocTypeDrop() {
	return DocTypeDrop;
}

public WebElement getDocTypeOptField() {
	return DocTypeOptField;
}

public WebElement getFromDate() {
	return fromDate;
}

public WebElement getViewButton() {
	return viewButton;
}

public WebElement getVoucherPrintingSearchBar() {
	return voucherPrintingSearchBar;
}

public WebElement getPrintButtonIcon() {
	return printButtonIcon;
}















}
