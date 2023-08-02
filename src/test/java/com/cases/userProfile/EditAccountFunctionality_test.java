package com.cases.userProfile;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.listeners.AllureListener;
import com.base.Base;
import com.pageObjects.userProfile.EditAccountFunctionallityObj;
import com.pageObjects.*;

@Listeners({ AllureListener.class })
public class EditAccountFunctionality_test extends Base {
	public static Logger log = LogManager.getLogger(EditAccountFunctionality_test.class.getName());
	private WebDriverWait wait;

	
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");

	}

	@Test(dataProvider = "getData")
	public void EditAccountFunctionality(String userName, String password) throws IOException, InterruptedException {

		Login_main login = new Login_main(driver);
		login.getUsername().sendKeys(userName);
		login.getPassword().sendKeys(password);
		login.clickLogin().click();
		login.clickPopup().click();
		login.clickLogin2().click();
		login.clickPopup2().click();
		Thread.sleep(3000);
		
		User_Settings_main User = new User_Settings_main(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		User.getProfileDropdown().click();
		Assert.assertTrue(User.getProfileDropdown().isEnabled(), "The profile dropdown element is not enabled ");
		
		User.getUserSetting().click();
	    
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/User/UserSetting")) {
			log.info("navigated on User Settings next page");
		} else {
			log.info("Failed to navigate on User Settings  page");
		}
		EditAccountFunctionallityObj editacc = new EditAccountFunctionallityObj(driver);
		// TC4.2-To verify all elements are properly placed after minimizing the page or not
		editacc.addElementLocator();
		
		driver.manage().window().maximize();

		// TC4.3-To verify Edit account window is clickable or not
		editacc.clickEditAccount().click();
		Assert.assertTrue(editacc.clickEditAccount().isEnabled(), "Edit Account tab is not clickable.");
		
		//TC4.4-to verify all the elements of edit account windows are present or not 
		Assert.assertTrue(editacc.checkFirstName().isDisplayed(), "First Name text Box is not present");
		Assert.assertTrue(editacc.checkLastName().isDisplayed(), "Last Name Name text Box is not present");
		Assert.assertTrue(editacc.checkEmail().isDisplayed(), " Email text Box is not present");
		Assert.assertTrue(editacc.checkPhone().isDisplayed(), "Phone Numbar text Box is not present");
		Assert.assertTrue(editacc.checkChangeprofilepicture().isDisplayed(), "Changeprofilepicture button is not present");
		Assert.assertTrue(editacc.checkRemovePicture().isDisplayed(), "RemovePicture button is not present");
		Assert.assertTrue(editacc.checkUpdateInformation().isDisplayed(), "UpdateInformation button is not present");
		
		//TC4.5-To verify  on Edit account window first name and last name  Text fields are clickable or not 
		editacc.checkFirstName().click();
		editacc.checkLastName().click();
		
		
		//actions.click(editacc.checkFirstName());
		Assert.assertTrue(editacc.checkFirstName().isEnabled(), "First Name text Box is not clickable");
		editacc.checkFirstName().click();
		//actions.click(editacc.checkLastName());
		Assert.assertTrue(editacc.checkLastName().isEnabled(), "Last Name Name text Box is not clickable");
		
		//TC4.6-To verify  on Edit account window  first name and  last name  Text fields are taking inputs or not
		String firstName = "Vishal";
		String lastName = "Shah";
		editacc.getFirstName(firstName);
		String enteredFirstName = editacc.checkFirstName().getAttribute("value");
		if (enteredFirstName.equals(firstName))
		{
			log.info("First Name Field is taking Input.");
		}
		else
		{
			log.info("First Name Field is not taking Input.");
		}
		
		editacc.getLastName(lastName);
		String enteredLastName = editacc.checkLastName().getAttribute("value");
		if (enteredLastName.equals(lastName))
		{
			log.info("Last Name Field is taking  Input.");
		}
		else
		{
			log.info("Last Name Field is taking not Input.");
		}
		String email = "vishal.gharate@writerinformation.com";
		editacc.getEmail(email) ;
		String enteredEmail = editacc.checkEmail().getAttribute("value");
		if (enteredEmail.equals(email))
		{
			log.info("Email Field is taking  Input.");
		}
		else
		{
			log.info("Email Field is taking not Input.");
		}
		String phoneNo = "8329556301";
		editacc.getPhoneNumber(phoneNo);
		String enteredPhoneNo = editacc.checkEmail().getAttribute("value");
		if (enteredPhoneNo.equals(email))
		{
			log.info("Phone Number Field is taking  Input.");
		}
		else
		{
			log.info("Phone Number Field is taking not Input.");
		}
		
		//driver.manage().window().minimize();

		//TC4.16-To verify  after minimizing the screen  ,all text  box field s  are  clickable or not
		if((editacc.clickFirstName(firstName))&& (editacc.clickLastName(lastName)) && (editacc.clickEmail(email)) && (editacc.clickPhoneNumber(phoneNo)))
		{
			log.info("After Minimizing the window the all text box Field is clickable and editable");

		}
		else
		{
			log.info("After Minimizing the window the all text box Field is not clickable and editable");
		}
		
		
		//TC4.20-To verify for  change  profile picture icon ,photo upload size limit  given or not 
		driver.manage().window().maximize();
		if(editacc.checkProfileImg())
		{
			
			log.info("photo upload size limit found");
	}
	else
	{
		
		log.info("Photo upload size limit is not  Present");
		}
		
		//TC4.21- To  verify  change profile picture functionality allows  user to upload  all type of  photo file format :png,jpg,jfif
		//TC4.22-To verify on Edit account window change profile picture icon is properly functioning or not
		//editacc.clickProfileImg().click();
//		  WebElement changepic = driver.findElement(By.xpath("//span[@class='btn btn-azure btn-file']"));
//		  changepic.click();
//         String filePath = "C:\\Users\\Shamal Shinde\\Downloads\\sample-1.jpg";
//      	editacc.clickProfileImg().sendKeys(filePath);
//		editacc.clickProfileImg().click();
//		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//	     jsExecutor.executeScript("arguments[0].value=arguments[1];",changepic, filePath);
//		
	        // Set the file path
//	        String filePath = "C:\\Users\\Shamal Shinde\\Downloads\\sample-1.gif";
//
//	        changepic.sendKeys(filePath);
		
		//TC 4.23 -To verify on Edit account window delete profile picture icon is clickable or not 
		editacc.clickRemovePicture().click();
		Assert.assertTrue(editacc.clickRemovePicture().isEnabled(), "Remove Profile photo is not clickable");
		
		//TC4.24-To verify on Edit account window delete profile picture icon is properly functioning or not
		if(editacc.checkProgileImageBefore())
		{
			log.info("Remove Profile Picture Button is functioning properlly");
		}
		else
		{
			log.info("Remove Profile Picture Button is not functioning as aspected");
		}
		
		//TC4.25 - To verify update information button is clickable or not
		
		editacc.checkUpdateInformation().click();
		Assert.assertTrue(editacc.checkUpdateInformation().isEnabled(), "Update Information Button  is not clickable");
		
		//TC 4.26 To verify after click on  update information button it shows  success message or not.
		if(editacc.clickOKUserSettings().isDisplayed())
		{
			log.info("after click on  update information button it shows  success message");
		}
		else 
		{
			log.info("after click on  update information button it not shows  success message");
		}
		
		Assert.assertTrue(User.clickOKUserSettings().isEnabled(), "ok popup button  is not clickable.");
		editacc.clickOKUserSettings().click();
		
		driver.quit();
	}
		
	

	@DataProvider
	public Object[][] getData() 
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}

}
