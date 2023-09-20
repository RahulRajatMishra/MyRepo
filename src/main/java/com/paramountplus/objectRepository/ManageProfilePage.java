package com.paramountplus.objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProfilePage {


	@FindBy(css=".user-nav-items.content.large>li:nth-of-type(4)")
	private WebElement testProfile;  //newly created test profile from automation when One main profile, one Adult and one kids user profile already exists

	@FindBy(xpath="//a[contains(text(),'Test')]/parent::div")
	private WebElement newTestProfile;

	public ManageProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getTestProfile() {
		return testProfile;
	}

	public WebElement getNewTestProfile() {
		return newTestProfile;
	}

}
