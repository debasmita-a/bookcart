package com.bookcart.driverfactory;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.bookcart.utilities.ReadPropertyFile;

public final class Driver {

	/**
	 * This class will initialize the WebDriver reference 
	 * and return the driver object 
	 * 
	 */
	
	private Driver() {
		
	}
	
	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {
			System.out.println("Launching browser..");
			ChromeOptions chrome_Profile = new ChromeOptions();
			chrome_Profile.addArguments("chrome.switches","--disable-extensions"); 
			chrome_Profile.addArguments("--disable-save-password");			
			chrome_Profile.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
			DriverManager.setDriver(new ChromeDriver(chrome_Profile));		
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(ReadPropertyFile.get("url"));
			
		}
		
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
	
}
