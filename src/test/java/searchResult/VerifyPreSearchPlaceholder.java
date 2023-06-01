package searchResult;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.SearchPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyPreSearchPlaceholder extends BaseClass
{

	@Test(groups = {"Regression"}, description = "C2402834 - Verify_Search_bar_pre-search_placeholder")
	public void preSearchPlaceholder() throws IOException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		homePage.getSearchLink().click();
		
		SearchPage searchPage= new SearchPage(driver);
		boolean flag= searchPage.getSearchInputField().isDisplayed();
		assertTrue(flag);
		LoggerUtility.info("Search page is displayed");
		String placeholderText=	searchPage.getSearchInputField().getAttribute("placeholder");
		assertEquals("Search", placeholderText);
		LoggerUtility.info("Placeholder value is verified- Test passed");
	}
}
