package com.paramountplus.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.WebDriverUtility;

public class WhosWatchingPage {

	WebDriver driver= BaseClass.sdriver;
	WebDriverUtility wLib= new WebDriverUtility();
	@FindBy(xpath="//div[@class='profile-hdr']")
	private WebElement WhosWatchingHeader;

	@FindBy(css="#who-s-watching>ul>li:first-of-type")
	private WebElement mainProfile;

	@FindBy(css="#who-s-watching>ul>li")
	private List<WebElement> allProfile;

	@FindBy(css="#who-s-watching>ul>li:last-of-type")
	private WebElement addProfilebtn;

	public WhosWatchingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getMainProfile() {
		return mainProfile;
	}

	public WebElement getWhosWatchingHeader() {
		return WhosWatchingHeader;
	}

	public List<WebElement> getAllProfile() {
		return allProfile;
	}

	public WebElement getAddProfilebtn() {
		return addProfilebtn;
	}

	//Library functions

	public void selectMainProfile()
	{
		try {
			if(WhosWatchingHeader.isDisplayed())
			{
				getMainProfile().click();
				LoggerUtility.info("Who is watching page displayed");
				LoggerUtility.info("User landed on home page");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			LoggerUtility.error("Who is watching page not displayed");
			LoggerUtility.info("User landed on home page");
		}
	}
	public void selectTestProfile()
	{
		List<WebElement> allProfile= getAllProfile();
		wLib.waitForElementToBeVisible(driver, WhosWatchingHeader);
		LoggerUtility.info("User is landed on who's watching page");
		for(WebElement profile: allProfile)
		{
			String currentProfile= profile.getText();
			if(currentProfile.toLowerCase().contains("test"))
			{
				profile.click();
				break;
			}
		}
	}
	public void selectOlderKidsTestProfile()
	{
		List<WebElement> allProfile= getAllProfile();
		wLib.waitForElementToBeVisible(driver, WhosWatchingHeader);
		LoggerUtility.info("User is landed on who's watching page");
		for(WebElement profile: allProfile)
		{
			String currentProfile= profile.getText();
			if(currentProfile.toLowerCase().contains("olderkids"))
			{
				profile.click();
				break;
			}
			else {
				LoggerUtility.info(currentProfile+" does not contains olderkids");
			}
		}
	}

}
