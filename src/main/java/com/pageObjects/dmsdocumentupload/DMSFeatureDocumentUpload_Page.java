package com.pageObjects.dmsdocumentupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DMSFeatureDocumentUpload_Page {
	public WebDriver driver;
	public DMSFeatureDocumentUpload_Page(WebDriver driver) {
		this.driver = driver;
	}

	By list_Folders = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li");
	By element_infodocs = By.xpath("//a[@ng-click=\"ViewPrjFolder(245027,false,'infodocs')\"]");
	By frame_DMSWorkspace = By.xpath("//span[contains(text(),'DMS Workspace')]");
	By frame_AdvanceSerach = By.xpath("//h4[contains(text(),'Advanced Search')]");
	By tablerows_DMSFolderName = By.xpath("//tr[contains(@id, '')]//td[@onclick='activateClass(this)']");
	By icon_NewFolder = By.cssSelector("a.btn.btn-warning.btn-o1.btn-sm.pull-right");
	By icon_Delete = By.cssSelector("a.btn.btn-danger.btn-o1.btn-sm.pull-right");
	By icon_UploadFile = By.xpath("//a[@class='btn btn-dark-azure btn-o1 btn-sm pull-right']");
	By icon_Refresh = By.xpath("//div[@class='btn-group']//a[@class='btn btn-info btn-o1 btn-sm pull-right btnRefresh']");
	By checkBox_FolderCheckBOx = By.cssSelector("div.checkbox.clip-check.check-warning.checkbox-block");
	By radio_EntityType = By.xpath("//tbody//label[1]//span[1]");
	By tabledData_MainFolder= By.xpath("//a[@id='aFile_1'");
	By tableData_SubFolder =  By.xpath("//div[@class='col-xs-10 max-over']//span[@class='ng-binding'][contains(text(),'selenium')]");
	By icon_AddToFavorite = By.cssSelector("i.ti-star");
	By icon_ViewIndexingDetails = By.xpath("//table[1]//tbody[1]//tr[1]//td[14]//a[3]");
	By popup_UploadFiles = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]");
	By popupLabel_DocumentDate = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[2]/div[1]/label[1]");
	By dropdown_CalenderBox = By.xpath("/html[1]/body[1]/div[4]");
	By DatePicker_TodaysDate = By.xpath("//td[@class='today day']");
	By tag_RequestApproval = By.cssSelector("div.col-xs-4");
	By dropdown_RequestApproval = By.xpath("(//button[@type='button'])[13]");
	By options_RequestApproval = By.xpath("//ul[@class='dropdown-menu dropdown-menu-form ng-scope']");
	By input_SelectFile = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[1]/div[1]/div[2]/form[1]/form[1]/input[1]");
	By button_UploadFile = By.xpath("//div[@class='col-md-3']/button[1]");
	By popup_SuccessfullyUpdated = By.xpath("//button[@class='confirm']");
	By list_WordFile = By.xpath("//span[contains(text(),'selenium_documentation_index.docx')]");
	By list_20MbPng = By.xpath("//span[contains(text(),'20mbpng.png')]");
	By list_500MbPng = By.xpath("//span[contains(text(),'500kb.png')]");
	By dropdown_fonts = By.xpath("//div[@class='se-toolbar sun-editor-common']/div[1]/ul[1]/li[1]/button[1]");
	public WebElement getlist_Folders() {

		return driver.findElement(list_Folders);


	}
	
	public WebElement getElemntFolderName() {

		return driver.findElement(element_infodocs);


	}
	
	public WebElement getElemntFolderPath() 
	{
		return driver.findElement(element_infodocs);
	}
	
	public WebElement checkDMSWorkspace() 
	{
		return driver.findElement(frame_DMSWorkspace);
	}
	public WebElement checkAdvanceSerach() 
	{
		return driver.findElement(frame_AdvanceSerach);
	}
	
	public WebElement checkDMSConsistFolders() 
	{
		return driver.findElement(tablerows_DMSFolderName);
	}
	
	public WebElement checkIconNewFolder() 
	{
		return driver.findElement(icon_NewFolder);
	}
	public WebElement checkIconDelete() 
	{
		return driver.findElement(icon_Delete);
	}
	public WebElement checkIconUploadFile() 
	{
		return driver.findElement(icon_UploadFile);
	}
	public WebElement checkIconRefresh() 
	{
		return driver.findElement(icon_Refresh);
	}
	public WebElement checkFolderCheckBoxes() 
	{
		return driver.findElement(checkBox_FolderCheckBOx);
	}
	
	public WebElement checkEntityTypeRadio() 
	{
		return driver.findElement(radio_EntityType);
	}
	
	public WebElement ClickMainFolderSeleDoc() 
	{
		return driver.findElement(tabledData_MainFolder);
	}
	public WebElement clickSubFolderSelenium() 
	{
		return driver.findElement(tableData_SubFolder);
	}

	public WebElement checkIconAddToFavorite() 
	{
		return driver.findElement(icon_AddToFavorite);
	}
	
	public WebElement checkIconViewIndexingDetails() 
	{
		return driver.findElement(icon_ViewIndexingDetails);
	}
	
	public WebElement checkPopupUploadFiles() 
	{
		return driver.findElement(popup_UploadFiles);
	}
	
	public WebElement checkpopupLabelDocumentDate() 
	{
		return driver.findElement(popupLabel_DocumentDate);
	}
	
	public WebElement checkDropdownCheckBox() 
	{
		return driver.findElement(dropdown_CalenderBox);
	}
	public WebElement selectDateCalenderBox() 
	{
		return driver.findElement(DatePicker_TodaysDate);
	}
	public WebElement checkDropdownRequestApproval() 
	{
		return driver.findElement(dropdown_RequestApproval);
	}
	
	public WebElement checkOptionsRequestApproval() 
	{
		return driver.findElement(options_RequestApproval);
	}

	public WebElement checkSelectFile() 
	{
		return driver.findElement(input_SelectFile);
	}
	
	public WebElement checkUploadFileButton() 
	{
		return driver.findElement(button_UploadFile);
	}
	public WebElement clickTextReqestApproval()
	{
		return driver.findElement(tag_RequestApproval);
	}
	public WebElement clickOkSuffullyUpdated()
	{
		return driver.findElement(popup_SuccessfullyUpdated);
	}
	public WebElement clickListWordFile()
	{
		return driver.findElement(list_WordFile);
	}

	public WebElement clickDropdownFonts()
	{
		return driver.findElement(dropdown_fonts);
	}

	public WebElement click20MbPng()
	{
		return driver.findElement(list_20MbPng);
	}

	public WebElement click500MbPng()
	{
		return driver.findElement(list_500MbPng);
	}

	
}
