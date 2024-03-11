package com.xyzbank.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.xyzbank.qa.util.TestUtil;
import com.xyzbank.qa.util.WebEventListener;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    @SuppressWarnings("deprecation")
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase() {
	try {
	    prop = new Properties();
	    FileInputStream ip = new FileInputStream(
		    System.getProperty("user.dir") + "/src/main/java/com/xyzbank" + "/qa/config/config.properties");
	    prop.load(ip);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @SuppressWarnings({ "deprecation", "deprecation" })
    public static void initialization() {
	String browserName = prop.getProperty("browser");

	if (browserName.equals("chrome")) {
	    System.setProperty("webdriver.chrome.driver",
		    "D:\\maven\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    driver = new ChromeDriver();
	} else if (browserName.equals("firefox")) {
	    System.setProperty("webdriver.Gecko.driver", "D:\\maven\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");

	    driver = new FirefoxDriver();
	} else if (browserName.equals("edge")) {
	    System.setProperty("webdriver.edge.driver", "D:\\maven\\edgedriver_win64\\msedgedriver.exe");

	    driver = new EdgeDriver();
	}

	e_driver = new EventFiringWebDriver(driver);

	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	driver.get(prop.getProperty("url"));

    }

}