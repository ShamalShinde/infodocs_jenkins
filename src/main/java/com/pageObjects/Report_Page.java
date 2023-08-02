package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Report_Page {
	public WebDriver driver;

	public Report_Page(WebDriver driver) {
		this.driver = driver;
	}

	By menu_Reports = By.xpath("//span[text()='Reports ']");
	By option_AuditLog = By.cssSelector("li[class='dropdown pull-right open'] li:nth-child(1) a:nth-child(1)");
	By button_Download = By.cssSelector(".btn.btn-success.btn-o1.btn-xs.text-right");

	public Actions clickReport() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Reports ']"))).click().build().perform();
		return action;
	}

	public WebElement clickAudit() {
		return driver.findElement(option_AuditLog);

	}

	public WebElement clickDownload() {
		return driver.findElement(button_Download);

	}

}
