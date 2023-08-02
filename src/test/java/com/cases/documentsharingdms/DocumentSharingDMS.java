package com.cases.documentsharingdms;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actions.Actions;
import com.base.Base;
import com.listeners.AllureListener;
import com.pageObjects.Login_main;
import com.pageObjects.documentsharingdms.DocumentSharingDMSObj;

@Listeners({ AllureListener.class })
public class DocumentSharingDMS extends Base {
	public static Logger log = LogManager.getLogger(DocumentSharingDMS.class.getName());
	public Actions actions;
	private WebDriverWait wait;
	
	
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");
		
		driver.get(prop.getProperty("url"));
		 wait = new WebDriverWait(driver, Duration.ofSeconds(80));
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
	
		DocumentSharingDMSObj share = new DocumentSharingDMSObj(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(share.clickTestDemo()));
		actions.click(share.clickTestDemo());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		 wait.until(ExpectedConditions.elementToBeClickable(share.clickInfodocsDepartment()));
		actions.click(share.clickInfodocsDepartment());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		 wait.until(ExpectedConditions.elementToBeClickable(share.clickFolder1()));
		actions.click(share.clickFolder1());
		Thread.sleep(7000);
		actions.click(share.clickFolder2());
		//TC1.1 - To verify if we right click on file then it displays window or not
		Thread.sleep(7000);
		share.rightClickOnButton();
		wait.until(ExpectedConditions.elementToBeClickable(share.clickFileWindow()));

		if(share.clickFileWindow().isDisplayed())
		{
			log.info("After  right click on file then it displays window");

		}
		else
		{
			log.info("After right click on file then it not displays window");

		}
		
		//TC1.2 To verify window contains list or not
		if(share.clickWindowList().isDisplayed())
		{
			log.info("window contains list ");

		}
		else
		{
			log.info("window not contains list ");

		}
		
		
		//TC1.3 To verify on window share document with option present or not
		if(share.clickShareDocument().isDisplayed())
		{
			log.info("window share document with  option present");

		}
		else
		{
			log.info("windowshare document with  option is not  present ");

		}
		
		//TC1.4  To verify on window share document with option  clickable or not
		
		Assert.assertTrue(share.clickShareDocument().isEnabled(), "check out option is not clickable");
		
		//TC1.5 To verify after clicking on share document with option ,share with window opening or not
		
		actions.click(share.clickShareDocument());
		 wait.until(ExpectedConditions.elementToBeClickable(share.clickShareDocumentWindow()));

		if(share.clickShareDocumentWindow().isDisplayed())
		{
			log.info(" After clicking on share document with option ,share with window opening ");

		}
		else
		{
			log.info(" After clicking on share document with option ,share with window is not  opening ");

		}
		
		//TC1.6 To verify on window user drop down box present or not
		
		if(share.clickUserDropDown().isDisplayed())
		{
			log.info("window user drop down box present");

		}
		else
		{
			log.info("window user drop down box not present ");

		}
	
		//TC1.7 To verify on window user drop down box clickable or not
		
		Assert.assertTrue(share.clickUserDropDown().isEnabled(), "User DropDown is not clickable");
		
		//TC1.8 To verify after clicking on user drop down box check all and unchecked all check boxes present or not
		actions.click(share.clickUserDropDown());
		if (share.areAllElementsDisplayed()) {
			log.info("User drop down box check all and unchecked all check boxes present");
		} else {
			log.info("User drop down box check all and unchecked all check boxes are not present");
		}

		//TC1.9 To verify after clicking on user drop down box check all and unchecked all check boxes clickable or not
		
		if (share.areAllElementsEnabled()) {
			log.info("User drop down box check all and unchecked all check boxes clickable");
		} else {
			log.info("User drop down box check all and unchecked all check boxes are not clickable");
		}
		
		//TC1.16 To verify on share window user list with check box present or not
				if(share.clickUserCheckbox().isDisplayed())
				{
					log.info(" share window user list with check box present ");

				}
				else
				{
					log.info(" share window user list with check box not present");

				}
				
				
				//TC1.17 To verify on share window user list with check box clickable or not
				Assert.assertTrue(share.clickUserCheckbox().isEnabled(), "Check box not Clickable");
		
		//TC1.10 To verify on window search text box present or not
		
		if(share.clickSearchBox().isDisplayed())
		{
			log.info(" window search text box present");

		}
		else
		{
			log.info("window search text box not present");

		}
		
		//TC1.11 To verify search text box accepts input or not
		actions.enterText(share.clickSearchBox(), "Arun Kumar");
		String enteredValue = share.clickSearchBox().getText();

        if (enteredValue.equals("Test input")) {
        	log.info("Search text box accepts input");
        } else {
        	log.info("Search text box accepts input");
        }
		
		
		//TC1.12 To verify if we mention user name in search text box,then it displays the filtered result in to table or not
       
        // Locate the table or element that contains the filtered results (replace with appropriate selector)
       

        // Verify if the table or element is displayed or not
        if (share.clickTable().isDisplayed()) {
            System.out.println("Filtered results displayed in table");
        } else {
            System.out.println("Filtered results not displayed in table");
        }
		
		
		
		
		
		
		
		//TC1.13  To verify Save button present or not
		
		Assert.assertTrue(share.clickSave().isDisplayed(), "Save button is not Present");
		//TC1.14 To verify Save button clickable or not
		Assert.assertTrue(share.clickSave().isEnabled(), "Save button is not Clickable");
		//TC1.15 To verify after clicking on save button success message window displays or not
		actions.click(share.clickSave());
		Thread.sleep(3000);
		if(share.clickSuccessWindow().isDisplayed())
		{
			log.info(" After clicking on save button success message window displays ");

		}
		else
		{
			log.info(" After clicking on save button success message window is not displays ");

		}
		
		
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
