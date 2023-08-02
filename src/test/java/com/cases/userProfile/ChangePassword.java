package com.cases.userProfile;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.pageObjects.userProfile.ChangePasswordPage;
import com.pageObjects.*;
import com.base.Base;
import com.listeners.AllureListener;


	@Listeners({ AllureListener.class })
	public class ChangePassword extends Base {
		public static Logger log = LogManager.getLogger(ChangePassword.class.getName());
		private WebDriverWait wait;
		
		@BeforeMethod
		public void intialize() throws IOException {
			driver = initializeDriver();
			log.info("Driver is intialized");
		
			driver.get(prop.getProperty("url"));
			 wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			log.info("Navigated to Home page");

		}

		@Test(dataProvider = "getData")
		public void ChangePasswordFunctionality(String userName, String password) throws IOException, InterruptedException
		{

			Login_main login = new Login_main(driver);
			login.getUsername().sendKeys(userName);
			login.getPassword().sendKeys(password);
			login.clickLogin().click();
			login.clickPopup().click();
			login.clickLogin2().click();
			login.clickPopup2().click();
			Thread.sleep(3000);
			
			ChangePasswordPage changepw = new ChangePasswordPage(driver);
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		     wait.until(ExpectedConditions.elementToBeClickable(changepw.getProfileDropdown()));

		       changepw.getProfileDropdown().click();;
		        Assert.assertTrue(changepw.getProfileDropdown().isEnabled(), "The profile dropdown element is not enabled ");
		        wait.until(ExpectedConditions.elementToBeClickable(changepw.getUserSetting()));

		        changepw.getUserSetting().click();
		     //   wait.until(ExpectedConditions.elementToBeClickable(addfile.clickTestDemo()));
		        if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/User/UserSetting")) {
		            log.info("navigated on usersettings next page");
		        } else {
		            log.info("Failed to navigate on user settings  page");
		        }

		        //TC 5.1- To verify Change password window is clickable or not
		        Assert.assertTrue(changepw.getChangePassowrd().isEnabled(), "change password textbox box is not clickable.");
		        changepw.getChangePassowrd().click();

		        // TC 5.2 -To verify all the elements are present on Change password window or not

		        if (changepw.areAllElementsEnabled()) 
		        {
		            log.info("All Elements of change password tab are Present");
		        } else 
		        {
		            log.info("All Elements of change password tab are not Present");
		        }

		        // TC5.3-To verify all text fields are clickable or not

		        if (changepw.areAllElementsClicked())
		        {
		            log.info("All Text Fields of Change Password Tab are Clickable");
		        } else 
		        {
		            log.info("All Text Fields of Change Password Tab are  Not Clickable");
		        }
		        //TC5.4-To verify Text fields are taking inputs or not
		        String oldPass = password;
		        String NewPass = "Sky#123";
		        changepw.enterOldPassword(oldPass);
		        String enteredOldPass =changepw.getOldPassword().getAttribute("value");
				if (enteredOldPass.equals(oldPass))
				{
					log.info("Old Password Field is taking Input.");
				}
				else
				{
					log.info("Old Password Field is not taking Input.");
				}
				
		        changepw.enterNewPassowrd(NewPass);
		        String enteredNewPass =changepw.getNewPassowrd().getAttribute("value");
				if (enteredNewPass.equals(NewPass))
				{
					log.info("New Passowrd Field is taking Input.");
				}
				else
				{
					log.info("New Passowrd Field is not taking Input.");
				}
				
		        changepw.enterConfirmPassword(NewPass);
		        String enteredConfirmPass =changepw.getConfirmPassword().getAttribute("value");
				if (enteredConfirmPass.equals(NewPass))
				{
					log.info("Confirm Password Field is taking Input.");
				}
				else
				{
					log.info("Confirm Password Field is not taking Input.");
				}
				
				//TC 5.5 - To verify ,If we mentioned wrong or invalid credentials then error message is displaying or not
//				if(changepw.clickOk().isDisplayed())
//				{
//					changepw.clickOk().click();
//				}
				changepw.checkInvalidPassword();
	         //TC5.6-To verify ,If we mentioned wrong or invalid password (without alpha numeric combination) then error message is displaying or not
		      
		       changepw.checkWithoutAlphaNumericPass();
		       
	         //TC5.7 - To verify update button is present or not
		       
		       if(changepw.clickResetPassword().isDisplayed())
		       {
		    	  log.info("Update Password button is present");
		       }
		       else
		       {
		    	   log.info("Update Password button is not present");
		       }
		       
             //TC5.8 - To verify update button is clickable or not
		       
		      if(changepw.clickResetPassword().isEnabled())
		      {
		    	  log.info("Update Password button is clikable.");  
		      }
		      else 
		      {
		    	  log.info("Update Password button is clikable.");
		      }
		      driver.quit();
		}
		@DataProvider
		public Object[][] getData() 
		{
			Object[][] data = new Object[1][2];
			data[0][0] = "testdemo";
			data[0][1] = "Writer@456";

			return data;
		}
  
}