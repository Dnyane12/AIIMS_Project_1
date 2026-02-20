package Test.productionModuleTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.productionFlow.WorkOrderStatusFlow;
import pageObjects.production.WorkOrderStatusPage;

public class WorkOrderStatusTest extends SetUp{

	WorkOrderStatusPage workOSPage;
	WorkOrderStatusFlow workOSFlow;	
	
	@BeforeClass
	public void objInit() {
		workOSPage = new WorkOrderStatusPage(driver);
		workOSFlow = new WorkOrderStatusFlow(driver);
	}
	
	
	@Test(description="Method to validate the start fun of the form.")
	public void validateWorkOrderStatusStartFun() {
		workOSFlow.flowFromLogin();
		workOSFlow.workOrderStatusFlowToStartWO();
	}
}
