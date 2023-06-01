package userProfile;

import java.io.IOException;

import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.DeleteConfirmPage;
import com.paramountplus.objectRepository.EditProfilePage;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.ManageProfilePage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyDeleteNewProfile extends BaseClass {

	@Test(groups = {"Smoke"})
	public void deleteNewProfile() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithBundle();

		WhosWatchingPage whoIsWatching = new WhosWatchingPage(driver);
		whoIsWatching.selectMainProfile();

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
