package pageObjects.inventory.master;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.WaitHelper;

public class InvPartyMasterPage {
	WebDriver driver;
	private static final Logger logger = LogManager.getLogger(InvPartyMasterPage.class); 

	
	public InvPartyMasterPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		
		
		//Locating partymaster
		@FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/app-sidebar/igx-nav-drawer/aside/div/app-menu-tree/div[2]/div/span")
		private
		WebElement partyMasterLink;
	    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/app-breadcrum/div/div[2]/div[2]/div/div/button")
		private WebElement createNewBtn;   
	    By dotSpinner = By.xpath("/html/body/app-root/div/div/div/div/div");
	    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/div/div/div/app-g-combo-all-simplbox[2]/div/igx-simple-combo/igx-input-group/div[1]/div[5]/igx-suffix/igx-icon")
	    private WebElement partySubTypeDrop;
	    @FindBy(xpath="/html/body/div/div/div/div/div/div/igx-display-container/igx-combo-item[2]/span/div/span")
	    private WebElement partySubTypeDropOption;
	    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/div/div/div/app-g-text-all-inputtext[1]/div/igx-input-group/div[1]/div[3]/input")
	    private WebElement partyName;
	    @FindBy(xpath="/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/div/div/div/app-g-text-all-inputtext[3]/div/igx-input-group/div[1]/div[3]/input")
		private
	    WebElement partyaOrAccountCode;
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
	    @FindBy(xpath="//igx-icon[normalize-space(text())='today']")
	    private WebElement fssaiEffFrom;
	    @FindBy(xpath="")
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
	 
	 
	    

	    public void clickPartyMstLink() {
			logger.info("clicking partyMasterLink");
			partyMasterLink.click();
		}
		
		
	    public void clickCreateNewBtn() throws InterruptedException {
			logger.info("ing for loader to disappear before clicking Create New button");
			WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		    logger.info("Loader disappeared. ing for Create New button to be clickable");
		    
		    WaitHelper.waitForClickable(driver, createNewBtn, 10);
		    createNewBtn.click();   	
			logger.info("clicked Create New button");
		}
	    public void clickPartySubTypeDrop() throws InterruptedException {
			
			logger.info("ing for loader to disappear before clicking Create New button");
			 WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		    logger.info("Loader disappeared. ing for party SubTypeDrop to be clickable");
		    WaitHelper.waitForClickable(driver, partySubTypeDrop, 10);
		    partySubTypeDrop.click();	
			
			logger.info("Selecting Party SubType option");
			 WaitHelper.waitForClickable(driver, partySubTypeDropOption, 10);
			 partySubTypeDropOption.click();
		}
		
		private void clickPartyName() {			 
			logger.info("Entering Party Name");
			 WaitHelper.waitForClickable(driver, partyName, 10);
			 partyName.click();
			partyName.sendKeys("SHRIRAM INDUSTRIES");
			
		}
		private void clickPartyOrAccountCode() {
			 logger.info("Selecting Account Group");
			 WaitHelper.waitForClickable(driver, partyaOrAccountCode, 10);
			 partyaOrAccountCode.click();	
			partyaOrAccountCode.sendKeys("687654e33");
		}
		private void clickAccountGroup() {
			 WaitHelper.waitForClickable(driver, accountGroup, 10);
			 accountGroup.click();
			 WaitHelper.waitForClickable(driver, accountGroupOption, 10);
			 accountGroupOption.click();
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
	        //((JavascriptExecutor) driver).executeScript("arguments[0].click();",option);
			
		}
		
		private void clickCompanyTypeDrop() {
			 WaitHelper.waitForClickable(driver, companyTypeDrop, 10);
			 companyTypeDrop.click();
			 WaitHelper.waitForClickable(driver, companyTypeDropOption, 10);
			 companyTypeDropOption.click();
		}
		
		private void clickGstTypeDrop() {
			 WaitHelper.waitForClickable(driver, gstTypeDrop, 10);
			 gstTypeDrop.click();
			 WaitHelper.waitForClickable(driver, gstTypeDropOption, 10);
			 gstTypeDropOption.click();
		}
		private void clickGstNo() {
			 WaitHelper.waitForClickable(driver, gstNo, 10);
			 gstNo.click();
			gstNo.sendKeys("27AAAAP0267H2ZN");
		}
		
		private void clickFssaiNo() {
			 WaitHelper.waitForClickable(driver, fssaiNo, 10);
			 fssaiNo.click();
			fssaiNo.sendKeys("12345678901234");
			
		}
		private void clickFssaiEffFrom() {
			 WaitHelper.waitForClickable(driver, fssaiEffFrom, 10);
			 fssaiEffFrom.click();			
		}
		private void clickFssaiEffectiveTo() {
			 WaitHelper.waitForClickable(driver, fssaiEffectiveTo, 10);
			 fssaiEffectiveTo.click();		
		}
		
		private void clickNameOrContactPersonName() {
			 WaitHelper.waitForClickable(driver, nameOrContactPersonName, 10);
			 nameOrContactPersonName.click();
			nameOrContactPersonName.sendKeys("Mahi more");
			
		}
		private void clickAddress() {
			 WaitHelper.waitForClickable(driver, address, 10);
			 address.click();
			address.sendKeys("Nagpur");
			
		}
		private void clickcity() {
			 WaitHelper.waitForClickable(driver, city, 10);
			 city.click();
			city.sendKeys("Nagpur");
		}
		
		private void clickPin() {
			 WaitHelper.waitForClickable(driver, pin, 10);
			 pin.click();
			pin.sendKeys("322311");;
		}
		private void clickPhone() {
			 WaitHelper.waitForClickable(driver, phone, 10);
			 phone.click();
			phone.sendKeys("7733337838");;
		}
		
		private void clickReportTag4Drop() {
			 WaitHelper.waitForClickable(driver, reportTag4Drop, 10);
			 reportTag4Drop.click();			
			 WaitHelper.waitForClickable(driver, reportTag4DropOption, 10);
			 reportTag4DropOption.click();			
		}

		private void clickAddressTab(){
			 WaitHelper.waitForClickable(driver, addressTab, 10);
			 addressTab.click();		
		}
		
		private void clickOtherTab(){
			 WaitHelper.waitForClickable(driver, otherTab, 10);
			 otherTab.click();	
		}
		private void clickContactNo1(){
			 WaitHelper.waitForClickable(driver, contactNo1, 10);
			 contactNo1.click();
			contactNo1.sendKeys("7646747645");
		}
}
