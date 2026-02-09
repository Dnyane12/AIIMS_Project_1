package Test.salesModuleTests.masterTests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.setUpTests.SetUp;
import flowPack.salesModuleFlow.masterFlow.SPartyMasterFlow;
import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.sales.master.SPartyMasterPage;
import utils.DropdownTestUtility;
import utils.PropertyReader;
import utils.WaitHelper;

public class PartyMasterTest extends SetUp{
	SPartyMasterPage pmpo;
	SPartyMasterFlow partyFlow;
	PropertyReader propReader;
	LoginFlow loginFlow;
	HomeFlow homeFlow;

	
	@BeforeClass
	public void objInitilization() throws InterruptedException {		
		try {
			pmpo =new SPartyMasterPage(driver);
			partyFlow= new SPartyMasterFlow(driver);
			propReader = new PropertyReader("salesModule/SPartyMasterTestData.properties");	
			homeFlow= new HomeFlow(driver);
			loginFlow = new LoginFlow(driver);
			loginFlow.loginFlowCheck();
			homeFlow.clickToSalesModule();
            pmpo.clickPartyMstLink();
			 Thread.sleep(1000);
				
			 WaitHelper.waitForClickable(driver, pmpo.getCreateNewBtn(), 10);
			 //pmpo;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=0)//Test to validate the visibility of the party subtype dropdown on UI.
	public void validateVisibilityOfElements() {
		    WaitHelper.waitForInvisibilityOfElementLocated(driver, pmpo.getDotSpinner(), 10);
		    WaitHelper.waitForVisible(driver, pmpo.getPartyMstPage(), 10);	
			List<WebElement> allElementList =pmpo.getAllElements();
					
			for (WebElement i : allElementList) {
		        try {
		        	WaitHelper.waitForVisible(driver, i, 10);
		            boolean visibilityStatus = i.isDisplayed();
		            System.out.println("visibilityStatus: " + visibilityStatus);
		            Assert.assertTrue(
		                visibilityStatus,
		                "Element with value: '" + i.getAttribute("value") + "' is not visible"
		            );
		        } catch (TimeoutException te) {
		            throw new AssertionError(
		                "Timeout ing for element to be visible: " + i.toString() +
		                ", value: '" + i.getAttribute("value") + "'", te
		            );
		        }
		    }	
	}
	
		
	@Test(enabled=true)//Test to validate the option on selecting is  getting properly reflected on the dropdown field or not.
	public void validateTextAfterSelection() throws InterruptedException {		
		
		 WaitHelper.waitForClickable(driver, pmpo.getPartySubTypeDrop(), 10);
		 pmpo.getPartySubTypeDrop().click();			
		 //.until(ExpectedConditions.elementToBeClickable(pmpo.getPartySubTypeDropOption())).click();
		
		 
		 WaitHelper.waitForClickable(driver, pmpo.getPartySubTypeDrop(), 10); 
		 WebElement	 dropField= pmpo.getPartySubTypeDrop();
        String ExpectedText= "DISTRIBUTOR";
        
        
        String actualText;
        if (dropField.getTagName().equalsIgnoreCase("input")) {
            actualText = dropField.getAttribute("value");
            System.out.println("actualText :"+actualText);
        } else {
            actualText = dropField.getText().trim();
            System.out.println("actualText :"+actualText);
        }
		 System.out.println("ExpectedText :"+ExpectedText);		  
		 Assert.assertEquals(actualText, ExpectedText,"The option on selecting is not getting properly reflected on the dropdown field.");   
	}
	
	
	
	
	@Test(enabled=false)
	public void validateTheOptIsPreseInDropOrNot() {
		WaitHelper.waitForClickable(driver, pmpo.getPartySubTypeDrop(), 10);
		pmpo.getPartySubTypeDrop().click();
				
		 WaitHelper.waitForClickable(driver, pmpo.getPartySubTypeDrop(), 10); 
		 WebElement	 dropField= pmpo.getPartySubTypeDrop();
		 
		List<String>subTyOpt =DropdownTestUtility.getItemTypeDropdownOptions(driver,propReader.getProperty("SubTypeOpt"));
		
		System.out.println("The total options visible in the dropdown lists are:");
		for(String i : subTyOpt) {
	    System.out.println("i");
		}
	}
	
	
	//Test to validate party master flow.
	@Test(enabled=true)
	public void validetePartyMstFlow() {
		try {
			partyFlow.creatingNewParty();
			
			//clicking submit button			
			 WaitHelper.waitForClickable(driver, pmpo.getSubmitBtn(), 10);
			pmpo.clickSubmitBtn();
			
			WaitHelper.waitForClickable(driver, pmpo.getSuccMsg(), 10);
			if (pmpo.getSuccMsg().isDisplayed()) {
				String successMsg = pmpo.getSuccMsg().getText();
				Assert.assertTrue(successMsg.contains("Party Created successfully: , Details:"));
			} else {
				Assert.fail("Sussess message was not displayed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	//test to validate the input field accepts special symbols or not ,for name input field.
	@Test(enabled=true)
	public void validateInputAsNumbersOnly() {
		
		pmpo.clickField(propReader.getProperty("label"));
		
		//sending the special symbols
		WaitHelper.waitForClickable(driver, pmpo.getNameField(), 10);
		pmpo.getNameField().click();
		String expectedValue ="#%^%^&^%(&";
		pmpo.getNameField().sendKeys(expectedValue);
		
		//
		
		WaitHelper.waitForClickable(driver, pmpo.getNameField(), 10);
		String actualInputedValue = pmpo.getNameField().getAttribute("value");
		
		
		//printing the atual and expected values
		System.out.print("expectedValue :"+expectedValue +"|"+"actualInputedValue :"+actualInputedValue);
		
		
		//validating the input by sending the special symbols
		Assert.assertNotEquals(actualInputedValue, expectedValue,"The input field is accepting special symbols!");		
	}
	
	
	
	//test to validate reset Functionality
	@Test(enabled=false)
	public void validateResetBtnFunctionality() {
		WaitHelper.waitForClickable(driver, pmpo.getResetBtn(), 10);
		pmpo.getResetBtn().click();		
	}
	
	
	
	
	
	

}
