package flowPack.accountsModuleFlow.masterFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.LoginFlow;
import pageObjects.accounts.master.CashPaymentPage;
import pageObjects.accounts.master.CashReceiptPage;
import utils.PropertyReader;
import utils.WaitHelper;

public class CashReceiptFlow {
	WebDriver driver;
	CashReceiptPage cashReceiptPage;
	LoginFlow loginFlow;
	PropertyReader propReader;
	private static final Logger logger = LogManager.getLogger(CashReceiptFlow.class);

		public CashReceiptFlow(WebDriver driver) {
			this.driver=driver;	
			loginFlow= new LoginFlow(driver);
			cashReceiptPage = new CashReceiptPage(driver);
			propReader =new PropertyReader("accountsModule/CashReceiptTestData.properties");
	    }
			
		public void cashReceiptFlow() {
			executeLogin();			
			cashReceiptPage.clickAccountModule();
			cashReceiptPage.clickVoucherLink();
			cashReceiptPage.clickCashReceiptLink();
			cashReceiptPage.clickCreateNewButton();						
			cashReceiptPage.enterVoucherAmount(propReader.getProperty("voucherInputLable"), propReader.getProperty("voucherInputIdPart"), propReader.getProperty("voucherAmount"));
			cashReceiptPage.enterNarration(propReader.getProperty("narrationInputLable"), propReader.getProperty("narrationInputIdPart"), propReader.getProperty("narrationValue"));
			cashReceiptPage.selectTxnCode(propReader.getProperty("txnCodeValue"));
			cashReceiptPage.selectDebitToAccount(propReader.getProperty("debitToAccount"));
			//bankPaymentPage.clickSubmitButton();
		}
		
		public void executeLogin() {
			loginFlow.loginFlowCheck();
			WaitHelper.waitForInvisibilityOfElementLocated(driver,cashReceiptPage.getDotSpinner(),20);
		}
}
