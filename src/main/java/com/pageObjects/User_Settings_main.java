package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class User_Settings_main

{

	public WebDriver driver;

	public User_Settings_main(WebDriver driver) {
		this.driver = driver;
	}

	By menu_UserProfile = By.cssSelector("li.dropdown.current-user.pull-right");
	By dropdown_UserProfile = By.xpath("(//a[@class='dropdown-toggle'])[1]");
	By option_UserSettings = By.cssSelector("li[class='dropdown current-user pull-right open'] li:nth-child(1) a:nth-child(1)");
	By input_FirstName = By.id("firstname");
	By input_LastName = By.id("lastname");
	By input_Email = By.id("email");
	By input_PhoneNumber = By.id("phone");
	By button_ChangeProfilePicture = By.cssSelector("#ProfileImageFile");
	By button_RemoveProfilePicture = By.cssSelector(".btn.fileinput-exists.btn-red");
	By button_UpdateInfo = By.cssSelector("button.btn.btn-primary.pull-right[ng-click$='updateUserProfile()']");
	By popup_OkUserSettings = By.cssSelector("button.confirm");
	By frame_ChangePassowrd = By.xpath("//a[@href='#panel_change_password']");
	By input_OldPassword = By.cssSelector("input[name='oldpassword']");
	By input_NewPassowrd = By.cssSelector("input[placeholder='New password']");
	By input_ConfirmPassword = By.cssSelector("input[placeholder='Confirm new password']");
	By button_UpdatePassword = By.cssSelector("button[ng-click='resetPassword()']");
	By popup_SuccesfulChangePassword = By.cssSelector(".confirm");
	By frame_EditAccount = By.xpath("//h4[normalize-space()='Edit Account']");

	public Actions getUpdateUser() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("li.dropdown.current-user.pull-right"))).click().build().perform();
		return action;
	}

	public WebElement getProfileDropdown() {

		return driver.findElement(dropdown_UserProfile);

	}

	public WebElement getUserSetting() {

		return driver.findElement(option_UserSettings);

	}
	

	public WebElement getFirstName() {

		return driver.findElement(input_FirstName);

	}

	public WebElement getLastName() {

		return driver.findElement(input_LastName);

	}

	public WebElement getEmail() {

		return driver.findElement(input_Email);

	}

	public WebElement getPhone() {

		return driver.findElement(input_PhoneNumber);

	}

	public WebElement clickChangeprofilepicture() {

		return driver.findElement(button_ChangeProfilePicture);

	}

	public WebElement clickRemovePicture() {

		return driver.findElement(button_RemoveProfilePicture);

	}

	public WebElement clickUpdateInformation() {

		return driver.findElement(button_UpdateInfo);

	}

	public WebElement clickOKUserSettings() {

		return driver.findElement(popup_OkUserSettings);

	}

	public WebElement getChangePassowrd() {

		return driver.findElement(frame_ChangePassowrd);

	}

	public WebElement getOldPassword() {

		return driver.findElement(input_OldPassword);

	}

	public WebElement getNewPassowrd() {

		return driver.findElement(input_NewPassowrd);

	}

	public WebElement getConfirmPassword() {

		return driver.findElement(input_ConfirmPassword);

	}

	public WebElement clickResetPassword() {

		return driver.findElement(button_UpdatePassword);

	}

	public WebElement clickOk() {

		return driver.findElement(popup_SuccesfulChangePassword);

	}

	public WebElement clickEditAccount() {

		return driver.findElement(frame_EditAccount);

	}

}
