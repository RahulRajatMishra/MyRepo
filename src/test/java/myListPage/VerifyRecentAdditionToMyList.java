package myListPage;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.MoviesDetailsPage;
import com.paramountplus.objectRepository.MoviesPage;
import com.paramountplus.objectRepository.MyListPage;
import com.paramountplus.objectRepository.ShowsDetailsPage;
import com.paramountplus.objectRepository.ShowsPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyRecentAdditionToMyList extends BaseClass{

	@Test(groups = {"Smoke"}, description = "C2187966- Verify_recently_added_shows/Movies_show_first_under_My_List")
	public void verifyRecentAdditionToMylist() throws IOException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		homePage.getMyListTab().click();
		LoggerUtility.info("My list page displayed");

		MyListPage myList= new MyListPage(driver);
		myList.getFindShowsLink().click();

		ShowsPage shows= new ShowsPage(driver);
		shows.getPopularShows().get(0).click();

		ShowsDetailsPage showsDetailsPage= new ShowsDetailsPage(driver);
		showsDetailsPage.getWatchlistCTA().click();
		homePage.getMyListTab().click();
		myList.getFindMovieLink().click();

		MoviesPage movies= new MoviesPage(driver);
		String recentlyAddedToMyList= movies.getPopularMovies().get(0).getAttribute("alt");
		movies.getPopularMovies().get(0).click();

		MoviesDetailsPage moviesDetailsPage= new MoviesDetailsPage(driver);
		moviesDetailsPage.getMyListCTA().click();
		//Assertion
		homePage.getMyListTab().click();
		String firstItemOnMyList= myList.getAllMyListItems().get(0).getAttribute("alt");
		Assert.assertEquals(recentlyAddedToMyList, firstItemOnMyList);
		LoggerUtility.info("Recently added item shows as the first item on my list- PASSED");	

		//Empty my list for next execution
		myList.clickOnEditButton();
		myList.removeMyListItems();
		wLib.pageRefreshAndWaitForElementVisibilty(driver, myList.getEmptyListText());
		boolean flag= myList.getEmptyListText().isDisplayed();
		Assert.assertTrue(flag);
		LoggerUtility.info("My list is empty");
	}
}
