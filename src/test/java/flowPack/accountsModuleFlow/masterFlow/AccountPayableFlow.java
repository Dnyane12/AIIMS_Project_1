package flowPack.accountsModuleFlow.masterFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.LoginFlow;
import pageObjects.accounts.master.AccountPayablePage;
import pageObjects.accounts.master.AccountReceivablePage;
import utils.PropertyReader;
import utils.WaitHelper;

public class AccountPayableFlow {
	WebDriver driver;
	AccountPayablePage accountPayablePage;
	LoginFlow loginFlow;
	PropertyReader propReader;
	private static final Logger logger = LogManager.getLogger(AccountPayableFlow.class);

		public AccountPayableFlow(WebDriver driver) {
			this.driver=driver;	
			loginFlow= new LoginFlow(driver);
			accountPayablePage = new AccountPayablePage(driver);
			propReader =new PropertyReader("accountsModule/AccountPayableTestData.properties");
	    }
			
		public void accountPayableFlow() {
			executeLogin();			
			accountPayablePage.clickAccountModule();
			accountPayablePage.clickVoucherLink();
			accountPayablePage.clickAccountPayLink();
			accountPayablePage.clickCreateNewButton();		
			accountPayablePage.selectAccount(propReader.getProperty("accCodeDropValue"));
			accountPayablePage.enterVoucherAmount(propReader.getProperty("voucherInputLable"), propReader.getProperty("voucherInputIdPart"), propReader.getProperty("voucherAmount"));
			accountPayablePage.enterNarration(propReader.getProperty("narrationInputLable"), propReader.getProperty("narrationInputIdPart"), propReader.getProperty("narrationValue"));
			accountPayablePage.enterBillNo(propReader.getProperty("billNoInputLable"), propReader.getProperty("billNoInputIdPart"), propReader.getProperty("billNoValue"));
			accountPayablePage.selectTxnCode(propReader.getProperty("txnCodeValue"));
			accountPayablePage.selectDebitToAccount(propReader.getProperty("debitToAccount"));
			//accountPayablePage.clickSubmitButton();
		}
		
		public void executeLogin() {
			loginFlow.loginFlowCheck();
			WaitHelper.waitForInvisibilityOfElementLocated(driver,accountPayablePage.getDotSpinner(),20);
		}
}
