package com.testAutomationTest.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testAutomationTest.QA.base.TestBase;

public class Balance extends TestBase {

	@FindBy(xpath="//*[@title=\"Doco\"]")	
	WebElement WelcomeMessage_username;
	
	@FindBy(xpath ="//table[@id='money_balance_table']//td[@class='money text-nowrap']/span")
	WebElement AvailableBalance;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/ul/li[4]/a")
	WebElement MyProfileLabel;
	
	public Balance()
	{
		PageFactory.initElements(driver, this);
	}
	
	public  Boolean checkUserName_On_WelcomeMessage()
	{
		
		return WelcomeMessage_username.isDisplayed();
	}
	
	public  String getUserNAme_on_WelcomeMessage()
	{
		return WelcomeMessage_username.getText();
	}
	
	public String getAvailableAmount()
	{
		return AvailableBalance.getText();
	}
	
	public MyProfile navigateToMyProfile()
	{
		return new MyProfile();
	}
}
