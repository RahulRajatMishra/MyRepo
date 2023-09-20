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

	@FindBy(css=".padded-container.showtime-bundle-padded-container div div .upsell-text div")
	private WebElement upsellText;

	@FindBy(css=".flexWrapper.links ul:nth-child(1) li:nth-child(3)")
	private WebElement showsFooterLink;

	@FindBy(css=".hero__cta>a")
	private WebElement tryItFreeCTA;

	@FindBy(xpath="//div[@class='icon siteLogo']")
	public WebElement footerSiteLogo;

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

	public WebElement getShowsFooterLink() {
		return showsFooterLink;
	}

	public WebElement getTryItFreeCTA() {
		return tryItFreeCTA;
	}

	public WebElement getUpsellText() {
		return upsellText;
	}

	public WebElement getFooterSiteLogo() {
		return footerSiteLogo;
	}

}


