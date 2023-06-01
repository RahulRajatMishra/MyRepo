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

	@Test(groups = {"Smoke"}, description = "C2197010 & C2197009- User_can_edit_content_tile_on_My_list_by_selecting_edit_option & Empty_My_list_Page_has_no_content_tile_selected")
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
		wLib.waitForElementToBeSelectable(driver, item);
		item.click();
		wLib.waitForElementToBeClickable(driver, myList.getRemovebtn());
		myList.getRemovebtn().click();
		wLib.pageRefreshAndWaitForElementVisibilty(driver, myList.getEmptyListText());
		LoggerUtility.info("Item removed ");

		boolean flag= myList.getEmptyListText().isDisplayed();
		Assert.assertTrue(flag);
		LoggerUtility.info("My list is empty-TEST PASSED");
	}

}
