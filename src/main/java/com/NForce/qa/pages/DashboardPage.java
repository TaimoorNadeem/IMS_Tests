package com.NForce.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NForce.qa.base.TestBase;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage extends TestBase {
	
	@FindBy(xpath="//ul[@class='userTools']//li")
	WebElement userToolsList;
	
	@FindBy(xpath="//span[@class='role' and contains(text(), 'qatest.admin@internal.haud')]")
	WebElement role;
	
	@FindBy(xpath="//span[normalize-space()='minimize all']")
	WebElement minimizeAll;
	
	@FindBy(xpath="//span[normalize-space()='expand all']")
	WebElement expandAll;
	
	@FindBy(xpath="//span[normalize-space()='reload']")
	WebElement reload;
	
	@FindBy(id="add_dashboard")
	WebElement addDashboard;
	
	@FindBy(id="dashboard_name")
	WebElement dashboardName;
	
	@FindBy(xpath="//button[normalize-space()='Create']")
	WebElement createBtn;
	
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	WebElement editDashName;
	
	@FindBy(id="name")
	WebElement newName;
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	WebElement saveName;
	
	@FindBy(xpath="//i[@class='fa fa-ban']")
	WebElement cancelEdit;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	WebElement deleteDash;
	
	@FindBy(xpath="//button[normalize-space()='Yes']")
	WebElement deleteYes;
	
	@FindBy(xpath="//button[normalize-space()='No']")
	WebElement deleteNo;
	
	@FindBy(xpath="//i[@class='icon-steering']")
	WebElement trafficManagementIcon;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	
	public String verifyDashboardPageTitle() {
		return driver.getTitle();
	}
	
	public String isDashboardPage() {
		return driver.getCurrentUrl();
	}
	
	public String verifyUserName() {
		Actions action = new Actions(driver);
		action.moveToElement(userToolsList).build().perform();
		return role.getText();
	}
	
	public boolean verfiyMinimizeAllButton() {
		minimizeAll.click();
		return true;
	}
	
	public boolean verifyExpandAllButton() {
		expandAll.click();
		return true;
	}
	
	public boolean verifyReloadButton() {
		reload.click();
		return true;
	}
	
	public boolean verifyAddNewDashboard() {
		addDashboard.click();
		dashboardName.sendKeys("Dashboard_testing");
		createBtn.click();
		return true;
	}
	
	public BulkGuardPage clickOnTrafficManagementIcon() {
		trafficManagementIcon.click();
		return new BulkGuardPage();
	}
	
	public String verifyTrafficManagementPageTitle() {
		return driver.getTitle();
	}
	
}
