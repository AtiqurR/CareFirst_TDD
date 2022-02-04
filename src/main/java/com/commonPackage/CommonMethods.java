package com.commonPackage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.BaseClass.BaseClass;

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
//		Java_Logger.getLog("Actual value : " + element.getText() +" >>><<< Expected value : "+ expected);
		Assert.assertEquals(valueString.trim(), expected);
		System.out.println(valueString + ">>>>>>" + expected);
	}

	public void writeText(WebElement element, String value) {
		try {
			BaseClass.waits.waitUntilClickAble(element);
			element.sendKeys(value);
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

	/*
	 * public void jSEMethod(WebElement element,WebDriver driver, String value) {
	 * try { JavascriptExecutor js = (JavascriptExecutor)driver;
	 * js.executeScript("arguments[0].scrollIntoView()", element); } catch
	 * (Exception e) { } }
	 */
}
