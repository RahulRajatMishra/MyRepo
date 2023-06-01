package userProfile;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.genericUtility.WebDriverUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyKidsUserProfile extends BaseClass {

	@Test(groups = {"Smoke"}, description="C2402831- Verify_kids_user_profile_is_selected")
	public void verifyKidsUserProfilePicker() throws IOException, InterruptedException
	{		

		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whoIsWatching= new WhosWatchingPage(driver);
		whoIsWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getAvatarImage());
		wLib.mouseHoverAndClick(driver, homePage.getAvatarImage(), homePage.getKidsUser());
		String profileName= homePage.checkCurrentProfileContains("kids");
		System.out.println(profileName);
//		Assertion
		Assert.assertEquals(profileName, "kidsuser");
		LoggerUtility.info("KidsUser profile is selected, TEST PASSED");
	}
}
