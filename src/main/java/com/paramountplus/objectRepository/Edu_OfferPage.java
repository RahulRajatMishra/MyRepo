package com.paramountplus.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edu_OfferPage {

	@FindBy(xpath="//h1[normalize-space(text())= 'STUDENTS GET 25% OFF']")
	private WebElement upsellHeadertxt;

	@FindBy(xpath="//div[text()[normalize-space()='Work hard. Play harder. Students get an Essential monthly plan for just $3.75/mo.! Cancel anytime.']]")
	private WebElement upsellSubHeadertxt;
	
	@FindBy(xpath="//div[normalize-space(text())= 'GET 25% OFF']")
	private List<WebElement> get25percentOffcta;

	public Edu_OfferPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public WebElement getupsellHeadertxt() {
		return upsellHeadertxt;
	}

	public List<WebElement> getGet25percentOffcta() {
		return get25percentOffcta;
	}
	public WebElement getUpsellSubHeadertxt() {
		return upsellSubHeadertxt;
	}


}
