package Test.inventoryModuleTests.masterTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.inventoryModuleFlow.masterFlow.PurchaseOrderFlow;
import pageObjects.inventory.master.PurchaseOrderPages;
import utils.PropertyReader;
import utils.WaitHelper;

public class PurchaseOrderTest extends SetUp{
	PurchaseOrderPages poPages;
	PurchaseOrderFlow poFlow;
	public static final Logger logger = LogManager.getLogger(PurchaseOrderFlow.class);
	PropertyReader propReader;
	
	
	@BeforeClass
	public void objInitilization() {
		logger.info("called objInitilization method in PurchaseOrderTest");
		poPages = new PurchaseOrderPages(driver);
		poFlow = new PurchaseOrderFlow(driver);
		propReader= new PropertyReader("InventoryModule/PurchaseOrderTestData.properties");
		poFlow.prapareEnv();
	}
	
	
	//Test to validate purchase order creation.
	@Test(enabled=true,priority=0)
	public void validatePurchaseOrderCreation() {
		try {
			logger.info("called validatePurchaseOrderCreation method in PurchaseOrderTest");	
			String poNo= poFlow.creatingPurchaseOrder();
			
			String expeSuccMsg= "Purchase Order Save successfully";
			String actSuccMsg=poPages.getSaveSucMsgText();
			 
			System.out.println("expeUpSuccMsg: "+ expeSuccMsg+",actSuccMsg: "+actSuccMsg);
			Assert.assertTrue(actSuccMsg.startsWith(expeSuccMsg),"Record is not created successfully.");	
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	
	   //Test to validate the update functionality of PO.
		@Test(enabled=false,priority=1)
		public void validatePoUpdateFun() {	
			WaitHelper.waitForClickable(driver, poPages.getEditIcon(), 10);
			poPages.clickEditIcon();
			
			WaitHelper.waitForInvisibilityOfElementLocated(driver, poPages.getDotSpinner(), 10);
			WaitHelper.waitForClickable(driver, poPages.getDeliveryAt(), 10);
			poPages.getDeliveryAt().click();
			
			
			poPages.getDeliveryAt().sendKeys(propReader.getProperty("DeliveryAtUpdatedValue"));
			WaitHelper.waitForClickable(driver, poPages.getUpdateBtn(), 10);
			poPages.clickUpdateBtn();
			
			String expeUpSuccMsg= "Purchase Order Update successfully,ID: A02-WOI-25-00009";
			String actUpSuccMsg=poPages.getUpdateSucMsgText();
			Assert.assertEquals(expeUpSuccMsg, actUpSuccMsg,"Record is not updated successfully.");		
		}
		
		
		
		
	//Test to validate that other fields are deactive until series field is selected.
	@Test(enabled=false)
	public void validateDeactivityOfOtherFields() {
		WaitHelper.waitForVisible(driver, poPages.getSeriesDropdownField(), 10);		
	boolean selectStatus =driver.findElement(poPages.getSeriesDropdownField()).isSelected();
		
	
	if(!selectStatus) {
		WaitHelper.waitForClickable(driver, poPages.getPartyDropdown(), 10);
		WebElement partyDrop = poPages.getPartyDropdown();
	boolean enabilityStatus =partyDrop.isEnabled();	
	   if(!enabilityStatus) {
		Assert.assertFalse(enabilityStatus,"Other fields are active,when series field is not selected.");
	   }else {
		Assert.assertFalse(enabilityStatus,"Other fields are deactive,when series field is not selected.");
	   }
	  }
    }
	
		
	
	//Test to validate the party code is provided in dropdown list or not.
	@Test(enabled=false)
	public void validatePartyCodeForPartyDrop() {
		WaitHelper.waitForClickable(driver, poPages.getSeriesDropdownField(), 10);
		poPages.selectSeries(propReader.getProperty("SeriesDropOption"));
		
		WaitHelper.waitForClickable(driver, poPages.getPartyDropdown(), 10);
		poPages.selectParty(propReader.getProperty("PartyDropOption"));
		String partyValue= poPages.getPartyDropdown().getText();
		partyValue.trim();
	}
	
	
	
	//Test to validate purchase order flow.
	@Test(enabled=false)
	public void validatePoGrossAmount() {
		poFlow.flowUptoRateEntering();
		
		WaitHelper.waitForClickable(driver, poPages.getPoQtyEntered(), 10);
		String poQtyEnteredFieldValue= poPages.getPoQtyEntered().getAttribute("value");
		
		WaitHelper.waitForClickable(driver, poPages.getPoRateEntered(), 10);
		 String poRateEnteredFieldValue= poPages.getPoRateEntered().getAttribute("value");
		
		 WaitHelper.waitForClickable(driver, poPages.getPoGrossAmt(), 10);
		String poGrossAmtFieldValue= poPages.getPoGrossAmt().getAttribute("value");
		
		WaitHelper.waitForClickable(driver, poPages.getPoCgst(), 10);
		String poCgstFieldValue= poPages.getPoCgst().getAttribute("value");
		
		
		WaitHelper.waitForClickable(driver, poPages.getPoSgst(), 10);
		String poSgstFieldValue= poPages.getPoSgst().getAttribute("value");
		
		WaitHelper.waitForClickable(driver, poPages.getPoNetAmount(), 10);
		String poNetAmtFieldValue= poPages.getPoNetAmount().getAttribute("value");
		
		System.out.println("poQtyEnteredFieldValue:"+poQtyEnteredFieldValue);
		System.out.println("poRateEnteredFieldValue:"+poRateEnteredFieldValue);
		System.out.println("poGrossAmtFieldValue:"+poGrossAmtFieldValue);
		System.out.println("poCgstFieldValue:"+poCgstFieldValue);
		System.out.println("poSgstFieldValue:"+poSgstFieldValue);
		System.out.println("poNetAmtFieldValue:"+poNetAmtFieldValue);
		
		// Convert to double (safer for decimal values)
		double poQty = Double.parseDouble(poQtyEnteredFieldValue);
		double rate= Double.parseDouble(poRateEnteredFieldValue);
		double grossAmt= Double.parseDouble(poGrossAmtFieldValue);
		double poCgstValue= Double.parseDouble(poCgstFieldValue);
		double poSgstValue= Double.parseDouble(poSgstFieldValue);
		double poNetAmtValue= Double.parseDouble(poNetAmtFieldValue);
		
		double expGrossAmt =poQty*rate;
        double actGrossAmt=Double.parseDouble(poSgstFieldValue);
		
		Assert.assertEquals(expGrossAmt, actGrossAmt,"Actual gross amount and expected gross amount are not matching,improper calculations!");
	}
	
	
	//Test to validate purchase order flow.
		@Test(enabled=false)
		public void validatePoNetAmount(){
			poFlow.flowUptoRateEntering();
			
			WaitHelper.waitForClickable(driver, poPages.getPoQtyEntered(), 10);
			String poQtyEnteredFieldValue= poPages.getPoQtyEntered().getAttribute("value");
			
			WaitHelper.waitForClickable(driver, poPages.getPoRateEntered(), 10);
			String poRateEnteredFieldValue= poPages.getPoRateEntered().getAttribute("value");
			 poPages.getPoRateEntered().getAttribute("value");
			
			 WaitHelper.waitForClickable(driver, poPages.getPoGrossAmt(), 10);
			 String poGrossAmtFieldValue= poPages.getPoGrossAmt().getAttribute("value");
				
			WaitHelper.waitForClickable(driver, poPages.getPoCgst(), 10);
			String poCgstFieldValue= poPages.getPoCgst().getAttribute("value");
			
			WaitHelper.waitForVisible(driver, poPages.getPoSgst(), 10);
			String poSgstFieldValue= poPages.getPoSgst().getAttribute("value");
			
			WaitHelper.waitForVisible(driver, poPages.getPoNetAmount(), 10);
			String poNetAmtFieldValue= poPages.getPoNetAmount().getAttribute("value");
			
			
			//.until(ExpectedConditions.elementToBeClickable(null))
			
				
			System.out.println("poQtyEnteredFieldValue:"+poQtyEnteredFieldValue);
			System.out.println("poRateEnteredFieldValue:"+poRateEnteredFieldValue);
			System.out.println("poGrossAmtFieldValue:"+poGrossAmtFieldValue);
			System.out.println("poCgstFieldValue:"+poCgstFieldValue);
			System.out.println("poSgstFieldValue:"+poSgstFieldValue);
			System.out.println("poNetAmtFieldValue:"+poNetAmtFieldValue);
			
			// Convert to double (safer for decimal values)
			double poQty = Double.parseDouble(poQtyEnteredFieldValue);
			double rate= Double.parseDouble(poRateEnteredFieldValue);
			double grossAmt= Double.parseDouble(poGrossAmtFieldValue);
			double poCgstValue= Double.parseDouble(poCgstFieldValue);
			double poSgstValue= Double.parseDouble(poSgstFieldValue);
			double poNetAmtValue= Double.parseDouble(poNetAmtFieldValue);
			
			
			//double expGrossAmt =poQty*rate;
			//double expCgstValue = expGrossAmt*
			//double expSgstValue =
			//double expNetAmt =expGrossAmt+poCgstValue+poSgstValue;
            //double actNetAmt=Double.parseDouble(poSgstFieldValue);
			
			//Assert.assertEquals(expGrossAmt, actGrossAmt,"Actual gross amount and expected gross amount are not matching,improper calculations!");
		}
	
		
		
	
}
