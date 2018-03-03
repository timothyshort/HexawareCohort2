package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountEnhanced {
	// Enhancements: multi-browser testing, algorithm utilities, intro to DDT with arrays
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		
		// Define variables
		String webUrl = "http://sdettraining.com/projects/";
		String browserType = "firefox";
		String name = "Matt";
		String email = "matt@sdettraining.com";
		String phoneNumber = "7897897897";
		String gender = "male";
		String password = "password";
		String country = "Australia";
		String accountText = "Account";
		boolean weeklyEmail = false;
		boolean monthlyEmail = true;
		boolean occasionalEmail = false;
		
		System.out.println("**TEST STARTING**");
		
		// Call a function from utilities.DriverFactory that returns a browser based on browserType parameter
		WebDriver driver = utilities.DriverFactory.start(browserType);
		
		// 2. Go to SDET Training projects page
		driver.get(webUrl);
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		
		// 3. Click on "Account Management System"
		Thread.sleep(1000);
		System.out.println("Clicking on AMS Application");
		driver.findElement(By.linkText("Account Management System")).click();
		
		// 4. Click on "Create Account" use xpath so as to not account for link text browser formatting
		Thread.sleep(1000);
		System.out.println("Clicking on Create Account link");
		driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();
		
		// 5. Fill out the New User form
		System.out.println("Filling out the new user form");
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(name);
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);
		driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys(phoneNumber);
		
		// Radio button
		if (gender.equalsIgnoreCase("male")) { driver.findElement(By.id("MainContent_Male")).click(); }
		else if (gender.equalsIgnoreCase("female")) { driver.findElement(By.id("MainContent_Female")).click(); }
		
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys(password);
		
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByValue(country);
		
		// Checkboxes
		// Call a function that selects, de-selects, or does nothing to a checkbox
		// Pass WebDriver, checkbox desired outcome, element
		utilities.Checkbox.choose(driver, weeklyEmail, By.id("MainContent_checkWeeklyEmail"));
		utilities.Checkbox.choose(driver, monthlyEmail, By.id("MainContent_checkMonthlyEmail"));
		utilities.Checkbox.choose(driver, occasionalEmail, By.id("MainContent_checkUpdates"));
		
		// Submit
		System.out.println("Clicking submit");
		/*
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		Thread.sleep(1000);
		
		String result = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println(result);
		
		*/
	
		// Add a wait, then close browser
		Thread.sleep(1000);
		driver.quit();
		
		System.out.println("**TEST COMPLETE**");
		long difference = System.currentTimeMillis() - startTime;
		System.out.println("DURATION: " + difference);
		
	}

}
