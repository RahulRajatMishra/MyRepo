package showsPage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.ShowsDetailsPage;
import com.paramountplus.objectRepository.ShowsPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyNonWatchlistSelectedShow extends BaseClass {

	@Test(priority = 1, groups = {"Smoke"}, description = "C1533413-Navigate_to_a_non-watchlist_selected_show_page")
	public void verifyNonWatchlistSelectedShow() throws Exception
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.scrollTillElementIsDisplayed(driver, homePage.getHorrorMoviesCarousel());
		wLib.scrollIntoView(driver, homePage.getHorrorMoviesCarousel());
		WebElement firstShow= homePage.getAllItemsInHorrorMoviesCarousel().get(0);
		boolean flag1= firstShow.isDisplayed();
		Assert.assertTrue(flag1);
		firstShow.click();
		wLib.waitTillcurrectURLContains(driver, "movies");
		LoggerUtility.info("First show is selected");
	}
	@Test(priority = 2, groups = {"Smoke"}, description = "C1533533- Add_Show_to_the_Watchlist")
	public void addShowToMyList()
	{
		ShowsDetailsPage showsDetailsPage= new ShowsDetailsPage(driver);
		boolean flag2=  showsDetailsPage.getWatchNowCTA().isDisplayed();
		Assert.assertTrue(flag2);
		LoggerUtility.info("Watch Now CTA is displayed");
        wLib.waitForElementToBeVisible(driver, showsDetailsPage.getMyListText());
		wLib.mouseHoverOnElement(driver, showsDetailsPage.getWatchlistCTA());
		boolean flag3= showsDetailsPage.getAddToWatchlistbtn().isDisplayed();
		Assert.assertTrue(flag3);
		LoggerUtility.info("\"plus Sign\" is displayed next to watch now CTA");

		String myListText= showsDetailsPage.getMyListText().getText().toLowerCase();
		Assert.assertEquals("my list", myListText);
		LoggerUtility.info("My List is displayed next to plus Sign- TEST PASSED");

		//Prepare pre condition for VerifyWatchListSelectedShow
		//C1533533- Add_Show_to_the_Watchlist
		showsDetailsPage.getAddToWatchlistbtn().click();
		wLib.mouseHoverOnElement(driver, showsDetailsPage.getWatchlistCTA());
		boolean flag4= showsDetailsPage.getInWatchlist().isDisplayed();
		Assert.assertTrue(flag4);
		LoggerUtility.info("Added to Watchlist");
	}
}
