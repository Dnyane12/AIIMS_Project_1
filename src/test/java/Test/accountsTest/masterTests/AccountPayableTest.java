package Test.accountsTest.masterTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Test.setUpTests.SetUp;
import flowPack.accountsModuleFlow.masterFlow.AccountPayableFlow;
import flowPack.accountsModuleFlow.masterFlow.AccountReceivableFlow;
import pageObjects.accounts.master.AccountPayablePage;
import pageObjects.accounts.master.AccountReceivablePage;
import utils.PropertyReader;

public class AccountPayableTest extends SetUp{
	AccountPayablePage accountPayablePage;
	AccountPayableFlow accountPayableFlow;
	PropertyReader propReader;
	SoftAssert softAssert;
	private static final Logger logger = LogManager.getLogger(AccountPayableTest.class);
	
	
	@BeforeClass
	public void objInit() {
		accountPayablePage = new AccountPayablePage(driver);
		accountPayableFlow =new AccountPayableFlow(driver);
		propReader =new PropertyReader("accountsModule/AccountPayableTestData.properties");
		softAssert= new SoftAssert();
	}
		

	@Test
	public void accountPayablecreateVali() {
		accountPayableFlow.accountPayableFlow();
		
		String actualMsg= accountPayablePage.getSuccMssage();
		String expectedMsg= "Voucher Created successfully";	
		
		softAssert.assertTrue(actualMsg.startsWith(expectedMsg),"Bank Receipt creation failed");	
		softAssert.assertAll();
	}
	
	
	@Test(enabled=false,description="Test to validate the dependency of debit To account dropdown enability on complete info filiing of Credit To account")
	public void validateCreditToDebitAccDependency() {
		//on after selecting credit to account ,directly select debit to account ,
		//without filling all credit to account details,it should be disabled.
		accountPayableFlow.executeLogin();			
		accountPayablePage.clickAccountModule();
		accountPayablePage.clickVoucherLink();
		accountPayablePage.clickAccountPayLink();
		accountPayablePage.clickCreateNewButton();		
		accountPayablePage.selectAccount(propReader.getProperty("accCodeDropValue"));
		
		boolean enabilityStatus= accountPayablePage.getDebitToAccountDrop().isEnabled();
		softAssert.assertFalse(enabilityStatus,"Dependency of Debit To account enability on Credit To account info filling not working as expected !");
		//accountPayablePage.selectDebitToAccount(propReader.getProperty("debitToAccount"));
	}
	
	
}












