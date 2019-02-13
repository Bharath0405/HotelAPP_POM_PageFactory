package com.hotelapp.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelapp.qa.base.TestBase;

public class RegistrationPage extends TestBase {

	@FindBy (linkText="New User Register Here")
	WebElement regLink;
	
	@FindBy(xpath="//td[contains(text(), 'New User Registration Form')]")
	WebElement regPageConfText;
	
	@FindBy(id="username")
	WebElement usrName;
	
	@FindBy(id="password")
	WebElement pwd;
	
	@FindBy(id="re_password")
	WebElement pwdConfirm;
	
	@FindBy(id="full_name")
	WebElement fullName;
	
	@FindBy(id="email_add")
	WebElement emailID;
	
	@FindBy(id="captcha")
	WebElement captchaWait;
	
	@FindBy(id="tnc_box")
	WebElement tcBox;
	
	@FindBy(id="Submit")
	WebElement submitForm;
	
	@FindBy(linkText="Click here to login")
	WebElement validRegText;
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	public void regLinkClick() {
		regLink.click();
	}
	public String regPageVerify() {
		return regPageConfText.getText();	
	}
	
	public boolean newUserRegForm(String uName, String paswd, String repaswd, String fName, String eID) throws InterruptedException {
		usrName.sendKeys(uName);
		pwd.sendKeys(paswd);
		pwdConfirm.sendKeys(repaswd);
		fullName.sendKeys(fName);
		emailID.sendKeys(eID);
		if (captchaWait.isDisplayed()) {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(10000);
				}
		tcBox.click();
		submitForm.click();
		return validRegText.isDisplayed();
		}
}


