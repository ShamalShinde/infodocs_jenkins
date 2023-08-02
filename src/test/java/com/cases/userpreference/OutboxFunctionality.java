package com.cases.userpreference;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
public class OutboxFunctionality extends Base {
	public static Logger log = LogManager.getLogger(OutboxFunctionality.class.getName());
	public Actions actions;
	private WebDriverWait wait;
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		 wait = new WebDriverWait(driver, Duration.ofSeconds(90));
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
		Thread.sleep(3000);

		OutboxFunctionalityObj outbox = new OutboxFunctionalityObj(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
	    wait.until(ExpectedConditions.elementToBeClickable(outbox.clickTestDemo()));

		actions.click(outbox.clickTestDemo());
		wait.until(ExpectedConditions.elementToBeClickable(outbox.clickOutbox()));

		// TC-12.1 To verify outbox window present or not

		boolean isOutboxDisplayed = outbox.clickOutbox().isDisplayed();
		if (isOutboxDisplayed) {
			log.info("Outbox window is present.");
		} else {
			log.info("Outbox files window is not present.");

		}

		// TC-12.2 To verify outbox window is clickable or not
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(outbox.clickOutbox()));
		Assert.assertTrue(outbox.clickOutbox().isEnabled(), "Outbox is not clickable");
		actions.click(outbox.clickOutbox());

		// TC-12.3 To verify after clicking on outbox , table is opening or not
		if (outbox.clickOutboxTable().isDisplayed()) {
			log.info("After clicking outbox table is opened");
		}

		// TC-12.4 To verify in to table under file name and file path ,details are
		// given/uploaded or not
		if (outbox.clickFileName().getText().isEmpty() && outbox.clickFilePath().getText().isEmpty()) {
			log.info("File name and file path are missing for a row");
		} else {
			log.info("File name and file path details is uploaded ");

		}

		// TC-12.5 To verify after clicking on particular PDF file it is opening or not
		//wait.until(ExpectedConditions.elementToBeClickable(outbox.clickPdfFile()));
		Assert.assertTrue(outbox.clickPdfFile().isEnabled(), "PDf File is is not clickable");
		actions.click(outbox.clickPdfFile());


		// TC-12.6  To verify after clicking on particular word file it is opening or not
//		wait.until(ExpectedConditions.elementToBeClickable(outbox.clickWordFile()));
//		Assert.assertTrue(outbox.clickWordFile().isEnabled(), "Word File is not clickable");
//		actions.click(outbox.clickWordFile());
	

		// TC-12.7  To verify after clicking on particular Excel file it is opening or
		// not
//		wait.until(ExpectedConditions.elementToBeClickable(outbox.clickExcelFile()));
//		Assert.assertTrue(outbox.clickExcelFile().isEnabled(), "Excel File is not clickable");
//		actions.click(outbox.clickExcelFile());
//		
//
//		// TC-12.8  To verify after clicking on particular Image file it is opening or
//		// not
//		wait.until(ExpectedConditions.elementToBeClickable(outbox.clickImageFile()));
//		Assert.assertTrue(outbox.clickImageFile().isEnabled(), "Image File is not clickable");
//		actions.click(outbox.clickImageFile());
		

		// TC12.9 To verify in to table row view status button is present or not
		if (outbox.clickFileName().getText().contains("View Status")) {
			log.info("View Status button is present");
		}

		// TC-12.10 To verify view status button is clickable or not
		Assert.assertTrue(outbox.clickImageFile().isEnabled(), "View Status Button is not clickable");
		actions.click(outbox.clickViewStatus());
		

		// TC-12.11 To verify after clicking on view status button ,view action status
		// window opening or not
		wait.until(ExpectedConditions.elementToBeClickable(outbox.checkViewStatusPopup()));
		wait.until(ExpectedConditions.elementToBeClickable(outbox.clickStatusWindow()));
		if (outbox.clickStatusWindow().isDisplayed()) {
			log.info("clicking on view status button ,view action status window is opening");
		} else {
			log.info("clicking on view status button ,view action status window is  Not opening");
		}

		// TC-12.12 To verify on view action status window action table present or not
		if (outbox.clickStatusWindowAction().isDisplayed()) {
			log.info("status window action table is  present");
		} else {
			log.info("tatus window action table Not is  present");
		}
		wait.until(ExpectedConditions.elementToBeClickable(outbox.clickCloseButton()));

		// TC-12.13 To verify on view action status window close button present or not
		if (outbox.clickCloseButton().isDisplayed()) {
			log.info(" view action status window close button is present ");
		} else {
			log.info(" view action status window close button is not  present ");
		}

		// TC-12.14 To verify on view action status window close button clickable or not

		Assert.assertTrue(outbox.clickCloseButton().isEnabled(), "View Status Button is not clickable");
		actions.click(outbox.clickCloseButton());
		

		// TC-12.15 To verify after clicking on close button ,it is navigating to outbo
		// window or not
		if (driver.getCurrentUrl().equals(
				"https://ecm.writercorporation.com/InfoDocsV1/Folder/ViewFolder?PrjFldType=TestDemo&FolderId=224873&IsDept=N")) {
			log.info("After clicking on close button ,It is navigating to outbox window ");
		} else {
			log.info("After clicking on close button ,It is failed to navigating  outbox window");
		}

		// TC-12.16 To verify on outbox window refresh button icon present or not
		if (outbox.clickRefreshButton().isDisplayed()) {
			log.info(" outbox window refresh button icon present");
		} else {
			log.info("outbox window refresh button icon  is not present ");
		}

		// TC-12.17 To verify on outbox window refresh button icon clickable or not
		Assert.assertTrue(outbox.clickRefreshButton().isEnabled(), "View Status Button is not clickable");
		actions.click(outbox.clickRefreshButton());
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
