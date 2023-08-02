package com.cases.DMSDocumentShareOnMailTestCase;

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
import com.pageObjects.DMSDocumentShareOnMail.DmsDocMail;
import com.pageObjects.DMSFeatureDocumentview.DmsViewDoc;
import com.base.Base;
import com.pageObjects.Login_main;

@Listeners({ AllureListener.class })
public class DmsDocMailTest extends Base {
	public static Logger log = LogManager.getLogger(DmsViewDoc.class.getName());

	private WebDriverWait wait;
	@BeforeMethod
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("Succesfully opened the browser");

		driver.get(prop.getProperty("url"));
			wait = new WebDriverWait(driver, Duration.ofSeconds(90));
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password) throws IOException, InterruptedException {

		Login_main login = new Login_main(driver);
		login.getUsername().sendKeys(Username);
		login.getPassword().sendKeys(Password);
		login.clickLogin().click();
		login.clickPopup().click();
		login.clickLogin2().click();
		login.clickPopup2().click();
//		Thread.sleep(4000);

		DmsViewDoc d = new DmsViewDoc(driver);

		DmsDocMail mail = new DmsDocMail(driver);
		Thread.sleep(5000);
		d.SelectInfoDocs().click();
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.elementToBeClickable(d.ClickOnFolder1()));
		d.ClickOnFolder1().click();
//		Thread.sleep(5000);
		// TC1.1
		d.rightClickElement();
		//Thread.sleep(3000);
		Assert.assertTrue(d.ViewDocument().isDisplayed(), "if we right click on file then window  not Displayed");
		log.info("if we right click on file then window   Displayed");
		// TC1.2
		mail.verifyCursorMovability();
		Assert.assertTrue(d.ViewDocument().isDisplayed(), " drop up window cursor is not movable");

		// TC1.3
		Assert.assertTrue(d.ViewDocument().isDisplayed(), "widow should not contains list");
		log.info("widow should  contains list");

		// TC1.4
		Assert.assertTrue(mail.EmailInList().isDisplayed(), "Email option is not present in List");
		log.info("Email option is Present");

		// TC1.5
		 wait.until(ExpectedConditions.elementToBeClickable(mail.EmailInList()));
		mail.EmailInList().click();
		Thread.sleep(2000);
		Assert.assertTrue(mail.VerifyEmailClick().isDisplayed(), "Email option is not CLickeble");
		log.info("Email option is Clickeble");

		// TC1.6
		Assert.assertTrue(mail.VerifyEmailClick().isDisplayed(),
				" After clicking email option share document on email window not opening");
		log.info("After clicking email option share document on email window is opening");

		// TC1.7

		Assert.assertTrue(mail.ToEmail().isDisplayed(), "To option is not present ");
		log.info("To option is Present");
		Assert.assertTrue(mail.CcEmail().isDisplayed(), "Cc option is not present ");
		log.info("Cc option is Present");
		Assert.assertTrue(mail.SubjectEmail().isDisplayed(), "Subject option is not present");
		log.info("Subject option is Present");
		Assert.assertTrue(mail.MessageEmail().isDisplayed(), "Message option is not present ");
		log.info("Message option is Present");
		Assert.assertTrue(mail.SendEmail().isDisplayed(), "Send option is not present ");
		log.info("Send option is Present");
		Assert.assertTrue(mail.CloseEmail().isDisplayed(), "Close option is not present ");
		log.info("Close option is Present");
		Assert.assertTrue(mail.CrossEmail().isDisplayed(), "Cross option is not present ");
		log.info("Cross option is Present");

		// TC1.8

		Assert.assertTrue(mail.ToEmail().isDisplayed(), "To option is not Placed Properly ");
		log.info("To option is Placed Properly");
		Assert.assertTrue(mail.CcEmail().isDisplayed(), "Cc option is not Placed Properly ");
		log.info("Cc option is Placed Properly");
		Assert.assertTrue(mail.SubjectEmail().isDisplayed(), "Subject option is not Placed Properly");
		log.info("Subject option is Placed Properly");
		Assert.assertTrue(mail.MessageEmail().isDisplayed(), "Message option is not Placed Properly ");
		log.info("Message option is Placed Properly");
		Assert.assertTrue(mail.SendEmail().isDisplayed(), "Send option is Placed not Properly ");
		log.info("Send option is Placed Properly");
		Assert.assertTrue(mail.CloseEmail().isDisplayed(), "Close option is Placed not Properly ");
		log.info("Close option is Placed Properly");
		Assert.assertTrue(mail.CrossEmail().isDisplayed(), "Cross option is Placed not Properly");
		log.info("Cross option is Placed Properly");

		// TC1.9
		Assert.assertTrue(mail.ToTextFieldEmail().isDisplayed(), "To TextField is not Present ");
		log.info("To TextField is  Present ");
		Assert.assertTrue(mail.CcTextFieldEmail().isDisplayed(), "Cc TextField is not Present ");
		log.info("Cc TextField is Present ");
		Assert.assertTrue(mail.SubjectTextFieldEmail().isDisplayed(), "Subject TextField is not Present");
		log.info("Subject TextField is Present ");
//				Assert.assertTrue(mail.MessageTextFieldEmail().isDisplayed(), "Message TextField is not Present ");
//				log.info("Message TextField is  Present ");

		// TC1.10
		mail.ToTextFieldEmail().sendKeys("abhishekhirulkar12@gmail");
		Assert.assertTrue(mail.ToTextFieldEmail().isDisplayed(), " text box field is not clickable  ");
		log.info("text box field is  clickable  ");

		// TC1.11
		mail.ToTextFieldEmail().clear();
		String inputText = "aleex@gmail.";
		mail.ToTextFieldEmail().sendKeys(inputText);
		String enteredText = mail.ToTextFieldEmail().getAttribute("value");
		boolean acceptsInput = enteredText.equals(inputText);
		System.out.println("Text box field accepts input: " + acceptsInput);
		log.info(" To text box field accept input  ");

		// TC1.12
		Assert.assertTrue(mail.CcTextFieldEmail().isDisplayed(), " CC text box field is not Present ");
		log.info("CC text box field is  Present ");

		// TC1.13
		mail.CcTextFieldEmail().sendKeys("abhi@gmail");
		Assert.assertTrue(mail.ToTextFieldEmail().isDisplayed(), " CC text box field is not clickable  ");
		log.info(" CC text box field is  clickable  ");
		// TC1.14
		mail.CcTextFieldEmail().clear();
		String CCinputText = "yash.shardul@";
		mail.ToTextFieldEmail().sendKeys(CCinputText);
		String CCenteredText = mail.ToTextFieldEmail().getAttribute("value");
		boolean CCacceptsInput = CCenteredText.equals(inputText);
		System.out.println("Text box field accepts input: " + CCacceptsInput);
		Assert.assertTrue(mail.ToTextFieldEmail().isDisplayed(), " CC text box field is not accept input ");
		log.info(" CC text box field accept input  ");

//			    //TC1.15 	
//			    mail.CcTextFieldEmail().clear();
//			    mail.SendEmail().click();
//				Assert.assertTrue(mail.OKSendMAilError().isDisplayed(), " if we mentioned invalid mail id in to To then error message window not displaying");
//				log.info("if we mentioned invalid mail id in to To then error message window is displaying");
		// TC1.16
//			    mail.SendEmail().click();
//				Assert.assertTrue(mail.OKSendMAilError().isDisplayed(), " if we mentioned invalid mail id with wrong combination in to To then error message window not displaying");
//				log.info("if we mentioned invalid mail id with wrong combination in to To then error message window is displaying");
//				
		// TC1.17
//				mail.ToTextFieldEmail().clear();
//				mail.ToTextFieldEmail().sendKeys("abhishekhirulkar12@gmail.com");
//				mail.CcTextFieldEmail().clear();
//				mail.CcTextFieldEmail().sendKeys("aleex8600@gmail.com");
//				
		// TC1.18
		Assert.assertTrue(mail.SubjectTextFieldEmail().isDisplayed(), "Subject TextField is not Present");
		log.info("Subject TextField is Present ");

		// TC1.19
		mail.SubjectTextFieldEmail().clear();
		String documentName = "Sharing WRITER.png";
		mail.SubjectTextFieldEmail().sendKeys(documentName);
		String SubenteredText = mail.SubjectTextFieldEmail().getAttribute("value");
		boolean subjectMatchesDocumentName = SubenteredText.equals(documentName);
		System.out.println("Subject text box field matches document name: " + subjectMatchesDocumentName);

		// TC1.20
		Assert.assertTrue(mail.SubjectTextFieldEmail().isDisplayed(), " Subject text box field is not accept input ");
		log.info(" Subject text box field accept input  ");

		// TC1.21 Unable To Locate Message Text Field
//			    Assert.assertTrue(mail.MessageTextFieldEmail().isDisplayed(), " Message text box field is not Present ");
//			    log.info(" Subject text box field accept input  ");

		// TC1.22 Unable To Locate Message Text Field
		// TC1.23 Unable To Locate Message Text Field

//				mail.SubjectTextFieldEmail().sendKeys(" "+"This is my File");
//				Assert.assertTrue(mail.SubjectTextFieldEmail().isDisplayed(), "Subject TextField is not Present");
//				log.info("Subject TextField is Present ");
//				
//				mail.MessageTextFieldEmail().sendKeys("pleaser check my Attachment");
//				Assert.assertTrue(mail.MessageTextFieldEmail().isDisplayed(), "Message TextField is not Present ");
//				log.info("Message TextField is  Present ");

		// TC1.24
		Assert.assertTrue(mail.SendEmail().isDisplayed(), "Send Button is not Present ");
		log.info("Send Button is  Present ");

		Assert.assertTrue(mail.CloseEmail().isDisplayed(), "Close Button is not Present ");
		log.info("Close Button is  Present ");

		// TC1.25
		mail.SendEmail().click();
		if (driver.getCurrentUrl()
				.equals("https://ecm.writercorporation.com/InfoDocsV1/Folder/Internal%20Server%20Error")) {
			log.info("Save Button is Clickable");
		} else {
			log.info("Save Button is not  Clickable");
		}
		mail.Navigate();

		// TC1.26
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fix-loader")));
		 wait.until(ExpectedConditions.elementToBeClickable(d.ClickOnFolder1()));
		d.ClickOnFolder1().click();
		Thread.sleep(5000);
		d.rightClickElement();
//		Thread.sleep(3000);
		mail.EmailInList().click();
//		Thread.sleep(2000);
		mail.ToTextFieldEmail().sendKeys("abhishekhirulkar12@gmail");
		mail.CloseEmail().click();
		Assert.assertTrue(mail.T1FolderClick().isDisplayed(), "Close Button is not Clickable ");
		log.info("Close Button is Clickable ");

		// TC1.27 Server Error..................
		// TC1.28 Server Error..................

		// TC1.29
		Assert.assertTrue(mail.T1FolderClick().isDisplayed(),
				"After clicking on close button,it not navigates to DMS work space window ");
		log.info("After clicking on close button,it  navigates to DMS work space window");

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
