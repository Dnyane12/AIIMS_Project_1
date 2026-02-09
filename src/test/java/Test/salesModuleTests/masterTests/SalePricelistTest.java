package Test.salesModuleTests.masterTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.salesModuleFlow.masterFlow.SalePricelistFlow;
import pageObjects.sales.master.SalePricelistPage;
import utils.PropertyReader;
import utils.WaitHelper;

public class SalePricelistTest extends SetUp{
	SalePricelistPage salePriPage;
	SalePricelistFlow salePriFlow;
	WebDriver driver;
	private static Logger logger= LogManager.getLogger(SalePricelistTest.class);
	PropertyReader propReader;
	
	
	@BeforeClass
	private void objInit() {
		salePriPage = new SalePricelistPage(driver);
		salePriFlow = new SalePricelistFlow(driver);
		propReader = new PropertyReader("salesModule/salePricelist.properties");		
	}
	
	
	
	
	//Test to validate SalePricelistCreation
	@Test
	private void validateSalePricelistCreation() {
		logger.info("calling sale pricelist creation method");
		try {
	    salePriFlow.createingNewPricelst();		
		logger.info("ing locating and clicking submit btn");
		
		
		WaitHelper.waitForInvisibilityOfElementLocated(driver, salePriPage.getDotSpinner(), 10);
		WaitHelper.waitForClickable(driver, salePriPage.getSubmitBtn(), 10);
		salePriPage.clickSubmitBtn();
		
		logger.info("ing and locating the success msg element");
		WaitHelper.waitForClickable(driver, salePriPage.getSuccesssMsgElement(), 10);
		WebElement successsMsgElement = salePriPage.getSuccesssMsgElement();
		
		logger.info("Validating the sale pricelist successfully creation msg using assert.");
        Assert.assertTrue(successsMsgElement.isDisplayed(),"Success msg not displayed.");	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//Test to update the sale pricelist.
	@Test
	private void validateSalePricelistUpdation() {
		try {
			logger.info("calling sale pricelist creation method");
			salePriFlow.createingNewPricelst();
			
			logger.info("ing locating and clicking submit btn");
			WaitHelper.waitForClickable(driver, salePriPage.getSubmitBtn(), 10);
			//salePriPage.clickSubmitBtn();
			
			logger.info("ing and locating the success msg element");
			
			WaitHelper.waitForClickable(driver, salePriPage.getSuccesssMsgElement(), 10);
			WebElement successsMsgElement = salePriPage.getSuccesssMsgElement();
			
			logger.info("Validating the sale pricelist successfully creation msg using assert.");
            Assert.assertTrue(successsMsgElement.isDisplayed(),"Success msg not displayed.");			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	
	//Test to validate edit button Functionality.
	@Test
	private void validateEditBtnFunctionality() {
		logger.info("ing,locating and clicking edit btn");
		
		WaitHelper.waitForClickable(driver, salePriPage.getGlobalSearchBtn(), 10);
		salePriPage.getGlobalSearchBtn().click();
		salePriPage.getGlobalSearchBtn().sendKeys(propReader.getProperty("searchPriceName"));
		
	}
}
