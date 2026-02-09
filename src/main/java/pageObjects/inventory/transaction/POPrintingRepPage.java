package pageObjects.inventory.transaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;

public class POPrintingRepPage {
	WebDriver driver;
	
	public POPrintingRepPage(WebDriver driver) {
		this.driver= driver;	
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(xpath="//igx-nav-drawer//span[normalize-space(text())='Report' and contains(@class,'fs-13')]")
	private WebElement reportLink;
	@FindBy(xpath="//div[@class='mb-50']//span[contains(normalize-space(.),'Po Printing') and contains(@class,'fs-12')]")	
	private WebElement poRepPrintLink;	
	By dotSpinner = By.xpath("//div[@class='dot-spinner']");

	@FindBy(xpath="//button[contains(normalize-space(.),'View') and contains(@class,'mt-3')]")
	private WebElement viewButton;

	@FindBy(xpath="//input[contains(@class,'p-0') and contains(@placeholder,'Po Printing Search')]")
	private WebElement searchBar;

	@FindBy(xpath="(//label[text()='From Date']/following::input[contains(@class,'igx-date-picker__input-date') and @role='combobox'])[1]")
	private WebElement fromDate;
			
	@FindBy(xpath="//igx-icon[text()='print' and contains(@class,'material-icons')]")
	private WebElement printIcon;


    @FindBy(xpath="(//label[contains(@id,'igx-label') and contains(text(),'PO Type')]/following::input[contains(@class,'igx-input-group__input')])[1]")
    private WebElement poTypeDrop;

    @FindBy(xpath="//igx-combo-item[contains(@id,'igx-drop-down-item')]//span[normalize-space(text())='PO Direct']")
    private WebElement poTypeDropOptField;
    
    
    
    
    
    
    
    

	//Action Methods
	public void clickReportLink(){
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForClickable(driver, reportLink, 10);
		reportLink.click();
	}

	public void clickPoPrintRepLink() {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForClickable(driver, poRepPrintLink, 10);
		poRepPrintLink.click();
	}

	public void enterFromDate(String fromDateValue) {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForClickable(driver, fromDate, 10);
		fromDate.click();
		fromDate.sendKeys(fromDateValue);
	}
	
	
	public void selectPoType(String poType) {
		WaitHelper.waitForClickable(driver, poTypeDrop, 10);
		poTypeDrop.click();
		poTypeDrop.sendKeys(poType);
		
		WaitHelper.waitForClickable(driver, poTypeDropOptField, 10);
		poTypeDropOptField.click();
	}
	
	public void clickViewButton(){
		WaitHelper.waitForClickable(driver, viewButton, 10);
		viewButton.click();
	}

	public void serchGRNNoInSerchBar(String poNo) {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForClickable(driver, searchBar, 10);
		searchBar.click();
		searchBar.sendKeys(poNo);	
	}

	

	public void clickPrintIcon() {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForClickable(driver, printIcon, 10);
		printIcon.click();	
	}
		


	//Getters and Setters
	
	
}
