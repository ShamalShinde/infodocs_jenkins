package com.pageObjects.documentsharingdms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocumentSharingDMSObj {
	private List<By> elementLocators;
	public WebDriver driver;
	public Actions actions;

	public DocumentSharingDMSObj(WebDriver driver) {
		this.driver = driver;
		new ArrayList<>();
		actions = new Actions(driver);
		elementLocators = new ArrayList<>();
		
	}

	By sidemenu_TestDemo = By.xpath("//li[@class='liSideMenu fademenu closed']//i[@class='icon-arrow']");

	public WebElement clickTestDemo() {

		return driver.findElement(sidemenu_TestDemo);
	}

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

	By button_FileIcon = By.xpath("//span[@class='ng-binding'][contains(text(),'selenium_documentation_index.pdf')]");

	public WebElement clickFileIcon() {

		return driver.findElement(button_FileIcon);
	}

	public void rightClickOnButton() {
		WebElement button = driver.findElement(button_FileIcon);
		actions.contextClick(button).perform();
	}

	// TC1.1 - To verify if we right click on file then it displays window or not

	By frame_FileWindow = By.xpath("/html[1]/body[1]/ul[1]");

	public WebElement clickFileWindow() {

		return driver.findElement(frame_FileWindow);
	}

	// TC1.2 To verify window contains list or not

	By list_WindowList = By.xpath("/html[1]/body[1]/ul[1]/li");

	public WebElement clickWindowList() {

		return driver.findElement(list_WindowList);
	}

	// TC1.3 To verify on window check out option present or not

	By option_ShareDocument = By.xpath("//a[contains(text(),'Share Document With')]");

	public WebElement clickShareDocument() {

		return driver.findElement(option_ShareDocument);
	}

	////TC1.5 To verify after clicking on share document with option ,share with window opening or not

	By frame_ShareDocumentWindow = By.xpath("(//div[@class='modal-content md-border'])[14]");

	public WebElement clickShareDocumentWindow() {

		return driver.findElement(frame_ShareDocumentWindow);
	}

	//TC1.6 To verify on window user drop down box present or not
	

	By dropdown_User= By.xpath("(//button[@type='button'])[200]");

	public WebElement clickUserDropDown() {

		return driver.findElement(dropdown_User);
	}
	
	
	//TC1.8 To verify after clicking on user drop down box check all and unchecked all check boxes present or not
	

	public void addElementLocator(By locator) {
		elementLocators.add(By.cssSelector("#selectAll"));
		elementLocators.add(By.cssSelector("#deselectAll"));
		elementLocators.add(By.xpath("(//div[@class='checkbox'])[2]"));
		
	}

	public boolean areAllElementsDisplayed() {
		boolean allElementsDisplayed = true;
		for (By locator : elementLocators) {
			WebElement element = driver.findElement(locator);
			if (!element.isDisplayed()) {
				allElementsDisplayed = false;
				break;
			}
		}
		return allElementsDisplayed;
	}
	
			//TC1.9 To verify after clicking on user drop down box check all and unchecked all check boxes clickable or not
	public void addElementLocatorforclick(By locator) {
		elementLocators.add(By.cssSelector("#selectAll"));
		elementLocators.add(By.cssSelector("#deselectAll"));
		elementLocators.add(By.xpath("(//div[@class='checkbox'])[2]"));
		
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
			//TC1.10 To verify on window search text box present or not
	
			By input_SearchBox= By.cssSelector("#txtSearchOptions");
		
			public WebElement clickSearchBox() {
		
				return driver.findElement(input_SearchBox);
			}
	
	
	
	
	
			//TC1.11 To verify search text box accepts input or not
			//TC1.12 To verify if we mention user name in search text box,then it displays the filtered result in to table or not
			

			By input_Table= By.xpath("//a[@class='option']//div[@class='checkbox']");
		
			public WebElement clickTable() {
		
				return driver.findElement(input_Table);
			}
			
			
			
			
			
			//TC1.13  To verify Save button present or not
			
			By button_Save = By.cssSelector("button[ng-click='SaveShareDocUser()']");
			
			public WebElement clickSave() {
		
				return driver.findElement(button_Save);
			}
	
			
			
			//TC1.14 To verify Save button clickable or not
			//TC1.15 To verify after clicking on save button success message window displays or not
			By frame_SuccessWindow= By.xpath("//div[@class='sweet-alert showSweetAlert visible']");
			
			public WebElement clickSuccessWindow() {
		
				return driver.findElement(frame_SuccessWindow);
			}
			
			//TC1.16 To verify on share window user list with check box present or not
			
			By checkbox_user= By.xpath("(//input[@type='checkbox'])[8]");
			
			public WebElement clickUserCheckbox() {
		
				return driver.findElement(checkbox_user);
			}
			
			
			//TC1.17 To verify on share window user list with check box clickable or not
	
	
	
	
	
	
}
