package com.cases.userpreference;

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
import com.actions.Actions;
import com.base.Base;
import com.pageObjects.Login_main;
import com.pageObjects.userpreference.*;

@Listeners({ AllureListener.class })
public class MyWorkspaceFunctionality extends Base {
	public static Logger log = LogManager.getLogger(MyWorkspaceFunctionality.class.getName());
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
	

		UserPreferenceFunctionalityObj mywork = new UserPreferenceFunctionalityObj(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
	     wait.until(ExpectedConditions.elementToBeClickable(mywork.clickTestDemo()));
		actions.click(mywork.clickTestDemo());
		
		// TC-2.1 To verify my work space window is clickable or not
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(mywork.clickTestDemoFolder()));
		Assert.assertTrue(mywork.clickTestDemoFolder().isEnabled(), "My Workspace is not clickable");
		actions.click(mywork.clickMyWorkSpace());
	
		// TC-2.3 To verify all icons are clickable or not

		actions.click(mywork.clickTestDemoFolder());
		Assert.assertTrue(mywork.clickTestDemoFolder().isEnabled(), "Test Demo Folder is not clickable");

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(mywork.clickGoToPriviousFolder()));
		Assert.assertTrue(mywork.clickGoToPriviousFolder().isEnabled(), "go to previous folder is not clickable");
		actions.click(mywork.clickGoToPriviousFolder());
		wait.until(ExpectedConditions.elementToBeClickable(mywork.clickTestDemoFolder()));
		Assert.assertTrue(mywork.clickRefresh().isEnabled(), "Refresh icon is not clickable");
		actions.click(mywork.clickRefresh());

		
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
