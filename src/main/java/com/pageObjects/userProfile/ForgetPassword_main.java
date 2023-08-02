package com.pageObjects.userProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPassword_main {

public WebDriver driver;
	
	public ForgetPassword_main(WebDriver driver) {
		this.driver = driver;
	}
	
	By input_UserName = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/fieldset/div[1]/span/input");
	By button_ForgetPassword = By.cssSelector("a.forgot");
	By input_Password = By.cssSelector(".password");
	By dialog_SelfResetPassword = By.xpath("//div[@class='modal-content']");
	By input_EmailId = By.xpath("//input[@placeholder='Please Enter Registered Email Adddress']");
	By captcha_SecurityCheck1 = By.cssSelector("#code");
	By button_Refresh = By.cssSelector(".ti-reload");
    By input_Captcha = By.id("IpVal");
	By button_ResetPassword =By.xpath("//button[normalize-space()='Reset Password']");
	By popup_Ok =By.cssSelector(".confirm");
	By button_Close =By.cssSelector("div[class='login ng-scope'] button:nth-child(2)");

	public WebElement getUsername() 
	{
	
		return driver.findElement(input_UserName);
	}
	public WebElement getPassword() {
		return driver.findElement(input_Password);
	}
	public WebElement getForgotPassword() {
		
		return driver.findElement(button_ForgetPassword);
	}
   public WebElement getResetPasswordDialog() {
		
		return driver.findElement(dialog_SelfResetPassword);
	}
	public WebElement getEmail() {
		
		return driver.findElement(input_EmailId);
	}

	
	
	public WebElement getCaptcha() {
		return driver.findElement(captcha_SecurityCheck1);
	}

	public WebElement clickRefreshButton() {
		return driver.findElement(button_Refresh);
	}

	public WebElement getEnterCaptcha() {
		return driver.findElement(input_Captcha);
	}

	public WebElement clickResetPassword() {
		return driver.findElement(button_ResetPassword);
	}

	public WebElement clickOk() {
		return driver.findElement(popup_Ok);
	}
	public WebElement clickClose() {
		return driver.findElement(button_Close);
	}
	


}


