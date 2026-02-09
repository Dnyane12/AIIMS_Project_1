package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownTestUtility {
	
	public static List<String> getItemTypeDropdownOptions(WebDriver driver, String labelText) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    
	    
	    // Step 1: Click the dropdown icon
	    By dropdownIcon = By.xpath("//label[normalize-space(text())='" + labelText + "']/following::igx-icon[1]");
	    wait.until(ExpectedConditions.elementToBeClickable(dropdownIcon)).click();

	    // Step 2:  for overlay container
	    WebElement dropdownOverlay = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("div.igx-overlay__content")
	        )
	    );

	    // Step 3: Scroll and collect unique options
	    Set<String> allOptions = new LinkedHashSet<>();
	    int previousCount = -1;

	    while (true) {
	        // Get current visible items
	        List<WebElement> visibleOptions = driver.findElements(
	            By.xpath("//igx-combo-item[@role='option']//span[contains(@class,'drop-down__inner')]")
	        );

	        for (WebElement el : visibleOptions) {
	            String text = el.getText().trim();
	            if (!text.isEmpty()) {
	                allOptions.add(text);
	            }
	        }

	        // Break condition: If no new items are added
	        if (allOptions.size() == previousCount) {
	            break;
	        }
	        previousCount = allOptions.size();

	        // Scroll dropdown overlay down by 300px (adjust as needed)
	        js.executeScript("arguments[0].scrollBy(0, 300);", dropdownOverlay);

	        // Short sleep to allow new items to render
	        try {
	            Thread.sleep(300);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    return new ArrayList<>(allOptions);
	}



}
