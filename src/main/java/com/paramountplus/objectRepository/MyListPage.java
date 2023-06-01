package com.paramountplus.objectRepository;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paramountplus.genericUtility.BaseClass;
import com.paramountplus.genericUtility.WebDriverUtility;

public class MyListPage {
	WebDriver driver= BaseClass.sdriver;
	WebDriverUtility wLib= new WebDriverUtility();

	@FindBy(css=".empty-list>h2")
	private WebElement emptyListText;

	@FindBy(xpath="//div[contains(text(),'Find Shows')]")
	private WebElement findShowsLink;

	@FindBy(xpath="//div[contains(text(),'Find Movies')]")
	private WebElement findMovieLink;

	@FindBy(css=".padded-container.watchlist-browse-container>div>div")
	private List<WebElement> allMyListItems;

	@FindBy(xpath="//div[@class='watch-list-edit-carousel']")
	private WebElement editbtn;

	@FindBy(xpath="//div[text()='Remove']")
	private WebElement removebtn;

	@FindBy(css=".watch-list-edit-cancel-carousel")
	private WebElement cancelbtn;

	@FindBy(css=".confirmation-count")
	private WebElement removedConfirmPopup;

	public MyListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmptyListText() {
		return emptyListText;
	}

	public WebElement getFindShowsLink() {
		return findShowsLink;
	}

	public WebElement getFindMovieLink() {
		return findMovieLink;
	}

	public List<WebElement> getAllMyListItems() {
		return allMyListItems;
	}
	public WebElement getEditbtn() {
		return editbtn;
	}

	public WebElement getRemovebtn() {
		return removebtn;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	//Library function
	public void clickOnEditButton()
	{
		do {
			getEditbtn().click();
		}while(!getCancelbtn().isDisplayed());

	}
	public void removeMyListItems()
	{
		Iterator<WebElement> itr= getAllMyListItems().iterator();
		while(itr.hasNext())
		{
			WebElement firstItem= itr.next();
			firstItem.click();
			WebElement secondItem= itr.next();
			secondItem.click();
			break;
		}
		wLib.waitForElementToBeClickable(driver, getRemovebtn());
		getRemovebtn().click();
	}
}
