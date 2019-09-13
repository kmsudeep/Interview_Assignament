package com.assignment.basetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.assignemnt.constants.Definitions;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase()
	{
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(Definitions.Config_Path);
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
			System.setProperty(Definitions.chrome_driver,Definitions.chrome_path );
			driver = new ChromeDriver();
		}
		
		else if(browser.equals("firefox"))
		{
			System.setProperty(Definitions.firefox_driver,Definitions.firefox_path);
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Definitions.Page_Load, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Definitions.implicit_wait, TimeUnit.SECONDS);
		
	}
}
