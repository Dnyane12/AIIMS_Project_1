package flowPack.accountsModuleFlow.masterFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.accounts.master.JournalVoucherMultiLinePage;

public class JournalVoucherMultiLineFlow {
	WebDriver driver;
	JournalVoucherMultiLinePage jvMulPage;
	
	
	//Constructor to initialize the driver and page objects
	JournalVoucherMultiLineFlow(WebDriver driver){
		this.driver= driver;
		jvMulPage= new JournalVoucherMultiLinePage(driver);
	}
	
	
	@FindBy(xpath="")
	private WebElement accModule;
	
	
	
}
