package pageObjects.sales.transaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitHelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

public class DirectTaxInvoicePage {
	WebDriver driver;
	private WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger(DirectTaxInvoicePage.class);
	
	public  DirectTaxInvoicePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	} 	
	
	
	@FindBy(xpath="//label[contains(text(), 'Series')]/following::input[@role='combobox'][1]")
	private WebElement seriesDrop;
	
	@FindBy(xpath="//span[contains(text(), '1-Direct Invoice')]")
	private WebElement seriesDropOptField;
	
	
	@FindBy(xpath="//label[contains(text(), 'Bill To Party')]/following::input[@role='combobox'][1]")
	private WebElement billToPartyDrop;
	
	@FindBy(xpath="//span[contains(text(), 'VIDARBHA INDUSTRIES')]")
	private WebElement billToPartyDroOptField;
	
	
	//create action methods for the above webElements
	
//	/**
//	 * Opens the series dropdown.
//	 */
//	public void openSeriesDropdown() {
//		seriesDrop.click();
//	}
//
//	/**
//	 * Selects a series option by the visible text of the option.
//	 * Uses an XPath search for a matching span and waits until it's clickable.
//	 */
//	public void selectSeries(String visibleText) {
//		seriesDrop.click();
//		By opt = By.xpath("//span[normalize-space()=" + escapeXPath(visibleText) + "]");
//		wait.until(ExpectedConditions.elementToBeClickable(opt)).click();
//	}
//
//	/**
//	 * Convenience method to select the hard-coded "1-Direct Invoice" option
//	 * (keeps existing page object field usage).
//	 */
//	public void selectDefaultSeries() {
//		seriesDrop.click();
//		wait.until(ExpectedConditions.elementToBeClickable(seriesDropOptField)).click();
//	}
//
//	public String getSelectedSeriesValue() {
//		try {
//			return seriesDrop.getAttribute("value");
//		} catch (Exception e) {
//			return null;
//		}
//	}
//
//	/**
//	 * Opens the Bill To Party dropdown.
//	 */
//	public void openBillToPartyDropdown() {
//		billToPartyDrop.click();
//	}
//
//	/**
//	 * Selects a Bill To Party option by visible text.
//	 */
//	public void selectBillToParty(String visibleText) {
//		billToPartyDrop.click();
//		By opt = By.xpath("//span[normalize-space()=" + escapeXPath(visibleText) + "]");
//		wait.until(ExpectedConditions.elementToBeClickable(opt)).click();
//	}
//
//	/**
//	 * Convenience method to select the hard-coded VIDARBHA INDUSTRIES option.
//	 */
//	public void selectDefaultBillToParty() {
//		billToPartyDrop.click();
//		wait.until(ExpectedConditions.elementToBeClickable(billToPartyDroOptField)).click();
//	}
//
//	public String getSelectedBillToPartyValue() {
//		try {
//			return billToPartyDrop.getAttribute("value");
//		} catch (Exception e) {
//			return null;
//		}
//	}
//
//	/**
//	 * Helper to escape strings for use in XPath literal expressions.
//	 */
//	private String escapeXPath(String text) {
//		if (text == null) return "''";
//		if (!text.contains("'")) {
//			return "'" + text + "'";
//		}
//		// If the text contains single quotes, use concat(...) technique
//		String[] parts = text.split("'");
//		StringBuilder sb = new StringBuilder("concat(");
//		for (int i = 0; i < parts.length; i++) {
//			sb.append("'").append(parts[i]).append("'");
//			if (i != parts.length - 1) sb.append(", \"'\", ");
//		}
//		sb.append(")");
//		return sb.toString();
//	}

// ==================== LOCATORS ====================
    
    // Navigation Links
//    @FindBy(xpath = "//div[@class='mb-50']//span[normalize-space(text())='Transaction']")
//    private WebElement transactionLink;
//    
//    @FindBy(xpath = "//span[contains(normalize-space(.),'Direct Tax Invoice') and contains(@class,'fs-12')]")
//    private WebElement directTaxInvoiceLink;
//    
//    // Page Title
//    @FindBy(xpath = "//div[contains(@class,'display-cell')]//span[contains(., 'Direct Tax Invoice / Create')]")
//    private WebElement pageTitle;
//    
//    // Loading Spinner
//    By dotSpinner = By.xpath("/html/body/app-root/div/div/div/div/div");
//    
//    // Header Section - Row 1
//    @FindBy(xpath = "//label[normalize-space(text())='Doc Type']/following::input[contains(@class,'igx-input-group__input')][1]")
//    private WebElement docTypeField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Doc Type']/following::igx-icon[contains(@class,'material-icons')][1]")
//    private WebElement docTypeClearIcon;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Doc Type']/following::igx-icon[normalize-space(text())='expand_more'][1]")
//    private WebElement docTypeDropdownIcon;
//    
//    By docTypeInput = By.xpath("//label[normalize-space(text())='Doc Type']/following::input[contains(@class,'igx-input-group__input')][1]");
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Series']/parent::div/following-sibling::div//igx-icon[normalize-space(text())='expand_more']")
//    private WebElement seriesDropdownIcon;
//    
//    By seriesInput = By.xpath("//label[normalize-space(text())='Series']/following::input[@role='combobox'][1]");
//    
//    @FindBy(xpath = "//input[@placeholder='PO reference No']")
//    private WebElement poReferenceNoField;
//    
//    @FindBy(xpath = "//input[@placeholder='dd/MM/yyyy' and contains(@class,'igx-input-group__input')]")
//    private WebElement poDateField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='PO Date']/following::igx-icon[normalize-space(text())='calendar_today'][1]")
//    private WebElement poDateCalendarIcon;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Vehicle No.']/following::igx-icon[normalize-space(text())='expand_more'][1]")
//    private WebElement vehicleNoDropdownIcon;
//    
//    By vehicleNoInput = By.xpath("//label[normalize-space(text())='Vehicle No.']/following::input[@role='combobox'][1]");
//    
//    // Header Section - Row 2
//    @FindBy(xpath = "//label[normalize-space(text())='Invoice No.']/following::input[1]")
//    private WebElement invoiceNoField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Remarks']/following::textarea[1]")
//    private WebElement remarksField;
//    
//    // Header Section - Row 3
//    @FindBy(xpath = "//input[contains(@class,'igx-input-group__input') and @placeholder='12/Feb/2026']")
//    private WebElement dateField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Date']/following::igx-icon[normalize-space(text())='calendar_today'][1]")
//    private WebElement dateCalendarIcon;
//    
//    @FindBy(xpath = "//igx-icon[normalize-space(text())='clear' and contains(@class,'igx-input-group__icon')]")
//    private WebElement dateClearIcon;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Bill To Party']/following::igx-icon[normalize-space(text())='expand_more'][1]")
//    private WebElement billToPartyDropdownIcon;
//    
//    By billToPartyInput = By.xpath("//label[normalize-space(text())='Bill To Party']/following::input[@role='combobox'][1]");
//    
//    @FindBy(xpath = "//button[normalize-space(text())='PLACE OF SUPPLY' and contains(@class,'igx-button')]")
//    private WebElement placeOfSupplyButton;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Ledger Balance']/following::input[1]")
//    private WebElement ledgerBalanceField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Invoice Type']/following::input[1]")
//    private WebElement invoiceTypeField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Currency']/following::igx-icon[normalize-space(text())='expand_more'][1]")
//    private WebElement currencyDropdownIcon;
//    
//    By currencyInput = By.xpath("//label[normalize-space(text())='Currency']/following::input[@role='combobox'][1]");
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Exchange Rate']/following::input[1]")
//    private WebElement exchangeRateField;
//    
//    @FindBy(xpath = "//label[contains(text(),'Invoice Type')]/following::igx-icon[normalize-space(text())='expand_more'][1]")
//    private WebElement invoiceTypeDropdownIcon;
//    
//    By invoiceTypeDropdownInput = By.xpath("//label[contains(text(),'Invoice Type')]/following::input[@role='combobox'][1]");
//    
//    // Header Section - Row 4
//    @FindBy(xpath = "//label[normalize-space(text())='Location']/following::igx-icon[normalize-space(text())='expand_more'][1]")
//    private WebElement locationDropdownIcon;
//    
//    By locationInput = By.xpath("//label[normalize-space(text())='Location']/following::input[@role='combobox'][1]");
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Item']/following::igx-icon[normalize-space(text())='expand_more'][1]")
//    private WebElement itemDropdownIcon;
//    
//    By itemInput = By.xpath("//label[normalize-space(text())='Item']/following::input[@role='combobox'][1]");
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Batch']/following::igx-icon[normalize-space(text())='expand_more'][1]")
//    private WebElement batchDropdownIcon;
//    
//    By batchInput = By.xpath("//label[normalize-space(text())='Batch']/following::input[@role='combobox'][1]");
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Unit']/following::input[1]")
//    private WebElement unitField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='MRP']/following::input[contains(@class,'text-input')][1]")
//    private WebElement mrpField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Rate']/following::input[contains(@class,'text-input')][1]")
//    private WebElement rateField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Stock Avbl']/following::input[1]")
//    private WebElement stockAvblField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Invoice Qty.']/following::input[contains(@class,'text-input')][1]")
//    private WebElement invoiceQtyField;
//    
//    // Tax Section - Row 5
//    @FindBy(xpath = "//label[normalize-space(text())='Gross']/following::input[contains(@class,'text-input')][1]")
//    private WebElement grossField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='CGST%']/following::input[contains(@class,'text-input')][1]")
//    private WebElement cgstPercentField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='SGST%']/following::input[contains(@class,'text-input')][1]")
//    private WebElement sgstPercentField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='IGST%']/following::input[contains(@class,'text-input')][1]")
//    private WebElement igstPercentField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='UGST%']/following::input[contains(@class,'text-input')][1]")
//    private WebElement ugstPercentField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Net Amount']/following::input[contains(@class,'text-input')][1]")
//    private WebElement netAmountField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='FAT %']/following::input[contains(@class,'text-input')][1]")
//    private WebElement fatPercentField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='SNF %']/following::input[contains(@class,'text-input')][1]")
//    private WebElement snfPercentField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='CLR']/following::input[contains(@class,'text-input')][1]")
//    private WebElement clrField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='Protien']/following::input[contains(@class,'text-input')][1]")
//    private WebElement protienField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='QTYKG']/following::input[contains(@class,'text-input')][1]")
//    private WebElement qtykgField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='FATKG']/following::input[contains(@class,'text-input')][1]")
//    private WebElement fatkgField;
//    
//    @FindBy(xpath = "//label[normalize-space(text())='SNFKG']/following::input[contains(@class,'text-input')][1]")
//    private WebElement snfkgField;
//    
//    // Summary Information
//    @FindBy(xpath = "//div[contains(text(),'GROSS AMT :')]")
//    private WebElement grossAmtLabel;
//    
//    @FindBy(xpath = "//div[contains(text(),'CREDIT LIMIT :')]")
//    private WebElement creditLimitLabel;
//    
//    @FindBy(xpath = "//div[contains(text(),'LEDGER BALANCE :')]")
//    private WebElement ledgerBalanceLabel;
//    
//    @FindBy(xpath = "//div[contains(text(),'BALANCE:')]")
//    private WebElement balanceLabel;
//    
//    // Grid Section
//    @FindBy(xpath = "//div[@role='rowgroup']//igx-grid-row[@data-rowindex='0']")
//    private WebElement firstGridRow;
//    
//    @FindBy(xpath = "//igx-grid-row//igx-grid-cell[contains(@class,'igx-grid__td')]")
//    private List<WebElement> gridCells;
//    
//    By gridRowLocator = By.xpath("//igx-grid-row[@data-rowindex='0']");
//    
//    // Grid Column Headers with Sort Icons
//    @FindBy(xpath = "//span[normalize-space(text())='Item']/parent::div//igx-icon[@name='arrow_upward']")
//    private WebElement itemColumnSortUpIcon;
//    
//    @FindBy(xpath = "//span[normalize-space(text())='Batch']/parent::div//igx-icon[@name='arrow_upward']")
//    private WebElement batchColumnSortUpIcon;
//    
//    @FindBy(xpath = "//span[normalize-space(text())='Unit']/parent::div//igx-icon[@name='arrow_upward']")
//    private WebElement unitColumnSortUpIcon;
//    
//    @FindBy(xpath = "//span[normalize-space(text())='MRP']/parent::div//igx-icon[@name='arrow_upward']")
//    private WebElement mrpColumnSortUpIcon;
//    
//    @FindBy(xpath = "//span[normalize-space(text())='Rate']/parent::div//igx-icon[@name='arrow_upward']")
//    private WebElement rateColumnSortUpIcon;
//    
//    @FindBy(xpath = "//span[normalize-space(text())='Tax%']/parent::div//igx-icon[@name='arrow_upward']")
//    private WebElement taxPercentColumnSortUpIcon;
//    
//    @FindBy(xpath = "//span[normalize-space(text())='Invoice Qty.']/parent::div")
//    private WebElement invoiceQtyColumnHeader;
//    
//    @FindBy(xpath = "//span[normalize-space(text())='Action']")
//    private WebElement actionColumnHeader;
//    
//    // Action Buttons
//    @FindBy(xpath = "//button[@id='l_action_save_btn-width-selector' and normalize-space(text())='Back']")
//    private WebElement backButton;
//    
//    @FindBy(xpath = "//button[@id='l_action_save_btn-width-selector' and normalize-space(text())='Reset']")
//    private WebElement resetButton;
//    
//    // Confirmation Dialogs
//    @FindBy(xpath = "//div[contains(@class,'igx-dialog__window-title') and normalize-space(text())='Confirmation']")
//    private WebElement confirmationPopup;
//    
//    @FindBy(xpath = "//span[contains(@class,'igx-dialog__window-message')]")
//    private WebElement confirmationMessage;
//    
//    @FindBy(xpath = "//button[contains(@class,'igx-button') and normalize-space(text())='OK']")
//    private WebElement confirmationOkButton;
//    
//    @FindBy(xpath = "//button[contains(@class,'igx-button') and normalize-space(text())='CANCEL']")
//    private WebElement confirmationCancelButton;
//    
//    // Success/Error Messages
//    @FindBy(xpath = "//div[@class='igx-snackbar__message']")
//    private WebElement snackbarMessage;
//    
//    @FindBy(xpath = "//div[contains(text(),'Regrettably, no data was found')]")
//    private WebElement noDataFoundMessage;
//    
//    // Dropdown Options (Dynamic)
//    By dropdownOptionsList = By.xpath("//igx-combo-item[@role='option']//span[contains(@class,'combo-col')]");
//    
//    // Combo Box Search Input
//    By comboSearchInput = By.xpath("//div[contains(@class,'igx-overlay__content')]//input[@type='text']");
//    
//    
//    
//    
//    
//    // ==================== ACTION METHODS ====================
//    
//    /**
//     * Click on Transaction link in the sidebar
//     */
//    public void clickTransactionLink() {
//        WaitHelper.waitForClickable(driver, transactionLink, 10);
//        transactionLink.click();
//        logger.info("Clicked on Transaction link");
//    }
//    
//    /**
//     * Click on Direct Tax Invoice link in the sidebar
//     */
//    public void clickDirectTaxInvoiceLink() {
//        WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
//        WaitHelper.waitForClickable(driver, directTaxInvoiceLink, 10);
//        directTaxInvoiceLink.click();
//        logger.info("Clicked on Direct Tax Invoice link");
//    }
//    
//    /**
//     * Wait for page to load completely
//     */
//    public void waitForPageLoad() {
//        WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 15);
//        WaitHelper.waitForVisible(driver, pageTitle, 10);
//        logger.info("Direct Tax Invoice page loaded successfully");
//    }
//    
//    /**
//     * Select Doc Type from dropdown
//     * @param docType - Doc Type value to select
//     */
//    public void selectDocType(String docType) {
//        WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
//        WaitHelper.waitForClickable(driver, docTypeField, 10).click();
//        WaitHelper.waitForPresenceOfElementLocated(driver, docTypeInput, 10).clear();
//        WaitHelper.waitForPresenceOfElementLocated(driver, docTypeInput, 10).sendKeys(docType);
//        
//        By docTypeOption = By.xpath("//igx-combo-item//span[normalize-space(text())='" + docType + "']");
//        WaitHelper.waitForClickable(driver, docTypeOption, 10).click();
//        logger.info("Selected Doc Type: " + docType);
//    }
//    
//    /**
//     * Select Series from dropdown
//     * @param series - Series value to select
//     */
//    public void selectSeries(String series) {
//        WaitHelper.waitForClickable(driver, seriesDropdownIcon, 10).click();
//        WaitHelper.waitForPresenceOfElementLocated(driver, seriesInput, 10).clear();
//        WaitHelper.waitForPresenceOfElementLocated(driver, seriesInput, 10).sendKeys(series);
//        
//        By seriesOption = By.xpath("//igx-combo-item//span[contains(normalize-space(text()),'" + series + "')]");
//        WaitHelper.waitForClickable(driver, seriesOption, 10).click();
//        logger.info("Selected Series: " + series);
//    }
//    
//    /**
//     * Enter PO Reference Number
//     * @param poRefNo - PO Reference Number
//     */
//    public void enterPOReferenceNo(String poRefNo) {
//        WaitHelper.waitForClickable(driver, poReferenceNoField, 10);
//        poReferenceNoField.clear();
//        poReferenceNoField.sendKeys(poRefNo);
//        logger.info("Entered PO Reference No: " + poRefNo);
//    }
//    
//    /**
//     * Select PO Date
//     * @param date - Date in format dd/MM/yyyy
//     */
//    public void selectPODate(String date) {
//        WaitHelper.waitForClickable(driver, poDateField, 10);
//        poDateField.clear();
//        poDateField.sendKeys(date);
//        poDateField.sendKeys(Keys.ENTER);
//        logger.info("Selected PO Date: " + date);
//    }
//    
//    /**
//     * Select Vehicle Number from dropdown
//     * @param vehicleNo - Vehicle Number
//     */
//    public void selectVehicleNo(String vehicleNo) {
//        WaitHelper.waitForClickable(driver, vehicleNoDropdownIcon, 10).click();
//        WaitHelper.waitForPresenceOfElementLocated(driver, vehicleNoInput, 10).clear();
//        WaitHelper.waitForPresenceOfElementLocated(driver, vehicleNoInput, 10).sendKeys(vehicleNo);
//        
//        By vehicleOption = By.xpath("//igx-combo-item//span[contains(normalize-space(text()),'" + vehicleNo + "')]");
//        WaitHelper.waitForClickable(driver, vehicleOption, 10).click();
//        logger.info("Selected Vehicle No: " + vehicleNo);
//    }
//    
//    /**
//     * Enter Remarks
//     * @param remarks - Remarks text
//     */
//    public void enterRemarks(String remarks) {
//        WaitHelper.waitForClickable(driver, remarksField, 10);
//        remarksField.clear();
//        remarksField.sendKeys(remarks);
//        logger.info("Entered Remarks: " + remarks);
//    }
//    
//    /**
//     * Select Date
//     * @param date - Date in format dd/MM/yyyy
//     */
//    public void selectDate(String date) {
//        WaitHelper.waitForClickable(driver, dateField, 10);
//        dateField.clear();
//        dateField.sendKeys(date);
//        dateField.sendKeys(Keys.ENTER);
//        logger.info("Selected Date: " + date);
//    }
//    
//    /**
//     * Select Bill To Party from dropdown
//     * @param partyName - Party Name
//     */
//    public void selectBillToParty(String partyName) {
//        WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
//        WaitHelper.waitForClickable(driver, billToPartyDropdownIcon, 10).click();
//        WaitHelper.waitForPresenceOfElementLocated(driver, billToPartyInput, 10).clear();
//        WaitHelper.waitForPresenceOfElementLocated(driver, billToPartyInput, 10).sendKeys(partyName);
//        
//        By partyOption = By.xpath("//igx-combo-item//span[contains(normalize-space(text()),'" + partyName + "')]");
//        WaitHelper.waitForClickable(driver, partyOption, 10).click();
//        logger.info("Selected Bill To Party: " + partyName);
//    }
//    
//    /**
//     * Click on Place of Supply button
//     */
//    public void clickPlaceOfSupplyButton() {
//        WaitHelper.waitForClickable(driver, placeOfSupplyButton, 10);
//        placeOfSupplyButton.click();
//        logger.info("Clicked on Place of Supply button");
//    }
//    
//    /**
//     * Get Ledger Balance value
//     * @return Ledger Balance as String
//     */
//    public String getLedgerBalance() {
//        WaitHelper.waitForVisible(driver, ledgerBalanceField, 10);
//        String balance = ledgerBalanceField.getAttribute("value");
//        logger.info("Ledger Balance: " + balance);
//        return balance;
//    }
//    
//    /**
//     * Select Currency from dropdown
//     * @param currency - Currency code (e.g., INR, USD)
//     */
//    public void selectCurrency(String currency) {
//        WaitHelper.waitForClickable(driver, currencyDropdownIcon, 10).click();
//        WaitHelper.waitForPresenceOfElementLocated(driver, currencyInput, 10).clear();
//        WaitHelper.waitForPresenceOfElementLocated(driver, currencyInput, 10).sendKeys(currency);
//        
//        By currencyOption = By.xpath("//igx-combo-item//span[normalize-space(text())='" + currency + "']");
//        WaitHelper.waitForClickable(driver, currencyOption, 10).click();
//        logger.info("Selected Currency: " + currency);
//    }
//    
//    /**
//     * Enter Exchange Rate
//     * @param rate - Exchange Rate
//     */
//    public void enterExchangeRate(String rate) {
//        WaitHelper.waitForClickable(driver, exchangeRateField, 10);
//        exchangeRateField.clear();
//        exchangeRateField.sendKeys(rate);
//        logger.info("Entered Exchange Rate: " + rate);
//    }
//    
//    /**
//     * Select Invoice Type from dropdown
//     * @param invoiceType - Invoice Type (e.g., Goods, Services)
//     */
//    public void selectInvoiceTypeDropdown(String invoiceType) {
//        WaitHelper.waitForClickable(driver, invoiceTypeDropdownIcon, 10).click();
//        WaitHelper.waitForPresenceOfElementLocated(driver, invoiceTypeDropdownInput, 10).clear();
//        WaitHelper.waitForPresenceOfElementLocated(driver, invoiceTypeDropdownInput, 10).sendKeys(invoiceType);
//        
//        By invoiceTypeOption = By.xpath("//igx-combo-item//span[normalize-space(text())='" + invoiceType + "']");
//        WaitHelper.waitForClickable(driver, invoiceTypeOption, 10).click();
//        logger.info("Selected Invoice Type: " + invoiceType);
//    }
//    
//    /**
//     * Select Location from dropdown
//     * @param location - Location name
//     */
//    public void selectLocation(String location) {
//        WaitHelper.waitForClickable(driver, locationDropdownIcon, 10).click();
//        WaitHelper.waitForPresenceOfElementLocated(driver, locationInput, 10).clear();
//        WaitHelper.waitForPresenceOfElementLocated(driver, locationInput, 10).sendKeys(location);
//        
//        By locationOption = By.xpath("//igx-combo-item//span[contains(normalize-space(text()),'" + location + "')]");
//        WaitHelper.waitForClickable(driver, locationOption, 10).click();
//        logger.info("Selected Location: " + location);
//    }
//    
//    /**
//     * Select Item from dropdown
//     * @param itemName - Item name
//     */
//    public void selectItem(String itemName) {
//        WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
//        WaitHelper.waitForClickable(driver, itemDropdownIcon, 10).click();
//        WaitHelper.waitForPresenceOfElementLocated(driver, itemInput, 10).clear();
//        WaitHelper.waitForPresenceOfElementLocated(driver, itemInput, 10).sendKeys(itemName);
//        
//        By itemOption = By.xpath("//igx-combo-item//span[contains(normalize-space(text()),'" + itemName + "')]");
//        WaitHelper.waitForClickable(driver, itemOption, 10).click();
//        logger.info("Selected Item: " + itemName);
//    }
//    
//    /**
//     * Select Batch from dropdown
//     * @param batchNo - Batch number
//     */
//    public void selectBatch(String batchNo) {
//        WaitHelper.waitForClickable(driver, batchDropdownIcon, 10).click();
//        WaitHelper.waitForPresenceOfElementLocated(driver, batchInput, 10).clear();
//        WaitHelper.waitForPresenceOfElementLocated(driver, batchInput, 10).sendKeys(batchNo);
//        
//        By batchOption = By.xpath("//igx-combo-item//span[contains(normalize-space(text()),'" + batchNo + "')]");
//        WaitHelper.waitForClickable(driver, batchOption, 10).click();
//        logger.info("Selected Batch: " + batchNo);
//    }
//    
//    /**
//     * Get MRP value
//     * @return MRP as String
//     */
//    public String getMRP() {
//        WaitHelper.waitForVisible(driver, mrpField, 10);
//        String mrp = mrpField.getAttribute("value");
//        logger.info("MRP: " + mrp);
//        return mrp;
//    }
//    
//    /**
//     * Enter Rate
//     * @param rate - Rate value
//     */
//    public void enterRate(String rate) {
//        WaitHelper.waitForClickable(driver, rateField, 10);
//        rateField.clear();
//        rateField.sendKeys(rate);
//        logger.info("Entered Rate: " + rate);
//    }
//    
//    /**
//     * Get Stock Available value
//     * @return Stock Available as String
//     */
//    public String getStockAvailable() {
//        WaitHelper.waitForVisible(driver, stockAvblField, 10);
//        String stock = stockAvblField.getAttribute("value");
//        logger.info("Stock Available: " + stock);
//        return stock;
//    }
//    
//    /**
//     * Enter Invoice Quantity
//     * @param quantity - Invoice Quantity
//     */
//    public void enterInvoiceQty(String quantity) {
//        WaitHelper.waitForClickable(driver, invoiceQtyField, 10);
//        invoiceQtyField.clear();
//        invoiceQtyField.sendKeys(quantity);
//        invoiceQtyField.sendKeys(Keys.TAB);
//        logger.info("Entered Invoice Qty: " + quantity);
//    }
//    
//    /**
//     * Get Gross Amount
//     * @return Gross Amount as String
//     */
//    public String getGrossAmount() {
//        WaitHelper.waitForVisible(driver, grossField, 10);
//        String gross = grossField.getAttribute("value");
//        logger.info("Gross Amount: " + gross);
//        return gross;
//    }
//    
//    /**
//     * Get Net Amount
//     * @return Net Amount as String
//     */
//    public String getNetAmount() {
//        WaitHelper.waitForVisible(driver, netAmountField, 10);
//        String netAmount = netAmountField.getAttribute("value");
//        logger.info("Net Amount: " + netAmount);
//        return netAmount;
//    }
//    
//    /**
//     * Enter FAT Percentage
//     * @param fatPercent - FAT Percentage
//     */
//    public void enterFATPercent(String fatPercent) {
//        WaitHelper.waitForClickable(driver, fatPercentField, 10);
//        fatPercentField.clear();
//        fatPercentField.sendKeys(fatPercent);
//        logger.info("Entered FAT %: " + fatPercent);
//    }
//    
//    /**
//     * Enter SNF Percentage
//     * @param snfPercent - SNF Percentage
//     */
//    public void enterSNFPercent(String snfPercent) {
//        WaitHelper.waitForClickable(driver, snfPercentField, 10);
//        snfPercentField.clear();
//        snfPercentField.sendKeys(snfPercent);
//        logger.info("Entered SNF %: " + snfPercent);
//    }
//    
//    /**
//     * Click Back button
//     */
//    public void clickBackButton() {
//        WaitHelper.waitForClickable(driver, backButton, 10);
//        backButton.click();
//        logger.info("Clicked on Back button");
//    }
//    
//    /**
//     * Click Reset button
//     */
//    public void clickResetButton() {
//        WaitHelper.waitForClickable(driver, resetButton, 10);
//        resetButton.click();
//        logger.info("Clicked on Reset button");
//    }
//    
//    /**
//     * Handle confirmation popup - Click OK
//     */
//    public void clickConfirmationOK() {
//        WaitHelper.waitForVisible(driver, confirmationPopup, 10);
//        WaitHelper.waitForClickable(driver, confirmationOkButton, 10);
//        confirmationOkButton.click();
//        logger.info("Clicked OK on confirmation popup");
//    }
//    
//    /**
//     * Handle confirmation popup - Click Cancel
//     */
//    public void clickConfirmationCancel() {
//        WaitHelper.waitForVisible(driver, confirmationPopup, 10);
//        WaitHelper.waitForClickable(driver, confirmationCancelButton, 10);
//        confirmationCancelButton.click();
//        logger.info("Clicked Cancel on confirmation popup");
//    }
//    
//    /**
//     * Get confirmation message text
//     * @return Confirmation message
//     */
//    public String getConfirmationMessage() {
//        WaitHelper.waitForVisible(driver, confirmationMessage, 10);
//        String message = confirmationMessage.getText();
//        logger.info("Confirmation Message: " + message);
//        return message;
//    }
//    
//    /**
//     * Get success/error message from snackbar
//     * @return Snackbar message
//     */
//    public String getSnackbarMessage() {
//        WaitHelper.waitForVisible(driver, snackbarMessage, 10);
//        String message = snackbarMessage.getText();
//        logger.info("Snackbar Message: " + message);
//        return message;
//    }
//    
//    /**
//     * Check if page is loaded
//     * @return true if page title is visible
//     */
//    public boolean isPageLoaded() {
//        try {
//            WaitHelper.waitForVisible(driver, pageTitle, 10);
//            return pageTitle.isDisplayed();
//        } catch (Exception e) {
//            logger.error("Direct Tax Invoice page not loaded", e);
//            return false;
//        }
//    }
//    
//    /**
//     * Wait for grid to load
//     */
//    public void waitForGridLoad() {
//        WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
//        WaitHelper.waitForPresenceOfElementLocated(driver, gridRowLocator, 10);
//        logger.info("Grid loaded successfully");
//    }
//    
//    /**
//     * Get Doc Type value
//     * @return Doc Type as String
//     */
//    public String getDocType() {
//        WaitHelper.waitForVisible(driver, docTypeField, 10);
//        String docType = docTypeField.getAttribute("value");
//        logger.info("Doc Type: " + docType);
//        return docType;
//    }
//    
//    /**
//     * Get Invoice Number
//     * @return Invoice Number as String
//     */
//    public String getInvoiceNo() {
//        WaitHelper.waitForVisible(driver, invoiceNoField, 10);
//        String invoiceNo = invoiceNoField.getAttribute("value");
//        logger.info("Invoice No: " + invoiceNo);
//        return invoiceNo;
//    }
//    
//    /**
//     * Clear all form fields
//     */
//    public void clearAllFields() {
//        clickResetButton();
//        WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
//        logger.info("Cleared all form fields");
//    }
//    
//    /**
//     * Verify if no data found message is displayed
//     * @return true if no data message is visible
//     */
//    public boolean isNoDataFoundMessageDisplayed() {
//        try {
//            WaitHelper.waitForVisible(driver, noDataFoundMessage, 5);
//            return noDataFoundMessage.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
	
	
	
}
