package com.qureai.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qureai.methods.Conduit_TestMethods;
import com.qureai.pageobjects.Conduit_ExploreImplementationsPage;
import com.qureai.pageobjects.Conduit_HomePage;
import com.qureai.pageobjects.Conduit_LoginHomePage;
import com.qureai.pageobjects.Conduit_SigninPage;
import com.qureai.resources.Base;

public class Conduit_ApplyFilterAndAct extends Base{

	WebDriver driver;
	Conduit_HomePage homePage;
	Conduit_ExploreImplementationsPage exploreImplementations;
	Conduit_TestMethods testMethods;
	SoftAssert asserts = new SoftAssert();

	@BeforeClass
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("appURL"));

	}

	@Test
	public void commentAndFollow() throws InterruptedException {		
		//Selecting the articles from Global Feed
		testMethods = new Conduit_TestMethods(driver);
		testMethods.signin(prop.getProperty("username"), prop.getProperty("password"));
		Conduit_LoginHomePage loginHomePage = new Conduit_LoginHomePage(driver);
		testMethods.clickOnLink(loginHomePage.globalFeedLink());

		//Applying Filter
		String filterTag = prop.getProperty("filter");
		System.out.println("Filter: "+filterTag);
		WebElement filterElement = driver.findElement(By.xpath("//a[text()='"+filterTag+"']"));
		System.out.println(filterElement.isDisplayed());
		testMethods.clickOnLink(filterElement);
		Thread.sleep(5000);

		//Clicking on the first article
		List<WebElement> articles = loginHomePage.articleList();
		if(articles.size() > 0) {
			articles.get(0).click();
			testMethods.enterComments(prop.getProperty("comments"));
			Thread.sleep(5000);
			testMethods.favoriteArticle();
		}
		exploreImplementations = new Conduit_ExploreImplementationsPage(driver);
		if(exploreImplementations.unfollowButton().isDisplayed()) {
			asserts.assertTrue(true);
		}
		else {
			asserts.assertTrue(false);
		}
	}

	@AfterClass
	public void unfollowArticle() throws InterruptedException {
		testMethods.unfollow();
		Thread.sleep(5000);
		driver.close();
	}
}
