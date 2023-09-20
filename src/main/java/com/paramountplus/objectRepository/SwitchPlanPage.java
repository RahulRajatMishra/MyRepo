package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paramountplus.genericUtility.WebDriverUtility;

public class SwitchPlanPage {

	WebDriverUtility wLib= new WebDriverUtility();
	@FindBy(css=".account-grid div h3")
	private WebElement switchYourPlantxt;

	@FindBy(xpath="//span[normalize-space(text())='Switch Plan']")
	private WebElement switchPlanbtn;

	@FindBy(xpath="//span[normalize-space(text())='Cancel']")
	private WebElement cancelbtn;
	
	@FindBy(xpath="//div[contains(text(), 'Paramount+ Essential')]")
	private WebElement essentialPlantxt;
	
	@FindBy(xpath="//div[text()='Essential']/ancestor::label/div[1]/span")
	private WebElement essentialPlanRadiobtn;
	
	@FindBy(xpath="//div[contains(text(), 'Paramount+ Essential')]/ancestor::label/div[2]/div/div[2]/span")
	private WebElement essentialPlanPrice;
	
	@FindBy(xpath="//div/div/div/div[contains(text(), 'Paramount+ with SHOWTIME®')]")
	private WebElement premiumPlantxt;
	
	@FindBy(xpath="//div[text()='Premium']/ancestor::label/div[1]/span")
	private WebElement premiumPlanRadiobtn;

	@FindBy(xpath="//div/div/div/div[contains(text(), 'Paramount+ with SHOWTIME®')]/ancestor::label/div[2]/div/div[2]/span")
	private WebElement premiumPlanPrice;
	
	@FindBy(xpath="//div[text()='Essential w/ SHOWTIME®']")
	private WebElement essentialWithShowtimetxt;
	
	@FindBy(xpath="//div[text()='Essential w/ SHOWTIME®']/ancestor::label/div[1]/span")
	private WebElement essentialWithShowtimeRadiobtn;
	
	@FindBy(xpath="//div[text()='Essential w/ SHOWTIME®']/ancestor::label/div[2]/div/div[3]/span")
	private WebElement essentialWithShowtimePrice;
	
	@FindBy(xpath="//div[text()='Premium w/ SHOWTIME®']")
	private WebElement premiumWithShowtimetxt;
	
	@FindBy(xpath="//div[text()='Premium w/ SHOWTIME®']/ancestor::label/div[1]/span")
	private WebElement premiumWithShowtimeRadiobtn;
	
	@FindBy(xpath="//div[text()='Premium w/ SHOWTIME®']/ancestor::label/div[2]/div/div[3]/span")
	private WebElement premiumWithShowtimePrice;
	
	public SwitchPlanPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSwitchYourPlantxt() {
		return switchYourPlantxt;
	}

	public WebElement getSwitchPlanbtn() {
		return switchPlanbtn;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}

	public WebElement getEssentialPlantxt() {
		return essentialPlantxt;
	}

	public WebElement getEssentialPlanRadiobtn() {
		return essentialPlanRadiobtn;
	}

	public WebElement getEssentialPlanPrice() {
		return essentialPlanPrice;
	}

	public WebElement getPremiumPlantxt() {
		return premiumPlantxt;
	}

	public WebElement getPremiumPlanRadiobtn() {
		return premiumPlanRadiobtn;
	}

	public WebElement getPremiumPlanPrice() {
		return premiumPlanPrice;
	}

	public WebElement getEssentialWithShowtimetxt() {
		return essentialWithShowtimetxt;
	}

	public WebElement getEssentialWithShowtimeRadiobtn() {
		return essentialWithShowtimeRadiobtn;
	}

	public WebElement getEssentialWithShowtimePrice() {
		return essentialWithShowtimePrice;
	}

	public WebElement getPremiumWithShowtimetxt() {
		return premiumWithShowtimetxt;
	}

	public WebElement getPremiumWithShowtimeRadiobtn() {
		return premiumWithShowtimeRadiobtn;
	}

	public WebElement getPremiumWithShowtimePrice() {
		return premiumWithShowtimePrice;
	}

}
