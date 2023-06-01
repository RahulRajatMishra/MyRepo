package userProfile;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.genericUtility.WebDriverUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyAdultUserProfile extends BaseClass {

	@Test(groups={"Smoke"}, description="C2402830- Verify_adult_user_profile_is_selected")
	public void verifyAdultUserProfilePicker() throws IOException, InterruptedException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithoutBundle();


		WhosWatchingPage whoIsWatching= new WhosWatchingPage(driver);
		whoIsWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getAvatarImage());
		wLib.mouseHoverAndClick(driver, homePage.getAvatarImage(), homePage.getAdultUser());
		String profileName= homePage.checkCurrentProfileContains("adult");
//		Assertion
		Assert.assertEquals(profileName, "adultuser");
		LoggerUtility.info("AdultUser profile is selected, PASSED");
	}
}
