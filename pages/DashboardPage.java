package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	public static void clickChangePassword(WebDriver driver) {
		driver.findElement(By.linkText("Change password")).click();
	}
	
	public static void clickUpdateSubscriptions(WebDriver driver) {
		driver.findElement(By.linkText("Updated subscriptions")).click();
	}
	
	public static void clickCancelAccount(WebDriver driver) {
		driver.findElement(By.linkText("Cancel account")).click();
	}

}
