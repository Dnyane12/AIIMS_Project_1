package Test.inventoryModuleTests.transactionTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Test.setUpTests.SetUp;
import flowPack.inventoryModuleFlow.transactionFlow.PurchaseReturnFlow;
import pageObjects.inventory.transaction.PurchaseReturnPage;
import utils.PropertyReader;
import utils.WaitHelper;
public class PurchaseReturnTest extends SetUp{
	PurchaseReturnFlow prnFlow;
	PurchaseReturnPage prnPages;
	private static final Logger logger = LogManager.getLogger(PurchaseReturnTest.class);
	PropertyReader propReader;
    SoftAssert softAssert;
	
	@BeforeClass
	public void objInitilization() {
		prnFlow = new PurchaseReturnFlow(driver);
		prnPages = new PurchaseReturnPage(driver);
		propReader = new PropertyReader("InventoryModule/PurchaseReturnTestData");
		prnFlow.prepEnvFromLogin();
	}

	
	// Test to validate sucussesful creation of PRN.
	@Test(enabled = true)
	public void validateSucPRNCreation() {
		logger.info("Executing complete flow of PRN.");
		prnFlow.executingFlowOfPRN();

		logger.info("clicking submit button now");
		WaitHelper.waitForClickable(driver, prnPages.getSubmitBtn(), 10);
		prnPages.clickSubmitButton();		

		//spitting to get only desired msg
		logger.info("working on background logic to validate succssfull creation of PRN.");
		WaitHelper.waitForVisible(driver, prnPages.getSubmitBtnSucusessMsg(), 10);
		String actCompMsg = prnPages.getSubmitBtnSucusessMsg().getText();
		String parts[] = actCompMsg.split(":");

		//getting only "PRN Created successfully ID:" this part.
		String actMsg = parts[0] + ":";
		String expMsg = "PRN Created successfully ID:";
		
        String prnNo= parts[1];
        System.out.println("prnNo:"+prnNo);
        
		logger.info("validating actual msg shown on submitting PRN record using assert.");
		//validating actMsg and expMsg using assert.
		Assert.assertTrue(actCompMsg.contains(expMsg),"The actMsg shown is not containing expMsg,PRN is not created succussfully.");
	}

	
	
	// Test to validate complete PRN calculations in view mode.
	@Test(enabled=false)
	public void validatePRNCalculations() {
		try {
		logger.info("flow upto clicking PRN link.");
		prnFlow.flowToValidatePRNCalculation();

		WaitHelper.waitForInvisibilityOfElementLocated(driver, prnPages.getDotSpinner(), 10);
		WaitHelper.waitForClickable(driver, prnPages.getPurchaseSubModLink(), 10);
	
		
		logger.info(
				"locating and clicking view icon,to ckeck net amount calcualtions in case of already created record.");
		WaitHelper.waitForClickable(driver, prnPages.getViewIcon(), 10);
		prnPages.clickViewIconButton();

		WaitHelper.waitForInvisibilityOfElementLocated(driver, prnPages.getDotSpinner(),20);

		//WaitHelper.waitForClickable(driver, prnPages.getGrnDetailsTab(),10);
		prnPages.clickGrnDetailsTab();

		WaitHelper.waitForClickable(driver, prnPages.getViewIcon(), 10);
		prnPages.clickViewIconButton();

		
		WaitHelper.waitForInvisibilityOfElementLocated(driver, prnPages.getDotSpinner(),20);
		String returnQtyValueFch = prnPages.extractingFetchedReturnQty();
		System.out.println("returnQtyValueFch:" + returnQtyValueFch);
		
		String grossAmtValueFch = prnPages.extractingFetchedGrossAmt();
		System.out.println("grossAmtValueFch:" + grossAmtValueFch);
		
		
		String rateFetched = prnPages.extractingFetchedRate();
		System.out.println("rateFetched:" + rateFetched);
		
		String landedRateValueFch = prnPages.extractingFetchedLandedRate();
		System.out.println("landedRateValueFch:" + landedRateValueFch);
		
		
		String totalTaxAmtFetched = prnPages.extractingFetchedTotalTaxAmt();
		System.out.println("totalTaxAmtFetched:" + totalTaxAmtFetched);
		
		
		String totalTaxPerFetched = prnPages.extractingFetchedTotalTaxPer();
		System.out.println("totalTaxPerFetched:" + totalTaxPerFetched);
		
		
		String totalNetAmtFetched = prnPages.extractingFetchedTotalNetAmt();
		System.out.println("totalNetAmtFetched:" + totalNetAmtFetched);
		
		
		String sgstAmtFetched = prnPages.extractingFetchedSgstAmt();
		System.out.println("sgstAmtFetched:" + sgstAmtFetched);
		
		String cgstAmtFteched = prnPages.extractingFetchedCgstAmt();
		System.out.println("cgstAmtFteched:" + cgstAmtFteched);
		
		
		
		double returnQty = (returnQtyValueFch != null? Double.parseDouble(returnQtyValueFch):0.0);
		double rate = Double.parseDouble(rateFetched);
		double grossAmt = Double.parseDouble(grossAmtValueFch);
		double landedRate = Double.parseDouble(landedRateValueFch);
		double totalTaxAmt = Double.parseDouble(totalTaxAmtFetched);
		double totalNetAmt = Double.parseDouble(totalNetAmtFetched);
		double sgstAmt = Double.parseDouble(sgstAmtFetched);
		double cgstAmt = Double.parseDouble(cgstAmtFteched);		
				
				
		double expGross= returnQty*rate;
		double expTotalNetAmt=totalTaxAmt+expGross;
		
		System.out.println("expTotalNetAmt: "+expTotalNetAmt);
		
		//Assert.assertEquals(grossAmt, expGross,"The gross amount calculations are not correct.");	
		Assert.assertEquals(totalNetAmt, expTotalNetAmt,"The total net amount calculations are not correct.");	
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

	
	
	
	// Test to validate auto poppulation of vendor dropdown list on selection of GRN NO.
	@Test(enabled = false)
	public void verifyAutoPoppulation() {
	    logger.info("Checking in case of GRN NO is not selected.");
	    
		boolean isGRNSel= prnFlow.extractGRNSelStatus();
		boolean isVendorEnable= prnFlow.extractVendorEnabilityStatus();
		boolean isVendorSel= prnFlow.extractVendorSelStatus();
	    
	    if(!isGRNSel) {
	    	softAssert.assertFalse(isVendorEnable,"Vendor list is not disabled in case of GRN No. is deselected.");
	    	softAssert.assertFalse(isVendorSel,"Vendor list is not deselected in case of GRN No. is deselected.");	    	
	    }
	    
	     logger.info("Now checking in case of GRN NO is selected.");
         prnFlow.selectGRNNo();
				
		String actualValue = prnPages.getVendorDropList().getAttribute("value");
		String expectedValue = "SUP0000059 / HARIOM INDUSTRIES / 27AGMPK1283D1ZG";
		softAssert.assertEquals(actualValue, expectedValue, "Vendor name autopoppulation is not correct!");
		softAssert.assertAll();
	}

	
	
	// Test to validate auto poppulation of grnInfo tab fields.
	@Test(enabled = false)
	public void verifyAutoPoppulationOfGrnInfoTab() {
		WaitHelper.waitForClickable(driver, prnPages.getVendorValue(), 10);
		String actualValue = prnPages.getVendorValue().getAttribute("value");
		String expectedValue = "SUP0000059 / HARIOM INDUSTRIES / 27AGMPK1283D1ZG";
		Assert.assertEquals(actualValue, expectedValue, "Vendor name autopoppulation is not correct!");

		WaitHelper.waitForClickable(driver, prnPages.getTransporterValue(), 10);
		String actualTranValue = prnPages.getTransporterValue().getAttribute("value");
		String expectedTranValue = "TATA";
		Assert.assertEquals(actualTranValue, expectedTranValue, "TranValue autopoppulation is not correct!");

		WaitHelper.waitForClickable(driver, prnPages.getTransporterModeValue(), 10);
		String actualTMValue = prnPages.getTransporterModeValue().getAttribute("value");
		String expectedTMValue = "Road";
		Assert.assertEquals(actualTMValue, expectedTMValue, "TMValue autopoppulation is not correct!");

		WaitHelper.waitForClickable(driver, prnPages.getLrDateValue(), 10);
		String actualLrDateValue = prnPages.getLrDateValue().getAttribute("value");
		String expectedLrDateValue = "03/Nov/2025";
		Assert.assertEquals(actualLrDateValue, expectedLrDateValue, "LrDateValue autopoppulation is not correct!");

		WaitHelper.waitForClickable(driver, prnPages.getInvoiceNoValue(), 10);
		String actualInvNoValue = prnPages.getInvoiceNoValue().getAttribute("value");
		String expectedInvNoValue = "S3283091";
		Assert.assertEquals(actualInvNoValue, expectedInvNoValue, "InvNoValue autopoppulation is not correct!");

		WaitHelper.waitForClickable(driver, prnPages.getInvoiceDateValue(), 10);
		String actualInvDateValue = prnPages.getInvoiceDateValue().getAttribute("value");
		String expectedInvDateValue = "03/Nov/2025";
		Assert.assertEquals(actualInvDateValue, expectedInvDateValue, "Vendor name autopoppulation is not correct!");
	}

	
	
	//Test to validate PRN quantities like accepted quantity,invoice qty ,rej qty ,etc.
	@Test
	public void validateAllQtyOfPRN() {
		//return from store qty should not be greater than  prn accepted qty.
	}
	
	
	//Test to validate mandetory fields.
	@Test
	public void validateMandetoryFields() {
		
	}
	
	
	public void validateGRNInfoCorrectAutoPopp() {
		logger.info("Writting query to extract all GRN info for selected GRN No.");
		
		
	}
	
}
