package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.JavaUtility;
import com.paramountplus.genericUtility.LoggerUtility;
import com.paramountplus.genericUtility.WebDriverUtility;

public class CreateProfilePage {

	WebDriver driver= BaseClass.sdriver;
	JavaUtility jLib= new JavaUtility();
	@FindBy(css=".qt-emailtxtfield")
	private WebElement profileNametxtField;

	@FindBy(xpath="//button[@id='parental-switch']")
	private WebElement parentalSwitchToggleButton;

	@FindBy(xpath="//input[@value='KIDS']/following-sibling::span")
	private WebElement olderKidsRadioButton;

	@FindBy(xpath="//input[@value='YOUNGER_KIDS']/following-sibling::span")
	private WebElement youngerKidsRadioButton;

	@FindBy(xpath="//span[contains(text(),'Save Profile')]")
	private WebElement saveProfileButton;

	@FindBy(css=".edit-loc")
	private WebElement chooseAvatar;

	public CreateProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getProfileNametxtField() {
		return profileNametxtField;
	}

	public WebElement getParentalSwitchToggleButton() {
		return parentalSwitchToggleButton;
	}

	public WebElement getOlderKidsRadioButton() {
		return olderKidsRadioButton;
	}

	public WebElement getYoungerKidsRadioButton() {
		return youngerKidsRadioButton;
	}

	public WebElement getChooseAvatar() {
		return chooseAvatar;
	}
	public WebElement getSaveProfileButton() {
		return saveProfileButton;
	}
	// Library functions
	public String createTestProfile()
	{
		String profileName= "Test"+jLib.getRandomNumber();
		getProfileNametxtField().sendKeys(profileName);
		getSaveProfileButton().click();
		LoggerUtility.info(profileName+" profile is created");
		return profileName.toLowerCase();
	}
	public String createOlderKidsProfile()
	{
		String profileName= "OlderKids"+jLib.getRandomNumber();
		getProfileNametxtField().sendKeys(profileName);
		getParentalSwitchToggleButton().click();
		getOlderKidsRadioButton().click();
		getSaveProfileButton().click();
		LoggerUtility.info(profileName+" profile is created");
		return profileName.toLowerCase();
	}

	public String createProfileWith18Chars()
	{
		String profileName= "TestUserWith18"+jLib.getRandomNumber();
		getProfileNametxtField().sendKeys(profileName);
		getSaveProfileButton().click();
		LoggerUtility.info(profileName+" profile is created");
		return profileName.toLowerCase();
	}

}
