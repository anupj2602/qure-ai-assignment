package com.qureai.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Conduit_HomePage {
	WebDriver driver;

	public Conduit_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//ul[@show-authed='false']//a[contains(text(),'Home')]")
	WebElement homeLink;

	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signinLink;

	@FindBy(xpath="//a[contains(text(),'Sign up')]")
	WebElement signupLink;

	public WebElement homeLink() {
		return homeLink;
	}

	public WebElement signinLink() {
		return signinLink;
	}

	public WebElement signupLink() {
		return signupLink;
	}
}
