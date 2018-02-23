package basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartDemo {
	
	// Write a working script
	// Enhance with variables, logic, etc

	public static void main(String[] args) throws InterruptedException {
		String searchItem = "camera";
		int selectResult = 2;
		
		// 1. Initializing browser
		System.setProperty("webdriver.chrome.driver", "C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://sdettraining.com/online/default.asp");
		
		// 2. Search for a product (enter search item and click Go)
		driver.findElement(By.name("txtSearch")).sendKeys(searchItem);
		driver.findElement(By.id("Go")).click();
		
		// Verify that we see products in search results
		String searchResults = driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[" + selectResult + "]/td[2]")).getText();
		String itemPrice = driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[" + selectResult + "]/td[3]/font")).getText();
		if (!searchResults.toUpperCase().contains(searchItem.toUpperCase())) {
			System.out.println("FAIL: PRODUCT NOT CONTAINED IN SEARCH RESULT");
		}
		System.out.println(searchResults);
		System.out.println(itemPrice);
		
		// 3. View search results / add item to cart
		driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[" + selectResult + "]/td[3]/a")).click();
		
		// 4. View shopping cart / checkout
		String cartInfo = driver.findElement(By.xpath("/html/body/font/form/table")).getText();
		System.out.println(cartInfo);
		driver.findElement(By.cssSelector("input[name='cmdSubmit'][value='Proceed to Checkout']")).click();
		
		// 5. Checkout / enter information
		driver.findElement(By.cssSelector("input[value='Submit Order']")).click();
		
		// 6. Confirmation
		String confirmation = driver.findElement(By.xpath("html/body/font")).getText();
		
		// Use regular expression to extract order number
		String pattern = "Order# (.*) safe";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(confirmation);
		String confirmationNumber = null;
		if (m.find()) {
			confirmationNumber = m.group(1);
		}
		System.out.println("Confirmation #: " + confirmationNumber);
	}

}
