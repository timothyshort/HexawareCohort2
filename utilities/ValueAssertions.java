package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValueAssertions {
	
	public static void contains(WebDriver driver, By element, String expectedValue) {
		
		System.out.print("Assertion checkpoint " + element.toString());
		String actualValue = driver.findElement(element).getText();
		if (actualValue.contains(expectedValue)) {
			System.out.println(" : PASSED");
		}
		else {
			System.out.println(" : FAILED");
		}
	}

}
