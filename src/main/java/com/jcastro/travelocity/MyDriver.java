package com.jcastro.travelocity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
	
	private WebDriver driver;
	
	/**
	 * constructor
	 * @param browser
	 */
	public MyDriver(String browser) {
		switch (browser) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			driver = new ChromeDriver();
			break;
		default:
			break;
		}
	}
	/**
	 * 
	 * @return driver 
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

}