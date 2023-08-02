package com.pageObjects.userpreference;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;

public class UserPreferenceFunctionalityObj {
	private List<By> elementLocators;

	public WebDriver driver;

	public UserPreferenceFunctionalityObj(WebDriver driver) {
		this.driver = driver;
		elementLocators = new ArrayList<>();

	}

	// TC-1.1 To verify all the elements are present on user home page or not
	public void addElementLocator(By locator) {
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

	// TC-1.2 To verify on user home page user profile window #private workspace is
	// present
	// on left side or not

	By sidebar_PrivateWorkspace = By.xpath("//ul[@class='main-navigation-menu']");

	public WebElement clickPrivateWorkSpace() {

		return driver.findElement(sidebar_PrivateWorkspace);

	}

	// TC-1.3 To verify user profile window is clickable or not

	By sidemenu_TestDemo = By.xpath("//li[@class='liSideMenu fademenu closed']//i[@class='icon-arrow']");

	public WebElement clickTestDemo() {

		return driver.findElement(sidemenu_TestDemo);

	}

	// TC-1.5 To verify after clicking on user profile it displays the next window
	// including my work space,my favorite,
	// my recent file,inbox,outbox,rejected documents or not

	By frame_MyWorkSpace = By.cssSelector("a[href='#dvFolderFilesList']");
	By frame_MyFavorites = By.cssSelector("a[href='#dvFavourite']");
	By frame_MyRecentFiles = By.cssSelector("a[href='#dvRecentFiles']");
	By frame_Inbox = By.xpath("//a[@href='#dvPendForAppr']");
	By frame_Outbox = By.xpath("//a[@href='#dvSentForAppr']");
	By frame_RejectedDocuments = By.xpath("//a[@href='#dvRejDoc']");

	public WebElement clickMyWorkSpace() {

		return driver.findElement(frame_MyWorkSpace);

	}

	public WebElement clickMyFavorites() {

		return driver.findElement(frame_MyFavorites);

	}

	public WebElement clickMyRecentFiles() {

		return driver.findElement(frame_MyRecentFiles);

	}

	public WebElement clickInbox() {

		return driver.findElement(frame_Inbox);

	}

	public WebElement clickOutbox() {

		return driver.findElement(frame_Outbox);

	}

	public WebElement clickRejectedDocuments() {

		return driver.findElement(frame_RejectedDocuments);

	}

	// TC-2.3 To verify all icons are clickable or not
	By button_TestDemo = By.cssSelector("a[class='ng-scope']");
	By button_GoToPriviousFolder = By.xpath("//i[@class='ti-control-backward']");
	By button_Refresh = By.xpath("(//i[@class='ti-reload'])[1]");

	public WebElement clickTestDemoFolder() {

		return driver.findElement(button_TestDemo);

	}

	public WebElement clickGoToPriviousFolder() {

		return driver.findElement(button_GoToPriviousFolder);

	}

	public WebElement clickRefresh() {

		return driver.findElement(button_Refresh);

	}

}
