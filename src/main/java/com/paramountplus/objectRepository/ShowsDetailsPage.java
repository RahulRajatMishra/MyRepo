package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowsDetailsPage {

	@FindBy(xpath="//div[contains(text(),'WATCH NOW')]")
	private WebElement watchNowCTA;

	@FindBy(css="#watchlistCta")
	private WebElement watchlistCTA;

	@FindBy(css=".in_watchlist")
	private WebElement inWatchlist;

	@FindBy(css=".mylist")
	private WebElement myListText;

	@FindBy(xpath="//a[@title='Add to watchlist']")
	private WebElement addToWatchlistbtn;

	@FindBy(xpath="//a[@title='Remove from watchlist']")
	private WebElement removeFromWatchlistbtn;

	public ShowsDetailsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getWatchNowCTA() {
		return watchNowCTA;
	}

	public WebElement getWatchlistCTA() {
		return watchlistCTA;
	}

	public WebElement getInWatchlist() {
		return inWatchlist;
	}

	public WebElement getMyListText() {
		return myListText;
	}

	public WebElement getAddToWatchlistbtn() {
		return addToWatchlistbtn;
	}

	public WebElement getRemoveFromWatchlistbtn() {
		return removeFromWatchlistbtn;
	}
}
