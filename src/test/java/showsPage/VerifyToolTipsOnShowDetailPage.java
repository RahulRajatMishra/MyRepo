package showsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.ShowsDetailsPage;
import com.paramountplus.objectRepository.ShowsPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyToolTipsOnShowDetailPage extends BaseClass {

	@Test(groups = {"Regression"}, description = "C2402437-Tool Tips implemented on Icons")
	public void verifyToolTips() throws Exception
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatchingPage= new WhosWatchingPage(driver);
		whosWatchingPage.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		homePage.getShowsTab().click();

		ShowsPage showsPage= new ShowsPage(driver);
		showsPage.getPopularShows().get(0).click();

		ShowsDetailsPage showsDetailsPage= new ShowsDetailsPage(driver);
		wLib.waitForElementToBeVisible(driver, showsDetailsPage.getUnmuteToolTip());
		boolean flag1=showsDetailsPage.getUnmuteToolTip().isDisplayed();
		Assert.assertTrue(flag1);
		LoggerUtility.info("UNMUTE- Tooltip displayed");

		showsDetailsPage.getVolumeButton().click();
		wLib.waitForElementToBeVisible(driver, showsDetailsPage.getMuteToolTip());
		boolean flag2=showsDetailsPage.getMuteToolTip().isDisplayed();
		Assert.assertTrue(flag2);
		LoggerUtility.info("MUTE- Tooltip displayed");
		wLib.mouseHoverOnElement(driver, showsDetailsPage.getWatchlistCTA());
		boolean flag3=showsDetailsPage.getAddToWatchlistToolTip().isDisplayed();
		Assert.assertTrue(flag3);
		LoggerUtility.info("Add to watchlist- Tooltip is dispalyed");

		showsDetailsPage.getWatchlistCTA().click();
		driver.navigate().refresh();
		wLib.mouseHoverOnElement(driver, showsDetailsPage.getWatchlistCTA());
		boolean flag4=showsDetailsPage.getRemoveFromWatchlistToolTip().isDisplayed();
		Assert.assertTrue(flag4);
		LoggerUtility.info("Remove from watchlist- Tooltip is displayed");

		showsDetailsPage.getWatchlistCTA().click();
		driver.navigate().refresh();
		wLib.mouseHoverOnElement(driver, showsDetailsPage.getWatchlistCTA());
		wLib.waitForElementToBeVisible(driver, showsDetailsPage.getAddToWatchlistbtn());
		LoggerUtility.info("Show removed from watchlist");
	}
}
