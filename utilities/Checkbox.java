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
}
