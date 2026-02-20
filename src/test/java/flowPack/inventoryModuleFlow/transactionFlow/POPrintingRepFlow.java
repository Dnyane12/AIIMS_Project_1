package flowPack.inventoryModuleFlow.transactionFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.inventory.transaction.GRNPrintingPage;
import pageObjects.inventory.transaction.POPrintingRepPage;
import utils.PropertyReader;

public class POPrintingRepFlow {
	WebDriver driver;
	PropertyReader propReader;
	LoginFlow loginFlow;
	HomeFlow homeFlow;
	POPrintingRepPage poPage;
	private static Logger logger= LogManager.getLogger(PRNPrintingRepFlow.class);



	public POPrintingRepFlow(WebDriver driver) {
		this.driver=driver;
		propReader =new PropertyReader("InventoryModule/poPrintingRepTestData.properties");
		loginFlow= new LoginFlow(driver);
		homeFlow = new HomeFlow(driver);
	    poPage=new POPrintingRepPage(driver);
	}
		

	public void prepEnvfromLogin() {
		logger.info("called prepEnvfromLogin()  method in PRNPrintingRepFlow");		
		logger.info("Executing login flow");
		loginFlow.loginFlowCheck();
		
		logger.info("calling clickToInventoryModule method in PRNPrintingRepFlow");
		homeFlow.clickInvModule();
		poPage.clickReportLink();
		poPage.clickPoPrintRepLink();;	
	}


	public void prepEnvdirectlyOpenPoRep() {		
		poPage.clickPoPrintRepLink();	
	}

	public void executePoRepFlow() {
		poPage.enterFromDate(propReader.getProperty("fromDateValue"));
		poPage.selectPoType(propReader.getProperty("poType"));
		poPage.clickViewButton();
		poPage.serchGRNNoInSerchBar(propReader.getProperty("poNo"));
		poPage.clickPrintIcon();
	}
}
