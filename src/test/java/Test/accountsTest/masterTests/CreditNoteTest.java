package Test.accountsTest.masterTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.accountsModuleFlow.masterFlow.CreditNoteFlow;
import flowPack.accountsModuleFlow.masterFlow.DebitNoteFlow;
import pageObjects.accounts.master.CreditNotePage;
import pageObjects.accounts.master.DebitNotePage;

public class CreditNoteTest extends SetUp{
	CreditNotePage creditNotePage;
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
