package com.jcastro.travelocity.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jcastro.travelocity.pages.MainPage;

public class MainTest extends BaseTest {

	private MainPage home;

	@BeforeMethod(alwaysRun = true)
	@Parameters({"url"})
	private void loadPage(String url){
		myDriver.getDriver().get(url);
	}
	
	@Test
	public void Search() {
		home = getHomePage();
		home.searchFlight();
	}
	
	

}
