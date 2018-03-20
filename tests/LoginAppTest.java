package tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.AccountManagementPage;
import pages.HomePage;
import utilities.DriverFactory;
import utilities.GlobalConfig;

public class LoginAppTest extends BaseTest {
	
	@Before
	public void setup() {
		System.out.println("STARTING TEST");
		driver = DriverFactory.start("chrome", GlobalConfig.ROOTURL);
	}
	
	@Test
	public void loginTest() {
		// Create the HomePage object
		printLinkTags("Home Page");
		HomePage home = new HomePage(driver);
		home.clickAccountManagement();
		
		printLinkTags("Account Management Page");
		AccountManagementPage ams = new AccountManagementPage(driver);
		ams.doLogin("tim@testemail.com", "password");
		
		printLinkTags("Dashboard Page");
		pageInfo("Dashboard Page");
		System.out.println("ENDING TEST");
	}
	
	/*
	@Ignore
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
