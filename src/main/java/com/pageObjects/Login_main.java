package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;

public class Login_main {

	public WebDriver driver;

	public Login_main(WebDriver driver) {
		this.driver = driver;
	}

	By input_UserName = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/fieldset/div[1]/span/input");
	By input_Password = By.cssSelector(".password");
	By button_Login = By.cssSelector("#btnLogin");
	By popup_Ok = By.xpath("//button[@class='confirm']");
	By button_Login2 = By.id("btnLogin");
	By popup2_Ok = By.xpath("//button[@class='confirm']");

	public WebElement getUsername() {

		return driver.findElement(input_UserName);
	}

	public WebElement getPassword() {
		return driver.findElement(input_Password);
	}

	public WebElement clickLogin() {
		return driver.findElement(button_Login);
	}

	public WebElement clickPopup() {
		return driver.findElement(popup_Ok);
	}

	public WebElement clickLogin2() {
		return driver.findElement(button_Login2);
	}

	public WebElement clickPopup2() {
		return driver.findElement(popup2_Ok);
	}

	

}
