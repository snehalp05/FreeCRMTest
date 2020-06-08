package org.makeMyTrip.qa.pages;

import org.makeMyTrip.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class ContactsPage extends TestBase {
	
	
	
	@FindBy(xpath="//div[@id=\"dashboard-toolbar\"]/div")
	WebElement contactsPageTitlePath;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyContactsPageLabel() {
		String name=contactsPageTitlePath.getText();
		return name;
	}
	
	public void selectContact(String name) {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr//descendant::input[@name='id']"))).click().build().perform();
		//selectContact.click();
	}

}
