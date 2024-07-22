package com.bookcart.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bookcart.driverfactory.Driver;
import com.bookcart.pages.HomePage;
import com.bookcart.pages.LoginPage;
import com.bookcart.pages.RegistrationPage;

public class BaseTest {
	
	public HomePage homePage;
	public RegistrationPage registerPage;
	public LoginPage loginPage;

	protected BaseTest() {
		
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		Driver.initDriver();
		homePage = new HomePage();
	}
	
	@AfterMethod
	public void teardown() {
		//Driver.quitDriver();
	}
}
