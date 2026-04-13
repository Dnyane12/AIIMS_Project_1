package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class InputUtility {
	  
	public static void enterValueByLabel(WebDriver driver, String labelText, String inputIdPart, String inputValue) {
	        String xpath = "(//label[normalize-space(text())='" + labelText + "' " +
	                   "and contains(@id,'igx-label')]" +
	                   "/following::input[contains(@id,'" + inputIdPart + "')])[1]";
	        try {
	            WebElement input = driver.findElement(By.xpath(xpath));
	            input.click();
	            input.sendKeys(inputValue);
	            System.out.println("Entered value for label: " + labelText);
	        } catch (Exception e) {
	            System.out.println("Failed to enter value for label: " + labelText);
	            e.printStackTrace();
	        }
	    }
	}

