package Test.inventoryModuleTests.transactionTests;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Test.setUpTests.SetUp;
import flowPack.inventoryModuleFlow.transactionFlow.VoucherPrintingRepFlow;
import pageObjects.inventory.transaction.VoucherPrintingRepPage;
import utils.PDFUtilToReadPDFFile;
import utils.PropertyReader;
import utils.UtilityToGetDownlodedFiles;

public class VoucherPrintingRepTest extends SetUp{
VoucherPrintingRepFlow vpRepFlow;
VoucherPrintingRepPage vpRepPage;
SoftAssert softAssert;
PropertyReader propReader;
String voucherNo;


@BeforeClass
public void objIni() {
	vpRepFlow=new VoucherPrintingRepFlow(driver);
	vpRepPage =new VoucherPrintingRepPage(driver);
	vpRepFlow.prepareEnvFromLogin();
	softAssert= new SoftAssert();	
	propReader= new PropertyReader("InventoryModule/VoucherPrintingRepTestData.properties");
	voucherNo =propReader.getProperty("voucherNo");
}


@Test
public void validateVPRepFlow() throws InterruptedException {	
	vpRepFlow.executeVPFlow(voucherNo);
	String downloadDir = System.getProperty("user.home") + "\\Downloads";
    //System.out.println("downloadDir:"+downloadDir);
	
	File pdfFile= UtilityToGetDownlodedFiles.getDownloadedPdf(downloadDir, 20);  
	//softAssert.assertNotNull(pdfFile, "PDF file was not downloaded");
	
    String pdfText = PDFUtilToReadPDFFile.readPdfText(pdfFile);
    //System.out.println("pdfText:"+pdfText);
    System.out.println("voucherNo:"+propReader.getProperty("voucherNo"));
    
    Pattern pattern = Pattern.compile("A02-APV-\\d{2}-\\d{5}");
    Matcher matcher = pattern.matcher(pdfText);

    if (matcher.find()) {
        String voucherNoFromPdf = matcher.group();
        System.out.println("Voucher found: " + voucherNoFromPdf);
    }   
    //softAssert.assertTrue(pdfText.contains(propReader.getProperty("voucherNo")),"Voucher number not found in PDF");
    //softAssert.assertAll();
}









}
