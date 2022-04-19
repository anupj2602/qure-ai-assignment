package com.qureai.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Conduit_YourSettingsPage {
	WebDriver driver;

	public Conduit_YourSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement usernameTextbox;

	@FindBy(xpath="//textarea[@placeholder='Short bio about you']")
	WebElement bioTextarea;

	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement emailTextbox;

	@FindBy(xpath="//input[@placeholder='New Password']")
	WebElement newPasswordTextbox;

	@FindBy(xpath="//button[contains(text(),'Update Settings')]")
	WebElement updateSettingsButton;

	@FindBy(xpath="//button[contains(text(),'Or click here to logout')]")
	WebElement logoutButton;

	public WebElement usernameTextbox() {
		return usernameTextbox;
	}

	public WebElement bioTextarea() {
		return bioTextarea;
	}

	public WebElement emailTextbox() {
		return emailTextbox;
	}

	public WebElement newPasswordTextbox() {
		return newPasswordTextbox;
	}

	public WebElement updateSettingsButton() {
		return updateSettingsButton;
	}

	public WebElement logoutButton() {
		return logoutButton;
	}
}
