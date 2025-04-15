package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {
	public CreateCampPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//img[@alt=\"Select\"]")
	private WebElement prdPlusSign;

	public WebElement getCampNAme() {
		return campName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void enterCampDetails(String name)
	{
		campName.sendKeys(name);
		saveButton.click();
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
	public void clickPrdPlusSign()
	{
		prdPlusSign.click();
	}
}
