package com.jcastro.travelocity.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jcastro.travelocity.pages.MainPage;
import com.jcastro.travelocity.pages.ResultsPage;

public class MainTest extends BaseTest {

	

	@BeforeMethod(alwaysRun = true)
	@Parameters({"url"})
	private void loadPage(String url){
		myDriver.getDriver().get(url);
	}
	
	@Test
	public void Search() {
		MainPage mainpage = getHomePage();
		 mainpage.searchFlight();
		 ResultsPage resultPage = mainpage.clickSearchFligthButton();
		 resultPage.checkResultPage();
	}
	
	

}
