package newAccount;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.AccountPage;
import com.paramountplus.objectRepository.CreateAccountPage;
import com.paramountplus.objectRepository.PickPlanPage;
import com.paramountplus.objectRepository.PlanPage;
import com.paramountplus.objectRepository.SubmitPaymentPage;
import com.paramountplus.objectRepository.UpsellPage;

public class VerifyMonthlyPremiumUserCreation extends BaseClass {

	@Test(priority = 1, groups= {"Smoke"}, description = "Monthly_Plan_Premium_User_Account_Creation")
	public void verifyMonthlyPremiumUserCreation() throws Exception
	{
		UpsellPage upsellPage= new UpsellPage(driver);
		upsellPage.getTryItFreeCTA().click();

//		boolean flag1= wLib.waitTillcurrectURLContains(driver, "plan");
//		Assert.assertTrue(flag1);
//		PlanPage planPage= new PlanPage(driver);
//		planPage.getContinuebtn().click();

		boolean flag2= wLib.waitTillcurrectURLContains(driver, "pickplan");
		Assert.assertTrue(flag2);
		PickPlanPage pickPlanPage= new PickPlanPage(driver);
		pickPlanPage.getSelectPremiumPlan().click();

		//		boolean flag3= wLib.waitTillcurrectURLContains(driver, "bundle");
		//		Assert.assertTrue(flag3);
		//		BundleSelectionPage bundleSelectionPage= new BundleSelectionPage(driver);
		//		bundleSelectionPage.getMayBeLaterbtn().click();

//		boolean flag4= wLib.waitTillcurrectURLContains(driver, "account");
//		Assert.assertTrue(flag4);
//		AccountPage accountPage= new AccountPage(driver);
//		accountPage.getContinuebtn().click();

		boolean flag5= wLib.waitTillcurrectURLContains(driver, "createaccount");
		Assert.assertTrue(flag5);
		CreateAccountPage createAccountPage= new CreateAccountPage(driver);
		createAccountPage.createPremiumAccount();
		LoggerUtility.info("New Monthly Premium account is created");
	}
	@Test(priority = 2, groups= {"Smoke"}, description = "Monthly_Plan_Premium_User_Make_Payment")
	public void makePayment()
	{
		boolean flag6= wLib.waitTillcurrectURLContains(driver, "submitpayment");
		Assert.assertTrue(flag6);
		SubmitPaymentPage submitPaymentPage= new SubmitPaymentPage(driver);
		submitPaymentPage.makePayment();

		wLib.waitTillcurrectURLContains(driver, "shows/picker");
		LoggerUtility.info("Monthly Premium Account- Payment Done");

	}
}
