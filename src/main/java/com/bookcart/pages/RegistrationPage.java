package com.bookcart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bookcart.driverfactory.DriverManager;

public final class RegistrationPage {

	private static final By textbox_firstName = By.id("mat-input-2");
	private static final By textbox_lastName = By.id("mat-input-3");
	private static final By textbox_userName = By.id("mat-input-4");
	private static final By textbox_password = By.id("mat-input-5");
	private static final By textbox_confirmPass = By.id("mat-input-6");
	private static final By radioBtn_option1 = By.xpath("(//input[@type='radio'])[1]");
	private static final By radioBtn_option2 = By.xpath("(//input[@type='radio'])[2]");

	private static final String radioBtn_xpath = "//input[@value='%value%']";
	private static final By btn_register = By.xpath("//span[contains(@class,'mdc-button') and text()='Register']");

	public String getPageTitle() {
		System.out.println("Register Page title..");
		return DriverManager.getDriver().getTitle();
	}

	public String getPageURL() {
		return DriverManager.getDriver().getCurrentUrl();
	}

	public RegistrationPage enterFirstName(String firstname) {
		DriverManager.getDriver().findElement(textbox_firstName).sendKeys(firstname);
		;
		return this;
	}

	public RegistrationPage enterLastName(String lastname) {
		DriverManager.getDriver().findElement(textbox_lastName).sendKeys(lastname);
		return this;
	}

	public RegistrationPage enterUserName(String username) {
		DriverManager.getDriver().findElement(textbox_userName).sendKeys(username);
		;
		return this;
	}

	public RegistrationPage enterPassword(String pass) {
		DriverManager.getDriver().findElement(textbox_password).sendKeys(pass);
		;
		return this;
	}

	public RegistrationPage enterConfirmPassword(String pass) {
		DriverManager.getDriver().findElement(textbox_confirmPass).sendKeys(pass);
		;
		return this;
	}

	public RegistrationPage doRegistration() throws InterruptedException {
	
		WebElement regBtn = DriverManager.getDriver().findElement(btn_register);
		
		//Thread.sleep(5000);
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeSelected(regBtn));
		regBtn.click();
		
		return this;
	}

	public void isRegisterBtnAvailable() {
		System.out.println(DriverManager.getDriver().findElement(btn_register).getAttribute("class"));
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(btn_register));
	}

	public RegistrationPage selectGenderOption(String genderValue) {
		DriverManager.getDriver().findElement(By.xpath(radioBtn_xpath.replace("%value%", genderValue))).click();
		return this;
	}

}
