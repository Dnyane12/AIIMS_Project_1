package Test.productionModuleTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.productionFlow.ProcessTransactionFlow;
import pageObjects.production.ProcessTransactionPage;

public class ProcessTransactionTest extends SetUp {
	ProcessTransactionFlow procTransFlow;
	ProcessTransactionPage procTransPage;
	
	
	@BeforeClass
	public void objInit() {
		procTransFlow = new ProcessTransactionFlow(driver);
		procTransPage = new ProcessTransactionPage(driver);
	}
	
	
	@Test(priority = 1)
	public void validateProcTransCreation() {
		
	}
	
}
