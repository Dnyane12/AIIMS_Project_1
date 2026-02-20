package Test.salesModuleTests.transTest;

import Test.setUpTests.SetUp;
import flowPack.salesModuleFlow.transactionFlow.DirectTaxInvoiceFlow;
import pageObjects.sales.transaction.DirectTaxInvoicePage;

public class DirectTaxInvoiceTest extends SetUp{
	DirectTaxInvoiceFlow dTaxInvFlow;
	DirectTaxInvoicePage dTaxInvPage;
	
	
	public void objIni() {
		dTaxInvFlow = new DirectTaxInvoiceFlow(driver);
		dTaxInvPage = new DirectTaxInvoicePage(driver);
	}
	
	
	public void validateDirectTaxInvFlow() {
		
	}
}
