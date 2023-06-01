package homePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyMyListCarouselDisplayed extends BaseClass {

	@Test(groups= {"Smoke", "Regression"}, description = "C1534304-At_least_1_show/movie_is_selected_for_watchlist")
	public void verifyMyListCarouselIsDisplayed() throws Exception
	{
		LoginPage loginPage= new LoginPage(driver);
		loginPage.loginWithoutBundle();;

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.scrollTillAllElementsLoaded(driver);
		boolean flag= wLib.isElementFound(driver, homePage.getMyListCarousel());
		Assert.assertTrue(flag);
		String text= homePage.getMyListText().getText().toLowerCase();
		Assert.assertEquals("my list", text);
		LoggerUtility.info("The watchlist carousel is displayed on the Homepage at the top of the page with the title \"My List\"");
	}
}
