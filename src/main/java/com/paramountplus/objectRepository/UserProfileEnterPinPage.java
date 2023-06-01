package com.paramountplus.objectRepository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.WebDriverUtility;

public class UserProfileEnterPinPage {
	WebDriver driver= BaseClass.sdriver;
	WebDriverUtility wLib= new WebDriverUtility();
	@FindBy(css= ".digit")
	private List<WebElement> enterPINFields;

	@FindBy(css=".digit-field-set")
	private WebElement enterPINfield;

	public UserProfileEnterPinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public List<WebElement> getEnterPINFields() {
		return enterPINFields;
	}

	public WebElement getEnterPINfield() {
		return enterPINfield;
	}

	//Library functions
	public void enterPIN()
	{
		wLib.waitTillcurrectURLContains(driver, "enter-pin");
		for(WebElement PinBox:getEnterPINFields())
		{
			PinBox.sendKeys("1");
		}

	}
}
