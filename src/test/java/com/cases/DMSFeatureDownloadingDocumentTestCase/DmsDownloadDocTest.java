package com.cases.DMSFeatureDownloadingDocumentTestCase;

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
import com.pageObjects.DMSFeatureDocumentview.DmsViewDoc;
import com.pageObjects.DMSFeatureDownloadingDocument.DmsDownlaodDoc;
import com.base.Base;
import com.pageObjects.Login_main;

@Listeners({ AllureListener.class })
public class DmsDownloadDocTest extends Base {
	public static Logger log = LogManager.getLogger(DmsDownlaodDoc.class.getName());

	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Succesfully opened the browser");

		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
		// Thread.sleep(3000);
		DmsViewDoc d = new DmsViewDoc(driver);
		DmsDownlaodDoc d1 = new DmsDownlaodDoc(driver);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(d.SelectInfoDocs()));
		d.SelectInfoDocs().click();
		// Thread.sleep(4000);
		// TC1.1
		wait.until(ExpectedConditions.elementToBeClickable(d.ClickOnFolder1()));
		d.ClickOnFolder1().click();
			Thread.sleep(3000);
		
	//	Assert.assertTrue(d1.DownloadZipBtn().isDisplayed(), "downloading in ZIP icon button   not Displayed");
		log.info("downloading in ZIP icon button Displayed");

		// TC1.2
		wait.until(ExpectedConditions.elementToBeClickable(d1.CheckBoxFiles()));
		Assert.assertTrue(d1.CheckBoxFiles().isDisplayed(), "CheckBox  is  not Displayed");
		log.info("CheckBox  is  Displayed");

		// TC1.3
		wait.until(ExpectedConditions.elementToBeClickable(d1.CheckBoxFiles()));
		d1.CheckBoxFiles().click();
		Assert.assertTrue(d1.CheckBoxFiles().isEnabled(), "Checkbox is not clickble");
		log.info("Checkbox is clickble");

		Thread.sleep(3000);
		d1.AcceptPopup();
		// TC1.6
		d.rightClickElement();
		// Thread.sleep(3000);
		Assert.assertTrue(d.ViewDocument().isDisplayed(), "if we right click on file then window  not Displayed");
		log.info("if we right click on file then window   Displayed");

		// TC1.7
		Assert.assertTrue(d.ViewDocument().isDisplayed(), "widow should not contains list");
		log.info("widow should  contains list");

		// TC1.8
		Assert.assertTrue(d1.DownloadFileOptn().isDisplayed(), "on window Download document option not  present");
		log.info("on window Download document option  present");

		// TC1.9
		d1.DownloadFileOptn().click();
		Assert.assertTrue(d1.DownloadZipBtn().isDisplayed(), "download document option is not clickeble");
		log.info("download document option is  clickeble");

		// TC1.10
		Assert.assertTrue(d1.DownloadZipBtn().isDisplayed(), "downloading in not start");
		log.info("downloading in start");

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
