package com.cases.versioncontrol;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actions.Actions;
import com.base.Base;
import com.listeners.AllureListener;
import com.pageObjects.Login_main;
import com.pageObjects.versioncontrol.VersionControlFunctionalityObj;

@Listeners({ AllureListener.class })
public class VersionControlFunctionality extends Base {
	public static Logger log = LogManager.getLogger(VersionControlFunctionality.class.getName());
	public Actions actions;

	
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
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
		Thread.sleep(3000);

		VersionControlFunctionalityObj version = new VersionControlFunctionalityObj(driver);
		
		 version.clickTestDemo();
		
		// Thread.sleep(5000);
		 
		version.clickInfodocsDepartment();
		
		version.clickFolder1();
		
		version.clickFolder2();
	
		//TC1.1 - To verify if we right click on file then it displays window or not
//		version.rightClickOnButton();
//		if(version.clickFileWindow().isDisplayed())
//		{
//			log.info("After  right click on file then it displays window");
//
//		}
//		else
//		{
//			log.info("After right click on file then it not displays window");
//
//		}
		
		//TC1.2 To verify window contains list or not
//		if(version.clickWindowList().isDisplayed())
//		{
//			log.info("window contains list ");
//
//		}
//		else
//		{
//			log.info("window not contains list ");
//
//		}
//		
		
//		//TC1.3 To verify on window check out option present or not
//		if(version.clickCheckOut().isDisplayed())
//		{
//			log.info("window check out option present");
//
//		}
//		else
//		{
//			log.info("window check out option is not  present ");
//
//		}
//		
		
		
		//TC1.4 To verify on window check out option clickable or not
	//	Assert.assertTrue(version.clickCheckOut().isEnabled(), "check out option is not clickable");
		
		//TC1.5 To verify after clicking on it,check out window opening or not
		version.clickCheckOut();
		
//		if(version.clickCheckOutWarning().isDisplayed())
//		{
//			log.info("after clicking on it,check out window opening");
//
//		}
//		else
//		{
//			log.info("after clicking on it,check out window is not opening ");
//
//		}
		
		//TC1.6 To verify on check out window cancel and yes button present or not
		
		//Assert.assertTrue(version.clickCancelButton().isDisplayed(), "check out window cancel  button is not clickable");
		//Assert.assertTrue(version.clickYesButton().isDisplayed(), "check out window Yes button is not clickable");
		
		//Thread.sleep(4000);
		
		
		//TC1.7 To verify after clicking on yes button,check out success window opening or not
		 version.ClickrightClickOnButton();
//		if(version.clickSuccesWindow().isDisplayed())
//		{
//			log.info("After clicking on yes button,check out success window opening");
//		}
//		else
//		{
//			log.info("After clicking on yes button,check out success window is not opening");
//		}
		
		
		
		//TC1.8 To verify ,if user check out particular file then after clicking on that file it should be not open again ,because user lock that file
//		
//		Assert.assertFalse(version.clickLockFile().isEnabled(), " after clicking on that file it open");
//		actions.click(version.clickLockFile());
//		
	
		//TC1.9 To verify if user check out(lock)particular file,and user have given access of that folder to another user also that time if another user click on that lock file ,it should not be open,because user already lock the file
		
		
		
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
