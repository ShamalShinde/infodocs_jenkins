package com.pageObjects.userpreference;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyRecentFilesFunctionalityObj {
	private List<By> elementLocators;
	public WebDriver driver;

	public MyRecentFilesFunctionalityObj(WebDriver driver) {
		this.driver = driver;
		elementLocators = new ArrayList<>();
	}

	By sidemenu_TestDemo = By.xpath("//li[@class='liSideMenu fademenu closed']//i[@class='icon-arrow']");

	public WebElement clickTestDemo() {

		return driver.findElement(sidemenu_TestDemo);
	}

	// TC-11.1 To verify my recent files window present or not

	By frame_MyRecentFiles = By.cssSelector("a[href='#dvRecentFiles']");

	public WebElement clickMyRecentFiles() {

		return driver.findElement(frame_MyRecentFiles);

	}

	// TC-11.2 To verify top 10 documents are listed in my recent files or not

//	public void addElementLocator(By locator) {
//		elementLocators.add(By.xpath(
//				"//tr[@current-page='RecentFilesitemPager.currentPage']//span[@class='ng-binding'][normalize-space()='1']"));
//		elementLocators.add(By.xpath(
//				"//tr[@current-page='RecentFilesitemPager.currentPage']//span[@class='ng-binding'][normalize-space()='2']"));
//		elementLocators.add(By.xpath(
//				"//tr[@current-page='RecentFilesitemPager.currentPage']//span[@class='ng-binding'][normalize-space()='3']"));
//		elementLocators.add(By.xpath(
//				"//tr[@current-page='RecentFilesitemPager.currentPage']//span[@class='ng-binding'][normalize-space()='4']"));
//		elementLocators.add(By.xpath(
//				"//tr[@current-page='RecentFilesitemPager.currentPage']//span[@class='ng-binding'][normalize-space()='5']"));
//		elementLocators.add(By.xpath(
//				"//tr[@current-page='RecentFilesitemPager.currentPage']//span[@class='ng-binding'][normalize-space()='6']"));
//		elementLocators.add(By.xpath(
//				"//tr[@current-page='RecentFilesitemPager.currentPage']//span[@class='ng-binding'][normalize-space()='7']"));
//		elementLocators.add(By.xpath(
//				"//tr[@current-page='RecentFilesitemPager.currentPage']//span[@class='ng-binding'][normalize-space()='8']"));
//		elementLocators.add(By.xpath(
//				"//tr[@current-page='RecentFilesitemPager.currentPage']//span[@class='ng-binding'][normalize-space()='9']"));
//		elementLocators.add(By.xpath(
//				"//tr[@current-page='RecentFilesitemPager.currentPage']//span[@class='ng-binding'][normalize-space()='10']"));
//
//	}
//
//public boolean areAllElementsEnabled() {
//    for (By locator : elementLocators) {
//        WebElement element = driver.findElement(locator);
//        if (!element.isDisplayed()) {
//            return false; // If any of the elements is not displayed, return false
//        }
//    }
//    return true; // If there are at least 10 elements, return true
//
//}
//    	
//     
         //To verify listed files under my recent files are opening or not
}    

       


      
  





