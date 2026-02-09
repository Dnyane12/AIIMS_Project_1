package Test.inventoryModuleTests.transactionTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.SetUp;
import flowPack.inventoryModuleFlow.transactionFlow.GRNPostingFlow;
import pageObjects.inventory.transaction.GRNPostingPage;

public class GRNPostingTest extends SetUp{
	GRNPostingFlow GRNPostFlow;
	GRNPostingPage GRNPostPage;
	SoftAssert softAssert;
	
	
	@BeforeClass
	public void objIni() {
		GRNPostFlow = new GRNPostingFlow(driver);
		GRNPostPage= new GRNPostingPage(driver);
		GRNPostFlow.openFormFromLogin();
		softAssert = new SoftAssert();
	}
	
	
	@Test
	public void validateGRNPostingCreation() {
		GRNPostFlow.executeGRNPostingFlow();       
		
		String actSuccMsg =GRNPostPage.extractSuccMsg();
		String expSuccMsg="Voucher Created successfully, ID:";
		System.out.println("actSuccMsg:"+actSuccMsg);
				
		softAssert.assertTrue(actSuccMsg.contains(expSuccMsg),"Account payable voucher not created successfully.");
	}
	
}
