package pageObjects.inventory.master;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtilityDuplicate;
import utils.WaitHelper;

public class ItemMasterPage {
	private static final Logger logger = LogManager.getLogger(ItemMasterPage.class);
	WebDriver driver;


	public ItemMasterPage(WebDriver driver){
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[contains(@class,'fs-12') and contains(text(),'Item')])[1]")
	private WebElement itemMstLink;

	By dotSpinner = By.xpath("/html/body/app-root/div/div/div/div/div");
	
	@FindBy(xpath = "//button[contains(@class,'icon-button') and normalize-space(text())='Create New']")
	private WebElement createNewBtn;

	@FindBy(xpath = "//label[normalize-space(text())='Item Type']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement itemTypeDrop;

	@FindBy(xpath = "//label[normalize-space(text())='Item Sub Type']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement itemSubTypeDrop;

	@FindBy(xpath = "//label[normalize-space(text())='Inventory Type']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement invTypeDrop;

	@FindBy(xpath = "//input[contains(@id,'l_item_code')]")
	private WebElement itemCode;

	@FindBy(xpath = "//label[normalize-space(text())='HSN Code']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement hsnCode;

	@FindBy(xpath = "")
	private WebElement tax;

	@FindBy(xpath = "//label[normalize-space(text())='Batch / Lot']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement batchLot;

	@FindBy(xpath = "//input[@id='l_item_name']")
	private WebElement itemName;

	@FindBy(xpath = "//input[contains(@id,'l_item_shelf_life_Days')]")
	private WebElement shelfLife;

	@FindBy(xpath = "//label[normalize-space(text())='Print Tag']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement printTagDrop;

	@FindBy(xpath = "//label[normalize-space(text())='Stock Unit-Primary']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement stockUnitPri;

	@FindBy(xpath = "//label[normalize-space(text())='Stock Account']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement stockAccount;

	@FindBy(xpath = "//label[normalize-space(text())='Department']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement department;

	@FindBy(xpath = "//label[normalize-space(text())='Cost Center']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement costcenter;

	@FindBy(xpath = "//span[normalize-space()='Is Purchasable?']/ancestor::igx-checkbox//span[contains(@class,'igx-checkbox__composite')]")
	private WebElement isPerchasableCheckbox;

	@FindBy(xpath = "//span[normalize-space()='Is Salable?']/ancestor::igx-checkbox//span[contains(@class,'igx-checkbox__composite')]")
	private WebElement isSalableCheckbox;

	@FindBy(xpath = "//span//app-g-label[normalize-space(text())='Store Location']")
	private WebElement storeLocatioTab;
	
	
	@FindBy(xpath = "//label[normalize-space(text())='Default Location']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement defaultLocation;

	@FindBy(xpath = "//label[normalize-space(text())='Default Location']/parent::div/following-sibling::div//input[contains(@class,'igx-input-group__input')]")
	private WebElement homePageLogo;

	@FindBy(xpath = "//button[normalize-space(text())='Submit' and @id='l_action_save_btn-width-selector']")
	private WebElement subBtn;
	
	@FindBy(xpath = "//input[contains(@id,'l_itemlist_code')]")
	private WebElement listItemCode;
	
	@FindBy(xpath = "//igx-grid-cell[@title='RAJGULLAMILK' and contains(@id,'l_item_item_mst_list_table_igx_grid')]")
	private WebElement listItemName;
	
	
	
	@FindBy(xpath="(//input[@class='igx-input-group__input' and @role='combobox'])[4]")
	private WebElement hsnCodeDisable;

	private void clickHomePageLogo() {
		logger.info("ing for visibility of homePageLogo.");		
		WaitHelper.waitForClickable(driver, homePageLogo, 10);
		
		logger.info("clicking homePageLogo");
		WaitHelper.waitForClickable(driver, homePageLogo, 10);
		homePageLogo.click();
	}

	public void clickitemMstLink() {
		logger.info("ing for visibility of inventoryMod.");
		WaitHelper.waitForClickable(driver, itemMstLink, 10);
		itemMstLink.click();		
	}

	public void clickCreateNewBtn() throws InterruptedException {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
			
		WaitHelper.waitForClickable(driver, createNewBtn, 10);
		createNewBtn.click();
	}

	public void selectItemTypeDrop(String itemTypeLabel, String ItemTypeOpt) throws InterruptedException {
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForClickable(driver, itemTypeDrop, 10);
		
		//UtilityDuplicate.selectFromComboWithoutSearch(driver, , itemTypeLabel, ItemTypeOpt);
		WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, itemTypeLabel, ItemTypeOpt);
	}

	public void selectItemSubTypeDrop(String itemSubTypeLabel, String ItemSubTypeOpt) {
		WaitHelper.waitForClickable(driver, itemSubTypeDrop, 10);
		//UtilityDuplicate.selectFromComboWithoutSearch(driver, , itemSubTypeLabel, ItemSubTypeOpt);
		WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, itemSubTypeLabel, ItemSubTypeOpt);
	}

	public void selectInventoryType(String InventoryTypeLabel, String InventoryOpt) {
		WaitHelper.waitForClickable(driver, invTypeDrop, 10);
		//UtilityDuplicate.selectFromComboWithoutSearch(driver, , InventoryTypeLabel, InventoryOpt);
		WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, InventoryTypeLabel, InventoryOpt);
	}

	public void enterItemCode(String ItemCode) {
		WaitHelper.waitForClickable(driver, itemCode, 10);
		itemCode.click();
	}

	public void selectHsnCode(String hsnCodeLabel, String hsnCodeOpt) {
		WaitHelper.waitForClickable(driver, hsnCode, 10);
		//UtilityDuplicate.selectFromComboWithoutSearch(driver, , hsnCodeLabel, hsnCodeOpt);
		WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, hsnCodeLabel, hsnCodeOpt);
	}

	public void selectBatch(String batchLabel, String batchOpt) {
		WaitHelper.waitForClickable(driver, batchLot, 10);
		WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, batchLabel, batchOpt);
		//UtilityDuplicate.selectFromComboWithoutSearch(driver, , batchLabel, batchOpt);
	}

	public void enterItemName(String ItemName) {
		WaitHelper.waitForClickable(driver, itemName, 10);
		itemName.sendKeys(ItemName);
	}

	public void enterShelfLife(String ShelfLifeValue) {
		WaitHelper.waitForClickable(driver, shelfLife, 10);
		shelfLife.sendKeys(ShelfLifeValue);
	}

	public void selectPrintTag(String printLabel, String printOpt) {
		WaitHelper.waitForClickable(driver, printTagDrop, 10);
		WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, printLabel, printOpt);
	}

	public void selectStockUnitPri(String stockUnitLabel, String stockUnitOpt) {
		WaitHelper.waitForClickable(driver, stockUnitPri, 10);
		WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, stockUnitLabel, stockUnitOpt);
	}

	public void selectStockAccount(String stockAccountLabel, String stockAccountOpt) {
		WaitHelper.waitForClickable(driver, stockAccount, 10);
		WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, stockAccountLabel, stockAccountOpt);
	}

	public void selectDepartment(String departmentLabel, String departmentOpt) {
		WaitHelper.waitForClickable(driver, department, 10);
		WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, departmentLabel, departmentOpt);
	}

	
	
	public void selectIsPurchasableCheckbox() {
		WaitHelper.waitForClickable(driver, isPerchasableCheckbox, 10);
		isPerchasableCheckbox.click();
	}

	
	
	public void selectIsSableCheckbox() {
		WaitHelper.waitForClickable(driver, isSalableCheckbox, 10);
		isSalableCheckbox.click();
	}
	
	
	public void selectCostcenter(String costcenterLabel, String costcenterOpt) {
		WaitHelper.waitForClickable(driver, costcenter, 10);
		WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, costcenterLabel, costcenterOpt);
	}
	
	
	public void clickStoreLocationTab() {
		WaitHelper.waitForClickable(driver, storeLocatioTab, 10);
		storeLocatioTab.click();
	}

	public void selectDefaultLocation(String defaultLocLabel, String defaultLocOpt) {
		WaitHelper.waitForClickable(driver, defaultLocation, 10);
		WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, defaultLocLabel, defaultLocOpt);
	}
	
	
	public void clickSubmitBtn() {
		WaitHelper.waitForClickable(driver, subBtn, 10);
		subBtn.click();
	}

	public void validateSubmitedRecord() {
		WaitHelper.waitForClickable(driver, listItemCode, 10);
		listItemCode.sendKeys("65644");		
	}
	
	public boolean isSubmitBtnEnabled() {
		return subBtn.isEnabled();
	}

		
	public void clearAllFields() {
		logger.info("Clearing all fields on Item Master form...");

		// Clear text fields
		itemCode.clear();
		itemName.clear();
		shelfLife.clear();

		// Clear dropdown inputs
		itemTypeDrop.clear();
		itemSubTypeDrop.clear();
		invTypeDrop.clear();
		//hsnCode.clear();
		batchLot.clear();
		printTagDrop.clear();
		stockUnitPri.clear();
		stockAccount.clear();
		department.clear();
		costcenter.clear();
		defaultLocation.clear();

		// Uncheck checkboxes if selected
		if (isCheckboxSelected(isPerchasableCheckbox)) {
			isPerchasableCheckbox.click();
		}
		if (isCheckboxSelected(isSalableCheckbox)) {
			isSalableCheckbox.click();
		}

		logger.info("All fields cleared.");
	}

	

	public boolean isCheckboxSelected(WebElement checkbox) {
		return checkbox.getAttribute("class").contains("igx-checkbox--checked");
	}
	
	public void validateFieldBlocksSpecialCharacters(WebElement field, String fieldName) {
		String invalidInput = "@ITEM#123$";

		field.clear();
		field.sendKeys(invalidInput);

		String actualValue = field.getAttribute("value");

//		Assert.assertTrue(actualValue.matches("[A-Za-z0-9]*"),
//				fieldName + " should not allow special characters. Actual value: " + actualValue);
//
//		System.out.println("[" + fieldName + "] Typed: " + invalidInput + " | Captured: " + actualValue);
	}

	
	
	
	
//	public void validateMaxInputLength(WebElement field, String fieldName, String inputValue, int expectedMaxLength) {
//		field.clear();
//		field.sendKeys(inputValue);
//
//		String actualValue = field.getAttribute("value");
//
//		Assert.assertTrue(actualValue.length() <= expectedMaxLength, fieldName + " should accept only up to "
//				+ expectedMaxLength + " characters, but got: " + actualValue.length());
//
//		// Optional exact match
//		if (inputValue.length() > expectedMaxLength) {
//			String expectedTruncatedValue = inputValue.substring(0, expectedMaxLength);
//			Assert.assertEquals(actualValue, expectedTruncatedValue,
//					fieldName + " should truncate input to: " + expectedTruncatedValue);
//		}
//
//		System.out.println("[" + fieldName + "] Typed: " + inputValue + " | Accepted: " + actualValue);
//	}
//
//	
//	
//
//	public void verifyAutoFilledAndReadOnly(WebElement field, String fieldName) {
//		// Step 1: Value should not be empty
//		String fieldValue = field.getAttribute("value");
//		Assert.assertNotNull(fieldValue, fieldName + " should not be empty");
//
//		// Step 2: Field should be disabled / read-only
//		Assert.assertFalse(field.isEnabled(), fieldName + " should be read-only or disabled");
//
//		// Optional: Print for debug
//		System.out.println(fieldName + " value: " + fieldValue);
//	}
	
	
	
	
	
	
	
	
	
	
	
	//Getters and Setters
	
	public WebElement getItemMstLink() {
		return itemMstLink;
	}

	public By getDotSpinner() {
		return dotSpinner;
	}

	public WebElement getCreateNewBtn() {
		return createNewBtn;
	}

	public WebElement getItemTypeDrop() {
		return itemTypeDrop;
	}

	public WebElement getItemSubTypeDrop() {
		return itemSubTypeDrop;
	}

	public WebElement getInvTypeDrop() {
		return invTypeDrop;
	}

	public WebElement getItemCode() {
		return itemCode;
	}

	public WebElement getHsnCode() {
		return hsnCode;
	}

	public WebElement getTax() {
		return tax;
	}

	public WebElement getBatchLot() {
		return batchLot;
	}

	public WebElement getItemName() {
		return itemName;
	}

	public WebElement getShelfLife() {
		return shelfLife;
	}

	public WebElement getPrintTagDrop() {
		return printTagDrop;
	}

	public WebElement getStockUnitPri() {
		return stockUnitPri;
	}

	public WebElement getStockAccount() {
		return stockAccount;
	}

	public WebElement getDepartment() {
		return department;
	}

	public WebElement getCostcenter() {
		return costcenter;
	}

	public WebElement getIsPerchasableCheckbox() {
		return isPerchasableCheckbox;
	}

	public WebElement getIsSalableCheckbox() {
		return isSalableCheckbox;
	}

	public WebElement getStoreLocatioTab() {
		return storeLocatioTab;
	}

	public WebElement getDefaultLocation() {
		return defaultLocation;
	}

	public WebElement getHomePageLogo() {
		return homePageLogo;
	}

	public WebElement getSubBtn() {
		return subBtn;
	}

	public WebElement getListItemCode() {
		return listItemCode;
	}

	public WebElement getListItemName() {
		return listItemName;
	}

	public WebElement getHsnCodeDisable() {
		return hsnCodeDisable;
	}

	public void setHsnCodeDisable(WebElement hsnCodeDisable) {
		this.hsnCodeDisable = hsnCodeDisable;
	}
	
	
}
