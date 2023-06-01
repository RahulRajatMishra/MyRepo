package homePage;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

public class VerifyJustAddedBadge extends BaseClass{
	WebElement justAdded;
	@Test(groups= {"Smoke","Regression"}, description = "C2402828- Verify_that_New_Movie_and_New_Series_has_updated_ \"Just Added\" _text_to_it")
	public void verifyJustAddedBadge() throws IOException, InterruptedException
	{
		LoginPage login= new LoginPage(driver);
		login.loginWithBundle();

		WhosWatchingPage whosWatching= new WhosWatchingPage(driver);
		whosWatching.selectMainProfile();
		
		HomePage homePage= new HomePage(driver);
		wLib.scrollTillAllElementsLoaded(driver);
		List<WebElement> list= homePage.getJustAdded();
		System.out.println(list.size());
		assertNotNull(list);
		LoggerUtility.info(" *Just Added* badge displayed");

		String text=null;
		for(int i=0; i<list.size();)
		{
			justAdded= list.get(i);
			text=justAdded.getAttribute("data-impression");
			break;
		}
		wLib.scrollIntoView(driver, justAdded);
		LoggerUtility.info("Just Added badge is displayed on / "+text+" /");
	}

}
