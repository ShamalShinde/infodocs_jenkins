package com.pageObjects.userProfile;


import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAccountFunctionallityObj {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(EditAccountFunctionallityObj.class.getName());

	public EditAccountFunctionallityObj(WebDriver driver) {
		this.driver = driver;

	}

	// TC4.2-To verify all elements are properly placed after minimizing the page or
	// not
	public Point getFirstNameBefore() {

		WebElement input_FirstName = driver.findElement(By.id("firstname"));
		return input_FirstName.getLocation();

	}

	public Point getFirstNameAfter() {

		driver.manage().window().minimize();
		WebElement input_FirstName = driver.findElement(By.id("firstname"));
		return input_FirstName.getLocation();

	}

	public Point getLastNameBefore() {

		WebElement input_LastName = driver.findElement(By.id("lastname"));
		return input_LastName.getLocation();

	}

	public Point getLastNameAfter() {

		driver.manage().window().minimize();
		WebElement input_LastName = driver.findElement(By.id("lastname"));
		return input_LastName.getLocation();

	}

	public Point getEmailBefore() {

		WebElement input_Email = driver.findElement(By.id("email"));
		return input_Email.getLocation();

	}

	public Point getEmailAfter() {

		WebElement input_Email = driver.findElement(By.id("email"));
		return input_Email.getLocation();

	}

	public Point getPhoneBefore() {

		WebElement input_PhoneNumber = driver.findElement(By.id("phone"));
		return input_PhoneNumber.getLocation();

	}

	public Point getPhoneAfter() {

		WebElement input_PhoneNumber = driver.findElement(By.id("phone"));
		return input_PhoneNumber.getLocation();

	}

	public void addElementLocator() {
		Point input_FirstNameBefore = getFirstNameBefore();
		Point input_LastNameBefore = getLastNameBefore();
		Point input_EmailBefore = getEmailBefore();
		Point input_PhoneNoBefore = getPhoneBefore();

		// Get the element positions after minimizing the window
		Point input_FirstNameAfter = getFirstNameAfter();
		Point input_LastNameAfter = getLastNameAfter();
		Point input_EmailAfter = getEmailBefore();
		Point input_PhoneNoAfter = getPhoneAfter();

		if (input_FirstNameBefore.equals(input_FirstNameAfter)) {
			log.info("FirstName is at the same position after minimizing the window.");
		} else {
			log.info("FirstName has moved from its original position after minimizing the window.");
		}
		if (input_LastNameBefore.equals(input_LastNameAfter)) {
			log.info("LastName is at the same position after minimizing the window.");
		} else {
			log.info("LastName has moved from its original position after minimizing the window.");
		}
		if (input_EmailBefore.equals(input_EmailAfter)) {
			log.info("Email is at the same position after minimizing the window.");
		} else {
			log.info("Email has moved from its original position after minimizing the window.");
		}
		if (input_PhoneNoBefore.equals(input_PhoneNoAfter)) {
			log.info("PhoneNumber is at the same position after minimizing the window.");
		} else {
			log.info("PhoneNumber has moved from its original position after minimizing the window.");
		}

	}

	// TC4.3 -To verify Edit account window is clickable or not
	By frame_EditAccount = By.cssSelector("a[href='#panel_edit_account']");

	public WebElement clickEditAccount() {

		return driver.findElement(frame_EditAccount);
	}

	// TC4.5-to verify all the elements of edit account windows are present or not

	By input_FirstName = By.id("firstname");
	By input_LastName = By.id("lastname");
	By input_Email = By.id("email");
	By input_PhoneNumber = By.id("phone");
	By button_ChangeProfilePicture = By.xpath("//span[@class='ti-upload']");
	By button_RemoveProfilePicture = By.cssSelector(".btn.fileinput-exists.btn-red");
	By button_UpdateInfo = By.cssSelector("button.btn.btn-primary.pull-right[ng-click$='updateUserProfile()']");

	public WebElement checkFirstName() {

		return driver.findElement(input_FirstName);

	}

	public WebElement checkLastName() {

		return driver.findElement(input_LastName);

	}

	public WebElement checkEmail() {

		return driver.findElement(input_Email);

	}

	public WebElement checkPhone() {

		return driver.findElement(input_PhoneNumber);

	}

	public WebElement checkChangeprofilepicture() {

		return driver.findElement(button_ChangeProfilePicture);

	}

	public WebElement checkRemovePicture() {

		return driver.findElement(button_RemoveProfilePicture);

	}

	public WebElement checkUpdateInformation() {

		return driver.findElement(button_UpdateInfo);

	}

	// TC4.5-To verify on Edit account window first name and last name Text fields
	// are clickable or no
	public void getFirstName(String firstName) {

		checkFirstName().clear();
		checkFirstName().sendKeys(firstName);
	}

	public void getLastName(String lastName) {

		checkLastName().clear();
		checkLastName().sendKeys(lastName);

	}

	// TC4.8 -To verify on Edit account window Email and Phone Number Text fields
	// are clickable or no
	public void getEmail(String Email) {

		checkEmail().clear();
		checkEmail().sendKeys(Email);
	}

	public void getPhoneNumber(String PhoneNo) {

		checkPhone().clear();
		checkPhone().sendKeys(PhoneNo);
	}

	// TC4.16-To verify after minimizing the screen ,all text box field s are
	// cllickable or not
	public boolean clickFirstName(String firstName) {

		checkFirstName().click();
		checkFirstName().clear();
		checkFirstName().sendKeys(firstName);
		return true;

	}

	public boolean clickLastName(String lastName) {

		checkLastName().click();
		checkLastName().clear();
		checkLastName().sendKeys(lastName);
		return true;
	}

	public boolean clickEmail(String email) {

		checkEmail().click();
		checkEmail().clear();
		checkEmail().sendKeys(email);
		return true;
	}

	public boolean clickPhoneNumber(String phoneNo) {

		checkPhone().click();
		checkPhone().clear();
		checkPhone().sendKeys(phoneNo);
		return true;
	}

	//TC4.20-To verify for  change  profile picture icon ,photo upload size limit  given or not 
	
	By button_ChangeProfilePicture1 = By.cssSelector("#ProfileImageFile"); 
	
	public WebElement clickProfileImg()
	{
	return driver.findElement(button_ChangeProfilePicture1);
	}
	public boolean checkProfileImg() {
		

		String maxSize = clickProfileImg().getAttribute("max");
		if(maxSize == null)
		{
		return true;
		}
		else
		return false; 
	}
    
			
	//TC 4.23 -To verify on Edit account window delete profile picture icon is clickable or not 
	public WebElement clickRemovePicture() {

		return driver.findElement(button_RemoveProfilePicture);

	}
	By img_ProgileImage = By.xpath("//img[@src=\"/InfoDocsV1/Scripts/assets/images/default-user.png\"]");
	
	public boolean checkProgileImageBefore() {

		driver.findElement(img_ProgileImage);
		return true;

	}
	
	By popup_OkUserSettings = By.cssSelector("button.confirm");

	public WebElement clickOKUserSettings()
	{
		
		return driver.findElement(popup_OkUserSettings);
	}


}
