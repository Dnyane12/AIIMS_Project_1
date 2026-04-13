package pageObjects.production;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;

public class ProcessTransactionPage {
WebDriver driver;


public ProcessTransactionPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "(//igx-nav-drawer[@id='project-menu']//span[contains(normalize-space(.),'Process Transaction')])[1]")
private WebElement processTransMenu;

@FindBy(xpath = "//label[normalize-space(.)='From Date']/ancestor::igx-date-picker//input[@role='combobox']")
private WebElement fromDate;

@FindBy(xpath = "//igx-card[contains(@id,'igx-card')]//div[@class='justify-start']//h3[contains(normalize-space(text()),'Production')]")
WebElement productionMenu;

By transactionMenu =By.xpath("//div[@class='mb-50']//span[@class='fs-13 menu-l1-name'][normalize-space()='Transaction']");

By dotSpinner = By.xpath("//div[@class='dot-spinner']");

@FindBy(xpath = "(//button[@role='button']//span[contains(normalize-space(.),'Book')])[1]")
private WebElement bookButton;

@FindBy(xpath = "(//div[contains(@id,'_title') and contains(normalize-space(.),'Confirmation')])[2]")
private WebElement expConfPopup;

@FindBy(xpath = "(//div[contains(@class, 'igx-dialog__window-actions')]//button[contains(normalize-space(.),'No') and contains(@class,'igx-button')])[1]")
private WebElement expConfNoButton;

@FindBy(xpath = "(//igx-grid-cell[@id='l_process_transaction_input_igx_grid_0_3']//div[contains(@class,'igx-input-group__bundle-main')]//input[@role='combobox'])[1]")
private WebElement locationInputDrop;

@FindBy(xpath = "(//igx-simple-combo[@id='l_grid_prio_store_sub_loc_stor1l_process_transaction_input']//div[contains(@class,'igx-input-group__bundle-main')]//input[@role='combobox'])[1]")
private WebElement locationInputDrop2;

@FindBy(xpath = "//button[normalize-space(text())='Set BOM Qty.' and contains(@id,'l_sorh_place_of_supply-width-selector')]")
private WebElement setBomQtyBtn;

@FindBy(xpath = "(//label[normalize-space(text())='Shift']/following::input[@role='combobox'])[1]")
private WebElement shiftDropdown;

@FindBy(xpath = "//igx-tab-header[contains(@id,'igx-tabs-header')]//app-g-label[normalize-space(text())='Process Output']")
private WebElement processOutputTab;

//process output tab elements
@FindBy(xpath = "//igx-combo[@id='l_grid_prio_lotbatch0l_process_transaction_output']//div[contains(@class,'igx-input-group__bundle-main')]//input[@role='combobox']")
private WebElement batchDrop;


@FindBy(xpath = "//div[contains(@class,'igx-input-group__bundle-main')]//input[@role='searchbox' and @name='searchInput']")
private WebElement batchSearchInput;


@FindBy(xpath = "(//igx-simple-combo[contains(@id,'l_grid_prio_store_sub_loc_stor0l_process_transaction_output')]//div[contains(@class,'igx-input-group__bundle-main')]//input[@role='combobox'])[1]")
private WebElement locaForOutput;

@FindBy(xpath = "//div//input[contains(@id,'l_grid_prio_primary_qty0l_process_transaction_output')]")
private WebElement outputQtyField;

@FindBy(xpath = "//div//input[contains(@id,'l_grid_prio_fat0l_process_transaction_output')]")
private WebElement OutputFatField;

@FindBy(xpath = "//div//input[contains(@id,'l_grid_prio_snf0l_process_transaction_output')]")
private WebElement OutputSNFField;

@FindBy(xpath = "//button[contains(@id,'l_action_save_btn-width-selector') and normalize-space(text())='Submit']")
private WebElement submitButton;







//Acions
public void clickProcessTransMenu() {
	WaitHelper.waitForInvisibilityOfElementLocated(driver,dotSpinner, 10);
	WaitHelper.waitForClickable(driver, processTransMenu, 20);
	processTransMenu.click();
}



public void clickProductionMenu() {
    WaitHelper.waitForClickable(driver, productionMenu, 10);
    productionMenu.click();
}

public void clickTransactionMenu() {
    WaitHelper.waitForRefreshAndClick(driver, transactionMenu, 10);
}


public void clickBookButton() {
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 30);
	WaitHelper.waitForClickable(driver, bookButton, 30);
	bookButton.click();
}


public void clickConfOkBtn() {
	WaitHelper.waitForVisible(driver, expConfPopup, 20);
	WaitHelper.waitForClickable(driver, expConfNoButton, 20);
	expConfNoButton.click();
}

public void selectLocation(String location1,String location2,String value) {
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 30);
	WaitHelper.waitForClickable(driver, locationInputDrop, 30);
	locationInputDrop.click();
	locationInputDrop.sendKeys(location1);
		
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 20);
	WaitHelper.waitForClickable(driver, locationInputDrop2, 20);
	locationInputDrop2.click();
	locationInputDrop2.sendKeys(location2);
		
	String xpath = String.format(
	        "//div//span[normalize-space(.)='%s']",
	        value
	    );
	 WebElement opt=driver.findElement(By.xpath(xpath));
	
	//locationInputDrop.sendKeys(org.openqa.selenium.Keys.ENTER);
}

public void clickSetBomQtyBtn() {
	WaitHelper.waitForClickable(driver, setBomQtyBtn, 20);
	setBomQtyBtn.click();
}



public void selectShift(String shift) {
	WaitHelper.waitForClickable(driver, shiftDropdown, 20);
	shiftDropdown.click();
	shiftDropdown.sendKeys(shift);
}


public void clickProcessOutputTab() {
	WaitHelper.waitForClickable(driver, processOutputTab, 20);
	processOutputTab.click();
}



public void selectBatch(String batch) {
	WaitHelper.waitForClickable(driver, batchDrop, 30);
	batchDrop.click();
	
	WaitHelper.waitForClickable(driver, batchSearchInput, 20);
	batchSearchInput.click();
	batchSearchInput.sendKeys(batch);
		
	String xpath = String.format("//igx-combo-item[@aria-label='%s']//span[contains(@class,'igx-checkbox__composite')]",batch);
    WebElement checkbox = driver.findElement(By.xpath(xpath));
    
    WaitHelper.waitForVisible(driver, checkbox, 20);
    WaitHelper.waitForClickable(driver, checkbox, 20);
    checkbox.click();
}

public void selectLocForOutput(String locForOutput) {
	WaitHelper.waitForClickable(driver, locaForOutput, 20);
	locaForOutput.click();
	locaForOutput.sendKeys(locForOutput);   
}


public void enterOutputQty(String outputQty) {
	WaitHelper.waitForClickable(driver, outputQtyField, 20);
	outputQtyField.click();
	outputQtyField.sendKeys(outputQty);
}

public void enterOutputFat(String outputFat) {
	WaitHelper.waitForClickable(driver, OutputFatField, 20);
	OutputFatField.click();
	OutputFatField.sendKeys(outputFat);
}

public void enterOutputSNF(String outputSNF) {
	WaitHelper.waitForClickable(driver, OutputSNFField, 20);
	OutputSNFField.click();
	OutputSNFField.sendKeys(outputSNF);
}

public void  clickSubmitButton() {
	WaitHelper.waitForClickable(driver, submitButton, 20);
	submitButton.click();
}








//Getters
public WebElement getProcessTransMenu() {
	return processTransMenu;

}

public By getDotSpinner() {
	return dotSpinner;
}





}

