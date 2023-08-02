package com.pageObjects.userProfile;

import java.util.List; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;


public class UserProfileFunctionalityObject {
	private List<By> elementLocators;
	private List<By> dropdownLocators;
	public WebDriver driver;

	public UserProfileFunctionalityObject(WebDriver driver) {
		this.driver = driver;
		elementLocators = new ArrayList<>();
		dropdownLocators = new ArrayList<>();
	}

	public void addElementLocator(By locator) 
	{
		elementLocators.add(By.cssSelector(".ti-bar-chart"));
		elementLocators.add(By.cssSelector("a[class='dropdown-toggle'] i[class='ti-settings']"));
		elementLocators.add(By.cssSelector("img[alt='User']"));
		elementLocators.add(By.cssSelector("li[class='liSideMenu fademenu closed'] span[class='title']"));
		elementLocators.add(By.xpath("//span[contains(text(),' Shared With Me ')]"));
		elementLocators.add(By.cssSelector("span[ng-click='ViewDFiles()']"));
		elementLocators.add(By.xpath("//h3[@style='margin-top:5px']"));
	}

	public boolean areAllElementsEnabled() {
		boolean allElementsEnabled = true;
		for (By locator : elementLocators) {
			WebElement element = driver.findElement(locator);
			if (!element.isEnabled()) {
				allElementsEnabled = false;
				break;
			}
		}
		return allElementsEnabled;
	}
	
	

	// To verify user profile photo icon present or not

	By img_UserProfile = By.xpath("//img[@src='/InfoDocsV1/Script/assets/images/default-user.png']");

	public WebElement checkUserProfileImg() {
		return driver.findElement(img_UserProfile);
	}

	// To verify if we take cursor on right hand side user profile photo icon then
	// it shows drop down list or not
	By menu_UserProfile = By.cssSelector("li.dropdown.current-user.pull-right");

	public WebElement getUserProfile() {

		return driver.findElement(menu_UserProfile);
	}

	// To verify after clicking on User setting it is navigating to next page or not
	By option_UserSettings = By.xpath("//a[@href='/InfoDocsV1/User/UserSetting']");

	public WebElement getUserSetting() {

		return driver.findElement(option_UserSettings);

	}

	// To verify all drop down lists are clickable or not - User Profile

	public void addElementUserDropdown(By locator) {
		dropdownLocators.add(By.xpath("//a[@href='/InfoDocsV1/User/UserSetting']"));
		dropdownLocators.add(By.xpath("//a[@href='/InfoDocsV1/Support/Index']"));
		dropdownLocators.add(By.xpath("//a[@href='/InfoDocsV1/Home/ViewUserManaul']"));
		dropdownLocators.add(By.xpath("//a[@href='/InfoDocsV1/Home/Logout']"));

	}

	public boolean areAllElementsClicked() {
		boolean allElementsEnabled = true;
		for (By locator : dropdownLocators) {
			WebElement element = driver.findElement(locator);
			if (!element.isEnabled()) {
				allElementsEnabled = false;
				break;
			}
		}
		return allElementsEnabled;
	}
}
