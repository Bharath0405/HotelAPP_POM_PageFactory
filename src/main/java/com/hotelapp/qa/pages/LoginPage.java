package com.hotelapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelapp.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory- Object Repositories 

	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(linkText="New User Register Here")
	WebElement signUp;
	
	@FindBy(xpath="//img[contains(@class, 'logo')]")
	WebElement logoImage;
	
	//Initializing the Page Objects by creating a constructor
	
	public LoginPage() {
		PageFactory.initElements(driver, this);		
	}
	
	//Actions on the page
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	/*Usually we use "void", after using the return to validate the page title the return value is "String"
		 *  we use this return value in test case*/
	}
	
	public boolean verifyLoginPageLogo() {
		return logoImage.isDisplayed();
	}
	
	public HomePage login(String usr, String pwd) {
		username.sendKeys(usr);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();//After the click, the page jumps to HomePage so we have to change the void to HomePage
		
		
	}
	
	
	
	
	

}
