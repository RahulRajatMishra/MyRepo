package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteConfirmPage {

	@FindBy(xpath="//span[contains(text(),'YES, DELETE PROFILE')]")
	private WebElement yesDeleteProfilebtn;
	
	@FindBy(xpath="//span[contains(text(),'NO, KEEP PROFILE')]")
	private WebElement noKeepProfilebtn;
	
	public DeleteConfirmPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getYesDeleteProfilebtn() {
		return yesDeleteProfilebtn;
	}

	public WebElement getNoKeepProfilebtn() {
		return noKeepProfilebtn;
	}
	
}
