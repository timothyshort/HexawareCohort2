package tests;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.AccountManagementPage;
import pages.HomePage;
import utilities.DriverFactory;
import utilities.GlobalConfig;
import utilities.Screenshot;

public class LoginAppTest extends BaseTest {
	
	@Before
	public void setup() {
		// Configure the logger object
		log = Logger.getLogger("LoginAppTest");
		DOMConfigurator.configure("loggerConfig.xml");
				
		log.info("STARTING LOGIN APP TEST");
		System.out.println("STARTING TEST");
		driver = DriverFactory.start("headless", GlobalConfig.ROOTURL);
		log.info("OPENING CHROME BROWSER");
	}
	
	@After
	public void tearDown() {
		driver.quit();
		log.info("TEARING DOWN TEST");
	}
	
	// Using Page Object Model with Page Factory
	@Test
	public void loginTest() {
		// Create the HomePage object
		log.info("USER IS ON HOME PAGE");
		printLinkTags("Home Page");
		HomePage home = new HomePage(driver);
		home.clickAccountManagement();
		
		log.info("UESR IS ON ACCOUNT MANAGEMENT PAGE");
		printLinkTags("Account Management Page");
		AccountManagementPage ams = new AccountManagementPage(driver);
		ams.doLogin("tim@testemail.com", "password");
		
		log.info("USER IS ON DASHBOARD PAGE");
		printLinkTags("Dashboard Page");
		pageInfo("Dashboard Page");
		System.out.println("ENDING TEST");
	}
	
	/*
	// Using page classes as utility functions (Page Object Model)
	@Test
	public void loginTestStatic() {
		WebDriver driver = DriverFactory.start("chrome", GlobalConfig.ROOTURL);
		
		// 1. Landing Page
		HomeStatic.clickAccountManagement(driver);
		
		// 2. AMS Page
		AccountManagementPage.typeUsername(driver, "tim@testemail.com");
		AccountManagementPage.typePassword(driver, "password");
		AccountManagementPage.clickLogin(driver);
		
		// 3. Dashboard Page
	}
	*/

}
