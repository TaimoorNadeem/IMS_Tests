package com.NForce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NForce.qa.base.TestBase;
import com.NForce.qa.pages.BulkGuardPage;
import com.NForce.qa.pages.DashboardPage;
import com.NForce.qa.pages.LoginPage;
import com.NForce.qa.util.TestUtil;

public class BulkGuardPageTest extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	BulkGuardPage bulkGuardPage;
	TestUtil testUtil;
	
	public BulkGuardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		bulkGuardPage = new BulkGuardPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		bulkGuardPage = dashboardPage.clickOnTrafficManagementIcon();
		Thread.sleep(4000);
	}
	
	@Test(priority=1)
	public void verifyBulkGuardLabelTest() {
		boolean label = bulkGuardPage.verifyBulkGuardLabel();
		Assert.assertTrue(label, "BulkGuard Label is missing on the page");
	}
	
	@Test(priority=2)
	public void verifyClickOnSearchWildcardsTest() {
		Assert.assertTrue(bulkGuardPage.verifyClickOnSearchWildcards());
	}
	
	@Test(priority=3)
	public void controlOnBulkGuardPage(){ 
		String isBulkGuardPage = bulkGuardPage.isBulkGuardPage(); 
		Assert.assertEquals(isBulkGuardPage,"http://192.168.14.159/control/blkgrd/green"); }
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
