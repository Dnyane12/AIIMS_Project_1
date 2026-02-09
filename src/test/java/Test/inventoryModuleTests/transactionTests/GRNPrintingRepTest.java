package Test.inventoryModuleTests.transactionTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.inventoryModuleFlow.transactionFlow.GRNPrintingFlow;
import pageObjects.inventory.transaction.GRNPrintingPage;
import utils.PropertyReader;

public class GRNPrintingRepTest extends SetUp{
	GRNPrintingFlow grnFlow;
	GRNPrintingPage grnPage;
	PropertyReader propReader;
	
	
	@BeforeClass
	public void initObj() {
		propReader =new PropertyReader("InventoryModule/grnPrintingRepTestData");
		grnFlow= new GRNPrintingFlow(driver);
		grnPage = new GRNPrintingPage(driver);
		grnFlow.prepEnvfromLogin(); 
	}
		
	@Test
	public void validateGRNRepFlow() {
		grnFlow.executeGRNRepFlow();
	}
}
