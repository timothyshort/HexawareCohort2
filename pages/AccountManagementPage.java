package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountManagementPage {
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")
	WebElement createAccountBtn;
	
	@FindBy(id = "MainContent_txtUserName")
	WebElement usernameTextBox;
	
	@FindBy(id = "MainContent_txtPassword")
	WebElement passwordTextBox;
	
	@FindBy(id = "MainContent_btnLogin")
	WebElement loginBtn;
	
	public AccountManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateAccount() {
		createAccountBtn.click();
	}
	
	public void typeUsername(String email) {
		usernameTextBox.sendKeys(email);
	}
	
	public void typePassword(String password) {
		passwordTextBox.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void doLogin(String username, String password) {
		typeUsername(username);
		typePassword(password);
		clickLogin();
	}

}
