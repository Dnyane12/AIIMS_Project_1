package flowPack.inventoryModuleFlow.masterFlow;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.inventory.master.PurchaseOrderPages;
import pageObjects.setup.HomePage;
import utils.PropertyReader;
import utils.WaitHelper;

public class PurchaseOrderFlow {
	 WebDriver driver;
	 LoginFlow loginFlow;
	 HomePage homePage;
	 PurchaseOrderPages poPages;	
	 PropertyReader propReader;
	 public static final Logger logger = LogManager.getLogger(PurchaseOrderFlow.class);
	
	 
	public PurchaseOrderFlow(WebDriver driver) {
		logger.info("called PurchaseOrderFlow constructor  in PurchaseOrderFlow");
		this.driver=driver;	
		loginFlow= new LoginFlow(driver);
		homePage = new HomePage(driver);
		poPages= new PurchaseOrderPages(driver);		
		propReader = new PropertyReader("InventoryModule/PurchaseOrderTestData.properties");		
	}
	 
	 
	public void prapareEnv() {
		logger.info("called prapareEnv() method in PurchaseOrderFlow");
		loginFlow.loginFlowCheck();
		homePage.clickInventoryModule();
		
		WaitHelper.waitForInvisibilityOfElementLocated(driver, poPages.getDotSpinner(), 5);
		poPages.clickPurSubModAndPOLink();
	}
		
		
	//method to execute purchase order creation.
	public String creatingPurchaseOrder() {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, poPages.getDotSpinner(), 20);
		WaitHelper.waitForClickable(driver,poPages.getCreateNewButton(), 10);
		
		WaitHelper.waitForInvisibilityOfElementLocated(driver, poPages.getDotSpinner(), 30);
		poPages.clickCreateNewBtn();
		
       
		WaitHelper.waitForInvisibilityOfElementLocated(driver, poPages.getDotSpinner(), 60);
		//WaitHelper.waitForInvisibilityOfElementLocated(driver, poPages.getDotSpinner(), 10);
		
		poPages.selectSeries(propReader.getProperty("SeriesDropOption"));
		
		
		WaitHelper.waitForClickable(driver,poPages.getPartyDropdown(), 10);
		poPages.selectParty(propReader.getProperty("PartyDropOption"));
		
		
		WaitHelper.waitForClickable(driver,poPages.getDispatchModeDropdown(), 10);
		poPages.selectDispatchMode(propReader.getProperty("DispatchModeDropOption"));
		
		WaitHelper.waitForClickable(driver,poPages.getDeliveryDate(), 10);
		poPages.enterDeliveryDate(propReader.getProperty("DeliveryDateValue"));
		
		WaitHelper.waitForClickable(driver,poPages.getDeliveryAt(), 10);
		poPages.enterDeliveryAt(propReader.getProperty("DeliveryAtValue"));
		
		WaitHelper.waitForClickable(driver,poPages.getDeliveryPoint(), 10);
		poPages.enterDeliveryPoint(propReader.getProperty("DeliveryPointValue"));
		
		WaitHelper.waitForClickable(driver,poPages.getPreferredTransporter(), 10);
		poPages.enterPreferredTran(propReader.getProperty("PreferredTransValue"));
		
		
		WaitHelper.waitForClickable(driver,poPages.getItemDtlTab(), 10);
		poPages.clickItemDetailTab();
		
		WaitHelper.waitForClickable(driver,poPages.getItemDropdown(), 20);
		poPages.selectItem(propReader.getProperty("ItemDropOption"));
		
		WaitHelper.waitForClickable(driver,poPages.getQuantity(), 10);
		poPages.enterQuantity(propReader.getProperty("QuantityValue"));
		
		WaitHelper.waitForClickable(driver,poPages.getRate(), 10);
		poPages.enterRate(propReader.getProperty("rateValue"));
		
		WaitHelper.waitForClickable(driver,poPages.getDiscount(), 10);
		poPages.enterDiscount(propReader.getProperty("discountValue"));
		
		WaitHelper.waitForClickable(driver,poPages.getPkgForward(), 10);
		poPages.enterPkgForword(propReader.getProperty("pkgForwordValue"));
		
		
		WaitHelper.waitForClickable(driver,poPages.getAddButtonItemDtl(), 10);
		poPages.enterAddButtonItemDtl();
		
		WaitHelper.waitForClickable(driver,poPages.getTermConTab(), 10);
		poPages.clickTermConTab();
		
		WaitHelper.waitForClickable(driver,poPages.getTermsAndConDrop(), 10);
		poPages.selectTermCondDrop(propReader.getProperty("TermsAndConDropOption"));
		
		WaitHelper.waitForClickable(driver,poPages.getAddButtonTerConTab(), 10);
		poPages.enterAddButtonTerConTab();
		
		WaitHelper.waitForClickable(driver,poPages.getPaymentTermTab(), 10);
		poPages.clickPayTermTab();
		
		
		WaitHelper.waitForClickable(driver,poPages.getX(), 10);
		poPages.enterX(propReader.getProperty("xValue"));
		
		
		WaitHelper.waitForClickable(driver,poPages.getY(), 10);
		poPages.enterY(propReader.getProperty("yValue"));
		
		
		WaitHelper.waitForClickable(driver,poPages.getPaymentTermDrop(), 10);
		poPages.selectPaymentTerm(propReader.getProperty("PaymentTermDropOption"));
		
		WaitHelper.waitForClickable(driver,poPages.getPaymentTermAddBtn(), 10);
		poPages.clickPaymentTermAddBtn();
		
		WaitHelper.waitForClickable(driver,poPages.getSubmitBtn(), 10);
		poPages.clickSubmitBtn();
		
		return poPages.getPoNo();				
	}
	
	
	//method to get flow upto rate entering ,to validate GST calcualations.
	public void flowUptoRateEntering() {
		logger.info("called creatingPurchaseOrder flow method in PurchaseOrderFlow");
		loginFlow.loginFlowCheck();
		homePage.clickInventoryModule();
		
		WaitHelper.waitForClickable(driver,poPages.getPurchaseSubModLink(), 10);
		poPages.clickPurSubModAndPOLink();
		
		WaitHelper.waitForClickable(driver,poPages.getCreateNewButton(), 10);
		poPages.clickCreateNewBtn();
		
		
		WaitHelper.waitForClickable(driver,poPages.getSeriesDropdownField(), 10);
		poPages.selectSeries(propReader.getProperty("SeriesDropOption"));
		
		WaitHelper.waitForClickable(driver,poPages.getPartyDropdown(), 10);
		poPages.selectParty(propReader.getProperty("PartyDropOption"));
		
		WaitHelper.waitForClickable(driver,poPages.getDispatchModeDropdown(), 10);
		poPages.selectDispatchMode(propReader.getProperty("DispatchModeDropOption"));
		
		
		WaitHelper.waitForClickable(driver,poPages.getDeliveryDate(), 10);
		poPages.enterDeliveryDate(propReader.getProperty("DeliveryDateValue"));
		
		WaitHelper.waitForClickable(driver,poPages.getDeliveryAt(), 10);
		poPages.enterDeliveryAt(propReader.getProperty("DeliveryAtValue"));
		
		WaitHelper.waitForClickable(driver,poPages.getDeliveryPoint(), 10);
		poPages.enterDeliveryPoint(propReader.getProperty("DeliveryPointValue"));
		
		
		WaitHelper.waitForClickable(driver,poPages.getPreferredTransporter(), 10);
		poPages.enterPreferredTran(propReader.getProperty("PreferredTransValue"));
		
		
		WaitHelper.waitForClickable(driver,poPages.getItemDtlTab(), 10);
		poPages.clickItemDetailTab();
		
		
		WaitHelper.waitForClickable(driver,poPages.getItemDropdown(), 10);
		poPages.selectItem(propReader.getProperty("ItemDropOption"));
		
		
		WaitHelper.waitForClickable(driver,poPages.getQuantity(), 10);
		poPages.enterQuantity(propReader.getProperty("QuantityValue"));
		
		
		WaitHelper.waitForClickable(driver,poPages.getRate(), 10);
		poPages.enterRate(propReader.getProperty("rateValue"));
	}
	
	
	
}
