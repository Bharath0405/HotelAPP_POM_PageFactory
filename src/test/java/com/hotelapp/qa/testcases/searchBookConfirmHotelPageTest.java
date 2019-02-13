package com.hotelapp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hotelapp.qa.util.TestUtil;
import com.hotelapp.qa.base.TestBase;
import com.hotelapp.qa.pages.BookedItineraryPage;
import com.hotelapp.qa.pages.HomePage;
import com.hotelapp.qa.pages.LoginPage;
import com.hotelapp.qa.pages.SearchBookConfirmHotelPage;

public class SearchBookConfirmHotelPageTest extends TestBase {
	HomePage homePage;
	SearchBookConfirmHotelPage searchBookConfirmHotelPage;
	LoginPage loginPage;
	BookedItineraryPage bookedItineraryPage;
	String sheetName = "bookingDataOriginal";

	public SearchBookConfirmHotelPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		browserIntiation();

		searchBookConfirmHotelPage = new SearchBookConfirmHotelPage();
		homePage = new HomePage();
		loginPage = new LoginPage();

		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnSearchLink();
	}

	@Test(priority = 1)
	public void validateSearchPageTest() {
		String title = searchBookConfirmHotelPage.verifyPageTitle();
		Assert.assertEquals(title, "Search Hotel (Fields marked with Red asterix (*) are mandatory)");
	}
	
	@DataProvider
	public Object[][] getHotelappTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getHotelappTestData")
	public void searchSelectBookHotelTest(String hotelLocation, String hotelName, String roomType,  String noOfRoms, String audlts, String children, String checkIn, String checkOut,String firstName, String lastName,
			String address, String ccType, String expMonth) {
		
		searchBookConfirmHotelPage.searchValues(hotelLocation, hotelName, roomType, noOfRoms, audlts, children);
		searchBookConfirmHotelPage.datePickins(checkIn, checkOut);
		searchBookConfirmHotelPage.serachAndSelectHotel();
		searchBookConfirmHotelPage.bookAHotel(firstName, lastName, address, "1234123445674560", "4512", ccType, expMonth, "2021");
		String confirmTitle = searchBookConfirmHotelPage.confirmBooking();
		Assert.assertEquals(confirmTitle, "Booking Confirmation");

		bookedItineraryPage = searchBookConfirmHotelPage.jumpToItinerary();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
