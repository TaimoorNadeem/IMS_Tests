package com.NForce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.NForce.qa.base.TestBase;
import com.NForce.qa.pages.BulkGuardPage;
import com.NForce.qa.pages.DashboardPage;
import com.NForce.qa.pages.HardBlockGTPage;
import com.NForce.qa.pages.LoginPage;
import com.NForce.qa.util.TestUtil;

public class HardBlockGTPageTest extends TestBase {
	
	DashboardPage dashboardPage;
	BulkGuardPage bulkGuardPage;
	LoginPage loginPage;
	TestUtil testUtil;
	HardBlockGTPage hardBlockGtPage;
	String sheetName = "hbgt";
	
	public HardBlockGTPageTest() {
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
			hardBlockGtPage = new HardBlockGTPage();
			dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			bulkGuardPage = dashboardPage.clickOnTrafficManagementIcon();
			hardBlockGtPage = hardBlockGtPage.clickOnHardBlockGTPage();
			Thread.sleep(10000);
		}
		
		@Test(priority=1)
		public void verifyIsHardBlockGtPageTest() {
			String label = hardBlockGtPage.verifyHardBlockGtLabel();
			Assert.assertEquals(label, "HardBlock GT", "HardBlock Label is missing on the page");
		}
		
		@Test(priority=2)
		public void verifyisHardBlockGtPageTest() {
			String url = hardBlockGtPage.isHardBlockGtPage();
			Assert.assertEquals(url, "http://192.168.14.159/control/hbgt/green", "Page URL is not correct");
		}
		
		@DataProvider
		public Object[][] getIMSTestData() throws Exception {
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
		}
		
		@Test(priority=3, dataProvider="getIMSTestData")
		public void validateAddNewParameterTest(String callingGt, String notesProvided) {
			hardBlockGtPage.createNewHbgtParameter(callingGt, notesProvided);
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

}
