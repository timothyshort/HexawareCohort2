package data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.DriverFactory;
import utilities.Excel;
import utilities.GlobalConfig;
import utilities.Screenshot;

public class NewAccountExcel {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = DriverFactory.start("chrome", GlobalConfig.AMS_URL);
		driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "getXLSData")
	public void registerWithExcel(String firstName, String lastName, String gender, String email,
			String password, String phoneNumber, String country,
			String weeklyEmail, String monthlyEmail, String occasionalEmail) throws InterruptedException {
		
		String name = firstName + " " + lastName;
		
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(name);
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);
		driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys(phoneNumber);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys(password);
		
		if (gender.equalsIgnoreCase("male")) { driver.findElement(By.id("MainContent_Male")).click(); }
		else if (gender.equalsIgnoreCase("female")) { driver.findElement(By.id("MainContent_Female")).click(); }
	
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country);
		
		utilities.Checkbox.choose(driver, weeklyEmail, By.id("MainContent_checkWeeklyEmail"));
		utilities.Checkbox.choose(driver, monthlyEmail, By.id("MainContent_checkMonthlyEmail"));
		utilities.Checkbox.choose(driver, occasionalEmail, By.id("MainContent_checkUpdates"));
		
		Thread.sleep(2000);
		// System.out.println("Clicking submit");
		// Assertions, Screenshot
	}
	
	@DataProvider
	public String[][] getXLSData() {
		return Excel.getXLS(GlobalConfig.TESTDATA_DIR + "NewAccountData_XLS.xls");
	}

}
