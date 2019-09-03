package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	//define locators OR- with By locator-NPF
	
	By emailID = By.id("username");
	By password =By.id("password");
	By loginButton = By.id("loginBtn");
	
	//constructor of page class:
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	
	//page action:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void doLogin(String username,String pwd) { 
		driver.findElement(emailID).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}