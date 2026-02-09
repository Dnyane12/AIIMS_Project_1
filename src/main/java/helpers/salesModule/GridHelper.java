package helpers.salesModule;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GridHelper {

	public static void scrollGridToRight(WebDriver driver, WebElement scroller){
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", scroller);
	     try {
			Thread.sleep(100);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }
	}

}
