package flowPack.accountsModuleFlow.masterFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.LoginFlow;
import pageObjects.accounts.master.BankReceiptPage;
import pageObjects.accounts.master.CashPaymentPage;
import utils.PropertyReader;
import utils.WaitHelper;

public class CashPaymentFlow {
	WebDriver driver;
	CashPaymentPage cashPaymentPage;
	LoginFlow loginFlow;
	PropertyReader propReader;
	private static final Logger logger = LogManager.getLogger(BankReceiptFlow.class);

		public CashPaymentFlow(WebDriver driver) {
			this.driver=driver;	
			loginFlow= new LoginFlow(driver);
			cashPaymentPage = new CashPaymentPage(driver);
			propReader =new PropertyReader("accountsModule/CashPaymentTestData.properties");
	    }
			
		public void cashPaymentFlow() {
			executeLogin();			
			cashPaymentPage.clickAccountModule();
			cashPaymentPage.clickVoucherLink();
			cashPaymentPage.clickCashPaymentLink();
			cashPaymentPage.clickCreateNewButton();						
			cashPaymentPage.enterVoucherAmount(propReader.getProperty("voucherInputLable"), propReader.getProperty("voucherInputIdPart"), propReader.getProperty("voucherAmount"));
			cashPaymentPage.enterNarration(propReader.getProperty("narrationInputLable"), propReader.getProperty("narrationInputIdPart"), propReader.getProperty("narrationValue"));
			cashPaymentPage.selectTxnCode(propReader.getProperty("txnCodeValue"));
			cashPaymentPage.selectDebitToAccount(propReader.getProperty("debitToAccount"));
			//bankPaymentPage.clickSubmitButton();
		}
		
		public void executeLogin() {
			loginFlow.loginFlowCheck();
			WaitHelper.waitForInvisibilityOfElementLocated(driver,cashPaymentPage.getDotSpinner(),20);
		}
}
