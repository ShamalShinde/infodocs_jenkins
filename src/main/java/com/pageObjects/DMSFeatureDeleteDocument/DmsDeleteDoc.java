package com.pageObjects.DMSFeatureDeleteDocument;



import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

	public class DmsDeleteDoc {
		WebDriver driver;
		public String originalWindowHandle;
		public DmsDeleteDoc(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}  
		@FindBy (xpath = "//i[@class='glyphicon glyphicon-trash']")
		WebElement deleteIcon;
		
		@FindBy (xpath = "//button[normalize-space()='Cancel']")
		WebElement cancleButtonPopup;
		
		@FindBy (xpath = "//button[normalize-space()='Delete']")
		WebElement deleteButtonPopup;
		
		@FindBy (xpath = "//button[normalize-space()='OK']")
		WebElement cancleOk;
		
		@FindBy (xpath = "//label[@for='chkFolderAndFiles_0']")
		WebElement checkBoxDelete;
		
		@FindBy (xpath = "//button[normalize-space()='Ok']")
		WebElement deleteOk;
		
		@FindBy (xpath = "//a[contains(text(),'T1')]")
		WebElement folderBackClick;
		
		@FindBy (xpath ="//div[@class='col-xs-10 max-over']//span[@class='ng-binding'][normalize-space()='Tst']")
		WebElement folderIcon;
		
		@FindBy (xpath ="//a[normalize-space()='Delete Folder']")
		WebElement deleteFolder;
		
		@FindBy (xpath ="//button[normalize-space()='Cancel']")
		WebElement cancledeleteFolder;
		
		@FindBy (xpath ="//button[normalize-space()='Delete']")
		WebElement deleteDeleteFolder;
		
		@FindBy (xpath ="//button[normalize-space()='OK']")
		WebElement okcancleDeleteDolder;
		
		@FindBy (xpath ="//div[@class='col-xs-10 max-over']//span[@class='ng-binding'][normalize-space()='staff']")
		WebElement stafffolderIcon;
		
		@FindBy (css =".confirm")
		WebElement okdeleteDeleteFolder;
		
          public WebElement DeleteIcon() {
        	  return deleteIcon;
          }
          public WebElement CanclePop() {
        	  return cancleButtonPopup;
          }
          public WebElement DeletePop() {
        	  return deleteButtonPopup;
          }
          public WebElement CancleOKBtn() {
        	  return cancleOk;
          }
          public WebElement CheckBoxDel() {
        	  return checkBoxDelete;
          }
          public WebElement DeleteOKBtn() {
        	  return deleteOk;
          }
          public WebElement FolderBackClick() {
        	  return folderBackClick;
          }
          
          public void rightClickElement() {
		        Actions actions = new Actions(driver);
		        actions.contextClick(folderIcon).perform();
		    }
          
          public void StaffrightClickElement() {
		        Actions actions = new Actions(driver);
		        actions.contextClick(stafffolderIcon).build().perform();
		    }
          public WebElement DeleteFolderr() {
        	  return deleteFolder;
          }
          public WebElement CancleDeleteFolderr() {
        	  return cancledeleteFolder;
          }
          public WebElement DeleteDeleteFolderr() {
        	  return deleteDeleteFolder;
          }
          public WebElement OKCancleDeleteFolderr() {
        	  return okcancleDeleteDolder;
          }
          public WebElement OKDeleteDeleteFolderr() {
        	  return okdeleteDeleteFolder;
          }
//          public WebElement CheckBoxFiles() {
//        	  return checkBoxFiles;
//          }
//          public void AcceptPopup() {
//              Alert alert = driver.switchTo().alert();
//              alert.accept();
//          }

          
          }

	  
