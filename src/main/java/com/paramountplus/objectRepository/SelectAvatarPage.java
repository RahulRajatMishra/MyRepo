package com.paramountplus.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paramountplus.genericUtility.BaseClass;

public class SelectAvatarPage {

	WebDriver driver= BaseClass.sdriver;

	@FindBy(css=".carousel-container.swiper-wrapper.square-cards div a div img")
	private List<WebElement> allAvatars;

	@FindBy(xpath="//h2[contains(text(),'Emotions')]")
	private WebElement emotionAvatar;

	public SelectAvatarPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getAllAvatars() {
		return allAvatars;
	}

	public WebElement getEmotionAvatar() {
		return emotionAvatar;
	}

}
