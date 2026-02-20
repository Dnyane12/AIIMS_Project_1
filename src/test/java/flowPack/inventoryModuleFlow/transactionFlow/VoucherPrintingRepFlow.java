package flowPack.inventoryModuleFlow.transactionFlow;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.inventory.transaction.VoucherPrintingRepPage;
import pageObjects.setup.HomePage;
import utils.PDFUtilToReadPDFFile;
import utils.PropertyReader;
import utils.UtilityToGetDownlodedFiles;
import utils.WaitHelper;

public class VoucherPrintingRepFlow {
WebDriver driver;
VoucherPrintingRepPage vpRepPage;
PropertyReader propReader;
LoginFlow loginFlow;
HomePage homePage;

	
	public VoucherPrintingRepFlow(WebDriver driver) {
		this.driver=driver;
		vpRepPage= new VoucherPrintingRepPage(driver);
		propReader= new PropertyReader("InventoryModule/VoucherPrintingRepTestData.properties");
		loginFlow= new LoginFlow(driver);
		homePage=new HomePage(driver);			
	}
	
	
	//Method to directly execute Voucher printing rep flow after GRN Posting to check Account Receivable and GRN journal voucher.
	public void repFlowExeFromGRNPosting() {
		vpRepPage.clickReportLink();
		vpRepPage.clickVoucherPrintingLink();
	}
	
	




public void prepareEnvFromLogin() {
	try {				 
		loginFlow.loginFlowCheck();		
		WaitHelper.waitForInvisibilityOfElementLocated(driver, vpRepPage.getDotSpinner(), 10);
		homePage.clickAccountMod();
		
		WaitHelper.waitForInvisibilityOfElementLocated(driver, vpRepPage.getDotSpinner(), 10);			
		vpRepPage.clickReportLink();
		vpRepPage.clickVoucherPrintingLink();
		WaitHelper.waitForInvisibilityOfElementLocated(driver, vpRepPage.getDotSpinner(), 10);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	
		
	public void executeVPFlow(String voucherNo) throws InterruptedException {	
		
		System.out.println("voucher no in flow class: "+voucherNo);
		vpRepPage.selectDocType(propReader.getProperty("docType"));
		
		vpRepPage.selectFromDate(propReader.getProperty("fromDateValue"));
		
		vpRepPage.clickViewButton();
	
		vpRepPage.searchVoucherNo(propReader.getProperty("voucherNo"));
		
		vpRepPage.clickPrintButtonIcon();

       // Desktop.getDesktop().open(pdfFile);
		
         
	}
}
