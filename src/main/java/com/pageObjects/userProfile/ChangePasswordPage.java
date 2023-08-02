package com.pageObjects.userProfile;

import java.util.List;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ChangePasswordPage
{
	    private List<By> elementLocators;
	    private List<By> inputLocators;
	    public WebDriver driver;
	    public static Logger log = LogManager.getLogger(ChangePasswordPage.class.getName());
	    public ChangePasswordPage(WebDriver driver) 
	    {
	        this.driver = driver;
	        elementLocators = new ArrayList<>();
	        inputLocators = new ArrayList<>();
	    }

	    By menu_UserProfile = By.cssSelector("li.dropdown.current-user.pull-right");
	    By dropdown_UserProfile = By.xpath("(//a[@class='dropdown-toggle'])[1]");
	    By option_UserSettings = By.cssSelector("li[class='dropdown current-user pull-right open'] li:nth-child(1) a:nth-child(1)");
	    By frame_ChangePassowrd = By.xpath("//a[@href='#panel_change_password']");
	    By input_OldPassword = By.cssSelector("input[name='oldpassword']");
	    By input_NewPassowrd = By.cssSelector("input[placeholder='New password']");
	    By input_ConfirmPassword = By.cssSelector("input[placeholder='Confirm new password']");
	    By button_UpdatePassword = By.cssSelector("button[ng-click='resetPassword()']");
	    By popup_SuccesfulChangePassword = By.cssSelector(".confirm");
	    By popup_ErrorMessage = By.xpath("//h2[contains(text(),'Error!')]");
	    By popup_SuccessMessage = By.xpath("//h2[contains(text(),'Success!')]");
	    By popup_oneSpecialChar = By.xpath("//p[@style='display: block;']");
	    

	    public WebElement getProfileDropdown() {

	        return driver.findElement(dropdown_UserProfile);

	    }

	    public WebElement getUserSetting() {

	        return driver.findElement(option_UserSettings);

	    }

	    public WebElement getChangePassowrd() {

	        return driver.findElement(frame_ChangePassowrd);

	    }

	    public WebElement getOldPassword() {

	        return driver.findElement(input_OldPassword);

	    }

	    public WebElement getNewPassowrd() {

	        return driver.findElement(input_NewPassowrd);

	    }

	    public WebElement getConfirmPassword() {

	        return driver.findElement(input_ConfirmPassword);

	    }

	    public WebElement clickResetPassword() {

	        return driver.findElement(button_UpdatePassword);

	    }

	    public WebElement clickOk() {

	        return driver.findElement(popup_SuccesfulChangePassword);

	    }

	    public WebElement checkErrorMessage() {

	        return driver.findElement(popup_ErrorMessage);

	    }
	    public WebElement checkSuccessMessage() {

	        return driver.findElement(popup_SuccessMessage);

	    }
	    public WebElement checkOneSpecialChar() {

	        return driver.findElement(popup_oneSpecialChar);

	    }
	    // To verify all the elements are present on Change password window or not
	    public void addElementLocator(By locator) {
	        elementLocators.add(By.xpath("//a[@href='#panel_change_password']"));
	        elementLocators.add(By.cssSelector("input[name='oldpassword']"));
	        elementLocators.add(By.cssSelector("input[placeholder='New password']"));
	        elementLocators.add(By.cssSelector("input[placeholder='Confirm new password']"));
	        elementLocators.add(By.cssSelector("button[ng-click='resetPassword()']"));
	        elementLocators.add(By.cssSelector(".confirm"));

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

	    // To verify all text fields are clickable or not

	    public void addElementChangePassword(By locator) 
	    {
	        inputLocators.add(By.cssSelector("input[name='oldpassword']"));
	        inputLocators.add(By.cssSelector("input[placeholder='New password']"));
	        inputLocators.add(By.cssSelector("input[placeholder='Confirm new password']"));
	    }

	    public boolean areAllElementsClicked()
	    {
	        boolean allElementsEnabled = true;
	        for (By locator : inputLocators) 
	        {
	            WebElement element = driver.findElement(locator);
	            if (!element.isEnabled()) 
	            {
	                allElementsEnabled = false;
	                break;
	            }
	        }
	        return allElementsEnabled;
	    }
	    
	    public void enterOldPassword(String Oldpass) 
	    {

	        getOldPassword().sendKeys(Oldpass);
		
	    }

	    public void enterNewPassowrd(String newpass) 
	    {

	    	 getNewPassowrd().sendKeys("Sky#123");
			
	    }

	    public void enterConfirmPassword(String confirmpass) 
	    {

	    	 getConfirmPassword().sendKeys(confirmpass);

	    }
	  //TC 5.5 - To verify ,If we mentioned wrong or invalid credentials then error message is displaying or not
	    public void checkInvalidPassword() throws InterruptedException
	    { 
	    String[] credentialsList = {"Writer@123", "Writer@12", "Writer@1234"};
        int i =0 ;
       // changepw.clickOk().click();
        while (i < credentialsList.length) {
            String value = credentialsList[i];
            getOldPassword().clear();
            getOldPassword().sendKeys(value);
            getNewPassowrd().clear();
           getNewPassowrd().sendKeys("Shamal@1234");
            getConfirmPassword().clear();
            getConfirmPassword().sendKeys("Shamal@1234");
            clickResetPassword().click();
                  
            if( checkErrorMessage().isDisplayed()) {
                log.info("Error Message is displayed for invalid credentials");
            } else {
                log.info("Success Message is displayed for invalid credentials");
            }
             
            
            clickOk().click();

            // Clear the input fields before the next iteration
            getOldPassword().clear();
            getNewPassowrd().clear();
            getConfirmPassword().clear();
            
            Thread.sleep(3000); 
            i++;
        } 
       
	    }
		//TC5.6-To verify ,If we mentioned wrong or invalid password (without alpha numeric combination) then error message is displaying or not
	    public void checkWithoutAlphaNumericPass() throws InterruptedException
	    {
	    String[] credentialsList = {"writer@123", "Writer123", "WRITER@123"};
        int i =0 ;
      while (i < credentialsList.length) {
            String value = credentialsList[i];

           getOldPassword().clear();
            getOldPassword().sendKeys(value);
            getNewPassowrd().clear();
           getNewPassowrd().sendKeys("Shamal@1234");
           getConfirmPassword().clear();
           getConfirmPassword().sendKeys("Shamal@1234");
            Thread.sleep(3000);
           clickResetPassword().click();
            
           
            
            if (checkErrorMessage().isDisplayed()) {
                log.info("Error Message is for without alpha numeric combination" );
            } else {
                log.info("Success Message is displayed for invalid credentials");
            }
             
    
            clickOk().click();

            // Clear the input fields before the next iteration
           getOldPassword().clear();
            getNewPassowrd().clear();
            getConfirmPassword().clear();
            
            Thread.sleep(3000); 
            i++;
           
        }
    }
}