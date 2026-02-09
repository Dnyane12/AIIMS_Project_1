package pageObjects.setup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalenderPage {
	WebDriver driver;
	
	public CalenderPage(WebDriver driver) {
		this.driver= driver;
		//PageFactory.initElements(driver,this);
	}
	
	private By calenderIcon = By.xpath("/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[1]/div/div[3]/app-g-date-all-datepicker[1]/div/igx-date-picker/igx-input-group/div[1]/div[1]/igx-prefix/igx-icon");
	private By calendarPopup =By.xpath("/html/body/div/div/div/igx-calendar-container/igx-calendar/div/section[1]");
	private By monthYearTitlexpath =By.xpath("/html/body/div/div/div/igx-calendar-container/igx-calendar/div/section[1]/div[2]");
	private By nextButton = By.xpath("/html/body/div/div/div/igx-calendar-container/igx-calendar/div/section[1]/div[1]/igx-icon");
	private By dayItems =By.xpath("/html/body/div/div/div/igx-calendar-container/igx-calendar/div/section[2]/igx-days-view");
	

	
	
	
}
