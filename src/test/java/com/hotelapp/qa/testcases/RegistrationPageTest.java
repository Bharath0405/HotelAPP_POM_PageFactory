package com.hotelapp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hotelapp.qa.base.TestBase;
import com.hotelapp.qa.pages.RegistrationPage;
import com.hotelapp.qa.util.TestUtil;

public class RegistrationPageTest extends TestBase {
	RegistrationPage registrationPage;
	String sheetName="regData";
	
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
	
	@DataProvider
	public Object[][] getHotelappTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider= "getHotelappTestData")
	public void newUserRegFormTest(String userName, String password, String rePassword, String fullName, String emailID) throws InterruptedException {
		boolean regConfText = registrationPage.newUserRegForm(userName, password, rePassword, fullName, emailID);
		Assert.assertEquals(regConfText, true);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


