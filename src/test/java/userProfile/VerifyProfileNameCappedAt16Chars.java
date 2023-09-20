package userProfile;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.CreateProfilePage;
import com.paramountplus.objectRepository.DeleteConfirmPage;
import com.paramountplus.objectRepository.EditProfilePage;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.ManageProfilePage;
import com.paramountplus.objectRepository.ShowsPickerPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyProfileNameCappedAt16Chars extends BaseClass {

	@Test(priority = 1, groups = {"Smoke, Regression"}, description = "C1556656_User's_profile_name_is_capped_at_16th_character")
	public void VerifyProfileLengthOnShowPicker() throws Exception
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getAvatarImage());
		wLib.mouseHoverAndClick(driver, homePage.getAvatarImage(), homePage.getAddProfileLink());

		LoggerUtility.info("Add profile page is displayed");
		CreateProfilePage createProfile= new CreateProfilePage(driver);
		String profileName=createProfile.createProfileWith18Chars();
		System.out.println(profileName);
		boolean flag=wLib.waitTillcurrectURLContains(driver, "showspicker");
		Assert.assertTrue(flag);
		LoggerUtility.info("User is taken to the New Account Show Picker page- C2355860-Test passed");

		ShowsPickerPage showsPicker= new ShowsPickerPage(driver);
		String showPickerTitle=	showsPicker.getShowPickerTitle().getText();
		System.out.println(showPickerTitle);
		String[] str=showPickerTitle.split(",");
		String profile= str[0];
		System.out.println(profile);
		int profileLength=profile.length();
		Assert.assertEquals(profileLength, 16);
		LoggerUtility.info("User's profile name is capped at 16th character-C1556656-PASSED");
	}

	@Test(priority = 2, groups = {"Smoke"}, description = "Delete created user profile")
	public void deleteProfile() throws Exception
	{
		driver.navigate().back();
		HomePage homePage = new HomePage(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getAvatarImage());
		wLib.mouseHoverAndClick(driver, homePage.getAvatarImage(), homePage.getManagePrifile());

		ManageProfilePage manageProfile= new ManageProfilePage(driver); 
		wLib.waitForElementToBeVisible(driver, manageProfile.getTestProfile());
		String profileName= manageProfile.getTestProfile().getText();
		manageProfile.getTestProfile().click();

		EditProfilePage editProfile= new EditProfilePage(driver);
		wLib.waitForElementToBeClickable(driver, editProfile.getDeleteProfilebtn());
		editProfile.getDeleteProfilebtn().click();

		DeleteConfirmPage confirmDelete= new DeleteConfirmPage(driver);
		wLib.waitForElementToBeClickable(driver, confirmDelete.getYesDeleteProfilebtn());
		confirmDelete.getYesDeleteProfilebtn().click();
		LoggerUtility.info(profileName+" Profile is Deleted, TEST PASSED");
	}

}
