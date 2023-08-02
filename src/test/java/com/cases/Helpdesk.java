package com.cases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.listeners.AllureListener;
import com.pageObjects.*;
import com.base.Base;

@Listeners({ AllureListener.class })
public class Helpdesk extends Base {
	public static Logger log = LogManager.getLogger(Helpdesk.class.getName());

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

		Helpdesk_main help = new Helpdesk_main(driver);
		help.clickProfileDropdown().click();
		Assert.assertTrue(help.clickProfileDropdown().isEnabled(), "The profile dropdown element is not enabled ");
		Thread.sleep(3000);
		Assert.assertTrue(help.clickHelpDesk().isEnabled(), "helpdesk element is not clickable.");
		help.clickHelpDesk().click();
		Thread.sleep(3000);

		// To verify after clicking on helpdesk it is navigating to next page or not
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/Support/Index")) {
			log.info("Navigated to HelpDesk Next Page.");
		} else {
			log.info("Failed to navigate on helpdesk  page.");

		}
		// validate subject field
		Assert.assertTrue(help.getSubject().isEnabled(), "subject textbox is not clickable.");
		help.getSubject().sendKeys("Logo");

		Assert.assertTrue(help.getAttachFile().isEnabled(), "attach file textbox is not clickable.");

		// Set the file path
		String filePath = System.getProperty(("user.home") + "/Pictures/rpa.jfif");

		help.getAttachFile().sendKeys(filePath);
		System.out.println("file uploaded : hepldesk");
		Thread.sleep(3000);
		// validate subject field
		help.getBody().clear();
		Assert.assertTrue(help.getBody().isEnabled(), "body textbox is not clickable.");
		help.getBody().sendKeys("writer logo");
		Thread.sleep(2000);
		// click on send button
		Assert.assertTrue(help.clickSend().isEnabled(), "send button  is not clickable.");
		// help.send().click();
		Thread.sleep(3000);
		// click on Exit button
		Assert.assertTrue(help.clickExit().isEnabled(), "Exit button  is not clickable.");
		help.clickExit().click();
		Thread.sleep(3000);
		driver.close();
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
