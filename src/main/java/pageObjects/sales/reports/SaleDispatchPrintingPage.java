package pageObjects.sales.reports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitHelper;
public class SaleDispatchPrintingPage {
	WebDriver driver;

	public SaleDispatchPrintingPage(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(xpath="//div[@class='mb-50']//span[normalize-space(text())='Report' and contains(@class,'fs-13')]")
	private WebElement reportLink;
		
	@FindBy(xpath="//div[contains(@class,'ml-3')]//span[contains(text(),'Sale Dispatch Printing') and contains(@class,'fs-12')]")
	private WebElement saleDispatchPrintingLink;

	@FindBy(xpath="//button[normalize-space(text())='View' and @id='l_sldh_view-width-selector']")
	private WebElement viewButton;

	@FindBy(xpath="(//igx-icon[@title='Change Date' and contains(@class,'material-icons')])[1]")
	private WebElement fromDateFilter;
	
	@FindBy(xpath="(//igx-icon[@title='Change Date' and contains(@class,'material-icons')])[2]")
	private WebElement ToDateFilter;

	@FindBy(xpath="//button[@id='l_action_print_btn-width-selector' and normalize-space(text())='Print']")
	private WebElement printBtn;

	@FindBy(xpath="//button[@id='l_action_reset_btn-width-selector' and normalize-space(text())='Reset']")
	private WebElement resetBtn;


	public void clickReportLink() {
		 WaitHelper.waitForClickable(driver, reportLink, 10);
		 reportLink.click();	
	}

	public void clickSaleDispatchPrintLink() {
		 WaitHelper.waitForClickable(driver, saleDispatchPrintingLink, 10);
		 saleDispatchPrintingLink.click();	
	}

	public void clickViewButton() {
		 WaitHelper.waitForClickable(driver, viewButton, 10);
		 viewButton.click();
	}

	public void clickFromDateFilter() {
		 WaitHelper.waitForClickable(driver, fromDateFilter, 10);
		 fromDateFilter.click();	
	}

	public void clickToDateFilter() {
		 WaitHelper.waitForClickable(driver, ToDateFilter, 10);
		 ToDateFilter.click();
	}
	
	public void clickPrintBtn() {
		 WaitHelper.waitForClickable(driver, resetBtn, 10);
		 resetBtn.click();
	}

	public void clickResetBtn() {
		 WaitHelper.waitForClickable(driver, resetBtn, 10);
		 resetBtn.click();
		
	}

	
	
	//Getters and Setters
	public WebElement getReportLink() {
		return reportLink;
	}

	public WebElement getSaleDispatchPrintingLink() {
		return saleDispatchPrintingLink;
	}

	public WebElement getViewButton() {
		return viewButton;
	}

	public WebElement getFromDateFilter() {
		return fromDateFilter;
	}

	public WebElement getToDateFilter() {
		return ToDateFilter;
	}

	public WebElement getPrintBtn() {
		return printBtn;
	}

	public WebElement getResetBtn() {
		return resetBtn;
	}
	

	
}

