package homePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.SwitchPlanPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyGoAddFreeCTA extends BaseClass {

	@Test(groups = {"Smoke"}, description = "C1543391-Click_the_Go_Commercial_Free_button_&_Verify_Switch_Plan_Page")
	public void verifyGoCommercialFreeCTA() throws Exception
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		homePage.getGoAddFreeCTA().click();

		SwitchPlanPage switchPlanPage= new SwitchPlanPage(driver);
		boolean flag1= switchPlanPage.getSwitchYourPlantxt().isDisplayed();
		Assert.assertTrue(flag1);
		LoggerUtility.info("Switch your plan page is displayed");

		boolean flag2= switchPlanPage.getEssentialPlantxt().isDisplayed();
		Assert.assertTrue(flag2);

		boolean flag3= switchPlanPage.getPremiumPlantxt().isDisplayed();
		Assert.assertTrue(flag3);

		boolean flag4= switchPlanPage.getEssentialWithShowtimetxt().isDisplayed();
		Assert.assertTrue(flag4);

		boolean flag5= switchPlanPage.getPremiumWithShowtimetxt().isDisplayed();
		Assert.assertTrue(flag5);
		LoggerUtility.info("\"Essential\", \"Premium\", \"Essential with Showtime\" and \"Premium with Showtime\" plans are displayed");

		String essentialPrice=switchPlanPage.getEssentialPlanPrice().getText();
		String premiunPrice= switchPlanPage.getPremiumPlanPrice().getText();
		Assert.assertNotSame(essentialPrice, premiunPrice);
		LoggerUtility.info("Essential and Premium plan have different price");

	}
}
