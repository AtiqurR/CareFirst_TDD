package com.commonPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.BaseClass.BaseClass;

public class CommonWaits {

	public void waitUntilClickAble(WebElement element) {
		try {

			BaseClass.wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NullPointerException e) {
			System.out.println(element + ": Not Found");
			e.printStackTrace();
			Assert.fail();

		}

	}

	public void waitUntilVisible(WebElement element) {
		try {
			BaseClass.wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NullPointerException e) {
			System.out.println(element + ": Not Found");
			e.printStackTrace();
			Assert.fail();

		}
	}

	public void waitUntilSelectable(WebElement element) {
		try {
			BaseClass.wait.until(ExpectedConditions.elementToBeSelected(element));
		} catch (NullPointerException e) {
			e.printStackTrace();
			Assert.fail();

		}
	}
}
