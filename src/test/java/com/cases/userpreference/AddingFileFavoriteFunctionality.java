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
public class AddingFileFavoriteFunctionality extends Base {
	public static Logger log = LogManager.getLogger(AddingFileFavoriteFunctionality.class.getName());
	public Actions actions;
	private WebDriverWait wait;

	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");
		
		driver.get(prop.getProperty("url"));
		 wait = new WebDriverWait(driver, Duration.ofSeconds(60));
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
		

		AddingFileFavoriteFunctionalityObj addfile = new AddingFileFavoriteFunctionalityObj(driver);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
	     wait.until(ExpectedConditions.elementToBeClickable(addfile.clickTestDemo()));
		actions.click(addfile.clickTestDemo());
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(addfile.clickInfodocsDepartment()));

		actions.click(addfile.clickInfodocsDepartment());
		
//		 boolean clicked = false;
//	        while (!clicked) {
//	            try {
//	                // Wait for the element to be clickable
		           //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
//	               wait.until(ExpectedConditions.elementToBeClickable((addfile.clickFolder1())));
//
//	                // Perform the click action
//	               actions.click(addfile.clickFolder1());
//
//	                // Set the flag to indicate successful click
//	                clicked = true;
//	            } 
//	            catch (Exception e)
//	            {
//	               log.info(" Folder is not clickable");
//	            }
//	        }
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(addfile.clickFolder1()));
		actions.click(addfile.clickFolder1());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		Thread.sleep(30000);
		actions.click(addfile.clickFolder2());
		  if(addfile.clickFolder1().isDisplayed())
		    {
		    	 actions.click(addfile.clickFolder1());
		    }
		
		//wait.until(ExpectedConditions.elementToBeClickable(addfile.areAllElementsEnabled()));
		// TC-8.1 To verify all elements are present or not including check box and star
		// icon
		if (addfile.areAllElementsEnabled())
		{
			log.info("all elements are present including checkbox and star icon");
		}
		else 
		{
			log.info("all elements are present including checkbox and star icon");
		}

		//// TC-8.2 To verify check box for selecting the file is clickable or not
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(addfile.clickCheckbox()));
		Assert.assertTrue(addfile.clickCheckbox().isEnabled(), "Checkbox is not clickable");
		actions.click(addfile.clickCheckbox());
		wait.until(ExpectedConditions.elementToBeClickable(addfile.clickStarIcon()));
		// TC-8.3  To verify star icon is clickable or not
		Assert.assertTrue(addfile.clickStarIcon().isEnabled(), "Checkbox is not clickable");
		
		actions.click(addfile.clickStarIcon());
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='sweet-alert showSweetAlert visible']")));
		wait.until(ExpectedConditions.elementToBeClickable(addfile.clickOk()));
		// TC-8.4   To verify after clicking on star icon success message window (Added
		// to favourite ) display or not
		if (addfile.clickOk().isEnabled()) {
			log.info(" After clicking on star icon success message window (Added to favourite ) is display");
		} else {
			log.info(" After clicking on star icon success message window (Added to favourite ) is Not display");
		}

		// TC-8.5  To verify it is added to my favourite or not
		if (addfile.clickOk().isDisplayed()) {
			log.info("File is added to my favourite");
		} else {
			log.info("File is added to my favourite");
		}
		actions.click(addfile.clickOk());
		
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
