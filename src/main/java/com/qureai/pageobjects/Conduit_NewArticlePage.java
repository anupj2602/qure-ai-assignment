package com.qureai.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Conduit_NewArticlePage {
	WebDriver driver;

	public Conduit_NewArticlePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(@href,'editor')]")
	WebElement newArticleLink;

	@FindBy(xpath="//input[@placeholder='Article Title']")
	WebElement articleTitleTextbox;

	@FindBy(xpath="//input[contains(@placeholder,'this article about')]")
	WebElement articleAboutTextbox;

	@FindBy(xpath="//textarea[contains(@placeholder,'Write your article')]")
	WebElement writeYourArticleTextbox;

	@FindBy(xpath="//input[@placeholder='Enter tags']")
	WebElement enterTagsTextbox;

	@FindBy(xpath="//button[contains(text(),'Publish Article')]")
	WebElement publishArticleButton;

	public WebElement newArticleLink() {
		return newArticleLink;
	}
	public WebElement articleTitleTextbox() {
		return articleTitleTextbox;
	}

	public WebElement articleAboutTextbox() {
		return articleAboutTextbox;
	}

	public WebElement writeYourArticleTextbox() {
		return writeYourArticleTextbox;
	}

	public WebElement enterTagsTextbox() {
		return enterTagsTextbox;
	}

	public WebElement publishArticleButton() {
		return publishArticleButton;
	}
}
