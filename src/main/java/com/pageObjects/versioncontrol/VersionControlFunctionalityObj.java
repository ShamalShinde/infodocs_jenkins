package com.pageObjects.versioncontrol;

import java.util.ArrayList;
import org.openqa.selenium.interactions.Actions;
import com.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VersionControlFunctionalityObj extends Base {

	private WebDriver driver;
	public Actions actions;

	public VersionControlFunctionalityObj(WebDriver driver) {
		this.driver = driver;
		new ArrayList<>();
		actions = new Actions(driver);

	}

	By sidemenu_TestDemo = By.xpath("//li[@class='liSideMenu fademenu closed']//i[@class='icon-arrow']");
	By sidemenu_InfodocsDepartment = By.cssSelector("li[id='MLi_infodocs'] span[class='title']");
	By button_Folder1 = By.xpath("//tr[@id='div245037']//td[@onclick='activateClass(this)']");
	By button_Folder2 = By.xpath("//div[@class='col-xs-10 max-over']//span[@class='ng-binding'][contains(text(),'selenium')]");
	By button_FileIcon = By.xpath("//a[@id='aFile_7']//div[@class='row']//div[@class='col-xs-10 max-over']//span[@class='ng-binding'][contains(text(),'selenium_documentation_index.pdf')]");
	By frame_FileWindow = By.xpath("/html[1]/body[1]/ul[1]");
	By list_WindowList = By.xpath("/html[1]/body[1]/ul[1]/li");
	By list_CheckOut = By.xpath("//a[contains(text(),'Check Out')]");
	By frame_checkoutwarning = By.xpath("/html[1]/body[1]/div[5]");
	By button_Cancel = By.xpath("//button[@class='cancel']");
	By button_Yes = By.xpath("//button[@class='confirm']");
	By button_LockFile = By.xpath("//div[@class='col-xs-10 max-over']//span[@class='ng-binding'][contains(text(),'Template.txt')]");
	By frame_SuccesWindow = By.xpath("/html[1]/body[1]/div[5]");

	public WebElement getTestDemo() {
		return getElement(sidemenu_TestDemo);
	}

	public String clickTestDemo() {
		getTestDemo().click();
		return getPageTitle();
	}

	public WebElement getInfodocsDepartment() {

		return getElement(sidemenu_InfodocsDepartment);
	}

	public String clickInfodocsDepartment() {
		getInfodocsDepartment().click();
		return getPageTitle();
	}

	public WebElement getFolder1() {

		return getElement(button_Folder1);
	}

	public String clickFolder1() {
		getFolder1().click();
		return getPageTitle();
	}

	public WebElement getFolder2() {

		return getElement(button_Folder2);
	}

	public String clickFolder2() {
		getFolder2().click();
		return getPageTitle();
	}

	public WebElement getFileIcon() {

		return getElement(button_FileIcon);
	}

	public String clickFileIcon() {
		getFileIcon().click();
		return getPageTitle();
	}

	// TC1.1 - To verify if we right click on file then it displays window or not
	public WebElement getFileWindow() {

		return getElement(frame_FileWindow);
	}

	public String clickFileWindow() {
		getFileWindow().click();
		return getPageTitle();
	}
	
	public WebElement getrightClickOnButton() {

		return getElement(button_FileIcon);
	}

	public String ClickrightClickOnButton() {
		Actions a= new Actions(getDriver());
		actions.contextClick(getrightClickOnButton()).perform();
		return getPageTitle();
	}
	

	// TC1.2 To verify window contains list or not

	public WebElement getWindowList() {

		return getElement(list_WindowList);
	}

	public String clickWindowList() {
		getWindowList().click();
		return getPageTitle();
	}

	// TC1.3 To verify on window check out option present or not
	public WebElement getCheckOut() {

		return getElement(list_CheckOut);
	}

	public String clickCheckOut() {
		getCheckOut().click();
		return getPageTitle();
	}

	// TC1.5 To verify after clicking on it,check out window opening or not

	public WebElement getCheckOutWarning() {

		return getElement(frame_checkoutwarning);
	}

	public String clickCheckOutWarning() {
		getCheckOutWarning().click();
		return getPageTitle();
	}

	// TC1.6 To verify on check out window cancel and yes button present or not
	public WebElement getCancelButton() {

		return getElement(button_Cancel);
	}

	public String clickCancelButton() {
		getCancelButton().click();
		return getPageTitle();
	}

	public WebElement getYesButton() {

		return getElement(button_Yes);
	}

	public String clickYesButton() {
		getYesButton().click();
		return getPageTitle();
	}

	// TC1.7 To verify after clicking on yes button,check out success window opening
	// or not
	public WebElement getSuccesWindow() {

		return getElement(frame_SuccesWindow);
	}

	public String clickSuccesWindow() {
		getSuccesWindow().click();
		return getPageTitle();
	}

	// TC1.8 To verify ,if user check out particular file then after clicking on
	// that file it should be not open again ,because user lock that file

	public WebElement getLockFile() {

		return getElement(button_LockFile);
	}

	public String clickLockFile() {
		getLockFile().click();
		return getPageTitle();
	}

}
