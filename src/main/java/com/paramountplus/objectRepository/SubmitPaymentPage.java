package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.WebDriverUtility;

import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;

public class SubmitPaymentPage {
	WebDriverUtility wLib= new WebDriverUtility();
	WebDriver driver= BaseClass.sdriver;

	@FindBy(css="h1 span:nth-child(1)")
	private WebElement paymentMethodLabel;

	@FindBy(xpath="//a[@id='tab-cards' and @aria-selected='true']")
	private WebElement cardsPaymentselected;

	@FindBy(css="#address1")
	private WebElement addresstxtField;

	@FindBy(css="#city")
	private WebElement citytxtField;

	@FindBy(css="#custom-selector-state-selected")
	private WebElement selectStateDropdown;
	//	Options: AK, AL, AR, AZ, HI, IN, ID, CO etc...

	@FindBy(css="li[value='AK']")
	private WebElement selectState;

	@FindBy(css="#postal_code")
	private WebElement zipCodetxtField;

	@FindBy(css="html body form input[autocomplete='cc-number']")
	private WebElement ccNumbertxtField;

	@FindBy(css="html body form input:nth-child(1)[autocomplete='cc-exp-month']")
	private WebElement ccExpireMonthtxtField;

	@FindBy(css="html body form input:nth-child(1)[autocomplete='cc-exp-year']")
	private WebElement ccExpireYeartxtField;

	@FindBy(css="html body form input:nth-child(1)[autocomplete='off']")
	private WebElement ccCvvtxtField;

	@FindBy(css="div button[class='payment-layout__summary__submit button qt-AAbtn'] span")
	private WebElement startParamountbtn;

	public SubmitPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCardsPaymentselected() {
		return cardsPaymentselected;
	}

	public WebElement getAddresstxtField() {
		return addresstxtField;
	}

	public WebElement getCitytxtField() {
		return citytxtField;
	}

	public WebElement getSelectStateDropdown() {
		return selectStateDropdown;
	}

	public WebElement getZipCodetxtField() {
		return zipCodetxtField;
	}
	public WebElement getCcNumbertxtField() {
		return ccNumbertxtField;
	}

	public WebElement getCcExpireMonthtxtField() {
		return ccExpireMonthtxtField;
	}

	public WebElement getCcExpireYeartxtField() {
		return ccExpireYeartxtField;
	}

	public WebElement getCcCvvtxtField() {
		return ccCvvtxtField;
	}

	public WebElement getStartParamountbtn() {
		return startParamountbtn;
	}

	public WebElement getSelectState() {
		return selectState;
	}
	//	Library function

	public void makePayment()
	{
		addresstxtField.sendKeys("New York City");
		citytxtField.sendKeys("New work");
		//		Select select= new Select(selectStateDropdown);
		//		select.selectByValue("AK");
		selectStateDropdown.click();
		selectState.click();
		getZipCodetxtField().sendKeys("10001");
		wLib.scrollToBottom(driver);
		wLib.switchToFrame(driver, 0);
		getCcNumbertxtField().sendKeys("4111111111111111");
		driver.switchTo().parentFrame();
		wLib.switchToFrame(driver, 1);
		getCcExpireMonthtxtField().sendKeys("12");
		driver.switchTo().parentFrame();
		wLib.switchToFrame(driver, 2);
		getCcExpireYeartxtField().sendKeys("2025");
		driver.switchTo().parentFrame();
		wLib.switchToFrame(driver, 3);
		getCcCvvtxtField().sendKeys("123");
		driver.switchTo().parentFrame();
		getStartParamountbtn().click();
		
	}
}
