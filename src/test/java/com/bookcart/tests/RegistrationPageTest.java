package com.bookcart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookcart.base.BaseTest;
import com.bookcart.pages.LoginPage;

public final class RegistrationPageTest extends BaseTest {

	private RegistrationPageTest() {
		
	}
	
	@Test
	public void getPageTitleTest() {
		registerPage = homePage.clickRegisterLink();
		Assert.assertEquals(registerPage.getPageTitle(), "BookCart");
	}
	
	@Test
	public void doRegistrationTest() throws InterruptedException {
		registerPage = homePage.clickRegisterLink();
		registerPage.enterFirstName("Sand1").enterLastName("Worm1")
		.enterUserName("sand_worm5555").enterPassword("SandWorm@243!").enterConfirmPassword("SandWorm@243!")
		.selectGenderOption("Male")
		.doRegistration();
		loginPage = new LoginPage();
	//	Assert.assertTrue(loginPage.getPageURL().contains("login"));
	}
	
	@Test
	public void isRegisterBtnAvailableTest(){
		registerPage = homePage.clickRegisterLink();
		registerPage.isRegisterBtnAvailable();
	}
}
