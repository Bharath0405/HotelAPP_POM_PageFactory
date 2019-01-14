package com.hotelapp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotelapp.qa.base.TestBase;
import com.hotelapp.qa.pages.HomePage;
import com.hotelapp.qa.pages.LoginPage;
import com.hotelapp.qa.pages.SearchBookConfirmHotelPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	SearchBookConfirmHotelPage searchHotelPage;
	LoginPage loginPage;
	
	//Creating constructor and deriving the testbase class using super method
	
	public HomePageTest () {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		browserIntiation();
		homePage = new HomePage();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void vaidateHomePageTest() {
		String txt = homePage.validateHomePage();
		Assert.assertEquals(txt, "Welcome to AdactIn Group of Hotels");
		}
	
	@Test(priority=2)
	public void verifyUserTest() {
		boolean usrVerify = homePage.verifyUser();
		Assert.assertTrue(usrVerify);
	}
	
	@Test(priority=3)
	public void clickOnSearchHhotelTest() {
		searchHotelPage = homePage.clickOnSearchLink();		
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
