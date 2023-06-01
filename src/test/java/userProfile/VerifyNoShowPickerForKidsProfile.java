package userProfile;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.objectRepository.CreateProfilePage;
import com.paramountplus.objectRepository.DeleteConfirmPage;
import com.paramountplus.objectRepository.EditProfilePage;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.ManageProfilePage;
import com.paramountplus.objectRepository.UserProfileEnterPinPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyNoShowPickerForKidsProfile extends BaseClass {
	//	HomePage homePage= new HomePage(driver);

	@Test(groups={"Smoke"}, description = "C1693080 - Kids profile Should not see the show picker")
	public void noShowPickerForKidsProfile() throws IOException, InterruptedException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whoIsWatching= new WhosWatchingPage(driver);
		whoIsWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getAvatarImage());
		wLib.mouseHoverAndClick(driver, homePage.getAvatarImage(), homePage.getAddProfileLink());

		CreateProfilePage createProfile= new CreateProfilePage(driver);
		String profileName= createProfile.createOlderKidsProfile();
		wLib.waitForElementToBeVisible(driver, whoIsWatching.getWhosWatchingHeader());
		boolean flag= whoIsWatching.getWhosWatchingHeader().isDisplayed();
		Assert.assertTrue(flag);
		whoIsWatching.selectOlderKidsTestProfile();
		wLib.waitTillcurrectURLContains(driver, "home");
		String currentProfile= homePage.checkCurrentProfileContains(profileName);
		Assert.assertEquals(profileName, currentProfile);
		LoggerUtility.info(profileName+" Profile created- No show picker page shown- TEST PASSED");
	}
}
