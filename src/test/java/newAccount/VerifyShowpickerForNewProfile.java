package newAccount;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

public class VerifyShowpickerForNewProfile extends BaseClass{

	@Test(dataProvider="getUser")
	public void verifyShowpickerForNewProfile(String userName, String pwd) throws Exception
	{
		LoginPage loginPage= new LoginPage(driver);
		loginPage.login(userName, pwd);
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
		System.out.println("Created profile selected");
		wLib.waitTillcurrectURLContains(driver, "home");

		String currentProfile= homePage.checkCurrentProfileContains(profileName);
		Assert.assertEquals(profileName, currentProfile);
		LoggerUtility.info(profileName+" profile added successfully, TEST PASSED");
		// Delete profile
		driver.navigate().refresh();
		wLib.mouseHoverAndClick(driver, homePage.getAvatarImage(), homePage.getManagePrifile());
		//wLib.mouseHoverAndClick(driver, homePage.getAvatarImage(), homePage.getManagePrifile());
		System.out.println("Navigated to manage profile");
		wLib.waitTillcurrectURLContains(driver, "/user-profile/manage");
		ManageProfilePage manageProfile= new ManageProfilePage(driver); 
		wLib.waitForElementToBeVisible(driver, manageProfile.getNewTestProfile());
		profileName= manageProfile.getNewTestProfile().getText();
		manageProfile.getNewTestProfile().click();

		EditProfilePage editProfile= new EditProfilePage(driver);
		wLib.waitForElementToBeClickable(driver, editProfile.getDeleteProfilebtn());
		editProfile.getDeleteProfilebtn().click();

		DeleteConfirmPage confirmDelete= new DeleteConfirmPage(driver);
		wLib.waitForElementToBeClickable(driver, confirmDelete.getYesDeleteProfilebtn());
		confirmDelete.getYesDeleteProfilebtn().click();
		LoggerUtility.info(profileName+" Profile is Deleted, TEST PASSED");
		wLib.waitTillcurrectURLContains(driver, "whos-watching");
		whosWatching.selectMainProfile();
		homePage.logout();	
	}
	@DataProvider
	public Object[][] getUser()
	{
		Object[][] objArr= new Object[2][2];
		objArr[0][0]= "Essential@auto5779.com";
		objArr[0][1]="123456";
		objArr[1][0]="Premium@auto9249.com";
		objArr[1][1]="123456";
		return objArr;	
	}
}
