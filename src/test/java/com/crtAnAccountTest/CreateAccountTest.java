package com.crtAnAccountTest;

import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class CreateAccountTest extends BaseClass {

	@Test
	public void createAccountTest() {
		crtAcntPage.accountSteps(driver, "Let's Create Your Account", "Abc1100damn", "01121994", "10472", "8080");
		System.out.println("I am here lazy debugging");
		instaPage.instaPageSteps("_____anik_____", "1100", driver);
	}

}
