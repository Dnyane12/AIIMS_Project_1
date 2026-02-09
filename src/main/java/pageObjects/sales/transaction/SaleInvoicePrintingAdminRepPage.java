package pageObjects.sales.transaction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import utils.WaitHelper;
public class SaleInvoicePrintingAdminRepPage {
	WebDriver driver;


    public SaleInvoicePrintingAdminRepPage(WebDriver driver) {
        this.driver = driver;      
        PageFactory.initElements(driver, this);
    }

  

    @FindBy(xpath = "//input[@type='text' and (contains(@placeholder,'Invoice') or contains(@aria-label,'Invoice'))]")
    private WebElement invoiceSearchInput;

    @FindBy(xpath = "//label[normalize-space()='From Date']/following::input[1]")
    private WebElement fromDateInput;

    @FindBy(xpath = "//label[normalize-space()='To Date']/following::input[1]")
    private WebElement toDateInput;

    @FindBy(xpath = "//label[normalize-space()='Invoice Type']/following::input[1]")
    private WebElement invoiceTypeDropdown;

    // NOTE: spelling mistake exists in UI → Disptach
    @FindBy(xpath = "//label[normalize-space()='Disptach No']/following::input[1]")
    private WebElement dispatchNoDropdown;

    @FindBy(xpath =
        "(//div[contains(@class,'igx-overlay__content')]//igx-display-container" +
        "[contains(@class,'igx-display-container--active')][1]" +
        "//igx-combo-item[@role='option']//span)")
    private List<WebElement> activeDropdownOptions;

    @FindBy(xpath = "//button[.//span[normalize-space()='Export'] or normalize-space()='Export']")
    private WebElement exportButton;

    @FindBy(xpath = "//button[.//span[normalize-space()='View'] or normalize-space()='View']")
    private WebElement viewButton;

    @FindBy(xpath = "//igx-grid//igx-grid-row//igx-icon[normalize-space()='print' or contains(@title,'Print')]")
    private List<WebElement> printIcons;
    
    
    
    
    private void safeClick(WebElement element) {
        try {
          WaitHelper.waitForClickable(driver,element, 10);
          element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }

    
    private void safeSendKeys(WebElement element, String value) {
    	WaitHelper.waitForVisible(driver,element, 10);
        element.clear();
        element.sendKeys(value);
    }


	public WebElement getInvoiceSearchInput() {
		return invoiceSearchInput;
	}


	public WebElement getFromDateInput() {
		return fromDateInput;
	}


	public WebElement getToDateInput() {
		return toDateInput;
	}


	public WebElement getInvoiceTypeDropdown() {
		return invoiceTypeDropdown;
	}


	public WebElement getDispatchNoDropdown() {
		return dispatchNoDropdown;
	}


	public List<WebElement> getActiveDropdownOptions() {
		return activeDropdownOptions;
	}


	public WebElement getExportButton() {
		return exportButton;
	}


	public WebElement getViewButton() {
		return viewButton;
	}


	public List<WebElement> getPrintIcons() {
		return printIcons;
	}

    
    
    
    
    
    
    
    
    
}
