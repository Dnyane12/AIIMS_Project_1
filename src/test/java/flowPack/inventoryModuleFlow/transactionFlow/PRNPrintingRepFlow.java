package flowPack.inventoryModuleFlow.transactionFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.inventory.transaction.PRNPrintingRepPage;
import utils.PropertyReader;

public class PRNPrintingRepFlow {
WebDriver driver;
PropertyReader propReader;
LoginFlow loginFlow;
HomeFlow homeFlow;
PRNPrintingRepPage prnPage;
private static Logger logger= LogManager.getLogger(PRNPrintingRepFlow.class);



public PRNPrintingRepFlow(WebDriver driver) {
	this.driver=driver;
	propReader =new PropertyReader("InventoryModule/prnPrintingTestData");
	loginFlow= new LoginFlow(driver);
	homeFlow = new HomeFlow(driver);
	prnPage=new PRNPrintingRepPage(driver);

}
	

public void prepEnvfromLogin() {
	logger.info("called prepEnvfromLogin()  method in PRNPrintingRepFlow");		
	logger.info("Executing login flow");
	loginFlow.loginFlowCheck();
	
	logger.info("calling clickToInventoryModule method in PRNPrintingRepFlow");
	homeFlow.clickInvModule();
	prnPage.clickReportLink();
	prnPage.clickPRNRepLink();	
}


public void prepEnvdirectlyAfterPrn() {
	prnPage.clickReportLink();
	prnPage.clickPRNRepLink();	
}

public void executePRNRepPrintFlow() {
	prnPage.enterFromDate(propReader.getProperty("fromDate"));
	prnPage.clickViewButton();
	prnPage.serchPRNNoInSerchBar(propReader.getProperty("prnNo"));
	prnPage.clickPrintIcon();
}



}
