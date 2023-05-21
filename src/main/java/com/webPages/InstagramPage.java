package com.webPages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.BaseClass.BaseClass;
import com.instagramLogInData.LogInData;

public class InstagramPage {

	public InstagramPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "(//button[contains('aria-label','')])[4]")
	public WebElement popUpElement;
	@FindBy(xpath = "//button[text()='Log In or Register']")
	public WebElement registerButton;
	@FindBy(xpath = "//a[text()='Not Yet Registered?']")
	public WebElement notYetRegister;
	@FindBy(xpath = "(//p[@class=' mb-2 font-weight-bold  color-black'])[2]")
	public WebElement individualButton;
	@FindBy(xpath = "//div[@class='social-links']//child::a[5]")
	public WebElement instaElement;
	@FindBy(xpath = "//button[@class='sqdOP  L3NKy   y3zKF     ']//parent::a[@class='ENC4C']")
	public WebElement logInElement;
	@FindBy(name = "//input[@name='username']")
	public WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passWord;
	@FindBy(linkText = "Sign up")
	public WebElement signUp;

	
	private void popUp() {
		BaseClass.cm.clickMethod(popUpElement);
	}
	
	public void registerButtonMethod(WebDriver driver) {
		BaseClass.wait.until(ExpectedConditions.elementToBeClickable(registerButton));
		BaseClass.cm.clickMethod(registerButton);
	}

	public void notYetRegisterButton(WebDriver driver) {

		BaseClass.wait.until(ExpectedConditions.elementToBeClickable(notYetRegister));
		BaseClass.cm.clickMethod(notYetRegister);
	}

	public void individualButtonMethod() {
		BaseClass.cm.clickMethod(individualButton);
	}
	public void instaPage() {
		BaseClass.js.executeScript("arguments[0].scrollIntoView(true)", instaElement);
		BaseClass.cm.clickMethod(instaElement);
	}
	public void logInStep() {
		BaseClass.wait.until(ExpectedConditions.elementToBeClickable(logInElement));
		BaseClass.cm.clickMethod(logInElement);
	}

	public void userNamestep(String value, WebDriver driver) {

		Set<String> allWindowHandles = BaseClass.driver.getWindowHandles();
		@SuppressWarnings("unused")
		String parent = (String) allWindowHandles.toArray()[0];
		String child = (String) allWindowHandles.toArray()[1];
		BaseClass.driver.switchTo().window(child);
		BaseClass.wait.until(ExpectedConditions.elementToBeClickable(userName));
		BaseClass.cm.writeText(userName, value);
	}

	public void passwordStep(String value) {
		BaseClass.cm.writeText(passWord, value);
	}

	public void signUpStep(WebDriver driver) {

		BaseClass.wait.until(ExpectedConditions.elementToBeClickable(signUp));
		BaseClass.cm.clickMethod(signUp);
	}

	public void instaPageSteps(String userNameInput, String passwordInput, WebDriver driver) {
		popUp();
		registerButtonMethod(driver);
		notYetRegisterButton(driver);
		individualButtonMethod();
		instaPage();
		userNamestep(userNameInput, driver);
		passwordStep(passwordInput);
		signUpStep(driver);
	}
	public void instaPageStepData(WebDriver driver, LogInData Data ){
		popUp();
		registerButtonMethod(driver);
		notYetRegisterButton(driver);
		individualButtonMethod();
		instaPage();
		logInStep();
		userNamestep(Data.getUserName(), driver);
		passwordStep(Data.getPassWord());
		signUpStep(driver);
	}
}
