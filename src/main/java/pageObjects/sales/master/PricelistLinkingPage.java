package pageObjects.sales.master;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import integrationFlowPack.SalesModuleFlow.setupFlow.SetUp;
import utils.FormLabels;
import utils.InputUtility;
import utils.PropertyReader;
import utils.WaitHelper;
import utils.WaitUtilityDuplicate;


public class PricelistLinkingPage{
WebDriver driver;
PropertyReader prop;
	private static final Logger logger = LogManager.getLogger(PricelistLinkingPage.class); 
	
	
	public PricelistLinkingPage(WebDriver driver) {
		this.driver=driver;
		this.prop = new PropertyReader("salesModule/PricelistLinkingTestData.properties"); 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(@class,'fs-12') and contains(normalize-space(.), 'Price List Linking')]")
	private WebElement pricelistPartyLink;
	@FindBy(xpath="//div[contains(@class,'igx-dialog__window-title') and normalize-space(text())='Confirmation']")
	private WebElement confPopup;
	@FindBy(xpath="//button[contains(@class,'igx-button') and normalize-space(text())='OK']")
	private WebElement ConOkBtn;
	@FindBy(xpath="//label[normalize-space(text())='Item Type']/following::igx-icon[contains(., 'expand_more')][1]")
	private WebElement itemTypeDrop;
	@FindBy(xpath="//igx-combo-item[contains(@id,'igx-drop-down-item')]//span[contains(@class,'ng-star-inserted') and normalize-space(text())='FINISHED GOODS']")
	private WebElement itemTypeDropOption;
	@FindBy(xpath="//label[normalize-space(text())='Item Sub Type']/following::igx-icon[contains(., 'expand_more')][1]")
	private WebElement itemSubTypeDrop;
	@FindBy(xpath="//igx-combo-item//span[normalize-space(text())='All']")
	private WebElement itemSubTypeDropOption;
	@FindBy(xpath="//label[normalize-space(text())='Price List']/following::igx-icon[contains(., 'expand_more')][1]")
	private WebElement pricelistDrop;
	@FindBy(xpath="//span[normalize-space(text())='Reliance - Version 0']")
	private WebElement pricelistOption;
	@FindBy(xpath="//app-g-switch-tab[contains(@class,'h-100')]//app-g-label[normalize-space(text())='Search Parties']")
	private WebElement searchPartiesTab;
	@FindBy(xpath="//div[contains(@class ,'igx-input-group__bundle')]//input[starts-with(@id,'l_sppt_partyname') and contains(@class,'igx-input-group__input')]")
	private WebElement partyName;
	@FindBy(xpath="//div[contains(@class,'igx-input-group__bundle')]//input[starts-with(@id,'l_sppt_partycode') and contains(@class,'igx-input-group__input')]")
	private WebElement partyCode;
	By dotSpinner = By.xpath("/html/body/app-root/div/div/div/div/div");
	@FindBy(xpath="(//igx-grid-row[contains(@class,'igx-grid__tr') and @data-rowindex='0']//span[@class='igx-checkbox__composite'])[1]")
	private WebElement checkbox;
	
	
	public void clickPricelistPartyLink() {		 
		//logger.info("Entering Party Name");
		WaitHelper.waitForClickable(driver, pricelistPartyLink, 10);
		pricelistPartyLink.click();
		WaitHelper.waitForVisible(driver, confPopup, 10);
		WaitHelper.waitForClickable(driver, ConOkBtn, 10);
		ConOkBtn.click();
	}
	
	
	public void selectItemtype(String itemTypeLabel,String itemTypeOpt) {
		    String DropDownXpath = "//label[text()='Item Type']/following::igx-icon[1]";
		    By xpath=By.xpath(DropDownXpath);
			WaitHelper.waitForClickable(driver, xpath, 10);
			WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, itemTypeLabel, itemTypeOpt);
		    //UtilityDuplicate.selectFromComboWithoutSearch(driver, ,itemTypeLabel,itemTypeOpt);
	}
	
	public void selectItemSubtype(String itemSubTypeLabel,String itemSubTypeOpt) {
		    String DropDownXpath = "//label[text()='Item Sub Type']/following::igx-icon[1]";
		    By xpath=By.xpath(DropDownXpath);
		    WaitHelper.waitForClickable(driver, xpath, 10);
			WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, itemSubTypeLabel, itemSubTypeOpt);
	}
	
	public void selectkPricelistDrop(String pricelistLabel,String pricelistOpt) {	
		    String pricelistDropDXpath = "//label[text()='Price List']/following::igx-icon[1]";
		    
		    WebElement pricelistDropD = driver.findElement(By.xpath(pricelistDropDXpath));
		    WaitHelper.waitForClickable(driver, pricelistDropD, 10);
		    WaitUtilityDuplicate.selectFromComboWithoutSearch(driver, pricelistLabel, pricelistOpt);
	}
	
	public void clickSearchParty() throws InterruptedException {
		By linkedTabActice = By.xpath("//div[contains(@class,'igx-tabs__header-active-indicator')]");
		
		WaitHelper.waitForPresenceOfElementLocated(driver, linkedTabActice, 10);
		logger.info("Linked Parties tab is now active.");
		logger.info("searching Party Name");
		logger.info("ing for loader to disappear before clicking Create New button");
		WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		Thread.sleep(400);
		searchPartiesTab.click();
	}
	
	public void enterPartyName() {	 
		//logger.info("Entering Party Name");
		//.until(ExpectedConditions.elementToBeClickable(partyName)).click();
		String partyNameInput=prop.getProperty("partyName");
		InputUtility.enterValueByLabel(driver,FormLabels.getPartynamelabel(),partyNameInput);	
	}
	
	public void clickCheckBox() { 
		logger.info("clicking checkbox");
		 WaitHelper.waitForClickable(driver, checkbox, 10);
		 checkbox.click();
	}


	public PropertyReader getProp() {
		return prop;
	}


	public void setProp(PropertyReader prop) {
		this.prop = prop;
	}


	public WebElement getPricelistPartyLink() {
		return pricelistPartyLink;
	}


	public void setPricelistPartyLink(WebElement pricelistPartyLink) {
		this.pricelistPartyLink = pricelistPartyLink;
	}


	public WebElement getConfPopup() {
		return confPopup;
	}


	public void setConfPopup(WebElement confPopup) {
		this.confPopup = confPopup;
	}


	public WebElement getConOkBtn() {
		return ConOkBtn;
	}


	public void setConOkBtn(WebElement conOkBtn) {
		ConOkBtn = conOkBtn;
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


	public WebElement getItemSubTypeDrop() {
		return itemSubTypeDrop;
	}


	public void setItemSubTypeDrop(WebElement itemSubTypeDrop) {
		this.itemSubTypeDrop = itemSubTypeDrop;
	}


	public WebElement getItemSubTypeDropOption() {
		return itemSubTypeDropOption;
	}


	public void setItemSubTypeDropOption(WebElement itemSubTypeDropOption) {
		this.itemSubTypeDropOption = itemSubTypeDropOption;
	}


	public WebElement getPricelistDrop() {
		return pricelistDrop;
	}


	public void setPricelistDrop(WebElement pricelistDrop) {
		this.pricelistDrop = pricelistDrop;
	}


	public WebElement getPricelistOption() {
		return pricelistOption;
	}


	public void setPricelistOption(WebElement pricelistOption) {
		this.pricelistOption = pricelistOption;
	}


	public WebElement getSearchPartiesTab() {
		return searchPartiesTab;
	}


	public void setSearchPartiesTab(WebElement searchPartiesTab) {
		this.searchPartiesTab = searchPartiesTab;
	}


	public WebElement getPartyName() {
		return partyName;
	}


	public void setPartyName(WebElement partyName) {
		this.partyName = partyName;
	}


	public WebElement getPartyCode() {
		return partyCode;
	}


	public void setPartyCode(WebElement partyCode) {
		this.partyCode = partyCode;
	}


	public By getDotSpinner() {
		return dotSpinner;
	}


	public void setDotSpinner(By dotSpinner) {
		this.dotSpinner = dotSpinner;
	}


	public WebElement getCheckbox() {
		return checkbox;
	}


	public void setCheckbox(WebElement checkbox) {
		this.checkbox = checkbox;
	}
	
	
		
	//Getters and Setters
	
	
}