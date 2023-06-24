package com.paramountplus.objectRepository;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.ExcelUtility;
import com.paramountplus.genericUtility.FileUtility;
import com.paramountplus.genericUtility.JavaUtility;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.WebDriverUtility;

public class CreateAccountPage {

	WebDriverUtility wLib= new WebDriverUtility();
	JavaUtility jLib= new JavaUtility();
	FileUtility fLib= new FileUtility();
	ExcelUtility eLib= new ExcelUtility();
	WebDriver driver= BaseClass.sdriver;

	@FindBy(css="#fullName")
	private WebElement fullNametxtField;

	@FindBy(css="#email")
	private WebElement emailtxtField;

	@FindBy(css="#password")
	private WebElement passwordtxtField;

	@FindBy(css="#zip")
	private WebElement zipCodetxtField;

	@FindBy(css="#birthday")
	private WebElement DOBtxtField; //Format: MM/DD/YYYY

	@FindBy(css="#custom-selector-gender-selected")
	private WebElement genderDropdown;

	@FindBy(css="li[value='Male']")
	private WebElement genderMale;

	@FindBy(css="li[value='Female']")
	private WebElement genderFemale;

	@FindBy(css="button[class='button button qt-continuebtn vue-focusable buttonWindows'] span")
	private WebElement continuebtn;


	public CreateAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFullNametxtField() {
		return fullNametxtField;
	}

	public WebElement getEmailtxtField() {
		return emailtxtField;
	}

	public WebElement getPasswordtxtField() {
		return passwordtxtField;
	}

	public WebElement getZipCodetxtField() {
		return zipCodetxtField;
	}

	public WebElement getDOBtxtField() {
		return DOBtxtField;
	}

	public WebElement getGenderDropdown() {
		return genderDropdown;
	}

	public WebElement getGenderMale() {
		return genderMale;
	}

	public WebElement getGenderFemale() {
		return genderFemale;
	}

	public WebElement getContinuebtn() {
		return continuebtn;
	}
	//Library functions

	public void createEssentialAccount() throws InterruptedException
	{
		String fullName= "Auto "+"User";
		fullNametxtField.sendKeys(fullName);
		String email="Essential@"+"auto"+jLib.getRandomNumber()+".com";
		fLib.writePropertyValue("NewEssentialUser", email);
		emailtxtField.sendKeys(email);
		passwordtxtField.sendKeys("123456");
		zipCodetxtField.sendKeys("10001");
		DOBtxtField.sendKeys("08/31/1990");
		genderDropdown.click();
		wLib.waitForElementToBeVisible(driver, genderMale);
		genderMale.click();

		/*1* for(int i=0; i<5;i++)
		{
			try {
				if(continuebtn.isEnabled())
				{
//			        wLib.waitForElementToBeClickable(driver, continuebtn);
					Thread.sleep(2000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", continuebtn);
				}
				if(wLib.waitTillcurrectURLContains(driver, "payment"))
				{
					LoggerUtility.info("User is taken to payment page");
					break;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				LoggerUtility.info("User is not taken to payment page");
			}
		}*/

		/*2* for(int i=0; i<10;i++)
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			continuebtn.click();
			if(wLib.waitTillcurrectURLContains(driver,"payment"))
			{
				LoggerUtility.info("User is taken to the payment screen");
				break;
			}
		}*/

		//		wLib.waitForElementToBeVisible(driver, getContinuebtn());
		//		wLib.waitForElementToBeClickable(driver, getContinuebtn());
		//		continuebtn.click();
		//		Actions action= new Actions(driver);
		//		action.moveToElement(getContinuebtn()).click().build().perform();
//		wLib.executeJavaScript(driver, "let d = new Date(); d.setDate(d.getDate()+365); document.cookie = \"ovvuid=growth-qa-65b30329-0043-450c-b148-c6db0175acaf;path=/;expires=\"+d;");
//		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getContinuebtn());
	}

}

