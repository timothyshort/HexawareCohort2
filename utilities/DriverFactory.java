package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

// This class contains methods that return a WebDriver instance
public class DriverFactory {
	
	// private functions to return browser
	private static WebDriver chooseChrome() {
		System.out.println("Browser is CHROME");
		System.setProperty(GlobalConfig.CHROMEKEY, GlobalConfig.DRIVERDIRECTORY + GlobalConfig.CHROMEVALUE);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	private static WebDriver chooseFirefox() {
		System.out.println("Browser is FIREFOX");
		System.setProperty(GlobalConfig.FIREFOXPROPERTY[0], GlobalConfig.DRIVERDIRECTORY + GlobalConfig.FIREFOXPROPERTY[1]);
		return new FirefoxDriver();
	}
	private static WebDriver chooseIE() {
		System.out.println("Browser is IE");
		System.setProperty("webdriver.ie.driver", GlobalConfig.DRIVERDIRECTORY + "IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	// Receives browser type and returns browser driver accordingly
	public static WebDriver start(String browserType) {
		if (browserType.equalsIgnoreCase("chrome")) {
			return chooseChrome();
		}
		else if (browserType.equalsIgnoreCase("firefox")) {
			return chooseFirefox();
		}
		else if (browserType.toUpperCase().equals("IE")) {
			return chooseIE();
		}
		else if (browserType.equalsIgnoreCase("headless")) {
			System.out.println("Headless Browser: HTML UNIT");
			return new HtmlUnitDriver();
		}
		else {
			System.out.println("Using default browser: CHROME");
			return chooseChrome();
		}
	}
	
	// Receives a browser type and starting URL and returns browser driver accordingly starting at the given URL
	public static WebDriver start(String browserType, String url) {
		WebDriver driver = start(browserType);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	private static WebDriver configure(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}

}
