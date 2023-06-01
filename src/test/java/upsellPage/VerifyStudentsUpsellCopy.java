package upsellPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.objectRepository.Edu_OfferPage;

public class VerifyStudentsUpsellCopy extends BaseClass{

	@Test(groups = {"Smoke","Regression"}, description = "C2112629-Upsell_copy_ header_Students_get_25%_off")
	public void verifySudentUpsellCopy()
	{
		driver.get("https://www.paramountplus.com/account/signup/edu-offer/");
		Edu_OfferPage studentUpsellPage= new Edu_OfferPage(driver);
		String headertxt= studentUpsellPage.getupsellHeadertxt().getText();
		boolean flag1= headertxt.equalsIgnoreCase("STUDENTS GET 25% OFF");
		Assert.assertTrue(flag1);
		String subHeadertxt= studentUpsellPage.getUpsellSubHeadertxt().getText();
		System.out.println(subHeadertxt);
		boolean flag2= subHeadertxt.equalsIgnoreCase("Work hard. Play harder. Students get an Essential monthly plan for just $3.75/mo.! Cancel anytime.");
		Assert.assertTrue(flag2);
		LoggerUtility.info("Header and sub-header text verified- TEST PASSED");
	}
}
