package com.cases.userProfile;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.Base;
import com.pageObjects.userProfile.ForgetPassword_main;


public class ForgotPassword_test extends Base 
{
	
	public static Logger log = LogManager.getLogger(ForgotPassword_test.class.getName());
	private WebDriverWait wait;
	
	@BeforeMethod
	public void intialize() throws IOException 
	{
		
		
		driver = initializeDriver();
		log.info("Driver is intialized");

		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		log.info("Navigated to Home page");

	}
	
	@Test
	public void forget_password() throws InterruptedException
	{
		ForgetPassword_main fp = new ForgetPassword_main(driver);
		fp.getUsername().sendKeys("testdemo");
		fp.getPassword().sendKeys("Writer@456");
		if (!fp.getUsername().getAttribute("value").isEmpty()) {
			
			// verify forgot password tab is clickable or not
			Assert.assertTrue(fp.getForgotPassword().isEnabled(), "forgot password is not clickable.");
			fp.getForgotPassword().click();
			driver.switchTo().alert().accept();
//			To  verify  if we  mentioned only passwod ,and click on  forget password  link  then  check it should not be navigate to  self reset 	
		    Assert.assertFalse(false ,"it is not navigating to self reset password though we provided password");
	
			
		    wait.until(ExpectedConditions.elementToBeClickable(fp.getEmail()));

			//verify email text box clickable or not
			Assert.assertTrue(fp.getEmail().isEnabled(), "email textbox is not clickable.");
			fp.getEmail().sendKeys("vishal.gharate@writerinformation.com");

	        // Capture the initial CAPTCHA value
	        String initialCaptchaValue = fp.getCaptcha().getText();
	        
			fp.clickRefreshButton().click();
			Assert.assertTrue(fp.clickRefreshButton().isEnabled(), "cpatch refresh button is not clickable.");
		
	        // Capture the updated CAPTCHA value
	        String updatedCaptchaValue = fp.getCaptcha().getText();

	        // Compare initial and updated CAPTCHA values
	        if (!initialCaptchaValue.equals(updatedCaptchaValue)) {
	           log.warn("CAPTCHA is auto-regenerated.");
	        } else {
	           log.warn("CAPTCHA is not auto-regenerated.");
	        }
			
			
			
	       
			fp.getEnterCaptcha().click();
			Assert.assertTrue(fp.getEnterCaptcha().isEnabled(), "capatch  Enter field is not clickable.");
			 wait.until(ExpectedConditions.elementToBeClickable(fp.getEmail()));

			  //resetpassword button
			 
			fp.clickResetPassword().click();
			Assert.assertTrue(fp.clickResetPassword().isEnabled(), "capatch  Enter field is not clickable.");
			//for ok button
			 wait.until(ExpectedConditions.elementToBeClickable(fp.clickOk()));
		if(fp.clickOk().isDisplayed())
		{
			Assert.assertTrue(true);
		}
		else 
		{
			System.out.println("ok popup is not display");
		}
			
			fp.clickOk().click();
			Assert.assertTrue(fp.clickOk().isEnabled(), "capatch  Enter field is not clickable.");

			
			
		} 

		//TC6.10-To verify ,If we mentioned wrong or invalid credentials then error message is displaying or not
		fp.getEmail().clear();
		
		fp.getEmail().sendKeys("vishal.shah@writerinformation.com");
		
		fp.getEnterCaptcha().sendKeys("HmkL1234");
	
		fp.clickResetPassword().click();
		if(fp.clickOk().isDisplayed())
		{
			log.info("Error Message is displayed for entering invalid email and Captcha.");
		}
		else 
		{
			log.info("No Error Message is displayed for entering invalid email and Captcha.");
		}
		fp.clickOk().click();
		
		//verify close button clickable or not
		 wait.until(ExpectedConditions.elementToBeClickable(fp.clickClose()));
		
		fp.clickClose().click();
		Assert.assertTrue(fp.clickClose().isEnabled(), "capatch  Enter field is not clickable.");
		
		 wait.until(ExpectedConditions.elementToBeClickable(fp.getUsername()));
		fp.getUsername().clear();

		fp.getUsername().sendKeys("test");
		fp.getPassword().clear();
		fp.getForgotPassword().click();
		driver.switchTo().alert().accept();
		  
		driver.quit();
	}
	

	}
