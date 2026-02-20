package flowPack.inventoryModuleFlow.transactionFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import flowPack.setUpFlow.LoginFlow;
import pageObjects.inventory.transaction.GRNPostingPage;
import utils.PropertyReader;
import utils.WaitHelper;

public class GRNPostingFlow {
	WebDriver driver;
	GRNPostingPage GRNPostPage;
    private static Logger logger=LogManager.getLogger(GRNPostingFlow.class);
	PropertyReader propReader;
	LoginFlow loginFlow;

	
	//constructor
	public GRNPostingFlow(WebDriver driver) {
		this.driver=driver;	
		propReader= new PropertyReader("InventoryModule/GRNPostingTestData.properties");
		GRNPostPage= new GRNPostingPage(driver);
		loginFlow=new LoginFlow(driver);		
	}
	
	
	//prep env directly
	public void openFormDirectlyfromInvToAcc() {
		logger.info("Executing method openFormDirectlyfromInvToAcc(),to directly "
				+ "open GRN posting form,without starting the flow from login.");
				
		GRNPostPage.clickHomeIcon();
		GRNPostPage.clickAccountsMod();
		GRNPostPage.clickVoucherLink();
		GRNPostPage.clickGRNPostingLink();
	}
	
	
	//prep env from starting
	public void openFormFromLogin() {
		logger.info("===== Starting GRN Flow Execution, Step 1: Performing Login Flow=====");
		loginFlow.loginFlowCheck();
		
		logger.info("clicking inventoryMod  in HomePage");
		WaitHelper.waitForInvisibilityOfElementLocated(driver, GRNPostPage.getDotSpinner(), 10);
		GRNPostPage.clickAccountsMod();
		GRNPostPage.clickVoucherLink();
		GRNPostPage.clickGRNPostingLink();
	}
	
	
	//Method to execute GRN posting Flow
	public String executeGRNPostingFlow(String grnNo) {
		System.out.println("grnNo executeGRNPostingFlow in flow class: "+grnNo);
		GRNPostPage.SearchGRNNo(grnNo);
		GRNPostPage.clickForwordArrowIcon();
		GRNPostPage.clickPostGRNButton();
		GRNPostPage.clickSubmitButton();
		
		String voucherNo= GRNPostPage.extractVoucherNo();
		System.out.println("voucherNo:"+voucherNo);
		return voucherNo;
	}
	
	
}
