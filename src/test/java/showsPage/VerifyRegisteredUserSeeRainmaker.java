package showsPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.ShowsDetailsPage;
import com.paramountplus.objectRepository.ShowsPage;
import com.paramountplus.objectRepository.UpsellPage;

public class VerifyRegisteredUserSeeRainmaker extends BaseClass{

	@Test(groups = {"Smoke"}, description = "C1503125_Navigate_to_Shows_page_&_C1503129_Show_page_Registered_user_See_Rainmaker_&_C1503139_'X'_to_dismiss_&_C1503140_Try_it_Free CTA")
	public void verifyRegisteredUserSeeRainmaker() throws Exception
	{
		LoginPage loginPage= new LoginPage(driver);
		loginPage.loginWithRegisteredUser();
		//C1503125- Navigate to Shows page
		driver.get("https://stage.paramountplus.com/shows/");
		LoggerUtility.info("Navigated to shows page");


		ShowsPage showsPage= new ShowsPage(driver);
		showsPage.getPopularShows().get(0).click();
		LoggerUtility.info("Navigated to Show deatail page");

		//C1503129- Show page - Registered user - See Rainmaker
		ShowsDetailsPage showsDetailsPage= new ShowsDetailsPage(driver);
		wLib.waitForElementToBeVisible(driver, showsDetailsPage.getWatchNowCTA());
		wLib.scrollToBottom(driver);
		wLib.waitForPageToLoadForJSElement(driver);
		wLib.waitForElementToBeVisible(driver, showsDetailsPage.getRainmakerLogo());
		boolean flag1= showsDetailsPage.getRainmakerLogo().isDisplayed();
		Assert.assertTrue(flag1);
		LoggerUtility.info("The Rainmaker is displayed");

		boolean flag2= showsDetailsPage.getCloseRainmakerbtn().isDisplayed();
		Assert.assertTrue(flag2);
		LoggerUtility.info("\"X\" is displayed on the left side");

		boolean flag3= showsDetailsPage.getTryItFreeCTA().isDisplayed();
		Assert.assertTrue(flag3);
		LoggerUtility.info("Try It Free CTA is displayed on the right- TEST PASSED");

		//C1503139-Show page - Registered user - 'X' to dismiss
		showsDetailsPage.getCloseRainmakerbtn().click();
		wLib.waitForElementToBeInvisible(driver, showsDetailsPage.getRainmakerLogo());
		boolean flag4= showsDetailsPage.getRainmakerLogo().isDisplayed();
		Assert.assertFalse(flag4);
		LoggerUtility.info("Rainmaker is closed");

		//C1503140- Show page - Registered user - "Try it Free" CTA
		driver.navigate().refresh();
		wLib.scrollToBottom(driver);
		wLib.waitForElementToBeVisible(driver, showsDetailsPage.getRainmakerLogo());
		showsDetailsPage.getTryItFreeCTA().click();

		UpsellPage upsellPage= new UpsellPage(driver);
		boolean flag5=  upsellPage.getSignInButton().isDisplayed();
		Assert.assertTrue(flag5);
		LoggerUtility.info("User is taken to the upsell page");
	}
}
