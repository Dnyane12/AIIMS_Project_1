package flowPack.inventoryModuleFlow.masterFlow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObjects.inventory.master.ItemMasterPage;
import pageObjects.sales.master.SPartyMasterPage;
import pageObjects.setup.HomePage;
import utils.PropertyReader;
import utils.WaitHelper;


public class ItemMasterFlow {
private static final Logger logger = LogManager.getLogger(ItemMasterFlow.class);
	WebDriver driver;
	ItemMasterPage itemMasterPage;
	PropertyReader propReader;
	HomePage homePage;
	SPartyMasterPage partyMstPage;
	
	public ItemMasterFlow(WebDriver driver) {
		   this.driver=driver;	
		   itemMasterPage= new ItemMasterPage(driver);
		   propReader= new PropertyReader("InventoryModule/ItemMasterTestData.properties");
		   homePage= new HomePage(driver);
		   partyMstPage =new SPartyMasterPage(driver);
	}
	
	
	 
	 
	
	 public void creatingNewItem() throws InterruptedException {
		 
		 try {
			logger.info("ing for loader to disappear before clicking Create New button");
			logger.info("calling clickHomePageLogo method");
			//itemMasterPage.clickHomePageLogo();
			

			WaitHelper.waitForClickable(driver, itemMasterPage.getItemMstLink(), 10);
			logger.info("calling clickHomePageLogo method");
			itemMasterPage.clickitemMstLink();	
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getCreateNewBtn(), 10);
			itemMasterPage.clickCreateNewBtn();
			
			logger.info("selecting item Type drop");
			WaitHelper.waitForClickable(driver, itemMasterPage.getItemTypeDrop(), 10);
			itemMasterPage.selectItemTypeDrop(propReader.getProperty("ItemTypeLabel"),propReader.getProperty("ItemTypeOpt"));
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getItemSubTypeDrop(), 10);
			itemMasterPage.selectItemSubTypeDrop(propReader.getProperty("ItemSubTypeLabel"),propReader.getProperty("ItemSubTypeOpt") );
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getInvTypeDrop(), 10);
			itemMasterPage.selectInventoryType(propReader.getProperty("InventoryTypeLabel"),propReader.getProperty("InventoryTypeOpt"));
			
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getHsnCode(), 10);
			itemMasterPage.selectHsnCode(propReader.getProperty("hsnCodeLabel"),propReader.getProperty("hsnCodeOpt"));
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getBatchLot(), 10);
			itemMasterPage.selectBatch(propReader.getProperty("BatchLotLabel"),propReader.getProperty("BatchLotOpt"));
			
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getItemCode(),10);
			itemMasterPage.enterItemCode(propReader.getProperty("ItemCode"));
			
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getItemName(), 10);
			itemMasterPage.enterItemName(propReader.getProperty("ItemName"));
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getShelfLife(), 10);
			itemMasterPage.enterShelfLife(propReader.getProperty("ShelfLifeValue"));
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getPrintTagDrop(), 10);
			itemMasterPage.selectPrintTag(propReader.getProperty("printTagLabel"),propReader.getProperty("printTagOpt"));
			
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getStockUnitPri(),10);
			itemMasterPage.selectStockUnitPri(propReader.getProperty("stockUnitLabel"),propReader.getProperty("stockUnitOpt"));
			
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getStockAccount(), 10);
			itemMasterPage.selectStockAccount(propReader.getProperty("stockAccountLabel"),propReader.getProperty("stockAccountOpt"));
			
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getDepartment(), 10);
			itemMasterPage.selectDepartment(propReader.getProperty("departmentLabel"),propReader.getProperty("departmentOpt"));
			
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getCostcenter(), 10);
			itemMasterPage.selectCostcenter(propReader.getProperty("costCenterLabel"),propReader.getProperty("costCenterOpt"));
		
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getStoreLocatioTab(), 10);
			itemMasterPage.clickStoreLocationTab();
			
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getDefaultLocation(), 10);
			itemMasterPage.selectDefaultLocation(propReader.getProperty("locationLabel"),propReader.getProperty("locationOpt"));
			
		   }catch(Exception e) {
			 e.printStackTrace();
		   }
			}
	 
	 
	 
	 
	 @Test
		private void clickToItemMaster() throws InterruptedException {
		    WaitHelper.waitForClickable(driver, itemMasterPage.getItemMstLink(), 10);
			logger.info("calling clickHomePageLogo method");
			itemMasterPage.clickitemMstLink();	
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getCreateNewBtn(), 10);
			//itemMasterPage;
			WaitHelper.waitForClickable(driver, partyMstPage.getDotSpinnerPartySubType(), 10);
		}
}
