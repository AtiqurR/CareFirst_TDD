package com.registerTest;

import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class RegisterTest extends BaseClass {

	@Test
	public void registerTest() {
		driver.navigate().refresh();
		mainPage.registerSteps(driver);

	}

}
