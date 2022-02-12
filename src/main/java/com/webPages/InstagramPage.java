package com.webPages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.BaseClass.BaseClass;

public class InstagramPage {

	public InstagramPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='social-links']//child::a[5]")
	public WebElement instaElement;
	@FindBy(xpath = "//*[@name='username']")
	public WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passWord;
	@FindBy(linkText = "Sign up")
	public WebElement signUp;

	public void instaPage() {
		BaseClass.js.executeScript("arguments[0].scrollIntoView(true)", instaElement);
		BaseClass.cm.clickMethod(instaElement);
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
		instaPage();
		userNamestep(userNameInput, driver);
		passwordStep(passwordInput);
		signUpStep(driver);
	}
}
