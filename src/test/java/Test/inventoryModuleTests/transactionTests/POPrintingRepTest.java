package Test.inventoryModuleTests.transactionTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.inventoryModuleFlow.transactionFlow.POPrintingRepFlow;
import pageObjects.inventory.transaction.POPrintingRepPage;
import utils.PropertyReader;

public class POPrintingRepTest extends SetUp{
	POPrintingRepFlow poFlow;
	POPrintingRepPage poPage;
	PropertyReader propReader;
	
	
	@BeforeClass
	public void initObj() {
		propReader =new PropertyReader("InventoryModule/poPrintingRepTestData");
		poFlow= new POPrintingRepFlow(driver);
		poPage = new POPrintingRepPage(driver);
		poFlow.prepEnvfromLogin(); 

	}
		
	@Test
	public void validatePoRepFlow() {
		poFlow.executePoRepFlow();
	}
}
