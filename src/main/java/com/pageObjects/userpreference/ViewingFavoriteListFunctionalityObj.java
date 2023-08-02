package com.pageObjects.userpreference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewingFavoriteListFunctionalityObj {

	public WebDriver driver;

	public ViewingFavoriteListFunctionalityObj(WebDriver driver) {
		this.driver = driver;
	}

	By sidemenu_TestDemo = By.xpath("//li[@class='liSideMenu fademenu closed']//i[@class='icon-arrow']");

	public WebElement clickTestDemo() {

		return driver.findElement(sidemenu_TestDemo);
	}

	// TC-1 To verify viewing favorite list in to my favorites

	By frame_MyFavorite = By.cssSelector("a[href='#dvFavourite']");

	public WebElement clickMyFavorite() {

		return driver.findElement(frame_MyFavorite);
	}

	By list_MyFavorite = By.xpath("//tr[@current-page='FavouriteitemPager.currentPage']");

	public WebElement clickListMyFavorite() {

		return driver.findElement(list_MyFavorite);
	}

}
