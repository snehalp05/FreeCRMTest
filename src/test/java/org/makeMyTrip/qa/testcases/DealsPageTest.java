package org.makeMyTrip.qa.testcases;

import org.makeMyTrip.qa.base.TestBase;
import org.makeMyTrip.qa.pages.ContactsPage;
import org.makeMyTrip.qa.pages.DealsPage;
import org.makeMyTrip.qa.pages.HomePage;
import org.makeMyTrip.qa.pages.LoginPage;
import org.makeMyTrip.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DealsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage=homePage.verifyDealsLink();
	}
	
/*	@Test
	public void verifyDealsPageLabel() {
		String label=dealsPage.verifyDealsPageLabel();
		Assert.assertEquals(label, "Deals", "Deals Page Label doesnot match");
	}
	
	@Test
	public void verifyNewDealLink() {
		boolean b=dealsPage.clickNewDealLink();
		Assert.assertTrue(b);
	}*/
	
	@DataProvider
	public Object[][] getDataFromExcel() {
		Object data[][]=TestUtil.getTestData("Sheet1");
		return data;
	}
	
	@Test(dataProvider="getDataFromExcel")
	public void verifyCreateNewDeal(String Title, String Date, String Description, String Amount, String Comission) {
		dealsPage.createNewDeal("Sneha patil","Quote","Priority","Online",Title,Date,Description,Amount,Comission);
		homePage.verifyDealsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
