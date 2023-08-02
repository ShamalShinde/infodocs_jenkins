package com.pageObjects.userpreference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RefreshIconFunctionalityObj {
	

	public WebDriver driver;

	public RefreshIconFunctionalityObj(WebDriver driver) {
		this.driver = driver;
		
	}

	
	//  To verify user profile window is clickable or not

	By sidemenu_TestDemo = By.xpath("//li[@class='liSideMenu fademenu closed']//i[@class='icon-arrow']");

	public WebElement clickTestDemo() {

		return driver.findElement(sidemenu_TestDemo);

	}

	//MyWorkspace
	By frame_MyWorkSpace = By.cssSelector("a[href='#dvFolderFilesList']");

	public WebElement clickMyWorkSpace() {

		return driver.findElement(frame_MyWorkSpace);

	}

	//Testdemo and refresh button
	By button_TestDemo = By.cssSelector("a[class='ng-scope']");
	By button_Refresh = By.xpath(" (//i[@class='ti-reload'])[2]");

	public WebElement clickTestDemoFolder() {

		return driver.findElement(button_TestDemo);

	}

	public WebElement clickRefresh() {

		return driver.findElement(button_Refresh);

	}

}
