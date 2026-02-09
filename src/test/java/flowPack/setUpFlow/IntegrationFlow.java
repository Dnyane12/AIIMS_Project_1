package flowPack.setUpFlow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Test.salesModuleTests.masterTests.PartyMasterTest;
import Test.setUpTests.LoginTest;
import base.SetUp;
import flowPack.inventoryModuleFlow.masterFlow.ItemMasterFlow;
import flowPack.salesModuleFlow.masterFlow.PricelistLinkingFlow;
import flowPack.salesModuleFlow.masterFlow.SPartyMasterFlow;
import flowPack.salesModuleFlow.masterFlow.SalePricelistFlow;
import flowPack.salesModuleFlow.transactionFlow.MultiSaleOrderFlow;
import pageObjects.sales.master.SalePricelistPage;

public class IntegrationFlow extends SetUp{
	private static final Logger logger=LogManager.getLogger(IntegrationFlow.class);
	SPartyMasterFlow spartyMstFlow;
	LoginFlow loginFlow;
	HomeFlow homeFlow;
	SalePricelistFlow priceFlow;
	PricelistLinkingFlow pricelink;
	ItemMasterFlow itemMstFlow;
	MultiSaleOrderFlow mulSaleFlow;
	
	
	@BeforeClass
	public void completeFlowSetup(){
	homeFlow= new HomeFlow(driver);
	loginFlow = new LoginFlow(driver);
	spartyMstFlow =new SPartyMasterFlow(driver);
    priceFlow = new SalePricelistFlow(driver);
    pricelink= new PricelistLinkingFlow(driver);
    mulSaleFlow = new MultiSaleOrderFlow(driver);
    itemMstFlow=new ItemMasterFlow(driver);
	}
    
   
    
   
	
	//method to call complete integration flow.
	@Test
	public void fullIntegrationFlow() {
			try {
								  
				  //logger.info("calling completeFlowSetup method of pricelist flow");
				  //completeFlowSetup();
				  //logger.info("calling completeFlowSetup method of pricelist flow");
				
				  
				  logger.info("calling loggingFlowCheck method of loginFlow");
				  loginFlow.loginFlowCheck();
				  logger.info("called loggingFlowCheck method of loginFlow");
				  
				  //logger.info("calling homeFlowSetup method of homeFlow");
				  //homeFlow.homeFlowSetup();
				  //logger.info("called homeFlowSetup method of homeFlow");
				  
				  logger.info("calling clickToCreatePricelist method of homeFlow");
				  homeFlow.clickToSalesModule();
				  logger.info("called clickToSalesModule method of homeFlow");
				  
				  //logger.info("calling objInitilization method of partyMstFlow");
				  //partyMstFlow.objInitilization();
				  //logger.info("called objInitilization method of partyMstFlow");
				  
				  logger.info("calling creatingNewParty method of partyMstFlow");
				  spartyMstFlow.creatingNewParty();
				  logger.info("called creatingNewParty method of partyMstFlow");
				  
				  logger.info("calling createingNewPricelst method ");
				  // priceFlow.createingNewPricelst();
				  
				  logger.info("calling linkingPricelistToParty method of pricelistLinking form");
				   //pricelink.linkingPricelistToParty();
				  
				  logger.info("calling createMultiSaleOrder method of MultiSaleOrder form");
				 // mulSaleFlow.createMultiSaleOrder();
				  
				  logger.info("calling creatingNewItem method of ItemMasterFlow form");
				   //itemMstFlow.creatingNewItem();
				  				  	  
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	
	
	
	
	
	
	
}
