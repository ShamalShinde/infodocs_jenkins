package com.pageObjects.DMSFeatureDocumentview;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

public class DmsViewDoc {
	WebDriver driver;
	public String originalWindowHandle;

	public DmsViewDoc(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='T1']")
	WebElement selectDepartmentInfoDocs;

	@FindBy(xpath = "//tr[@id='div224881']//img[1]")
	WebElement clickOnFolder1;

	@FindBy(xpath = "//div[@class='col-xs-10 max-over']//span[@class='ng-binding'][normalize-space()='WRITER.png']")
	public WebElement file;

	@FindBy(xpath = "//a[normalize-space()='View Document']")
	WebElement viewDocument;

	@FindBy(css = "div[class='col-xs-6'] h4")
	WebElement verifyNewWindow;

	public WebElement SelectInfoDocs() {
		return selectDepartmentInfoDocs;
	}

	public WebElement ClickOnFolder1() {
		return clickOnFolder1;
	}

	public void rightClickElement() {
		Actions actions = new Actions(driver);
		actions.contextClick(file).perform();
	}

	public void doubleClickElement() {
		Actions actions = new Actions(driver);
		actions.doubleClick(file).perform();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(originalWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

	}

	public WebElement ViewDocument() {
		return viewDocument;
	}

	public WebElement VerifyNewWindow() {
		return verifyNewWindow;
	}

}
