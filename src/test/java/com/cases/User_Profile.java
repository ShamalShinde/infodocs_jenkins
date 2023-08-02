package com.cases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.listeners.AllureListener;
import com.pageObjects.*;
import com.base.Base;

@Listeners({ AllureListener.class })
public class User_Profile extends Base {
	public static Logger log = LogManager.getLogger(User_Profile.class.getName());

	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Succesfully opened the browser");

		driver.get(prop.getProperty("url"));
		if (driver.getCurrentUrl().equals(prop.getProperty("url"))){
			log.info("Successfully opened the url of InfoDocs Application");
		} else {
			log.info("Failed to opened the url of InfoDocs Application");
		}

	}

	@Test(dataProvider = "getData")
	public void userProfileNavigation(String Username, String Password) throws IOException, InterruptedException {

		Login_main login = new Login_main(driver);
		login.getUsername().sendKeys(Username);
		login.getPassword().sendKeys(Password);
		login.clickLogin().click();
		login.clickPopup().click();
		login.clickLogin2().click();
		login.clickPopup2().click();
		Thread.sleep(3000);

		User_Settings_main User = new User_Settings_main(driver);
		

		User.getProfileDropdown().click();
		Assert.assertTrue(User.getProfileDropdown().isEnabled(), "The profile dropdown element is not enabled ");
		Thread.sleep(3000);
		
		User.getUserSetting().click();
		Thread.sleep(3000);
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/User/UserSetting")) {
			log.info("navigated on usersettings next page");
		} else {
			log.info("Failed to navigate on user settings  page");
		}
		User.clickEditAccount().click();
		Assert.assertTrue(User.clickEditAccount().isEnabled(), "Edit Account tab is not clickable.");
		Thread.sleep(3000);
		User.getFirstName().clear();
		Assert.assertTrue(User.getFirstName().isEnabled(), "first name textbox is not clickable.");
		User.getFirstName().sendKeys("Vishal");
		User.getLastName().clear();
		Assert.assertTrue(User.getLastName().isEnabled(), "last name textbox is not clickable.");
		User.getLastName().sendKeys("Gharate");
		User.getEmail().clear();
		Assert.assertTrue(User.getEmail().isEnabled(), "Email textbox is not clickable.");
		User.getEmail().sendKeys("vishal.gharate@writerinformation.com");
		User.getPhone().clear();
		Assert.assertTrue(User.getPhone().isEnabled(), "phone text box is not clickable.");
		User.getPhone().sendKeys("8329556301");
		User.clickChangeprofilepicture();
		Assert.assertTrue(User.clickChangeprofilepicture().isEnabled(), " change profile button is not clickable.");
		User.clickUpdateInformation().click();
		Assert.assertTrue(User.clickOKUserSettings().isEnabled(), "ok popup button  is not clickable.");
		User.clickOKUserSettings().click();
//		Assert.assertTrue(User.getChangePassowrd().isEnabled(), "change password textbox box is not clickable.");
//		User.getChangePassowrd().click();
//		Assert.assertTrue(User.getOldPassword().isEnabled(), " old password textbox box is not clickable.");
//		User.getOldPassword().sendKeys("Writer@456");
//		Assert.assertTrue(User.getNewPassowrd().isEnabled(), "newpassword textbox box is not clickable.");
//		User.getNewPassowrd().sendKeys("Sky#1234");
//		Assert.assertTrue(User.getConfirmPassword().isEnabled(), "confirmpassword textbox box is not clickable.");
//		User.getConfirmPassword().sendKeys("Sky#1234");
//		Assert.assertTrue(User.clickResetPassword().isEnabled(), "resetpassword button box is not clickable.");
//		User.clickResetPassword().click();
//		Thread.sleep(3000);
//		Assert.assertTrue(User.clickOk().isEnabled(), "resetpassword button box is not clickable.");
//		User.clickOk().click();
//		driver.navigate().back();

		
		
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}
}
