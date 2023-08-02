package com.pageObjects.userpreference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OutboxFunctionalityObj {

	public WebDriver driver;

	public OutboxFunctionalityObj(WebDriver driver) {
		this.driver = driver;

	}

	By sidemenu_TestDemo = By.xpath("//li[@class='liSideMenu fademenu closed']//i[@class='icon-arrow']");

	public WebElement clickTestDemo() {

		return driver.findElement(sidemenu_TestDemo);
	}

	// TC-12.1 To verify outbox window present or not

	By frame_Outbox = By.xpath("//a[@href='#dvSentForAppr']");

	public WebElement clickOutbox() {

		return driver.findElement(frame_Outbox);

	}

	// TC-12.3 To verify outbox window present or not

	By frame_OutboxTable = By.xpath("//div[@id='dvSentForAppr']//table[@class='table table-bordered table-striped']");

	public WebElement clickOutboxTable() {

		return driver.findElement(frame_OutboxTable);

	}

	// TC-12.4 To verify in to table under file name and file path ,details are
	// given/uploaded or not
	By td_Filname = By.xpath("//div[@id='dvSentForAppr']//table[@class='table table-bordered table-striped']");
	By td_Filepath = By.xpath("//div[@id='dvSentForAppr']//table[@class='table table-bordered table-striped']");

	public WebElement clickFileName() {

		return driver.findElement(td_Filname);

	}

	public WebElement clickFilePath() {

		return driver.findElement(td_Filepath);

	}

	// TC-12.5 To verify after clicking on particular PDF file it is opening or not
	By a_PdfFile = By.xpath("//span[normalize-space()='invoice-02.pdf']");

	public WebElement clickPdfFile() {

		return driver.findElement(a_PdfFile);

	}

	// TC-12.5  To verify after clicking on particular word file it is opening or
	// not
	By a_WordFile = By.xpath("(//span[@class='ng-binding'][normalize-space()='Module.docx'])[3]");

	public WebElement clickWordFile() {

		return driver.findElement(a_WordFile);

	}

	// TC-12.6 To verify after clicking on particular excel file it is opening or
	// not
	By a_ExcelFile = By.xpath("(//span[normalize-space()='Free_Test_Data_1MB_XLS.xls'])[1]");

	public WebElement clickExcelFile() {

		return driver.findElement(a_ExcelFile);

	}

	// TC-12.7 To verify after clicking on particular image file it is opening or
	// not
	By a_ImageFile = By.xpath("//span[contains(text(),'Picture1.png')]");

	public WebElement clickImageFile() {

		return driver.findElement(a_ImageFile);

	}

	// TC-12.8 To verify view status button is clickable or not
	By popup_ViewStatus = By.xpath("//div[@id='dvStatusLog']//div[@class='modal-dialog modal-lg']//div[@class='modal-content md-border']");
	public WebElement checkViewStatusPopup() {

		return driver.findElement(popup_ViewStatus);

	}

	By button_ViewStatus = By.xpath("//tbody/tr[2]/td[4]/button[1]");

	public WebElement clickViewStatus() {

		return driver.findElement(button_ViewStatus);

	}

	// TC-12.11 To verify after clicking on view status button ,view action status
	// window opening or not

	By frame_StatusWindow = By.xpath("(//div[@class='modal-content md-border'])[16]");

	public WebElement clickStatusWindow() {

		return driver.findElement(frame_StatusWindow);

	}

	// TC-12.12 To verify on view action status window action table present or not

	By table_StatusWindowAction = By
			.xpath("//div[@id='dvStatusLog']//table[@class='table table-bordered table-striped']");

	public WebElement clickStatusWindowAction() {

		return driver.findElement(table_StatusWindowAction);

	}

	// TC-12.13 To verify on view action status window close button present or not

	By button_Close = By.xpath("//button[@ng-click='CloseActionStatus()'][normalize-space()='Close']");

	public WebElement clickCloseButton() {

		return driver.findElement(button_Close);

	}

	// TC-12.16 To verify on outbox window refresh button icon present or not
	By button_Refresh = By.xpath("(//a[@class='btn btn-info btn-o1 btn-sm pull-right btnRefresh'])[5]");

	public WebElement clickRefreshButton() {

		return driver.findElement(button_Refresh);

	}

}
