package object_repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.Webdriver_utility;

public class HomePage {

	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Declaration
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(name="Campaigns")
	private WebElement campLink;
	
	@FindBy(css="[src='themes/softed/images/user.PNG']")
	private WebElement admLink;

	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	@FindBy(linkText = "Products")
	private WebElement prdLink;
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	@FindBy(linkText="Contacts")
	private WebElement conLink;
	
	//getter method
	public WebElement getMoreLink() {
		return moreLink;
		}
	public WebElement getCampLink() {
		return campLink;
		}
	
	public WebElement getConLink() {
		return conLink;
		}

		
	/**
	 * this method is used to click campaign link
	 * 	 */
	public void clickCampLink() {
		moreLink.click();
		campLink.click();
	}
	public void logOut(WebDriver driver) {
	Webdriver_utility wlib = new Webdriver_utility();
	wlib.mouseHoverToEle(driver,admLink);	
	signOut.click();
	
	}
	public void signOut() {
		admLink.click();
		signOut.click();
	}
	public void clickprdLink() {
		prdLink.click();
		
	}
	public void clickorgLink() {
		
		orgLink.click();
		
	}
	public void clickconLink() {
		conLink.click();
	}
	
	
	
}
