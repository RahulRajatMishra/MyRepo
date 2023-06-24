package com.paramountplus.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paramountplus.genericUtility.LoggerUtility;

public class ShowsPage {

	@FindBy(css="#subnav>ul>li:nth-of-type(8)")
	private WebElement kidsSubnav;

	@FindBy(css="#main-container>section>div>article")
	private List<WebElement> popularShows; 

	@FindBy(css=".in-app-messaging.close-prompt.icon")
	private WebElement closePrompt;

	@FindBy(xpath="//div[contains(text(),'No thanks')]")
	private WebElement noThanksbtnOnPrompt;

	@FindBy(css=".aa-logo")
	private WebElement promptLogo;

	public ShowsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getKidsSubnav() {
		return kidsSubnav;
	}

	public List<WebElement> getPopularShows() {
		return popularShows;
	}

	public WebElement getClosePrompt() {
		return closePrompt;
	}

	public WebElement getNoThanksbtnOnPrompt() {
		return noThanksbtnOnPrompt;
	}

	public WebElement getPromptLogo() {
		return promptLogo;
	}

	//	Library Function
	public void closePrompt()
	{
		try {
			if(getPromptLogo().isDisplayed())
			{
				getNoThanksbtnOnPrompt().click();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			LoggerUtility.info("Prompt didn't show up");
		}
	}
}
