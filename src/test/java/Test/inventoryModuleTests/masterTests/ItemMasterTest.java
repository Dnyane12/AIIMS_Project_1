package Test.inventoryModuleTests.masterTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.inventoryModuleFlow.masterFlow.ItemMasterFlow;
import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.inventory.master.ItemMasterPage;
import utils.PropertyReader;
import utils.WaitHelper;

public class ItemMasterTest extends SetUp{
	 ItemMasterFlow itemMstFlow;
	 ItemMasterPage itemMstPage;
	 LoginFlow loginFlow;
	 HomeFlow homeFlow;
	 PropertyReader propReader;
	 public static final Logger logger = LogManager.getLogger(ItemMasterTest.class);
	 
	 
	 @BeforeClass
	 public void objInitilization() {
		 try {		
		 itemMstPage = new ItemMasterPage(driver);
	     itemMstFlow = new ItemMasterFlow(driver);
		 loginFlow = new LoginFlow(driver);
		 homeFlow = new HomeFlow(driver);		
		 propReader= new PropertyReader("InventoryModule/ItemMasterTestData.properties");
		 
		 loginFlow.loginFlowCheck();
		 homeFlow.clickToInvModAndConfMstLink();
		 
		 WaitHelper.waitForClickable(driver, itemMstPage.getItemMstLink(), 10);
		 itemMstPage.clickitemMstLink();
		 
		 WaitHelper.waitForClickable(driver, itemMstPage.getCreateNewBtn(), 10);
		 itemMstPage.getCreateNewBtn().click();
		 //itemMstPage;
		 WaitHelper.waitForInvisibilityOfElementLocated(driver, itemMstPage.getDotSpinner(), 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 
	//Test to validate item creation 
	/*
	 * @Test public void validateItemCreation() { try {
	 * itemMstFlow.creatingNewItem();
	 * .until(ExpectedConditions.elementToBeClickable(itemMstPage.getSubBtn()));
	 * itemMstPage.clickSubmitBtn(); } catch (InterruptedException e) {
	 * e.printStackTrace(); } }
	 */
	
	
	/*
	 * @Test public void validateAllOptDropdown() { try { String label =
	 * "Item Type";
	 * .until(ExpectedConditions.invisibilityOf(itemMstPage.getDotSpinner()));
	 * 
	 * UtilityForDropDownScrollNew util = new UtilityForDropDownScrollNew();
	 * util.dropdownScrollUtilityFunction(label);
	 * 
	 * // System.out.
	 * println("Options from dropdown printing through validateAllOptDropdown:");
	 * //for (String opt : options) { // System.out.println(opt); //}
	 * }catch(Exception e) { e.printStackTrace(); } }
	 */
	
	
	@Test
	public boolean validateHSNCodeByDefaultDisability() {
		WebElement hsnCodeD = itemMstPage.getHsnCodeDisable();
		boolean DisabilityStatus=hsnCodeD.isEnabled();
		if(!DisabilityStatus) {
			System.out.println("The HSN Code field is disabled");
		}else {
			System.out.println("The HSN Code field is disabled");
		}
		return DisabilityStatus;
	}
	
}
