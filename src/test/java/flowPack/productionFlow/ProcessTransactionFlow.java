package flowPack.productionFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.production.ProcessTransactionPage;
import utils.PropertyReader;
import utils.WaitHelper;

public class ProcessTransactionFlow {
	WebDriver driver;
	ProcessTransactionPage procTransPage;
	LoginFlow loginFlow;
	HomeFlow homeFlow;
	PropertyReader propReader;
	private static Logger logger = LogManager.getLogger(ProcessTransactionFlow.class);
	
	public ProcessTransactionFlow(WebDriver driver) {
		this.driver = driver;
		propReader = new PropertyReader("productionModule/ProcessTransTestData.properties");
		loginFlow = new LoginFlow(driver);
		homeFlow= new HomeFlow(driver);
		procTransPage = new ProcessTransactionPage(driver);
	}
	
	
	public void flowFromLogin() {
		logger.info("===== Starting GRN Flow Execution, Step 1: Performing Login Flow=====");
		loginFlow.loginFlowCheck();
		
		logger.info("clicking inventoryMod  in HomePage");
		WaitHelper.waitForInvisibilityOfElementLocated(driver, procTransPage.getDotSpinner(), 10);
		procTransPage.clickProductionMenu();
		procTransPage.clickTransactionMenu();
		procTransPage.clickProcessTransMenu();	
	}
	
	
	public void directlyNavigateToProcessTransaction() {		
		procTransPage.clickProcessTransMenu();		
	}
	
	public void processTransactionFlow() {
		procTransPage.clickBookButton();
		procTransPage.clickConfOkBtn();
		procTransPage.selectLocation(propReader.getProperty("location1"), propReader.getProperty("location2"),propReader.getProperty("value"));
		procTransPage.clickSetBomQtyBtn();
		procTransPage.selectShift(propReader.getProperty("shift"));
		procTransPage.selectLocForOutput(propReader.getProperty("locForOutput"));
		procTransPage.enterOutputQty(propReader.getProperty("outputQty"));
		procTransPage.enterOutputFat(propReader.getProperty("outputFat"));
		procTransPage.enterOutputSNF(propReader.getProperty("outputSNF"));
		procTransPage.clickSubmitButton();		
	}
		
}
