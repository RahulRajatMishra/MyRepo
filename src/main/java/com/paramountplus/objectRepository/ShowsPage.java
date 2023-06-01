package com.paramountplus.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowsPage {

	@FindBy(css="#subnav>ul>li:nth-of-type(8)")
	private WebElement kidsSubnav;

	@FindBy(css="#main-container>section>div>article")
	private List<WebElement> popularShows; 

	public ShowsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getKidsSubnav() {
		return kidsSubnav;
	}

	public List<WebElement> getPopularShows() {
		return popularShows;
	}
}
