package com.bookcart.driverfactory;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	/**
	 * This class will manage the driver object
	 * This class is responsible for making the driver object thread-safe
	 * 
	 */
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	private DriverManager() {
		
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public static void setDriver(WebDriver tlDriverRef) {
		tlDriver.set(tlDriverRef);
	}
	
	public static void unload() {
		tlDriver.remove();
	}
	
}
