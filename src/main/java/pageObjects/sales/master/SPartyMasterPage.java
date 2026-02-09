package pageObjects.sales.master;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;
import utils.WaitUtilityDuplicate;

public class SPartyMasterPage{
WebDriver driver;
private static final Logger logger = LogManager.getLogger(SPartyMasterPage.class); 



	public SPartyMasterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	//Locating partymaster
	@FindBy(xpath="//span[contains(normalize-space(text()),'Party Master')]")
	private
	WebElement partyMasterLink;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/app-breadcrum/div/div[2]/div[2]/div/div/button")
	private
	WebElement createNewBtn;  
    By dotSpinner = By.xpath("/html/body/app-root/div/div/div/div/div");        
    @FindBy(xpath="/html/body/app-root/div/div/div/div/div")
    private WebElement dotSpinnerPartySubType;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/div/div/div/app-g-combo-all-simplbox[2]/div/igx-simple-combo/igx-input-group/div[1]/div[5]/igx-suffix/igx-icon")
    private WebElement partySubTypeDrop;
    @FindBy(xpath="/html/body/div/div/div/div/div/div/igx-display-container/igx-combo-item[2]/span/div/span")
    private WebElement partySubTypeDropOption;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/div/div/div/app-g-text-all-inputtext[1]/div/igx-input-group/div[1]/div[3]/input")
    private WebElement partyName;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/div/div/div/app-g-text-all-inputtext[3]/div/igx-input-group/div[1]/div[3]/input")
	private WebElement partyaOrAccountCode;
    @FindBy(xpath="//label[normalize-space(text())='Account Group']/following::igx-icon[contains(., 'expand_more')][1]")
    private WebElement accountGroup;
    @FindBy(xpath="//igx-combo-item[starts-with(@id,'igx-drop-down-item')]//span[normalize-space(text())='Debtors For Bulk business']")
    private WebElement accountGroupOption;
    //basic Info Tab locators and webElement fields
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[1]/div/div[1]/app-g-combo-all-simplbox[1]/div/igx-simple-combo/igx-input-group/div[1]/div[5]/igx-suffix/igx-icon")
    private WebElement companyTypeDrop;
    @FindBy(xpath="//span[normalize-space(text())='Company']")
    private WebElement companyTypeDropOption;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[1]/div/div[1]/app-g-combo-all-simplbox[2]/div/igx-simple-combo/igx-input-group/div[1]/div[5]/igx-suffix/igx-icon")
    private WebElement gstTypeDrop;
    @FindBy(xpath="//span[normalize-space(text())='Registered']")
    private WebElement gstTypeDropOption;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[1]/div/div[1]/app-g-custom-regex-inputtext/div/igx-input-group/div[1]/div[3]/input")
    private WebElement gstNo;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[1]/div/div[1]/app-g-chkbox-all-checkbox[2]/div/igx-checkbox/div/span/svg")
    private WebElement TCSApplicableCheckbox;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[1]/div/div[2]/app-g-custom-regex-inputtext/div/igx-input-group/div[1]/div[3]/input")
    private WebElement panNo;

   
    //Contact Person  
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[2]/div/div[1]/app-g-text-all-inputtext/div/igx-input-group/div[1]/div[3]/input")
    private WebElement contactPersonName;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[2]/div/div[1]/app-g-mobile-all-mobileno[1]/div/igx-input-group/div[1]/div[3]/input")
    private WebElement contactNo1;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[2]/div/div[2]/app-g-custom-regex-inputtext[1]/div/igx-input-group/div[1]/div[3]/input")
    private WebElement contactEmailId1;
   
    //FSSAI Detail 
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[3]/div[1]/div/app-g-text-all-inputtext/div/igx-input-group/div[1]/div[3]/input")
    private WebElement fssaiNo;
    @FindBy(xpath="//label[normalize-space(text())='FSSAI Effective From']/ancestor::div[contains(@class,'igx-input-group__bundle')]//input[contains(@class,'igx-date-picker__input-date')]")
    private WebElement fssaiEffFrom;
    @FindBy(xpath="//label[normalize-space(text())='FSSAI Effective Upto']/ancestor::div[contains(@class,'igx-input-group__bundle')]//input[contains(@class,'igx-date-picker__input-date')]")
    private WebElement fssaiEffectiveTo;

    //Address Tab
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[2]/div/div[1]/app-g-text-all-inputtext/div/igx-input-group/div[1]/div[3]/input")
    private  WebElement nameOrContactPersonName;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[3]/div[1]/div/div[1]/div/app-g-address-all-address/div/div/div[1]/app-g-text-all-textarea/div/igx-input-group/div[1]/div[3]/textarea")
    private WebElement address;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[3]/div[1]/div/div[1]/div/app-g-address-all-address/div/div/div[1]/div[2]/app-g-text-all-inputtext/div/igx-input-group/div[1]/div[3]/input")
    private WebElement city;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[3]/div[1]/div/div[1]/div/app-g-address-all-address/div/div/div[2]/div[3]/div[1]/app-g-text-all-inputtext/div/igx-input-group/div[1]/div[3]/input")
    private WebElement pin;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[3]/div[1]/div/div[1]/div/app-g-address-all-address/div/div/div[2]/div[3]/div[2]/app-g-mobile-all-mobileno/div/igx-input-group/div[1]/div[3]/input")
    private WebElement phone;
    
    //other tab
    @FindBy(xpath="//label[normalize-space(text())='Report Tag 4']/following::igx-icon[contains(., 'expand_more')][1]")
    private WebElement reportTag4Drop;
    @FindBy(xpath="//igx-combo-item//span[normalize-space(text())='Upcountry']")
    private WebElement reportTag4DropOption;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[4]/div/div/div/app-g-text-all-inputtext[3]/div/igx-input-group/div[1]/div[3]/input")
    private WebElement reportTag5;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[4]/div/div/div/app-g-text-all-inputtext[4]/div/igx-input-group/div[1]/div[3]/input")
    private WebElement billingCycle;
    //trade information tab
    
    //
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[1]/div/div/div[1]/igx-tab-header[2]/div/span")
    private WebElement bankDetailsTab; 
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[1]/div/div/div[1]/igx-tab-header[3]/div/span")
    private WebElement addressTab;
    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[1]/div/div/div[1]/igx-tab-header[4]/div/span")
    private WebElement otherTab;
    @FindBy(xpath = "//button[@id='l_action_save_btn-width-selector' and @name='l_action_save_btn']")
	private WebElement submitBtn;
 
    @FindBy(xpath="//label[normalize-space(.)='FSSAI Effective From']/ancestor::div[contains(@class,'igx-input-group__bundle')][1]//igx-icon[@title='Choose Date']")
    private WebElement calenderIcon;
    
    
    @FindBy(xpath="//span[contains(@class,'igx-calendar-picker__date') and normalize-space(text())='2025']")
    private WebElement calenderPopup;
    
    @FindBy(xpath="//div[contains(@class,'igx-calendar-picker__dates')]")
    private WebElement monthYearTitle;
    
    @FindBy(xpath="//igx-icon[contains(@class,'material-icons')]/following::igx-icon[normalize-space(text())='keyboard_arrow_left'][1]")
    private WebElement nextButton;
    
    @FindBy(xpath="//span[contains(@class,'igx-calendar__date-content') and normalize-space(text())='14']")
    private WebElement dayItems;
    
    @FindBy(xpath="//input[contains(@class,'is-invalid')]")
    private List<WebElement> allElements;
    
  
    public WebElement getPartyMstPage() {
		return partyMstPage;
	}
    
    @FindBy(xpath="(//label[normalize-space(text())='Name']/following::input[contains(@class,'igx-input-group__input')])[1]")
    private WebElement nameField;
    		    		
	@FindBy(xpath="//span[contains(@class,'fs-18')]")
    private WebElement partyMstPage;
    
    @FindBy(xpath="//button[normalize-space(text())='Reset']")
	private WebElement resetBtn;
    
    @FindBy(xpath="//div[contains(text(),'Party Created successfully: , Details:']")
	private WebElement succMsg;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public void clickPartyMstLink() {
		logger.info("clicking partyMasterLink");
		WaitHelper.waitForClickable(driver, partyMasterLink, 10);
	}
    
    public void clickField(String label) {
    	 By fieldXpath= By.xpath("(//label[normalize-space(text())='"+ label + "']/following::input[contains(@class,'igx-input-group__input')])[1]");
    	    
    	 WaitHelper.waitForClickable(driver,fieldXpath,10);
    	 WebElement field= driver.findElement(fieldXpath);
		  field.click();
    }
    
    
    public void clickCreateNewBtn() throws InterruptedException {
		logger.info("ing for loader to disappear before clicking Create New button");
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	    logger.info("Loader disappeared. ing for Create New button to be clickable");
	    WaitHelper.waitForClickable(driver,createNewBtn, 10);    	
	    createNewBtn.click();
	}
    
    public void clickPartySubTypeDrop() throws InterruptedException {
		
		logger.info("ing for loader to disappear before clicking Create New button");
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		
		
	    logger.info("Loader disappeared. ing for party SubTypeDrop to be clickable");
	    WaitHelper.waitForClickable(driver, partySubTypeDrop, 10);	
		Thread.sleep(1000);
		partySubTypeDrop.click();
		
		logger.info("Selecting Party SubType option");
		WaitHelper.waitForClickable(driver, partySubTypeDropOption, 10);
		partySubTypeDropOption.click();
	}
	
    public void clickPartyName(String pName) {		 
		logger.info("Entering Party Name");
		WaitHelper.waitForClickable(driver, partyName, 10);	
		partyName.click();
		partyName.sendKeys(pName);
		
	}
    public void enterPartyOrAccountCode(String partyCode) {
		 logger.info("Selecting Account Group");
		 WaitHelper.waitForClickable(driver, partyaOrAccountCode, 10);
		 partyaOrAccountCode.click();	
		partyaOrAccountCode.sendKeys(partyCode);
	}
    public void clickAccountGroup(String AccountGrpLbl ,String AccountGrpOpt) {
    	WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, AccountGrpLbl, AccountGrpOpt);
        //UtilityDuplicate.selectFromComboWithoutSearch(driver, , AccountGrpLbl, AccountGrpOpt);		
	}
	
    public void clickCompanyTypeDrop(String companyTypeLabel,String companyTypeOPt) {
    	WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, companyTypeLabel, companyTypeOPt);
		 //UtilityDuplicate.selectFromComboWithoutSearch(driver, , AccountGrpLbl, AccountGrpOpt);
	}
	
    public void clickGstTypeDrop(String GstTypeLabel, String GstTypeOpt) {
    	WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, GstTypeLabel, GstTypeOpt);
		//UtilityDuplicate.selectFromComboWithoutSearch(driver, , GstTypeLabel, GstTypeOpt);
	}
    
    public void clickGstNo(String GSTNo) {
    	WaitHelper.waitForClickable(driver, gstNo, 10);
    	gstNo.click();
    	gstNo.sendKeys(GSTNo);	
	}
	
    public void clickFssaiNo(String fssaiNum) {
    	WaitHelper.waitForClickable(driver, fssaiNo, 10);
    	fssaiNo.click();
		fssaiNo.sendKeys(fssaiNum);		
	}
    public void clickFssaiEffFrom(String fssaiEfFrom) {
    	WaitHelper.waitForClickable(driver, fssaiEffFrom, 10);
    	fssaiEffFrom.click();
		fssaiEffFrom.sendKeys(fssaiEfFrom);
		//CalenderDateUtility.selectDate(driver,"14","Jul","2025","FSSAI Effective From");	
		
	}
    public void clickFssaiEffectiveTo(String fssaiEfUpto) {
    	WaitHelper.waitForClickable(driver, fssaiEffectiveTo, 10);
    	fssaiEffectiveTo.click();
		fssaiEffectiveTo.sendKeys(fssaiEfUpto);	
		//CalenderDateUtility.selectDate(driver,"30","Jul","2026","FSSAI Effective Upto");
	}
	
    public void clickNameOrContactPersonName(String CName) {
    	WaitHelper.waitForClickable(driver, nameOrContactPersonName, 10);
    	nameOrContactPersonName.click();
		nameOrContactPersonName.sendKeys(CName);
		
	}
    public void clickAddress(String address1) {
    	WaitHelper.waitForClickable(driver, address, 10);
    	address.click();
		address.sendKeys(address1);
		
	}
    public void clickcity(String city1) {
    	WaitHelper.waitForClickable(driver, city, 10);
    	city.click();
		city.sendKeys(city1);
	}
	
    public void clickPin() {
    	WaitHelper.waitForClickable(driver, pin, 10);
    	pin.click();
		pin.sendKeys("322311");
	}
	
	/*
	 * private void clickPhone(String contactNo) {
	 * .until(ExpectedConditions.elementToBeClickable(phone)).click();
	 * phone.sendKeys(contactNo); }
	 */
	
    public void clickReportTag4Drop(String reportTag4Label,String reportTag4Opt) {
    	WaitHelper.waitForClickable(driver, reportTag4Drop, 10);
		//UtilityDuplicate.selectFromComboWithoutSearch(driver, , reportTag4Label, reportTag4Opt);	
    	WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, reportTag4Label, reportTag4Opt);
	}

    public void clickAddressTab(){
    	WaitHelper.waitForClickable(driver, addressTab, 10);
    	addressTab.click();		
	}
	
    public void clickOtherTab(){
    	WaitHelper.waitForClickable(driver, otherTab, 10);
    	otherTab.click();	
	}
    public void clickContactNo1(String contactNo){
    	WaitHelper.waitForClickable(driver, contactNo1, 10);
    	contactNo1.click();
		contactNo1.sendKeys(contactNo);
	}
	
    public void clickSubmitBtn() {
    	WaitHelper.waitForClickable(driver, submitBtn, 10);
    	submitBtn.click();
	}

	
	
	
	
	//Getter and Setter
	
	public WebElement getPartyMasterLink() {
		return partyMasterLink;
	}


	public WebElement getCreateNewBtn() {
		return createNewBtn;
	}


	public By getDotSpinner() {
		return dotSpinner;
	}


	public WebElement getDotSpinnerPartySubType() {
		return dotSpinnerPartySubType;
	}


	public WebElement getPartySubTypeDrop() {
		return partySubTypeDrop;
	}


	public WebElement getPartySubTypeDropOption() {
		return partySubTypeDropOption;
	}


	public WebElement getPartyName() {
		return partyName;
	}


	public WebElement getPartyaOrAccountCode() {
		return partyaOrAccountCode;
	}


	public WebElement getAccountGroup() {
		return accountGroup;
	}


	public WebElement getAccountGroupOption() {
		return accountGroupOption;
	}


	public WebElement getCompanyTypeDrop() {
		return companyTypeDrop;
	}


	public WebElement getCompanyTypeDropOption() {
		return companyTypeDropOption;
	}


	public WebElement getGstTypeDrop() {
		return gstTypeDrop;
	}


	public WebElement getGstTypeDropOption() {
		return gstTypeDropOption;
	}


	public WebElement getGstNo() {
		return gstNo;
	}


	public WebElement getTCSApplicableCheckbox() {
		return TCSApplicableCheckbox;
	}


	public WebElement getPanNo() {
		return panNo;
	}


	public WebElement getContactPersonName() {
		return contactPersonName;
	}


	public WebElement getContactNo1() {
		return contactNo1;
	}


	public WebElement getContactEmailId1() {
		return contactEmailId1;
	}


	public WebElement getFssaiNo() {
		return fssaiNo;
	}


	public WebElement getFssaiEffFrom() {
		return fssaiEffFrom;
	}


	public WebElement getFssaiEffectiveTo() {
		return fssaiEffectiveTo;
	}


	public WebElement getNameOrContactPersonName() {
		return nameOrContactPersonName;
	}


	public WebElement getAddress() {
		return address;
	}


	public WebElement getCity() {
		return city;
	}


	public WebElement getPin() {
		return pin;
	}


	public WebElement getPhone() {
		return phone;
	}


	public WebElement getReportTag4Drop() {
		return reportTag4Drop;
	}


	public WebElement getReportTag4DropOption() {
		return reportTag4DropOption;
	}


	public WebElement getReportTag5() {
		return reportTag5;
	}


	public WebElement getBillingCycle() {
		return billingCycle;
	}


	public WebElement getBankDetailsTab() {
		return bankDetailsTab;
	}


	public WebElement getAddressTab() {
		return addressTab;
	}


	public WebElement getOtherTab() {
		return otherTab;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	public WebElement getCalenderIcon() {
		return calenderIcon;
	}


	public WebElement getCalenderPopup() {
		return calenderPopup;
	}


	public WebElement getMonthYearTitle() {
		return monthYearTitle;
	}


	public WebElement getNextButton() {
		return nextButton;
	}


	public WebElement getDayItems() {
		return dayItems;
	}


	public List<WebElement> getAllElements() {
		return allElements;
	}

	public WebElement getNameField() {
		return nameField;
	}

	public WebElement getResetBtn() {
		return resetBtn;
	}

	public WebElement getSuccMsg() {
		return succMsg;
	}


	
	
	



	
	
	
}
