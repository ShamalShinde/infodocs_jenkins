package com.pageObjects.AccessControlMatrix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

	public class Module01 {
		WebDriver driver;
		public Module01(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}  

		@FindBy (xpath ="//a[@class='dropdown-toggle']//i[@class='ti-settings']")
		WebElement congfilogo;
		

		@FindBy (linkText ="Manage Users")
		WebElement manageUser;
		
		@FindBy (xpath ="//span[@id='select2-ddlSearch-container']")
		WebElement selectDrop;
		
		@FindBy (id ="txtUsersSearchVal")
		WebElement textBox;
		
		@FindBy (css ="i.ti-search")
		WebElement searchIcon;
		
		@FindBy (css ="i.ti-reload")
		WebElement resetUserIcon;

		@FindBy (css ="a.btn.btn-warning.btn-sm")
		WebElement addNewUserIcon;
		
		@FindBy (xpath = "//li[text()='Last Name']")
		WebElement selectUserName;
		
		@FindBy (id ="txtUsersSearchVal")
		WebElement selectTextBox;
		
		@FindBy (css ="i.glyphicon.glyphicon-edit")
		WebElement actionButton;
		
		@FindBy (xpath ="//h4[text()='User Mapping']")
		WebElement userMapping;
		
		@FindBy (xpath ="//select[@id='ddlUserRole']")
		WebElement userRoleText;
		
		@FindBy (css ="select#ddlDepartment")
		WebElement departmentDrop;
		
		@FindBy (css ="buston.btn.btn-sm.btn-warning")
		WebElement addButton;
		
		@FindBy (xpath ="//a[@ng-click='SaveUserRoleMap()']")
		WebElement submitButton;
		
		@FindBy (xpath ="//div[@id='dvUserMapDtls']//a[@class='btn btn-default'][normalize-space()='Back']")
		WebElement backButton;
		
//		@FindBy (xpath ="//tbody/tr[14]/td[4]/button[1]")
//		WebElement deleteButton;
		
		
		public WebElement Conffii() {

			return congfilogo; 

		}
		public WebElement ManageUser() {
			return manageUser;
		}
		public WebElement SelectDrop() {
			return selectDrop;
		}
		
		public WebElement TextBox() {
			return textBox;
		}
		public WebElement SearchIcon() {
			return searchIcon;
		}
		public WebElement ResetUserIcon() {
			return resetUserIcon;
		}
		public WebElement AddNewUserIcon() {
			return addNewUserIcon;
		}
		public WebElement SelectUserNamee() {
			return selectUserName;
		}
		public WebElement SelectTextBox() {
			return selectTextBox;
		}
		public WebElement ActionButton() {
			return actionButton;
		}
		public WebElement UserMap() {
			return userMapping;
		}
		public WebElement UserRoll() {
			return userRoleText;
		}
		public WebElement DepartmentDrop() {
			return departmentDrop;
		}

		public void getSelectedOption() {
			WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='ddlDepartment']"));

			Select dropdown = new Select(dropdownElement);

			dropdown.selectByVisibleText("RRR");

		}
		
		public void clickOption_UserRole() {
			WebElement dropdownElement1 = driver.findElement(By.xpath("//select[@id='ddlUserRole']"));

			Select dropdown1 = new Select(dropdownElement1);

			dropdown1.selectByIndex(8);

		}
		
		public WebElement AddButton() {
			return addButton;
		}
		
		public WebElement SubmitButton() {
			return submitButton;
		}
		
		public WebElement BackButtton() {
			return  backButton;
		}
		
//		public WebElement DeleteButtton() {
//			return  deleteButton;
//		}
	}



	  
