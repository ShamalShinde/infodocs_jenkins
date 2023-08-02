package com.cases.AccessControlTestCases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.listeners.AllureListener;
import com.pageObjects.AccessControlMatrix.Module01;
import com.base.Base;
import com.pageObjects.Login_main;

@Listeners({ AllureListener.class })
public class Module01Test extends Base {
	public static Logger log = LogManager.getLogger(Module01Test.class.getName());

	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
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
		Thread.sleep(4000);

		Module01 t = new Module01(driver);
		// TC-1.1
		Assert.assertTrue(t.Conffii().isDisplayed(), "The Configuration setting icon in not Present ");
		log.info("navigated on usersettings next page");
		// TC-1.2

		Assert.assertTrue(t.Conffii().isEnabled(), "The Configuration setting icon is not clickeble ");
		log.info("navigated on usersettings next page");
		t.Conffii().click();
		Thread.sleep(2000);

		// TC-1.3,4
		Assert.assertTrue(t.ManageUser().isDisplayed(),
				"Manage User option is not present in configuration settings drop down list");
		log.info("navigated on usersettings next page");

		// TC-1.5
		t.ManageUser().click();
		Thread.sleep(3000);

		// TC-1.6
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/User/Index")) {
			log.info("navigated on usersettings next page");
		} else {
			log.info("Failed to navigate on user settings  page");
		}

//			    
		// TC-1.7
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

		// TC-1.8,9
		t.SelectDrop().click();
		Assert.assertTrue(t.SelectDrop().isEnabled(), "search by-drop down box option is not clickeble ");
		log.info("Select Dropdown is clickeble");
		Thread.sleep(2000);
		Assert.assertTrue(t.SelectUserNamee().isDisplayed(), "Select UserName options are present ");
		log.info("SelectUserName Dropdown is Present");
		t.SelectUserNamee().click();

		t.SelectTextBox().sendKeys("Sahu");

		t.SearchIcon().click();
		Thread.sleep(2000);
		Assert.assertTrue(t.ActionButton().isDisplayed(), "The User is not Present ");
		log.info("The User is  Present ");
		Assert.assertTrue(t.ActionButton().isDisplayed(), "The Action Button  is not Present ");
		log.info("The Action Button  is Present ");
		Thread.sleep(2000);
		t.ActionButton().click();
		Assert.assertTrue(t.ActionButton().isEnabled(), "The Action Button  is not Clickeble");
		log.info("The Action Button  is  Clickeble");
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/User/Edit?id=11371")) {
			log.info(" Action Button navigated on  next page");
		} else {
			log.info("Failed to navigate Action Button on next  page");
		}
		Thread.sleep(2000);
		// TC-1.15
		t.UserMap().click();
		Assert.assertTrue(t.UserMap().isDisplayed(), "The User Mappinng Window is not Present");
		log.info("The User Mappinng Window is  Present");

//			    Assert.assertTrue(t.UserMap().isEnabled(), "The User is not Clickeble");

		// TC-1.16
		Assert.assertTrue(t.UserMap().isEnabled(), "The User Mappinng Window is not clickble");
		log.info("The User Mappinng Window is  clickble");
		// TC-1.17
		Assert.assertTrue(t.UserRoll().isDisplayed(), "The User Mappinng Window is not Opning");
		log.info("The User Mappinng Window is  Opning");
		// TC-1.18
		Assert.assertTrue(t.UserRoll().isDisplayed(), "The User Role Dropdown is not Present");
		log.info("The User Role Dropdown is  Present");
		Assert.assertTrue(t.DepartmentDrop().isDisplayed(), "The Department Dropdown is not Present");
		log.info("The Department Dropdown is Present");
		// TC-1.19
		t.DepartmentDrop().click();
		Assert.assertTrue(t.DepartmentDrop().isEnabled(), "The Department Dropdown is not Clickeble");
		log.info("The Department Dropdown is  Clickeble");
		t.getSelectedOption();
		Thread.sleep(1000);
		t.UserRoll().click();
		Assert.assertTrue(t.UserRoll().isEnabled(), "The User Role Dropdown is not Clickeble");
		log.info("The User Role Dropdown is  Clickeble");
		t.clickOption_UserRole();

		Assert.assertTrue(t.AddButton().isDisplayed(), "The Add Button is not Present");
		log.info("The Add Button is  Present");

		t.AddButton().click();
		Assert.assertTrue(t.AddButton().isEnabled(), "The Add Button is not Clickeble");
		log.info("The Add Button is Clickeble");

		Assert.assertTrue(t.SubmitButton().isDisplayed(), "The Submit Button is not Present");
		log.info("The Submit Button is Present");
		Assert.assertTrue(t.BackButtton().isDisplayed(), "The Back Button is not Present");
		log.info("The Back Button is  Present");

//                t.DeleteButtton().click();
//                Assert.assertTrue(t.DeleteButtton().isEnabled(), "The Submit Button is not Clickeble");

		t.SubmitButton().click();
		Assert.assertTrue(t.SubmitButton().isEnabled(), "The Submit Button is not Clickeble");
		log.info("The Submit Button is  Clickeble");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}

}
