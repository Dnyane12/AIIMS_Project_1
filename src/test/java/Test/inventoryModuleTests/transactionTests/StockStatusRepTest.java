package Test.inventoryModuleTests.transactionTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.inventoryModuleFlow.transactionFlow.POPrintingRepFlow;
import flowPack.inventoryModuleFlow.transactionFlow.StockStatusRepFlow;
import pageObjects.inventory.transaction.POPrintingRepPage;
import pageObjects.inventory.transaction.StockStatusRepPage;
import utils.PropertyReader;

public class StockStatusRepTest extends SetUp{
	StockStatusRepFlow stockStRepFlow;
	StockStatusRepPage stockStRepPage;
	PropertyReader propReader;
	
	
	@BeforeClass
	public void initObj() {
		propReader =new PropertyReader("InventoryModule/stockStatusRepTestData");
		stockStRepFlow= new StockStatusRepFlow(driver);
		stockStRepPage = new StockStatusRepPage(driver);
		stockStRepFlow.prepEnvfromLogin(); 

	}
		
	@Test
	public void validatePoRepFlow() {
		stockStRepFlow.executeStockStaRepFlow();
	}
}
