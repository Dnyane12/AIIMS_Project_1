package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	public static String takeScreenshot(WebDriver driver, String testName) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = "./screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
        FileUtils.copyFile(src, new File(path));
        return path;
    }
}
