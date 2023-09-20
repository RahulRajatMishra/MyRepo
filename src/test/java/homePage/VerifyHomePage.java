package homePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.WhosWatchingPage;
public class VerifyHomePage extends BaseClass{

	@Test(groups = {"Smoke"}, description ="C1595116-Navigate_to_Homepage")

	public void homePage() throws IOException
	{
//		System.setProperty (" webdriver.http.factory "," jdk-http-client ");
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.waitAndVerifyPageTitle(driver, "Paramount Plus - Stream Live");
		boolean flag= homePage.getParamountPlusHomeLogo().isDisplayed();
		Assert.assertTrue(flag);
		LoggerUtility.info("Home page displayed");
		homePage.logout();
	}
}
