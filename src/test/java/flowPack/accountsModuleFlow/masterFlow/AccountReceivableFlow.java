package flowPack.accountsModuleFlow.masterFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.LoginFlow;
import pageObjects.accounts.master.AccountReceivablePage;
import pageObjects.accounts.master.CreditNotePage;
import utils.PropertyReader;
import utils.WaitHelper;

public class AccountReceivableFlow {
	WebDriver driver;
	AccountReceivablePage accountReceivablePage;
	LoginFlow loginFlow;
	PropertyReader propReader;
	private static final Logger logger = LogManager.getLogger(AccountReceivableFlow.class);

		public AccountReceivableFlow(WebDriver driver) {
			this.driver=driver;	
			loginFlow= new LoginFlow(driver);
			accountReceivablePage = new AccountReceivablePage(driver);
			propReader =new PropertyReader("accountsModule/AccountReceivableTestData.properties");
	    }
			
		public void accountReceivableFlow() {
			executeLogin();			
			accountReceivablePage.clickAccountModule();
			accountReceivablePage.clickVoucherLink();
			accountReceivablePage.clickAccountRecLink();
			accountReceivablePage.clickCreateNewButton();		
			accountReceivablePage.selectAccount(propReader.getProperty("accCodeDropValue"));
			accountReceivablePage.enterVoucherAmount(propReader.getProperty("voucherInputLable"), propReader.getProperty("voucherInputIdPart"), propReader.getProperty("voucherAmount"));
			accountReceivablePage.enterNarration(propReader.getProperty("narrationInputLable"), propReader.getProperty("narrationInputIdPart"), propReader.getProperty("narrationValue"));
			accountReceivablePage.enterBillNo(propReader.getProperty("billNoInputLable"), propReader.getProperty("billNoInputIdPart"), propReader.getProperty("billNoValue"));
			accountReceivablePage.selectTxnCode(propReader.getProperty("txnCodeValue"));
			accountReceivablePage.selectDebitToAccount(propReader.getProperty("debitToAccount"));
			//accountReceivablePage.clickSubmitButton();
		}
		
		public void executeLogin() {
			loginFlow.loginFlowCheck();
			WaitHelper.waitForInvisibilityOfElementLocated(driver,accountReceivablePage.getDotSpinner(),20);
		}
}
