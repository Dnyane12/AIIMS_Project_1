package pageObjects.inventory.master;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.ElementClickInterceptedException;
import java.time.Duration;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Step;
import utils.WaitUtilityDuplicate;
import utils.SimpleDropUtil;
import utils.WaitHelper;

public class PurchaseOrderPages {
    WebDriver driver;
	public static final Logger logger = LogManager.getLogger(PurchaseOrderPages.class);
	
	
	public PurchaseOrderPages(WebDriver driver) {
		logger.info("called PurchaseOrderPages constructor in PurchaseOrderPages");
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	By purchaseSubModLink=By.xpath("//igx-nav-drawer[@id='project-menu']//span[contains(text(),'Purchase')]");

	By purchaseOrderLinkBy = By.xpath("//span[contains(normalize-space(.),'Purchase Order') and contains(@class,'fs-12')]");

	By dotSpinner  = By.xpath("//div[@class='dot-spinner']");

	@FindBy(xpath="//button[normalize-space(text())='Create New' and contains(@class,'icon-button')]")
	private WebElement createNewButton;

	By SeriesDropdownField=By.xpath("(//label[normalize-space(text())='Series' and contains(@id,'igx-label')]/following::input[@class='igx-input-group__input'])[1]");

	By seriesOptField =By.xpath("(//span[normalize-space(text())='Purchase Order'])[2]");
	@FindBy(xpath="//div[@class='igx-combo__content']//span[normalize-space(text())='Purchase Order']")
	private WebElement SeriesDropFieldOpt;


	@FindBy(xpath="(//label[normalize-space(text())='Party' and contains(@id,'igx-label')]/following::input[@role='combobox'])[1]")
	private WebElement partyDropdown;

	@FindBy(xpath="//span[normalize-space(text())='SUP0000199 - MACK STEEL CO']")
	private WebElement partyDropOptField;

	@FindBy(xpath="(//label[normalize-space(text())='Dispatch Mode' and contains(@id,'igx-label')]/following::input[@role='combobox'])[1]")
	private WebElement dispatchModeDropdown;


	@FindBy(xpath="//span[contains(normalize-space(text()),'Rail')]")
	private WebElement disModeOptField;

	@FindBy(xpath="(//label[normalize-space(text())='Delivery Date']/following::input[@class='igx-date-picker__input-date igx-input-group__input'])[1]")
	private WebElement deliveryDate;


	@FindBy(xpath="//input[contains(@id,'l_poh_delivery_at')]")
	private WebElement deliveryAt;


	@FindBy(xpath="//input[contains(@id,'l_poh_delivery_point')]")
	private WebElement deliveryPoint;

	@FindBy(xpath="//input[contains(@id,'l_poh_pref_transporter')]")
	private WebElement PreferredTransporter;


	@FindBy(xpath="//app-g-label[normalize-space(text())='ITEM DETAILS']")
	private WebElement itemDtlTab;


	@FindBy(xpath="(//label[normalize-space(text())='Item' and contains(@id,'igx-label')]/following::input[@role='combobox'])[1]")
	private WebElement itemDropdown;


	@FindBy(xpath="//span[contains(normalize-space(text()),'GASKET')]")
	private WebElement itemDropdownOptField;

	@FindBy(xpath="//input[contains(@id,'l_pod_qty')]")
	private WebElement quantity;

	@FindBy(xpath="//input[contains(@id,'l_pod_rate')]")
	private WebElement rate;

	@FindBy(xpath="//input[contains(@id,'l_pod_discount_per')]")
	private WebElement discount;

	@FindBy(xpath="//input[contains(@id,'l_pod_pkg_forwd_amout')]")
	private WebElement pkgForward;


	@FindBy(xpath="//button[normalize-space(text())='Add' and @id='l_po_create_btn-width-selector']")
	private WebElement addButtonItemDtl;


	@FindBy(xpath="//app-g-label[normalize-space(text())='TERMS AND CONDITIONS']")
	private WebElement termConTab;

	@FindBy(xpath="(//label[normalize-space(text())='Terms and Conditions' and contains(@id,'igx-label')]/following::input[@role='combobox'])[1]")
	private WebElement termsAndConDrop;


	@FindBy(xpath="//span[normalize-space(text())='Delivery within 2 days of PO']")
	private WebElement termsAndConDropOptField;

	@FindBy(xpath="//app-g-label[normalize-space(text())='PAYMENT TERMS']")
	private WebElement paymentTermTab;

	@FindBy(xpath="(//label[normalize-space(text())='Payment Term' and contains(@id,'igx-label')]/following::input[@role='combobox'])[1]")
	private WebElement paymentTermDrop;


	@FindBy(xpath="//span[normalize-space(text())='Advance Payment X %']")
	private WebElement paymentTermDropOptField;

	@FindBy(xpath="(//input[contains(@id,'l_popt_param')])[1]")
	private WebElement x;


	@FindBy(xpath="(//input[contains(@id,'l_popt_param')])[2]")
	private WebElement y;

	@FindBy(xpath="//button[normalize-space(text())='Add' and contains(@id,'l_po_tnc_create_btn-width-selector')]")
	private WebElement addButtonTerConTab;


	@FindBy(xpath="//button[contains(@id,'l_po_payment_term_create_btn-width-selector')]")
	private WebElement paymentTermAddBtn;


	@FindBy(xpath="//button[contains(@id,'l_po_payment_term_reset_btn-width-selector')]")
	private WebElement resetBtnPayTerm;


	@FindBy(xpath="//button[contains(@id,'l_po_reset_btn-width-selector')]")
	private WebElement resetBtnItemDtl;


	@FindBy(xpath="//igx-icon[contains(@class,'material-icons')]/following::igx-icon[normalize-space(text())='edit']")
	private List<WebElement> editBtns;


	@FindBy(xpath="//igx-icon[contains(@class,'material-icons')]/following::igx-icon[normalize-space(text())='delete']")
	private List<WebElement> deleteBtns;


	@FindBy(xpath="//button[normalize-space(text())='Back' and @id='l_action_back_btn-width-selector']")
	private WebElement backBtn;



	@FindBy(xpath="//button[normalize-space(text())='Draft' and @id='l_action_draft_btn-width-selector']")
	private WebElement draftBtn;


	@FindBy(xpath="//button[normalize-space(text())='Submit' and @id='l_action_save_btn-width-selector']")
	private WebElement submitBtn;



	@FindBy(xpath="//button[normalize-space(text())='Reset' and @id='l_action_reset_btn-width-selector']")
	private WebElement resetBtn;


	@FindBy(xpath="(//igx-icon[contains(@class,'material-icons')])[24]")
	private WebElement editIcon;


	@FindBy(xpath="//button[normalize-space(text())='Update' and @id='l_action_update_btn-width-selector'")
	private WebElement updateBtn;


	@FindBy(xpath="//div[@class='igx-snackbar__message' and contains(normalize-space(text()),'Purchase Order Update successfully,ID:')]")
	private WebElement updateSuccMsg;

	@FindBy(xpath="//div[@class='igx-snackbar__message' and contains(normalize-space(text()),'Purchase Order Save successfully,ID:')]")
	private WebElement saveSuccMsg;

	@FindBy(xpath="//input[contains(@id,'l_pod_qty')]")
	private WebElement poQtyEntered;

	@FindBy(xpath="//input[contains(@id,'l_pod_rate')]")
	private WebElement poRateEntered;

	@FindBy(xpath="//input[contains(@id,'l_pod_gross_amount')]")
	private WebElement poGrossAmt;


	@FindBy(xpath="//input[contains(@id,'l_pod_cgst_per_taxm')]")
	private WebElement poCgst;


	@FindBy(xpath="//input[contains(@id,'l_pod_sgst_per_taxm')]")
	private WebElement poSgst;


	@FindBy(xpath="//input[contains(@id,'l_pod_net_amount')]")
	private WebElement poNetAmount;


	@FindBy(xpath="//label[contains(normalize-space(text()),'SGST') and contains(@id,'igx-label')]")
	private WebElement sgstLabel;


	@FindBy(xpath="//label[contains(normalize-space(text()),'SGST') and contains(@id,'igx-label')]")
	private WebElement cgstLabel;

	public void clickPurSubModAndPOLink() {
	    logger.info("Waiting and Clicking voucherLink");    
	    WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 20);    
	    WaitHelper.waitForRefreshAndClick(driver,purchaseSubModLink,10);

	    // Use robust waitForRefreshAndClick for the Purchase Order link as well
	    WaitHelper.waitForRefreshAndClick(driver, purchaseOrderLinkBy, 10);
	}

	public void clickCreateNewBtn() {
	    //WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
		WaitHelper.waitForClickable(driver, createNewButton, 10);
		createNewButton.click();
	}

	public void selectSeries(String option) {	
		 WaitHelper.safeClick(driver, driver.findElement(SeriesDropdownField));
		driver.findElement(SeriesDropdownField).sendKeys(option);
		
		WaitHelper.waitForClickable(driver, seriesOptField, 20);
		driver.findElement(seriesOptField).click();
		//SimpleDropUtil.selectDropOption(driver,SeriesDropdownField,SeriesDropFieldOpt,option);
	}

	public void selectParty(String PartyDropOption) {
		WaitHelper.waitForClickable(driver, partyDropdown, 10);
		SimpleDropUtil.selectDropOption(driver,partyDropdown,partyDropOptField,PartyDropOption);
		//UtilityDuplicate.selectFromComboWithoutSearch(driver,,partyDropLabel,PartyDropOption);	
	}

	public void selectDispatchMode(String DispatchModeDropOption) {
		WaitHelper.waitForClickable(driver, dispatchModeDropdown, 10);
		SimpleDropUtil.selectDropOption(driver,dispatchModeDropdown,disModeOptField,DispatchModeDropOption);	
	}

	public void enterDeliveryDate(String DeliveryDateValue) {
		WaitHelper.waitForClickable(driver, deliveryDate, 10);
		deliveryDate.click();
		deliveryDate.sendKeys(DeliveryDateValue);	
	}

	public void enterDeliveryAt(String DeliveryAtValue) {
		WaitHelper.waitForClickable(driver, deliveryAt, 10);
		deliveryAt.click();
		deliveryAt.sendKeys(DeliveryAtValue);	
	}

	public void enterDeliveryPoint(String DeliveryPointValue) {
		WaitHelper.waitForClickable(driver, deliveryPoint, 10);
		deliveryPoint.click();
		deliveryPoint.sendKeys(DeliveryPointValue);	
	}

	public void enterPreferredTran(String PreferredTransValue) {
		WaitHelper.waitForClickable(driver, PreferredTransporter, 10);
		PreferredTransporter.click();
		PreferredTransporter.sendKeys(PreferredTransValue);	
	}

	public void selectItem(String ItemDropOption) {
		WaitHelper.waitForClickable(driver, itemDropdown, 10);	
		SimpleDropUtil.selectDropOption(driver,itemDropdown,itemDropdownOptField,ItemDropOption);	
	}

	public void enterQuantity(String QuantityValue) {
		WaitHelper.waitForClickable(driver, quantity, 10);
		quantity.click();
		System.out.println("QuantityValue:"+QuantityValue);
		quantity.sendKeys(QuantityValue);	
	}

	public void enterRate(String rateValue) {
		WaitHelper.waitForClickable(driver, rate, 10);
		rate.click();
		rate.sendKeys(rateValue);	
	}

	public void enterDiscount(String discountValue) {
		WaitHelper.waitForClickable(driver, discount, 10);
		discount.click();
		discount.sendKeys(discountValue);	
	}

	public void enterPkgForword(String pkgForwordValue) {
		WaitHelper.waitForClickable(driver, pkgForward, 10);
		pkgForward.click();
		pkgForward.sendKeys(pkgForwordValue);	
	}

	public void selectPaymentTerm(String PaymentTermDropOption) {
		WaitHelper.waitForClickable(driver, paymentTermDrop, 10);
		SimpleDropUtil.selectDropOption(driver,paymentTermDrop,paymentTermDropOptField,PaymentTermDropOption);	
	}

	public void enterX(String xValue) {
		WaitHelper.waitForClickable(driver, x, 10);
		 x.click();
		x.sendKeys(xValue);
	}

	public void enterY(String yValue) {
		WaitHelper.waitForClickable(driver, y, 10);
	    y.click();
		y.sendKeys(yValue);
	}

	public void enterAddButtonItemDtl() {
		WaitHelper.waitForClickable(driver, addButtonItemDtl, 10);
		addButtonItemDtl.click();
	}

	public void enterAddButtonTerConTab() {
		WaitHelper.waitForClickable(driver, addButtonTerConTab, 10);
		addButtonTerConTab.click();
	}

	public void selectTermCondDrop(String TermsAndConDropOption) {
		WaitHelper.waitForClickable(driver, termsAndConDrop, 10);
		SimpleDropUtil.selectDropOption(driver,termsAndConDrop,termsAndConDropOptField,TermsAndConDropOption);	
	}

	public void clickItemDetailTab() {
		WaitHelper.waitForClickable(driver, itemDtlTab, 10);
		itemDtlTab.click();
	}

	public void clickTermConTab() {
		WaitHelper.waitForClickable(driver, termConTab, 10);
		termConTab.click();
	}

	public void clickPayTermTab() {
		WaitHelper.waitForClickable(driver, paymentTermTab, 10);
		paymentTermTab.click();
	}

	public void clickPaymentTermAddBtn() {
		WaitHelper.waitForClickable(driver, paymentTermAddBtn, 10);
		paymentTermAddBtn.click();
	}

	public void clickSubmitBtn() {
		WaitHelper.waitForClickable(driver, submitBtn, 10);
		submitBtn.click();
	}

	public void clickEditIcon(){
		WaitHelper.waitForClickable(driver, editIcon, 10);
		editIcon.click();
	}

	public void clickUpdateBtn() {
		WaitHelper.waitForClickable(driver, updateBtn, 10);	
		updateBtn.click();
	}

	public String getUpdateSucMsgText() {
	WaitHelper.waitForClickable(driver, updateSuccMsg, 10);	
	String upSuccusessMsg= updateSuccMsg.getText();
	return upSuccusessMsg;
	}

//Purchase Order Save successfully,ID:
	public String getSaveSucMsgText() {
	WaitHelper.waitForVisible(driver, saveSuccMsg, 10);	
	String saveSuccusessMsg= saveSuccMsg.getText();

	String poNo= saveSuccusessMsg != null ? saveSuccusessMsg.replaceAll(".*ID:\\s*", "").trim() : "";

	System.out.println("poNo: "+poNo);
	System.out.println("saveSuccusessMsg in page class: "+saveSuccusessMsg);
	return saveSuccusessMsg;
	}

	@Step("Extract PO No")
	public String getPoNo() {
	WaitHelper.waitForVisible(driver, saveSuccMsg, 10);	
	String saveSuccusessMsg= saveSuccMsg.getText();

	String poNo= saveSuccusessMsg != null ? saveSuccusessMsg.replaceAll(".*ID:\\s*", "").trim() : "";
	System.out.println("poNo: "+poNo);

	return poNo;
	}

	// Getters for all By/WebElement/List fields
	public By getPurchaseSubModLink() { return purchaseSubModLink; }
	public By getPurchaseOrderLinkBy() { return purchaseOrderLinkBy; }
	public By getDotSpinner() { return dotSpinner; }

	public WebElement getCreateNewButton() { return createNewButton; }
	public By getSeriesDropdownField() { return SeriesDropdownField; }
	public By getSeriesOptField() { return seriesOptField; }
	public WebElement getSeriesDropFieldOpt() { return SeriesDropFieldOpt; }

	public WebElement getPartyDropdown() { return partyDropdown; }
	public WebElement getPartyDropOptField() { return partyDropOptField; }
	public WebElement getDispatchModeDropdown() { return dispatchModeDropdown; }
	public WebElement getDisModeOptField() { return disModeOptField; }

	public WebElement getDeliveryDate() { return deliveryDate; }
	public WebElement getDeliveryAt() { return deliveryAt; }
	public WebElement getDeliveryPoint() { return deliveryPoint; }
	public WebElement getPreferredTransporter() { return PreferredTransporter; }

	public WebElement getItemDtlTab() { return itemDtlTab; }
	public WebElement getItemDropdown() { return itemDropdown; }
	public WebElement getItemDropdownOptField() { return itemDropdownOptField; }

	public WebElement getQuantity() { return quantity; }
	public WebElement getRate() { return rate; }
	public WebElement getDiscount() { return discount; }
	public WebElement getPkgForward() { return pkgForward; }

	public WebElement getAddButtonItemDtl() { return addButtonItemDtl; }
	public WebElement getTermConTab() { return termConTab; }
	public WebElement getTermsAndConDrop() { return termsAndConDrop; }
	public WebElement getTermsAndConDropOptField() { return termsAndConDropOptField; }

	public WebElement getPaymentTermTab() { return paymentTermTab; }
	public WebElement getPaymentTermDrop() { return paymentTermDrop; }
	public WebElement getPaymentTermDropOptField() { return paymentTermDropOptField; }

	public WebElement getX() { return x; }
	public WebElement getY() { return y; }
	public WebElement getAddButtonTerConTab() { return addButtonTerConTab; }
	public WebElement getPaymentTermAddBtn() { return paymentTermAddBtn; }
	public WebElement getResetBtnPayTerm() { return resetBtnPayTerm; }
	public WebElement getResetBtnItemDtl() { return resetBtnItemDtl; }

	public List<WebElement> getEditBtns() { return editBtns; }
	public List<WebElement> getDeleteBtns() { return deleteBtns; }

	public WebElement getBackBtn() { return backBtn; }
	public WebElement getDraftBtn() { return draftBtn; }
	public WebElement getSubmitBtn() { return submitBtn; }
	public WebElement getResetBtn() { return resetBtn; }

	public WebElement getEditIcon() { return editIcon; }
	public WebElement getUpdateBtn() { return updateBtn; }

	public WebElement getUpdateSuccMsg() { return updateSuccMsg; }
	public WebElement getSaveSuccMsg() { return saveSuccMsg; }

	public WebElement getPoQtyEntered() { return poQtyEntered; }
	public WebElement getPoRateEntered() { return poRateEntered; }
	public WebElement getPoGrossAmt() { return poGrossAmt; }
	public WebElement getPoCgst() { return poCgst; }
	public WebElement getPoSgst() { return poSgst; }
	public WebElement getPoNetAmount() { return poNetAmount; }

	public WebElement getSgstLabel() { return sgstLabel; }
	public WebElement getCgstLabel() { return cgstLabel; }

	//...existing code
}