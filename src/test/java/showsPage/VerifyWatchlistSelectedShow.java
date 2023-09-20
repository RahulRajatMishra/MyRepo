package showsPage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.ShowsDetailsPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyWatchlistSelectedShow extends BaseClass{

	@Test(priority = 1, groups = {"Smoke"}, description = "C1533416-Navigate_to_a_selected-watchlist_show_page")
	public void verifyWatchlistSelectedShow() throws Exception
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.scrollTillElementIsDisplayed(driver, homePage.getMyListCarousel());
//		wLib.scrollTillAllElementsLoaded(driver);
		wLib.scrollIntoView(driver, homePage.getMyListCarousel());
		wLib.waitForElementToBeVisible(driver, homePage.getMyListCarousel());
		WebElement myListItem= homePage.getAllItemsInMyListCarousel().get(0);
//		wLib.waitForElementToBeClickable(driver, myListItem);
		myListItem.click();
		LoggerUtility.info("Navigate to a selected-watchlist show page");

		ShowsDetailsPage showsDetailsPage= new ShowsDetailsPage(driver);
		boolean flag1=  showsDetailsPage.getWatchNowCTA().isDisplayed();
		Assert.assertTrue(flag1);
		LoggerUtility.info("Watch Now CTA is displayed");

		boolean flag2= showsDetailsPage.getInWatchlist().isDisplayed();
		Assert.assertTrue(flag2);
		LoggerUtility.info("The selected show page opens with a \"check mark\"");

		boolean flag3 =showsDetailsPage.getMyListText().isDisplayed();
		Assert.assertTrue(flag3);
		LoggerUtility.info("My List is displayed next to check mark Sign- TEST PASSED");
	}
	@Test(priority = 2, groups = {"Smoke"},description = "C1534294-Remove_Show_from_the_Watchlist")
	public void removeShowFromMyList()
	{
		ShowsDetailsPage showsDetailsPage= new ShowsDetailsPage(driver);
		wLib.mouseHoverOnElement(driver, showsDetailsPage.getWatchlistCTA());
		boolean flag1= showsDetailsPage.getRemoveFromWatchlistbtn().isDisplayed();
		Assert.assertTrue(flag1);
		LoggerUtility.info("Remove from watchlist button is displayed");
		showsDetailsPage.getRemoveFromWatchlistbtn().click();
		wLib.pageRefreshAndWaitForElementVisibilty(driver, showsDetailsPage.getWatchlistCTA());
		wLib.mouseHoverOnElement(driver, showsDetailsPage.getWatchlistCTA());
		boolean flag2= showsDetailsPage.getAddToWatchlistbtn().isDisplayed();
		Assert.assertTrue(flag2);
		LoggerUtility.info("Item is removed from watchlist");

	}
}
