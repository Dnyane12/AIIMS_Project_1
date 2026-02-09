package flowPack.salesModuleFlow.reportsFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObjects.sales.reports.SaleOrderPrintingPage;
import utils.WaitHelper;

public class SaleOrderPrintingFlow {
WebDriver driver;
SaleOrderPrintingPage invRep;
private static final Logger logger=LogManager.getLogger(SaleOrderPrintingFlow.class);

public SaleOrderPrintingFlow(WebDriver driver){
		this.driver=driver;
		invRep = new SaleOrderPrintingPage(driver);
	}
	

	
	@Test
	private void printingSaleOrder() {
        logger.info("clicking report link");
        WaitHelper.waitForClickable(driver, invRep.getReportLink(), 10);
		invRep.clickReportLink();
		
		WaitHelper.waitForClickable(driver, invRep.getSaleOrderPrintingLink(), 10);
		invRep.clickSaleOrderPrintLink();
		
		WaitHelper.waitForClickable(driver, invRep.getViewButton(), 10);
		invRep.clickViewButton();
		
		WaitHelper.waitForClickable(driver, invRep.getDateFilter(), 10);
		invRep.clickDateFilter();
		
		WaitHelper.waitForClickable(driver, invRep.getPrintBtn(), 10);
		invRep.clickPrintBtn();
		
		
		WaitHelper.waitForClickable(driver, invRep.getResetBtn(), 10);
		invRep.clickResetBtn();
		
	}
	
}
