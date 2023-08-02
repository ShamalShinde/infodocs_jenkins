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
import com.pageObjects.AccessControlMatrix.Module03;
import com.base.Base;

import com.pageObjects.Login_main;

@Listeners({ AllureListener.class })
public class Module03Test extends Base {
	public static Logger log = LogManager.getLogger(Module03Test.class.getName());
	private WebDriverWait wait;

	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		log.info("Successfully opened the browser");
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
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='selenium']")));
		Module03 m3 = new Module03(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		// TC-3.1
		wait.until(ExpectedConditions.elementToBeClickable(m3.SelectDepart())).click();
		Assert.assertTrue(m3.SelectDepart().isEnabled(), "The Department button is not Clickable");
		log.info("The Department button is Clickable");

		wait.until(ExpectedConditions.visibilityOf(m3.NewFolderIcon()));
		Assert.assertTrue(m3.NewFolderIcon().isDisplayed(), "New Folder icon is not present");
		log.info("New Folder icon is present");

		// TC-3.2
		wait.until(ExpectedConditions.elementToBeClickable(m3.NewFolderIcon())).click();
		Assert.assertTrue(m3.NewFolderIcon().isEnabled(), "The New Folder Icon is not Clickable");
		log.info("The New Folder Icon is Clickable");

		wait.until(ExpectedConditions.visibilityOf(m3.CreateFolder()));
		Assert.assertTrue(m3.CreateFolder().isDisplayed(), "Create Folder Window is not present");
		log.info("Create Folder Window is present");

		// TC-3.4
		Assert.assertTrue(m3.NameTextBox().isDisplayed(), "Name TextField is not present");
		log.info("Name TextField is present");

		Assert.assertTrue(m3.Radio1().isDisplayed(), "Inherit Radio Button is not present");
		log.info("Inherit Radio Button is present");

		Assert.assertTrue(m3.Radio2().isDisplayed(), "Private Radio Button is not present");
		log.info("Private Radio Button is present");

		// TC-3.5
		m3.NameTextBox().sendKeys("New2");
		// TC-3.5
		// TC-3.5
		Assert.assertTrue(m3.NameTextBox().isDisplayed(),
				"Name TextField should not be clickable and should not take input");
		log.info("Name TextField should not be clickable and should not take input");

		// TC-3.6
		m3.Radio1().click();
		Assert.assertTrue(m3.Radio1().isEnabled(), "Inherit Radio Button is not Clickable");
		log.info("Inherit Radio Button is Clickable");

		// TC-3.7
		m3.Radio2().click();
		Assert.assertTrue(m3.Radio2().isEnabled(), "Private Radio Button is not Clickable");
		log.info("Private Radio Button is Clickable");

		m3.Radio1().click();
		// TC-3.8
		wait.until(ExpectedConditions.elementToBeClickable(m3.CreateFolder())).click();
		Assert.assertTrue(m3.CreateFolder().isEnabled(), "Create Folder Button is not Clickable");
		log.info("Create Folder Button is Clickable");

		// TC-3.9
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(m3.SuccessWindow()));
		Assert.assertTrue(m3.SuccessWindow().isDisplayed(), "Success Message Window is not Present");
		log.info("Success Message Window is Present");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}
}
