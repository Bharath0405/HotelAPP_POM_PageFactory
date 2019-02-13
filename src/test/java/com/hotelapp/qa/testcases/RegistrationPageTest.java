package com.hotelapp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotelapp.qa.base.TestBase;
import com.hotelapp.qa.pages.RegistrationPage;

public class RegistrationPageTest extends TestBase {
	RegistrationPage registrationPage;
	
	public RegistrationPageTest() {
		super();		
	}

	@BeforeMethod
	public void setUp()
	{
		browserIntiation();
		registrationPage = new RegistrationPage();
		registrationPage.regLinkClick();
		}
	
	@Test(priority=1)
	public void regPageVerifyTest() {
		String confText = registrationPage.regPageVerify();
		Assert.assertEquals(confText, "New User Registration Form (Fields marked with Red asterix (*) are mandatory)");		
	}
	@Test(priority=2)
	public void newUserRegFormTest() throws InterruptedException {
		boolean regConfText = registrationPage.newUserRegForm("SelAutoKing1", "Selenium123", "Selenium123", "SelniumLearner", "adact2@yopmail.com");
		Assert.assertEquals(regConfText, true);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


