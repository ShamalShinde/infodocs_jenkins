package com.pageObjects.AccessControlMatrix;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

	public class Module03 {
		WebDriver driver;
		public Module03(WebDriver driver) {
			this.driver=driver;
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			PageFactory.initElements(driver, this);
		}  

		@FindBy (xpath ="//span[normalize-space()='selenium']")
		WebElement selectDepartment;
		

		@FindBy (css ="a.btn.btn-warning.btn-o1.btn-sm.pull-right")
		WebElement newFolderIcon;
		 
		@FindBy (xpath ="//button[@ng-click='createFolder()']")
		WebElement createFolder;
		
		@FindBy (id="myInput")
		WebElement nameText;
		
		@FindBy (id="rdoPublic")
		WebElement radio1;
		
		@FindBy (id="rdoPrivate")
		WebElement radio2;
		
		@FindBy (xpath ="//h2[text()='SUCCESS']")
		WebElement sucessWindow;
		
		
		
		public WebElement SelectDepart() {
			return selectDepartment;
		}
		public WebElement NewFolderIcon() {
			return newFolderIcon;
		}
		public WebElement CreateFolder() {
			return createFolder;
		}
		public WebElement NameTextBox() {
			return nameText;
		}
		public WebElement Radio1() {
			return radio1;
		}
		public WebElement Radio2() {
			return radio2;
		}
		public WebElement SuccessWindow() {
			return sucessWindow;
		}
	}

	  
