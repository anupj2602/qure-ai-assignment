package com.qureai.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Conduit_SignupPage {
	WebDriver driver;

	public Conduit_SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement usernameTextbox;

	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement emailTextbox;

	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwordTextbox;

	@FindBy(xpath="//button[text()='Sign up']")
	WebElement signupButton;

	public WebElement usernameTextbox() {
		return usernameTextbox;
	}

	public WebElement emailTextbox() {
		return emailTextbox;
	}

	public WebElement passwordTextbox() {
		return passwordTextbox;
	}

	public WebElement signupButton() {
		return signupButton;
	}
}
