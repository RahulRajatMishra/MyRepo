package com.paramountplus.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	@FindBy(xpath="//input[@type='search']")
	private WebElement searchInputField;

	@FindBy(css= ".results-text-copy")
	private WebElement searchResults;
	
	@FindBy(xpath="//img[contains(@alt,'Star Trek')]")
	private List<WebElement> allStarTrekShows;
	
	public SearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchInputField() {
		return searchInputField;
	}

	public List<WebElement> getAllStarTrekShows() {
		return allStarTrekShows;
	}

	public WebElement getSearchResults() {
		return searchResults;
	}
	
	
}
