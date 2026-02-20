package flowPack.productionFlow;

import org.openqa.selenium.WebDriver;

import pageObjects.production.ProcessTransactionPage;

public class ProcessTransactionFlow {
	WebDriver driver;
	ProcessTransactionPage procTransPage;
	
	public ProcessTransactionFlow(WebDriver driver) {
		this.driver = driver;
		procTransPage = new ProcessTransactionPage(driver);
	}
	
	
	public void createProcTransFlow() {
		
	}
	
}
