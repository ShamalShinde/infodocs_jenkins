package com.cases.userpreference;

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
import com.listeners.AllureListener;
import com.actions.Actions;
import com.base.Base;
import com.pageObjects.Login_main;
import com.pageObjects.userpreference.*;

@Listeners({ AllureListener.class })
public class UserPreferenceFunctionality extends Base {
	public static Logger log = LogManager.getLogger(UserPreferenceFunctionality.class.getName());
	public Actions actions;
	private WebDriverWait wait;
	
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");
		
		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		log.info("Navigated to Home page");
		actions = new Actions(driver);
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password) throws IOException, InterruptedException {

		Login_main login = new Login_main(driver);
		login.getUsername().sendKeys(userName);
		login.getPassword().sendKeys(password);
		login.clickLogin().click();
		login.clickPopup().click();
		login.clickLogin2().click();
		login.clickPopup2().click();
		

		UserPreferenceFunctionalityObj userpref = new UserPreferenceFunctionalityObj(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
	  
		// TC-1.1 To verify all the elements are present on user home page or not

		if (userpref.areAllElementsEnabled()) {
			log.info("All Elements of Home page are Present");
		} else {
			log.info("All Elements of Home page are not Present");
		}

		// TC-1.2 To verify on user home page user profile window #private workspace is
		// present on left side or not
		Assert.assertTrue(userpref.clickPrivateWorkSpace().isDisplayed(),"User home page user profile window (private workspace) is not present");
		wait.until(ExpectedConditions.elementToBeClickable(userpref.clickTestDemo()));

		// TC-1.3 To verify user profile window is clickable or not
		Assert.assertTrue(userpref.clickTestDemo().isEnabled(), "Test Demo is not clickable.");
		actions.click(userpref.clickTestDemo());
		

		// TC-1.4 To verify after clicking on user profile window ,it is navigating to
		// next page/window or not
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/Folder/ViewFolder?PrjFldType=TestDemo&FolderId=224873&IsDept=N")) {
			log.info("navigated on usersettings next page");
		} else {
			log.info("Failed to navigate on user settings  page");
		}

		// TC-1.5 To verify after clicking on user profile it displays the next window
		// including my work space,my favorite,
		// my recent file,inbox,outbox,rejected documents or not

		Assert.assertTrue(userpref.clickMyWorkSpace().isDisplayed(), "My Workspace is not displayed");
		Assert.assertTrue(userpref.clickMyFavorites().isDisplayed(), "My Favorites is not displayed");
		Assert.assertTrue(userpref.clickMyRecentFiles().isDisplayed(), "My Recent Files is not displayed");
		Assert.assertTrue(userpref.clickInbox().isDisplayed(), "Inbox is not displayed");
		Assert.assertTrue(userpref.clickOutbox().isDisplayed(), "Outbox is not displayed");
		Assert.assertTrue(userpref.clickRejectedDocuments().isDisplayed(), "Rejected Documents is not displayed");

		// TC-1.6 To verify my work space,my favorite, my recent
		// file,inbox,outbox,rejected documents are clickable or not
		Assert.assertTrue(userpref.clickMyWorkSpace().isEnabled(), "My Workspace is not clickable");
		Assert.assertTrue(userpref.clickMyFavorites().isEnabled(), "My Favorites is not clickable");
		Assert.assertTrue(userpref.clickMyRecentFiles().isEnabled(), "My Recent Files is not clickable");
		Assert.assertTrue(userpref.clickInbox().isEnabled(), "Inbox is not clickable");
		Assert.assertTrue(userpref.clickOutbox().isEnabled(), "Outbox is not clickable");
		Assert.assertTrue(userpref.clickRejectedDocuments().isEnabled(), "Rejected Documents is not clickable");
		
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
