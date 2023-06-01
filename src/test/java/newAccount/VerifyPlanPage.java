package newAccount;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.LoginUtility;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.PlanPage;

public class VerifyPlanPage extends BaseClass {

	@Test(groups = {"Smoke"},description="PlanPage")
	public void planPage() throws IOException
	{
		LoginPage login= new LoginPage(driver);
		login.loginExSubscriber();

		PlanPage planPage= new PlanPage(driver);
		boolean flag= planPage.getPickYourPlanText().isDisplayed();
		Assert.assertTrue(flag);
		LoggerUtility.info("<---Plan page displayed--->");
		planPage.logout();
	}

}
