package com.paramountplus.objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.FileUtility;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.WebDriverUtility;

public class LoginPage {

	WebDriver driver= BaseClass.sdriver;
	FileUtility fLib= new FileUtility();
	WebDriverUtility wLib= new WebDriverUtility();
	UpsellPage upsellPage= new UpsellPage(driver);
	//	LoginPage loginPage= new LoginPage(driver);

	@FindBy(id="email")
	private WebElement userNameInputField;

	@FindBy(id= "password")
	private WebElement passwordInputField;

	@FindBy(xpath="//div[contains(text(),'Continue')]")
	private WebElement continueButton;

	@FindBy(xpath="//div/p[@role='alert']")
	private WebElement errorMessage;

	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	private WebElement signUpLink;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameInputField() {
		return userNameInputField;
	}


	public WebElement getPasswordInputField() {
		return passwordInputField;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public WebElement getSignUpLink() {
		return signUpLink;
	}

	//	Library functions
	public void loginWithBundle() throws IOException
	{
		upsellPage.getSignInButton().click();
		LoggerUtility.info("Login page displayed");
		getUserNameInputField().sendKeys("AutoM.Essential@withBundle1.com");
		getPasswordInputField().sendKeys("123456");
		for(int i=0; i<3;i++)
		{
			try {
				getContinueButton().click();
				if(!getSignUpLink().isDisplayed())
				{
					break;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				wLib.waitForElementToBeClickable(driver, getContinueButton());
			}
		}
		LoggerUtility.info("Bundle user- Signed in successfully");
	}

	public void loginWithoutBundle() throws IOException
	{
		upsellPage.getSignInButton().click();
		LoggerUtility.info("Login page displayed");
		getUserNameInputField().sendKeys("AutoM.Essential@withoutBundle1.com");
		getPasswordInputField().sendKeys("123456");
		for(int i=0; i<3;i++)
		{
			try {
				getContinueButton().click();
				if(!getContinueButton().isDisplayed())
				{
					break;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				wLib.waitForElementToBeClickable(driver, getContinueButton());
			}
		}
		LoggerUtility.info("Non-bundle user- Signed in successfully");
	}
	public void loginExSubscriber() throws IOException
	{
		wLib.waitForElementToBeClickable(driver, upsellPage.getSignInButton());
		upsellPage.getSignInButton().click();
		LoggerUtility.info("Login page displayed");
		getUserNameInputField().sendKeys("exsub@stage5.com");
		getPasswordInputField().sendKeys("aaaaaa");
		for(int i=0; i<3;i++)
		{
			try {
				getContinueButton().click();
				if(!getSignUpLink().isDisplayed())
				{
					break;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				wLib.waitForElementToBeClickable(driver, getContinueButton());
			}
		}
		LoggerUtility.info(" Ex-subscriber- Signed in successfully");
	}

	//	Sign out to the application
	public void logout()
	{
		HomePage homePage= new HomePage(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getAvatarImage());
		wLib.mouseHoverOnElement(driver, homePage.getAvatarImage());

		wLib.waitForElementToBeClickable(driver, homePage.getSignOut());
		homePage.getSignOut().click();

		LoggerUtility.info("Signed out successfully");
	}
}
