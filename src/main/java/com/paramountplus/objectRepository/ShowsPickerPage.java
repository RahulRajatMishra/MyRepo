package com.paramountplus.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paramountplus.genericUtility.BaseClass;

public class ShowsPickerPage {

	WebDriver driver= BaseClass.sdriver;
	@FindBy(xpath="//div[text()[normalize-space()='NEXT']]")
	private WebElement nextbtn;

	@FindBy(css=".show-picker-grid.grid.portrait>article")
	private List<WebElement> showPickerGrid;

	public ShowsPickerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNextbtn() {
		return nextbtn;
	}

	public List<WebElement> getShowPickerGrid() {
		return showPickerGrid;
	}
	//Library functions
	public void selectThreeShows()
	{
		ShowsPickerPage showsPicker= new ShowsPickerPage(driver);
		List<WebElement> list= showsPicker.getShowPickerGrid();
		for(int i=0;i<3;i++)
		{
			list.get(i).click();
		}
	}
}
