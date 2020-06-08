package org.makeMyTrip.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.makeMyTrip.qa.base.TestBase;
import org.makeMyTrip.qa.pages.HomePage;
import org.makeMyTrip.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
		public LoginPageTest() {
			super();
		}
		
		@BeforeMethod
		public void setup() {
			initialization();
			loginPage=new LoginPage();
		}
		
		@Test
		public void loginPageTitleTest() {
			String title=loginPage.validateLoginPageTitle();
			Assert.assertEquals(title, "Cogmento CRM");
		}
		
		@Test
		public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		}
			
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		

}
