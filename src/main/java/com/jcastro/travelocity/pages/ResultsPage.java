package com.jcastro.travelocity.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ResultsPage extends BasePage {

	public ResultsPage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="#sortDropdown")
	private WebElement sortBy;
	
	@FindBy (css="#flightModuleList button .btn-label span:first-child")
	private WebElement buttons;
	
	@FindBy (css=".grid-container.standard-padding")
	private WebElement container;
	
	@FindBy (css="#flightModuleList .grid-container")
	private List<WebElement> resultList;
	
	@FindBy(css="#flightModuleList .grid-container button .btn-label span:first-child")
	private WebElement selectButton;
	
	@FindBy (css=".duration-emphasis")
	private WebElement duration;
	
	/**
	 *  check order by price 
	 *  select button pressent on every result
	 *  fligth detail and baggage fee pressent
	 */
	
	public void checkShortFilter() {
		
		for (int i = 1; i < 9; i++) {
			switch (i) {
			
			case 1: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(1)")).getText(),
						"Price (Lowest)",
						"Element price lowest is not present or has changed");
				break;
				
			case 2: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(2)")).getText(),
						"Price (Highest)",
						"Element price higest is not present or has changed");
				break;
				
			case 3: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(3)")).getText(),
						"Duration (Shortest)",
						"Element Duration shortest is not present or has changed");
				break;
			
			case 4: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(4)")).getText(),
						"Duration (Longest)",
						"Element Duration longest is not present or has changed");
				break;
				
			case 5: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(5)")).getText(),
						"Departure (Earliest)",
						"Element departure earliest is not present or has changed");
				break;	
				
			case 6: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(6)")).getText(),
						"Departure (Latest)",
						"Element departure latest is not present or has changed");
				break;
				
			case 7: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(7)")).getText(),
						"Arrival (Earliest)",
						"Element arrival earliest is not present or has changed");
				break;
				
			case 8: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(8)")).getText(),
						"Arrival (Latest)",
						"Element arrival latest is not present or has changed");
				break;
			}
		}
	}
	
	public void checkSelectButton() {
		int indexResult =0;
		getWait().until(ExpectedConditions.elementToBeClickable(selectButton));
		for (WebElement listResults : resultList) {
			indexResult++;
			Assert.assertEquals((listResults.findElement(By.cssSelector("#flightModuleList .grid-container button .btn-label span:first-child")).getText()),
					"Select",
					"Result #"+indexResult+" hasn't Select Button.");
		}
	}
	
	
	public void checkDuraton() {
		
	}
	
	public void checkResultPage() {
		
		checkSelectButton();
		checkShortFilter();
	}
}

