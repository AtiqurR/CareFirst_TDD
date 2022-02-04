package com.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commonPackage.CommonMethods;

public class RegisterAnAccount {

	public RegisterAnAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[contains('aria-label','')])[4]")
	public WebElement popUp;
	@FindBy(className = "//a[text()='OK']")
	public WebElement okkk;
	@FindBy(xpath = "//button[text()='Log In or Register']")
	public WebElement registerButton;
	@FindBy(xpath = "//a[text()='Not Yet Registered?']")
	public WebElement notYetRegister;
	@FindBy(xpath = "(//p[@class=' mb-2 font-weight-bold  color-black'])[2]")
	public WebElement individualButton;

	public void adPopUpMethod(WebDriver driver) {

		popUp.click();
		// Alert alert=driver.switchTo().alert();
		// alert.dismiss();
		// cm.clickMethod(popUp);
	}

	/*
	 * public void cookieOk(CommonMethods cm, WebDriver driver) { WebDriverWait wait
	 * = new WebDriverWait(driver, 30);
	 * wait.until(ExpectedConditions.elementToBeClickable(okkk));
	 * cm.clickMethod(okkk); }
	 */
	public void registerButtonMethod(CommonMethods cm) {
		cm.clickMethod(registerButton);
	}

	public void notYetRegisterButton(CommonMethods cm, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(notYetRegister));
		cm.clickMethod(notYetRegister);
	}

	public void individualButtonMethod(CommonMethods cm) {
		cm.clickMethod(individualButton);
	}

}
