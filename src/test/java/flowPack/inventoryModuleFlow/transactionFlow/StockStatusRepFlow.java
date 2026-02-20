package flowPack.inventoryModuleFlow.transactionFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.inventory.transaction.StockStatusRepPage;
import utils.PropertyReader;

public class StockStatusRepFlow {
	WebDriver driver;
	PropertyReader propReader;
	LoginFlow loginFlow;
	HomeFlow homeFlow;
	StockStatusRepPage stockStRepPage;
	private static Logger logger= LogManager.getLogger(StockStatusRepFlow.class);



	public StockStatusRepFlow(WebDriver driver) {
		this.driver=driver;
		propReader =new PropertyReader("InventoryModule/stockStatusRepTestData.properties");
		loginFlow= new LoginFlow(driver);
		homeFlow = new HomeFlow(driver);
		stockStRepPage=new StockStatusRepPage(driver);
	}
		

	public void prepEnvfromLogin() {
		logger.info("called prepEnvfromLogin()  method in PRNPrintingRepFlow");		
		logger.info("Executing login flow");
		loginFlow.loginFlowCheck();
		
		logger.info("calling clickToInventoryModule method in PRNPrintingRepFlow");
		homeFlow.clickInvModule();
		stockStRepPage.clickReportLink();
		stockStRepPage.clickStockStaRepLink();
	}

	public void prepEnvdirOpenStockStatusRep() {		
		stockStRepPage.clickStockStaRepLink();	
	}

	public void executeStockStaRepFlow() {
		stockStRepPage.selectItemType(propReader.getProperty("itemType"));
		stockStRepPage.selectItemSubType(propReader.getProperty("itemSubType"));
		stockStRepPage.clickViewButton();
		stockStRepPage.serchItemNameInSerchBar(propReader.getProperty("poNo"));
		stockStRepPage.clickPrintIcon();
	}
}
