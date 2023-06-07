package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoviesDetailsPage {

	@FindBy(css=".button.focusable.playIcon.watchMovieButton.buttonWindows")
	private WebElement watchNowCTA;
	
	@FindBy(css="div.watchlist_wrapper.initialized.in_movie_page>a#watchlistCta")
	private WebElement myListCTA;
	
	@FindBy(css="a[title='Add to watchlist']")
	private WebElement addToWatchlistbtn;
	
	@FindBy(css=".in_watchlist")
	private WebElement inWatchlist;
	
	@FindBy(css="a[title='Remove from watchlist']")
	private WebElement removeFromWatchlistbtn;

	public MoviesDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getMyListCTA() {
		return myListCTA;
	}
	public WebElement getWatchNowCTA() {
		return watchNowCTA;
	}
	public WebElement getAddToWatchlistbtn() {
		return addToWatchlistbtn;
	}
	public WebElement getInWatchlist() {
		return inWatchlist;
	}
	public WebElement getRemoveFromWatchlistbtn() {
		return removeFromWatchlistbtn;
	}
	
}
