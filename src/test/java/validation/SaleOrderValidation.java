package validation;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import flowPack.salesModuleFlow.transactionFlow.MultiSaleOrderFlow;
import pageObjects.sales.transaction.MultiSaleOrderPage;
import utils.DatabaseUtility;
import utils.PropertyReader;


public class SaleOrderValidation {
 WebDriver driver;
 MultiSaleOrderPage saleObj;
 MultiSaleOrderFlow saleOFlow;
 PropertyReader propReader;
 private static final Logger logger = LogManager.getLogger(SaleOrderValidation.class);

 
public SaleOrderValidation(WebDriver driver) {
	this.driver=driver;
	saleOFlow =new MultiSaleOrderFlow(driver);
	propReader= new PropertyReader("salesModule/MultiSaleOrderTestData.properties");
	saleObj=new MultiSaleOrderPage(driver);
}




public  String getSaleOrderStatus() {
	String actualSOStatusInDB="";
	logger.info("getSaleOrderStatus() method in SaleOrderValidation class");
	String partyId=propReader.getProperty("partyId");
	saleOFlow.createMultiSaleOrder();
    String query =
            "SELECT t.sorh_doc_no, t.sorh_status " +
            "FROM sl_so_hdr t " +
            "WHERE t.sorh_party_id_acnt = ? " +
            "AND DATE(t.sorh_dt) = CURRENT_DATE " +
            "ORDER BY t.createdon DESC " +
            "LIMIT 1";
    
    Map<String, String> result = new HashMap<>();
    try (ResultSet rs = DatabaseUtility.executeSelectQuery(query, partyId)) {
        if (rs.next()) {
            result.put("sorh_doc_no", rs.getString("sorh_doc_no"));
            result.put("sorh_status", rs.getString("sorh_status"));
            
            String saleOrderNoInDB= rs.getString("sorh_status"); 
            actualSOStatusInDB= rs.getString("sorh_status");           
           logger.info("actualSOStatusInDB: "+actualSOStatusInDB+", saleOrderNoInDB: "+saleOrderNoInDB);
         }
    }catch(Exception e) {
    	e.printStackTrace();
    }
	return actualSOStatusInDB;
}



public  String getSaleOrderNo() {
	String saleOrderNoInDB="";
	logger.info("getSaleOrderStatus() method in SaleOrderValidation class");
	String partyId=propReader.getProperty("partyId");
	saleOFlow.createMultiSaleOrder();
    String query =
            "SELECT t.sorh_doc_no, t.sorh_status " +
            "FROM sl_so_hdr t " +
            "WHERE t.sorh_party_id_acnt = ? " +
            "AND DATE(t.sorh_dt) = CURRENT_DATE " +
            "ORDER BY t.createdon DESC " +
            "LIMIT 1";
    
    Map<String, String> result = new HashMap<>();
    try (ResultSet rs = DatabaseUtility.executeSelectQuery(query, partyId)) {
        if (rs.next()) {
            result.put("sorh_doc_no", rs.getString("sorh_doc_no"));
            result.put("sorh_status", rs.getString("sorh_status"));
            
            saleOrderNoInDB= rs.getString("sorh_status"); 
            String actualSOStatusInDB= rs.getString("sorh_status");           
           logger.info("saleOrderNoInDB: "+saleOrderNoInDB);
         }
    }catch(Exception e) {
    	e.printStackTrace();
    }
	return saleOrderNoInDB;
}




	//The test(method) should fail in case of having value NR.
	public  void validateGridInputsNotNR(MultiSaleOrderPage saleObj, WebDriver driver, SoftAssert softAssert) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long lastScrollLeft = -1;

		while (true) {
			long currentScrollLeft =((Number) js.executeScript("return arguments[0].scrollLeft;",saleObj.getTopScroller())).longValue();
			// STOP when scrolling no longer moves
			if (currentScrollLeft == lastScrollLeft) {
				break;
			}
			lastScrollLeft = currentScrollLeft;
			for (WebElement e : saleObj.getInputBoxesList()) {
				if (!e.isDisplayed())
					continue;

				String value = e.getAttribute("value");
				if (value == null)
					value = "";

				System.out.println("Item grid value extract: [" + value + "]");
				softAssert.assertNotEquals(value, "NR", "Item without pricelist found for selected party");
			}
	
			//ACTUAL horizontal scroll
			js.executeScript("arguments[0].scrollLeft += 250", saleObj.getTopScroller());
			try {
				Thread.sleep(400);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		  }
		    softAssert.assertAll();
	  }
	
	
	

	
}
