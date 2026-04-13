package Test.accountsTest.masterTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.accountsModuleFlow.masterFlow.CashPaymentFlow;
import flowPack.accountsModuleFlow.masterFlow.CashReceiptFlow;
import flowPack.accountsModuleFlow.masterFlow.CreditNoteFlow;
import pageObjects.accounts.master.CashPaymentPage;
import pageObjects.accounts.master.CashReceiptPage;
import pageObjects.accounts.master.CreditNotePage;

public class CashReceiptTest extends SetUp{
	CreditNotePage	creditNotePage;
	CreditNoteFlow creditNoteFlow;
	
	
	@BeforeClass
	public void objInit() {
		creditNotePage = new CreditNotePage(driver);
		creditNoteFlow =new CreditNoteFlow(driver);
	}
	
	
	@Test
	public void cashReceiptcreateVali() {
		creditNoteFlow.creditNoteFlow();
	}
}
