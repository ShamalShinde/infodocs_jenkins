package com.cases.DMSFeatureDeleteDocumentTestCase;

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
import com.pageObjects.DMSFeatureDeleteDocument.DmsDeleteDoc;
import com.pageObjects.DMSFeatureDocumentview.DmsViewDoc;
import com.pageObjects.DMSFeatureDownloadingDocument.DmsDownlaodDoc;
import com.base.Base;
import com.pageObjects.Login_main;

@Listeners({ AllureListener.class })
public class DmsDeleteDocTest extends Base {
	public static Logger log = LogManager.getLogger(DmsDownlaodDoc.class.getName());
	private WebDriverWait wait;
	
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Succesfully opened the browser");
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
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
		DmsViewDoc d = new DmsViewDoc(driver);
		DmsDeleteDoc del = new DmsDeleteDoc(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(d.SelectInfoDocs()));
		d.SelectInfoDocs().click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		// TC1.1
		d.ClickOnFolder1().click();
		Thread.sleep(5000);
		Assert.assertTrue(del.DeleteIcon().isDisplayed(), "Delete Icon is   not Displayed");
		log.info("Delete Icon is Displayed");
		// TC1.2
		wait.until(ExpectedConditions.elementToBeClickable(del.CheckBoxDel()));
		del.CheckBoxDel().click();
		del.DeleteIcon().click();
		Assert.assertTrue(del.CanclePop().isDisplayed(), "Delete Icon  is  not clickeble");
		log.info("Delete Icon is Clickeble");
		// TC1.3
		Assert.assertTrue(del.CanclePop().isDisplayed(), "Alert Window  Popup is  not Displayed");
		log.info("Alert Window Popup is Displayed");
		//Thread.sleep(3000);
		// TC1.4
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sweet-alert showSweetAlert visible']")));
		wait.until(ExpectedConditions.elementToBeClickable(del.CanclePop()));
		Assert.assertTrue(del.CanclePop().isDisplayed(), "Cancle Button  is  not Present");
		log.info("Cancle Button is Present");
		Assert.assertTrue(del.DeletePop().isDisplayed(), "Delete Button is  not present");
		log.info("Delete Button is Present");
		// TC1.5
		wait.until(ExpectedConditions.elementToBeClickable(del.CanclePop()));
		del.CanclePop().click();
		Assert.assertTrue(del.CancleOKBtn().isDisplayed(),"after clicking on cancel button canceled confirmation alert OK window not Displayed");
		log.info("after clicking on cancel button canceled confirmation alert OK window  Displayed");
		// TC1.6
		del.CancleOKBtn().click();
		Assert.assertTrue(del.DeleteIcon().isDisplayed(), "Ok Button  is not Clickble");
		log.info("ok Button is Clickeble");
		// TC1.7
		del.DeleteIcon().click();
		del.DeletePop().click();
		Assert.assertTrue(del.DeleteOKBtn().isDisplayed(),
				"after clicking on Delete button success window not Displayed");
		log.info("after clicking on Delete button success window Displayed");
		// TC1.8
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		del.DeleteOKBtn().click();
		Assert.assertTrue(del.DeleteIcon().isDisplayed(), "Ok Button  is not Clickble");
		log.info("ok Button is Clickeble");
		// TC1.9
		wait.until(ExpectedConditions.elementToBeClickable(del.FolderBackClick()));
		del.FolderBackClick().click();
		Thread.sleep(7000);
		// TC1.10
		del.rightClickElement();
		Assert.assertTrue(del.DeleteFolderr().isDisplayed(), "DropDown window is not open after right click on folder");
		log.info("DropDown window is  open after right click on folder");

		// TC-1.11
		Assert.assertTrue(del.DeleteFolderr().isDisplayed(),
				"DropDown list  is not Present after right click on folder");
		log.info("DropDown list  is  Present after right click on folder");
		// TC-1.12
		Assert.assertTrue(del.DeleteFolderr().isDisplayed(), "Delete Folder button is not Present in dropdown");
		log.info("Delete Folder button is  Present in dropdown");
		// TC-1.13
		del.DeleteFolderr().click();
		Thread.sleep(2000);
		Assert.assertTrue(del.CancleDeleteFolderr().isDisplayed(), "Delete Folder button is not Clickeble");
		log.info("Delete Folder button is Clickeble");
		// TC-1.14
		Assert.assertTrue(del.CancleDeleteFolderr().isDisplayed(),"after clicking on delete button  alert window not Displayed");
		log.info("after clicking on delete button  alert window  Displayed");
		// TC-1.15
		Assert.assertTrue(del.CancleDeleteFolderr().isDisplayed(),"after clicking on delete Folderbutton  Cancle Button not Displayed");
		log.info("after clicking on delete Folderbutton  Cancle Button  Displayed");

		Assert.assertTrue(del.DeleteDeleteFolderr().isDisplayed(),"after clicking on delete Folderbutton Delete Button  not Displayed");
		log.info("after clicking on delete Folderbutton Delete Button  Displayed");
		// TC-1.16
		del.CancleDeleteFolderr().click();
		Assert.assertTrue(del.OKCancleDeleteFolderr().isDisplayed(), "Cancle Delete Folder button is not Clickble");
		log.info("Cancle Delete Folder button is  Clickble");

		del.OKCancleDeleteFolderr().click();
		// TC-1.16
		Thread.sleep(2000);
		del.StaffrightClickElement();
		del.DeleteFolderr().click();
		wait.until(ExpectedConditions.elementToBeClickable(del.DeleteDeleteFolderr()));
		del.DeleteDeleteFolderr().click();
		// TC-1.17
		wait.until(ExpectedConditions.elementToBeClickable(del.OKDeleteDeleteFolderr()));
		Assert.assertTrue(del.OKDeleteDeleteFolderr().isDisplayed(),"after clicking delete button success window not opens ");
		log.info("after clicking delete button success window  opens");

		// Assert.assertTrue(del.OKDeleteDeleteFolderr().isDisplayed(), "after clicking
		// delete button success window not Displayed");
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
