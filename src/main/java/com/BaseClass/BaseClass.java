package com.BaseClass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.commonPackage.CommonMethods;
import com.commonPackage.CommonWaits;
import com.webPages.CreateAccountPage;
import com.webPages.InstagramPage;
import com.webPages.MainPage;

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

	@BeforeMethod
	public void setUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
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
