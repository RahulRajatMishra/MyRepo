package moviesPage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.MoviesDetailsPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyNonWatchlistSelectedMovie extends BaseClass{

	@Test(priority = 1, groups = {"Smoke"}, description = "C1533414_Navigate_to_movie_page")
	public void verifyNonWatchlistSelectMovie() throws Exception
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.scrollTillElementIsDisplayed(driver, homePage.getHorrorMoviesCarousel());
		wLib.scrollIntoView(driver, homePage.getHorrorMoviesCarousel());
		WebElement firstMovie= homePage.getAllItemsInHorrorMoviesCarousel().get(0);
		firstMovie.click();
		wLib.waitTillcurrectURLContains(driver, "movies");
		LoggerUtility.info("User is taken to movie details page");
	}
	@Test(priority = 2,description = "C1534297_Add_Movie_to_the_Watchlist")
	public void addMovieToMyList()
	{ 
		MoviesDetailsPage moviesDetailsPage= new MoviesDetailsPage(driver);
		boolean flag1= moviesDetailsPage.getWatchNowCTA().isDisplayed();
		Assert.assertTrue(flag1);
		LoggerUtility.info("Watch now CTA is displayed");

		boolean flag2= moviesDetailsPage.getMyListCTA().isDisplayed();
		Assert.assertTrue(flag2);
		LoggerUtility.info("My List CTA is displayed");

		wLib.mouseHoverOnElement(driver, moviesDetailsPage.getMyListCTA());
		boolean flag3= moviesDetailsPage.getAddToWatchlistbtn().isDisplayed();
		Assert.assertTrue(flag3);
		LoggerUtility.info("Movie is not in watchlist-\"plus Sign\" displayed");

		//C1534297_Add_Movie_to_the_Watchlist
		moviesDetailsPage.getAddToWatchlistbtn().click();
		wLib.mouseHoverOnElement(driver, moviesDetailsPage.getMyListCTA());
		boolean flag4= moviesDetailsPage.getInWatchlist().isDisplayed();
		Assert.assertTrue(flag4);
		LoggerUtility.info("Movie is added to watchlist- TEST PASSED");
	}
}
