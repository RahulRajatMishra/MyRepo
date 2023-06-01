package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoviesDetailsPage {

	@FindBy(css="div.watchlist_wrapper.initialized.in_movie_page>a#watchlistCta")
	private WebElement myListCTA;

	public MoviesDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getMyListCTA() {
		return myListCTA;
	}
}
