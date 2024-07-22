package com.bookcart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookcart.base.BaseTest;

public final class HomePageTest extends BaseTest{

	private HomePageTest() {
		
	}
	
	@Test
	public void isBookCartIconAvailableTest() {
		Assert.assertTrue(homePage.isBookCartIconAvailable());
	}
	
	@Test
	public void getPageTitleTest() {
		Assert.assertEquals(homePage.getPageTitle(), "BookCart");
	}
}
