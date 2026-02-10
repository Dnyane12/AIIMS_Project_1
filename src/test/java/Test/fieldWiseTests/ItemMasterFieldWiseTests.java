package Test.fieldWiseTests;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Test.setUpTests.SetUp;
import flowPack.inventoryModuleFlow.masterFlow.ItemMasterFlow;
import flowPack.setUpFlow.HomeFlow;
import flowPack.setUpFlow.LoginFlow;
import pageObjects.inventory.master.ItemMasterPage;
import utils.DropdownTestUtility;
import utils.PropertyReader;
import utils.WaitHelper;

public class ItemMasterFieldWiseTests extends SetUp{	    
		ItemMasterPage itemMasterPage;
		ItemMasterFlow itmMstFlow;
		PropertyReader propReader;
		LoginFlow loginFlow;
		HomeFlow homeFlow;		
		private static final Logger logger= LogManager.getLogger(ItemMasterFieldWiseTests.class);
		
		/*
		 * private ItemMasterFieldWiseTests(WebDriver driver,WebDriver ) {
		 * this.driver=driver; this.=; }
		 */ 
		@BeforeClass
		private void initTests() throws InterruptedException {
			System.out.println("Beforeclass method is called.");
			itemMasterPage= new ItemMasterPage(driver);
			propReader=new PropertyReader("InventoryModule/ItemMasterTestData.properties");
			loginFlow=new LoginFlow(driver);	
			homeFlow =new HomeFlow(driver);
			itmMstFlow =new ItemMasterFlow(driver);
			logger.info("going for login");
			
			loginFlow.loginFlowCheck();
			logger.info("Clicking Inventory module");	
			homeFlow.clickToInvModAndConfMstLink();					
		}
		
		
		
		//test to verify AllMandatory FieldsAre Displayed
				@Test(enabled= false,priority = 1, description = "Verify that all mandatory fields are displayed on the Item Master form")
				private void verifyAllMandatoryFieldsAreDisplayed() throws InterruptedException {
					try {
						WaitHelper.waitForClickable(driver, itemMasterPage.getItemMstLink(), 10);
					logger.info("calling clickHomePageLogo method");
					
					itemMasterPage.clickitemMstLink();
				   // itemMasterPage;
				    SoftAssert softAssert = new SoftAssert();

				    softAssert.assertTrue(itemMasterPage.getItemCode().isDisplayed(), "Item Code field should be visible");
				    softAssert.assertTrue(itemMasterPage.getItemName().isDisplayed(), "Item Name field should be visible");
				    softAssert.assertTrue(itemMasterPage.getItemTypeDrop().isDisplayed(), "Item Type dropdown should be visible");
				    softAssert.assertTrue(itemMasterPage.getItemSubTypeDrop().isDisplayed(), "Item Sub Type dropdown should be visible");
				    softAssert.assertTrue(itemMasterPage.getInvTypeDrop().isDisplayed(), "Inventory Type dropdown should be visible");
				    softAssert.assertTrue(itemMasterPage.getHsnCode().isDisplayed(), "HSN Code dropdown should be visible");
				    softAssert.assertTrue(itemMasterPage.getBatchLot().isDisplayed(), "Batch/Lot dropdown should be visible");
				    softAssert.assertTrue(itemMasterPage.getShelfLife().isDisplayed(), "Shelf Life field should be visible");
				    softAssert.assertTrue(itemMasterPage.getPrintTagDrop().isDisplayed(), "Print Tag dropdown should be visible");
				    softAssert.assertTrue(itemMasterPage.getStockUnitPri().isDisplayed(), "Stock Unit field should be visible");
				    softAssert.assertTrue(itemMasterPage.getStockAccount().isDisplayed(), "Stock Account dropdown should be visible");
				    softAssert.assertTrue(itemMasterPage.getDepartment().isDisplayed(), "Department dropdown should be visible");
				    softAssert.assertTrue(itemMasterPage.getCostcenter().isDisplayed(), "Cost Center dropdown should be visible");
				    softAssert.assertTrue(itemMasterPage.getIsPerchasableCheckbox().isDisplayed(), "Is Purchasable checkbox should be visible");
				    softAssert.assertTrue(itemMasterPage.getIsSalableCheckbox().isDisplayed(), "Is Salable checkbox should be visible");
				    //softAssert.assertTrue(itemMasterPage.defaultLocation.isDisplayed(), "Default Location field should be visible");
				    softAssert.assertAll(); 
					}catch(Exception e){
						// 👈 very important! This collects all failures and reports them
						e.printStackTrace();
					}
				}
		
		
				//test to validate AllTextFieldsBlockSpecialCharacters
				   @Test(enabled =false,priority = 2, description = "Validate special characters are blocked in all text fields")
				   private void validateAllTextFieldsBlockSpecialCharacters() {
				       try {
				    	   
						Map<String, WebElement> fieldMap = new LinkedHashMap<>();
						   fieldMap.put("Item Code", itemMasterPage.getItemCode());
						  // fieldMap.put("Item Name", itemMasterPage.itemName);
						  // fieldMap.put("Shelf Life", itemMasterPage.shelfLife);
						   // Add other input fields you want to check

						   for (Map.Entry<String, WebElement> entry : fieldMap.entrySet()) {
						       entry.getValue().clear();
						       itemMasterPage.validateFieldBlocksSpecialCharacters(entry.getValue(), entry.getKey());
						   }
						   
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   }
				
		//test ToClearAllFields
		@Test(enabled=false,priority=1)
		private void testToClearAllFields() throws InterruptedException {
			WaitHelper.waitForClickable(driver, itemMasterPage.getItemMstLink(), 10);
			logger.info("calling clickHomePageLogo method");
			itemMasterPage.clickitemMstLink();	
			
			WaitHelper.waitForClickable(driver, itemMasterPage.getCreateNewBtn(), 10);
			itemMasterPage.clickCreateNewBtn();
			itemMasterPage.clearAllFields();
		}
		
		
		
		//test to validate ItemTypeDrop Selection
		@Test(enabled = false,priority=2)
		private void validateItemTypeDropSelection() throws InterruptedException {	
			// itmMstFlow.clickToItemMaster();
			
			 try {
				By dropdownIcon = 
					        By.xpath("//label[normalize-space(text())='Item Type']/following::igx-icon[1]");
					   
				WaitHelper.waitForClickable(driver,dropdownIcon, 10);
				//itemMasterPage.selectItemTypeDrop(propReader.getProperty("ItemTypeLabel"),propReader.getProperty("ItemTypeOpt"));
				 List<String> ActualOptList= new ArrayList<>();
				 ActualOptList=DropdownTestUtility.getItemTypeDropdownOptions(driver, propReader.getProperty("ItemTypeLabel"));
				System.out.println("optList :"+ActualOptList);
				List<String> ExpactedList= new ArrayList<>(List.of("FIXED ASSETS","ELECTRICAL","LABORATORY","MECHANICAL","PACKING MATERIAL","PROJECT MATERIAL","TRADING","RAW MATERIAL","WIP","FINISHED GOODS","CONSUMABLES","CAPITAL SPARES","SERVICES ","CRATES","SCRAP"));
				System.out.println("ExpactedList :"+ExpactedList);
				Assert.assertEquals(ActualOptList,ExpactedList,"The Item Type options shown are all not present UI properly");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		
		
		
		//test to validate MandatoryField Validations Grouped
		@Test(enabled =false,priority = 5, description = "Progressively validate all mandatory fields")
		private void testMandatoryFieldValidationsGrouped() {
		    itemMasterPage.clearAllFields();
		    Map<String, Runnable> mandatoryFieldActions = new LinkedHashMap<>();

		    mandatoryFieldActions.put("Item Code", () -> itemMasterPage.enterItemCode(propReader.getProperty("ItemCode")));
		    mandatoryFieldActions.put("Item Name", () -> itemMasterPage.enterItemName(propReader.getProperty("ItemName")));
		    mandatoryFieldActions.put("Item Type", () -> {
				try {
					itemMasterPage.selectItemTypeDrop(
					    propReader.getProperty("ItemTypeLabel"), propReader.getProperty("ItemTypeOpt"));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

		    mandatoryFieldActions.put("Item Sub Type", () -> itemMasterPage.selectItemSubTypeDrop(
		        propReader.getProperty("ItemSubTypeLabel"), propReader.getProperty("ItemSubTypeOpt")));

		    mandatoryFieldActions.put("Inventory Type", () -> itemMasterPage.selectInventoryType(
		        propReader.getProperty("InventoryTypeLabel"), propReader.getProperty("InventoryTypeOpt")));

		    mandatoryFieldActions.put("HSN Code", () -> itemMasterPage.selectHsnCode(
		        propReader.getProperty("hsnCodeLabel"), propReader.getProperty("hsnCodeOpt")));

		    mandatoryFieldActions.put("Batch / Lot", () -> itemMasterPage.selectBatch(
		        propReader.getProperty("BatchLotLabel"), propReader.getProperty("BatchLotOpt")));

		    mandatoryFieldActions.put("Shelf Life", () -> itemMasterPage.enterShelfLife(propReader.getProperty("ShelfLifeValue")));

		    mandatoryFieldActions.put("Print Tag", () -> itemMasterPage.selectPrintTag(
		        propReader.getProperty("printTagLabel"), propReader.getProperty("printTagOpt")));

		    mandatoryFieldActions.put("Stock Unit-Primary", () -> itemMasterPage.selectStockUnitPri(
		        propReader.getProperty("stockUnitLabel"), propReader.getProperty("stockUnitOpt")));

		    mandatoryFieldActions.put("Stock Account", () -> itemMasterPage.selectStockAccount(
		        propReader.getProperty("stockAccountLabel"), propReader.getProperty("stockAccountOpt")));

		    mandatoryFieldActions.put("Department", () -> itemMasterPage.selectDepartment(
		        propReader.getProperty("departmentLabel"), propReader.getProperty("departmentOpt")));

		    mandatoryFieldActions.put("Cost Center", () -> itemMasterPage.selectCostcenter(
		        propReader.getProperty("costCenterLabel"), propReader.getProperty("costCenterOpt")));

		    mandatoryFieldActions.put("Default Location", () -> itemMasterPage.selectDefaultLocation(
		        propReader.getProperty("locationLabel"), propReader.getProperty("locationOpt")));

		    mandatoryFieldActions.put("Is Purchasable?", () -> itemMasterPage.selectIsPurchasableCheckbox());

		    mandatoryFieldActions.put("Is Salable?", () -> itemMasterPage.selectIsSableCheckbox());

		    // If UOM, Group, Tax Category, Division fields are added, follow same pattern:
		    // itemMasterPage.selectUOM(propReader.getProperty("uomLabel"), propReader.getProperty("uomOpt"));


		    for (Map.Entry<String, Runnable> fieldEntry : mandatoryFieldActions.entrySet()) {
		        fieldEntry.getValue().run();
		        Assert.assertFalse(itemMasterPage.isSubmitBtnEnabled(), 
		            "Submit button should still be disabled after filling: " + fieldEntry.getKey());
		    }
		    Assert.assertTrue(itemMasterPage.isSubmitBtnEnabled(), "Submit should be enabled after all mandatory fields are filled");
		}
           
		//test to validate ItemCode WithSpecial Characters Blocked
		@Test(enabled = false,priority = 6, description = "Verify that Item Code does not accept special characters")
		private void validateItemCodeWithSpecialCharactersBlocked() {
		    itemMasterPage.clearAllFields();

		    String invalidInput = "@ITEM#123$";
		    itemMasterPage.enterItemCode(invalidInput);

		    String actualValue = itemMasterPage.getItemCode().getAttribute("value");

		    // Expecting only valid characters (alphanumeric)
		    Assert.assertTrue(actualValue.matches("[A-Za-z0-9]*"),
		        "Item Code should not allow special characters. Actual value: " + actualValue);

		    // Optional: You can also assert what it actually captured (e.g., "ITEM123")
		    System.out.println("Typed: " + invalidInput + " | Captured: " + actualValue);
		}

		 
		
           //test to validate ItemCode MaxLength Restriction
		   @Test(enabled = false,priority = 7, description = "Validate max 10 digits allowed in Item Code")
		   private void validateItemCodeMaxLengthRestriction() {
		       itemMasterPage.clearAllFields();

		       String longInput = "123456789012345"; // 15 digits
		      // itemMasterPage.validateMaxInputLength(itemMasterPage.getItemCode(), "Item Code", longInput, 10);
		   }
			
		   

		   @Test(enabled= false)
		   private void verifyTabNavigationBetweenFields() {
			   
		   }

		   @Test(enabled= false)
		   private void verifyFormLayoutAndStyles() {
			   
	        }
		   
		   @Test(enabled= false)
		   private void verifyAutoGeneratedFieldsAreReadOnly() {
			   
		   }
		   
		   @Test(enabled= false)
		   private void verifyDuplicateItemCodeNotAllowed() {
			   
		   }

		   @Test(enabled= false)
		   private void verifySubmitButtonDisabledInitially() {
			   
		   }

		   @Test(enabled= false)
		   private void verifySubmitButtonEnabledWhenFormIsValid() {
			   
		   }

		   @Test
		   private void verifySuccessfulFormSubmission() {
			   
		   }

		   @Test(enabled= false)
		   private void verifyClearButtonResetsAllFields()
		   {
			   
		   }

		   @Test
		   private void verifyItemSubTypeChangesBasedOnItemType()
		   {
			   
		   }
		   
		   @Test(enabled= false)
		   private void verifyItemTypeDropdownOptions() {
			   
		   }

		   @Test
		   private void verifyDepartmentDropdownOptions()
		   {
			   
		   }
		   @Test(enabled= false)
		   private void validateItemCodeCannotBeEmpty() {
			   
		   }

		   @Test(enabled= false)
		   private void validateItemCodeAcceptsAlphanumericOnly() {
			   
		   }
		   
		   //test to validate positive flow
		   @Test(enabled=false,priority=2)
		   private void validatePositiveFlow() throws InterruptedException {
			   try {
			   itmMstFlow.creatingNewItem();	
			   
				WaitHelper.waitForClickable(driver,itemMasterPage.getListItemCode(), 10);
				itemMasterPage.getListItemCode().click();
				itemMasterPage.getListItemCode().sendKeys(propReader.getProperty("ItemCode"));

				
				WaitHelper.waitForClickable(driver, itemMasterPage.getListItemCode(), 10);			
			    WebElement listItmCode=itemMasterPage.getListItemCode();
			    
			   if(listItmCode.isDisplayed()) {
					System.out.println("The record is submitted successfully.");
				}else{
					System.out.println("The record is not submitted successfully.");
				}
			   Assert.assertTrue(listItmCode.isDisplayed(), "The record is has not beeen created on listing page.");
			   }catch(Exception e) {
				   e.printStackTrace();
			   }
		   }
		   
		   
		   //test to validate record submissition.
		   @Test(enabled =false,priority=9)
		   private void validationOfSubmition() {
			  // .until(ExpectedConditions.elementToBeClickable(itemMasterPage.itemMstLink));				
				//itemMasterPage.clickitemMstLink();									
			  
			   WaitHelper.waitForClickable(driver, itemMasterPage.getListItemCode(), 10);	
			   itemMasterPage.getListItemCode().click();
			   itemMasterPage.getListItemCode().sendKeys(propReader.getProperty("ItemCode"));
				
			   
			   WaitHelper.waitForClickable(driver, itemMasterPage.getListItemCode(), 10);	
			   WebElement listItmCode=itemMasterPage.getListItemCode();	
			   if(listItmCode.isDisplayed()) {
					System.out.println("The record is submitted successfully.");
				}else{
					System.out.println("The record is not submitted successfully.");
				}
			   Assert.assertTrue(listItmCode.isDisplayed(), "The record is has not beeen created on listing page.");
		   }
		   		   

	}
