package flowPack.salesModuleFlow.reportsFlow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObjects.sales.reports.SaleInvoicePrintingPage;
import utils.WaitHelper;

public class SaleInvoicePrintingFlow {
	WebDriver driver;
	SaleInvoicePrintingPage invRep;
	private static final Logger logger=LogManager.getLogger(SaleOrderPrintingFlow.class);	
	
		private SaleInvoicePrintingFlow(WebDriver driver){
			this.driver=driver;
			invRep = new SaleInvoicePrintingPage();
		}
		
	
		
		@Test
		private void printingSaleOrder() {
	        logger.info("clicking report link");
	        
	        WaitHelper.waitForClickable(driver, invRep.getReportLink(), 10);
			invRep.clickReportLink();
			
			logger.info("clicking clickSaleInvoicePrintLink");
			WaitHelper.waitForClickable(driver, invRep.getSaleInvPrintLink(), 10);
			invRep.clickSaleInvPrintLink();
			
			logger.info("clicking viewButton");
			WaitHelper.waitForClickable(driver, invRep.getViewButton(), 10);		
			invRep.clickViewButton();
			
			logger.info("clicking fromDateFilter");
			WaitHelper.waitForClickable(driver, invRep.getFromDateFilter(), 10);		
			invRep.enterFromDate();
			
			logger.info("clicking ToDateFilter");
			WaitHelper.waitForClickable(driver, invRep.getToDateFilter(), 10);
		
			invRep.clickToDateFilter();
			
			logger.info("clicking printBtn");
			WaitHelper.waitForClickable(driver, invRep.getPrintBtn(), 10);
			
			invRep.clickPrintBtn();
			
			logger.info("clicking resetBtn");
			WaitHelper.waitForClickable(driver, invRep.getResetBtn(), 10);
			invRep.clickResetBtn();
			
		}
}
