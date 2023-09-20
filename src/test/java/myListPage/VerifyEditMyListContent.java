package myListPage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.genericUtility.RetryAnalyzer;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.MyListPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyEditMyListContent extends BaseClass {

	@Test(priority = 1, groups = {"Smoke"}, description = "C2197010- User_can_edit_content_tile_on_My_list_by_selecting_edit_option")
	public void editMyList() throws IOException, InterruptedException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		homePage.getMyListTab().click();
		wLib.waitTillcurrectURLContains(driver, "my-list");
		LoggerUtility.info("My List page is displayed");

		MyListPage myList= new MyListPage(driver);
		myList.clickOnEditButton();
		WebElement item= myList.getAllMyListItems().get(0);
		wLib.waitForElementToBeClickable(driver, item);
		item.click();
		wLib.waitForElementToBeClickable(driver, myList.getRemovebtn());
		myList.getRemovebtn().click();
		wLib.pageRefreshAndWaitForElementVisibilty(driver, myList.getEmptyListText());
		LoggerUtility.info("Item removed ");
	}
	@Test(priority = 2, description = "C2197009- Empty_My_list_Page_has_no_content_tile_selected")
	public void verifyEmptyMyList()
	{
		MyListPage myList= new MyListPage(driver);
		boolean flag= myList.getEmptyListText().isDisplayed();
		Assert.assertTrue(flag);
		LoggerUtility.info("My list is empty-TEST PASSED");
	}

}
