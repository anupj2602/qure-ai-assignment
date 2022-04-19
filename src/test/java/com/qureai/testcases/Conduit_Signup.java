package com.qureai.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qureai.methods.Conduit_TestMethods;
import com.qureai.pageobjects.Conduit_HomePage;
import com.qureai.pageobjects.Conduit_SignupPage;
import com.qureai.resources.Base;

public class Conduit_Signup extends Base{

	WebDriver driver;
	SoftAssert asserts = new SoftAssert();
	Conduit_TestMethods testMethods;

	@BeforeClass
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("appURL"));

		//Clicking on Sign up link
		Conduit_HomePage homePage = new Conduit_HomePage(driver);
		homePage.signupLink().click();
	}

	@Test
	public void conduitSignUp() throws IOException {	
		testMethods = new Conduit_TestMethods(driver);
		testMethods.signup(prop.getProperty("username"), prop.getProperty("username"), prop.getProperty("password"));
		String expectedTitle = driver.getTitle();
		String actualTitle = "@"+prop.getProperty("username")+" - Conduit";
		asserts.assertEquals(actualTitle, expectedTitle);
		asserts.assertAll();
	}

	@AfterClass
	public void closeDown() {
		driver.close();
	}
}
