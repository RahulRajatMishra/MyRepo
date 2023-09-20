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

	@FindBy(xpath="//div[contains(text(),'Pick Your Plan')]")
	private WebElement pickYourPlanText;

	@FindBy(xpath="//a[@aria-label='Paramount+ Home']")
	private WebElement paramountPlusLogo;
	
	@FindBy(xpath="//div[normalize-space(text())='Continue']")
	private WebElement continuebtn;
	
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
	
	public WebElement getParamountPlusLogo() {
		return paramountPlusLogo;
	}

	public WebElement getContinuebtn() {
		return continuebtn;
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
