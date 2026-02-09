package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.PropertyReader;

public class SetUp {

    public static WebDriver driver;
    public static PropertyReader prop;
    private static final Logger logger = LogManager.getLogger(SetUp.class);
    public static boolean isDriverInitialized = false;

    @BeforeClass(alwaysRun = true)
    public void basicSetting() {
    	try {
    		logger.info("calling basicSetting(), @Before Method in SetUp class");
    		prop = new PropertyReader("InventoryModule/application.properties");
    		System.out.println("prop:"+prop);
    	
    	if(!isDriverInitialized) {
    	 String browserName = prop.getProperty("browser");
    	 System.out.println("browserName:"+browserName);
    	 //using debug type of logger level to debug the browser name.
    	 logger.debug("Browser name from property file :"+browserName);
    	
    	
    	 
    			switch(browserName.toLowerCase()) {
    			case "chrome":
    				System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
    				driver= new ChromeDriver();
    				//using debug type of logger level to debug the driver initilized properly or not.
    				logger.debug("WebDriver has been Innitilised with driver of type :"+driver);
    				System.out.println("chrome driver properly initilised");
    				break;			
    			case "firefox":
    				System.setProperty("webdriver.firefox.driver", "");
    				driver= new FirefoxDriver();
    				logger.info("WebDriver has been Innitilised with driver of type :"+driver);
    			    break;
    			case "eage":
    				System.setProperty("webdriver.edge.driver", "");
    		         driver= new EdgeDriver();
    		         logger.info("WebDriver has been Innitilised with driver of type :"+driver);
    		         break;		         
    			default: 
    				System.out.println("Invalide browser!,cant login");
    				//using warn ,logger level to provide warning message.
    				logger.warn("Invalid browser name,execution can not be continue !"+browserName);
    				//using fatal,logger level to provide the high level fatal issue.
    				logger.fatal("Execution stoped due to unsupported browser.");
    				return;					
    	         }				
    		// Wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    			isDriverInitialized =true;
             }
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}

  

//    @AfterClass(alwaysRun = true)
//    public void tearDown() {
//        if (driver != null) {
//            logger.info("Closing browser and quitting driver");
//            driver.quit();
//            isDriverInitialized = false;
//        }
//    }
}