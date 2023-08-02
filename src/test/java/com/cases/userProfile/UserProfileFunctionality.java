package com.cases.userProfile;

import java.io.IOException;
import java.time.Duration;

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
import com.listeners.AllureListener;
import com.base.Base;
import com.pageObjects.userProfile.UserProfileFunctionalityObject;
import com.pageObjects.*;

@Listeners({ AllureListener.class })
public class UserProfileFunctionality extends Base {
	public static Logger log = LogManager.getLogger(UserProfileFunctionality.class.getName());
	private WebDriverWait wait; 
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");

		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		log.info("Navigated to Home page");

	}

	@Test(dataProvider = "getData")
	public void UserProfileFunctionalityNavigation(String userName, String password) throws IOException, InterruptedException {

		Login_main login = new Login_main(driver);
		login.getUsername().sendKeys(userName);
		login.getPassword().sendKeys(password);
		login.clickLogin().click();
		login.clickPopup().click();
		login.clickLogin2().click();
		login.clickPopup2().click();
		Thread.sleep(3000);

		UserProfileFunctionalityObject userpage = new UserProfileFunctionalityObject(driver);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
	
		if (userpage.areAllElementsEnabled()) {
			log.info("All Elements of Home page are Present");
		} else {
			log.info("All Elements of Home page are not Present");
		}

		wait.until(ExpectedConditions.elementToBeClickable(userpage.checkUserProfileImg()));
		if (userpage.checkUserProfileImg().isDisplayed()) {
			log.info("Profile Photo icon is Present");
		} else {
			log.info("Profile Photo icon is Present");
		}

		if (userpage.areAllElementsClicked()) {
			log.info("All Dropdown Elements of User Profile are clickable");
		} else {
			log.info("All Dropdown Elements of User Profile are  not clickable");
		}
	
	    userpage.getUserProfile().click();
		Assert.assertTrue(userpage.getUserProfile().isDisplayed(), "Element is not displayed.");
		wait.until(ExpectedConditions.elementToBeClickable(userpage.getUserSetting()));
		userpage.getUserSetting().click();
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/User/UserSetting")) {
			log.info("navigated on usersettings next page");
		} else {
			log.info("Failed to navigate on user settings  page");
		}
		
		driver.quit();
		
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}

}
