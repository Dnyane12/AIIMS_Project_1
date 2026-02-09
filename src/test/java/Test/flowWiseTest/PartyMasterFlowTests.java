package Test.flowWiseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.SetUp;
import flowPack.inventoryModuleFlow.masterFlow.InvPartyMasterFlow;


public class PartyMasterFlowTests extends SetUp {
	    InvPartyMasterFlow flows;

	    @BeforeClass
	    public void init() {
	        flows = new InvPartyMasterFlow(driver);
	    }

	    @Test
	    public void completePartyCreationFlowWithValidData() {
			/*
			 * private boolean isPartyInSearchResults(String name) { try { WebElement
			 * resultRow = driver.findElement( By.xpath("//table//tr//td[contains(text(),'"
			 * + name + "')]") ); return resultRow.isDisplayed(); } catch
			 * (NoSuchElementException e) { return false; } }
			 */

	        //Assert.assertTrue(flows.verifyPartyCreatedSuccessfully());
	    }
	

}
