package com.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.BaseClass.BaseClass;

public class MainPage {

	public MainPage(WebDriver driver) {
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
		BaseClass.cm.clickMethod(popUp);
	}

	public void registerButtonMethod() {
		BaseClass.wait.until(ExpectedConditions.elementToBeClickable(registerButton));
		BaseClass.cm.clickMethod(registerButton);
	}

	public void notYetRegisterButton() {

		BaseClass.wait.until(ExpectedConditions.elementToBeClickable(notYetRegister));
		BaseClass.cm.clickMethod(notYetRegister);
	}

	public void individualButtonMethod() {
		BaseClass.cm.clickMethod(individualButton);
	}

	public void registerSteps(WebDriver driver) {
		adPopUpMethod(driver);
		registerButtonMethod();
		notYetRegisterButton();
		individualButtonMethod();

	}
}
