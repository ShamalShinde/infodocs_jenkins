package com.pageObjects.DMSFeatureDownloadingDocument;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demo22 {
	WebDriver driver;
	public String originalWindowHandle;

	public Demo22(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Patient']")
	WebElement departmentPatient;
	
	@FindBy(xpath = "//div[@class='col-xs-10 max-over']//span[@class='ng-binding'][normalize-space()='Registration']")
	WebElement regiFolder;
	
	@FindBy(xpath = "//label[@for='chkFolderAndFiles_0']")
	WebElement checkBox;
	
	@FindBy(xpath = "//a[@class='btn btn-dark-orange btn-o1 btn-sm pull-right']//i[@class='ti-download']")
	WebElement zipDown;
	
	public WebElement DepartmentPatient() {
		return departmentPatient;
	}
	public WebElement RegiFolder() {
		return regiFolder;
	}
	public WebElement CheckBox() { 
		return checkBox;
	}
	public WebElement ZipDownlaod() {
		return zipDown;
	}
	 public void AcceptPopup() {
         Alert alert = driver.switchTo().alert();
         alert.accept();
     }

}
