package com.jcastro.travelocity.pages;

import java.time.LocalDate;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class MainPage extends BasePage {

	/**
	 * constructor
	 * @param driver to open the {@link browser}
	 * @param url access to the page
	 */
	
	public MainPage(WebDriver driver, String url) {
		super(driver);
		driver.get(url);
	}
	
	@FindBy(id="tab-flight-tab-hp")
	private WebElement flightsButton;
	@FindBy(id="flight-type-roundtrip-label-hp-flight")
	private WebElement roundtripOption;
	@FindBy(id="flight-origin-hp-flight")
	private WebElement flightOrigin;
	@FindBy(id="flight-destination-hp-flight")
	private WebElement flightDestination;
	@FindBy(id="flight-departing-hp-flight")
	private WebElement departingCalendar;
	@FindBy(id="flight-returning-hp-flight")
	private WebElement returningCalendar;
	@FindBy(css="button.datepicker-next")
	private WebElement nextMonthCalendarButtton;
	@FindBy(css=".datepicker-cal-dates")
	private WebElement calendar;
	@FindBy(css="#gcw-flights-form-hp-flight label button")
	private WebElement searchButton;
	List<WebElement> daysOfMonth;

	
	public void searchFlight() {
		
		selectFlightOption();
		completeDestinationAndOrigin();
		completeCalendar();
		completeDropDown();	
	}
	
	public void selectFlightOption() {
		
		flightsButton.click();
		roundtripOption.click();
	}
	
	public void completeDestinationAndOrigin() {
		flightOrigin.click(); flightOrigin.sendKeys("LAS");
		flightDestination.click(); flightDestination.sendKeys("LAX");
	}
	
	public void completeCalendar() {

		clickDeparture();
		clickReturn();
	}
	
	public void clearField(){
		
		String os = System.getProperty("os.name");
		if (os.equals("WINDOWS")){
			returningCalendar.sendKeys(Keys.CONTROL + "a");
			returningCalendar.sendKeys(Keys.DELETE);
		}else{
			for (int i = 0; i < 10; i++) {
				returningCalendar.click();
				returningCalendar.sendKeys(Keys.BACK_SPACE);
			}			
		}
	}

	public void clickDeparture() {
		
		int day = LocalDate.now().plusDays(2).getDayOfMonth();
		departingCalendar.click();
		getWait().until(ExpectedConditions.elementToBeClickable(nextMonthCalendarButtton));
		nextMonthCalendarButtton.click();

		daysOfMonth = calendar.findElements(By.cssSelector(".datepicker-cal-weeks .datepicker-cal-dates > tr > td > button[data-day]"));
		for(WebElement cell:daysOfMonth) {
			String calendarDay = cell.getText().substring((cell.getText().length() - 2)).trim();
			if(calendarDay.equals(Integer.toString(day))) {
				cell.click();
				break;
			}
		}
	}
	
	
	public void clickReturn() {
		returningCalendar.click();
		clearField();
		int day = LocalDate.now().plusDays(4).getDayOfMonth();
		daysOfMonth = calendar.findElements(By.cssSelector(".datepicker-cal-weeks .datepicker-cal-dates > tr > td > button[data-day]"));
		for(WebElement cell:daysOfMonth) {
			String calendarDay = cell.getText().substring((cell.getText().length() - 2)).trim();
			if(calendarDay.equals(Integer.toString(day))) {
				cell.click();
				break;
			}
		}
	}
	
	public void completeDropDown() {
		
		Select dropDownAdults = new Select(getDriver().findElement(By.id("flight-adults-hp-flight")));
		dropDownAdults.selectByValue("1");
	}
	
	public ResultsPage clickOnSearchButton() {
		getWait().until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		return new ResultsPage(getDriver());
	}
	
	public ResultsPage clickSearchFligthButton(){
		
		clickOnSearchButton();
		return new ResultsPage(driver); 
	}
	
}