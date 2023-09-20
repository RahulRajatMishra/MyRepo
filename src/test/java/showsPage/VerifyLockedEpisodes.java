package showsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.ShowsDetailsPage;
import com.paramountplus.objectRepository.ShowsPage;

public class VerifyLockedEpisodes extends BaseClass{

	@Test
	public void verifyLockedEpisodes()
	{
		//C1503125- Navigate to Shows page
		driver.get(" https://stage.paramountplus.com/shows/");
		LoggerUtility.info("Navigated to shows page");

		ShowsPage showsPage= new ShowsPage(driver);
		showsPage.closePrompt();
		showsPage.getPopularShows().get(1).click();
		LoggerUtility.info("Navigated to Show deatail page");

		wLib.executeJavaScript(driver, "window.scrollTo(0,500);");
		ShowsDetailsPage showsDetailsPage= new ShowsDetailsPage(driver);
		showsDetailsPage.getLockedEpisodes().get(1).click();

		boolean flag=showsDetailsPage.getMsgOnLockedEpisodes().isDisplayed();
		Assert.assertTrue(flag);
		LoggerUtility.info("\"Sign up for Paramount+ to stream this video\" is displayed on the locked episodes. Passed.");
	}
}
