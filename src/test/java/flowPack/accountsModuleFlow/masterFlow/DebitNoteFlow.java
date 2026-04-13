package flowPack.accountsModuleFlow.masterFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.LoginFlow;
import pageObjects.accounts.master.CashReceiptPage;
import pageObjects.accounts.master.DebitNotePage;
import utils.PropertyReader;
import utils.WaitHelper;

public class DebitNoteFlow {
	WebDriver driver;
	DebitNotePage debitNotePage;
	LoginFlow loginFlow;
	PropertyReader propReader;
	private static final Logger logger = LogManager.getLogger(DebitNoteFlow.class);

		public DebitNoteFlow(WebDriver driver) {
			this.driver=driver;	
			loginFlow= new LoginFlow(driver);
			debitNotePage = new DebitNotePage(driver);
			propReader =new PropertyReader("accountsModule/DebitNoteTestData.properties");
	    }
			
		public void debitNoteFlow() {
			executeLogin();			
			debitNotePage.clickAccountModule();
			debitNotePage.clickVoucherLink();
			debitNotePage.clickDebitNoteLink();
			debitNotePage.clickCreateNewButton();	
			debitNotePage.selectSeries(propReader.getProperty("seriesValue"));
			debitNotePage.selectAccount(propReader.getProperty("accCodeDropValue"));
			debitNotePage.enterVoucherAmount(propReader.getProperty("voucherInputLable"), propReader.getProperty("voucherInputIdPart"), propReader.getProperty("voucherAmount"));
			debitNotePage.enterNarration(propReader.getProperty("narrationInputLable"), propReader.getProperty("narrationInputIdPart"), propReader.getProperty("narrationValue"));
			debitNotePage.enterBillNo(propReader.getProperty("billNoInputLable"), propReader.getProperty("billNoInputIdPart"), propReader.getProperty("billNoValue"));
			debitNotePage.selectTxnCode(propReader.getProperty("txnCodeValue"));
			debitNotePage.selectDebitToAccount(propReader.getProperty("debitToAccount"));
			//bankPaymentPage.clickSubmitButton();
		}
		
		public void executeLogin() {
			loginFlow.loginFlowCheck();
			WaitHelper.waitForInvisibilityOfElementLocated(driver,debitNotePage.getDotSpinner(),20);
		}
}
