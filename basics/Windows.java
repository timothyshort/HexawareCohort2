package basics;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;
import utilities.WindowHandling;

public class Windows {
	WebDriver driver;	
	
	@Before
	public void setup() {
		driver = DriverFactory.start("chrome", "http://sdettraining.com/projects/windows.html");
	}
	
	@Test
	public void windowHandlingTest() {				
		// 1. Click on Create Account (opens new window)
		driver.findElement(By.linkText("Create Account".toUpperCase())).click();
		
		/*
		// Identify current window
		String mainWindow = driver.getWindowHandle();
		
		// Iterate through existing windows
		for(String win : driver.getWindowHandles()) {
			driver.switchTo().window(win);
			System.out.println("Window: " + driver.getTitle() + " " + driver.getCurrentUrl());
		}
		
		// Create a data structure that holds all existing windows
		ArrayList<String> openWindows = new ArrayList<String>(driver.getWindowHandles());
		
		// Manually choose which window to switch to
		driver.switchTo().window(mainWindow);
		driver.switchTo().window(openWindows.get(1));
		
		// Choose by design: iterate through open windows and exit when desired condition is true
		for(String window : openWindows) {
			if (driver.switchTo().window(window).getTitle().contains("Account Management")) {
				break;
			}
		}
		*/
		
		// Call utility function to change window
		WindowHandling.chooseWindowByTitle(driver, "Freddie");
		System.out.println("Current Window: " + driver.getTitle());
		
		// 2. Click Create Account (to registration form)
		// driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();
		// Finishing filling out form
	}
	
	@Ignore
	@Test
	public void popHandlingTest() throws InterruptedException {
		boolean deleteAccount = true;
		
		// Click Delete Account
		driver.findElement(By.id("delete_account")).click();
		
		/*
		// Confirm delete account?
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Thread.sleep(1000);
		
		if (deleteAccount) {
			driver.switchTo().alert().accept();
			System.out.println(" ACCEPT/CONFIRM");
		}
		else {
			driver.switchTo().alert().dismiss();
			System.out.println(" DISMISS/DENY");
		}
		
		System.out.println("RESULT: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		*/
		
		WindowHandling.alert(driver, false, 1500); // Confirm delete?
		WindowHandling.alert(driver, true, 500); // Alert / continue
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
}
