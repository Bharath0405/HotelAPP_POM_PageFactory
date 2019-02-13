package com.hotelapp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hotelapp.qa.util.WebEventListener;
import com.hotelapp.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;


	// Creating a constructor
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Bharath\\workspace\\HotelApp_POM_Project\\src\\main\\java\\com\\hotelapp\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Browser Initialization

	public static void browserIntiation() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {			
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Bharath\\Desktop\\Classes\\Browser_Drivers\\chromedriver.exe");
			driver = new ChromeDriver();		
		} else if (browserName.equals("firefox")) {			
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Bharath\\Desktop\\Classes\\Browser_Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IExplorer")) {			
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Bharath\\Desktop\\Classes\\Browser_Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		

	    e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);//Page_Looad_Timeout and Implicit_Wait are the global variables declared in util class

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
