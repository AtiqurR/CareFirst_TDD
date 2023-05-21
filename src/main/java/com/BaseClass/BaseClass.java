package com.BaseClass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.commonPackage.CommonMethods;
import com.commonPackage.CommonWaits;
import com.webPages.CreateAccountPage;
import com.webPages.InstagramPage;
import com.webPages.MainPage;
import careFirst.qa.reporting.Logger;
import careFirst.qa.utilities.ConfigSingleTone;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public MainPage mainPage;
	public static CommonMethods cm;
	public CreateAccountPage crtAcntPage;
	public static CommonWaits waits;
	public static JavascriptExecutor js;
	public InstagramPage instaPage;
	public ConfigSingleTone config;

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) throws InterruptedException {
		String os = System.getProperty("os.name");
		Logger.log("My os version is: " + os);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("firefox") && os.contains("Mac")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		instantiateMethod();
		driver.get(config.getUrl());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(config.pageLoadWait(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(config.implicitWait(), TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, config.explicitWait());

	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

	public void instantiateMethod() {
		mainPage = new MainPage(driver);
		cm = new CommonMethods();
		crtAcntPage = new CreateAccountPage(driver);
		wait = new WebDriverWait(driver, 30);
		waits = new CommonWaits();
		js = (JavascriptExecutor) driver;
		instaPage = new InstagramPage(driver);
		config = ConfigSingleTone.getInstance();

	}

}
