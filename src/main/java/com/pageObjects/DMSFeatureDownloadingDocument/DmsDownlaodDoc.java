package com.pageObjects.DMSFeatureDownloadingDocument;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

	public class DmsDownlaodDoc {
		WebDriver driver;
		public String originalWindowHandle;
		public DmsDownlaodDoc(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}  
		@FindBy (xpath = "//span[normalize-space()='T1']")
		WebElement selectDepartmentInfoDocs;
		
		@FindBy (xpath = "//tr[@id='div224881']//img[1]")
		WebElement clickOnFolder1;
		
		@FindBy (css = ".btn.btn-dark-orange.btn-o1.btn-sm.pull-right")
		WebElement downliadZipBtn;
		
		@FindBy (xpath  = "//label[@for='chkFolderAndFiles_0']")
		WebElement checkBoxFiles;
		
		@FindBy (xpath = "//div[@class='col-xs-10 max-over']//span[@class='ng-binding'][normalize-space()='WRITER.png']")
		public WebElement file;
		
		@FindBy (xpath = "//a[normalize-space()='Download File']")
		 WebElement downloadFileOptn;
		
		
		 public void rightClickElement() {
		        Actions actions = new Actions(driver);
		        actions.contextClick(file).perform();
		    }
		 public WebElement DownloadFileOptn() {
       	  return downloadFileOptn;
         }

          public WebElement SelectInfoDocs() {
        	  return selectDepartmentInfoDocs;
          }
          public WebElement ClickOnFolder1() {
        	  return clickOnFolder1;
          }
          public WebElement DownloadZipBtn() {
        	  return downliadZipBtn;
          }
          public WebElement CheckBoxFiles() {
        	  return checkBoxFiles;
          }
          public void AcceptPopup() {
              Alert alert = driver.switchTo().alert();
              alert.accept();
          }

          
          }

	  
