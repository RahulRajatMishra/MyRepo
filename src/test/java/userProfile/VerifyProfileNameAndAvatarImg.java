package userProfile;

import java.util.List;

import org.openqa.selenium.WebElement;
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
import com.paramountplus.objectRepository.SelectAvatarPage;
import com.paramountplus.objectRepository.ShowsPickerPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyProfileNameAndAvatarImg extends BaseClass{

	@Test(priority = 1, groups = "Smoke", description = "C1693082-Name_and_selected_icon_on_show_picker-New_profile")
	public void verifyNameAndSelectedIconOnShowPicker() throws Exception
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getAvatarImage());
		wLib.mouseHoverAndClick(driver, homePage.getAvatarImage(), homePage.getAddProfileLink());

		LoggerUtility.info("Add profile page is displayed");
		CreateProfilePage createProfilePage= new CreateProfilePage(driver);
		createProfilePage.getProfileNametxtField().sendKeys("NewProfile");
		createProfilePage.getChooseAvatar().click();

		SelectAvatarPage selectAvatarPage= new SelectAvatarPage(driver);
		wLib.scrollTillElementIsDisplayed(driver, selectAvatarPage.getEmotionAvatar());
		List<WebElement> allAvatars= selectAvatarPage.getAllAvatars();
		WebElement av= allAvatars.get(1);
//		wLib.waitForElementToBeVisible(driver, av);
		String srcImg1= av.getAttribute("src");
		String[] str1= srcImg1.split("_");
		String imageSelected= str1[3];
		LoggerUtility.info(imageSelected);
		allAvatars.get(1).click();
		createProfilePage.getSaveProfileButton().click();
		//Navigated to show picker

		ShowsPickerPage showPickerPage= new ShowsPickerPage(driver);
		wLib.waitForElementToBeVisible(driver, showPickerPage.getAvImgShowPicker());
		String srcImg2= showPickerPage.getAvImgShowPicker().getAttribute("src");
		String[] str2= srcImg2.split("_");
		String imageDisplayed=str2[3];
		LoggerUtility.info(imageDisplayed);
		Assert.assertEquals(imageSelected, imageDisplayed);

		String showPickerTitle=	showPickerPage.getShowPickerTitle().getText();
		String[] str= showPickerTitle.split(",");
		String profileName= str[0];
		LoggerUtility.info(profileName);
		Assert.assertEquals(profileName, "NewProfile");
		LoggerUtility.info("C1693082-Name and selected icon on show picker-New profile-TEST PASSED");
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
