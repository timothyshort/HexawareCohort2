package basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.DriverFactory;

public class DatePickerExpedia {
	WebDriver driver;
	String flightFrom = "Chicago, IL";
	String flightTo = "Miami, FL";
	
	// String date = "January 10, 2019";
	// String date = "1/10/2019";
	String dataMonth = "Jun";
	String dataDay = "18";
	String dataYear = "2018";
	
	int dateMonth = monthToNumber(dataMonth);
	int dateDay = Integer.parseInt(dataDay);
	int dateYear = Integer.parseInt(dataYear);
	
	@BeforeMethod
	public void setup() {
		driver = DriverFactory.start("chrome", "https://www.expedia.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void expediaTest() throws InterruptedException {
		
		// 1. Click on flights tab
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		
		// 2. Enter origin and destination location
		driver.findElement(By.id("flight-origin-hp-flight")).sendKeys(flightFrom);
		driver.findElement(By.id("flight-destination-hp-flight")).sendKeys(flightTo);
		
		// 3. Enter departing date
		Thread.sleep(1000);
		driver.findElement(By.id("flight-departing-hp-flight")).click();
		String departingRootXPath = "//*[@id=\"flight-departing-wrapper-hp-flight\"]";
		String departingMonthXPath = "/div/div/div[2]/table";
		
		// Capture current calendar on web application
		String currentDate = driver.findElement(By.xpath(departingRootXPath + departingMonthXPath + "/caption")).getText();
		String currentMonth = currentDate.substring(0, 3);
		int currentYear = Integer.parseInt(currentDate.substring(4));
		int currentMonthNum = monthToNumber(currentMonth);
		System.out.println("Current Month: " + currentDate + " (" + currentMonthNum + ")");
		System.out.println("Desired Month: " + dataMonth + " (" + dateMonth + ")");
		
		// Determine if we need to advance months
		int monthsAdvance = dateMonth - currentMonthNum;
		if (dateYear > currentYear) {
			monthsAdvance += 12;
		}
		System.out.println("Advancing " + monthsAdvance + " months");
		
		// Clicking "next month"
		for (int i = 0; i < monthsAdvance; i++) {
			driver.findElement(By.className("datepicker-next")).click();
		}
		
		// Clicking "day"
		List<WebElement> days = driver.findElements(By.className("datepicker-day-number"));
		days.get(dateDay-1).click();
		/*
		for (WebElement day : days) {
			System.out.println("Day: " + day.getText());
		}
		*/
		
		Thread.sleep(4000);
	}
	
	public int monthToNumber(String month) {
		switch (month) {
			case "Jan" : return 1;
			case "Feb" : return 2;
			case "Mar" : return 3;
			case "Apr" : return 4;
			case "May" : return 5;
			case "Jun" : return 6;
			case "Jul" : return 7;
			case "Aug" : return 8;
			case "Sep" : return 9;
			case "Oct" : return 10;
			case "Nov" : return 11;
			default : return 12;
		}
	}

}
