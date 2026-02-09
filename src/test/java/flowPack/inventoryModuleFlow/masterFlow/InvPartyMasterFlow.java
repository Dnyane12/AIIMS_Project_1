package flowPack.inventoryModuleFlow.masterFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObjects.sales.master.SPartyMasterPage;
import utils.PropertyReader;
import utils.WaitHelper;

public class InvPartyMasterFlow {
	SPartyMasterPage pmpo; 
	WebDriver driver;
    PropertyReader propReader;
    
    public InvPartyMasterFlow(WebDriver driver) {
		this.driver = driver;
		pmpo =new SPartyMasterPage(driver);	
		propReader= new PropertyReader("salesModule/SPartyMasterTestData.properties");
	}


	
	//Test to create the new party in party master form.
		@Test
		public void creatingNewParty() {
			
			try {	
				
				//clicking Party Mst Link
				WaitHelper.waitForClickable(driver, pmpo.getPartyMasterLink(), 10);
				pmpo.clickPartyMstLink();
				Thread.sleep(1000);
				
				
				//clicking Create NewBtn
				WaitHelper.waitForClickable(driver, pmpo.getCreateNewBtn(), 10);				
				pmpo.clickCreateNewBtn();
				
				
				//clicking Party SubTypeDrop
				WaitHelper.waitForClickable(driver, pmpo.getPartySubTypeDrop(), 10);				
				pmpo.clickPartySubTypeDrop();
				
			
				Thread.sleep(500);
				//click PartyName
				WaitHelper.waitForClickable(driver, pmpo.getPartyName(), 10);
				pmpo.clickPartyName(propReader.getProperty("name"));
				
				
				//clicking party code
				WaitHelper.waitForClickable(driver, pmpo.getPartyaOrAccountCode(), 10);				
				pmpo.enterPartyOrAccountCode(propReader.getProperty("partyCode"));
				
				
				//clicking account group drop
				WaitHelper.waitForClickable(driver, pmpo.getAccountGroup(), 10);	
				pmpo.clickAccountGroup(propReader.getProperty("accountGroupLabel"),propReader.getProperty("accountGroupOpt"));
				
							
				// company type drop
				WaitHelper.waitForClickable(driver, pmpo.getCompanyTypeDrop(), 10);			
				pmpo.clickCompanyTypeDrop(propReader.getProperty("companyTypeLabel"),propReader.getProperty("companyTypeOPt"));
				
				
				//clicking gst type drop
				WaitHelper.waitForClickable(driver, pmpo.getGstTypeDrop(), 10);			
				pmpo.clickGstTypeDrop(propReader.getProperty("GSTTypeLabel"), propReader.getProperty("GSTTypeOpt"));
				
				
				//clicking and sending gst no
				WaitHelper.waitForClickable(driver, pmpo.getGstNo(), 10);					
				pmpo.clickGstNo(propReader.getProperty("GSTNo"));
				
				
				//clicking contact person no.
				WaitHelper.waitForClickable(driver, pmpo.getNameOrContactPersonName(), 10);			
				pmpo.clickNameOrContactPersonName(propReader.getProperty("contactPersonName"));
				
	    
				try {					  
				    
					WebElement contactNo1 = driver.findElement(
						    By.xpath("/html/body/app-root/div/app-wrappper-adm/app-templete-wrapper/div[1]/div/div/app-component-wrapper/div/app-customer-master/div/igx-tabs/div[2]/igx-tab-content[1]/div[2]/div/div[1]/app-g-mobile-all-mobileno[1]/div/igx-input-group/div[1]/div[3]/input")
						);

						((JavascriptExecutor) driver).executeScript(
						    "arguments[0].value = '(+91)987-654-3210';" +
						    "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
						    "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
						    contactNo1
						);


				} catch (Exception e) {
				    e.printStackTrace();
				}

			    WaitHelper.waitForClickable(driver, pmpo.getFssaiNo(), 10);
				pmpo.clickFssaiNo(propReader.getProperty("FssaiNo"));
				
				
			    WaitHelper.waitForClickable(driver, pmpo.getFssaiEffFrom(), 10);
				pmpo.clickFssaiEffFrom(propReader.getProperty("FssaiEffeFrom"));
				
				
				//ckicking fssai eff to
			    WaitHelper.waitForClickable(driver, pmpo.getFssaiEffectiveTo(), 10);				
				pmpo.clickFssaiEffectiveTo(propReader.getProperty("FssaiEffUpto"));
				
				Thread.sleep(1000);
				
				//Clicking Bank Details Tab
			    WaitHelper.waitForClickable(driver, pmpo.getAddressTab(), 10);			
				pmpo.clickAddressTab();
				
				
				//clicking address
			    WaitHelper.waitForClickable(driver, pmpo.getAddress(), 10);			
				pmpo.clickAddress(propReader.getProperty("address"));
				
				
				//clicking city
			    WaitHelper.waitForClickable(driver, pmpo.getCity(), 10);
				pmpo.clickcity(propReader.getProperty("city"));
				
				//clicking pin
			    WaitHelper.waitForClickable(driver, pmpo.getPin(), 10);				
				pmpo.clickPin();
				
				
			    WaitHelper.waitForClickable(driver, pmpo.getOtherTab(), 10);
				pmpo.clickOtherTab();
				
				
				//.until(ExpectedConditions.elementToBeClickable(pmpo.reportTag4Drop));
				
			    WaitHelper.waitForClickable(driver, pmpo.getReportTag4Drop(), 10);
				pmpo.clickReportTag4Drop(propReader.getProperty("reportTag4Label"),propReader.getProperty("reportTag4Opt"));
				
				
				//clicking submit button
			    WaitHelper.waitForClickable(driver, pmpo.getSubmitBtn(), 10);
				pmpo.clickSubmitBtn();
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
