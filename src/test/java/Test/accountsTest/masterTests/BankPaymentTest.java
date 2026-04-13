package Test.accountsTest.masterTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Test.setUpTests.SetUp;
import flowPack.accountsModuleFlow.masterFlow.BankPaymentFlow;
import pageObjects.accounts.master.BankPaymentPage;
import utils.WaitHelper;

public class BankPaymentTest extends SetUp{
	Logger logger = LogManager.getLogger(BankPaymentTest.class);
	BankPaymentPage	bankPayPage;
	BankPaymentFlow bankPayFlow;
	SoftAssert softAssert;
	
	@BeforeClass
	public void objInit() {
		bankPayPage = new BankPaymentPage(driver);
		bankPayFlow =new BankPaymentFlow(driver);
		softAssert= new SoftAssert();
	}
	
	
	@Test
	public void bankPaymentcreateVali() {
		bankPayFlow.bankPaymentFlow();
		//WaitHelper.waitForInvisibilityOfElementLocated(driver, bankPayPage.getDotSpinner(), 20);
		
		logger.info("Waiting for success message to be visible...");
		WaitHelper.waitForVisible(driver, bankPayPage.getSuccMsg(), 20);
		String actualMsg= bankPayPage.getSuccMsg().getText();
		String expectedMsg= "Voucher Created successfully";
		
		logger.info("Actual Message: " + actualMsg);
		softAssert.assertTrue(actualMsg.startsWith(expectedMsg),"Bank Payment creation failed");	
		softAssert.assertAll();
	}
	
	
	
	
	
}
