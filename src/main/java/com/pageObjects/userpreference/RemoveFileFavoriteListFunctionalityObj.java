package com.pageObjects.userpreference;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RemoveFileFavoriteListFunctionalityObj {

	public WebDriver driver;
	private List<By> elementLocators;
	public RemoveFileFavoriteListFunctionalityObj(WebDriver driver) {
		this.driver = driver;
		elementLocators = new ArrayList<>();
	}

	By sidemenu_TestDemo = By.xpath("//li[@class='liSideMenu fademenu closed']//i[@class='icon-arrow']");

	public WebElement clickTestDemo() {

		return driver.findElement(sidemenu_TestDemo);
	}
	
	By frame_MyFavorite = By.xpath("//span[contains(text(),'My Favourites')]");

	public WebElement clickMyFavorite() {

		return driver.findElement(frame_MyFavorite);
	}


	// TC-10.1 To verify in my favourite -  files and delete icon is present or not

	
	public void addElementLocator(By locator) {
		elementLocators.add(By.xpath("(//span[@ng-bind='item.Filename'][normalize-space()='Template.txt'])[1]"));
		elementLocators.add(By.xpath("//tbody/tr[2]/td[5]/a[1]"));
	}

	public boolean areAllElementsDisplay() {
		boolean allElementsDisplay = true;
		for (By locator : elementLocators) {
			WebElement element = driver.findElement(locator);
			if (!element.isDisplayed()) {
				allElementsDisplay = false;
				break;
			}
		}
		return allElementsDisplay;
	}
	
	//TC-10.2 To verify delete icon is clickable or not
	
	By button_RemoveFile = By.xpath("(//i[@class='ti-trash'])[2]");

	public WebElement clickRemoveFileIcon() {

		return driver.findElement(button_RemoveFile);
	}
	
	//TC-10.3 To verify after clicking on delete icon it displays user confirmation window weather to delete or not
	By frame_remove = By.xpath("/html[1]/body[1]/div[5]");

	public WebElement clickRemoveWindow() {

		return driver.findElement(frame_remove);
	}
	
	//TC-10.4  To verify on window cancel  and delete buttons are clickable and functioning or not
	
	By button_Delete = By.xpath("//button[@class='confirm']");

	public WebElement clickDeleteButton() {

		return driver.findElement(button_Delete);
	}
	
	By button_Cancel = By.cssSelector("button[class='cancel']");

	public WebElement clickCancelButton() {

		return driver.findElement(button_Cancel);
	}
	
	//TC-10.6 To verify after clicking on delete buttons  it displays success message window or not.
	
		By frame_Success = By.xpath("/html[1]/body[1]/div[5]");

		public WebElement clickSuccessWindow() {

			return driver.findElement(frame_Success);
		}
	
		//TC-10.7 To verify after clicking on cancel buttons  it displays cancelled message window or not.
		By frame_Cancel = By.xpath("/html[1]/body[1]/div[5]");

		public WebElement clickCancelWindow() {

			return driver.findElement(frame_Cancel);
		}
}
