package com.jcastro.travelocity.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
/**
 * 
 * @author jc.castro
 *
 */
public class ResultsPage extends BasePage {

	public ResultsPage(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}
	
	//Web elements
	@FindBy(id="#sortDropdown")
	private WebElement sortBy;
	@FindBy (css="#flightModuleList button .btn-label span:first-child")
	private WebElement buttons;
	@FindBy (css="#flightModuleList .grid-container")
	private WebElement container;
	@FindBy (css="#flightModuleList .grid-container")
	private List<WebElement> resultList;
	@FindBy(css="#flightModuleList .grid-container button .btn-label span:first-child")
	private WebElement selectButton;
	@FindBy (css=".duration-emphasis")
	private WebElement duration;
	@FindBy (css="ssss")
	private WebElement baggageFee;
	@FindBy(id="sort-filter-drawer")
	private WebElement filterSection;
		
	
	/**
	 *  check options on sort filter 
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
	
	/**
	 * check option is present on result list
	 * @param option to check on result list
	 */
	public void checkElements(String option) {
		int indexResult =0;
		for (WebElement listResults : resultList) {
			
			switch (option) {
			case "Select":
				getWait().until(ExpectedConditions.elementToBeClickable(selectButton));
				indexResult++;
				Assert.assertEquals((listResults.findElement(By.cssSelector("#flightModuleList .grid-container button .btn-label span:first-child")).getText()),
						"Select",
						"Result #"+indexResult+" hasn't Select Button.");
				break;
			case "Duration":
//				getWait().until(ExpectedConditions.elementToBeClickable(duration));
				indexResult++;
				Assert.assertNotNull(listResults.findElement(By.cssSelector(".duration-emphasis")),
						"Result #"+indexResult+" hasn't duration.");
				break;
			case "Baggage":
				indexResult++;
				Assert.assertNotNull(listResults.findElement(By.cssSelector(".show-flight-details")),
						"Result #"+indexResult+" hasn't baggage fees option.");
				break;
			default:
				break;
			}	
		}
	}
	
	/**
	 * check options on the result page
	 */
	public void checkResultPage() {
		
		checkShortFilter();
		checkElements("Select");
		checkElements("Duration");
		checkElements("Baggage");
		sortByDuration();
		checkOrder();
		
	}
	
	/**
	 * selects Duration Shortest for list results
	 */
	public void sortByDuration() {
		
		Select dropDown = new Select(filterSection.findElement(By.id("sortDropdown")));
		dropDown.selectByValue("duration:asc");
		getWait().until(ExpectedConditions.elementToBeClickable(selectButton));
		checkOrder();
	}

	/**
	 * check results after be order by duration
	 */
	private void checkOrder() {

		for (WebElement listResults : resultList) {
			List<WebElement> datos = listResults.findElements(By.cssSelector(".duration-emphasis"));
			
			for (WebElement d : datos) {
				String s =d.getText();
				s= s.replaceAll("[^\\d.]", "");
				if(s.length()<3) {
					s=s+"0";
				}
			}
		}
	}
	

}
