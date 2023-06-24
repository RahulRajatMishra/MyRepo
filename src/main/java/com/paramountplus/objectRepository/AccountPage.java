package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	@FindBy(css=".interstitial-steps-title")
	private WebElement createAccountTitle;
	
	@FindBy(css="button[aria-label='Continue']")
	private WebElement continuebtn;

	public AccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateAccountTitle() {
		return createAccountTitle;
	}

	public WebElement getContinuebtn() {
		return continuebtn;
	}
	
}
