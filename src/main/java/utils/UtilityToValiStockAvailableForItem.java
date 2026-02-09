//package utils;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//
//import Test.setUpTests.SetUp;
//
//public class UtilityToValiStockAvailableForItem extends SetUp{
//	
//	public static void validateStockAvailableForItem(String itemName, String expectedStock) {
//	    // Get all column headers
//	    List<WebElement> headers = driver.findElements(By.xpath("//igx-grid-header//span[@class='igx-grid__th-title']"));
//
//	    int itemColIndex = -1;
//	    int stockColIndex = -1;
//
//	    for (int i = 0; i < headers.size(); i++) {
//	        String colName = headers.get(i).getText().trim();
//	        if (colName.equalsIgnoreCase("Item")) {
//	            itemColIndex = i + 1; // XPath is 1-based
//	        } else if (colName.toLowerCase().contains("stock")) {
//	            stockColIndex = i + 1;
//	        }
//	    }
//
//	    if (itemColIndex == -1 || stockColIndex == -1) {
//	        throw new RuntimeException("❌ Required columns not found.");
//	    }
//
//	    
//	    // Get all grid rows
//	    List<WebElement> rows = driver.findElements(By.xpath("//div[@class='igx-grid__tbody']//igx-grid-row"));
//
//	    boolean itemFound = false;
//
//	    for (WebElement row : rows) {
//	        String itemText = row.findElement(By.xpath(".//igx-grid-cell[" + itemColIndex + "]")).getText().trim();
//	        
//	        if (itemText.equalsIgnoreCase(itemName)) {
//	            itemFound = true;
//	            String stockAvailable = row.findElement(By.xpath(".//igx-grid-cell[" + stockColIndex + "]")).getText().trim();
//	            Assert.assertEquals(stockAvailable, expectedStock, "❌ Stock mismatch for item: " + itemName);
//	            System.out.println("Item '" + itemName + "' has correct stock: " + expectedStock);
//	            break;
//	        }
//	    }
//
//	    if (!itemFound) {
//	        throw new RuntimeException("❌ Item not found in grid: " + itemName);
//	    }
//	}
//
//}
