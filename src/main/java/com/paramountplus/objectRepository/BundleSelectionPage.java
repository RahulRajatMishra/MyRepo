package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BundleSelectionPage {

	@FindBy(css="div.ctas button:nth-child(1) div")
	private WebElement getTheBundlebtn;
	
	@FindBy(css="div.ctas button:nth-child(2) div")
	private WebElement mayBeLaterbtn;
	
	public BundleSelectionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getGetTheBundlebtn() {
		return getTheBundlebtn;
	}

	public WebElement getMayBeLaterbtn() {
		return mayBeLaterbtn;
	}
	
}
