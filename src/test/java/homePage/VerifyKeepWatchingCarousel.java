package homePage;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.genericUtility.WebDriverUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyKeepWatchingCarousel extends BaseClass{
	@Test(groups= {"Smoke","Regression"}, description = "C1860892-User_Navigates_to_Show_Detail_Page")
	public void keepWatchingCarouserl() throws IOException, InterruptedException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.scrollTillElementIsDisplayed(driver, homePage.getKeepWatchingCarousel());

		boolean flag= homePage.getKeepWatchingCarousel().isDisplayed();
		assertTrue(flag);
		LoggerUtility.info("Keep watching carousel displayed on homepage- TEST PASSED");
	}
}
