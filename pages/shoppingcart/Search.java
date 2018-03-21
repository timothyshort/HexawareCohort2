package pages.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"btnApple_Iphone_6.jpg\"]")
	WebElement productButton;
	
	public Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addItemToCart() {
		System.out.println("Add item to cart");
		productButton.click();
	}
	
	public void searchItem(String product) {
		System.out.println("Searching for: " + product);
	}

}
