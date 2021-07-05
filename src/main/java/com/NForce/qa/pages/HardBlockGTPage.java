package com.NForce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NForce.qa.base.TestBase;

public class HardBlockGTPage extends TestBase {
	
	@FindBy(xpath="//a[normalize-space()='']//i[@class='icon-hbgt']")
	WebElement hbgtIcon;
	
	@FindBy(xpath="//span[contains(text(),'HardBlock GT')]")
	WebElement hardBlockGtLabel;
	
	@FindBy(id="gt")
	WebElement gtTitleField;
	
	@FindBy(id="note")
	WebElement note;
	
	@FindBy(xpath="//select[@id='list']")
	WebElement whiteList;
	
	@FindBy(xpath="//a[normalize-space()='Add to Category']")
	WebElement addCategoryBtn;
	
	//Initializing the page objects:
			public HardBlockGTPage() {
				PageFactory.initElements(driver, this);
			}
			
		public HardBlockGTPage clickOnHardBlockGTPage() {
			hbgtIcon.click();
			return new HardBlockGTPage();
		}
		
		public String verifyHardBlockGtLabel() {
			return hardBlockGtLabel.getText();
		}
		
		public String isHardBlockGtPage() {
			return driver.getCurrentUrl();
		}
			
		public void createNewHbgtParameter(String gt, String notes) {
			gtTitleField.sendKeys(gt);
			note.sendKeys(notes);
			//Select action = new Select(whiteList);
			//action.selectByVisibleText("Whitelist");
			addCategoryBtn.click();	
		}

}
