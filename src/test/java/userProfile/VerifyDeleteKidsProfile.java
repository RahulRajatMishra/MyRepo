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

public class VerifyDeleteKidsProfile extends BaseClass {

	@Test(groups = {"Smoke"})
	public void deleteKidsUserProfile() throws IOException, InterruptedException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithBundle();
        
		WhosWatchingPage whoIsWatching = new WhosWatchingPage(driver);
		whoIsWatching.selectMainProfile();
        
		HomePage homePage = new HomePage(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getAvatarImage());
		wLib.mouseHoverAndClick(driver, homePage.getAvatarImage(), homePage.getManagePrifile());
        
		ManageProfilePage manageProfile= new ManageProfilePage(driver);
		wLib.waitForElementToBeClickable(driver, manageProfile.getTestProfile());
		String profileName= manageProfile.getTestProfile().getText();
		manageProfile.getTestProfile().click(); 
        
		EditProfilePage editProfile= new EditProfilePage(driver);
		wLib.waitForElementToBeClickable(driver, editProfile.getDeleteProfilebtn());
		editProfile.getDeleteProfilebtn().click();
        
		DeleteConfirmPage deleteConfirm= new DeleteConfirmPage(driver);
		wLib.waitForElementToBeClickable(driver, deleteConfirm.getYesDeleteProfilebtn());
		deleteConfirm.getYesDeleteProfilebtn().click();
		LoggerUtility.info(profileName+" profile is deleted, TEST PASSED");
	}
}
