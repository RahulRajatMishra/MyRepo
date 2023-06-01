package com.paramountplus.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoviesPage {

	@FindBy(css=".movie-browse-grid.browse-grid.grid.portrait>article")
	private List<WebElement> popularMovies;
	
	public MoviesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getPopularMovies() {
		return popularMovies;
	}
}
