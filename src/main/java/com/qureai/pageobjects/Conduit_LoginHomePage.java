package com.qureai.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Conduit_LoginHomePage {
	WebDriver driver;

	public Conduit_LoginHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a/img[@class='user-pic']")
	WebElement profileIcon;

	@FindBy(xpath="//follow-btn/following-sibling::a")
	WebElement editProfileSettings;

	@FindBy(xpath="//a[contains(text(),'Global Feed')]")
	WebElement globalFeedLink;

	@FindBy(xpath="//article-preview/descendant::h1")
	List<WebElement> articleList;

	public WebElement profileIcon() {
		return profileIcon;
	}

	public WebElement editProfileSettings() {
		return editProfileSettings;
	}

	public WebElement globalFeedLink() {
		return globalFeedLink;
	}

	public List<WebElement> articleList() {
		return articleList;
	}
}