package utilities;

import org.openqa.selenium.WebDriver;

public class WindowHandling {
	
	public static void chooseWindowByTitle(WebDriver driver, String expectedPageTitle) {
		for(String window : driver.getWindowHandles()) {
			if (driver.switchTo().window(window).getTitle().contains(expectedPageTitle)) {
				System.out.println("Switching window");
				break;
			}
		}
	}
	
	// Handles either a Confirm or Alert Javascript popup
	public static void alert(WebDriver driver, boolean alertDecision, int waitInMs) throws InterruptedException {
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(waitInMs);
		
		if (alertDecision) {
			driver.switchTo().alert().accept();
			System.out.println(" ACCEPT/CONFIRM");
		}
		else {
			driver.switchTo().alert().dismiss();
			System.out.println(" DISMISS/DENY");
		}
	}

}
