package flowPack.inventoryModuleFlow.transactionFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.inventory.transaction.GRNPrintingPage;
import pageObjects.inventory.transaction.PRNPrintingRepPage;
import utils.PropertyReader;

public class GRNPrintingFlow {
	WebDriver driver;
	PropertyReader propReader;
	LoginFlow loginFlow;
	HomeFlow homeFlow;
	GRNPrintingPage grnPage;
	private static Logger logger= LogManager.getLogger(PRNPrintingRepFlow.class);



	public GRNPrintingFlow(WebDriver driver) {
		this.driver=driver;
		propReader =new PropertyReader("InventoryModule/grnPrintingRepTestData");
		loginFlow= new LoginFlow(driver);
		homeFlow = new HomeFlow(driver);
		grnPage=new GRNPrintingPage(driver);
	}
		

	public void prepEnvfromLogin() {
		logger.info("called prepEnvfromLogin()  method in PRNPrintingRepFlow");		
		logger.info("Executing login flow");
		loginFlow.loginFlowCheck();
		
		logger.info("calling clickToInventoryModule method in PRNPrintingRepFlow");
		homeFlow.clickInvModule();
		grnPage.clickReportLink();
		grnPage.clickGrnPrintRepLink();;	
	}


	public void prepEnvdirectlyAfterPrn() {		
		grnPage.clickGrnPrintRepLink();	
	}

	public void executeGRNRepFlow() {
		// Store the main window handle BEFORE clicking print
        String mainWindow = driver.getWindowHandle();
        
		grnPage.enterFromDate(propReader.getProperty("fromDateValue"));
		grnPage.clickViewButton();
		grnPage.serchGRNNoInSerchBar(propReader.getProperty("grnNo"));
		grnPage.clickPrintIcon();
		   // Now you're on the PDF tab - you can perform validations or actions
//        System.out.println("Current URL: " + driver.getCurrentUrl());
        
        // Close PDF tab and switch back to main window
        //driver.close();
//        grnPage.switchBackToMainWindow(mainWindow);
	}

}
