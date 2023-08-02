package com.cases.DMSFeatureDownloadingDocumentTestCase;

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
import com.pageObjects.DMSFeatureDownloadingDocument.Demo22;
import com.base.Base;

import com.pageObjects.Login_main;

@Listeners({ AllureListener.class })
public class Demo22Test extends Base {
	public static Logger log = LogManager.getLogger(Demo22.class.getName());
	private WebDriverWait wait;

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

		Demo22 t1 = new Demo22(driver);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(t1.DepartmentPatient()));
		t1.DepartmentPatient().click();

		wait.until(ExpectedConditions.elementToBeClickable(t1.RegiFolder()));
		t1.RegiFolder().click();

		wait.until(ExpectedConditions.elementToBeClickable(t1.CheckBox()));
		t1.CheckBox().click();

		wait.until(ExpectedConditions.elementToBeClickable(t1.ZipDownlaod()));
		t1.ZipDownlaod().click();

		t1.AcceptPopup();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}

}
