package com.NForce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NForce.qa.base.TestBase;
import com.NForce.qa.pages.DashboardPage;
import com.NForce.qa.pages.LoginPage;
import com.NForce.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	TestUtil testUtil;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		dashboardPage = new DashboardPage();
		loginPage = new LoginPage();
	}

	
	
	  @Test(priority=1) public void controlOnLoginPage(){ String isLoginPage =
	  loginPage.isLoginPage(); Assert.assertEquals(isLoginPage,
	  "http://192.168.14.159/site/login"); }
	  
	  @Test(priority=2) public void loginPageTitleTest(){ String title =
	  loginPage.validateLoginPageTitle(); Assert.assertEquals(title,
	  "HAUD - Site"); }
	  
		
		  @Test(priority=3) public void checkIfNForceLogoPresent() { boolean logoFlag =
		  loginPage.validateNForceLogo(); Assert.assertTrue(logoFlag); }
		  
		  
		  
			/*
			 * @Test(priority=4) public void checkIfHbimsiIconPresent() { boolean
			 * hbimisiFlag = loginPage.validateHbimsi_Icon();
			 * Assert.assertTrue(hbimisiFlag); }
			 * 
			 * @Test(priority=5) public void checkIfWeightedKeywordIconPresent() { boolean
			 * weightedKeywordFlag = loginPage.weightedKeyword_Icon();
			 * Assert.assertTrue(weightedKeywordFlag); }
			 * 
			 * @Test(priority=6) public void checkIfHbsidIconPresent() { boolean hbsidFlag =
			 * loginPage.hbsid_Icon(); Assert.assertTrue(hbsidFlag); }
			 * 
			 * @Test(priority=7) public void checkIfBdyGrdIconPresent() { boolean bdyGrdFlag
			 * = loginPage.bdyGrd_Icon(); Assert.assertTrue(bdyGrdFlag); }
			 * 
			 * @Test(priority=8) public void checkIfSpoofGrdIconPresent() { boolean
			 * spoofGrdFlag = loginPage.spoofGrd_Icon(); Assert.assertTrue(spoofGrdFlag); }
			 * 
			 * @Test(priority=9) public void checkIfHbgtIconPresent() { boolean hbgtFlag =
			 * loginPage.hbgt_Icon(); Assert.assertTrue(hbgtFlag); }
			 * 
			 * @Test(priority=10) public void checkIfScanGrdIconPresent() { boolean
			 * scanGrdFlag = loginPage.scanGrd_Icon(); Assert.assertTrue(scanGrdFlag); }
			 * 
			 * @Test(priority=11) public void checkIfFakeGrdIconPresent() { boolean
			 * fakeGrdFlag = loginPage.fakeGrd_Icon(); Assert.assertTrue(fakeGrdFlag); }
			 * 
			 * @Test(priority=12) public void checkIfFloodGrdIconPresent() { boolean
			 * floodGrdFlag = loginPage.floodGrd_Icon(); Assert.assertTrue(floodGrdFlag); }
			 */
		 
	  @Test(priority=4) public void loginTest() { dashboardPage =
	  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  }
	 
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
