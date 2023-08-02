package com.cases.DMSFeatureDocumentViewTestCase;

import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.listeners.AllureListener;
import com.pageObjects.DMSFeatureDocumentview.DmsViewDoc;
import com.base.Base;
import com.pageObjects.Login_main;

@Listeners({ AllureListener.class })
public class DmsViewDocTest extends Base {
	public static Logger log = LogManager.getLogger(DmsViewDoc.class.getName());
	private WebDriverWait wait;
	private DmsViewDoc dmsViewDoc;

	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();

		log.info("Succesfully opened the browser");

		driver.get(prop.getProperty("url"));

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		dmsViewDoc = new DmsViewDoc(driver);
		// dmsViewDoc = PageFactory.initElements(driver, DmsViewDoc.class);
		PageFactory.initElements(driver, dmsViewDoc);
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
//				Thread.sleep(4000);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(dmsViewDoc.SelectInfoDocs()));
		dmsViewDoc.SelectInfoDocs().click();
//					Thread.sleep(5000);
		// dmsViewDoc.SelectInfoDocs().click();
//				Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(dmsViewDoc.ClickOnFolder1()));
		dmsViewDoc.ClickOnFolder1().click();
		// dmsViewDoc.ClickOnFolder1().click();
//				Thread.sleep(5000);
		// TC1.1
		Thread.sleep(3000);
		dmsViewDoc.doubleClickElement();

		// TC1.2
		dmsViewDoc.rightClickElement();
//				Thread.sleep(3000);
		Assert.assertTrue(dmsViewDoc.ViewDocument().isDisplayed(),"if we right click on file then window  not Displayed");
		log.info("if we right click on file then window   Displayed");
		// TC1.3
		Assert.assertTrue(dmsViewDoc.ViewDocument().isDisplayed(), "widow should not contains list");
		log.info("widow should  contains list");
		// TC1.4
		Assert.assertTrue(dmsViewDoc.ViewDocument().isDisplayed(), "on window view document option is not present");
		log.info("on window view document option is present");
		// TC1.5
		dmsViewDoc.ViewDocument().click();
//				Thread.sleep(3000);
		// Assert.assertTrue(d.VerifyNewWindow().isEnabled(), "view document option not
		// clickable ");
		if (driver.getCurrentUrl()
				.equals("https://ecm.writercorporation.com/InfoDocsV1/Document/ViewDoc?docId=330952&VerId=249709")) {
			log.info(" Window is open ");
		} else {
			log.info("new window not opening");
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
