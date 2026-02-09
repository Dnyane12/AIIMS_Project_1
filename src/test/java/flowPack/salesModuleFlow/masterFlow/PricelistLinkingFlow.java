package flowPack.salesModuleFlow.masterFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObjects.sales.master.PricelistLinkingPage;
import utils.PropertyReader;
import utils.WaitHelper;

public class PricelistLinkingFlow{
	public static final Logger logger = LogManager.getLogger(PricelistLinkingFlow.class);
	PricelistLinkingPage pricePartyObj;
	WebDriver driver;
    PropertyReader prop;
    String itemTypeLabel;
    String itemTypeOpt;
    String itemSubTypeLabel;
    String itemSubTypeOpt;
    String pricelistLabel;
    String pricelistOpt;
    
    
    public PricelistLinkingFlow(WebDriver driver) {
		this.driver = driver;
		pricePartyObj= new PricelistLinkingPage(driver);
		prop= new PropertyReader("salesModule/PricelistLinkingTestData.properties");
		itemTypeLabel=prop.getProperty("itemTypeLabel");
		itemTypeOpt=prop.getProperty("itemTypeOpt");
		itemSubTypeLabel=prop.getProperty("itemSubTypeLabel");
		itemSubTypeOpt=prop.getProperty("itemSubTypeOpt");
		pricelistLabel= prop.getProperty("pricelistLabel");
		pricelistOpt= prop.getProperty("pricelistOpt");	
	}


  
	
	
	@Test
	public void linkingPricelistToParty() {
		try {	
			WaitHelper.waitForClickable(driver, pricePartyObj.getPricelistPartyLink(), 10);
			pricePartyObj.clickPricelistPartyLink();
			
			
			WaitHelper.waitForClickable(driver, pricePartyObj.getItemTypeDrop(), 10);
			logger.info("selecting item type from item type dropdown");
			pricePartyObj.selectItemtype(itemTypeLabel,itemTypeOpt);
			
			
			WaitHelper.waitForClickable(driver, pricePartyObj.getItemSubTypeDrop(), 10);		
			logger.info("selecting item subtype  from subTypeDropdown");
			pricePartyObj.selectItemSubtype(itemSubTypeLabel,itemSubTypeOpt);
			
			
			WaitHelper.waitForClickable(driver, pricePartyObj.getPricelistDrop(), 10);
			logger.info("selecting pricelist from pricelist dropdown");
			pricePartyObj.selectkPricelistDrop(pricelistLabel,pricelistOpt);
			
			
			WaitHelper.waitForClickable(driver, pricePartyObj.getSearchPartiesTab(), 10);
			pricePartyObj.clickSearchParty();
			
			
			WaitHelper.waitForClickable(driver, pricePartyObj.getPartyName(), 10);
			pricePartyObj.enterPartyName();
			
			
			WaitHelper.waitForClickable(driver, pricePartyObj.getCheckbox(), 10);
			pricePartyObj.clickCheckBox();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
