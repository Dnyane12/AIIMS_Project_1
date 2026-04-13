package Test.accountsTest.masterTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.accountsModuleFlow.masterFlow.BankReceiptFlow;
import flowPack.accountsModuleFlow.masterFlow.CashPaymentFlow;
import pageObjects.accounts.master.BankReceiptPage;
import pageObjects.accounts.master.CashPaymentPage;

public class CashPaymentTest extends SetUp{
	CashPaymentPage	cashPaymentPage;
	CashPaymentFlow cashPaymentFlow;
	
	
	@BeforeClass
	public void objInit() {
		cashPaymentPage = new CashPaymentPage(driver);
		cashPaymentFlow =new CashPaymentFlow(driver);
	}
	
	
	@Test
	public void cashPaymentcreateVali() {
		cashPaymentFlow.cashPaymentFlow();
	}
}
