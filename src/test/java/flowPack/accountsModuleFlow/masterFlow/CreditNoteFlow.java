package flowPack.accountsModuleFlow.masterFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.LoginFlow;
import pageObjects.accounts.master.CashReceiptPage;
import pageObjects.accounts.master.CreditNotePage;
import utils.PropertyReader;
import utils.WaitHelper;

public class CreditNoteFlow {
	WebDriver driver;
	CreditNotePage creditNotePage;
	LoginFlow loginFlow;
	PropertyReader propReader;
	private static final Logger logger = LogManager.getLogger(CreditNoteFlow.class);

		public CreditNoteFlow(WebDriver driver) {
			this.driver=driver;	
			loginFlow= new LoginFlow(driver);
			creditNotePage = new CreditNotePage(driver);
			propReader =new PropertyReader("accountsModule/CreditNoteTestData.properties");
	    }
			
		public void creditNoteFlow() {
			executeLogin();			
			creditNotePage.clickAccountModule();
			creditNotePage.clickVoucherLink();
			creditNotePage.clickCreditNoteLink();
			creditNotePage.clickCreateNewButton();		
			creditNotePage.selectAccount(propReader.getProperty("accCodeDropValue"));
			creditNotePage.enterVoucherAmount(propReader.getProperty("voucherInputLable"), propReader.getProperty("voucherInputIdPart"), propReader.getProperty("voucherAmount"));
			creditNotePage.enterNarration(propReader.getProperty("narrationInputLable"), propReader.getProperty("narrationInputIdPart"), propReader.getProperty("narrationValue"));
			creditNotePage.enterBillNo(propReader.getProperty("billNoInputLable"), propReader.getProperty("billNoInputIdPart"), propReader.getProperty("billNoValue"));
			creditNotePage.selectTxnCode(propReader.getProperty("txnCodeValue"));
			creditNotePage.selectDebitToAccount(propReader.getProperty("debitToAccount"));
			//bankPaymentPage.clickSubmitButton();
		}
		
		public void executeLogin() {
			loginFlow.loginFlowCheck();
			WaitHelper.waitForInvisibilityOfElementLocated(driver,creditNotePage.getDotSpinner(),20);
		}
}
