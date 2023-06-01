package userProfile;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.genericUtility.WebDriverUtility;
import com.paramountplus.objectRepository.CreateProfilePage;
import com.paramountplus.objectRepository.DeleteConfirmPage;
import com.paramountplus.objectRepository.EditProfilePage;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.ManageProfilePage;
import com.paramountplus.objectRepository.ShowsPickerPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyNewProfileShowPicker extends BaseClass{

	@Test(groups= {"Smoke"}, description="C2355860-&-C1543386-&-C1543387-&-C1556664= Navigate_to_New_Profile_Show_Picker_&_Select_multiple_shows_&_Click_the_Next_button_&_User_is_landed_on_who's_watching_page_after_the_show_picker-New_Profile" )
	public void newProfileShowPicker() throws IOException, InterruptedException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getAvatarImage());
		wLib.mouseHoverAndClick(driver, homePage.getAvatarImage(), homePage.getAddProfileLink());

		//C2355860 - Navigate to New Profile Show Picker
		LoggerUtility.info("Add profile page is displayed");
		CreateProfilePage createProfile= new CreateProfilePage(driver);
		String profileName=createProfile.createTestProfile();
		boolean flag=wLib.waitTillcurrectURLContains(driver, "showspicker");
		Assert.assertTrue(flag);
		LoggerUtility.info("User is taken to the New Account Show Picker page- C2355860-Test passed");

		//C1543386 - Select multiple shows
		ShowsPickerPage showsPicker= new ShowsPickerPage(driver);
		showsPicker.selectThreeShows();
		LoggerUtility.info("Three shows selected- C1543386-Test passed");

		//C1543387- Click the Next button
		showsPicker.getNextbtn().click();
		boolean flag1= wLib.waitTillcurrectURLContains(driver, "compiling");
		assertTrue(flag1);
		LoggerUtility.info("Clicked on next CTA- C1543387 - Test Passed");

		//C1556664- User is landed on who's watching page after the show picker-New Profile
		boolean flag2= wLib.waitTillcurrectURLContains(driver, "whos-watching");
		Assert.assertTrue(flag2);
		whosWatching.selectTestProfile();
		wLib.waitTillcurrectURLContains(driver, "home");
		String currentProfile= homePage.checkCurrentProfileContains(profileName);
		Assert.assertEquals(profileName, currentProfile);
		LoggerUtility.info(profileName+" profile added successfully, TEST PASSED");
	}
}
