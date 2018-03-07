package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	// This function will take a screenshot of the browser
	public static void take(WebDriver driver, String filename) {
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filepath = GlobalConfig.TESTOUPUT_DIR + "Screenshots\\" + filename + ".jpg";
		File destinationFile = new File(filepath);
		
		try {
			FileUtils.copyFile(screenshotFile, destinationFile);
		} catch (IOException e) {
			System.out.println("ERROR: Could not capture screenshot");
			e.printStackTrace();
		}
	}
	
	// Receives driver, test case name, and filename
	// Calls the primary .take() function and passes the testCase/filename as filename
	public static void takeByTestCase(WebDriver driver, String testCase, String filename) {
		Screenshot.take(driver, testCase + "\\" + filename);
	}
	
	// Receives driver, test outcome, and filename
	// Calls the primary .take() function and passes the testOutcome/filename as filename
	public static void takeByOutcome(WebDriver driver, String testOutcome, String filename) {
		Screenshot.take(driver, testOutcome + "\\" + filename);
	}
	
	// Receives driver, test case name, test outcome, and filename
	// Calls the primary .take() function and passes the testCase/testOucome/filename as filename
	public static void takeByTestByOutCome(WebDriver driver, String testCase, String testOutcome, String filename) {
		Screenshot.take(driver, testCase + "\\" + testOutcome + "\\" + filename);
	}

}
