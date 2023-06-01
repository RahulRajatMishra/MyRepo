package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpsellPage {
	@FindBy(xpath="(//a[contains(text(),'SIGN IN')])[1]")
	private WebElement signInButton;

	@FindBy(xpath="//img[@alt='Showtime bundle logo']")
	private WebElement showtimeBundleLogo;

	public UpsellPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public WebElement getShowtimeBundleLogo() {
		return showtimeBundleLogo;
	}

}


