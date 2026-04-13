package Test.accountsTest.masterTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Test.setUpTests.SetUp;
import flowPack.accountsModuleFlow.masterFlow.AccountReceivableFlow;
import flowPack.accountsModuleFlow.masterFlow.DebitNoteFlow;
import pageObjects.accounts.master.AccountReceivablePage;
import pageObjects.accounts.master.DebitNotePage;

public class AccountReceivableTest extends SetUp{
	AccountReceivablePage accountReceivablePage;
	AccountReceivableFlow accountReceivableFlow;
	SoftAssert softAssert;
	
	
	@BeforeClass
	public void objInit() {
		accountReceivablePage = new AccountReceivablePage(driver);
		accountReceivableFlow =new AccountReceivableFlow(driver);
		SoftAssert softAssert= new SoftAssert();
	}
		
	@Test
	public void accountRececreateValidation() {
		accountReceivableFlow.accountReceivableFlow();
		
		String actualMsg= accountReceivablePage.getSuccMssage();
		String expectedMsg= "Voucher Created successfully";	
		
		softAssert.assertTrue(actualMsg.startsWith(expectedMsg),"Account Receivable creation failed");	
		softAssert.assertAll();
	}
}
