package flowPack.salesModuleFlow.masterFlow;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.sales.master.SPartyMasterPage;
import pageObjects.sales.master.SalePricelistPage;
import pageObjects.setup.HomePage;
import utils.PropertyReader;
import utils.WaitHelper;

public class SalePricelistFlow{
	WebDriver driver;
	private static final Logger logger=LogManager.getLogger(SalePricelistFlow.class);
	SalePricelistPage priceobj;
	PropertyReader PropReader;
	
	
	
	public SalePricelistFlow(WebDriver driver) {
		this.driver = driver;
		priceobj =new SalePricelistPage(driver);	
		PropReader=new PropertyReader("salesModule/salePricelist.properties");
	}

	

	
	//creating new pricelist
	@Test
	public void createingNewPricelst() throws InterruptedException {
		
		String pricelistName=PropReader.getProperty("pricelistName");
		String itemSubTypeName=PropReader.getProperty("itemTypeOption");
		logger.info("pricelistName: {}",pricelistName);
		String pricelistCode = PropReader.getProperty("pricelistCode");
		String mrp=PropReader.getProperty("mrp");
		
		logger.info("clicking salePricelistLink while changing the party mst form.2");
		WaitHelper.waitForClickable(driver, priceobj.getSalePricelistLink(), 10);
		priceobj.clickSalePricelistLink();
		
		logger.info("clicking confirmation button while changing the party mst form.3");
		WaitHelper.waitForClickable(driver, priceobj.getConfirBtnPopup(), 10);
		priceobj.clickConfirOkBtn();


		WaitHelper.waitForClickable(driver, priceobj.getSalePricelistLink(), 10);
		WaitHelper.waitForInvisibilityOfElementLocated(driver,priceobj.getDotSpinner() , 10);
		logger.info("ing for invisibility of confirBtnPopup of sales pricelist.and then try to clicking create new btn 5");
		//.until(ExpectedConditions.visibilityOf(priceobj.confirBtnPopup));
		WaitHelper.waitForClickable(driver, priceobj.getCreateNewBtn(), 10);
		priceobj.clickCreateNewBtn();
		//priceobj;	
		
		
		WaitHelper.waitForClickable(driver, priceobj.getItemTypeDrop(), 10);
		logger.info("trying to call clickItemTypeDrop of sales pricelist.");
		priceobj.clickItemTypeDrop(PropReader.getProperty("itemTypeLabel"),PropReader.getProperty("itemTypeOption"));
		
		
		WaitHelper.waitForClickable(driver, priceobj.getItemSubTypeDropNew(), 10);
		Thread.sleep(500);
		priceobj.selectItemSubtype(PropReader.getProperty("itemSubTypeLabel"),PropReader.getProperty("itemSubTypeOpt"));
		
		
		WaitHelper.waitForClickable(driver, priceobj.getPricelistName(), 10);
		System.out.println("pricelistName"+pricelistName);
		priceobj.clickPricelistName(pricelistName);
		
		
		
		WaitHelper.waitForClickable(driver, priceobj.getPricelistCode(), 10);
		priceobj.clickPricelistCode(pricelistCode);
		
		
		WaitHelper.waitForClickable(driver, priceobj.getFromDate(), 10);
		priceobj.clickFromDate();
		
		Thread.sleep(1000);
		WaitHelper.waitForClickable(driver, priceobj.getItemDropIcon(), 10);
		priceobj.selectItemDrop(PropReader.getProperty("itemopt"));
		
		
		WaitHelper.waitForClickable(driver, priceobj.getMrp(), 10);
		priceobj.clickMrp(mrp);
		
		
		WaitHelper.waitForClickable(driver, priceobj.getAdd(), 10);
		priceobj.clickAdd();
		
		//.until(ExpectedConditions.elementToBeClickable(priceobj.submitBtn));
		//priceobj.clickSubmitBtn();
		
		
	}
	
	//method to update pricelist
			/*
			 * @Test private void updatePricelist(String pricelistCode) {
			 * priceobj.searchPricelist(pricelistCode); //logic of pricelist code and name
			 * copied to be trimed need to be write //need  priceobj.clickEditBtn();
			 * 
			 * 
			 * }
			 */
}

