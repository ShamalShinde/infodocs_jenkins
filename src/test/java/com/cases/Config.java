package com.cases;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.listeners.AllureListener;
import com.pageObjects.*;
import com.base.Base;


@Listeners({ AllureListener.class })
public class Config extends Base {
	public static Logger log = LogManager.getLogger(Config.class.getName());

	@BeforeMethod
	public void intialize() throws IOException 
	{
		driver = initializeDriver();
		log.info("Driver is intialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");

	}

	@Test(dataProvider = "getData")
	public void configurationNavigation(String Username, String Password) throws IOException, InterruptedException
	{

		Login_main login = new Login_main(driver);
		Config_Page con = new Config_Page(driver);
		login.getUsername().sendKeys(Username);
		login.getPassword().sendKeys(Password);
		login.clickLogin().click();
		login.clickPopup().click();
		login.clickLogin2().click();
		login.clickPopup2().click();
		Thread.sleep(5000);
		
		con.ConfigTab().click();
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/User/Index")) {
			log.info("navigated on ManageUsers next page");
		} else {
			log.info("Failed to navigate on ManageUsers  page");
		}
		Thread.sleep(3000);
		con.manageUser().click();
		con.serachUser().click();
		Thread.sleep(3000);
		con.selectUserName().click();
		String Source_Input = JOptionPane.showInputDialog("Please enter your input for Source: ");
		con.lastNameText().sendKeys(Source_Input);
		con.lastNameSearch().click();
		con.actionIcon().click(); 
		Thread.sleep(3000);
		con.userMapping().click();
		con.selectDept().click();
		con.getSelectedOption();
		con.click_Role().click();
		con.getSelectedOption();
		con.select_addingRole();
		con.clickSave().click();
		con.clickOK().click();
		
//		con.clickLogout().click();
//		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/Account/Login?org=Demo")) {
//			System.out.println("log out suceess");
//		} else {
//			System.out.println("Failed to navigate on home user page");
//		}
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}

}
