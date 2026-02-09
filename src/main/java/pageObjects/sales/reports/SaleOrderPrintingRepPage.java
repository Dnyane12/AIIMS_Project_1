package pageObjects.sales.reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaleOrderPrintingRepPage {
	WebDriver driver;
	
	private SaleOrderPrintingRepPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(@class,'fs-13 menu-l1-name') and normalize-space(text())='Report']")
	private WebElement reportLink;
	@FindBy(xpath="(//span[contains(@class,'fs-12 d-flex') ])[1]")
	private WebElement saleOrderPritingRep;
	@FindBy(xpath="//igx-icon[contains(@class,'material-icons') and normalize-space(text())='today']")
	private WebElement date;
	@FindBy(xpath="//button[contains(@class,'igx-action-button')]//igx-icon[contains(@class,'material-icons')]")
	private WebElement printIcon ;
	@FindBy(xpath="//button[@id='l_action_print_btn-width-selector' and normalize-space(text())='Print']")
	private WebElement printButton;
	@FindBy(xpath="(//span[contains(@class,'fs-12')])[2]")
	private WebElement saleDispatchPrintLik;
	@FindBy(xpath="(//span[contains(@class,'fs-12')])[3]")
	private WebElement saleInvoicePritLink;
	/*
	 * @FindBy(xpath="(//span[contains(@class,'fs-12')])[3]") private WebElement ;
	 * 
	 * @FindBy(xpath="(//span[contains(@class,'fs-12')])[3]") private WebElement ;
	 * 
	 * @FindBy(xpath="(//span[contains(@class,'fs-12')])[3]") private WebElement ;
	 * 
	 * @FindBy(xpath="(//span[contains(@class,'fs-12')])[3]") private WebElement ;
	 * 
	 * @FindBy(xpath="(//span[contains(@class,'fs-12')])[3]") private WebElement ;
	 */
}
