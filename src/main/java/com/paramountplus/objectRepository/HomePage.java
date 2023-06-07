package com.paramountplus.objectRepository;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.WebDriverUtility;

public class HomePage {
	WebDriver driver= BaseClass.sdriver;
	WebDriverUtility wLib= new WebDriverUtility();
	//	@CacheLookup
	@FindBy(css=".header__nav--withsubMenu")
	private WebElement avatarImage;

	@FindBy(xpath="//ul[@class='header__subnav content']/li/a[contains(text(),'Sign Out')]")
	private WebElement signOut;

	@FindBy(xpath="//a[@data-ci='PPlus_logo']")
	private WebElement paramountPlusLogo;

	@FindBy(css=".navigation.header__nav--items>li:first-of-type")
	private WebElement showsTab;

	@FindBy(css=".navigation.header__nav--items>li:nth-of-type(7)")
	private WebElement myListTab;

	@FindBy(xpath="//a[@aria-label='Search']")
	private WebElement searchLink;

	@FindBy(xpath="//div[@class='avname']/a[text()='AdultUser']")
	private WebElement adultUser;

	@FindBy(xpath="//div[@class='avname']/a[text()='KidsUser']")
	private WebElement kidsUser;

	@FindBy(css="#user-profiles-menu-trigger li button div:nth-child(2)")
	private WebElement currentUserProfile;

	@FindBy(xpath="//a[text()='Add Profile']")
	private WebElement addProfileLink;

	@FindBy(xpath="//a[contains(text(),'Manage Profiles')]")
	private WebElement managePrifile;

	@FindBy(xpath="//a[contains(@data-impression,'NEW')]")
	private List<WebElement> newContents;

	@FindBy(xpath="//a[contains(@data-impression,'JUST ADDED')]")
	private List<WebElement> justAdded;

	@FindBy(xpath="//h2[contains(text(),'Keep Watching')]")
	private WebElement keepWatchingCarousel;

	@FindBy(css="#user-profiles-menu-app li")
	private WebElement switchProfileLink;

	@FindBy(xpath="//footer/div[@aria-label='Paramount+ Home']")
	private WebElement footerParamountPluslogo;

	@FindBy(css="section#my-list")
	private WebElement myListCarousel;

	@FindBy(css="section#my-list div div div div div div div img")
	private List<WebElement> allItemsInMyListCarousel;
	
	@FindBy(xpath="//h2[contains(text(),'My List')]")
	private WebElement myListText;
	
	@FindBy(xpath="//div[@has-my-list-listener='true']")
	private WebElement hasMyList; /* This attribute is present if there is no My List carousel*/
 
	@FindBy(xpath="//section[@id='showtime-shows-&-movies']")
	private WebElement showtimeShowsMoviesCarousel;
	
	@FindBy(xpath="//section[@id='showtime-shows-&-movies']/div/div/div/div/div/div/div")
	private List<WebElement> allItemsInShowtimeShowsMoviesCarousel;
	
	@FindBy(css="a[aria-label='Next Slides'][aa-link*='showtime']")
	private WebElement showtimeShowsAndMoviesNextSlideLink;
	
	@FindBy(css="section#horror-movies")
	private WebElement horrorMoviesCarousel;
	
	@FindBy(css="section#horror-movies div div div div div div div a")
	private List<WebElement> allItemsInHorrorMoviesCarousel;
	
	@FindBy(css="section#animated-movies")
	private WebElement annimatedMoviesCarousel;
	
	@FindBy(css="section#animated-movies div div div div div div div a")
	private List<WebElement> allItemsInAnnimatedMoviesCarousel;
	
	@FindBy(css="section#sci-fi-movies")
	private WebElement sciFiMoviesCarousel;
	
	@FindBy(css="section#sci-fi-movies div div div div div div div a")
	private WebElement allItemsInSciFiMoviesCarousel;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAvatarImage() {
		return avatarImage;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	public WebElement getParamountPlusHomeLogo() {
		return paramountPlusLogo;
	}

	public WebElement getSearchLink() {
		return searchLink;
	}

	public WebElement getAdultUser() {
		return adultUser;
	}

	public WebElement getKidsUser() {
		return kidsUser;
	}

	public WebElement getCurrentUserProfile() {
		return currentUserProfile;
	}

	public List<WebElement> getNewContents() {
		return newContents;
	}

	public List<WebElement> getJustAdded() {
		return justAdded;
	}

	public WebElement getAddProfileLink() {
		return addProfileLink;
	}

	public WebElement getManagePrifile() {
		return managePrifile;
	}

	public WebElement getShowsTab() {
		return showsTab;
	}

	public WebElement getMyListTab() {
		return myListTab;
	}
	public WebElement getKeepWatchingCarousel() {
		return keepWatchingCarousel;
	}
	public WebElement getSwitchProfileLink() {
		return switchProfileLink;
	}
	public WebElement getFooterParamountPluslogo() {
		return footerParamountPluslogo;
	}
	public WebElement getMyListCarousel() {
		return myListCarousel;
	}
	public WebElement getMyListText() {
		return myListText;
	}
	public WebElement getShowtimeShowsMoviesCarousel() {
		return showtimeShowsMoviesCarousel;
	}
	public List<WebElement> getAllItemsInShowtimeShowsMoviesCarousel() {
		return allItemsInShowtimeShowsMoviesCarousel;
	}
	public List<WebElement> getAllItemsInMyListCarousel() {
		return allItemsInMyListCarousel;
	}
	public WebElement getHorrorMoviesCarousel() {
		return horrorMoviesCarousel;
	}

	public List<WebElement> getAllItemsInHorrorMoviesCarousel() {
		return allItemsInHorrorMoviesCarousel;
	}

	public WebElement getAnnimatedMoviesCarousel() {
		return annimatedMoviesCarousel;
	}

	public List<WebElement> getAllItemsInAnnimatedMoviesCarousel() {
		return allItemsInAnnimatedMoviesCarousel;
	}

	public WebElement getSciFiMoviesCarousel() {
		return sciFiMoviesCarousel;
	}

	public WebElement getAllItemsInSciFiMoviesCarousel() {
		return allItemsInSciFiMoviesCarousel;
	}
	public WebElement getShowtimeShowsAndMoviesNextSlideLink() {
		return showtimeShowsAndMoviesNextSlideLink;
	}

	// Library functions
	public void logout()
	{
		HomePage homePage= new HomePage(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getAvatarImage());
		wLib.mouseHoverOnElement(driver, homePage.getAvatarImage());

		wLib.waitForElementToBeClickable(driver, homePage.getSignOut());
		homePage.getSignOut().click();
		LoggerUtility.info("Signed out successfully");
	}
	public String checkCurrentProfileContains(String currentProfile) throws InterruptedException
	{
		String profileName=null;
		int count=0;
		while(count<5) 
		{
			profileName= getCurrentUserProfile().getText().toLowerCase();
			if(profileName.contains(currentProfile))
			{
				break;
			}
			else
			{
				Thread.sleep(1000);
			}
			count++;
		}
		return profileName;
	}

}
