package homePage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.genericUtility.RetryAnalyzer;
import com.paramountplus.genericUtility.WebDriverUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyFooterParamountLogo extends BaseClass{

	@Test(groups= {"Smoke", "Regression"}, description="C1693084-Header_disappears_and_P+_logo_appears_on_the_navigation_bar")
	public void verifyFooterLogo() throws IOException, InterruptedException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.scrollToBottom(driver);
		wLib.waitForElementToBeVisible(driver, homePage.getFooterParamountPluslogo());
		boolean flag=homePage.getFooterParamountPluslogo().isDisplayed();
		Assert.assertTrue(flag);
		LoggerUtility.info("Footer ParamountPlus logo is displayed");
	}
}
