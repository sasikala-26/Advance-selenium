package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLookUpImg {

	
public ContactLookUpImg(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

@FindBy(css="[alt=\"Create Contact...\"]")
private WebElement ContactLookUp;

public WebElement getContactLookUp() {
	return ContactLookUp;
}
public void clickContactLookUp() {
	ContactLookUp.click();
}

}