package flowPack.salesModuleFlow.reportsFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObjects.sales.reports.SaleDispatchPrintingPage;
import pageObjects.sales.reports.SaleOrderPrintingPage;
import utils.WaitHelper;

public class SaleDispatchPrintingFlow {
	WebDriver driver;
	SaleDispatchPrintingPage invRep;
	private static final Logger logger=LogManager.getLogger(SaleOrderPrintingFlow.class);
	
		private SaleDispatchPrintingFlow(WebDriver driver){
			this.driver=driver;
			invRep = new SaleDispatchPrintingPage(driver);
		}
		
		
		
		@Test
		private void printingSaleOrder() {
	        logger.info("clicking report link");
	        WaitHelper.waitForClickable(driver, invRep.getReportLink(), 10);
			invRep.clickReportLink();
			
			logger.info("clicking clickSaleDispatchPrintLink");
			 WaitHelper.waitForClickable(driver, invRep.getSaleDispatchPrintingLink(), 10);
			invRep.clickSaleDispatchPrintLink();
			
			logger.info("clicking report link");
			 WaitHelper.waitForClickable(driver, invRep.getViewButton(), 10);
			invRep.clickViewButton();
			
			logger.info("clicking report link");
			 WaitHelper.waitForClickable(driver, invRep.getFromDateFilter(), 10);
			invRep.clickFromDateFilter();
			
			logger.info("clicking report link");
			 WaitHelper.waitForClickable(driver, invRep.getToDateFilter(), 10);
			invRep.clickToDateFilter();
			
			logger.info("clicking report link");
			 WaitHelper.waitForClickable(driver, invRep.getPrintBtn(), 10);
			invRep.clickPrintBtn();
			
			logger.info("clicking report link");
			 WaitHelper.waitForClickable(driver, invRep.getResetBtn(), 10);
			invRep.clickResetBtn();
			
		}
}
