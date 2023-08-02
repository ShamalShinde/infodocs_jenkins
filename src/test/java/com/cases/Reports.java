package com.cases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.listeners.AllureListener;
import com.pageObjects.*;
import com.base.Base;

@Listeners({ AllureListener.class })
public class Reports extends Base {
	public static Logger log = LogManager.getLogger(Reports.class.getName());

	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");

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
		Report_Page report = new Report_Page(driver);
		report.clickReport().click();
		Thread.sleep(5000);
		report.clickAudit().click();
		Thread.sleep(5000);
		report.clickDownload().click();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}
}
