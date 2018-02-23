package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

// This class contains methods that return a WebDriver instance
public class DriverFactory {
	
	/* private functions to return browser
	private static WebDriver chooseChrome()
	private static WebDriver chooseFirefox()
	private static WebDriver chooseIE()
	*/
	
	// Receives browser type and returns browser driver accordingly
	public static WebDriver start(String browserType) {
		WebDriver driver;
		
		if (browserType.equalsIgnoreCase("chrome")) {
			System.out.println("Browser is CHROME");
			System.setProperty("webdriver.chrome.driver", "C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\Software\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (browserType.equalsIgnoreCase("firefox")) {
			System.out.println("Browser is FIREFOX");
			System.setProperty("webdriver.gecko.driver", "C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\Software\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserType.toUpperCase().equals("IE")) {
			System.out.println("Browser is IE");
			System.setProperty("webdriver.ie.driver", "C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\Software\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		else if (browserType.equalsIgnoreCase("headless")) {
			System.out.println("Headless Browser: HTML UNIT");
			driver = new HtmlUnitDriver();
		}
		else {
			System.out.println("Using default browser: CHROME");
			System.setProperty("webdriver.chrome.driver", "C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\Software\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		return driver;
	}
	
	// Receives a browser type and starting URL and returns browser driver accordingly starting at the given URL
	public static WebDriver start(String browserType, String url) {
		WebDriver driver = start(browserType);
		driver.get(url);
		return driver;
	}

}
