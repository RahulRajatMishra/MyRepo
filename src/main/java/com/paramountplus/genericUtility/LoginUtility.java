package com.paramountplus.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.PlanPage;
import com.paramountplus.objectRepository.UpsellPage;

public class LoginUtility {

	WebDriver driver= BaseClass.sdriver;
	FileUtility fLib= new FileUtility();
	WebDriverUtility wLib= new WebDriverUtility();
	UpsellPage upsellPage= new UpsellPage(driver);
	LoginPage loginPage= new LoginPage(driver);

	//	Sign in to the application
	public void loginWithBundle() throws IOException
	{
		
		upsellPage.getSignInButton().click();
		LoggerUtility.info("Login page displayed");
		loginPage.getUserNameInputField().sendKeys("AutoM.Essential@withBundle1.com");
		loginPage.getPasswordInputField().sendKeys("123456");
		for(int i=0; i<3;i++)
		{
			try {
				loginPage.getContinueButton().click();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				wLib.waitForElementToBeClickable(driver, loginPage.getContinueButton());
				loginPage.getContinueButton().click();
			}
		}
		LoggerUtility.info("Bundle user- Signed in successfully");
	}
	
	public void loginWithoutBundle() throws IOException
	{
		upsellPage.getSignInButton().click();
		LoggerUtility.info("Login page displayed");
		loginPage.getUserNameInputField().sendKeys("AutoM.Essential@withoutBundle1.com");
		loginPage.getPasswordInputField().sendKeys("123456");
		for(int i=0; i<3;i++)
		{
			try {
				loginPage.getContinueButton().click();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				wLib.waitForElementToBeClickable(driver, loginPage.getContinueButton());
				loginPage.getContinueButton().click();
			}
		}
		LoggerUtility.info("Non-bundle user- Signed in successfully");
	}
	public void loginExSubscriber() throws IOException
	{
		upsellPage.getSignInButton().click();
		LoggerUtility.info("Login page displayed");
		loginPage.getUserNameInputField().sendKeys("exsub@stage5.com");
		loginPage.getPasswordInputField().sendKeys("aaaaaa");
		for(int i=0; i<3;i++)
		{
			try {
				loginPage.getContinueButton().click();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				wLib.waitForElementToBeClickable(driver, loginPage.getContinueButton());
				loginPage.getContinueButton().click();
			}
		}
		LoggerUtility.info("Non-bundle user- Signed in successfully");
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
