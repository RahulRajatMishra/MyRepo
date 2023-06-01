package homePage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyNewBadge extends BaseClass{
	WebElement newbadge;
	@Test(groups= {"Smoke","Regression"},description = "C2402827- Verify_that_the_new_content_has_content_badges_with_ \"new\" _text_on_it")
	public void verifyNewBadge() throws IOException, InterruptedException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();

		HomePage homePage= new HomePage(driver);
		wLib.scrollTillAllElementsLoaded(driver);;
		List<WebElement> list= homePage.getNewContents();
		Assert.assertFalse(list.isEmpty());
		LoggerUtility.info(" *New* badge displayed");

		newbadge= list.get(0);
		String text=newbadge.getAttribute("data-impression");
		Assert.assertTrue(text.contains("NEW"));
		wLib.scrollIntoView(driver, newbadge);
		LoggerUtility.info("New badge is displayed on / "+text+" /");
	}
}

