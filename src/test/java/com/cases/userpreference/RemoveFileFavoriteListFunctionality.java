package com.cases.userpreference;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
import com.actions.Actions;
import com.base.Base;
import com.pageObjects.Login_main;
import com.pageObjects.userpreference.*;

@Listeners({ AllureListener.class })
public class RemoveFileFavoriteListFunctionality extends Base {
	public static Logger log = LogManager.getLogger(RemoveFileFavoriteListFunctionality.class.getName());
	public Actions actions;
	private WebDriverWait wait;
	
	
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");
	
		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		log.info("Navigated to Home page");
		actions = new Actions(driver);
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password) throws IOException, InterruptedException {

		Login_main login = new Login_main(driver);
		login.getUsername().sendKeys(userName);
		login.getPassword().sendKeys(password);
		login.clickLogin().click();
		login.clickPopup().click();
		login.clickLogin2().click();
		login.clickPopup2().click();
		

		RemoveFileFavoriteListFunctionalityObj remove = new RemoveFileFavoriteListFunctionalityObj(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
	     wait.until(ExpectedConditions.elementToBeClickable(remove.clickTestDemo()));
		actions.click(remove.clickTestDemo());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		 wait.until(ExpectedConditions.elementToBeClickable(remove.clickMyFavorite()));
		actions.click(remove.clickMyFavorite());
		// TC-10.1 To verify in my favourite -  files and delete icon is present or not

		if (remove.areAllElementsDisplay()) {
			log.info("In my favourite -  files and delete icon is present");
		} else {
			log.info("In my favourite -  files and delete icon is not present");
		}
		
		//TC-10.2 To verify delete icon is clickable or not
		
		 wait.until(ExpectedConditions.elementToBeClickable(remove.clickRemoveFileIcon()));
		Assert.assertTrue(remove.clickRemoveFileIcon().isEnabled(), "My Favorite Tab is not clickable");
		actions.click(remove.clickRemoveFileIcon());
		
		
		//TC-10.3 To verify after clicking on delete icon it displays user confirmation window weather to delete or not
		 wait.until(ExpectedConditions.elementToBeClickable(remove.clickRemoveWindow()));
		if (remove.clickRemoveWindow().isDisplayed()) {
			log.info(" A after clicking on delete icon it is displays user confirmation window ");
		} else {
			log.info("  after clicking on delete icon it is not displays user confirmation window");
		}
		
		// TC-10.4  To verify on confirmation window cancel and delete buttons are present or not
		
		if(remove.clickCancelButton().isDisplayed() && remove.clickDeleteButton().isDisplayed())
		{
			log.info("confirmation window cancel and delete buttons are present ");
		}
		else
		{
			log.info("confirmation window cancel and delete buttons are not present ");
		}
		
		//TC-10.5  To verify on window cancel  and delete buttons are clickable and functioning or not
		Assert.assertTrue(remove.clickRemoveFileIcon().isEnabled(), "Delete Button is not clickable");

		Assert.assertTrue(remove.clickRemoveFileIcon().isEnabled(), "Cancel Button Tab is not clickable");
		
		//TC-10.6 To verify after clicking on delete buttons  it displays success message window or not.
//		actions.click(remove.clickDeleteButton());
//		Thread.sleep(5000);
//		if(remove.clickSuccessWindow().isDisplayed())
//		{
//			log.info(" After clicking on delete buttons  it is displays success message window");
//		}
//		else
//		{
//			log.info(" After clicking on delete buttons  it is not displays success message window");
//		}
		

		//TC-10.7 To verify after clicking on cancel buttons  it displays cancelled message window or not.
		actions.click(remove.clickCancelButton());
		
		if(remove.clickSuccessWindow().isDisplayed())
		{
			log.info("After clicking on cancel buttons  it is displays cancelled message window ");
		}
		else
		{
			log.info("After clicking on cancel buttons  it is not displays cancelled message window ");
		}
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}
	private static void waitForPageLoad( WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        int timeoutInSeconds = 10;
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 1000) {
            boolean isPageLoaded = jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            if (isPageLoaded) {
                break;
            }
        }
    }

}
