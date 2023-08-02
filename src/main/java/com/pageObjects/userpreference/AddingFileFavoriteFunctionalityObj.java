package com.pageObjects.userpreference;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddingFileFavoriteFunctionalityObj {

	public WebDriver driver;
	private List<By> elementLocators;

	public AddingFileFavoriteFunctionalityObj(WebDriver driver) {
		this.driver = driver;
		elementLocators = new ArrayList<>();
	}

	By sidemenu_TestDemo = By.xpath("//li[@class='liSideMenu fademenu closed']//i[@class='icon-arrow']");

	public WebElement clickTestDemo() {

		return driver.findElement(sidemenu_TestDemo);
	}

	// TC-8.1 To verify all elements are present or not including check box and star
	// icon

	By sidemenu_InfodocsDepartment = By.cssSelector("li[id='MLi_infodocs'] span[class='title']");

	public WebElement clickInfodocsDepartment() {

		return driver.findElement(sidemenu_InfodocsDepartment);
	}

	By button_Folder1 = By.xpath("//a[@id='aFile_1']//div[@class='row']//div[@class='col-xs-10 max-over']");

	public WebElement clickFolder1() {

		return driver.findElement(button_Folder1);
	}

	By button_Folder2 = By
			.xpath("//div[@class='col-xs-10 max-over']//span[@class='ng-binding'][contains(text(),'selenium')]");

	public WebElement clickFolder2() {

		return driver.findElement(button_Folder2);
	}

	public void addElementLocator(By locator) {
		elementLocators.add(By.xpath("//label[@for='chkFolderAndFiles_0']"));// checkbox
		elementLocators.add(By.xpath("//a[@data-original-title='Add To Favorite']"));// staricon
		elementLocators.add(By.cssSelector("//a[@data-original-title='View Indexing Details']"));

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

	// TC-8.2 To verify check box for selecting the file is clickable or not

	By label_Checkbox = By.xpath("//label[@for='chkFolderAndFiles_0']");

	public WebElement clickCheckbox() {

		return driver.findElement(label_Checkbox);
	}

	// TC-8.3  To verify star icon is clickable or not

	By button_StarIcon = By.xpath("//a[@data-original-title='Add To Favorite']");

	public WebElement clickStarIcon() {

		return driver.findElement(button_StarIcon);
	}

	// TC-8.4   To verify after clicking on star icon success message window (Added
	// to favourite ) display or not
	By button_Ok = By.cssSelector(".confirm");

	public WebElement clickOk() {

		return driver.findElement(button_Ok);
	}

	
}
