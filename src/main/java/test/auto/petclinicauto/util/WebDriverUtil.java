package test.auto.petclinicauto.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverUtil {

	private static WebDriver driver;
	
	private WebDriverUtil() {
		
	}
	
	public static WebDriver getDriver(String  browserType) {
		if(driver != null) {
			return driver;
		}else {
			return iniWebDriver(browserType);
		}
	}

	private static WebDriver iniWebDriver(String browserType) {
		WebDriver driver = null;
		switch(browserType.toUpperCase()) {
		
		case "IE": {
			driver = initIEBrowser();
			break;
		}
		case "CHROME":{
			driver = initChromeBrowser();
			break;
		}
		default:
			driver = initIEBrowser();
			
		}
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver initChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--no-sandbox");
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		return driver;
	}

	private static WebDriver initIEBrowser() {
		System.setProperty("webdriver.ie.driver", "driver/IEdriver.exe");
		DesiredCapabilities ieCap = DesiredCapabilities.internetExplorer();
		ieCap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver = new InternetExplorerDriver(ieCap);
		
		return driver;
	}
}
