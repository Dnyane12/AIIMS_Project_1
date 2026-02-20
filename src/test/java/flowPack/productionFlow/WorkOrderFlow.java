package flowPack.productionFlow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import flowPack.inventoryModuleFlow.transactionFlow.GoodReceiptNoteFlow;
import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.production.WorkOrderPage;
import utils.PropertyReader;
import utils.WaitHelper;

public class WorkOrderFlow {
	WebDriver driver;
	WorkOrderPage workOPage;
	LoginFlow loginFlow;
	HomeFlow homeFlow;
	PropertyReader propReader;
	private static final Logger logger = LogManager.getLogger(WorkOrderFlow.class);
	
	//Constructor
	public WorkOrderFlow(WebDriver driver) {
		this.driver = driver;
		workOPage = new WorkOrderPage(driver);
		loginFlow = new LoginFlow(driver);
		homeFlow = new HomeFlow(driver);
		propReader = new PropertyReader("productionModule/WorkOrderTestData.properties");
	}
	
	public void loginSteps() {
		logger.info("===== Starting GRN Flow Execution, Step 1: Performing Login Flow=====");
		loginFlow.loginFlowCheck();
		
		logger.info("clicking inventoryMod  in HomePage");
		WaitHelper.waitForInvisibilityOfElementLocated(driver, workOPage.getDotSpinner(), 10);
	}
	
	
	public String extractWorkOrderNo() {
		String successMsg = workOPage.getSuccMsg().getText().trim();
		logger.info("Work Order Creation Success Message: " + successMsg);
		
		String[] msgParts = successMsg.split(":");
		if (msgParts.length > 1) {
		    String workOrderNumber = msgParts[1].trim();
		    logger.info("Extracted Work Order Number: " + workOrderNumber);
			return workOrderNumber;
		} else {
		    logger.warn("Unexpected success message format: " + successMsg);
			return null;
		}	
	}
	
	
	public String extractSuccMsg() {
		WaitHelper.waitForVisible(driver, workOPage.getSuccMsg(), 10);
		String successMsg = workOPage.getSuccMsg().getText().trim();
		logger.info("Work Order Creation Success Message: " + successMsg);
		return successMsg;		
	}
	
	//Method to create work order
	public void createWorkOrder() {
		loginSteps();
		workOPage.navigateToWorkOrderCreate();		
		workOPage.fillDetailFields(propReader.getProperty("department"), propReader.getProperty("item"), propReader.getProperty("bom"), propReader.getProperty("quantity"));
		workOPage.clickSubmitButton();	
	}
	

	
}
