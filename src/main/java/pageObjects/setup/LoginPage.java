package pageObjects.setup;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.SetUp;
import utils.WaitHelper;

public class LoginPage{
	
private static final Logger logger = LogManager.getLogger(LoginPage.class);
WebDriver driver;



public LoginPage(WebDriver driver) {
   logger.info("called LoginPage constructor in LoginPage");
   this.driver= driver;
   PageFactory.initElements(driver, this);      
}


//Locators
 @FindBy(xpath="//input[contains(@class,'is-invalid')]")
 private WebElement usernameField ;
 @FindBy(xpath="//input[@id='gmd_Password']")
 private WebElement passwordField ;
 @FindBy(xpath="//button[@id='gmd_Login-width-selector']")
 WebElement loginBtnField; 
 @FindBy(xpath="//div[normalize-space(text())='Login Successful' and @class='igx-snackbar__message']")
 private WebElement loginSussMessageField;
 @FindBy(xpath="//label[normalize-space(text())='Incorrect LoginID or Password']")
 private WebElement errorMsgField;
 @FindBy(xpath="//span[normalize-space(text())='account_circle' and contains(@class,'profile')]")
 private WebElement homePageProfileLogo;
 @FindBy(xpath="/html/body/div/div/div/div/div/div/div[2]/div[1]/div[2]/span")
 private WebElement user;
 @FindBy(xpath="//button[@id='details-button']")
 private WebElement advanceBtn;
 @FindBy(xpath="//a[normalize-space(text())='Proceed to dinshawserpuat.microproindia.com (unsafe)']")
 private WebElement dinUrlUnsafe;
 
 
 
 
 
 
 
 
 //Actions methods
 public void clickAdvanceBtn() {
	 WaitHelper.waitForClickable(driver, advanceBtn, 10);
	 advanceBtn.click();
	 WaitHelper.waitForClickable(driver, dinUrlUnsafe, 10);
	 dinUrlUnsafe.click();
 }
 
 
 public void enterUsernameField(String username) {
	 WaitHelper.waitForClickable(driver, usernameField, 10);
	 usernameField.click();
	 usernameField.sendKeys(username);
 }
 public void enterPasswordField(String password) {
	 WaitHelper.waitForClickable(driver, passwordField, 10);
	 passwordField.click();
	 passwordField.sendKeys(password);
 }
 public void clickLoginButton() {
	 loginBtnField.click();
 }
 public String getloginMessage() {
	return loginSussMessageField.getText();	
}

 public String geterrorMessage() {
	return errorMsgField.getText();	
}

 public void getLoginUser() throws InterruptedException {
	homePageProfileLogo.click();
	Thread.sleep(1000);
	user.getText();
}
public WebElement getUsernameField() {
	return usernameField;
}
public WebElement getPasswordField() {
	return passwordField;
}
public WebElement getLoginBtnField() {
	return loginBtnField;
}
public WebElement getLoginSussMessageField() {
	return loginSussMessageField;
}
public WebElement getErrorMsgField() {
	return errorMsgField;
}
public WebElement getHomePageProfileLogo() {
	return homePageProfileLogo;
}
public WebElement getUser() {
	return user;
}
public static Logger getLogger() {
	return logger;
}
public WebDriver getDriver() {
	return driver;
}



//Getters and Setters
 
 
}
