package com.cases;

import java.io.IOException;
import javax.swing.JOptionPane;

import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.listeners.AllureListener;
import com.pageObjects.*;
import com.base.Base;

@Listeners({ AllureListener.class })
public class manageDepartment extends Base {
	public static Logger log = LogManager.getLogger(Helpdesk.class.getName());
	
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");

	
	}

	@Test(dataProvider = "getData")
	public void manageDepartment_test(String userName, String password) throws IOException, InterruptedException {

		Login_main login = new Login_main(driver);
		Assert.assertTrue(login.getUsername().isEnabled(), "username field is not clickable.");
		Assert.assertTrue(login.getPassword().isEnabled(), "password  field is not clickable.");
		login.getUsername().sendKeys(userName);
		login.getPassword().sendKeys(password);
		Assert.assertTrue(login.clickLogin().isEnabled(), "login button field is not clickable.");
		login.clickLogin().click();
		login.clickPopup().click();
		login.clickLogin2().click();
		login.clickPopup2().click();
		Thread.sleep(3000);

		ManageDepartment_main md = new ManageDepartment_main(driver);

		md.ConfigTab().click();

		Assert.assertTrue(md.clickManageDepartment().isEnabled(),
				"manage department dropdown element is not clickable.");
		md.clickManageDepartment().click();
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/Department/Index")) {
			System.out.println("navigated on manage department page");
		} else {
			System.out.println("Failed to navigate on manage department page");
		}

		// create new department
		Assert.assertTrue(md.clickAddDepartment().isEnabled(), "add department pluse button is not clickable.");
		md.clickAddDepartment().click();
		Thread.sleep(3000);
		String Source_Input = JOptionPane.showInputDialog("Please enter your input for Source: "); // input dialog
		md.getDepartmentName().sendKeys(Source_Input);
		Thread.sleep(5000);
		// active.click();
		Assert.assertTrue(md.clickSaveDepartment().isEnabled(), "save department button is not clickable.");
		md.clickSaveDepartment().click();
		Assert.assertTrue(md.clickOkDepartment().isEnabled(), "ok popup department button is not clickable.");
		md.clickOkDepartment().click();

		driver.navigate().back();

		///// Manage User
		
		md.ConfigTab().click();
		Assert.assertTrue(md.clickUserProfile().isEnabled(), "profile dropdown element is not clickable.");
//		md.clickUserProfile().click();
//		Thread.sleep(3000);

		Assert.assertTrue(md.clickManageUser().isEnabled(), "manage user dropdown element is not clickable.");
		md.clickManageUser().click();
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/User/Index")) {
			System.out.println("navigated on manage user page");
		} else {
			System.out.println("Failed to navigate on manage user page");
		}

		// click on search dropdown
		Assert.assertTrue(md.clickSearchBy().isEnabled(), "search manage user dropdown element is not clickable.");
		md.clickSearchBy().click();
		Thread.sleep(3000);
		// search by
		Assert.assertTrue(md.clickSearchByoption().isEnabled(), "search list username element is not clickable.");
		md.clickSearchByoption().click();
		Thread.sleep(3000);

		// username tesxtbox
		Assert.assertTrue(md.getSearchBy().isEnabled(), "search list textbox is not clickable.");
		md.getSearchBy().sendKeys("testdemo");
		Thread.sleep(3000);

		// search icon button
		Assert.assertTrue(md.clickSearch().isEnabled(), "search list textbox is not clickable.");
		md.clickSearch().click();
		Thread.sleep(3000);

		// click on actions
		Assert.assertTrue(md.clickAction().isEnabled(), "action is not clickable.");
		md.clickAction().click();
		Thread.sleep(3000);

		// user mapping
		Assert.assertTrue(md.clickUserMapping().isEnabled(), "user mapping tab is not clickable.");
		md.clickUserMapping().click();
		Thread.sleep(3000);

		// department user mapping tab
		Assert.assertTrue(md.clickDepartment().isEnabled(),"user mapping department dropdown tab is not clickable.");
		md.clickDepartment().click();
		Thread.sleep(3000);
		
         Select dropdown = new Select(md.clickDepartment());
         dropdown.selectByVisibleText("autotest");
         Thread.sleep(3000);

		// user role dropdown
		Assert.assertTrue(md.clickUserRole().isEnabled(), "user role dropdown tab is not clickable.");
		Select select_UserRole = new Select(md.clickUserRole());
		select_UserRole.selectByVisibleText("8 - System Admin");
		Thread.sleep(3000);

		// pluse sign button
		Assert.assertTrue(md.getAddDepartmentRole().isEnabled(), "add button in usermapping  is not clickable.");
		md.getAddDepartmentRole().click();
		Thread.sleep(3000);

		// save button
		Assert.assertTrue(md.clickSaveUserRole().isEnabled(), "save button in usermapping  is not clickable.");
		md.clickSaveUserRole().click();
		Thread.sleep(3000);

		// ok button popup
		Assert.assertTrue(md.clickOkUserRole().isEnabled(), "ok button in usermapping  is not clickable.");
		md.clickOkUserRole().click();
		Thread.sleep(3000);

		//// Log out

		md.getProfileDropdown().click();
		Assert.assertTrue(md.clickUserProfile().isEnabled(), "profile dropdown element is not clickable.");
		//md.clickUserProfile().click();
		Thread.sleep(3000);

		//Assert.assertTrue(md.clickLogout().isEnabled(), "log button  is not clickable.");
		md.clickLogout().click();
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/Account/Login?org=Demo")) {
			System.out.println("log out suceess");
		} else {
			System.out.println("Failed to navigate on home user page");
		}
		Thread.sleep(3000);

		// Log in

		Assert.assertTrue(login.getUsername().isEnabled(), "username field is not clickable.");
		Assert.assertTrue(login.getPassword().isEnabled(), "password  field is not clickable.");
		login.getUsername().sendKeys(userName);
		login.getPassword().sendKeys( password);
		Assert.assertTrue(login.clickLogin().isEnabled(), "login is not clickable.");
		login.clickLogin().click();
		login.clickPopup().click();
		login.clickLogin2().click();
		login.clickPopup2().click();
		Thread.sleep(10000);

		// Check if the option element is present
		boolean isNewDepartment = md.clickNewDepartment().isDisplayed();

		// Print the result
		if (isNewDepartment) {
			System.out.println("New Department  is present .");
		} else {
			System.out.println("New Department is not present.");
		}

	
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}
}
