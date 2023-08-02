package com.pageObjects.DMSDocumentShareOnMail;



import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.interactions.Actions;


	public class DmsDocMail {
		WebDriver driver;
		public String originalWindowHandle;
		public DmsDocMail(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}  
		@FindBy (xpath = "//span[normalize-space()='T1']")
		WebElement selectDepartmentInfoDocs;
		
		@FindBy (xpath = "//tr[@id='div224881']//img[1]")
		WebElement clickOnFolder1;
		
		@FindBy (xpath = "//div[@class='col-xs-10 max-over']//span[@class='ng-binding'][normalize-space()='WRITER.png']")
		public WebElement file;
		
		@FindBy (xpath = "//a[normalize-space()='View Document']")
		 public WebElement viewDocument;
		
		@FindBy (css = "div[class='col-xs-6'] h4")
		 WebElement verifyNewWindow;
		
		@FindBy (xpath = "//a[normalize-space()='Download File']")
		 WebElement downloadFileInList;
		
		@FindBy (xpath = "//a[normalize-space()='Email']")
		 WebElement emailInList;
		
		@FindBy (xpath = "//span[normalize-space()='Share Document on Email']")
		 WebElement verifyEmailClick;
		
		@FindBy (xpath = "//b[normalize-space()='To']")
		 WebElement toEmail;
		
		@FindBy (xpath = "//b[normalize-space()='Cc']")
		 WebElement cCEmail;
		
		@FindBy (xpath = "//b[normalize-space()='Subject']")
		 WebElement subjectEmail;
		
		@FindBy (xpath = "//b[normalize-space()='Message']")
		 WebElement messageEmail;
		
		@FindBy (xpath = "//button[normalize-space()='Send']")
		 WebElement sendEmail;
		
		@FindBy (xpath = "//button[@ng-click='closePop()'][normalize-space()='Close']")
		 WebElement closeEmail;
		
		@FindBy (xpath = "//div[@id='modalEmailShare']//i[@class='glyphicon glyphicon-remove md-close-red']")
		 WebElement crossEmail;
		
		@FindBy (xpath = "//input[@id='emailTo']")
		 WebElement toEmailtextField;
		
		@FindBy (xpath = "//input[@id='emailCc']")
		 WebElement cCEmailtextField;
		
		@FindBy (xpath = "//input[@id='emailSubject']")
		 WebElement subjectEmailtextField;
		
		@FindBy (xpath = "//div[@class='note-editor note-frame panel panel-default']")
		 WebElement messageEmailtextField;
		
		@FindBy (xpath = "//button[normalize-space()='Ok']")
		 WebElement okSendMailError;
		
		@FindBy (xpath = "	//a[contains(text(),'T1')]")
		 WebElement T1Folder;
	
		
		public void verifyCursorMovability() {
	        
	        Actions actions = new Actions(driver);
	        actions.moveToElement(downloadFileInList).perform();

	      
	    }
		
          public WebElement SelectInfoDocs() {
        	  return selectDepartmentInfoDocs;
          }
          public WebElement ClickOnFolder1() {
        	  return clickOnFolder1;
          }
          public void rightClickElement() {
		        Actions actions = new Actions(driver);
		        actions.contextClick(file).perform();
		    }
           
         
          public WebElement ViewDocument() {
        	  return viewDocument;
          }

          public WebElement DownloadFileInList() {
        	  return downloadFileInList;
          }
          public WebElement EmailInList() {
        	  return emailInList;
          }
          public WebElement VerifyEmailClick() {
        	  return verifyEmailClick;
          }
          
          public WebElement ToEmail() {
        	  return toEmail;
          }
          public WebElement CcEmail() {
        	  return cCEmail;
          }
          public WebElement SubjectEmail() {
        	  return subjectEmail;
          }
          public WebElement MessageEmail() {
        	  return messageEmail;
          }
          public WebElement SendEmail() {
        	  return sendEmail;
          }
          public WebElement CloseEmail() {
        	  return closeEmail;
          }
          public WebElement CrossEmail() {
        	  return crossEmail;
          }
          public WebElement ToTextFieldEmail() {
        	  return toEmailtextField;
          }
          public WebElement CcTextFieldEmail() {
        	  return cCEmailtextField;
          }
          public WebElement SubjectTextFieldEmail() {
        	  return subjectEmailtextField;
          }
          public WebElement MessageTextFieldEmail() {
        	  return MessageTextFieldEmail();
          }
          public WebElement OKSendMAilError() {
        	  return okSendMailError;
          }
          public WebElement T1FolderClick() {
        	  return T1Folder ;
          
          }
          public void Navigate() {
        	  driver.navigate().back();
          }
          }

	  
