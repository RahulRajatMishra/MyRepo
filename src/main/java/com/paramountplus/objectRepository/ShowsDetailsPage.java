package com.paramountplus.objectRepository;

import java.util.List;

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

	@FindBy(css=".rainmaker-logo")
	private WebElement rainmakerLogo;

	@FindBy(css="#js-rainmaker-close-out")
	private WebElement closeRainmakerbtn;

	@FindBy(xpath="//a[@class='hovered' and @title='Add to watchlist']")
	private WebElement addToWatchlistToolTip;

	@FindBy(xpath="//a[@class='in_watchlist hovered' and @title='Remove from watchlist']")
	private WebElement removeFromWatchlistToolTip;

	@FindBy(xpath="//button[@title='Unmute Audio' and @class='hero-volume muted']")
	private WebElement unmuteToolTip;

	@FindBy(xpath="//button[@title='Mute Audio' and @class='hero-volume']")
	private WebElement muteToolTip;

	@FindBy(xpath="//div[normalize-space(text())='TRY IT FREE']")
	private WebElement tryItFreeCTA;

	@FindBy(css=".bottom-right-content button")
	private WebElement volumeButton;

	@FindBy(xpath="//span[contains(text(),'SUBSCRIBE')]")
	private List<WebElement> lockedEpisodes;

	@FindBy(xpath="//div[contains(text(),'Sign up for Paramount+ to stream this video.')]")
	private WebElement msgOnLockedEpisodes;

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

	public WebElement getRainmakerLogo() {
		return rainmakerLogo;
	}

	public WebElement getCloseRainmakerbtn() {
		return closeRainmakerbtn;
	}

	public WebElement getTryItFreeCTA() {
		return tryItFreeCTA;
	}

	public WebElement getAddToWatchlistToolTip() {
		return addToWatchlistToolTip;
	}

	public WebElement getRemoveFromWatchlistToolTip() {
		return removeFromWatchlistToolTip;
	}

	public WebElement getUnmuteToolTip() {
		return unmuteToolTip;
	}

	public WebElement getMuteToolTip() {
		return muteToolTip;
	}

	public WebElement getVolumeButton() {
		return volumeButton;
	}

	public List<WebElement> getLockedEpisodes() {
		return lockedEpisodes;
	}

	public WebElement getMsgOnLockedEpisodes() {
		return msgOnLockedEpisodes;
	}

}
