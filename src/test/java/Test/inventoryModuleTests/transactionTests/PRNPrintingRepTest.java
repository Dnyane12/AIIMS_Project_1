package Test.inventoryModuleTests.transactionTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.inventoryModuleFlow.transactionFlow.PRNPrintingRepFlow;
import pageObjects.inventory.transaction.PRNPrintingRepPage;
import utils.PropertyReader;

public class PRNPrintingRepTest extends SetUp{
	PRNPrintingRepFlow prnFlow;
	PRNPrintingRepPage prnPage;
	PropertyReader propReader;
	
	@BeforeClass
	public void initObj() {
		propReader =new PropertyReader("InventoryModule/prnPrintingTestData");
		prnFlow= new PRNPrintingRepFlow(driver);
		prnPage = new PRNPrintingRepPage(driver);
		prnFlow.prepEnvfromLogin(); 

	}
	
	
	@Test
	public void executePRNRepFlow() {
		prnFlow.executePRNRepPrintFlow();
	}
	
}
