package utilities;

public class GlobalConfig {
	
	// Root directories
	public static final String DRIVERDIRECTORY = "C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\Software\\";
	public static final String TESTDATA_DIR = "C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\TestData\\";
	public static final String TESTOUPUT_DIR = "C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\TestOutput\\";
	
	// Settings for browser
	public static final String CHROMEKEY = "webdriver.chrome.driver";
	public static final String CHROMEVALUE = "chromedriver.exe";
	public static final String[] FIREFOXPROPERTY = { "webdriver.gecko.driver", "geckodriver.exe" };
	
	// Web application URLs
	public static final String ROOTURL = "http://sdettraining.com/projects/";
	public static final String AMS_URL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	public static final String SHOPCART_URL = "http://sdettraining.com/online/";
	
	// Database Connection String
	public static final String DB_SERVER = "jdbc:sqlserver://sql2k801.discountasp.net";
	public static final String DB_DATABASE = "SQL2008_841902_tr";
	public static final String DB_USERNAME = "SQL2008_841902_tr_user";
	public static final String DB_PASSWORD = "";

}
