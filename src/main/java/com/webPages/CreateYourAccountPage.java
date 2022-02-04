package com.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonPackage.CommonMethods;

public class CreateYourAccountPage {

	public CreateYourAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

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

	public void crtYourAccountTextStep(CommonMethods cm, String expected) {
		cm.getText(crtYourAccountText, expected);
	}
	
	public void memberIdStep(CommonMethods cm, String value) {
		cm.writeText(memberId, value);
	}

	public void dobStep(CommonMethods cm, String value) {
		cm.writeText(dob, value);

	}

	public void zipCodeStep(CommonMethods cm, String value) {
		cm.writeText(zipCode, value);
	}

	public void ssnStep(CommonMethods cm, String value) {
		cm.writeText(ssn, value);
	}

	public void continueStep(CommonMethods cm) {
		cm.clickMethod(continuElement);
	}

	
}
