package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage1 {

	public HomePage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(css = "[href='index.php?module=Products&action=index']"),@FindBy(xpath = "//a[text()='Products']")})
	private WebElement prdLink;
	
	@FindBys({@FindBy(css = "[alt='Create Product...']"),@FindBy(xpath = "//img[@title='Create Product...']")})
	private WebElement lookUp;
	
	public void clickPrdLink()
	{
		prdLink.click();
	}
	
	public void clickLookUp()
	{
		lookUp.click();
	}
}