package pageObjects.accounts.master;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtilForDropdown;
import utils.InputUtility;
import utils.WaitHelper;

public class JournalVoucherMultiLinePage {
WebDriver driver;
private static final Logger logger = LogManager.getLogger(JournalVoucherMultiLinePage.class);	


	public JournalVoucherMultiLinePage(WebDriver driver){
	this.driver= driver;
	PageFactory.initElements(driver, this);
    }
	


	By dotSpinner= By.xpath("/html/body/app-root/div/div/div/div/div");
	
	@FindBy(xpath="//igx-card[contains(@id,'igx-card')]//h3[normalize-space(text())='Accounts']")
	private WebElement accModule;
	
	@FindBy(xpath="//igx-nav-drawer[contains(@id,'project-menu')]//span[normalize-space(text())='Voucher']")
	private WebElement voucherLink;
	
	@FindBy(xpath="(//igx-nav-drawer[contains(@id,'project-menu')]//span[contains(normalize-space(.),'Account Payable')])[1]")
	private WebElement accountPayPageLink;
	
	@FindBy(xpath="(//div[contains(@class,'display-table')]//button[contains(normalize-space(.),'Create New')])[1]")
	private WebElement createNewBtn;
				
	@FindBy(xpath="//label[normalize-space(text())='Voucher Amount' and contains(@id,'igx-label')]/following::input[contains(@id,'l_voud_b1_voucher_amount')]")
	private WebElement voucherAmount;
	
	@FindBy(xpath="(//label[contains(@id,'igx-label') and normalize-space(text())='Txn Code']/following::input[@role='combobox'])[1]")
	private WebElement txnCodeDrop;
					
	@FindBy(xpath="(//div[@id='l_voud_b2_account_list-width-selector']//label[contains(@id,'igx-label') and normalize-space(text())='Account']/following::input[@role='combobox'])[1]")
	private WebElement debitToAccountDrop;
	
	@FindBy(xpath="//button[contains(@id,'l_action_save_btn-width-selector') and normalize-space(text())='Submit']")
	private WebElement submitButton;
	
	@FindBy(xpath="(//label[contains(@id,'igx-label') and normalize-space(text())='Account']/following::input[@role='combobox'])[1]")
	private WebElement accountDrop;
	
	@FindBy(xpath="//igx-snackbar//div[contains(normalize-space(text()),'Voucher Created successfully')]")
	private WebElement succMsg;
	
	
	
	
	
	
	
	
	//action Methods 
	
	public void clickAccountModule() {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 20);
		WaitHelper.waitForClickable(driver, accModule, 20);
		accModule.click();
	}
	
	public void clickVoucherLink() {
		//WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 20);
		//voucherLink.click();
	
		By voucher = By.xpath("//igx-nav-drawer[contains(@id,'project-menu')]//span[normalize-space(text())='Voucher']");
		WaitHelper.waitForRefreshAndClick(driver, voucher, 20);
	}	
	
	public void clickAccountPayLink() {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 20);
		WaitHelper.waitForClickable(driver,accountPayPageLink, 20);
		accountPayPageLink.click();
	}
	public void clickCreateNewButton() {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 20);
		WaitHelper.waitForClickable(driver,createNewBtn, 30);
		createNewBtn.click();
	}
	
	public void selectAccount(String accCodeDropValue) {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,20);
	CommonUtilForDropdown.selectFromIgxDropdown(driver, accountDrop, accCodeDropValue);
	}
						
	public void enterVoucherAmount(String voucherInputLable,String voucherInputIdPart,String voucherAmount) {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,30);
		InputUtility.enterValueByLabel(driver, voucherInputLable, voucherInputIdPart, voucherAmount);
	}
	
	public void enterNarration(String narrationInputLable,String narrationInputIdPart,String narrationValue) {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,20);
		InputUtility.enterValueByLabel(driver, narrationInputLable, narrationInputIdPart, narrationValue);
	}
	
	public void enterBillNo(String billNoInputLable,String billNoInputIdPart,String billNoValue) {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,20);
		InputUtility.enterValueByLabel(driver, billNoInputLable, billNoInputIdPart, billNoValue);
	}
	
	public void selectTxnCode(String txnCodeValue) {	
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,30);
		CommonUtilForDropdown.selectFromIgxDropdown(driver, txnCodeDrop, txnCodeValue);
	}
	
	public void selectDebitToAccount(String debitToAccount) {	
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,20);
		CommonUtilForDropdown.selectFromIgxDropdown(driver, debitToAccountDrop, debitToAccount);
	}
	
	public void clickSubmitButton() {
		WaitHelper.waitForClickable(driver, submitButton, 20);
		submitButton.click();
	}


	public String getSuccMssage() {
		WaitHelper.waitForVisible(driver,succMsg, 20);
		String actualMsg= succMsg.getText();					
		
		logger.info("Actual Message: " + actualMsg);
		return actualMsg;
	}
	
	
	
	
	
	//Getters and Setters
	
	public By getDotSpinner() {
		return dotSpinner;
	}

	public WebElement getAccModule() {
		return accModule;
	}

//	public By getVoucherLink() {
//		return voucherLink;
//	}

	public WebElement getAccountRecPageLink() {
		return accountPayPageLink;
	}

	public WebElement getCreateNewBtn() {
		return createNewBtn;
	}

	public WebElement getVoucherAmount() {
		return voucherAmount;
	}

	public WebElement getTxnCodeDrop() {
		return txnCodeDrop;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getDebitToAccountDrop() {
		return debitToAccountDrop;
	}
	
}
