package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeStatic {
	
	// Static methods
	
	public static void clickLoanApp(WebDriver driver) {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[1]")).click();
	}
	
	public static void clickAccountManagement( WebDriver driver) {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
	}

}
