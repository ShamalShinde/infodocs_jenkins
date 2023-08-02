package com.pageObjects.AccessControlMatrix;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

	public class Module02 {
		WebDriver driver;
		public Module02(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}  

		@FindBy (xpath ="//input[@name='fname']")
		WebElement firstName;
		

		@FindBy (xpath ="//a[@class='btn btn-primary panel-refresh']")
		WebElement sub;
		 
		@FindBy (xpath ="//button[@class='confirm']")
		WebElement errorButton;
		 
		@FindBy (xpath ="//input[@type='number']")
		WebElement mobileTextbox;
		
		@FindBy (xpath  ="//textarea[@ng-model='CurrentUser.Description']")
		WebElement discripBox;
		
		@FindBy (xpath  ="//input[@ng-model='CurrentUser.Email']")
		WebElement emailBox;
		
		@FindBy (xpath  ="//input[@ng-model='CurrentUser.Location']")
		WebElement locationBox;
		
		@FindBy (xpath  ="//div[@class='col-sm-2']//small")
		WebElement activeToggle;
		
		@FindBy (xpath  ="//div[@class='col-sm-3']//small")
		WebElement passChangeToggle; 
		
//		public WebElement Conffii() {
//
//			return congfilogo; 
//
//		}
//		public WebElement ManageUser() {
//			return manageUser;
//		}
//		public WebElement SelectDrop() {
//			return selectDrop;
//		}
//		
//		public WebElement TextBox() {
//			return textBox;
//		}
//		public WebElement SearchIcon() {
//			return searchIcon;
//		}
//		public WebElement ResetUserIcon() {
//			return resetUserIcon;
//		}
//		public WebElement AddNewUserIcon() {
//			return addNewUserIcon;
//		}
//		public WebElement SelectUserNamee() {
//			return selectUserName;
//		}
		public WebElement Sub() {
			return sub;
		}
		public WebElement FirstName() {
			return firstName;
		}
		public WebElement ErrorButton() {
			return errorButton;
		}
		public WebElement MobileTextBox() {
			return mobileTextbox;
		}
		public WebElement DiscriptionBox() {
			return discripBox;
		}
		public WebElement EmailBox() {
			return emailBox;
		}
		public WebElement LocationBox() {
			return locationBox;
		}
		public WebElement ActiveToggle() {
			return activeToggle;
		}
		public WebElement PassToggle() {
			return passChangeToggle;
		}
	}

	  
