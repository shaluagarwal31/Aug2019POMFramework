package com.qa.hubspot.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	/**
	 * method is used to initialize drriver on basis of given browser
	 * @return this method returns webdriver instance
	 */
	
	public WebDriver initialize_driver(Properties prop) {
	//String browser="chrome";
	String browser=prop.getProperty("browser");
	
	if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
	}
	else if(browser.equals("firefox")) {
		WebDriverManager.chromedriver().setup();
		driver= new FirefoxDriver();
}
	driver.manage().window().fullscreen();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get("https://app.hubspot.com/login");
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	return driver;
}
/**
 * this method is used to define properties
 * 
 * @return this method returns properties prop reference
 */
		
	public Properties initialize_properties() {
		
		prop=new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\Sundr\\eclipse-workspace\\MYJuly2019POMSeries"
					+ "/src\\main\\java\\cofig\\qa\\hubspot\\config\\cofig.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch(IOException e)	{
			e.printStackTrace();
		}
		
		return prop;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}