Switch to the Accessible Version of Box ›
Search Files and Folders


Get More Storage



0

All Files
Recents
Synced
Trash
Notes
Admin Console
Favorites

Drag items here for quick access
© 2019 Box Inc.
All Files
⋯
qa
hubspot

util

Upload

Sharing

Details
Naveen Khunteta
Owner

shalu.sandy@gmail.com
Viewer


bhavanathakur1307@gmail.com
Pending

vidya.pisati@gmail.com
Pending

veergadde@gmail.com
Pending

+144 People
Share this Folder

V1
ElementUtil.java
util
·
Updated Sep 5, 2019 by Naveen Khunteta


Open
Download
Share
✕
package com.qa.hubspot.util;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;

public class ElementUtil extends BasePage {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		waitForElementPresent(locator);

		WebElement element = null;
		try {
			element = driver.findElement(locator);
			if (flash.equalsIgnoreCase("yes")) {
				JavaScriptUtil.flash(element, driver);
			}
		} catch (Exception e) {
			System.out.println("Some exception occurred while creating webelement " + locator);
		}
		return element;
	}

	public void waitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some exception occurred while clicking on webelement " + locator);
		}
	}

	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some exception occurred while sending to webelement " + locator);
		}
	}

	public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("Some exception occurred while sending to webelement " + locator);
		}
		return text;
	}

	public String waitForPageTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Some exception occurred while checking webelement displayed " + locator);
			return false;
		}
	}

}




