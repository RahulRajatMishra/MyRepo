package showsPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.ShowsDetailsPage;
import com.paramountplus.objectRepository.ShowsPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyHideRainmaker extends BaseClass {

	@Test(groups= {"Smoke"}, description = "C1503128_Show_page_Hide_Rainmaker")
	public void verifyHideRainmaker() throws IOException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatchingPage= new WhosWatchingPage(driver);
		whosWatchingPage.selectMainProfile();

		driver.get("https://stage.paramountplus.com/shows/");
		LoggerUtility.info("Navigated to shows page");

		ShowsPage showsPage= new ShowsPage(driver);
		showsPage.getPopularShows().get(1).click();
		LoggerUtility.info("Navigated to show detail page");

		ShowsDetailsPage showsDetailsPage= new ShowsDetailsPage(driver);
		wLib.waitForElementToBeVisible(driver, showsDetailsPage.getWatchNowCTA());
		wLib.scrollToBottom(driver);
		boolean flag= wLib.isElementFound(driver, showsDetailsPage.getRainmakerLogo());
		Assert.assertFalse(flag);
		LoggerUtility.info("The Rainmaker is not displayed_TEST PASSED");

	}
}
