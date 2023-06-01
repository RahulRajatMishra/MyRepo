package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage {

	@FindBy(css="input.qt-emailtxtfield")
	private WebElement profileNametxt;
	
	@FindBy(xpath="//span[contains(text(),'Save Profile')]")
	private WebElement saveProfilebtn;
	
	@FindBy(xpath="//span[normalize-space(text())='DELETE PROFILE']")
	private WebElement deleteProfilebtn;
	
	public EditProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProfileNametxt() {
		return profileNametxt;
	}

	public WebElement getSaveProfilebtn() {
		return saveProfilebtn;
	}

	public WebElement getDeleteProfilebtn() {
		return deleteProfilebtn;
	}
	
}
