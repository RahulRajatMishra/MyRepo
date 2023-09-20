package searchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.SearchPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifySearchResult extends BaseClass {

	@Test(groups= {"Smoke", "Regression"}, description = "C2277658 & C2277660- Navigate_to_the_Search_Page_and_Enter_Search")
	public void performSearchAndVerifyResult() throws IOException, InterruptedException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		homePage.getSearchLink().click();

		SearchPage searchPage= new SearchPage(driver);
		wLib.waitForElementToBeClickable(driver, searchPage.getSearchInputField());
		/*
		 * searchPage.getSearchInputField().sendKeys("Star Trek");
		 * searchPage.getSearchInputField().sendKeys(Keys.ENTER);
		 */
//		new Actions(driver).sendKeys(searchPage.getSearchInputField(),"Star Trek").perform();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='Star Trek';", searchPage.getSearchInputField());
		wLib.pressEnterAndWaitForElement(driver, searchPage.getSearchResults());
//		wLib.pressEnterKey(driver);
		wLib.waitForElementToBeVisible(driver, searchPage.getSearchResults());
		boolean flag= searchPage.getSearchResults().isDisplayed();
		Assert.assertTrue(flag); //as the search result text is hidden- Updated on 19 Sep - Search result is shown
		wLib.scrollToBottom(driver);
		List<WebElement> list = searchPage.getAllStarTrekShows();
		System.out.println(list.size());
		Assert.assertFalse(list.isEmpty());
		LoggerUtility.info("Search page populate with the result- Test passed");
	}
}
