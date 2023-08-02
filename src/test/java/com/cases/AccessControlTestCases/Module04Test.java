package com.cases.AccessControlTestCases;

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
import com.pageObjects.AccessControlMatrix.Module01;
import com.pageObjects.AccessControlMatrix.Module02;
import com.pageObjects.AccessControlMatrix.Module03;
import com.pageObjects.AccessControlMatrix.Module04;
import com.base.Base;
import com.pageObjects.Login_main;


@Listeners({ AllureListener.class })
public class Module04Test extends Base {
	public static Logger log = LogManager.getLogger(Module04Test.class.getName());
	private WebDriverWait wait;
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

		Module03 m3 = new Module03(driver);
		Module04 m4 = new Module04(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(m3.SelectDepart()));
		m3.SelectDepart().click();
		Assert.assertTrue(m3.SelectDepart().isEnabled(), " The Department button is not Clickeble");
		log.info("The Department button is  Clickeble");

		Thread.sleep(3000);
		// TC-4.1
		m4.rightClickElement();
		Thread.sleep(3000);
		Assert.assertTrue(m4.PrpoertiesButton().isDisplayed(),
				"DropDown list  is not Present after right click on folder");
		log.info("DropDown list  is  Present after right click on folder");

		// TC-4.2
		Assert.assertTrue(m4.PrpoertiesButton().isDisplayed(), "properties button is not Present in dropdown");
		log.info("properties button is  Present in dropdown");

		// TC-4.3
		m4.PrpoertiesButton().click();
		Thread.sleep(2000);
		Assert.assertTrue(m4.FolderProperties().isDisplayed(), "properties button is not Clickeble");
		log.info("properties button is  Clickeble");


		// TC-4.4
		Assert.assertTrue(m4.FolderProperties().isDisplayed(),
				"properties window  not oprning after Click on Properties button");
		log.info("properties window is oprning after Click on Properties button");

		// TC-4.5
		m4.Template().click();
		Assert.assertTrue(m4.Template().isDisplayed(), "Template button is not Present in dropdown");
		log.info("Template button is Present in dropdown");

		m4.Access().click();
		Assert.assertTrue(m4.Access().isDisplayed(), "Access button is not Present in dropdown");
		log.info("Access button is  Present in dropdown");

		m4.Archive().click();
		Assert.assertTrue(m4.Archive().isDisplayed(), "Archiver button is not Present in dropdown");
		log.info("Archiver button is Present in dropdown");

		m4.Aprroveer().click();
		Assert.assertTrue(m4.Aprroveer().isDisplayed(), "Aprover button is not Present in dropdown");
		log.info("Aprover button is Present in dropdown");


		// TC-4.6

		m4.Access().click();
		Assert.assertTrue(m4.Access().isEnabled(), "Access Tab is not Clickeble");
		log.info("Access Tab is  Clickeble");


		// 4.8
		m4.FirstDrop().click();
		Thread.sleep(2000);
		m4.SelectUser1().click();
		Thread.sleep(2000);
		m4.SecondDrop().click();
		m4.SelectUser2().click();
		Thread.sleep(2000);
		m4.AddAccess().click();
		// TC-4.7
		Assert.assertTrue(m4.AddAccess().isDisplayed(), "Add Access Button should not Present");
		log.info("Add Access Button should  Present");

		// 4.9
		Assert.assertTrue(m4.PermissionButton().isDisplayed(), "Permission Submit Button is not Present");
		log.info("Permission Submit Button is  Present");


		// 4.10
		m4.FirstDrop().click();
		Thread.sleep(2000);
		m4.SelectUser1().click();
		Thread.sleep(2000);
		m4.SecondDrop().click();
		m4.SelectRollBack().click();
		m4.AddAccess().click();
		Assert.assertTrue(m4.ValidationWindow().isDisplayed(), "Validation Window  is not open");
		log.info("Validation Window  is  open");

		Thread.sleep(2000);
		m4.OkButton().click();

		// 4.11
		m4.FirstDrop().click();
		Thread.sleep(2000);
		m4.SelectUserBack().click();
		Thread.sleep(2000);
		m4.SecondDrop().click();
		m4.SelectUser2().click();
		m4.AddAccess().click();
		Assert.assertTrue(m4.ValidationWindow().isDisplayed(), "Validation Window  is not open");
		log.info("Validation Window  is open");

		Thread.sleep(2000);
		m4.OkButton().click();

		// 4.12
		m4.FirstDrop().click();
		Thread.sleep(2000);
		m4.SelectUser1().click();
		Thread.sleep(2000);
		m4.SecondDrop().click();
		m4.SelectUser2().click();
    	Thread.sleep(2000);
		m4.AddAccess().click();
		Assert.assertTrue(m4.ResultAfterAdd().isDisplayed(),
				"after clicking on add button it does not  shows the expected result ");
		log.info("after clicking on add button it   shows the expected result");


		// 4.13
		Assert.assertTrue(m4.ResultAfterAdd().isDisplayed(), "Delete icon is not Present ");
		log.info("Delete icon is  Present");


		// 4.14
		m4.PermissionButton().click();
		Assert.assertTrue(m4.FinalSubmitBtn().isDisplayed(),
				" After clicking on save permission button success message window not present");
		log.info("After clicking on save permission button success message window is present");

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
