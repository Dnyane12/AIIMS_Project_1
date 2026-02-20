package pageObjects.production;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;

public class WorkOrderPage {
WebDriver driver;
private static final Logger logger = LogManager.getLogger(WorkOrderPage.class);


    //Constructor
	public WorkOrderPage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	//WebElements
	// ═════════════════════════════════════════════
    // SIDEBAR / NAVIGATION ELEMENTS
    // ═════════════════════════════════════════════

    @FindBy(xpath = "//igx-card[contains(@id,'igx-card')]//div[@class='justify-start']//h3[contains(normalize-space(text()),'Production')]")
    WebElement productionMenu;

    @FindBy(xpath = "//div[@class='igx-snackbar__message' and contains(text(),'Work Order Created successfully')]")
    private WebElement succMsg;
    By dotSpinner = By.xpath("//div[@class='dot-spinner']");
    By transactionMenu =By.xpath("//div[@class='mb-50']//span[@class='fs-13 menu-l1-name'][normalize-space()='Transaction']");

     By workOrderMenu =By.xpath("(//div[@class='mb-50']//span[contains(normalize-space(.),'Work Order')])[1]");

    // ═════════════════════════════════════════════
    // PAGE-LEVEL TABS
    // ═════════════════════════════════════════════

    /** "CREATE" tab button */
    @FindBy(xpath = "//button[normalize-space()='CREATE'] | //span[normalize-space()='CREATE']/parent::button")
    WebElement createTab;

    /** "SEARCH" tab button */
    @FindBy(xpath = "//button[normalize-space()='SEARCH'] | //span[normalize-space()='SEARCH']/parent::button")
    WebElement searchTab;

    // ═════════════════════════════════════════════
    // HEADER-ROW FORM FIELDS
    // ═════════════════════════════════════════════

    /** Doc Type combo (e.g. "WORK ORDER") */
    @FindBy(xpath = "//label[normalize-space()='Doc Type']/ancestor::igx-input-group//input[@role='combobox']")
    WebElement docTypeDropdown;

    /** Series combo (e.g. "Work Order Transaction") */
    @FindBy(xpath = "//label[normalize-space()='Series']/ancestor::igx-input-group//input[@role='combobox']")
    WebElement seriesDropdown;

    /** Work No. text input (auto-generated) */
    @FindBy(xpath = "//label[normalize-space()='Work No.']/ancestor::igx-input-group//input[not(@role='combobox')]")
    WebElement workNoInput;

    /** Work Date calendar icon / trigger */
    @FindBy(xpath = "//label[normalize-space()='Work Date']/ancestor::igx-input-group//igx-date-picker//igx-picker-toggle | //label[normalize-space()='Work Date']/following-sibling::*//igx-picker-toggle")
    WebElement workDateCalendarIcon;

    /** Work Date input field */
    @FindBy(xpath = "//label[normalize-space()='Work Date']/ancestor::igx-input-group//input")
    WebElement workDateInput;

    /** Work Date clear (×) button */
    @FindBy(xpath = "//label[normalize-space()='Work Date']/ancestor::igx-input-group//igx-prefix[@igxpickertogggle] | //label[normalize-space()='Work Date']/ancestor::igx-input-group//igx-suffix[contains(@class,'clear')]")
    WebElement workDateClearButton;

    // ═════════════════════════════════════════════
    // DETAIL-ROW FORM FIELDS
    // ═════════════════════════════════════════════

    /** Department combo (e.g. "DAIRY PRODUCTION") */
    @FindBy(xpath = "//label[normalize-space()='Department']/ancestor::igx-input-group//input[@role='combobox']")
    WebElement departmentDropdown;

    /** Department clear (×) button */
    @FindBy(xpath = "//label[normalize-space()='Department']/ancestor::igx-input-group//igx-suffix[@igxclearicon] | //label[normalize-space()='Department']/ancestor::igx-input-group//igx-icon[normalize-space()='clear']")
    WebElement departmentClearButton;

    /** Item combo / search */
    @FindBy(xpath = "//label[normalize-space()='Item']/ancestor::igx-input-group//input[@role='combobox']")
    WebElement itemDropdown;

    /** BOM combo */
    @FindBy(xpath = "//label[normalize-space()='BOM']/ancestor::igx-input-group//input[@role='combobox']")
    WebElement bomDropdown;

    /** Quantity numeric input */
    @FindBy(xpath = "//label[normalize-space()='Quantity']/ancestor::igx-input-group//input[not(@role='combobox')]")
    WebElement quantityInput;

    /** UOM combo */
    @FindBy(xpath = "//label[normalize-space()='UOM']/ancestor::igx-input-group//input[@role='combobox']")
    WebElement uomDropdown;

    // ═════════════════════════════════════════════
    // SECOND DETAIL-ROW FORM FIELDS
    // ═════════════════════════════════════════════

    /** Route combo */
    @FindBy(xpath = "//label[normalize-space()='Route']/ancestor::igx-input-group//input[@role='combobox']")
    WebElement routeDropdown;

    /** Work Order From Date calendar icon */
    @FindBy(xpath = "//label[contains(normalize-space(),'Work Order F')]/ancestor::igx-input-group//igx-picker-toggle | (//igx-date-picker)[1]//igx-picker-toggle")
    WebElement workOrderFromDateCalendarIcon;

    /** Work Order From Date input */
    @FindBy(xpath = "//label[contains(normalize-space(),'Work Order F')]/ancestor::igx-input-group//input")
    WebElement workOrderFromDateInput;

    /** Work Order From Date clear (×) button */
    @FindBy(xpath = "//label[contains(normalize-space(),'Work Order F')]/ancestor::igx-input-group//igx-suffix[contains(@class,'clear')] | (//igx-date-picker)[1]//igx-suffix[@igxclearicon]")
    WebElement workOrderFromDateClearButton;

    /** Work Order To Date calendar icon */
    @FindBy(xpath = "//label[contains(normalize-space(),'Work Order T')]/ancestor::igx-input-group//igx-picker-toggle | (//igx-date-picker)[2]//igx-picker-toggle")
    WebElement workOrderToDateCalendarIcon;

    /** Work Order To Date input */
    @FindBy(xpath = "//label[contains(normalize-space(),'Work Order T')]/ancestor::igx-input-group//input")
    WebElement workOrderToDateInput;

    /** Work Order To Date clear (×) button */
    @FindBy(xpath = "//label[contains(normalize-space(),'Work Order T')]/ancestor::igx-input-group//igx-suffix[contains(@class,'clear')] | (//igx-date-picker)[2]//igx-suffix[@igxclearicon]")
    WebElement workOrderToDateClearButton;

    /** Remark text input */
    @FindBy(xpath = "//label[normalize-space()='Remark']/ancestor::igx-input-group//input[not(@role='combobox')]")
    WebElement remarkInput;

    // ═════════════════════════════════════════════
    // FOOTER ACTION BUTTONS
    // ═════════════════════════════════════════════

    /** "Prev" button */
    @FindBy(xpath = "//button[normalize-space()='Prev'] | //span[normalize-space()='Prev']/parent::button")
    WebElement prevButton;

    /** "Next" button */
    @FindBy(xpath = "//button[normalize-space()='Next'] | //span[normalize-space()='Next']/parent::button")
    WebElement nextButton;

    /** "Reset" button */
    @FindBy(xpath = "//button[normalize-space()='Reset'] | //span[normalize-space()='Reset']/parent::button")
    WebElement resetButton;

    /** "Save" button */
    @FindBy(xpath = "//button[normalize-space()='Submit'] | //span[normalize-space()='Submit']/parent::button")
    WebElement submitButton;

    // ═════════════════════════════════════════════
    // SEARCH-BAR ELEMENT
    // ═════════════════════════════════════════════

    /** Top global "Work Order Search" input */
    @FindBy(xpath = "//input[contains(@placeholder,'Work Order Search')]")
    WebElement workOrderSearchBar;

    // ═══════════════════════════════════════════════════════════════
    // ACTION METHODS — NAVIGATION
    // ═══════════════════════════════════════════════════════════════

    public void clickProductionMenu() {
        WaitHelper.waitForClickable(driver, productionMenu, 10);
        productionMenu.click();
    }

    public void clickTransactionMenu() {
        WaitHelper.waitForRefreshAndClick(driver, transactionMenu, 10);
    }

    public void clickWorkOrderMenu() {
        WaitHelper.waitForRefreshAndClick(driver, workOrderMenu, 10);
    }

    // ═══════════════════════════════════════════════════════════════
    // ACTION METHODS — TABS
    // ═══════════════════════════════════════════════════════════════

    public void clickCreateTab() {
        WaitHelper.waitForClickable(driver, createTab, 10);
        createTab.click();
    }

    public void clickSearchTab() {
        WaitHelper.waitForClickable(driver, searchTab, 10);
        searchTab.click();
    }

    // ═══════════════════════════════════════════════════════════════
    // ACTION METHODS — HEADER FIELDS
    // ═══════════════════════════════════════════════════════════════

    public void selectDocType(String docType) {
        WaitHelper.waitForClickable(driver, docTypeDropdown, 10);
        docTypeDropdown.click();
        docTypeDropdown.clear();
        docTypeDropdown.sendKeys(docType);
    }

    public void selectSeries(String series) {
        WaitHelper.waitForClickable(driver, seriesDropdown, 10);
        seriesDropdown.click();
        seriesDropdown.clear();
        seriesDropdown.sendKeys(series);
    }

    public String getWorkNo() {
        WaitHelper.waitForVisible(driver, workNoInput, 10);
        return workNoInput.getAttribute("value");
    }

    public void clickWorkDateCalendar() {
        WaitHelper.waitForClickable(driver, workDateCalendarIcon, 10);
        workDateCalendarIcon.click();
    }

    public void enterWorkDate(String date) {
        WaitHelper.waitForClickable(driver, workDateInput, 10);
        workDateInput.clear();
        workDateInput.sendKeys(date);
    }

    public void clearWorkDate() {
        WaitHelper.waitForClickable(driver, workDateClearButton, 10);
        workDateClearButton.click();
    }

    // ═══════════════════════════════════════════════════════════════
    // ACTION METHODS — DETAIL-ROW FIELDS
    // ═══════════════════════════════════════════════════════════════

    public void selectDepartment(String department) {
    	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 20);
  
    	 WaitHelper.waitForVisible(driver,departmentDropdown,30);
    	JavascriptExecutor js = (JavascriptExecutor) driver;   	
        js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", departmentDropdown);
        WaitHelper.waitForClickable(driver, departmentDropdown,30);
       
        js.executeScript("arguments[0].click()", departmentDropdown);
        departmentDropdown.sendKeys(department);
        WaitHelper.selectDropDownOption(driver,department,10);
    }

    public void clearDepartment() {
        WaitHelper.waitForClickable(driver, departmentClearButton, 10);
        departmentClearButton.clear();
        departmentClearButton.click();
    }

    public void selectItem(String item) {
        WaitHelper.waitForClickable(driver, itemDropdown, 10);
        itemDropdown.click();
        itemDropdown.sendKeys(item);
        WaitHelper.selectDropDownOption(driver,item,10);
    }

    public void selectBOM(String bom) {
        WaitHelper.waitForClickable(driver, bomDropdown, 10);
        bomDropdown.click();
        bomDropdown.sendKeys(bom);
        WaitHelper.selectDropDownOption(driver,bom,10);
    }

    public void enterQuantity(String quantity) {
        WaitHelper.waitForClickable(driver, quantityInput, 10);
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public String getQuantity() {
        WaitHelper.waitForVisible(driver, quantityInput, 10);
        return quantityInput.getAttribute("value");
    }

    public void selectUOM(String uom) {
        WaitHelper.waitForClickable(driver, uomDropdown, 10);
        uomDropdown.click();
        uomDropdown.clear();
        uomDropdown.sendKeys(uom);
    }

    // ═══════════════════════════════════════════════════════════════
    // ACTION METHODS — SECOND DETAIL-ROW FIELDS
    // ═══════════════════════════════════════════════════════════════

    public void selectRoute(String route) {
        WaitHelper.waitForClickable(driver, routeDropdown, 10);
        routeDropdown.click();
        routeDropdown.clear();
        routeDropdown.sendKeys(route);
    }

    public void clickWorkOrderFromDateCalendar() {
        WaitHelper.waitForClickable(driver, workOrderFromDateCalendarIcon, 10);
        workOrderFromDateCalendarIcon.click();
    }

    public void enterWorkOrderFromDate(String date) {
        WaitHelper.waitForClickable(driver, workOrderFromDateInput, 10);
        workOrderFromDateInput.clear();
        workOrderFromDateInput.sendKeys(date);
    }

    public void clearWorkOrderFromDate() {
        WaitHelper.waitForClickable(driver, workOrderFromDateClearButton, 10);
        workOrderFromDateClearButton.click();
    }

    public void clickWorkOrderToDateCalendar() {
        WaitHelper.waitForClickable(driver, workOrderToDateCalendarIcon, 10);
        workOrderToDateCalendarIcon.click();
    }

    public void enterWorkOrderToDate(String date) {
        WaitHelper.waitForClickable(driver, workOrderToDateInput, 10);
        workOrderToDateInput.clear();
        workOrderToDateInput.sendKeys(date);
    }

    public void clearWorkOrderToDate() {
        WaitHelper.waitForClickable(driver, workOrderToDateClearButton, 10);
        workOrderToDateClearButton.click();
    }

    public void enterRemark(String remark) {
        WaitHelper.waitForClickable(driver, remarkInput, 10);
        remarkInput.clear();
        remarkInput.sendKeys(remark);
    }

    // ═══════════════════════════════════════════════════════════════
    // ACTION METHODS — FOOTER BUTTONS
    // ═══════════════════════════════════════════════════════════════

    public void clickPrev() {
        WaitHelper.waitForClickable(driver, prevButton, 10);
        prevButton.click();
    }

    public void clickNext() {
        WaitHelper.waitForClickable(driver, nextButton, 10);
        nextButton.click();
    }

    public void clickReset() {
        WaitHelper.waitForClickable(driver, resetButton, 10);
        resetButton.click();
    }

    public void clickSubmitButton() {  	
        WaitHelper.waitForClickable(driver, submitButton, 20);
        submitButton.click();
    }

    // ═══════════════════════════════════════════════════════════════
    // ACTION METHODS — GLOBAL SEARCH BAR
    // ═══════════════════════════════════════════════════════════════

    public void enterWorkOrderSearch(String searchText) {
        WaitHelper.waitForClickable(driver, workOrderSearchBar, 10);
        workOrderSearchBar.clear();
        workOrderSearchBar.sendKeys(searchText);
    }

    // ═══════════════════════════════════════════════════════════════
    // COMPOSITE / HIGH-LEVEL METHODS
    // ═══════════════════════════════════════════════════════════════

    /**
     * Navigates from the home dashboard to the Work Order Create page.
     */
    public void navigateToWorkOrderCreate() {
        clickProductionMenu();
        clickTransactionMenu();
        clickWorkOrderMenu();
        //clickCreateTab();
    }

    /**
     * Fills all mandatory header fields for a new Work Order.
     *
     * @param docType   e.g. "WORK ORDER"
     * @param series    e.g. "Work Order Transaction"
     * @param workDate  e.g. "17/Feb/2026"
     */
    
    //auto-populates this fields.
    public void fillHeaderFields(String docType, String series, String workDate) {
        selectDocType(docType);
        selectSeries(series);
        enterWorkDate(workDate);
    }

    /**
     * Fills all mandatory detail fields for a new Work Order.
     *
     * @param department e.g. "DAIRY PRODUCTION"
     * @param item       item name / code
     * @param bom        BOM name / code
     * @param quantity   numeric string e.g. "100"
     * @param uom        unit of measure e.g. "KG"
     */
    public void fillDetailFields(String department, String item, String bom,
                                  String quantity) {
        selectDepartment(department);
        selectItem(item);
        selectBOM(bom);
        enterQuantity(quantity);
    }

    /**
     * Fills the route and date range fields for a Work Order.
     * @param fromDate    work order from date e.g. "17/Feb/2026"
     * @param toDate      work order to date   e.g. "17/Feb/2026"
     */
    public void fillRouteAndDates(String fromDate,
                                   String toDate) {
        enterWorkOrderFromDate(fromDate);
        enterWorkOrderToDate(toDate);     
    }

	public By getDotSpinner() {
		return dotSpinner;
	}

	public WebElement getSuccMsg() {
		return succMsg;
	}
	
	
    
    
}
	