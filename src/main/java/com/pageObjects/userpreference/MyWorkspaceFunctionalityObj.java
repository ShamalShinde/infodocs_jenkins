package com.pageObjects.userpreference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWorkspaceFunctionalityObj {

	public WebDriver driver;

	public MyWorkspaceFunctionalityObj(WebDriver driver) {
		this.driver = driver;

	}

	By sidebar_PrivateWorkspace = By.xpath("//ul[@class='main-navigation-menu']");

	public WebElement clickPrivateWorkSpace() {

		return driver.findElement(sidebar_PrivateWorkspace);

	}

	By sidemenu_TestDemo = By.xpath("//li[@class='liSideMenu fademenu closed']//i[@class='icon-arrow']");

	public WebElement clickTestDemo() {

		return driver.findElement(sidemenu_TestDemo);
	}

	By frame_MyWorkSpace = By.xpath("//a[@href='#dvFolderFilesList']");

	public WebElement clickMyWorkSpace() {

		return driver.findElement(frame_MyWorkSpace);

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
