package com.bookcart.pages;

import com.bookcart.driverfactory.DriverManager;

public final class LoginPage {

	public String getPageURL() {
		return DriverManager.getDriver().getCurrentUrl();
	}
}
