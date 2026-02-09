package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {
	
	 private WaitHelper() {
	        // prevent object creation
	    }
	 
	
	      // ---------- WebElement based s ----------
	    public static void waitForVisible(WebDriver driver, WebElement element, int seconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
	    }

	    public static void waitForClickable(WebDriver driver, WebElement element, int seconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(element));
	    }
	 
	 
	    public static void waitForInvisibilityOfElementLocated( WebDriver driver,By locator, int seconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	    }

	    
	    public static void waitForVisibilityOfAllElements(
	            WebDriver driver,
	            List<WebElement> elements,
	            int seconds) {

	        new WebDriverWait(driver, Duration.ofSeconds(seconds))
	                .until(ExpectedConditions.visibilityOfAllElements(elements));
	    }

	    
	     // ---------- By based s ----------
       public static void waitForVisible(WebDriver driver, By locator, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
       }

       public static WebElement waitForClickable(WebDriver driver, By locator, int seconds) {
      return  new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(locator));
       }

  
       public static WebElement waitForPresenceOfElementLocated(WebDriver driver, By locator, int seconds) {
    	    return new WebDriverWait(driver, Duration.ofSeconds(seconds))
    	            .until(ExpectedConditions.presenceOfElementLocated(locator));
    	}

       
       public static void waitForVisibilityOfAllElements(
	            WebDriver driver,
	            By locator,
	            int seconds) {

	        new WebDriverWait(driver, Duration.ofSeconds(seconds))
	                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	    }
       
       public static boolean isElementVisible(WebDriver driver, By locator, int seconds) {
    	    try {
    	        new WebDriverWait(driver, Duration.ofSeconds(seconds))
    	                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    	        return true;
    	    } catch (Exception e) {
    	        return false;
    	    }
    	}
       
       public static void waitForRefreshAndClick(WebDriver driver, By locator, int seconds) {
   	    try {
   	    	 new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
   	     // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", driver.findElement(locator));
   	       driver.findElement(locator).click();
   	    } catch (Exception e) {
   	        e.printStackTrace();
   	    }
   	}
       
       
       
       
       public static void safeSendKeys(WebDriver driver, By locator, String text, int seconds) {
           waitForClickable(driver, locator, seconds);
           driver.findElement(locator).clear();
           driver.findElement(locator).sendKeys(text);
       }

       
       public static void safeClick(WebDriver driver, WebElement element) {
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    wait.until(d -> {
    	        try {
    	            return element.isDisplayed() && element.isEnabled();
    	        } catch (StaleElementReferenceException e) {
    	            return false;
    	        }
    	    });

    	    ((JavascriptExecutor) driver).executeScript(
    	        "arguments[0].scrollIntoView({block:'center'});" +
    	        "arguments[0].click();", element
    	    );
    	}
       
       public static void scrollIntoView(WebDriver driver, WebElement element) {
    	    JavascriptExecutor js = (JavascriptExecutor) driver;
    	    js.executeScript(
    	        "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
    	        element
    	    );
    	}

       
       
       public static void safeClick(WebDriver driver, WebElement element, int timeoutInSeconds) {

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

    	    // 1. Scroll element into safe view
    	    scrollIntoView(driver, element);

    	    // 2. Wait until truly clickable
    	    wait.until(ExpectedConditions.elementToBeClickable(element));

    	    // 3. Click
    	    element.click();
    	}


       
       
       /**
        * Wait for the number of browser windows/tabs to be a specific count
        * @param driver WebDriver instance
        * @param numberOfWindows Expected number of windows
        * @param timeout Timeout in seconds
        */
       public static void waitForNumberOfWindowsToBe(WebDriver driver, int numberOfWindows, int timeout) {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
           wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
       }

}
    
    

