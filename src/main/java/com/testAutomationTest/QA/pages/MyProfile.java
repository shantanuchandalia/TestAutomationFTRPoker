package com.testAutomationTest.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testAutomationTest.QA.base.TestBase;

public class MyProfile extends TestBase {
	
	public MyProfile()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getMyProfileTitle()
	{
		System.out.println(driver.getCurrentUrl());
		return driver.getTitle();
	}
	
	
	
}
