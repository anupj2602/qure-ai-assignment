package com.qureai.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Conduit_ExploreImplementationsPage {

	WebDriver driver;

	public Conduit_ExploreImplementationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//textarea[contains(@placeholder,'Write a comment')]")
	WebElement commentTextArea;

	@FindBy(xpath="//button[contains(text(),'Post Comment')]")
	WebElement postCommentButton;

	@FindBy(xpath="(//span[contains(text(),'Favorite Article')])[1]")
	WebElement favoriteArticle;

	@FindBy(xpath="(//follow-btn/button)[1]")
	WebElement followButton;

	@FindBy(xpath="(//span[contains(text(),'Unfavorite Article')])[1]")
	WebElement unfollowButton;

	@FindBy(xpath="//comment/descendant::p")
	List<WebElement> getComments;

	public WebElement commentTextArea() {
		return commentTextArea;
	}

	public WebElement postCommentButton() {
		return postCommentButton;
	}

	public WebElement favoriteArticle() {
		return favoriteArticle;
	}

	public WebElement followButton() {
		return followButton;
	}

	public WebElement unfollowButton() {
		return unfollowButton;
	}

	public List<WebElement> getComments(){
		return getComments;
	}
}
