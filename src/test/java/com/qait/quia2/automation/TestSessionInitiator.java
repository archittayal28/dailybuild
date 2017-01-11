package com.qait.quia2.automation;

import static com.qait.quia2.automation.utils.ConfigPropertyReader.getProperty;
import static com.qait.quia2.automation.utils.YamlReader.getYamlValue;
import static com.qait.quia2.automation.utils.YamlReader.setYamlFilePath;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.qait.quia2.automation.pojo.TopicNamePojo;
import com.qait.quia2.automation.utils.TakeScreenshot;
import com.qait.quia2.keywords.AB_Canvas_Page;
import com.qait.quia2.keywords.LoginPageActions;

public class TestSessionInitiator {

	protected static WebDriver driver;
	private final WebDriverFactory wdfactory;
	String browser;
	String seleniumserver;
	String seleniumserverhost;
	String URL;
	String applicationpath;
	String chromedriverpath;
	String datafileloc = "";
	static int timeout;
	Map<String, Object> chromeOptions = null;
	DesiredCapabilities capabilities;
        public AB_Canvas_Page abcanvas;

	/**
	 * Initiating the page objects
	 */
	public LoginPageActions loginpage;
	public TakeScreenshot takescreenshot;
	public TopicNamePojo topicNameValue;
	private String testname;

	public Random randomGenerator;

	public WebDriver getDriver() {
		return this.driver;
	}

	private void _initPage() {
		loginpage = new LoginPageActions(driver);
                abcanvas = new AB_Canvas_Page(driver);
	}

	/**
	 * Page object Initiation done
	 *
	 * @param testname
	 */
	public TestSessionInitiator(String testname) {
		wdfactory = new WebDriverFactory();
		testInitiator(testname);
		this.testname = testname;
	}

	public TestSessionInitiator(String testname, String browserName) {
		wdfactory = new WebDriverFactory(browserName);
		testInitiator(testname);
		this.testname = testname;

	}

	private void testInitiator(String testname) {
		setYamlFilePath();
		_configureBrowser();
		_initPage();
		takescreenshot = new TakeScreenshot(testname, this.driver);
	}

	private void _configureBrowser() {
		//System.out.println("::::::: " + _getSessionConfig().get("browser"));
		driver = wdfactory.getDriver(_getSessionConfig());

		if (!_getSessionConfig().get("browser").toLowerCase().trim().equalsIgnoreCase("mobile")) {
			try {
				Thread.sleep(2000);
				System.out.println(":::::::::::::: " + driver);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getProperty("timeout")), TimeUnit.SECONDS);
	}

	private Map<String, String> _getSessionConfig() {
		String[] configKeys = { "tier", "browser", "seleniumserver", "seleniumserverhost", "timeout", "driverpath",
				"appiumServer", "mobileDevice" };
		Map<String, String> config = new HashMap<String, String>();
		for (String string : configKeys) {
			config.put(string, getProperty("./Config.properties", string));
		}
		// System.out.println(config.get("browser"));
		return config;
	}

	public void launchApplication() {
		launchApplication(getYamlValue("base_url"));
	}

	public void launchApplication(String base_url) {
		//Reporter.log("\n[INFO]: The application url is :- " + base_url, true);
		driver.manage().deleteAllCookies();
		driver.get(base_url);
	}

	public void launchAdminApplication(String Adminbase_url) {
		Reporter.log("\n[INFO]: The application url is :- " + Adminbase_url, true);
		driver.manage().deleteAllCookies();
		driver.get(Adminbase_url);
	}

	public void openUrl(String url) {
		driver.get(url);
	}

	public void closeBrowserSession() {
		Reporter.log("[INFO]: The Test: " + this.testname.toUpperCase() + " COMPLETED!" + "\n", true);
		try {
			driver.quit();
			Thread.sleep(3000);// [INFO]: this to wait before you close every
			// thing
		} catch (Exception b) {
			b.getMessage();
		}
	}

	public void closeTestSession() {
		closeBrowserSession();
	}
        
        public void quitBrowser(){
        driver.quit();
        }
        
}
