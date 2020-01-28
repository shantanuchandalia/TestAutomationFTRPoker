package com.testAutomationTest.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testAutomationTest.QA.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id="login")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="button_login")
	WebElement login;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPage()
	{
		return driver.getTitle();
	}
	
	public Balance Userlogin(String u, String p)
	{		
		username.sendKeys(u);
		password.sendKeys(p);
		login.click();
		
		return new Balance();
	}
	
	//landing
	
	
}
