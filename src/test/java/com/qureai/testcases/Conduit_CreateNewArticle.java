package com.qureai.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qureai.pageobjects.Conduit_HomePage;
import com.qureai.pageobjects.Conduit_NewArticlePage;
import com.qureai.pageobjects.Conduit_SigninPage;
import com.qureai.resources.Base;
import com.qureai.utilities.DataUtil;

public class Conduit_CreateNewArticle extends Base{

	WebDriver driver;
	SoftAssert asserts = new SoftAssert();

	@BeforeClass
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("appURL"));

		//Clicking on Sign in link
		Conduit_HomePage homePage = new Conduit_HomePage(driver);
		homePage.signinLink().click();
	}

	@Test(dataProvider="articleData", dataProviderClass=DataUtil.class)
	public void createNewArticle(String articleTitle, String articleAbout, String article, String tags) throws InterruptedException {		
		//Entering the valid credentials to successfully login
		Conduit_SigninPage signin = new Conduit_SigninPage(driver);
		signin.emailTextbox().sendKeys(prop.getProperty("username"));
		signin.passwordTextbox().sendKeys(prop.getProperty("password"));
		signin.signinButton().click();
		Thread.sleep(3000);

		System.out.println("Article Title: "+articleTitle);
		System.out.println("About: "+articleAbout);
		System.out.println("Article: "+article);
		System.out.println("Tags: "+tags);

		//Creating a new Article
		Conduit_NewArticlePage articlePage = new Conduit_NewArticlePage(driver);
		articlePage.newArticleLink().click();
		articlePage.articleTitleTextbox().sendKeys(articleTitle);
		articlePage.articleAboutTextbox().sendKeys(articleAbout);
		articlePage.writeYourArticleTextbox().sendKeys(article);
		articlePage.enterTagsTextbox().sendKeys(tags);
		//articlePage.publishArticleButton().click();

		//Verifying successful login
		//Assert.assertEquals(actualTitle, expectedTitle);
	}
}
