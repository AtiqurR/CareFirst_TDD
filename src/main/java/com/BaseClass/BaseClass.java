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
import com.webPages.CreateYourAccountPage;
import com.webPages.RegisterAnAccount;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public RegisterAnAccount register;
	public CommonMethods cm;
	public CreateYourAccountPage crtYourAcntPage;
	public static CommonWaits waits;
	public JavascriptExecutor js;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://individual.carefirst.com/individuals-families/home.page");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		instantiateMethod();
	}
	@AfterMethod
	public void tearUp() {
//		driver.quit();
	}
	public void instantiateMethod() {
		register=new RegisterAnAccount(driver);
		cm=new CommonMethods();
		crtYourAcntPage = new CreateYourAccountPage(driver);
		wait=new WebDriverWait(driver, 30);
		waits = new CommonWaits();
		js = (JavascriptExecutor)driver;
		
	}

}
