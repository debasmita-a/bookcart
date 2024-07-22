package com.bookcart.pages;

import org.openqa.selenium.By;

import com.bookcart.driverfactory.DriverManager;

public final class HomePage {

	private static final By link_bookcart = By.xpath("//span[text()=' Book Cart ']");
	private static final By link_login = By.xpath("//span[text()=' Login ']");
	private static final By link_register = By.xpath("//span[text()='Register']");
	private static final By searchbox = By.xpath("//input[@placeholder='Search books or authors']");

	public boolean isBookCartIconAvailable() {
		return DriverManager.getDriver().findElement(link_bookcart).isDisplayed();
	}
	
	public HomePage clickLoginLink() {
		DriverManager.getDriver().findElement(link_login).click();
		return this;
	}
	
	public String getPageTitle() {
		System.out.println("Home Page title..");
		return DriverManager.getDriver().getTitle();
	}
	
	public RegistrationPage clickRegisterLink() {
		DriverManager.getDriver().findElement(link_login).click();
		DriverManager.getDriver().findElement(link_register).click();
		return new RegistrationPage();
	}
	
}
