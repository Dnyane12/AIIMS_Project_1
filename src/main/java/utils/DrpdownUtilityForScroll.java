//package utils;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import Test.setUpTests.SetUp;
//
//public class DrpdownUtilityForScroll extends SetUp{
//	private static void selectItemFromVirtualDropdownByScroll(WebDriver driver, WebDriverWait wait ,
//            String dropdownInputXpath,
//            String itemToSelect,
//            int maxScrollAttempts) throws InterruptedException {
//WebElement dropdownInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownInputXpath)));
//dropdownInput.click();
//
//itemToSelect = itemToSelect.trim();
//JavascriptExecutor js = (JavascriptExecutor) driver;
//
//// Use the outer container that holds the virtual scroll
//WebElement dropdownPanel = wait.until(ExpectedConditions.presenceOfElementLocated(
//By.xpath("//div[contains(@class,'igx-overlay__content')]")
//));
//
//for (int i = 0; i < maxScrollAttempts; i++) {
//    List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class,'igx-overlay__content')]//span"));
//    for (WebElement item : items) {
//        if (item.getText().trim().equalsIgnoreCase(itemToSelect)) {
//            js.executeScript("arguments[0].scrollIntoView(true);", item);
//            Thread.sleep(200);
//            item.click();
//            return;
//        }
//    }
//
//    // Scroll container if item not found
//    js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 100;", dropdownPanel);
//    Thread.sleep(300);
//}
//
//throw new NoSuchElementException("Unable to locate item: " + itemToSelect + " after " + maxScrollAttempts + " scroll attempts");
//}
//
//}
