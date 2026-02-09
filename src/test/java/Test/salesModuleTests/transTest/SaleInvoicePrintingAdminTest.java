//package Test.salesModuleTests.transTest;
//
//import base.SetUp;
//import pageObjects.sales.transaction.SaleInvoicePrintingAdminRepPage;
//
//public class SaleInvoicePrintingAdminTest extends SetUp{
//	SaleInvoicePrintingAdminRepPage saleInvPage;
//	
//	
//	public void objIn()
//	{
//		saleInvPage= new SaleInvoicePrintingAdminRepPage(driver);
//		
//	}
//	
//	
//	
//	public void searchInvoice(String invoiceNo) {
//	    safeSendKeys(saleInvPage.getInvoiceSearchInput(), invoiceNo);
//	}
//
//	public void selectFromDate(String date) {
//	    safeSendKeys(saleInvPage.getFromDateInput(), date);
//	}
//
//	public void selectToDate(String date) {
//	    safeSendKeys(saleInvPage.getToDateInput(), date);
//	}
//
//	private void selectFromIgniteDropdown(WebElement dropdown, String value) {
//	    safeClick(dropdown);
//	    wait.until(ExpectedConditions.visibilityOfAllElements(
//	        saleInvPage.getActiveDropdownOptions()
//	    ));
//
//	    for (WebElement option : saleInvPage.getActiveDropdownOptions()) {
//	        if (option.getText().trim().equalsIgnoreCase(value)) {
//	            safeClick(option);
//	            return;
//	        }
//	    }
//	    throw new RuntimeException("Option not found: " + value);
//	}
//
//
//    
//    public void selectInvoiceType(String invoiceType) {
//        selectFromIgniteDropdown(invoiceTypeDropdown, invoiceType);
//    }
//
//    
//    public void selectDispatchNo(String dispatchNo) {
//        selectFromIgniteDropdown(dispatchNoDropdown, dispatchNo);
//    }
//
//    
//    public void clickView() {
//        safeClick(viewButton);
//    }
//
//    
//    public void clickExport() {
//        safeClick(exportButton);
//    }
//
//    
//    public void printFirstInvoice() {
//        wait.until(ExpectedConditions.visibilityOfAllElements(printIcons));
//        safeClick(printIcons.get(0));
//    }
//
//    
//
//}
