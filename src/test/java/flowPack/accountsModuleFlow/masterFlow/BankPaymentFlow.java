package flowPack.accountsModuleFlow.masterFlow;
import flowPack.setUpFlow.LoginFlow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.accounts.master.BankPaymentPage;
import utils.PropertyReader;
import utils.WaitHelper;

public class BankPaymentFlow {
WebDriver driver;
BankPaymentPage bankPaymentPage;
LoginFlow loginFlow;
PropertyReader propReader;
private static final Logger logger = LogManager.getLogger(BankPaymentPage.class);

	public BankPaymentFlow(WebDriver driver) {
		this.driver=driver;	
		loginFlow= new LoginFlow(driver);
		bankPaymentPage = new BankPaymentPage(driver);
		propReader =new PropertyReader("accountsModule/BankPaymentTestData.properties");
    }
		
	public void bankPaymentFlow() {
		try {
		executeLogin();
		bankPaymentPage.clickAccountModule();
		bankPaymentPage.clickVoucherLink();
		bankPaymentPage.clickBankPaymentLink();
		bankPaymentPage.clickCreateNewButton();
		bankPaymentPage.selectAccount(propReader.getProperty("accCodeDropValue"));
		bankPaymentPage.enterVoucherAmount(propReader.getProperty("voucherInputLable"), propReader.getProperty("voucherInputIdPart"), propReader.getProperty("voucherAmount"));
		bankPaymentPage.enterNarration(propReader.getProperty("narrationInputLable"), propReader.getProperty("narrationInputIdPart"), propReader.getProperty("narrationValue"));
		bankPaymentPage.selectTxnCode(propReader.getProperty("txnCodeValue"));
		bankPaymentPage.selectPaymentMode(propReader.getProperty("paymentModeValue"));
		bankPaymentPage.enterCheckNo(propReader.getProperty("checkNoLabel"), propReader.getProperty("checkNoInputIdPart"), propReader.getProperty("checkNoValue"));
		bankPaymentPage.selectDebitToAccount(propReader.getProperty("debitToAccount"));
		//bankPaymentPage.clickSubmitButton();
		}catch(Exception e) {
			logger.error("Error in Bank Payment Flow: " + e.getMessage());
		}
	}
	
	public void executeLogin() {
		loginFlow.loginFlowCheck();
		WaitHelper.waitForInvisibilityOfElementLocated(driver,bankPaymentPage.getDotSpinner(),20);
	}
	
}
