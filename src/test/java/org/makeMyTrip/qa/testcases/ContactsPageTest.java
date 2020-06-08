package org.makeMyTrip.qa.testcases;

import org.makeMyTrip.qa.base.TestBase;
import org.makeMyTrip.qa.pages.ContactsPage;
import org.makeMyTrip.qa.pages.HomePage;
import org.makeMyTrip.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.verifyContactsLink();
	}

	@Test
	public void verifyContactsPageLabel() {
		String title=contactsPage.verifyContactsPageLabel();
		Assert.assertEquals(title, "Contacts", "COntacts Page label is not displayed");
	} 
	
	@Test
	public void selectContactTest() {
		contactsPage.selectContact("Tanay Rode");
		contactsPage.selectContact("Shailesh Rode");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
