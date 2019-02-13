package com.jcastro.travelocity.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.jcastro.travelocity.MyDriver;
import com.jcastro.travelocity.pages.MainPage;

public class BaseTest {

	MyDriver myDriver;
	
	public MainPage home;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser","url"})
	public void beforeSuite(String driver, String url) {
		myDriver = new MyDriver(driver);
		home = new MainPage(myDriver.getDriver(), url);
	}
	
	/**
	 * close the browser's window
	 */
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		home.dispose();
//    String base = driver.getWindowHandle();
//
//    Set <String> set = driver.getWindowHandles();
//
//    set.remove(base);
//    assert set.size()==1;
//
//    driver.switchTo().window(set.toArray(new String[0]));
//
//    driver.close();
//    driver.switchTo().window(base);
	}
	
	public MainPage getHomePage() {
		return home;
	}

}