package Test.accountsTest.masterTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Test.setUpTests.SetUp;
import flowPack.accountsModuleFlow.masterFlow.BankPaymentFlow;
import flowPack.accountsModuleFlow.masterFlow.BankReceiptFlow;
import pageObjects.accounts.master.BankPaymentPage;
import pageObjects.accounts.master.BankReceiptPage;
import utils.WaitHelper;

public class BankReceiptTest extends SetUp{
	BankReceiptPage	bankReceiptPage;
	BankReceiptFlow bankReceiptFlow;
	SoftAssert softAssert;
	
	
	@BeforeClass
	public void objInit() {
		bankReceiptPage = new BankReceiptPage(driver);
		bankReceiptFlow =new BankReceiptFlow(driver);
		softAssert= new SoftAssert();
	}
	
	
	@Test
	public void bankRecieptcreateVali() {
		bankReceiptFlow.bankRecieptFlow();
		
		String actualMsg= bankReceiptPage.getSuccMssage();
		String expectedMsg= "Voucher Created successfully";	
		
		softAssert.assertTrue(actualMsg.startsWith(expectedMsg),"Bank Receipt creation failed");	
		softAssert.assertAll();
	}
}
