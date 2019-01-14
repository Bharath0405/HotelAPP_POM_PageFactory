package com.hotelapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelapp.qa.base.TestBase;

public class HomePage extends TestBase {

	//Page Factories or ORs
	
	@FindBy(xpath="//td[contains(text(),'Welcome to AdactIn Group of Hotels')]")
	WebElement welcmTxt;
	
	@FindBy(id="username_show")
	WebElement uName;
	
	@FindBy(linkText="Search Hotel")
	WebElement searchLink;
	
	//Initializing the Page Objects by creating a constructor
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions on the page
	
	public String validateHomePage() {
		return welcmTxt.getText();
	}
	
	public boolean verifyUser() {
		return uName.isDisplayed();
	}
	
	public SearchBookConfirmHotelPage clickOnSearchLink() {
		searchLink.click();
		return new SearchBookConfirmHotelPage();
	}
}
