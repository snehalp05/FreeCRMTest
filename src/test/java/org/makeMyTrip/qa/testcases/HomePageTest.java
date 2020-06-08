package org.makeMyTrip.qa.testcases;

import org.makeMyTrip.qa.base.TestBase;
import org.makeMyTrip.qa.pages.ContactsPage;
import org.makeMyTrip.qa.pages.DealsPage;
import org.makeMyTrip.qa.pages.HomePage;
import org.makeMyTrip.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		String title=homePage.homePageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "Home Page title doesnt match");
	}
	
	@Test
	public void verifyUserLabelTest() {
		String name=homePage.verifyUserLabel();
		Assert.assertEquals(name, "Sneha patil");
	}
	
	@Test
	public void verifyContactsLinkTest() {
		contactsPage=homePage.verifyContactsLink();
		
	}
	@Test
	public void verifyDealsLinkTest() {
		dealsPage=homePage.verifyDealsLink();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
