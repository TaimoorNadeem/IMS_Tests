package com.NForce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NForce.qa.base.TestBase;

public class BulkGuardPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'BulkGuard')]")
	WebElement bulkGuardLabel;
	
	@FindBy(xpath="//i[@class='fa fa-question']")
	WebElement bgSearchWildcards;
	
	@FindBy(xpath="//div[@class='jconfirm-closeIcon']")
	WebElement closeIcon;
	
	//Initializing the page objects:
		public BulkGuardPage() {
			PageFactory.initElements(driver, this);
		}
	
	public boolean verifyBulkGuardLabel() {
		return bulkGuardLabel.isDisplayed();
	}
	
	public String isBulkGuardPage() {
		return driver.getCurrentUrl();
	}
	
	public boolean verifyClickOnSearchWildcards() {
		bgSearchWildcards.click();
		return true;
	}
	
	

}
