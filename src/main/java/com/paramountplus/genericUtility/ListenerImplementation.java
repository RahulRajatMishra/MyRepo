package com.paramountplus.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log("Test started- "+ result.getName(),true);
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test completed successfully- "+result.getName(), true);
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("Test failed- "+result.getName(), true);
		//get random number
		int num= new JavaUtility().getRandomNumber();
		//		get method name
		String methodName= result.getName();
		//		get current date
		String currentDate= new JavaUtility().getSystemDateAndTimeInISOFormat();
		//		Concatenate method name with date and number
		String screenShotName= methodName+"_"+num+"_"+currentDate;
		//		take screenshot
		try {
			new WebDriverUtility().takeScreenShot(BaseClass.sdriver, screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test skipped- "+result.getName(), true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("Test failed due to timeout- "+result.getName(), true);
	}

	public void onStart(ITestContext context) {
		Reporter.log("Started- "+ context.getName(), true);
	}

	public void onFinish(ITestContext context) {
		Reporter.log("Finished- "+ context.getName(), true);
	}





}
