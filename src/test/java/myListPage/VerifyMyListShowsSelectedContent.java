package myListPage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.MyListPage;
import com.paramountplus.objectRepository.ShowsDetailsPage;
import com.paramountplus.objectRepository.ShowsPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyMyListShowsSelectedContent extends BaseClass {

	@Test(groups = {"Smoke"}, description="C2197007-Verify_that_user_My_list_page_has_selected_content_tile")
	public void VerifySelectedContentOnMyList() throws IOException, InterruptedException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		homePage.getMyListTab().click();
		LoggerUtility.info("My list page is displayed");

		MyListPage myList= new MyListPage(driver);
		myList.getFindShowsLink().click();

		ShowsPage showsPage= new ShowsPage(driver);
		List<WebElement> popularShows= showsPage.getPopularShows();
		String name1= popularShows.get(1).getAttribute("alt");
		popularShows.get(1).click();

		ShowsDetailsPage showsDetailsPage= new ShowsDetailsPage(driver);
//		wLib.scrollTillElementIsDisplayed(driver, showsDetailsPage.getWatchlistCTA());
		wLib.mouseHoverOnElement(driver, showsDetailsPage.getWatchlistCTA());
		wLib.waitForElementToBeClickable(driver, showsDetailsPage.getAddToWatchlistbtn());
		showsDetailsPage.getAddToWatchlistbtn().click();
		wLib.scrollToTop(driver);
		homePage.getMyListTab().click();
		String name2= myList.getAllMyListItems().get(0).getAttribute("alt");
		Assert.assertEquals(name1, name2);
		LoggerUtility.info("Added item displays on my list- TEST PASSED");
	}
}
