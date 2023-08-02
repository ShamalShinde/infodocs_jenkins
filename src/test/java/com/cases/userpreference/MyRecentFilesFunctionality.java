package com.cases.userpreference;

import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
public class MyRecentFilesFunctionality extends Base {
	public static Logger log = LogManager.getLogger(MyRecentFilesFunctionality.class.getName());
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
		

		MyRecentFilesFunctionalityObj recentfile = new MyRecentFilesFunctionalityObj(driver);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
	     wait.until(ExpectedConditions.elementToBeClickable(recentfile.clickTestDemo()));

		actions.click(recentfile.clickTestDemo());
		

		// TC-11.1 To verify my recent files window present or not

		boolean isRecentFilesWindowDisplayed = recentfile.clickMyRecentFiles().isDisplayed();
		if (isRecentFilesWindowDisplayed) {
			log.info("Recent files window is present.");
		} else {
			log.info("Recent files window is not present.");

		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(recentfile.clickMyRecentFiles()));
		actions.click(recentfile.clickMyRecentFiles());
		// TC-11.2 To verify top 10 documents are listed in my recent files or not

		/*
		 * if (recentfile.getElementCount()== 10) {
		 * log.info("Top 10 elements are present in the list ."); } else {
		 * log.info("Top 10 elements are not present in the list."); }
		 */

		// TC-11.3 To verify listed files under my recent files are opening or not
//        if (isRecentFilesWindowDisplayed) {
//        	actions.click();
//        	log.info("Recent files window is present.");     
//        } else {
//        	log.info("Recent files window is not present.");
//            
//        }
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
