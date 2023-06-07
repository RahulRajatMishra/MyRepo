package com. paramountplus.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

/**
 * It contains WebDriver specific reusable methods
 * @author rahulrajat.m
 */

public class WebDriverUtility {
	/**
	 * wait for page to load before finding any synchronized element in the DOM[HTML-Document]
	 * @param driver
	 */

	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	/**
	 * wait for page to load before identifying any assynchronized [Java script actions] element in DOM
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver)
	{
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(45));

	}
	/**
	 * Wait for page to load completely
	 * @param driver
	 */
	public void pageLoadTimeout(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	}
	/**
	 * Javascript Executor for page ready state
	 * @param driver
	 */
	public void waitForCompletePageLoad(WebDriver driver)
	{
		try{

			JavascriptExecutor j = (JavascriptExecutor)driver;
			if (j.executeScript("return document.readyState").toString().equals("complete")){
				System.out.println("Page in ready state"); }
		} catch(Exception exe) {
			System.out.println("Page not in ready state");
		}
	}
	/**
	 * Used to wait for element to be clickable in GUI, & check for specific element every 500 milli seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(45));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * Used to wait for element to be visible on the GUI
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(45));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * Used to check the visibility of all elements
	 * @param driver
	 * @param elements
	 */
	public void waitForVisibilityOfAllElement(WebDriver driver, List<WebElement> elements)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(45));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	/**
	 * wait till alert is present
	 * @param driver
	 */
	public void waitForAlert(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(45));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * Used to wait till the page partial page title is matched
	 * @param driver
	 * @param title
	 */
	public void waitAndVerifyPageTitle(WebDriver driver, String partialTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.titleContains(partialTitle));
	}
	/**
	 * used to wait for element to be clickable in GUI & check for the specific element after the specified time
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws InterruptedException
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws InterruptedException
	{
		FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofSeconds(pollingTime));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to switch any window based on the window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> set= driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		while(itr.hasNext())
		{
			String wID= itr.next();
			driver.switchTo().window(wID);
			String currentWindowTitle= driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	/**
	 * used to switch to alert window and click OK button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * Used to switch to alert window and click on cancel button
	 * @param driver
	 */
	public void switchToAlertAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * Used to switch to Frame window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * Used to switch to Frame Window based on id, name and attribute
	 * @param driver
	 * @param ID_Name_Attribute
	 */
	public void switchToFrame(WebDriver driver, String ID_Name_Attribute)
	{
		driver.switchTo().frame(ID_Name_Attribute);
	}
	/**
	 * Used to select the value from drop-down based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * Used to select the element from drop-down based on visible text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * Used to right click on specific element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element)
	{
		Actions a= new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * Mouse hover and click on sub menu item
	 * @param driver
	 * @param menu
	 * @param subMenu
	 * @throws InterruptedException 
	 */
	public void mouseHoverAndClick(WebDriver driver, WebElement menu, WebElement subMenu) throws InterruptedException
	{
		int count=0;
		while(count<5)
		{
			try {
				Actions a= new Actions(driver);
				a.moveToElement(menu).perform();
				a.moveToElement(subMenu).perform();
				subMenu.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				LoggerUtility.info("Submenu is not found");
				e.printStackTrace();
			}
			count++;
		}
	}

	/**
	 * Used to right click on a specific element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}
	/**
	 * It is used to execute java script to handle disable element and scroll bar
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript(javaScript);
	}
	/**
	 * This method is used to check whether element is displayed or not
	 * @param driver
	 * @param element
	 */
	public boolean isElementFound(WebDriver driver, WebElement element)
	{

		try {
			element.isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * This method is used to scroll the page till element is displayed
	 * @param driver
	 * @param element
	 */
	public void scrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	/**
	 * Use to scroll the page to the bottom and load all all elements
	 * @param driver
	 */
	public void scrollTillAllElementsLoaded(WebDriver driver)
	{
		//		long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("document.body.scrollHeight");
		int cont=100;
		while (true)
		{
			try {
				//((JavascriptExecutor) driver).executeScript("window.scrollTo(0, "+cont+");");
				executeJavaScript(driver, "window.scrollTo(0, "+cont+");");
				Thread.sleep(3000);

				long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.documentElement.scrollHeight");
				if (newHeight <= cont) {
					break;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			cont+=500;
		}
	}
	/**
	 * Scroll to the bottom of the page
	 * @param driver
	 */
	public void scrollToBottom(WebDriver driver)
	{
		while(true)
		{
			try {
				executeJavaScript(driver, "window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));");
				break;
			}
			catch(JavascriptException e)
			{
				e.printStackTrace();
			}
		}
	}
	/**
	 * Scroll to the top of the page
	 * @param driver
	 */
	public void scrollToTop(WebDriver driver)
	{
		try {
			executeJavaScript(driver, "window.scrollTo(0,0);");
		}
		catch (Exception e) {
			e.printStackTrace();
			executeJavaScript(driver, "window.scrollTo(0,0);");
		}
	}
	/**
	 * Used to scroll and wait for element to load
	 * @param driver
	 * @throws InterruptedException
	 */
	public void scrollTillElementIsDisplayed(WebDriver driver, WebElement element)
	{
		int cont=500;
		while (true) 
		{
			try {
				executeJavaScript(driver, "window.scrollTo(0, "+cont+");");
				if (element.isDisplayed()) {
					break;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				cont+=300;
			} 
		}
	}
	/**
	 * Used to click on element after every 1000ms
	 *  @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<20)
		{
			try
			{
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	public void takeScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./screenshot/"+screenShotName+" .jpg");
		FileUtils.copyFile(src, dest);	
	}
	/**
	 * Used to press Enter button
	 * @param driver
	 */
	public void pressEnterKey(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * Press ENTER and wait for element visibility
	 * @param driver
	 * @param element
	 * @throws InterruptedException 
	 */
	public void pressEnterAndWaitForElement(WebDriver driver, WebElement element) throws InterruptedException
	{
		int count= 0;
		while(count<10)
		{
			try {
				Actions act= new Actions(driver);
				act.sendKeys(Keys.ENTER).perform();
				if(element.isDisplayed())
					break;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			count++;
		}
	}
	/**
	 * Used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * Used to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	//method to delete all cookies
	public void ClearBrowserCache(WebDriver driver) throws InterruptedException
	{
		driver.manage().deleteAllCookies();
	}
	/**
	 * Use to refresh the page and check for element to be visible
	 * @param driver
	 * @param element
	 */
	public void pageRefreshAndWaitForElementVisibilty(WebDriver driver, WebElement element)
	{
		int count=0;
		while(count<5)
		{
			try {
				driver.navigate().refresh();
				WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOf(element));
				break;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			count++;
		}
	}
	/**
	 * Wait till 30 sec for element selection state to be true
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeSelectable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
	}
	/**
	 * Used to check the current URL using partial URL text
	 * @param driver
	 * @param partialURL
	 */
	public boolean waitTillcurrectURLContains(WebDriver driver, String partialURL)
	{
		try {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains(partialURL));
			return true;}
		catch (TimeoutException e) {
			e.printStackTrace();
			return false;
		}
	}
}
