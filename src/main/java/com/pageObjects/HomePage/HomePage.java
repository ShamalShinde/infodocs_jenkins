package com.pageObjects.HomePage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;
	public String originalWindowHandle;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='text-white']")
	WebElement homepageDisplay;

	@FindBy(xpath = "//h4[normalize-space()='Welcome, Vishal Shah']")
	WebElement welcomeuserName;

	@FindBy(xpath = "//span[@data-original-title='Login Time']")
    WebElement datetime;

	@FindBy(xpath = "//a[@class='navbar-brand']//img")
	WebElement infodocsLogo;

	@FindBy(xpath  = "//span[normalize-space()='Shared With Me']")
	WebElement sharedWithMeTab;
	
	@FindBy(xpath  = "//span[@id='select2-ddlSearch-container']")
	WebElement searchByWindowDropdown;
	
	@FindBy(xpath  = "//span[normalize-space()='Recycle Bin']")
	WebElement recyleBinTAb;
	
	@FindBy(xpath  = "//a[@class='sidebar-toggler pull-right1 visible-md visible-lg']//i[@class='ti-align-justify']")
	WebElement linesOnHomePAge;
	
	@FindBy(xpath  = "//span[normalize-space()='Reports']")
	WebElement repotsIcon;
	
	@FindBy(xpath  = "//a[normalize-space()='Audit Log']")
	WebElement auditLog;
	
	@FindBy(xpath  = "//a[normalize-space()='MIS Report']")
	WebElement misReport;
	
	@FindBy(xpath  = "//a[normalize-space()='User Activity Report']")
	WebElement userActivityReport;
	
	@FindBy(xpath  = "//h3[normalize-space()='Audit Log']")
	WebElement auditLogTitlet;
	
	@FindBy(xpath  = "//td[contains(text(),'Jun 14 2023')]")
	WebElement auditLogDateTime;
 
	@FindBy(xpath  = "//i[@class='ti-download']")
	WebElement auditLogDownload;
	
	@FindBy(xpath  = "//th[normalize-space()='Total']")
	WebElement misReportTotal;
	
	@FindBy(xpath  = "//th[normalize-space()='Successful Logins in']")
	WebElement userActivityTotal;
	
	public WebElement HomePageDisplay() {
		return homepageDisplay;
	}

	public WebElement WelcomeUserName() {
		return welcomeuserName;
	}
	public WebElement InfodocsLogo() {
		return infodocsLogo;
	}
	public WebElement DateTime() {
		return datetime;
	}
	public WebElement SharedWithMeTab() {
		return sharedWithMeTab;
	}
	public WebElement SearchByWindowDrop() {
		return searchByWindowDropdown;
	}
	public WebElement RecycleBinTab() {
		return recyleBinTAb;
	}
	public WebElement LinesOnHomePage() {
		return linesOnHomePAge;
	}
	public void scrollToElement() {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sharedWithMeTab);
	}
	public WebElement ReportIcon() {
		return repotsIcon;
	}
	 public void Reporthover() {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(repotsIcon).perform();
	    }

	 public WebElement AuditLog() {
			return auditLog;
		}
      
	 public WebElement MisReport() {
			return misReport;
		}
	 public WebElement userActivityReport() {
			return userActivityReport;
		}
       
	 public WebElement AuditLogTitle() {
			return auditLogTitlet;
		}
	 public WebElement AuditLogDateTime() {
			return auditLogDateTime;
		}
	 public WebElement AuditLogDownload() {
			return auditLogDownload;
		}
	 public WebElement MisReportTotal() {
			return misReportTotal;
		}
	 public WebElement UserActivityTotal() {
			return userActivityReport;
		}

}
