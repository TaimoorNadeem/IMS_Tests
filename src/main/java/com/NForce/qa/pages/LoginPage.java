package com.NForce.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NForce.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - Object Repository for login page
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="submit")
	WebElement submit;
	
	@FindBy(xpath="//img[@src='/imgs/logo.png']")
	WebElement logo;
	
	@FindBy(xpath="//i[@class='icon-hbimsi']")
	WebElement hbimsi_icon;
	
	@FindBy(xpath="//i[@class='icon-weight']")
	WebElement weightedKeyword_icon;
	
	@FindBy(xpath="//i[@class='icon-hbsid']")
	WebElement hbsid_icon;
	
	@FindBy(xpath="//i[@class='icon-bdygrd']")
	WebElement bdyGrd_icon;
	
	@FindBy(xpath="//i[@class='icon-spoof']")
	WebElement spoofGrd_icon;
	
	@FindBy(xpath="//i[@class='icon-hbgt']")
	WebElement hbgt_icon;
	
	@FindBy(xpath="//i[@class='icon-scan']")
	WebElement scanGrd_icon;
	
	@FindBy(xpath="//i[@class='icon-fake']")
	WebElement fakeGrd_icon;
	
	@FindBy(xpath="//i[@class='icon-flood']")
	WebElement floodGrd_icon;
	
	
	//Initializing the page objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateNForceLogo() {
		return logo.isDisplayed();
	}
	
	public boolean validateHbimsi_Icon() {
		return hbimsi_icon.isDisplayed();
	}
	
	public boolean weightedKeyword_Icon() {
		return weightedKeyword_icon.isDisplayed();
	}
	
	public boolean hbsid_Icon() {
		return hbsid_icon.isDisplayed();
	}
	
	public boolean bdyGrd_Icon() {
		return bdyGrd_icon.isDisplayed();
	}
	
	public boolean spoofGrd_Icon() {
		return spoofGrd_icon.isDisplayed();
	}
	
	public boolean hbgt_Icon() {
		return hbgt_icon.isDisplayed();
	}
	
	public boolean scanGrd_Icon() {
		return scanGrd_icon.isDisplayed();
	}
	
	public boolean fakeGrd_Icon() {
		return fakeGrd_icon.isDisplayed();
	}
	
	public boolean floodGrd_Icon() {
		return floodGrd_icon.isDisplayed();
	}
	
	public String isLoginPage() {
		return driver.getCurrentUrl();
	}
	
	public DashboardPage login(String email, String pwd) {
		username.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		return new DashboardPage();
	}

}
