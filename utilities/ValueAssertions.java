package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValueAssertions {
	
	public static void contains(WebDriver driver, By element, String expectedValue) {
		System.out.print("Assertion checkpoint " + element.toString());
		System.out.print(" .contains ");
		String actualValue = driver.findElement(element).getText();
		if (actualValue.contains(expectedValue)) {
			System.out.println(" : PASSED");
		}
		else {
			System.out.println(" : FAILED");
		}
	}
	
	// write assertion equals to check if something is equal
	public static void equals(WebDriver driver, By element, String expectedValue) {
		System.out.print("Assertion checkpoint " + element.toString());
		System.out.print(" .equals ");
		String actualValue = driver.findElement(element).getText();
		if (actualValue.equalsIgnoreCase(expectedValue)) {
			System.out.println(" : PASSED");
		}
		else {
			System.out.println(" : FAILED");
			System.out.println("  > EXPECTED: " + expectedValue + "\n  > ACTUAL: " + actualValue);
		}
	}

}
