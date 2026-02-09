package pageObjects.inventory.transaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

public class GRNPrintingPage{
WebDriver driver;
	
public GRNPrintingPage(WebDriver driver) {
	this.driver= driver;	
	PageFactory.initElements(driver,this);
}
	
@FindBy(xpath="//igx-nav-drawer//span[normalize-space(text())='Report' and contains(@class,'fs-13')]")
private WebElement reportLink;
@FindBy(xpath="//div[@class='mb-50']//span[contains(normalize-space(.),'Grn Printing') and contains(@class,'fs-12')]")	
private WebElement grnPrintLink;	
By dotSpinner = By.xpath("//div[@class='dot-spinner']");

@FindBy(xpath="//button[contains(normalize-space(.),'View') and contains(@class,'mt-3')]")
private WebElement viewButton;

By searchBar= By.xpath("//input[contains(@class,'p-0') and contains(@placeholder,'Grn Printing Search')]");

@FindBy(xpath="(//label[text()='From Date']/following::input[contains(@class,'igx-date-picker__input-date') and @role='combobox'])[1]")
private WebElement fromDate;
		
@FindBy(xpath="//igx-icon[text()='print' and contains(@class,'material-icons')]")
private WebElement printIcon;






//Action Methods
public void clickReportLink(){
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	WaitHelper.waitForClickable(driver, reportLink, 10);
	reportLink.click();
}

public void clickGrnPrintRepLink() {
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	WaitHelper.waitForClickable(driver, grnPrintLink, 10);
	grnPrintLink.click();
}

public void clickViewButton(){
	WaitHelper.waitForClickable(driver, viewButton, 10);
	viewButton.click();
}

public void serchGRNNoInSerchBar(String grnNo) {
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 20);
	WaitHelper.waitForRefreshAndClick(driver, searchBar, 10);	
	driver.findElement(searchBar).sendKeys(grnNo);	
}

public void enterFromDate(String fromDateValue) {
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	WaitHelper.waitForClickable(driver, fromDate, 10);
	fromDate.click();
	fromDate.sendKeys(fromDateValue);
}

public void clickPrintIcon1() {
	WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
	WaitHelper.waitForClickable(driver, printIcon, 10);
	printIcon.click();	
	
	// Wait for new tab/window with PDF
//    WaitHelper.waitForNumberOfWindowsToBe(SetUp.driver, 2, 10);
//    
//    // Switch to PDF tab
//    String mainWindow = SetUp.driver.getWindowHandle();
//    for (String windowHandle : SetUp.driver.getWindowHandles()) {
//        if (!windowHandle.equals(mainWindow)) {
//            SetUp.driver.switchTo().window(windowHandle);
//            break;
//        }
//    }
}
	


public void clickPrintIcon() {
    WaitHelper.waitForInvisibilityOfElementLocated(driver, dotSpinner, 10);
    WaitHelper.waitForClickable(driver, printIcon, 10);
    printIcon.click();
    
    // Wait for new tab/window with PDF
//    WaitHelper.waitForNumberOfWindowsToBe(driver, 2, 10);
//    
//    // Switch to PDF tab
//    String mainWindow = driver.getWindowHandle();
//    for (String windowHandle : driver.getWindowHandles()) {
//        if (!windowHandle.equals(mainWindow)) {
//            driver.switchTo().window(windowHandle);
//            break;
//        }
//    }
}

//public void switchBackToMainWindow(String mainWindowHandle) {
//    driver.switchTo().window(mainWindowHandle);
//}


//Getters and Setters


}
