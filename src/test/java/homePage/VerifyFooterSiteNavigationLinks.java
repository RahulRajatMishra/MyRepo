package homePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyFooterSiteNavigationLinks extends BaseClass {

	@Test(groups="Smoke")
	public void verifyHomeLink() throws IOException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.scrollToBottom(driver);
		wLib.waitForElementToBeClickable(driver, homePage.getFooterHomeLink());

		homePage.getFooterHomeLink().click();
		wLib.waitForElementToBeVisible(driver, homePage.getParamountPlusHomeLogo());

		boolean flag= homePage.getParamountPlusHomeLogo().isDisplayed();
		Assert.assertTrue(flag);
		LoggerUtility.info("Footer Home link is working- Passed");
	}
	@Test(groups="Smoke")
	public void verifyShowsLink()
	{
		HomePage homePage= new HomePage(driver);
		wLib.scrollToBottom(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getFooterShowsLink());
		homePage.getFooterShowsLink().click();
		boolean flag=wLib.waitTillcurrectURLContains(driver, "browse");
		Assert.assertTrue(flag);
		LoggerUtility.info("Footer Shows link is working- Passed");
	}
}
