package pageObjects.sales.master;
import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;
import utils.WaitUtilityDuplicate;

public class SalePricelistPage{
   WebDriver driver;
   boolean status=false;
   private static final Logger logger= LogManager.getLogger(SalePricelistPage.class);
   //To  locate the particular current date dynamically.
   String today = String.valueOf(LocalDate.now().getDayOfMonth());
   
   
   
   public SalePricelistPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
   }
   
    @FindBy(xpath="//div[contains(@class,'menu-l2')]//span[contains(normalize-space(),'Sale Price List')]")
    private WebElement salePricelistLink;
    
    By dotSpinner = By.xpath("/html/body/app-root/div/div/div/div/div");
    
	@FindBy(xpath="//button[normalize-space(text())='Create New']")
	private WebElement createNewBtn;		


	@FindBy(xpath="//div[normalize-space(text())='Confirmation']")
	private WebElement confirBtnPopup;
	
	@FindBy(xpath="//button[normalize-space(text())='OK']")
	private WebElement confirOkBtn;
	
	@FindBy(xpath = "(//label[normalize-space(text())='Item Type']/following::igx-icon[contains(., 'expand_more')])[1]")
	private WebElement itemTypeDrop;

	
	@FindBy(xpath = "//div[contains(@class,'igx-overlay__content')]//igx-combo-item[@role='option']//span[normalize-space(text())='FINISHED GOODS']")
	private WebElement itemTypeDropOption;
	
	 @FindBy(xpath="(//input[@role='combobox' and contains(@class,'igx-input-group__input')])[6]")
		private WebElement itemSubTypeDropNew;
	
	 @FindBy(xpath="//div//span[normalize-space(text())='All']")
	 private WebElement optionOnSearch;
	
	/*
	 * @FindBy(xpath =
	 * "(//label[normalize-space(text())='Item Sub Type']/following::igx-icon[contains(., 'expand_more')])[1]"
	 * ) private WebElement itemSubtypeDrop;
	 * 
	 * @FindBy(xpath =
	 * "//div[contains(@class,'igx-overlay__content')]//igx-combo-item[@role='option']//span[normalize-space(text())='All']")
	 * private WebElement itemSubtypeDropOption;
	 */

	@FindBy(xpath = "//input[starts-with(@id,'l_slph_pricelist_name')]")
	private WebElement pricelistName;

	@FindBy(xpath = "//input[starts-with(@id,'l_slph_pricelist_code')]")
	private WebElement pricelistCode;

	@FindBy(xpath = "//igx-icon[@title='Choose Date' and contains(@class,'material-icons igx-icon')]")
	private WebElement fromDate;
	
	By todayDateLocator =By.xpath("//igx-day-item[contains(@class,'igx-calendar__date')]//span[contains(@class,'igx-calendar__date-content') and normalize-space(text())='" + today + "']");
	
	@FindBy(xpath = "//label[normalize-space(text())='Item']/following::igx-icon[contains(@class,'material-icons') and normalize-space(text())='expand_more']")
	private WebElement itemDropIcon;
	
	
	@FindBy(xpath = "//div[contains(@class,'elect__entry')]//span[contains(@class,'combo-col') and normalize-space(text())='PIZZA BREAD 10 INCH']")
	private WebElement itemDropOption;

	@FindBy(xpath = "//div[contains(@class,'igx-input-group__bundle')]//input[contains(@class,'ng-untouched') and starts-with(@id,'l_slpd_mrp')]")
	private WebElement mrp;

	@FindBy(xpath = "//app-g-btn-all-button[contains(@class,'mt-2')]//button[normalize-space(text())='Add' and @id='l_spld_add_btn-width-selector']")
	private WebElement add;

	@FindBy(xpath = "//button[@id='l_action_save_btn-width-selector' and @name='l_action_save_btn']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//div[@class='igx-snackbar__message' and contains(text(),'Pricelist Created Successfully.')]")
	private WebElement successsMsgElement;
	
	@FindBy(xpath = "(//igx-icon[contains(@class,'material-icons')]/parent::button[contains(@class,'igx-action-button')])[1]")
	private WebElement listPageEditBtn;
	

	@FindBy(xpath = "//input[contains(@class,'p-0') and @placeholder='Sale Price List Search']")
	private WebElement globalSearchBtn;
	
	By aahar170Xpath =By.xpath("By.xpath(\"//span[normalize-space(text())='AAHAR 170ML' and contains(@class,'combo-col')]");
	
	By dropDownInputXpath = By.xpath("//label[normalize-space()='Item']/ancestor::div[contains(@class,'igx-input-group')]//input");
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickSalePricelistLink() {
		WaitHelper.waitForClickable(driver, salePricelistLink, 10);
		salePricelistLink.click();			
	}	
	public void clickConfirOkBtn() {
		try {
		WaitHelper.waitForClickable(driver, confirBtnPopup, 10);
		WaitHelper.waitForClickable(driver, confirOkBtn, 10);
		confirOkBtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void clickCreateNewBtn() {	
		logger.info("ing for loader to disappear before clicking Create New button");
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		logger.info("Confirmation popup is invisible. Clicking on Create New button.");
		WaitHelper.waitForClickable(driver, createNewBtn, 10);
		createNewBtn.click();	
	}
	
	
	
	public void clickItemTypeDrop(String itemLbl,String itemOpt) {		
		logger.info("trying to click itemTypeDrop of sales pricelist.");
		//UtilityDuplicate.selectFromComboWithoutSearch(driver, , itemLbl, itemOpt);
	}

	public void selectItemSubtype(String label,String opt) {
		    WaitHelper.waitForClickable(driver, itemSubTypeDropNew, 10);
		    //UtilityDuplicate.selectFromComboWithoutSearch(driver,,label,opt);
		    WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, label, opt);
	}

	public void clickPricelistName(String pName) {
		logger.info("pName:{}",pName);
		WaitHelper.waitForClickable(driver, pricelistName, 10);
		pricelistName.click();
		pricelistName.sendKeys(pName);
	}

	public void clickPricelistCode(String pCode) {
		pricelistCode.click();
		pricelistCode.sendKeys(pCode);	}

	public void clickFromDate() {
		WaitHelper.waitForClickable(driver, fromDate, 10);
		fromDate.click();
		//WebElement todayDateSelector =
		WaitHelper.waitForClickable(driver, todayDateLocator, 10);
		driver.findElement(todayDateLocator).click();
	}

	public void selectItemDrop(String itemOpt) throws InterruptedException {	      
	    //DrpdownUtilityForScroll.selectItemFromVirtualDropdownByScroll(driver,,dropInputXpath,itemOpt,28);
	     WaitHelper.waitForClickable(driver, dropDownInputXpath, 10);  
	     WebElement itemDrop= driver.findElement(dropDownInputXpath);
	     itemDrop.click();
	     itemDrop.sendKeys("AAHAR 170ML");
	   
	     WaitHelper.waitForClickable(driver, aahar170Xpath, 10);
	     driver.findElement(aahar170Xpath).click();    
	}

	
	public void clickMrp(String mrpValue) {
		WaitHelper.waitForClickable(driver, mrp, 10);
		mrp.click();
		mrp.sendKeys(mrpValue);
	}

	public void clickAdd() {
		 WaitHelper.waitForClickable(driver, add, 10);
		 add.click();
	}

	public void clickSubmitBtn() {
		 WaitHelper.waitForClickable(driver, submitBtn, 10);
		 submitBtn.click();
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public WebElement getSalePricelistLink() {
		return salePricelistLink;
	}
	public void setSalePricelistLink(WebElement salePricelistLink) {
		this.salePricelistLink = salePricelistLink;
	}
	public By getDotSpinner() {
		return dotSpinner;
	}
	public void setDotSpinner(By dotSpinner) {
		this.dotSpinner = dotSpinner;
	}
	public WebElement getCreateNewBtn() {
		return createNewBtn;
	}
	public void setCreateNewBtn(WebElement createNewBtn) {
		this.createNewBtn = createNewBtn;
	}
	public WebElement getConfirBtnPopup() {
		return confirBtnPopup;
	}
	public void setConfirBtnPopup(WebElement confirBtnPopup) {
		this.confirBtnPopup = confirBtnPopup;
	}
	public WebElement getConfirOkBtn() {
		return confirOkBtn;
	}
	public void setConfirOkBtn(WebElement confirOkBtn) {
		this.confirOkBtn = confirOkBtn;
	}
	public WebElement getItemTypeDrop() {
		return itemTypeDrop;
	}
	public void setItemTypeDrop(WebElement itemTypeDrop) {
		this.itemTypeDrop = itemTypeDrop;
	}
	public WebElement getItemTypeDropOption() {
		return itemTypeDropOption;
	}
	public void setItemTypeDropOption(WebElement itemTypeDropOption) {
		this.itemTypeDropOption = itemTypeDropOption;
	}
	public WebElement getItemSubTypeDropNew() {
		return itemSubTypeDropNew;
	}
	public void setItemSubTypeDropNew(WebElement itemSubTypeDropNew) {
		this.itemSubTypeDropNew = itemSubTypeDropNew;
	}
	public WebElement getOptionOnSearch() {
		return optionOnSearch;
	}
	public void setOptionOnSearch(WebElement optionOnSearch) {
		this.optionOnSearch = optionOnSearch;
	}
	public WebElement getPricelistName() {
		return pricelistName;
	}
	public void setPricelistName(WebElement pricelistName) {
		this.pricelistName = pricelistName;
	}
	public WebElement getPricelistCode() {
		return pricelistCode;
	}
	public void setPricelistCode(WebElement pricelistCode) {
		this.pricelistCode = pricelistCode;
	}
	public WebElement getFromDate() {
		return fromDate;
	}
	public void setFromDate(WebElement fromDate) {
		this.fromDate = fromDate;
	}
	public By getTodayDateLocator() {
		return todayDateLocator;
	}
	public void setTodayDateLocator(By todayDateLocator) {
		this.todayDateLocator = todayDateLocator;
	}
	public WebElement getItemDropIcon() {
		return itemDropIcon;
	}
	public void setItemDropIcon(WebElement itemDropIcon) {
		this.itemDropIcon = itemDropIcon;
	}
	public WebElement getItemDropOption() {
		return itemDropOption;
	}
	public void setItemDropOption(WebElement itemDropOption) {
		this.itemDropOption = itemDropOption;
	}
	public WebElement getMrp() {
		return mrp;
	}
	public void setMrp(WebElement mrp) {
		this.mrp = mrp;
	}
	public WebElement getAdd() {
		return add;
	}
	public void setAdd(WebElement add) {
		this.add = add;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void setSubmitBtn(WebElement submitBtn) {
		this.submitBtn = submitBtn;
	}
	public WebElement getSuccesssMsgElement() {
		return successsMsgElement;
	}
	public void setSuccesssMsgElement(WebElement successsMsgElement) {
		this.successsMsgElement = successsMsgElement;
	}
	public WebElement getListPageEditBtn() {
		return listPageEditBtn;
	}
	public void setListPageEditBtn(WebElement listPageEditBtn) {
		this.listPageEditBtn = listPageEditBtn;
	}
	public WebElement getGlobalSearchBtn() {
		return globalSearchBtn;
	}
	public void setGlobalSearchBtn(WebElement globalSearchBtn) {
		this.globalSearchBtn = globalSearchBtn;
	} 
	
	
	
	//Getters and Setters
	
	 	
}
