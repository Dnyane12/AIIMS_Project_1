package Test.productionModuleTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Test.setUpTests.SetUp;
import flowPack.productionFlow.WorkOrderFlow;
import pageObjects.production.WorkOrderPage;

public class WorkOrderTest extends SetUp {
	WorkOrderPage workOPage;
	WorkOrderFlow workOFlow;
	SoftAssert softAssert;
	
	
	@BeforeClass
	public void objIni() {
		workOPage = new WorkOrderPage(driver);
		workOFlow = new WorkOrderFlow(driver);
		softAssert = new SoftAssert();
	}
	
	@Test(priority = 1,description = "Test to validate work order creation")
	public void validateWorkOrderCreation() {
		workOFlow.createWorkOrder();
		String actSuccMsg =workOFlow.extractSuccMsg();
		String expectedSuccMsg = "Work Order created successfully";
		String workOrderNo=workOFlow.extractWorkOrderNo();
		System.out.println("workOrderNo: "+workOrderNo);
		softAssert.assertTrue(actSuccMsg.contains(expectedSuccMsg), "Success message does not contain expected text. Actual: " + actSuccMsg);
	}

}
