package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestFromIDE {
	
	public static void main(String[] args) {
		// 1. Initialize browser
		String path = "C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\Software\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
				
		// 2. Enter UI actions
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.id("MainContent_txtUserName")).clear();
	    driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@trpass");
	    driver.findElement(By.id("MainContent_txtPassword")).clear();
	    driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
	    driver.findElement(By.id("MainContent_btnLogin")).click();
	}

}
