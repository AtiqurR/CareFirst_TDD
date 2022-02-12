package com.commonPackage;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.BaseClass.BaseClass;

import careFirst.qa.reporting.Logger;

public class CommonMethods {

	public void clickMethod(WebElement element) {
		BaseClass.wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void hoverOver(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public String getTextMethod(WebElement element) {
		return element.getText();
	}

	public void getText(WebElement element, String expected) {
		String valueString = getTextMethod(element);
		careFirst.qa.reporting.Logger
				.log("Actual value : " + element.getText() + " -------- Expected value : " + expected);
		Assert.assertEquals(valueString.trim(), expected);
		System.out.println(valueString + ">>>>>>" + expected);
	}

	public void writeText(WebElement element, String value) {
		try {
			BaseClass.waits.waitUntilClickAble(element);
			element.sendKeys(value);
			careFirst.qa.reporting.Logger.log(element + "Text Value Entered" + value);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	public void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scrollDown(WebElement englishElement) {
		try {
			BaseClass.js.executeScript("scroll(0,700)", englishElement);
			Logger.log("Scrolling down 0 to 250 pixels");
		} catch (JavascriptException e) {
			e.printStackTrace();
			Logger.log("Exception while scrolling down");

		}
	}

	public void scrollUp(WebElement element) {
		try {
			BaseClass.js.executeScript("scroll(0,-700)");
			Logger.log("Scrolling up 250 to 0 pixel");
		} catch (JavascriptException e) {
			e.printStackTrace();
			Logger.log("Exception while scrolling up");
		}
	}

	public void scrollIntoView(WebElement element) {
		try {
			BaseClass.js.executeScript("arguments[0].scrollIntoView(true)", element);
			Logger.log("Scrolling into element : " + element + "succeed");
		} catch (JavascriptException e) {
			e.printStackTrace();
			Logger.log("Scrolling into element : " + element + " Failed");
			Assert.fail();

		}
	}

	public void popUpMethod(WebElement element) {
		BaseClass.wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
