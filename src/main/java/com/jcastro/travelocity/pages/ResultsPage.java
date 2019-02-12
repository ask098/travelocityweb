package com.jcastro.travelocity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ResultsPage extends BasePage {

	public ResultsPage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="#sortDropdown")
	private WebElement sortBy;
	
	
	
	public void checkShortFilter() {
		
		for (int i = 1; i < 9; i++) {
			switch (i) {
			
			case 1: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(1)")).getText(),
						"Price (Lowest)",
						"Element");
				break;
				
			case 2: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(2)")).getText(),
						"Price (Highest)",
						"e");
				break;
				
			case 3: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(3)")).getText(),
						"Duration (Shortest)"
						);
				break;
			
			case 4: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(4)")).getText(),
						"Duration (Longest)"
						);
				break;
				
			case 5: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(5)")).getText(),
						"Departure (Earliest)"
						);
				break;	
				
			case 6: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(6)")).getText(),
						"Departure (Latest)"
						);
				break;
				
			case 7: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(7)")).getText(),
						"Arrival (Earliest)"
						);
				break;
				
			case 8: 
				Assert.assertEquals(driver.findElement(By.cssSelector("#sortDropdown > option:nth-child(8)")).getText(),
						"Arrival (Latest)"
						);
				break;
				
			default:
				
				break;
			}
			
		}
	}
}
