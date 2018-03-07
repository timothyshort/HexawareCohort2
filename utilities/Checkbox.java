package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// This class performs the checkbox algorithm
public class Checkbox {
	
	public static void choose(WebDriver driver, boolean checkBoxDesired, By checkboxElement) {
		if (checkBoxDesired) {
			if (!driver.findElement(checkboxElement).isSelected()) {
				driver.findElement(checkboxElement).click();
			}
		}
		else {
			if (driver.findElement(checkboxElement).isSelected()) {
				driver.findElement(checkboxElement).click();
			}
		}
	}
	
	// Takes driver, String, By
	// Tests value of String and then calls the primary above with boolean
	public static void choose(WebDriver driver, String checkBoxDesired, By checkboxElement) {
		if (checkBoxDesired.equalsIgnoreCase("TRUE")) {
			Checkbox.choose(driver, true, checkboxElement);
		}
		else {
			Checkbox.choose(driver, false, checkboxElement);
		}
	}
}
