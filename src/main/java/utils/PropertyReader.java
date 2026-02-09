package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyReader {
	Properties prop;
	
	public PropertyReader(String fileName) {
		try {
			prop = new Properties();
            InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(fileName);
			prop.load(input);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	 }
	
	public String getProperty(String key) {
		return prop.getProperty(key);		
	}
}
