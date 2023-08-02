package com.cases.userpreference;

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
import com.actions.Actions;
import com.base.Base;
import com.pageObjects.Login_main;
import com.pageObjects.userpreference.*;

@Listeners({ AllureListener.class })
public class ViewingFavoriteListFunctionality extends Base {
	public static Logger log = LogManager.getLogger(ViewingFavoriteListFunctionality.class.getName());
	public Actions actions;
	private WebDriverWait wait;

	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is intialized");
		
		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
		
		ViewingFavoriteListFunctionalityObj view = new ViewingFavoriteListFunctionalityObj(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
	     wait.until(ExpectedConditions.elementToBeClickable(view.clickTestDemo()));
		actions.click(view.clickTestDemo());
		// TC-1 To verify viewing favorite list in to my favorites
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		 wait.until(ExpectedConditions.elementToBeClickable(view.clickMyFavorite()));
		Assert.assertTrue(view.clickMyFavorite().isEnabled(), "My Favorite Tab is not clickable");
		
		actions.click(view.clickMyFavorite());
		

		 driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		return data;
	}

}
