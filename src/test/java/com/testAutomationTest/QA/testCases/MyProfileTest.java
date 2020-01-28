package com.testAutomationTest.QA.testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.testAutomationTest.QA.base.TestBase;
import com.testAutomationTest.QA.pages.Balance;
import com.testAutomationTest.QA.pages.LoginPage;
import com.testAutomationTest.QA.pages.MyProfile;

public class MyProfileTest extends TestBase{
	LoginPage lp;
	Balance bal;
	MyProfile myprofile;
	
	public MyProfileTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		lp = new LoginPage();
		bal = lp.Userlogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofile = bal.navigateToMyProfile();
	}
	
	@Test
	public void VerifyMyProfileTitle()
	{
		Assert.assertFalse(myprofile.getMyProfileTitle().isEmpty());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
