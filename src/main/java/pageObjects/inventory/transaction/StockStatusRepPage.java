package pageObjects.inventory.transaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;

public class StockStatusRepPage {
WebDriver driver;
	
	public StockStatusRepPage(WebDriver driver) {
		this.driver= driver;	
		PageFactory.initElements(driver,this);
	}
		
	By reportLink =By.xpath("//igx-nav-drawer//span[normalize-space(text())='Report' and contains(@class,'fs-13')]");
	
	@FindBy(xpath="//div[@class='mb-50']//span[contains(normalize-space(.),'Stock Status Printing') and contains(@class,'fs-12')]")	
	private WebElement StockStaRepLink;
	
	By dotSpinner = By.xpath("//div[@class='dot-spinner']");

	@FindBy(xpath="//button[contains(normalize-space(.),'View') and contains(@class,'mt-3')]")
	private WebElement viewButton;

	@FindBy(xpath="//input[contains(@class,'p-0') and contains(@placeholder,'Po Printing Search')]")
	private WebElement searchBar;

	@FindBy(xpath="(//label[text()='From Date']/following::input[contains(@class,'igx-date-picker__input-date') and @role='combobox'])[1]")
	private WebElement fromDate;
			
	@FindBy(xpath="//igx-icon[text()='print' and contains(@class,'material-icons')]")
	private WebElement printIcon;

    By itemTypeDrop= By.xpath("(//label[contains(@id,'igx-label') and contains(text(),'Item Type')]/following::input[contains(@class,'igx-input-group__input')])[1]");
    
    @FindBy(xpath="(//label[contains(@id,'igx-label') and contains(text(),'Item Sub Type')]/following::input[contains(@class,'igx-input-group__input')])[1]")
    private WebElement itemSubTypeDrop;
    

    @FindBy(xpath="//span[normalize-space(text())='FINISHED GOODS']")
    private WebElement itemTypeDropOptField;
    
    @FindBy(xpath="//span[normalize-space(text())='MILK']")
    private WebElement itemSubTypeDropOptField;
    
    
    
    
    
    
    

	//Action Methods
	public void clickReportLink(){
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForRefreshAndClick(driver, reportLink, 10);
	}

	public void clickStockStaRepLink() {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForClickable(driver, StockStaRepLink, 10);
		StockStaRepLink.click();
	}

	public void enterFromDate(String fromDateValue) {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForClickable(driver, fromDate, 10);
		fromDate.click();
		fromDate.sendKeys(fromDateValue);
	}
	
	
	public void selectItemType(String itemType) {
		try {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 40);
		WaitHelper.waitForRefreshAndClick(driver, itemTypeDrop, 30);
		driver.findElement(itemTypeDrop).sendKeys(itemType);
		
		WaitHelper.waitForClickable(driver, itemTypeDropOptField, 30);
		itemTypeDropOptField.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void selectItemSubType(String itemSubType) {
		WaitHelper.waitForClickable(driver, itemSubTypeDrop, 20);
		itemSubTypeDrop.click();
		itemSubTypeDrop.sendKeys(itemSubType);
		
		WaitHelper.waitForClickable(driver, itemSubTypeDropOptField, 10);
		itemSubTypeDropOptField.click();
	}
	
	
	public void clickViewButton(){
		WaitHelper.waitForClickable(driver, viewButton, 10);
		viewButton.click();
	}

	public void serchItemNameInSerchBar(String itemName) {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForClickable(driver, searchBar, 10);
		searchBar.click();
		searchBar.sendKeys(itemName);	
	}

	
	public void clickPrintIcon() {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForClickable(driver, printIcon, 10);
		printIcon.click();	
	}
		


	//Getters and Setters
}
