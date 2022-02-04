package com.registerAnAccountTest;

import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class RegisterTest extends BaseClass {

	@Test()
	public void registerTest1() throws InterruptedException {
//		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		driver.navigate().refresh();
		register.adPopUpMethod(driver);
		register.registerButtonMethod(cm);
		register.notYetRegisterButton(cm, driver);
		register.individualButtonMethod(cm);
//      register.cookieOk(cm, driver);
//		crtYourAcntPage.crtYourAccountTextStep(WebElement element);
		crtYourAcntPage.memberIdStep(cm, "Abc1100damn");
		crtYourAcntPage.crtYourAccountTextStep(cm, "Let's Create Your Account");
		crtYourAcntPage.dobStep(cm, "01121994");
		crtYourAcntPage.zipCodeStep(cm, "10472");
		crtYourAcntPage.ssnStep(cm, "8080");
		js.executeScript("arguments[0].scrollIntoView()", crtYourAcntPage.continuElement);
		crtYourAcntPage.continueStep(cm);
		// jsExecutor.executeScript("window.scrollBy(0,250)", "");
		System.out.println("I am here lazy debugging");
	}
}
