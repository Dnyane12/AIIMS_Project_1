package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleDropUtil {	
	private static final Logger logger = LogManager.getLogger(SimpleDropUtil.class);

	
	//method to select dropdown option using By class 
    public static void selectDropOption(WebDriver driver,By dropdownFieldBy,By optionFieldBy,String dropOption) {

    	if (dropOption == null || dropOption.trim().isEmpty()) {
            throw new IllegalArgumentException("dropOption text cannot be null or empty");
        }

        try {
            logger.info("Selecting dropdown option: {}", dropOption);

            // 1️⃣ Wait only for visibility (NOT clickable)
            WaitHelper.waitForVisible(driver, dropdownFieldBy, 10);

            WebElement dropField = driver.findElement(dropdownFieldBy);

            // 2️⃣ JS click for igx-input
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", dropField);

            dropField.sendKeys(dropOption);

            // 3️⃣ Wait for option popup
            WaitHelper.waitForClickable(driver, optionFieldBy, 10);
            driver.findElement(optionFieldBy).click();

            logger.info("Successfully selected dropdown option: {}", dropOption);

        } catch (Exception e) {
            logger.error("Failed to select dropdown option: {}", dropOption, e);
            throw e;
        }
    }
	

    
    
    
    //method to select dropdown option using WebElement
    public static void selectDropOption(WebDriver driver,WebElement dropField,WebElement dropOptionField,String dropOption) {
     if (dropOption == null || dropOption.trim().isEmpty()) {
     throw new IllegalArgumentException("Dropdown option text cannot be null or empty");
      }
      logger.info("Selecting dropdown option: {}", dropOption);

      try {
      WaitHelper.waitForClickable(driver, dropField, 10);
      dropField.click();
      dropField.clear();
      dropField.sendKeys(dropOption);

      WaitHelper.waitForClickable(driver, dropOptionField, 10);
      dropOptionField.click();

      logger.info("Successfully selected dropdown option: {}", dropOption);

      }catch (Exception e) {
      logger.error("Failed to select dropdown option: {}", dropOption, e);
      throw e;
    }
}

	
}
