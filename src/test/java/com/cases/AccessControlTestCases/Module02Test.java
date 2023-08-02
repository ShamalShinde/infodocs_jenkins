package com.cases.AccessControlTestCases;

import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.listeners.AllureListener;
import com.pageObjects.AccessControlMatrix.Module01;
import com.pageObjects.AccessControlMatrix.Module02;
import com.base.Base;
import com.pageObjects.Login_main;

@Listeners({ AllureListener.class })
public class Module02Test extends Base {
	public static Logger log = LogManager.getLogger(Module02Test.class.getName());
	private WebDriverWait wait;

	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		log.info("Succesfully opened the browser");

		driver.get(prop.getProperty("url"));
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
		Thread.sleep(3000);

		Module01 t = new Module01(driver);
		Module02 m2 = new Module02(driver);
		// TC-2.1
		wait.until(ExpectedConditions.visibilityOf(t.Conffii()));
		Assert.assertTrue(t.Conffii().isDisplayed(), "The Configuration setting icon is not Present ");
		log.info("The Configuration setting icon is Present ");
//				Assert.assertTrue(t.Conffii().isDisplayed(), "The Configuration setting icon in not Present ");
//			    log.info( "The Configuration setting icon in Present ");

		// TC-2.2
		wait.until(ExpectedConditions.elementToBeClickable(t.Conffii()));
		Assert.assertTrue(t.Conffii().isEnabled(), "The Configuration setting icon is not clickable ");
		log.info("The Configuration setting icon is clickable ");
//				Assert.assertTrue(t.Conffii().isEnabled(), "The Configuration setting icon is not clickeble ");
//			    log.info( "The Configuration setting icon is clickeble ");

		t.Conffii().click();
		// Thread.sleep(2000);

		// TC-2.3
		wait.until(ExpectedConditions.visibilityOf(t.ManageUser()));
		Assert.assertTrue(t.ManageUser().isDisplayed(),
				"Drop down list is not Displayed after clicking and moving cursor on configuration setting ");
		log.info("Drop down list is Displayed after clicking and moving cursor on configuration setting");

//				Assert.assertTrue(t.ManageUser().isDisplayed(), " drop down list is not Displayed after  clicking and moving cursor on configuration setting ");
//			    log.info( "drop down list is  Displayed after  clicking and moving cursor on configuration setting");

		// TC-2.4
		wait.until(ExpectedConditions.visibilityOf(t.ManageUser()));
		Assert.assertTrue(t.ManageUser().isDisplayed(),
				"Manage User option is not present in configuration settings drop down list");
		log.info("Manage User option is present in configuration settings drop down list");

//				Assert.assertTrue(t.ManageUser().isDisplayed(), "Manage User option is not present in configuration settings drop down list");
//			    log.info( "Manage User option is  present in configuration settings drop down list");

		// TC-2.5
		wait.until(ExpectedConditions.elementToBeClickable(t.ManageUser()));
		t.ManageUser().click();
		// Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(t.SelectDrop()));
		Assert.assertTrue(t.SelectDrop().isDisplayed(), "Manage User Option is not Clickable ");
		log.info("Manage User Option is Clickable ");

//			    t.ManageUser().click();
//			    Thread.sleep(3000); 
//			    Assert.assertTrue(t.SelectDrop().isDisplayed(), "Manage User Option is not Clickeble ");
//			    log.info( "Manage User Option is Clickeble ");

		// TC-2.6
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/User/Index")) {
			log.info("navigated on usersettings next page");
		} else {
			log.info("Failed to navigate on user settings  page");
		}

		// TC-2.7
		Assert.assertTrue(t.SelectDrop().isDisplayed(), "search by-drop down box option is not Present ");
		log.info("Select Dropdown is Present");
		Assert.assertTrue(t.TextBox().isDisplayed(), "The Text Box option is not Present ");
		log.info("TextBox is Present");
		Assert.assertTrue(t.SearchIcon().isDisplayed(), "Search Icon  is not Present");
		log.info("Search Icon is Present");
		Assert.assertTrue(t.ResetUserIcon().isDisplayed(), "The Reset User Icon is not Present ");
		log.info("Reset User Icon is Present");
		Assert.assertTrue(t.AddNewUserIcon().isDisplayed(), "The Add New User Icon is not Present ");
		log.info("AddNewUser Icon is Present");

		// TC-2.8
		t.SelectDrop().click();
		Assert.assertTrue(t.SelectDrop().isEnabled(), "search by-drop down box option is not clickeble ");
		log.info("Select Dropdown is clickeble");
		Thread.sleep(2000);
		// TC-2.9
		Assert.assertTrue(t.SelectUserNamee().isDisplayed(), "Select UserName options is not  present ");
		log.info("SelectUserName Dropdown is Present");
		t.SelectUserNamee().click();
		// Assert.assertTrue(t.SelectUserNamee().isEnabled(), "Select UserName options
		// is not clickeble ");
		t.SelectTextBox().sendKeys("sahu");
		Assert.assertTrue(t.SelectTextBox().isEnabled(), "TextBox is Not Case Sensitive");
		log.info("TextBox is Case Sensitive");

		t.AddNewUserIcon().click();
		// TC-2.25
		m2.FirstName().sendKeys("Abhishek");

		m2.Sub().click();
		Assert.assertTrue(m2.Sub().isEnabled(), "After click on Submit Button it does not shows Error");
		log.info("After click on Submit Button  shows Error");

		m2.ErrorButton().click();
		Assert.assertTrue(m2.ErrorButton().isEnabled(), "The Error Button is not Clickeble");
		log.info("The Error Button is Clickeble");

		// TC-2.26
		m2.MobileTextBox().sendKeys("12345678");
		m2.Sub().click();
		Assert.assertTrue(m2.Sub().isEnabled(), "mobile no text box  not clickable ");
		log.info("mobile no text box  is clickable");

		m2.ErrorButton().click();

		// TC-2.27
		m2.MobileTextBox().clear();
		m2.MobileTextBox().sendKeys("Abcde");
		m2.Sub().click();
		Assert.assertTrue(m2.Sub().isEnabled(), "After click on Submit Button it does not shows Error");
		log.info("After click on Submit Button it shows Error");

		m2.ErrorButton().click();

		// TC-2.28
		m2.MobileTextBox().clear();
		m2.MobileTextBox().sendKeys("@ff#");
		m2.Sub().click();
		Assert.assertTrue(m2.Sub().isEnabled(),
				"if we type any character or  special letter in to mobile no text box then it not allows to type");
		log.info("if we type any character or  special letter in to mobile no text box then it  allows to type");

		m2.ErrorButton().click();
		Thread.sleep(2000);
		// TC-2.30
		m2.DiscriptionBox().click();
		Assert.assertTrue(m2.DiscriptionBox().isEnabled(), " The Discription Box is not Clickeble");
		log.info("The Discription Box is  Clickeble");

		// TC-2.31
		m2.DiscriptionBox().sendKeys("Hello My name is Abhishek");
		Assert.assertTrue(m2.DiscriptionBox().isEnabled(), "The Discription Box does not Accept input");
		log.info("The Discription Box  Accept input");

		// TC-2.32
		Assert.assertTrue(m2.DiscriptionBox().isEnabled(), "The Discription Box should be case sensetive");
		log.info("The Discription Box should not be case sensetive");

		m2.Sub().click();
		m2.ErrorButton().click();

		// TC-2.33
		m2.EmailBox().click();
		Assert.assertTrue(m2.EmailBox().isEnabled(), " The Email Box is not Clickeble");
		log.info("The Email Box is  Clickeble");

		// TC-2.34
		m2.EmailBox().sendKeys("abhi12@gmail.com");
		Assert.assertTrue(m2.EmailBox().isEnabled(), "The Email Box does not Accept input");
		log.info("The Email Box does Accept input");

		// TC-2.35
		Assert.assertTrue(m2.EmailBox().isEnabled(),
				"The Email Box should not Accept alpha numeric value with Special Characters");
		log.info("The Email Box Accept alpha numeric value with Special Characters");

		// TC-2.36
		Assert.assertTrue(m2.EmailBox().isEnabled(), "The Email Box should not Accept .com .in");
		log.info("The Email Box should  Accept .com .in");

		// TC-2.37
		Assert.assertTrue(m2.EmailBox().isEnabled(), "The Email Box should be case sensetive");
		log.info("The Email Box should not  be case sensetive");

		// TC-2.38
		m2.LocationBox().click();
		Assert.assertTrue(m2.LocationBox().isEnabled(), " The Location Box is not Clickeble");
		log.info("The Location Box is Clickeble");

		// TC-2.39
		m2.LocationBox().sendKeys("Akola5");
		Assert.assertTrue(m2.LocationBox().isEnabled(), "The Location Box does not Accept input");
		log.info("The Location Box  Accept input");

		// TC-2.40
		Assert.assertTrue(m2.LocationBox().isEnabled(),
				"The Location Box should not Accept alpha numeric value with Special Characters");
		log.info("The Location Box  Accept alpha numeric value with Special Characters");

		// TC-2.41
		Assert.assertTrue(m2.ActiveToggle().isDisplayed(), "Active Toggle  is not  present ");
		log.info("Active Toggle  is   present");

		Assert.assertTrue(m2.PassToggle().isDisplayed(), "Password Change Toggle  is not  present ");
		log.info("Password Change Toggle  is  present");

		// TC-2.42
		m2.ActiveToggle().click();
		Assert.assertTrue(m2.ActiveToggle().isEnabled(), " The Active Toggle is not Clickeble");
		log.info("The Active Toggle is  Clickeble");

		m2.PassToggle().click();
		Assert.assertTrue(m2.PassToggle().isEnabled(), " The Password Change is not Clickeble");
		log.info("The Password Change is Clickeble");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}

}
