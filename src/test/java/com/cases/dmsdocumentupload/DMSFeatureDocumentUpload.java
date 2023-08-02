package com.cases.dmsdocumentupload;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.listeners.AllureListener;
import com.base.Base;
import com.pageObjects.Login_main;
import com.pageObjects.dmsdocumentupload.DMSFeatureDocumentUpload_Page;

@Listeners({ AllureListener.class })
public class DMSFeatureDocumentUpload extends Base {
	public static Logger log = LogManager.getLogger(DMSFeatureDocumentUpload.class.getName());
	private WebDriverWait wait;
	
	// Actions actions = new Actions(driver);
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Succesfully opened the browser");
		
		driver.get(prop.getProperty("url"));
	    wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		if (driver.getCurrentUrl().equals(prop.getProperty("url"))) {
			log.info("Successfully opened the url of InfoDocs Application");
		} else {
			log.info("Failed to opened the url of InfoDocs Application");
		}

	}

	@Test(dataProvider = "getData")
	public void DMSFeatureDocumentUploadNavigation(String Username, String Password)throws IOException, InterruptedException
	{

		Login_main login = new Login_main(driver);
		login.getUsername().sendKeys(Username);
		login.getPassword().sendKeys(Password);
		login.clickLogin().click();
		login.clickPopup().click();
		login.clickLogin2().click();
		login.clickPopup2().click();
		Thread.sleep(3000);

		DMSFeatureDocumentUpload_Page docUpload = new DMSFeatureDocumentUpload_Page(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	     wait.until(ExpectedConditions.elementToBeClickable(docUpload.getlist_Folders()));
		// TC1.1-To verify on left side of user home page ,under the user profile icon folders are present or not
		if (docUpload.getlist_Folders().isDisplayed()) {
			log.info("Folders are present.");
		} else {
			log.info("No folders found.");
		}

		// TC1.2 - To verify folders are clickable or not

		if (docUpload.getlist_Folders().isEnabled()) {
			log.info("Folders are Clickable.");
		} else {
			log.info("No folders clickable");
		}

		// TC1.3-To verify if we click on particular folder ,it is navigating to
		// particular folder page or not
		 wait.until(ExpectedConditions.elementToBeClickable(docUpload.getElemntFolderName()));
		docUpload.getElemntFolderName().click();

		String folder_Link = "https://ecm.writercorporation.com/InfoDocsV1/Folder/ViewFolder?PrjFldType=infodocs&FolderId.=245027&IsDept=Y";
		if (driver.getCurrentUrl().equals(folder_Link)) {
			log.info("if click on particular folder ,it is navigating to particular folder page");
		} else {
			log.info("if click on particular folder ,it is not navigating to particular folder page");
		}

		// TC1.4-To verify on folder page ,two windows:DMS Workspace and Advance search
		// windows are present or not
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.visibilityOf(docUpload.checkDMSWorkspace()));
		wait.until(ExpectedConditions.visibilityOf(docUpload.checkAdvanceSerach()));
		if (docUpload.checkDMSWorkspace().isDisplayed() && docUpload.checkAdvanceSerach().isDisplayed()) {
			log.info("On folder page ,two windows:DMS Workspace and Advance search windows are present");
		} else {
			log.info("On folder page ,two windows:DMS Workspace and Advance search windows are not present");
		}

		// TC1.5 - To verify DMS Workspace and Advance search windows are clickable or
		// not
		if (docUpload.checkDMSWorkspace().isEnabled() && docUpload.checkAdvanceSerach().isEnabled()) {
			log.info("DMS Workspace and Advance search windows are clickable");
		} else {
			log.info("DMS Workspace and Advance search windows are not clickable");
		}

		// TC1.6-To verify after clicking on DMS Workspace windows, it contains the
		// folder related all document files/ffolders inside it or not
		wait.until(ExpectedConditions.elementToBeClickable(docUpload.checkDMSConsistFolders()));
		
		if (docUpload.checkDMSConsistFolders().isDisplayed()) {
			log.info("clicking on DMS Workspace windows, it contains the folder related all document files/ffolders inside it");
		} else {
			log.info("clicking on DMS Workspace windows, it does not contains the folder related all document files/ffolders inside it");
		}
		//  TC1.7-To verify on DMS work space window new folder icon,delete icon,refresh
		// icon present or not
		if (docUpload.checkIconNewFolder().isDisplayed() && docUpload.checkIconDelete().isDisplayed() && docUpload.checkIconRefresh().isDisplayed()) {
			log.info("In DMS work space window new folder icon,delete icon,refresh icon are present");
		} else {
			log.info("In DMS work space window new folder icon,delete icon,refresh icon are not present");
		}
		// TC1.8- To verify on DMS work space window new folder icon,delete icon,refresh
		// icons are clickable or not.
		if (docUpload.checkIconNewFolder().isEnabled() && docUpload.checkIconDelete().isEnabled()
				&& docUpload.checkIconRefresh().isEnabled()) {
			log.info("In DMS work space window new folder icon,delete icon,refresh icon are clickable");
		} else {
			log.info("In DMS work space window new folder icon,delete icon,refresh icon are not clickable");
		}
		// TC1.9-To verify check box for every file is given or not
		Assert.assertTrue(docUpload.checkFolderCheckBoxes().isDisplayed(), "CheckBoxes are not given for files");

		//  TC1.10-To verify check boxes are clickable or not
		Assert.assertTrue(docUpload.checkFolderCheckBoxes().isEnabled(), "CheckBoxes are not Clickable ");

		
		 wait.until(ExpectedConditions.elementToBeClickable(docUpload.checkEntityTypeRadio()));
		// TC1.11-To verify Entity Type radio buttons are present or not
		Assert.assertTrue(docUpload.checkEntityTypeRadio().isDisplayed(), "radio buttons are not present ");

		// To verify Entity Type radio buttons are clickable or not
		Assert.assertTrue(docUpload.checkEntityTypeRadio().isEnabled(), "radio buttons are not clikable ");

		// TC1.14 To verify if we click on particular radio button of entity type files
		// then it displays the uploaded document inside that file or not
		docUpload.checkEntityTypeRadio().click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
	//	wait.until(ExpectedConditions.elementToBeClickable(docUpload.checkDMSConsistFolders()));
		if (docUpload.checkDMSConsistFolders().isDisplayed()) {
			log.info(" clicking on particular radio button of  entity type files then it displays the uploaded document inside that file");
		} else {
			log.info(" clicking on particular radio button of  entity type files then it didn't displays the uploaded document inside that file");
		}

		// TC1.15-To verify if we click on particular radio button of file then it
		// displays the uploaded document inside that file ,on this page check box for
		// selecting the document present or not
		// TC1.16 -To verify check boxes are clickable or not
		 wait.until(ExpectedConditions.elementToBeClickable(docUpload.checkFolderCheckBoxes()));
		//Assert.assertTrue(docUpload.checkFolderCheckBoxes().isDisplayed(),"check box for selecting the document is not present ");
	
		Assert.assertTrue(docUpload.checkFolderCheckBoxes().isEnabled(),"check box for selecting the document is not Clickable ");

		// TC1.17-To verify add to favourite,view indexing details,icons are present
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		Thread.sleep(30000);
		docUpload.clickSubFolderSelenium().click();
//		if(docUpload.clickSubFolderSelenium().isEnabled())
//		{
//			docUpload.clickSubFolderSelenium().click();
//		}
//		else
//		{
//			log.info("Folder is already opened");
//		}

		if (docUpload.checkIconAddToFavorite().isDisplayed() && docUpload.checkIconViewIndexingDetails().isDisplayed())
		{
			log.info("add to favourite,view indexing details,icons are present");
		} 
		else
		{
			log.info("add to favourite,view indexing details,icons are not present");
		}
		// TC1.18-To verify upload file icon button present or not
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		wait.until(ExpectedConditions.elementToBeClickable(docUpload.checkIconUploadFile()));
		
		Assert.assertTrue(docUpload.checkIconUploadFile().isDisplayed(), "Upload file icon is not Present");

		// TC1.19- To verify upload file icon button clickable or not
		Assert.assertTrue(docUpload.checkIconUploadFile().isEnabled(), "Upload file icon is not clickable");

		// TC1.20 -To verify after clicking on upload file icon button ,upload file window opening or not
		docUpload.checkIconUploadFile().click();
		Assert.assertTrue(docUpload.checkPopupUploadFiles().isDisplayed(), "Upload files window is not opening");

		// TC1.21-On upload file window document date drop down calender box present or not
		// TC1.22- On upload file window document date drop down calender box clickable or not.
		Assert.assertTrue(docUpload.checkpopupLabelDocumentDate().isDisplayed()," document date drop down calender box not present");
		Assert.assertTrue(docUpload.checkpopupLabelDocumentDate().isEnabled()," document date drop down calender box not clickable");

		// TC1.23-On upload file window document date drop down calender box functioning
		// or no.
		docUpload.checkpopupLabelDocumentDate().click();
		if (docUpload.checkDropdownCheckBox().isDisplayed()) {
			log.info("upload file window document date drop down calender box functioning ");
		} else {
			log.info("upload file window document date drop down calender box not functioning ");
		}

		docUpload.selectDateCalenderBox().click();

		// TC1.24-On upload file window request approval drop down box present or not
		// TC1.25-On upload file window request approval drop down box clickable or not
		docUpload.clickTextReqestApproval().click();
		Assert.assertTrue(docUpload.checkDropdownRequestApproval().isDisplayed()," request approval drop down  box not present");
		Assert.assertTrue(docUpload.checkDropdownRequestApproval().isEnabled()," request approval drop down  box not clickable");

		// TC1.26- On upload file window request approval drop down list clickable or
		// not
		docUpload.checkDropdownRequestApproval().click();
		Assert.assertTrue(docUpload.checkOptionsRequestApproval().isEnabled()," request approval drop down list not clickable");

		// TC1.27-To verify select file box present or not
		// TC1.28-To verify select file box clickable or not
		 wait.until(ExpectedConditions.elementToBeClickable(docUpload.checkSelectFile()));
		docUpload.checkDropdownRequestApproval().click();
		Assert.assertTrue(docUpload.checkSelectFile().isDisplayed(), " select file box not present");
		Assert.assertTrue(docUpload.checkSelectFile().isEnabled(), " select file box not clickable");

		// TC1.29-To verify select file box functioning or not
		docUpload.clickTextReqestApproval().click();
		 wait.until(ExpectedConditions.elementToBeClickable(docUpload.checkSelectFile()));
		docUpload.checkSelectFile().sendKeys("C:\\Users\\Shamal Shinde\\Downloads\\selenium_documentation_index.pdf");

		// TC1.30-To verify upload file button present or not
		// TC1.31- To verify upload file button clickable or not
		Assert.assertTrue(docUpload.checkUploadFileButton().isDisplayed(), "upload file button is not present ");
		Assert.assertTrue(docUpload.checkUploadFileButton().isEnabled(), "upload file button is not clickable ");

		// TC1.37-To verify:200 kb PNG file size uploading or not
		docUpload.checkSelectFile().sendKeys("C:\\Users\\Shamal Shinde\\Downloads\\500kb.png");

		// TC1.38-To verify:20 mb PNG file size uploading or not
		docUpload.checkSelectFile().sendKeys("C:\\Users\\Shamal Shinde\\Downloads\\20mbpng.png");

		// TC1.39-To verify:30 mb PNG file size uploading or not
		docUpload.checkSelectFile().sendKeys("C:\\Users\\Shamal Shinde\\Downloads\\png-24mb_1_30000.png");

		// TC1.40-To verify:20 mb tiff file size uploading or not
		docUpload.checkSelectFile().sendKeys("C:\\Users\\Shamal Shinde\\Downloads\\BlackMarble_2016_928m_conus.tif");

		// TC1.41-To verify:39 mb tiff file size uploading or not
		docUpload.checkSelectFile().sendKeys("C:\\Users\\Shamal Shinde\\Downloads\\BlackMarble_2016_928m_conus.tif");

		// TC1.42-To verify:50 mb excel sheet file size uploading or not
		docUpload.checkSelectFile().sendKeys("C:\\Users\\Shamal Shinde\\Downloads\\MjAOlj88.xls");
		docUpload.checkUploadFileButton().click();
		Assert.assertFalse(!docUpload.checkPopupUploadFiles().isDisplayed(),"file with different sizes not uploading ");
		// TC1.43-To verify after opening the word file ,user have access to edit that
		// file,but if we click on font drop down then it displays only limited font
		// list ,also user can not search or add other font in that
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sweet-alert showSweetAlert visible']")));
		 wait.until(ExpectedConditions.elementToBeClickable(docUpload.clickOkSuffullyUpdated()));
		docUpload.clickOkSuffullyUpdated().click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		 wait.until(ExpectedConditions.elementToBeClickable(docUpload.clickListWordFile()));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String doubleClickScript = "var event = document.createEvent('MouseEvents');"
				+ "event.initEvent('dblclick', true, true);" + "arguments[0].dispatchEvent(event);";
		jsExecutor.executeScript(doubleClickScript, docUpload.clickListWordFile());
		
		//WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        //w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='se-toolbar sun-editor-common']/div[1]/ul[1]/li[1]/button[1]")));


	        
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		for (String handle : handles) {
			if (!handle.equals(currentWindowHandle)) 
			{
				driver.switchTo().window(handle);
				break;
			}
		}

		// Navigate to the second webpage in the new tab or window
		driver.get("https://ecm.writercorporation.com/InfoDocsV1/Document/ViewWordDoc?docId=361076&VerId=279842");

		// Perform some actions on the second webpage
		docUpload.clickDropdownFonts().click();

		// Close the new tab or window and switch back to the first tab or window
		driver.switchTo().window(currentWindowHandle);

		// 1.44-To verify uploaded 20 mb PNG file opening or not
		// 1.45-To verify uploaded 200 kb PNG file opening or not
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
		String doubleClickScript1 = "var event = document.createEvent('MouseEvents');"
				+ "event.initEvent('dblclick', true, true);" + "arguments[0].dispatchEvent(event);"
				+ "arguments[1].dispatchEvent(event);";
		jsExecutor1.executeScript(doubleClickScript1, docUpload.click20MbPng(), docUpload.click500MbPng());

		Set<String> handles1 = driver.getWindowHandles();
		String currentWindowHandle1 = driver.getWindowHandle();
		for (String handle : handles1) {
			if (!handle.equals(currentWindowHandle1)) 
			{
				driver.switchTo().window(handle);
				log.info("Successfully opening the png files");
				break;
			}
		}

		// Navigate to the second webpage in the new tab or window
		driver.get("https://ecm.writercorporation.com/InfoDocsV1/Document/ViewDoc?docId=361106&VerId=279873");
		
		if(driver.equals(currentWindowHandle1))
		{
			log.info("Navigate to the second webpage in the new tab or window");
		}
		else
			if(driver.equals(currentWindowHandle1))
			{
				log.info("Navigate to the second webpage is not opening");
			}
		
		// Close the new tab or window and switch back to the first tab or window
		driver.close();
		driver.switchTo().window(currentWindowHandle1);
		
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
