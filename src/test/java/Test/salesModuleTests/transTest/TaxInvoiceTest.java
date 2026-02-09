package Test.salesModuleTests.transTest;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.SetUp;
import flowPack.salesModuleFlow.transactionFlow.TaxInvoiceFlow;
import pageObjects.sales.transaction.TaxInvoicePage;


public class TaxInvoiceTest extends SetUp{
	TaxInvoicePage taxInvPage;
	TaxInvoiceFlow taxInvFlow;
	SoftAssert softAssert;
	
	
	@BeforeClass(groups = {"sales-flow"})
	public void objIni() {
		taxInvPage = new TaxInvoicePage(driver);
		taxInvFlow = new TaxInvoiceFlow(driver);		
		softAssert= new SoftAssert();
		taxInvFlow.prepareEnvToRunFlowFromLogin();
	}
	
	
	//Test to validate the successful creation of tax invoice.
	@Test(groups = {"sales-flow"})
	public void validateTaxInvoiceCreation(String dispatchNo) {
		//ITestContext context
		//String dispatchNo= (String)context.getAttribute("dispatchNo");
		taxInvFlow.createTaxInvoice(dispatchNo);
		
		String sucessMessageDisplayed= taxInvPage.extractSuccMsg();
		String TaxInvoiceId = sucessMessageDisplayed.split("ID:").toString();
		boolean succMsgDisplayStatus = taxInvPage.succMsgDisplayStatus();
		
		System.out.println("succMsgDisplayStatus: "+taxInvPage.succMsgDisplayStatus());
		System.out.println("sucessMessageDisplayed: "+sucessMessageDisplayed+", TaxInvoiceId"+ TaxInvoiceId);
		
		softAssert.assertTrue(succMsgDisplayStatus,"Success Message not displayed,Tax Invoice creation may be Failed!");		
	}
	
	
	
	//Test to validate the auto poppulation of Route and vehicle number on selection of dispatch No.
	@Test(enabled=false)
	public void validateAutoPopOfRouteVehicleNo(){
		//String routeValue= taxInvPage.getRouteValue();
		
	}
	
	
}
