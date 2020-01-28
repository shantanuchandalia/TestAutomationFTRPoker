package com.testAutomationTest.QA.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testAutomationTest.QA.base.TestBase;
import com.testAutomationTest.QA.pages.Balance;
import com.testAutomationTest.QA.pages.LoginPage;

public class BalanceTest extends TestBase{

	LoginPage lp;
	Balance bal;
	
	public BalanceTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		lp = new LoginPage();
		bal = lp.Userlogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority =1)
	public void checkUserNameonBalance()
	{
		Assert.assertTrue(bal.checkUserName_On_WelcomeMessage(), "Username Label not present!");
	}
	
	@Test(priority =2)
	public void checkforCorrectUsername()
	{
		Assert.assertEquals(bal.getUserNAme_on_WelcomeMessage().toLowerCase(), prop.getProperty("username"));
	}
	
	@Test(priority =3)
	public void verifyAvailableAmount()
	{
		Assert.assertTrue(bal.getAvailableAmount().contains("0.00"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
