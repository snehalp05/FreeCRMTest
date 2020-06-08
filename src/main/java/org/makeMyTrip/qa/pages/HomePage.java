package org.makeMyTrip.qa.pages;

import org.makeMyTrip.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement nameLabel;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[text()='Deals']")
	WebElement dealsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyUserLabel() {
		String name=nameLabel.getText();
		return name;
	}
	
	public ContactsPage verifyContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage verifyDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
}
