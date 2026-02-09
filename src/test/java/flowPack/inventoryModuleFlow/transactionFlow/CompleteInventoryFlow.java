package flowPack.inventoryModuleFlow.transactionFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.inventoryModuleFlow.masterFlow.ItemMasterFlow;
import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.IntegrationFlow;
import flowPack.setUpFlow.LoginFlow;

public class CompleteInventoryFlow extends SetUp{
	private ItemMasterFlow itemMstFlow;
	private static final Logger logger=LogManager.getLogger(CompleteInventoryFlow.class);
	LoginFlow loginFlow;
	HomeFlow homeFlow;
	
	@BeforeClass
	public void initilize() {
		itemMstFlow =new ItemMasterFlow(driver);
		homeFlow= new HomeFlow(driver);
		loginFlow = new LoginFlow(driver);
	}
	
	
	
	@Test
	public void InventoryMstFlow() throws InterruptedException {
		 logger.info("calling loggingFlowCheck method of loginFlow");
		  loginFlow.loginFlowCheck();
		  logger.info("called loggingFlowCheck method of loginFlow");
		  
		 logger.info("calling clickToCreatePricelist method of homeFlow");
		  //homeFlow.clickToSalesModule();
		 
		  
		  logger.info("called clickToSalesModule method of homeFlow");
		 logger.info("calling creatingNewItem method of item Master");
		itemMstFlow.creatingNewItem();
	}
}
