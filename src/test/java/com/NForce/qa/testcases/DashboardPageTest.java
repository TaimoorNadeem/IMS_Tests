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

public class DashboardPageTest extends TestBase {
	
	DashboardPage dashboardPage;
	BulkGuardPage bulkGuardPage;
	LoginPage loginPage;
	TestUtil testUtil;

	public DashboardPageTest() {
		super();
	}
	//Test Cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//After each Test Case -- close the browser
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		bulkGuardPage = new BulkGuardPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
	}
	
	@Test(priority=1)
	public void verifyDashboardTitleTest() {
		String title = dashboardPage.verifyDashboardPageTitle();
		Assert.assertEquals(title, "HAUD - Dashboard", "Dashboard Title is not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		String userName = dashboardPage.verifyUserName();
		Assert.assertEquals(userName, "QATEST.ADMIN@INTERNAL.HAUD");
	}
	
	@Test(priority=3)
	public void verfiyMinimizeAllButtonTest() {
		boolean minimizeAllBtnFlag = dashboardPage.verfiyMinimizeAllButton();
		Assert.assertTrue(minimizeAllBtnFlag);
	}
	
	@Test(priority=4)
	public void verfiyExpandAllButtonTest() {
		boolean expandAllBtnFlag = dashboardPage.verifyExpandAllButton();
		Assert.assertTrue(expandAllBtnFlag);
	}
	
	@Test(priority=5)
	public void verfiyReloadButtonTest() {
		boolean reloadBtnFlag = dashboardPage.verifyReloadButton();
		Assert.assertTrue(reloadBtnFlag);
	}
	
	@Test(priority=6)
	public void verifyaddNewDashboardTest() {
		boolean addDashboardFlag = dashboardPage.verifyAddNewDashboard();
		Assert.assertTrue(addDashboardFlag);
	}
	
	@Test(priority=7)
	public void verifyclickOnTrafficManagementIconTest() {
		bulkGuardPage = dashboardPage.clickOnTrafficManagementIcon();
		String title = dashboardPage.verifyTrafficManagementPageTitle();
		Assert.assertEquals(title, "HAUD - Traffic Management", "Traffic Management Title is not matched");	
	}
	@Test(priority=8)
	public void controlOnDashboardPage(){ 
		String isDashboardPage = dashboardPage.isDashboardPage(); 
		Assert.assertEquals(isDashboardPage,"http://192.168.14.159/dashboard"); }
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
