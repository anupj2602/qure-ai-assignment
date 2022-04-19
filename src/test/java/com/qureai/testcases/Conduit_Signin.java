package com.qureai.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qureai.methods.Conduit_TestMethods;
import com.qureai.pageobjects.Conduit_HomePage;
import com.qureai.pageobjects.Conduit_LoginHomePage;
import com.qureai.pageobjects.Conduit_SigninPage;
import com.qureai.pageobjects.Conduit_YourSettingsPage;
import com.qureai.resources.Base;

public class Conduit_Signin extends Base{
	WebDriver driver;
	SoftAssert asserts = new SoftAssert();
	Conduit_TestMethods testMethods;

	@BeforeClass
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("appURL"));
	}

	@Test
	public void conduitSignin() throws InterruptedException {
		testMethods = new Conduit_TestMethods(driver);
		testMethods.signin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Home — Conduit";

		//Verifying successful login
		asserts.assertEquals(actualTitle, expectedTitle);
		asserts.assertAll();
	}

	@Test(dependsOnMethods = "conduitSignin")
	public void conduitSignout() throws InterruptedException {	
		testMethods.signout();

		//Verifying successful logout
		String expectedTitle = "Home — Conduit";
		String actualTitle = driver.getTitle();
		asserts.assertEquals(actualTitle, expectedTitle);
		asserts.assertAll();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
