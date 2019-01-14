package com.hotelapp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hotelapp.qa.base.TestBase;
import com.hotelapp.qa.util.TestUtil;

public class SearchBookConfirmHotelPage extends TestBase {
	TestUtil testUtil;

	// Page Factories or ORs or Page Elements

	@FindBy(xpath = "//td[contains(text(), 'Search Hotel ')]")
	WebElement pageTitle;

	@FindBy(id = "datepick_in")
	WebElement checkInDate;

	@FindBy(id = "datepick_out")
	WebElement checkOutDate;

	@FindBy(id = "Submit")
	WebElement searchBtn;

	@FindBy(id = "radiobutton_0")
	WebElement radioBtn;

	@FindBy(id = "continue")
	WebElement cntBtn;

	@FindBy(id = "first_name")
	WebElement fName;

	@FindBy(id = "last_name")
	WebElement lName;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "cc_num")
	WebElement ccNum;

	@FindBy(id = "cc_cvv")
	WebElement cvvNum;

	@FindBy(id = "book_now")
	WebElement bookNowBtn;
	
	@FindBy(xpath="//td[contains(text(),'Booking Confirmation ')]")
	WebElement bookingConf;
	
	@FindBy(id="my_itinerary")
	WebElement itrBtn;
	
	

	// Initializing the page elements

	public SearchBookConfirmHotelPage() {
		PageFactory.initElements(driver, this);
	}

	// Page Actions

	public String verifyPageTitle() {
		return pageTitle.getText();
	}

	public void searchValues(String h_city, String h_name, String h_roomType, String h_rooms, String h_audlts,
			String h_children) {

		dropDown("location", h_city);
		dropDown("hotels", h_name);
		dropDown("room_type", h_roomType);
		dropDown("room_nos", h_rooms);
		dropDown("adult_room", h_audlts);
		dropDown("child_room", h_children);
	}

	public void datePickins(String checkIn, String checkOut) {
		checkInDate.clear();
		checkInDate.sendKeys(checkIn);
		checkOutDate.clear();
		checkOutDate.sendKeys(checkOut);

	}

	public void serachAndSelectHotel() {

		searchBtn.click();
		radioBtn.click();
		cntBtn.click();
	}

	public void bookAHotel(String firstName, String lastName, String addr, String ccNumber, String cvvNumber,
			String cc_Type, String exp_Month, String exp_Year) {
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		address.sendKeys(addr);
		ccNum.sendKeys(ccNumber);
		cvvNum.sendKeys(cvvNumber);
		dropDown("cc_type", cc_Type);
		dropDown("cc_exp_month", exp_Month);
		dropDown("cc_exp_year", exp_Year);
		bookNowBtn.click();
	}

	public String confirmBooking() {
		
		return bookingConf.getText();

	}

	public BookedItineraryPage jumpToItinerary() {
		itrBtn.click();
		return new BookedItineraryPage();
	}

	public void dropDown(String e_id, String selectOption) {
		Select select = new Select(driver.findElement(By.id(e_id)));
		select.selectByVisibleText(selectOption);
	}
}
