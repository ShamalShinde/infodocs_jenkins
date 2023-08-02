package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Config_Page {

	public WebDriver driver;

	public Config_Page(WebDriver driver) {
		this.driver = driver;
	}

	// By menu_Config = By.xpath("//span[normalize-space()='Configuration']");
	By dropdown_ManageUser = By.cssSelector("li[class='dropdown pull-right open'] li:nth-child(3) a:nth-child(1)");
	By button_Search = By.id("select2-ddlSearch-container");
	By dropdown_LastName = By.xpath("//li[text()='Last Name']");
	By option_LastName = By.id("txtUsersSearchVal");
	By input_Name = By.cssSelector("i.ti-search");
	By icon_Edit = By.xpath("//a[@class1='btn btn-info btn-sm btn-o']");
	By frame_UserMapping = By.xpath("//h4[text()='User Mapping']");
	By dropdown_Depatment = By.xpath("//select[@id='ddlDepartment']");
	By option_UserDept = By.xpath("//select[@id='ddlUserRole']");
	By dropdown_UserRole = By.cssSelector("buston.btn.btn-sm.btn-warning");
	By button_Save = By.xpath("//a[@ng-click='SaveUserRoleMap()']");
	By popup_Ok = By.cssSelector("button.confirm");
	By option_Logout = By.xpath("//a[normalize-space()='Logout']");

	public Actions ConfigTab() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Configuration']"))).click().build().perform();
		return action;

	}

	public WebElement manageUser() {

		return driver.findElement(dropdown_ManageUser);

	}

	public WebElement serachUser() {

		return driver.findElement(button_Search);

	}

	public WebElement selectUserName() {

		return driver.findElement(dropdown_LastName);

	}

	public WebElement lastNameText() {

		return driver.findElement(option_LastName);

	}

	public WebElement lastNameSearch() {

		return driver.findElement(input_Name);

	}

	public WebElement actionIcon() {

		return driver.findElement(icon_Edit);

	}

	public WebElement userMapping() {

		return driver.findElement(frame_UserMapping);

	}

	public void getSelectedOption() {
		WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='ddlDepartment']"));

		Select dropdown = new Select(dropdownElement);

		dropdown.selectByVisibleText("RRR");

	}

	public WebElement selectDept() {
		return driver.findElement(dropdown_Depatment);

	}

	public void clickOption_UserRole() {
		WebElement dropdownElement1 = driver.findElement(By.xpath("//select[@id='ddlUserRole']"));

		Select dropdown1 = new Select(dropdownElement1);

		dropdown1.selectByIndex(8);

	}

	public WebElement click_Role() {
		return driver.findElement(option_UserDept);

	}

	public WebElement select_addingRole() {
		return driver.findElement(dropdown_UserRole);

	}

	public WebElement clickSave() {
		return driver.findElement(button_Save);

	}

	public WebElement clickOK() {
		return driver.findElement(popup_Ok);

	}
	public WebElement clickLogout() {

		return driver.findElement(option_Logout);

	}

}
