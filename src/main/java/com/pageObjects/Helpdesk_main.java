package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Helpdesk_main 

{
	
public WebDriver driver;
	
	public Helpdesk_main(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By dropdown_UserProfile = By.xpath("(//a[@class='dropdown-toggle'])[1]");
	By options_HelpDesk = By.xpath("//a[normalize-space()='Help Desk']");
	By input_Subject = By.id("txtSubject");
	By input_AttachFile = By.id("FUSupportAttach");
	By input_Body = By.xpath("//div[@class='note-editable panel-body']");
	By button_Send = By.cssSelector("button[type='button'] i[class='ti-save']");
	By button_Exit = By.cssSelector("button[class='btn btn-default']");
	public Actions UpdateUser() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("li.dropdown.current-user.pull-right"))).click().build().perform();
		return action;
	}

	public WebElement clickProfileDropdown() {

		return driver.findElement(dropdown_UserProfile);

	}
	

	public WebElement clickHelpDesk() {

		return driver.findElement(options_HelpDesk);

	}

	public WebElement getSubject() {

		return driver.findElement(input_Subject);

	}

	public WebElement getAttachFile() {

		return driver.findElement(input_AttachFile);

	}

	public WebElement getBody() {

		return driver.findElement(input_Body);

	}

	public WebElement clickSend() {

		return driver.findElement(button_Send);

	}

	public WebElement clickExit() {

		return driver.findElement(button_Exit);

	}

}
