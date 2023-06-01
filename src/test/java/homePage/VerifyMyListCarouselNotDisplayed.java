package homePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyMyListCarouselNotDisplayed extends BaseClass {

	@Test(groups= {"Smoke", "Regression"}, description = "C1533531-If_no_shows/movies_were_added_to_Watchlist")
	public void verifyNoMyListCarousel() throws Exception
	{
		LoginPage loginPage= new LoginPage(driver);
		loginPage.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.scrollTillAllElementsLoaded(driver);
		boolean flag= wLib.isElementFound(driver, homePage.getMyListCarousel());
		Assert.assertFalse(flag);
		LoggerUtility.info("My List carousel is not displayed- TEST PASSED");

	}
}
