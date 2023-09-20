package com.paramountplus.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PickPlanPage {

	@FindBy(css="a[aria-label='Paramount+ Home']")
	public WebElement paramountLogo;

	@FindBy(xpath="//div[contains(text(),'pick your plan')]")
	private WebElement pickYourPlanText;

	@FindBy(css=".toggle-btn.left.active")
	private WebElement monthlyPlanActiveToggle;

	@FindBy(xpath="//span[normalize-space()='MONTHLY']")
	private WebElement monthlyPlanToggleButton;

	@FindBy(xpath="//span[normalize-space()='ANNUAL']")
	private WebElement annualPlanToggleButton;

	@FindBy(css="div[class='pick-a-plan-grid-item'] div:nth-child(1) div:nth-child(1) div:nth-child(1) h3:nth-child(1)")
	private WebElement essentialPlantxt;

	@FindBy(xpath="//span[contains(text(), '$5.99')]")
	//	@FindBy(xpath="//h3[contains(text(),'Essential')]/following-sibling::div/span")
	private WebElement monthlyEssentialPlanPrice;

	@FindBy(xpath="//span[contains(text(), '$59.99')]")
	//	@FindBy(xpath="//h3[contains(text(),'Essential')]/following-sibling::div/span")
	private WebElement annualEssentialPlanPrice;

	@FindBy(css=".plan-list-grid div:nth-child(1) div button")
	private WebElement selectEssentialPlan;

	@FindBy(css="div[class='pick-a-plan-grid-item'] div:nth-child(2) div:nth-child(1) div:nth-child(1) h3:nth-child(1)")
	private WebElement premiumPlantxt;

	@FindBy(css="//span[normalize-space()='$11.99']")
	private WebElement monthlyPremiumPlanPrice;

	@FindBy(css=".plan-list-grid div:nth-child(2) div button")
	private WebElement selectPremiumPlan;


	public PickPlanPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPickYourPlanText() {
		return pickYourPlanText;
	}

	public WebElement getMonthlyPlanActiveToggle() {
		return monthlyPlanActiveToggle;
	}

	public WebElement getMonthlyPlanToggleButton() {
		return monthlyPlanToggleButton;
	}

	public WebElement getAnnualPlanToggleButton() {
		return annualPlanToggleButton;
	}

	public WebElement getEssentialPlantxt() {
		return essentialPlantxt;
	}

	public WebElement getMonthlyEssentialPlanPrice() {
		return monthlyEssentialPlanPrice;
	}

	public WebElement getAnnualEssentialPlanPrice() {
		return annualEssentialPlanPrice;
	}

	public WebElement getSelectEssentialPlan() {
		return selectEssentialPlan;
	}

	public WebElement getPremiumPlantxt() {
		return premiumPlantxt;
	}

	public WebElement getMonthlyPremiumPlanPrice() {
		return monthlyPremiumPlanPrice;
	}

	public WebElement getSelectPremiumPlan() {
		return selectPremiumPlan;
	}

	public WebElement getParamountLogo() {
		return paramountLogo;
	}

}
