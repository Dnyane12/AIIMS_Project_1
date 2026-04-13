package Test.accountsTest.masterTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.accountsModuleFlow.masterFlow.CashReceiptFlow;
import flowPack.accountsModuleFlow.masterFlow.DebitNoteFlow;
import pageObjects.accounts.master.CashReceiptPage;
import pageObjects.accounts.master.DebitNotePage;

public class DebitNoteTest extends SetUp{
	DebitNotePage debitNotePage;
	DebitNoteFlow debitNoteFlow;
	
	
	@BeforeClass
	public void objInit() {
		debitNotePage = new DebitNotePage(driver);
		debitNoteFlow =new DebitNoteFlow(driver);
	}
		
	@Test
	public void cashReceiptcreateVali() {
		debitNoteFlow.debitNoteFlow();
	}
}
