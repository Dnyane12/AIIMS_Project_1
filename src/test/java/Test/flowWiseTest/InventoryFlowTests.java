package Test.flowWiseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Test.inventoryModuleTests.transactionTests.GoodReceiptNoteTest;
import Test.setUpTests.SetUp;
import flowPack.inventoryModuleFlow.masterFlow.PurchaseOrderFlow;
import flowPack.inventoryModuleFlow.transactionFlow.GRNPostingFlow;
import flowPack.inventoryModuleFlow.transactionFlow.GRNPrintingFlow;
import flowPack.inventoryModuleFlow.transactionFlow.GoodReceiptNoteFlow;
import flowPack.inventoryModuleFlow.transactionFlow.POPrintingRepFlow;
import flowPack.inventoryModuleFlow.transactionFlow.PRNPrintingRepFlow;
import flowPack.inventoryModuleFlow.transactionFlow.PurchaseReturnFlow;
import flowPack.inventoryModuleFlow.transactionFlow.VoucherPrintingRepFlow;
import flowPack.salesModuleFlow.transactionFlow.MultiSaleOrderFlow;
import flowPack.salesModuleFlow.transactionFlow.SaleDispatchFlow;
import flowPack.salesModuleFlow.transactionFlow.TaxInvoiceFlow;
import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.inventory.transaction.GoodReceiptNotePage;
import utils.WaitHelper;

public class InventoryFlowTests extends SetUp{
	    //This class going to execute only the flow test cases.
		PurchaseOrderFlow poFlow;
		GoodReceiptNoteFlow grnFlow;
		GoodReceiptNotePage grnPage;
		GRNPostingFlow grnPostFlow;
		VoucherPrintingRepFlow vpRepFlow;		
		PurchaseReturnFlow prnFlow;
		PRNPrintingRepFlow prnRepFlow;
		GRNPrintingFlow grnRepFlow;
		POPrintingRepFlow poRepFlow;	
		String poNo;
		String grnNo;
		String voucherNo;
		//LoginFlow loginFlow;
		//HomeFlow homeFlow;
			
		@BeforeClass(groups = "Inventory-flow")
		public void compInvFlow(){
			System.out.println("called compInvFlow() ,@Before class method.");
			poFlow = new PurchaseOrderFlow(driver);		
			grnFlow= new GoodReceiptNoteFlow(driver);		
			grnPostFlow = new GRNPostingFlow(driver);
			vpRepFlow = new VoucherPrintingRepFlow(driver);
			prnFlow= new PurchaseReturnFlow(driver);
			prnRepFlow= new PRNPrintingRepFlow(driver);
			grnRepFlow= new GRNPrintingFlow(driver);
			poRepFlow= new POPrintingRepFlow(driver);
			grnPage = new GoodReceiptNotePage(driver);
			
			
			//loginFlow = new LoginFlow(driver);
			//homeFlow = new HomeFlow(driver);
			//loginFlow.loginFlowCheck();
			//WaitHelper.waitForInvisibilityOfElementLocated(driver, grnPage.getDotSpinner(), 10);
			//homeFlow.clickInvModAndStoreLink();
		}
		
		
			    @Test(groups = "Inventory-flow" ,priority=0)
			    public void validatePurchaseOrderCreation() {
			    	poFlow.prapareEnv();
			    	poNo= poFlow.creatingPurchaseOrder();
			    }

			    
			    @Test( enabled=true,groups = "Inventory-flow",priority=1)			    
			    public void validateGRNCreation(){
			    	grnFlow.prepareEnvToDirectlyOpenGRNForm();
			    	String grnNo= grnFlow.executeGrnFlow(poNo);
			    }

			    	   			    
			    @Test(enabled=false,groups = "Inventory-flow",dependsOnMethods = "validateGRNCreation")
			    public void validateGRNPosting() {
			    	grnPostFlow.openFormDirectlyfromInvToAcc();
			        voucherNo =grnPostFlow.executeGRNPostingFlow(grnNo);
			    }
			    
			    
			    //,dependsOnMethods = "validateGRNPosting"
			    @Test(enabled=false,groups = "Inventory-flow")
			    public void validateAccPayableVoucherRep() throws InterruptedException {
			    	vpRepFlow.repFlowExeFromGRNPosting();
			    	vpRepFlow.executeVPFlow(voucherNo);
			    }
			    
			    
			    @Test(enabled=false,groups = "Inventory-flow", dependsOnMethods = "validateGRNCreation")
			    public void createPurchaseRutNote() {
			    	prnFlow.prepEnvToExeFromAcc();
			    	prnFlow.executingFlowOfPRN();
			    }
			    
			    @Test(enabled=false,groups = "Inventory-flow", dependsOnMethods = "createPurchaseRutNote")
			    public void executeFlowOfPRNPrintingRep() {
			    	prnRepFlow.prepEnvdirectlyAfterPrn();
			    	prnRepFlow.executePRNRepPrintFlow();
			    }
			    
			    
			    
			    @Test(enabled=false,groups = "Inventory-flow")
			    public void executeFlowOfGRNPrintingRep() {
			    	grnRepFlow.prepEnvdirectlyAfterPrn();
			    	grnRepFlow.executeGRNRepFlow();
			    }
			    
			    @Test(enabled=false,groups = "Inventory-flow", dependsOnMethods = "validatePurchaseOrderCreation")
			    public void executeFlowOfPurchaseOrderRep() {
			    	prnFlow.prepEnvToExeFromAcc();
			    	prnFlow.executingFlowOfPRN();
			    }
			    
			    @Test(enabled=false,groups = "Inventory-flow", dependsOnMethods = "validatePurchaseOrderCreation")
			    public void executeFlowOfStockStatusRep() {
			    	prnFlow.prepEnvToExeFromAcc();
			    	prnFlow.executingFlowOfPRN();
			    }
			    
			    @Test(enabled=false,groups = "Inventory-flow", dependsOnMethods = "validatePurchaseOrderCreation")
			    public void executeFlowOfLedgerPrinting() {
			    	poRepFlow.prepEnvdirectlyOpenPoRep();
			    	poRepFlow.executePoRepFlow();
			    }
			    
			    
}
