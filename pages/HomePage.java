package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	// Define page web elements
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/a[1]")
	WebElement loanAppLink;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/a[2]")
	WebElement accountManagementLink;
	
	// Constructor function to initialize driver and elements
	public HomePage(WebDriver driver) {
		System.out.println("Creating new home page object");
		// Initialize web elements and bind to the driver instance
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoanApp() {
		loanAppLink.click();
	}
	
	public void clickAccountManagement() {
		accountManagementLink.click();
	}

}
