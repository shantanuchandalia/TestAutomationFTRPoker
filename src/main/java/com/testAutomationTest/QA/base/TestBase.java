package com.testAutomationTest.QA.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.testAutomationTest.QA.util.TestUtil;
import com.testAutomationTest.QA.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new  FileInputStream("D:\\RestAPIWorkSpace\\testAutomationTest\\src\\main\\java\\com\\testAutomationTest\\QA\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		String chromePath = "C:\\Users\\shantanu\\eclipse-workspace\\TestAutomationFTRPoker\\src\\main\\java\\com\\testAutomationTest\\QA\\config\\chromedriver.exe";
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", chromePath );
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
}
