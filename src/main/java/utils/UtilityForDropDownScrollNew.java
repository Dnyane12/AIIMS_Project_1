//package utils;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Set;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import Test.setUpTests.SetUp;
//
//public class UtilityForDropDownScrollNew extends SetUp{
//	
//public void dropdownScrollUtilityFunction(String labelText) throws InterruptedException {
//	
//	// 1. Click to open dropdown
//	WebElement dropdownIcon = driver.findElement(By.xpath("//label[normalize-space(text())='Item Type']/following::igx-icon[1]"));
//	dropdownIcon.click();
//
//	// 2.  for overlay options to appear
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'igx-overlay__content')]//igx-combo-item[@role='option']")));
//
//	// 3. Fetch all options globally
//	List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'igx-overlay__content')]//igx-combo-item[@role='option']"));
//
//	System.out.println("Total options found: " + options.size());
//
//	// 4. Scroll to get more options if required
//	WebElement scrollContainer = driver.findElement(By.xpath("//div[contains(@class,'igx-drop-down__list-scroll')]"));
//	int previousCount = 0;
//
//	while (true) {
//	    List<WebElement> currentOptions = driver.findElements(By.xpath("//div[contains(@class,'igx-overlay__content')]//igx-combo-item[@role='option']"));
//	    if (currentOptions.size() == previousCount) break; // no new options
//	    previousCount = currentOptions.size();
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollContainer);
//	    Thread.sleep(500);
//	}
//	System.out.println("Total options after scroll: " + previousCount);
//
//
//
//
//
//
//
//
//
//}
//
//}
//
//
