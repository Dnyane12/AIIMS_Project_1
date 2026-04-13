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

public class BankReceiptPage {
	WebDriver driver;
	private static final Logger logger = LogManager.getLogger(BankReceiptPage.class);	
		
		public BankReceiptPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	    }
		
		
		By dotSpinner= By.xpath("/html/body/app-root/div/div/div/div/div");
		
		@FindBy(xpath="//igx-card[contains(@id,'igx-card')]//h3[normalize-space(text())='Accounts']")
		private WebElement accModule;
		
		//@FindBy(xpath="//igx-nav-drawer[contains(@id,'project-menu')]//span[normalize-space(text())='Voucher']")
		//private WebElement voucherLink;
		
		@FindBy(xpath="(//igx-nav-drawer[contains(@id,'project-menu')]//span[contains(normalize-space(.),'Bank Reciept')])[1]")
		private WebElement bankReceiptLink;
		
		@FindBy(xpath="(//div[contains(@class,'display-table')]//button[contains(normalize-space(.),'Create New')])[1]")
		private WebElement createNewBtn;
		
		@FindBy(xpath="(//label[contains(@id,'igx-label') and normalize-space(text())='Series']/following::input[@role='combobox'])[1]")
		private WebElement seriesDropdown;
		
		@FindBy(xpath="(//label[contains(@id,'igx-label') and normalize-space(text())='Account']/following::input[@role='combobox'])[1]")
		private WebElement accountDrop;
		
		@FindBy(xpath="//label[normalize-space(text())='Voucher Amount' and contains(@id,'igx-label')]/following::input[contains(@id,'l_voud_b1_voucher_amount')]")
		private WebElement voucherAmount;
		
		@FindBy(xpath="(//label[contains(@id,'igx-label') and normalize-space(text())='Txn Code']/following::input[@role='combobox'])[1]")
		private WebElement txnCodeDrop;
		
		@FindBy(xpath="(//label[contains(@id,'igx-label') and normalize-space(text())='Payment Mode']/following::input[@role='combobox'])[1]")
		private WebElement paymentMode;
		
		@FindBy(xpath="(//label[normalize-space(text())='Cheque No' and contains(@id,'igx-label')]/following::input[contains(@id,'l_voud_cheque_block')])[1]")
		private WebElement checkNoField;
				
		@FindBy(xpath="(//div[@id='l_voud_b2_account_list-width-selector']//label[contains(@id,'igx-label') and normalize-space(text())='Account']/following::input[@role='combobox'])[1]")
		private WebElement debitToAccountDrop;
		
		@FindBy(xpath="//button[contains(@id,'l_action_save_btn-width-selector') and normalize-space(text())='Submit']")
		private WebElement submitButton;
		
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
		
		public void clickBankRecieptLink() {
			WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 20);
			WaitHelper.waitForClickable(driver,bankReceiptLink, 20);
			bankReceiptLink.click();
		}
		public void clickCreateNewButton() {
			WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 20);
			WaitHelper.waitForClickable(driver,createNewBtn, 30);
			createNewBtn.click();
		}
		
		public void selectSeries(String seriesValue) {
			WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,20);
		CommonUtilForDropdown.selectFromIgxDropdown(driver, seriesDropdown, seriesValue);
		}
		
		
		public void selectAccount(String accCodeDropValue) {
			WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,20);
		CommonUtilForDropdown.selectFromIgxDropdown(driver, accountDrop, accCodeDropValue);
		}
				
		public void enterVoucherAmount(String voucherInputLable,String voucherInputIdPart,String voucherAmount) {
			WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,20);
			InputUtility.enterValueByLabel(driver, voucherInputLable, voucherInputIdPart, voucherAmount);
		}
		
		public void enterNarration(String narrationInputLable,String narrationInputIdPart,String narrationValue) {
			WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,20);
			InputUtility.enterValueByLabel(driver, narrationInputLable, narrationInputIdPart, narrationValue);
		}
		
		public void selectTxnCode(String txnCodeValue) {	
			WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,30);
			CommonUtilForDropdown.selectFromIgxDropdown(driver, txnCodeDrop, txnCodeValue);
		}
		
		public void selectPaymentMode(String paymentModeValue) {	
			CommonUtilForDropdown.selectFromIgxDropdown(driver, paymentMode, paymentModeValue);
		}
		
		public void enterCheckNo(String checkNoLabel,String checkNoInputIdPart,String checkNoValue) {
			WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner,20);
			WaitHelper.waitForVisible(driver, checkNoField, 20);
			InputUtility.enterValueByLabel(driver, checkNoLabel, checkNoInputIdPart, checkNoValue);
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

//		public By getVoucherLink() {
//			return voucherLink;
//		}

		public WebElement getBankReceiptLink() {
			return bankReceiptLink;
		}

		public WebElement getCreateNewBtn() {
			return createNewBtn;
		}

		public WebElement getAccountDrop() {
			return accountDrop;
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
}
