package upsellPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.UpsellPage;

public class VerifySignInCTA extends BaseClass{

	@Test(groups={"Smoke","Regression"}, description="Navigate_to_upsell_page_and_verify_Sign_in_CTA - C2355862 & C2355863")
	public void signInCTA()
	{
		UpsellPage upsellPage= new UpsellPage(driver);
		boolean flag1= upsellPage.getShowtimeBundleLogo().isDisplayed();
		Assert.assertTrue(flag1);
		LoggerUtility.info("Upsell page displayed");
		
//		Verify the sign in button in the top right corner
		boolean flag2= upsellPage.getSignInButton().isDisplayed();
		Assert.assertTrue(flag2);
		LoggerUtility.info("Sign in CTA is displayed in the top right hand corner- TEST PASSED");
		
	}
}
