package moviesPage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.MoviesDetailsPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyWatchlistSelectedMovie extends BaseClass {

	@Test(groups= {"Smoke"}, description = "C1534296-Navigate_to_a_selected-watchlist_movie_page_&_C1534298-Remove_Movie_from_the_Watchlist")
	public void verifyWatchlistSelectedMovie() throws IOException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.scrollTillElementIsDisplayed(driver, homePage.getMyListCarousel());
		wLib.scrollIntoView(driver, homePage.getMyListCarousel());
		WebElement myListItem= homePage.getAllItemsInMyListCarousel().get(0);
		wLib.waitForElementToBeClickable(driver, myListItem);
		myListItem.click();
		LoggerUtility.info("Navigate to a selected-watchlist movie details page");

		MoviesDetailsPage moviesDetailsPage= new MoviesDetailsPage(driver);
		boolean flag1=  moviesDetailsPage.getWatchNowCTA().isDisplayed();
		Assert.assertTrue(flag1);
		LoggerUtility.info("Watch Now CTA is displayed");

		boolean flag2= moviesDetailsPage.getInWatchlist().isDisplayed();
		Assert.assertTrue(flag2);
		LoggerUtility.info("The selected movie page opens with a \"check mark\"");

		wLib.mouseHoverOnElement(driver, moviesDetailsPage.getMyListCTA());
		boolean flag3= moviesDetailsPage.getRemoveFromWatchlistbtn().isDisplayed();
		Assert.assertTrue(flag3);
		LoggerUtility.info("Remove from watchlist button is displayed");

		boolean flag4=	moviesDetailsPage.getMyListCTA().isDisplayed();
		Assert.assertTrue(flag4);
		LoggerUtility.info("My List is displayed next to check mark Sign- TEST PASSED");
		//C1534298-Remove_Movie_from_the_Watchlist
		moviesDetailsPage.getRemoveFromWatchlistbtn().click();
		LoggerUtility.info("Item is removed from watchlist");
	}

}
