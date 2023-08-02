package com.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ManageDepartment_main 
{

	public WebDriver driver;

	public ManageDepartment_main(WebDriver driver) {
		this.driver = driver;
	}

	By menu_Profile = By.xpath("(//a[@class='dropdown-toggle'])[1]");

	By option_ManageDepartment = By.xpath("//a[@href='/InfoDocsV1/Department/Index']");
	By button_AddDepartment = By.xpath("//i[@class='ti-plus']");
	By input_DepartmentName = By.id("txtSubject");
	By button_SaveDepartment = By.xpath("//a[normalize-space()='Save']");
	By button_OkDepartment = By.cssSelector(".confirm");
	By option_ManageUser = By.xpath("//a[@href='/InfoDocsV1/User/Index']");
	By dropdown_SearchBy = By.cssSelector("span[role='presentation']");
	By option_SearchBy = By.xpath("//li[text()='Username']");
	By input_SearchBy = By.id("txtUsersSearchVal");
	By button_Search = By.cssSelector(".btn.btn-sm.btn-success");
	By button_Action = By.xpath("//i[@class='glyphicon glyphicon-edit']");
	By frame_UserMapping = By.xpath("//a[@href='#dvUserMapDtls']");
	By dropdown_Department =By.xpath("//select[@id='ddlDepartment']");
	By dropdown_UserRole = By.cssSelector("#ddlUserRole");
	By button_AddDepartmentRole = By.cssSelector("buston[type='button']");
	By button_SaveUserRole = By.cssSelector("a[ng-click='SaveUserRoleMap()']");
	By button_OkUserRole = By.cssSelector(".confirm");
	By option_Logout = By.xpath("//a[normalize-space()='Logout']");
	String input_NewDepartment = "selenium";
	By option_NewDepartment = By.xpath("//span[contains(text(), '" + input_NewDepartment + "')]");
	By menu_UserProfile = By.cssSelector("li.dropdown.current-user.pull-right");
	By dropdown_UserProfile = By.xpath("(//a[@class='dropdown-toggle'])[1]");
	
	public Actions ConfigTab() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Configuration']"))).click().build().perform();
		return action;

	}
	public WebElement getProfileDropdown() {

		return driver.findElement(dropdown_UserProfile);

	}

	public WebElement clickUserProfile() {

		return driver.findElement(menu_Profile);

	}

	public WebElement clickManageDepartment() {

		return driver.findElement(option_ManageDepartment);

	}

	public WebElement clickAddDepartment() {

		return driver.findElement(button_AddDepartment);

	}

	public WebElement getDepartmentName() {

		return driver.findElement(input_DepartmentName);

	}

	public WebElement clickSaveDepartment() {

		return driver.findElement(button_SaveDepartment);

	}

	public WebElement clickOkDepartment() {

		return driver.findElement(button_OkDepartment);

	}

	public WebElement clickManageUser() {

		return driver.findElement(option_ManageUser);

	}

	public WebElement clickSearchBy() {

		return driver.findElement(dropdown_SearchBy);

	}

	public WebElement clickSearchByoption() {

		return driver.findElement(option_SearchBy);

	}

	public WebElement getSearchBy() {

		return driver.findElement(input_SearchBy);

	}

	public WebElement clickSearch() {

		return driver.findElement(button_Search);

	}

	public WebElement clickAction() {

		return driver.findElement(button_Action);

	}

	public WebElement clickUserMapping() {

		return driver.findElement(frame_UserMapping);

	}

	public WebElement clickDepartment() {

		return driver.findElement(dropdown_Department);

	}

	public WebElement clickUserRole() {

		return driver.findElement(dropdown_UserRole);

	}

	public WebElement getAddDepartmentRole() {

		return driver.findElement(button_AddDepartmentRole);

	}

	public WebElement clickSaveUserRole() {

		return driver.findElement(button_SaveUserRole);

	}

	public WebElement clickOkUserRole() {

		return driver.findElement(button_OkUserRole);

	}

	public WebElement clickLogout() {

		return driver.findElement(option_Logout);

	}

	public WebElement clickNewDepartment() {

		return driver.findElement(option_NewDepartment);

	}
}
