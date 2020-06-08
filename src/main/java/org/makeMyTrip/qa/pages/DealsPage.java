package org.makeMyTrip.qa.pages;

import org.makeMyTrip.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends TestBase {
	
	
	@FindBy(xpath="//div[@class='ui fluid container']//descendant::div[text()='Deals']")
	WebElement dealsLabel;
	
	@FindBy(xpath="//a/button[text()='New']")
	WebElement newDealButton;
	
	@FindBy(xpath="//div[@class='ui fluid container']//descendant::div[text()='Create new Deal']")
	WebElement createNewDealLabel;
	
	@FindBy(name="title")
	WebElement title;
	@FindBy(xpath="//div[@role='listbox' and @class='ui fluid selection dropdown']")
	WebElement assignedTo;
	
	@FindBy(className="calendarField") ////input[@class='calendarField']
	WebElement date;
	@FindBy(name="description")
	WebElement description;
	@FindBy(name="amount")
	WebElement amount;
	@FindBy(name="commission")
	WebElement commission;
	
	@FindBy(name="stage")
	WebElement stage;
	
	@FindBy(name="type")
	WebElement type;
	
	@FindBy(name="source")
	WebElement source;
	
	@FindBy(xpath="//div/button[text()='Save']")
	WebElement save;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyDealsPageLabel() {
		String label=dealsLabel.getText();
		return label;
	}
	
	public boolean clickNewDealLink() {
		newDealButton.click();
		boolean b=createNewDealLabel.isDisplayed();
		return b;
	}
	
	public void createNewDeal(String assignToName,String stageName,String typeName, String sourceName, String Title,String Date, String Description, String Amount, String Comission) {
		clickNewDealLink();
		title.sendKeys(Title);
		assignedTo.click();
		driver.findElement(By.xpath("//div[@role='listbox' and @class='ui active visible fluid selection dropdown']"
				+ "//descendant::span[text()='"+assignToName+"']")).click();
		
		date.sendKeys(Date);
		description.sendKeys(Description);
		amount.sendKeys(Amount);
		commission.sendKeys(Comission);
		
		stage.click();
		driver.findElement(By.xpath("//span[text()='"+stageName+"']")).click();		
		
		type.click();		
		driver.findElement(By.xpath("//span[text()='"+typeName+"']")).click();
		
		source.click();
		driver.findElement(By.xpath("//span[text()='"+sourceName+"']")).click();
		
		save.click();
		
	}

}
