package showsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.ShowsDetailsPage;
import com.paramountplus.objectRepository.ShowsPage;
import com.paramountplus.objectRepository.UpsellPage;

public class VerifyRegisteredUserSeeRainmaker extends BaseClass{

	@Test(priority = 1, groups = {"Smoke"}, description = "C1503125_Navigate_to_Shows_page")
	public void navigateToShowsPage() throws Exception
	{
		LoginPage loginPage= new LoginPage(driver);
		loginPage.loginWithRegisteredUser();
		driver.get("https://stage.paramountplus.com/shows/");
		LoggerUtility.info("Navigated to shows page");
		ShowsPage showsPage= new ShowsPage(driver);
		showsPage.getPopularShows().get(1).click();
		wLib.waitTillcurrectURLContains(driver, "shows");
		LoggerUtility.info("Navigated to Show deatail page");
	}
	@Test(priority = 2, groups = {"Smoke"}, description = "C1503129_Show_page_Registered_user_See_Rainmaker")
	public void verifyRainmaker()
	{
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
	}
	@Test(priority = 3, groups = {"Smoke"}, description = "C1503139_Show_page_Registered_user_'X'_to_dismiss")
	public void clickOnDismissButton()
	{
		ShowsDetailsPage showsDetailsPage= new ShowsDetailsPage(driver);
		showsDetailsPage.getCloseRainmakerbtn().click();
		wLib.waitForElementToBeInvisible(driver, showsDetailsPage.getRainmakerLogo());
		boolean flag= showsDetailsPage.getRainmakerLogo().isDisplayed();
		Assert.assertFalse(flag);
		LoggerUtility.info("Rainmaker is closed");
	}
	@Test(priority = 4, groups = {"Smoke"}, description = "C1503140_Show_page_Registered_user_Try_it_Free CTA")
	public void verifyTryItFreeCTA()
	{
		ShowsDetailsPage showsDetailsPage= new ShowsDetailsPage(driver);
		driver.navigate().refresh();
		wLib.scrollToBottom(driver);
		wLib.waitForElementToBeVisible(driver, showsDetailsPage.getRainmakerLogo());
		showsDetailsPage.getTryItFreeCTA().click();

		UpsellPage upsellPage= new UpsellPage(driver);
		boolean flag=  upsellPage.getSignInButton().isDisplayed();
		Assert.assertTrue(flag);
		LoggerUtility.info("User is taken to the upsell page");
	}
}
