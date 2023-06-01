package com.paramountplus.genericUtility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.naming.spi.DirectoryManager;

import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.paramountplus.objectRepository.HomePage;
import com.paramountplus.objectRepository.LoginPage;
import com.paramountplus.objectRepository.PlanPage;
import com.paramountplus.objectRepository.UpsellPage;
import com.paramountplus.objectRepository.WhosWatchingPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.paramountplus.genericUtility.ListenerImplementation.class)
public class BaseClass {

	public WebDriverUtility wLib= new WebDriverUtility();
	public JavaUtility jLib= new JavaUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public FileUtility fLib= new FileUtility();
	//	public LoginUtility lLib= new LoginUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	public static String screenshotSubFolderName;
	public static ExtentReports extentRepots;
	public static ExtentTest extentTest;

	@BeforeSuite
	public void initialiseExtentReports()
	{
		ExtentSparkReporter sparkReporter_all= new ExtentSparkReporter("./Reports/AllTests.html");
		sparkReporter_all.config().setReportName("All Tests Report");

		ExtentSparkReporter sparkReporter_failed= new ExtentSparkReporter("./Reports/FailedTests.html");
		sparkReporter_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		sparkReporter_failed.config().setReportName("Failure Report");

		ExtentSparkReporter sparkReporter_skipped= new ExtentSparkReporter("./Reports/SkippedTests.html");
		sparkReporter_skipped.filter().statusFilter().as(new Status[] {Status.SKIP}).apply();
		sparkReporter_skipped.config().setReportName("Skipped Report");
		extentRepots= new ExtentReports();
		extentRepots.attachReporter(sparkReporter_all, sparkReporter_failed, sparkReporter_skipped);

		extentRepots.setSystemInfo("OS","Windows");
		extentRepots.setSystemInfo("Java Version", System.getProperty("java.version"));
	}
	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(ITestContext context,@Optional("chrome") String browserName) throws IOException, InterruptedException
	{
		//		read values from properties file
		//		String browserName= fLib.getPropertyValue("browser");
		String url= fLib.getPropertyValue("url");

		//		Instantiating browser respective options class
		ChromeOptions chromeOptions= new ChromeOptions();
		FirefoxOptions fireFoxOptions= new FirefoxOptions();
		EdgeOptions edgeOptions= new EdgeOptions();

		// code for clicking on allow, block or ask on the notification pop-up (0 for ask, 1 for allow, 2 for block)
		HashMap<String, Integer> contentSettings= new HashMap<String, Integer>();
		HashMap<String, Object> profile= new HashMap<String, Object>();
		HashMap<String, Object> prefs= new HashMap<String, Object>();
		contentSettings.put("notifications", 1);
		contentSettings.put("geolocation", 1);
		contentSettings.put("media_stream", 2);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);

		chromeOptions.setExperimentalOption("prefs", prefs);
		fireFoxOptions.setCapability("prefs", prefs);
		edgeOptions.setExperimentalOption("prefs", prefs);

		// Launching browser based on the parameter passed
		switch(browserName.toLowerCase())
		{
		case "chrome":
			//          chromeOptions.addArguments("--headless=new");
			//			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--remote-allow-origins=*");
			//			chromeOptions.addArguments("--disable-notifications");
			//			chromeOptions.addArguments("disable-geolocation");
			driver= new ChromeDriver(chromeOptions);
			LoggerUtility.info("Chrome browser launched");
			break;
		case "firefox":
			//			fireFoxOptions.addArguments("-headless");
			driver= new FirefoxDriver(fireFoxOptions);
			LoggerUtility.info("Firefox browser launched");
			break;
		case "edge":
			//			edgeOptions.addArguments("--headless=new");
			driver= new EdgeDriver(edgeOptions);
			LoggerUtility.info("Edge browser launched");
			break;
		default:
			LoggerUtility.info("BrowserName is invalid");
			break;
		}
		//		Use static driver while implementing ITestListener
		sdriver= driver;
		//		Extent Report implementation
		Capabilities capabilities= ((RemoteWebDriver) driver).getCapabilities();
		String device= capabilities.getBrowserName()+" "+capabilities.getBrowserVersion().substring(0,capabilities.getBrowserVersion().indexOf("."));
		String author= context.getCurrentXmlTest().getParameter("author");

		extentTest= extentRepots.createTest(context.getName());
		extentTest.assignAuthor(author);
		extentTest.assignDevice(device);

		wLib.maximizeWindow(driver);
		//		wLib.ClearBrowserCache(driver);
		wLib.waitForPageToLoad(driver);
		wLib.pageLoadTimeout(driver);
		driver.get(url);
		LoggerUtility.info("Upsell page displayed");
	}
	//	@Parameters({"userName", "pwd"})
	//	@BeforeMethod(alwaysRun= true)
	//	public void beforeMethod(@Optional String userName,@Optional String pwd) throws IOException, InterruptedException
	//	{
	//				Sign in to the application
	//				String userName= fLib.getPropertyValue("userName");
	//				String pwd= fLib.getPropertyValue("password");
	//				UpsellPage upsellPage= new UpsellPage(driver);
	//				upsellPage.getSignInButton().click();
	//				LoggerUtility.info("Login page displayed");
	//				LoginPage loginPage= new LoginPage(driver);
	//				loginPage.getUserNameInputField().sendKeys(userName);
	//				loginPage.getPasswordInputField().sendKeys(pwd);
	//				for(int i=0; i<3;i++)
	//				{
	//					try {
	//						loginPage.getContinueButton().click();
	//					}
	//					catch(Exception e)
	//					{
	//						e.printStackTrace();
	//						wLib.waitForElementToBeClickable(driver, loginPage.getContinueButton());
	//						loginPage.getContinueButton().click();
	//					}
	//				}
	//				LoggerUtility.info("Signed in successfully - Home page displayed ");
	//	}
	@AfterMethod
	public void afterMethod(Method m, ITestResult result)
	{
		//Extent Report implementation- check execution status
		if(result.getStatus()==ITestResult.FAILURE) {
			String screenshotPath=null;
			screenshotPath= captureScreenshot(result.getTestContext().getName()+"-"+result.getMethod().getMethodName()+".jpg");
			extentTest.addScreenCaptureFromPath(screenshotPath);
			extentTest.fail(m.getName()+" Failed");
			extentTest.fail(result.getThrowable());
		}else if(result.getStatus()==ITestResult.SUCCESS) {

			extentTest.pass(m.getName()+" Passed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			extentTest.skip(m.getName()+" Skipped");
			extentTest.skip(result.getThrowable());
		}
		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
		extentTest.assignCategory(m.getAnnotation(Test.class).description());
	}
	public String captureScreenshot(String fileName) {
		if(screenshotSubFolderName==null) {
			LocalDateTime myDateObj= LocalDateTime.now();
			DateTimeFormatter myFormatObj =DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			screenshotSubFolderName= myDateObj.format(myFormatObj);				
		}
		TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
		File sourceFile= takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile= new File("./Screenshot/"+screenshotSubFolderName+"/"+fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Reporter.log("Screenshot saved successfully",true);
		return destFile.getAbsolutePath();

	}
	@AfterClass
	public void afterClass() throws InterruptedException
	{
		driver.quit();
		LoggerUtility.info("Browser closed successfully");
	}
	@AfterSuite
	public void generateExtentReports() throws Exception
	{
		extentRepots.flush();
	}
}
