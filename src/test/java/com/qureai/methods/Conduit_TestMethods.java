package com.qureai.methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qureai.pageobjects.Conduit_ExploreImplementationsPage;
import com.qureai.pageobjects.Conduit_HomePage;
import com.qureai.pageobjects.Conduit_LoginHomePage;
import com.qureai.pageobjects.Conduit_SigninPage;
import com.qureai.pageobjects.Conduit_SignupPage;
import com.qureai.pageobjects.Conduit_YourSettingsPage;
import com.qureai.resources.Base;

public class Conduit_TestMethods extends Base{
	WebDriver driver;
	Conduit_HomePage homePage;
	Conduit_SignupPage signupPage;
	Conduit_SigninPage signin;
	Conduit_LoginHomePage loginHomePage;
	Conduit_YourSettingsPage settingsPage;
	Conduit_ExploreImplementationsPage exploreImplementations;

	public Conduit_TestMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void signup(String username, String email, String password) {
		signupPage = new Conduit_SignupPage(driver);
		signupPage.usernameTextbox().sendKeys(username);
		signupPage.emailTextbox().sendKeys(email);
		signupPage.passwordTextbox().sendKeys(password);
		signupPage.signupButton().click();
	}

	public void signin(String loginUsername, String loginPassword) {
		//Clicking on Sign in link
		homePage = new Conduit_HomePage(driver);
		homePage.signinLink().click();

		//Entering the valid credentials to successfully login
		signin = new Conduit_SigninPage(driver);
		signin.emailTextbox().sendKeys(loginUsername);
		signin.passwordTextbox().sendKeys(loginPassword);
		signin.signinButton().click();
	}

	public void signout() {
		//Navigating to Settings page
		loginHomePage = new Conduit_LoginHomePage(driver);
		loginHomePage.profileIcon().click();
		loginHomePage.editProfileSettings().click();

		//Clicking on logout
		settingsPage = new Conduit_YourSettingsPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", settingsPage.logoutButton());
		settingsPage.logoutButton().click();
	}

	public void clickOnLink(WebElement element) {
		element.click();
	}

	public void enterComments(String comments) {
		//Commenting on the selected article
		exploreImplementations = new Conduit_ExploreImplementationsPage(driver);
		exploreImplementations.commentTextArea().sendKeys(comments);
		exploreImplementations.postCommentButton().click();
	}

	public void favoriteArticle() {
		//Favorite the article
		exploreImplementations = new Conduit_ExploreImplementationsPage(driver);
		exploreImplementations.favoriteArticle().click();
	}

	public void unfollow() {
		//Favorite the article
		exploreImplementations = new Conduit_ExploreImplementationsPage(driver);
		exploreImplementations.unfollowButton().click();
	}
}
