package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseTest {
	WebDriver driver;
	
	public void printLinkTags(String pageName) {
		System.out.println("PRINTING LINK TAGS FOR PAGE: " + pageName);
		List<WebElement> aTags = driver.findElements(By.tagName("a"));
		for (WebElement tag : aTags) {
			System.out.println(tag.getText());
		}
	}
	
	public void pageInfo(String pageName) {
		System.out.println("Page: " + pageName + "\n" + driver.getTitle() + " " + driver.getCurrentUrl());
	}

}
