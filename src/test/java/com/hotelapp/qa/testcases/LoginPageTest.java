package com.hotelapp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotelapp.qa.base.TestBase;
import com.hotelapp.qa.pages.HomePage;
import com.hotelapp.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	//Creating constructor and deriving the testbase class using super method
	public LoginPageTest() {
		super();		
	}
	
	@BeforeMethod
	public void setUp() {
		browserIntiation();//calling the browser initiation method from base class
		loginPage=new LoginPage();		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "AdactIn.com - Hotel Reservation System");
	}
	
	@Test(priority=2)
	public void loginPageLogoTest() {
		boolean flag = loginPage.verifyLoginPageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		//after the click the method returns the "homepage" so, we returned the homePage to "HomePage" class
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
