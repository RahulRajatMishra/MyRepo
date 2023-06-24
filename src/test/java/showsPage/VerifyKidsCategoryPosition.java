package showsPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.ShowsPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyKidsCategoryPosition extends BaseClass {

	@Test(groups= {"Smoke","Regression"},description = "C2251311- Verify_that_the_kids_section_is_8th_on_the_Nav_bar_of_show_browse_page")
	public void verifyKidsCategoryPosition() throws IOException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();
		
		HomePage homePage= new HomePage(driver);
		homePage.getShowsTab().click();
		boolean flag = wLib.waitTillcurrectURLContains(driver, "browse");
		Assert.assertTrue(flag);
		LoggerUtility.info("Shows page displayed");

		ShowsPage showsPage= new ShowsPage(driver);
		wLib.waitForElementToBeVisible(driver, showsPage.getKidsSubnav());
		showsPage.getKidsSubnav().isDisplayed();
		LoggerUtility.info("Kids subnav is displayed at 8th position");
	}
}
