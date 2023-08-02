package com.cases.HomePageTestCase;

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
import com.pageObjects.HomePage.HomePage;
import com.base.Base;
import com.pageObjects.Login_main;

@Listeners({ AllureListener.class })
public class HomePageTest extends Base {
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	private WebDriverWait wait;

	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();

		log.info("Succesfully opened the browser");

		driver.get(prop.getProperty("url"));

		wait = new WebDriverWait(driver, Duration.ofSeconds(90));

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password) throws IOException, InterruptedException {

		Login_main login = new Login_main(driver);
		login.getUsername().sendKeys(Username);
		login.getPassword().sendKeys(Password);
		login.clickLogin().click();
		login.clickPopup().click();
		login.clickLogin2().click();
		login.clickPopup2().click();

		HomePage home = new HomePage(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		// TC-1.1
	//	wait.until(ExpectedConditions.visibilityOf(home.HomePageDisplay()));
		Assert.assertTrue(home.HomePageDisplay().isDisplayed(), "Home page is  not Displayed");
		log.info("Home Page is Displayed");

		// TC-1.3
		Assert.assertTrue(home.WelcomeUserName().isDisplayed(), "Welcome UserName is  not Displayed");
		log.info("Welcome Username is Displayed");
		Assert.assertTrue(home.DateTime().isDisplayed(), "Date and Time is  not Displayed");
		log.info("Date and time is Displayed");

		// TC-1.4
		Assert.assertTrue(home.InfodocsLogo().isDisplayed(), "Date and Time is  not Displayed");
		log.info("Date and time is Displayed");

		// TC-1.8
		Assert.assertTrue(home.SharedWithMeTab().isDisplayed(), "Shared With ME Tab is  not Displayed");
		log.info("Shared with Me Tab is Displayed");

		// TC-1.9
		wait.until(ExpectedConditions.elementToBeClickable(home.SharedWithMeTab()));
		home.SharedWithMeTab().click();
		Assert.assertTrue(home.SearchByWindowDrop().isDisplayed(), "Search By Window is  not Displayed");
		log.info("Search By Window is Displayed");
		home.scrollToElement();
		// TC-1.10
		Assert.assertTrue(home.RecycleBinTab().isDisplayed(), "Recycle been Tab is  not Displayed");

		// TC-1.11
		wait.until(ExpectedConditions.elementToBeClickable(home.RecycleBinTab()));
		home.RecycleBinTab().click();
//		Assert.assertTrue(home.RecycleBinTab().isDisplayed(), "Recycle been Tab is  not Clickable");
		log.info("Recycle Been Tab is Displayed");

		// TC-1.12
		wait.until(ExpectedConditions.elementToBeClickable(home.LinesOnHomePage()));
		home.LinesOnHomePage().click();
		Assert.assertFalse(home.RecycleBinTab().isDisplayed(),
				"After click on corner lines on home page it hide the tab of icon");
		log.info("After click on corner lines on home page it hide the tab of icon");
		home.LinesOnHomePage().click();
		// TC-1.13

		// TC-3.1
		home.Reporthover();
		Assert.assertFalse(home.AuditLog().isDisplayed(), "after clicking on Report icon then list is not displayed ");
		log.info("after clicking on Report icon then list is displayed ");

		// TC-3.2
		Assert.assertFalse(home.AuditLog().isDisplayed(), "Audit Log is not displayed ");
		log.info("Audit Log is  displayed ");
		Assert.assertFalse(home.MisReport().isDisplayed(), "Mis Report is not displayed ");
		log.info("Mis Report is  displayed  ");
		Assert.assertFalse(home.userActivityReport().isDisplayed(), "User Activity Report not displayed ");
		log.info("User Activity Report displayed \" ");

		// TC-3.3
		wait.until(ExpectedConditions.elementToBeClickable(home.AuditLog()));
		home.AuditLog().click();
		Assert.assertFalse(home.AuditLog().isDisplayed(),
				"after clicking on any report if administrator gives the access then and then it’s open other wise it’s not");
		log.info("Audit Log is  displayed ");

		// TC-3.4
		Assert.assertFalse(home.AuditLog().isDisplayed(), "Audit Log is not displayed ");
		log.info("Audit Log is  displayed ");

		// TC-3.5
		Assert.assertFalse(home.AuditLogTitle().isDisplayed(),
				"After clicking on audit report it does not display the report .");
		log.info("After clicking on audit report it  display the report");

		// TC-3.6
		Assert.assertFalse(home.AuditLogDateTime().isDisplayed(), "file uploaded date & time is not displayed ");
		log.info("file uploaded date & time is displayed ");

		// TC-3.7
		Assert.assertFalse(home.AuditLogDateTime().isDisplayed(), "uploaded file is not shown in audit report ");
		log.info("uploaded file is  shown in audit report");

		// TC-3.10
		Assert.assertFalse(home.AuditLogDownload().isDisplayed(),
				" icon of downloading on left bottom side of the report is not present  ");
		log.info("icon of downloading on left bottom side of the report is present ");

		// TC-3.11
		home.Reporthover();
		wait.until(ExpectedConditions.elementToBeClickable(home.MisReport()));
		home.MisReport().click();
		Assert.assertFalse(home.MisReportTotal().isDisplayed(), "Mis Report is not Clickable");
		log.info("Mis Report is  Clickable");

		// TC-3.12
		Assert.assertFalse(home.MisReportTotal().isDisplayed(),
				"After clicking on MIS report it not shows the count of department wise documents available in the system");
		log.info(
				"After clicking on MIS report it shows the count of department wise documents available in the system");

		// TC-3.14
		home.Reporthover();
		wait.until(ExpectedConditions.elementToBeClickable(home.userActivityReport()));
		home.userActivityReport().click();
		Assert.assertFalse(home.UserActivityTotal().isDisplayed(), "User Activity Report is not Clickable");
		log.info("User Activity Report is  Clickable");

		// TC-3.15
		Assert.assertFalse(home.UserActivityTotal().isDisplayed(),
				"If click on the user activity report then it not display the total count of successful logins done by the users ");
		log.info(
				"If click on the user activity report then it display the total count of successful logins done by the users ");

		// TC-3.16
		Assert.assertFalse(home.UserActivityTotal().isDisplayed(),
				" user activity report not shows the login counts of last 7 & 30  days");
		log.info(" user activity report shows the login counts of last 7 & 30  days");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}

}
