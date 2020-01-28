package com.testAutomationTest.QA.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testAutomationTest.QA.base.TestBase;
import com.testAutomationTest.QA.pages.Balance;
import com.testAutomationTest.QA.pages.LoginPage;

public class LoginTest extends TestBase{
	LoginPage lp;
	Balance bal;
	
	// to initialize the base class constructor -- to initialize properties
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		lp = new LoginPage();
	}
	
	@Test(priority = 1)
	public void LoginPageTitleCheck()
	{
		Assert.assertEquals(lp.validateLoginPage(), "Player Login");
	}
	
	@Test(priority = 2)
	public void LoginPageUserLogin()
	{
		bal= lp.Userlogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
