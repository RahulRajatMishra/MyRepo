package com.paramountplus.genericUtility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.paramountplus.genericUtility.ListenerImplementation.class)
public class BaseClass {

	public WebDriverUtility wLib= new WebDriverUtility();
	public JavaUtility jLib= new JavaUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public FileUtility fLib= new FileUtility();
	public static WebDriver driver;
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
	//	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(ITestContext context,@Optional("chrome") String browserName) throws IOException, InterruptedException
	{
		//		read values from properties file
		browserName= fLib.getPropertyValue("browser");
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
		//		fireFoxOptions.setCapability("prefs", prefs);
		//	edgeOptions.setExperimentalOption("prefs", prefs);

		// Launching browser based on the parameter passed
		switch(browserName.toLowerCase())
		{
		case "chrome":
			//			chromeOptions.addArguments("--headless=new");
			//			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--remote-allow-origins=*");
			//			chromeOptions.addArguments("--disable-notifications");
			//			chromeOptions.addArguments("disable-geolocation");
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			WebDriverManager.chromedriver().setup();

			//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahulrajat.m.360NDCLP414\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
			//			chromeOptions.setBinary("C:\\Users\\rahulrajat.m.360NDCLP414\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
			driver= new ChromeDriver(chromeOptions);
			LoggerUtility.info("Chrome browser launched");
			break;
		case "firefox":
			//			fireFoxOptions.addArguments("-headless");
			fireFoxOptions.addPreference("dom.webnotifications.enabled", false);
			fireFoxOptions.addPreference("geo.enabled", false);
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
		//		String device= capabilities.getBrowserName()+" "+capabilities.getBrowserVersion().substring(0,capabilities.getBrowserVersion().indexOf("."));
		//		String author= context.getCurrentXmlTest().getParameter("author");

		String device= "Window";
		String author= "Rahul";
		extentTest= extentRepots.createTest(context.getName());
		extentTest.assignAuthor(author);
		extentTest.assignDevice(device);

		wLib.maximizeWindow(driver);
		wLib.ClearBrowserCache(driver);
//		wLib.pageLoadTimeout(driver);
		WebDriverUtility.waitForPageToLoad(driver, Duration.ofSeconds(30));
		wLib.waitForPageToLoad(driver);

		driver.get(url);
		wLib.executeJavaScript(driver, "let d = new Date(); d.setDate(d.getDate()+365); document.cookie = \"ovvuid=growth-qa-65b30329-0043-450c-b148-c6db0175acaf;path=/;expires=\"+d;");
		LoggerUtility.info("Upsell page displayed");
	}

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
