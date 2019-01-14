package com.hotelapp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotelapp.qa.base.TestBase;
import com.hotelapp.qa.pages.BookedItineraryPage;
import com.hotelapp.qa.pages.HomePage;
import com.hotelapp.qa.pages.LoginPage;
import com.hotelapp.qa.pages.SearchBookConfirmHotelPage;

public class searchBookConfirmHotelPageTest extends TestBase {
	HomePage homePage;
	SearchBookConfirmHotelPage searchBookConfirmHotelPage;
	LoginPage loginPage;
	BookedItineraryPage bookedItineraryPage;
	
	public searchBookConfirmHotelPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		browserIntiation();
		
		searchBookConfirmHotelPage=new SearchBookConfirmHotelPage();
		homePage=new HomePage();
		loginPage=new LoginPage();
		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnSearchLink();	
	}
	
	@Test(priority=1)
	public void validateSearchPageTest() {
		String title = searchBookConfirmHotelPage.verifyPageTitle();
		Assert.assertEquals(title, "Search Hotel (Fields marked with Red asterix (*) are mandatory)");
	}
	
	@Test(priority=2)
	public void searchSelectBookHotelTest() {
		searchBookConfirmHotelPage.searchValues("Melbourne", "Hotel Creek", "Double", "3 - Three", "3 - Three", "1 - One");
		searchBookConfirmHotelPage.datePickins("14/02/2019", "18/02/2019");
		searchBookConfirmHotelPage.serachAndSelectHotel();
		searchBookConfirmHotelPage.bookAHotel("Jeremy", "Renner", "Detroit", "1234123445674567", "1234", "VISA", "May", "2022");
		String confirmTitle = searchBookConfirmHotelPage.confirmBooking();
		Assert.assertEquals(confirmTitle, "Booking Confirmation");
		
		bookedItineraryPage= searchBookConfirmHotelPage.jumpToItinerary();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
