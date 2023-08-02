package com.pageObjects.AccessControlMatrix;



import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

	public class Module04 {
		WebDriver driver;
		public Module04(WebDriver driver) {
			this.driver=driver;
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			PageFactory.initElements(driver, this);
		}  

		@FindBy (xpath ="//tr[@id='div245083']//img[1]")
		WebElement folderIcon;
		
		@FindBy (xpath ="//a[@class='dropdown-item'][normalize-space()='Properties']")
		WebElement propertiesButton;
		
		@FindBy (xpath ="//div[@id='modalFolderProp']//i[@class='glyphicon glyphicon-remove md-close-red']")
		WebElement folderPropertiesTitle;
		
		@FindBy (xpath ="//a[normalize-space()='Template']")
		WebElement templateButton;
		
		@FindBy (xpath ="//a[normalize-space()='Access']")
		WebElement accessButton;
		
		@FindBy (xpath ="//a[normalize-space()='Archive']")
		WebElement archiveButton;
		
		@FindBy (xpath ="//a[normalize-space()='Approver Status Log']")
		WebElement approverButton;
		
		@FindBy (xpath ="//span[@id='select2-ddlFolderUserAccess-container']")
		WebElement firstDrop1;
		
		@FindBy (xpath ="//li[text()='Abdul Samad']")
		WebElement selectUserFromFirst;
		
		@FindBy (xpath ="//span[@id='select2-ddlFolderUserAccessSpecRole-container']")
		WebElement secondDrop2;
		
		@FindBy (xpath ="//li[text()='1 - View Only']")
		WebElement selectUserFromSecond;
		
		@FindBy (xpath ="//button[normalize-space()='Add']")
		WebElement addAccessButton;
		
		@FindBy (xpath ="//button[normalize-space()='Save Permission']")
		WebElement permissonButton;
		
		
		@FindBy (xpath ="//h2[normalize-space()='Validation']")
		WebElement validationWin;
		
		@FindBy (xpath ="//li[text()='--Select Role--']")
		WebElement selectRoleBack;
		
		@FindBy (xpath ="//button[normalize-space()='Ok']")
		WebElement okButton;
		
		@FindBy (xpath ="//li[text()='--Select User--']")
		WebElement selectUserBack;
		
		@FindBy (xpath ="//button[@class='btn btn-danger btn-sm']")
		WebElement resultAfterAdd;
		
		@FindBy (xpath ="//button[normalize-space()='Ok']")
		WebElement finalSubmitBtn;
		
		
		 public void rightClickElement() {
		        Actions actions = new Actions(driver);
		        actions.contextClick(folderIcon).perform();
		    }
          public WebElement PrpoertiesButton() {
        	  return propertiesButton;
          }
          public WebElement FolderProperties() {
        	  return folderPropertiesTitle;
          }
          public WebElement Template() {
        	  return templateButton;
          }
          public WebElement Access() {
        	  return accessButton;
          }
          public WebElement Archive() {
        	  return archiveButton;
          }
          public WebElement Aprroveer() {
        	  return approverButton;
          }
          public WebElement AddAccess() {
        	  return addAccessButton;
          }
          
          public WebElement FirstDrop() {
        	  return firstDrop1;
          }
          public WebElement SelectUser1() {
        	  return selectUserFromFirst;
          }
          public WebElement SecondDrop() {
        	  return secondDrop2;
          }
          public WebElement SelectUser2() {
        	  return selectUserFromSecond;
          }
          public WebElement PermissionButton() {
        	  return permissonButton;
          }
          public WebElement ValidationWindow() {
        	  return validationWin;
          }
          public WebElement SelectRollBack() {
        	  return selectRoleBack;
          }
          public WebElement OkButton() {
        	  return okButton;
          }
          public WebElement SelectUserBack() {
        	  return selectUserBack;
          }
          public WebElement ResultAfterAdd() {
        	  return resultAfterAdd;
          }
          
          public WebElement FinalSubmitBtn() {
        	  return finalSubmitBtn;
          }
	}

	  
