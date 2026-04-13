package flowPack.accountsModuleFlow.masterFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.LoginFlow;
import pageObjects.accounts.master.BankPaymentPage;
import pageObjects.accounts.master.BankReceiptPage;
import utils.PropertyReader;
import utils.WaitHelper;

public class BankReceiptFlow {

	WebDriver driver;
	BankReceiptPage bankReceiptPage;
	LoginFlow loginFlow;
	PropertyReader propReader;
	private static final Logger logger = LogManager.getLogger(BankReceiptFlow.class);

		public BankReceiptFlow(WebDriver driver) {
			this.driver=driver;	
			loginFlow= new LoginFlow(driver);
			bankReceiptPage = new BankReceiptPage(driver);
			propReader =new PropertyReader("accountsModule/BankReceiptTestData.properties");
	    }
			
		public void bankRecieptFlow() {
			executeLogin();			
			bankReceiptPage.clickAccountModule();
			bankReceiptPage.clickVoucherLink();
			bankReceiptPage.clickBankRecieptLink();
			bankReceiptPage.clickCreateNewButton();
			bankReceiptPage.selectSeries(propReader.getProperty("seriesValue"));
			bankReceiptPage.selectAccount(propReader.getProperty("accCodeDropValue"));
			bankReceiptPage.enterVoucherAmount(propReader.getProperty("voucherInputLable"), propReader.getProperty("voucherInputIdPart"), propReader.getProperty("voucherAmount"));
			bankReceiptPage.enterNarration(propReader.getProperty("narrationInputLable"), propReader.getProperty("narrationInputIdPart"), propReader.getProperty("narrationValue"));
			bankReceiptPage.selectTxnCode(propReader.getProperty("txnCodeValue"));
			bankReceiptPage.selectPaymentMode(propReader.getProperty("paymentModeValue"));
			bankReceiptPage.enterCheckNo(propReader.getProperty("checkNoLabel"), propReader.getProperty("checkNoInputIdPart"), propReader.getProperty("checkNoValue"));
			bankReceiptPage.selectDebitToAccount(propReader.getProperty("debitToAccount"));
			bankReceiptPage.clickSubmitButton();
		}
		
		public void executeLogin() {
			loginFlow.loginFlowCheck();
			WaitHelper.waitForInvisibilityOfElementLocated(driver,bankReceiptPage.getDotSpinner(),20);
		}
}
