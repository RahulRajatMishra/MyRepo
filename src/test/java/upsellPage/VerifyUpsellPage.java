package upsellPage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.PickPlanPage;
import com.paramountplus.objectRepository.UpsellPage;

public class VerifyUpsellPage extends BaseClass {
	@Test(dataProvider="getUserData", description = "C1533064_Navigate_to_the_Upsell_Page_&_C1533072_Scroll_up_and_down")
	public void verifyUpsellPage(String userName, String pwd) throws Exception
	{
		LoginPage loginPage= new LoginPage(driver);
		loginPage.login(userName, pwd);
		wLib.waitTillcurrectURLContains(driver, "pickplan");
		PickPlanPage pickPlanPage= new PickPlanPage(driver);
		pickPlanPage.getParamountLogo().click();

		UpsellPage upsellPage= new UpsellPage(driver);
		boolean flag1=upsellPage.getTryItFreeCTA().isDisplayed();
		Assert.assertTrue(flag1);

		boolean flag2=upsellPage.getUpsellText().isDisplayed();
		Assert.assertTrue(flag2);

		boolean flag3= upsellPage.getShowtimeBundleLogo().isDisplayed();
		Assert.assertTrue(flag3);
		LoggerUtility.info("Upsell page displayed for "+userName+" -Test Passed");

		//		C1533072-Scroll up and down
		wLib.scrollToBottom(driver);
		boolean flag4=upsellPage.footerSiteLogo.isDisplayed();
		Assert.assertTrue(flag4);
		wLib.scrollToTop(driver);
		loginPage.logout();
	}

	@DataProvider
	public Object[][] getUserData()
	{
		Object[][] objArr= new Object[2][2];
		objArr[0][0]= "exsub@stage5.com";
		objArr[0][1]="aaaaaa";
		objArr[1][0]="rahulrajat.mishra+1@paramount.com";
		objArr[1][1]="123456";
		return objArr;	
	}
}
