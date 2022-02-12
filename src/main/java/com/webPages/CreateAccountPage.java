package com.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.BaseClass.BaseClass;

public class CreateAccountPage {

	public CreateAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[contains('aria-label','')])[4]")
	public WebElement popUpElement;
	@FindBy(className = "//a[text()='OK']")
	public WebElement okkk;
	@FindBy(xpath = "//button[text()='Log In or Register']")
	public WebElement registerButton;
	@FindBy(xpath = "//a[text()='Not Yet Registered?']")
	public WebElement notYetRegister;
	@FindBy(xpath = "(//p[@class=' mb-2 font-weight-bold  color-black'])[2]")
	public WebElement individualButton;
	@FindBy(css = ".font-weight-bold.mb-4.ng-star-inserted")
	public WebElement crtYourAccountText;
	@FindBy(xpath = "//input[@id='memberId']")
	public WebElement memberId;
	@FindBy(xpath = "//input[contains(@id,'datepicker')]")
	public WebElement dob;
	@FindBy(xpath = "//input[@id='zipCode']")
	public WebElement zipCode;
	@FindBy(xpath = "//input[@id='ssnOrTaxID']")
	public WebElement ssn;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/mem-member-information-step2/cf-band/div/div/div[2]/div[2]/form/div[3]/div[2]/button")
	public WebElement continuElement;
	@FindBy(xpath = "//a[text()='English']")
	public WebElement englishElement;
	@FindBy(xpath = "//a[text()='< Back']")
	public WebElement backButton;

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

	public void crtYourAccountTextStep(String expected) {
		BaseClass.cm.getText(crtYourAccountText, expected);
	}

	public void memberIdStep(String value) {
		BaseClass.cm.writeText(memberId, value);
	}

	public void dobStep(String value) {
		BaseClass.cm.writeText(dob, value);

	}

	public void zipCodeStep(String value) {
		BaseClass.cm.writeText(zipCode, value);
	}

	public void ssnStep(String value) {
		BaseClass.cm.writeText(ssn, value);
	}

	public void continueStep() {
		BaseClass.cm.clickMethod(continuElement);
	}

	public void english() {
		BaseClass.cm.scrollDown(englishElement);
		BaseClass.cm.scrollUp(englishElement);
		BaseClass.cm.clickMethod(englishElement);
	}

	public void backStep() {
		BaseClass.cm.scrollUp(backButton);
		BaseClass.cm.clickMethod(backButton);
	}

	public void accountSteps(WebDriver driver, String expected, String memberInput, String dobInput,
			String zipCodeInput, String ssnInput) {
		popUp();
		registerButtonMethod(driver);
		notYetRegisterButton(driver);
		individualButtonMethod();
		crtYourAccountTextStep(expected);
		memberIdStep(memberInput);
		dobStep(dobInput);
		zipCodeStep(zipCodeInput);
		ssnStep(ssnInput);
		continueStep();
		english();
		backStep();

	}
}
