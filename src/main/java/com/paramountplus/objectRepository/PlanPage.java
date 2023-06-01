package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.WebDriverUtility;

public class PlanPage {

	WebDriver driver= BaseClass.sdriver;
	WebDriverUtility wLib= new WebDriverUtility();

	@FindBy(xpath="//a[contains(@aa-link,'global header|user|my account|')]")
	private WebElement userAccount;

	@FindBy(xpath="//a[contains(@aa-link,'global header|user|sign out|')]")
	private WebElement signOutButton;

	@FindBy(xpath="//div[contains(text(),'First, pick your plan. Cancel anytime')]")
	private WebElement pickYourPlanText;

	public PlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserAccount() {
		return userAccount;
	}

	public WebElement getSignOutButton() {
		return signOutButton;
	}

	public WebElement getPickYourPlanText() {
		return pickYourPlanText;
	}
	//Library functions
	//	Sign out to the application
	public void logout()
	{
		PlanPage planPage= new PlanPage(driver);
		wLib.mouseHoverOnElement(driver, planPage.getUserAccount());
		planPage.getSignOutButton().click();		
		LoggerUtility.info("Signed out successfully");
	}
}
