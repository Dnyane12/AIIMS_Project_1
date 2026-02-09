package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
   	    // ExtentHtmlReporter----UI reporter (HTML file) — decides how the report looks
   	    //Main class for generating the report and attaching reporters/use to popullate common info of the report
   	  // Represents an individual test case (to log pass/fail info)/creating test case entries in the report and update status of the test methods
   	    
   	 
	public static ExtentReports extent;

	public static ExtentReports getInstance() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "/reports/index.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Dnyaneshwari");
        }
        return extent;
    }
   	    
   	  
   	    
}
