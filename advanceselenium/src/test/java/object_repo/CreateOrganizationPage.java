package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
public CreateOrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(name="accountname")
private WebElement orgName;
@FindBy(id="phone")
private WebElement orgPhnNum;
@FindBy(id="email1")
private WebElement orgEmail;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement savebutton;



public WebElement getOrgName() {
	return orgName;
}
public WebElement getOrgPhnNum() {
	return orgPhnNum;
}
public WebElement getOrgEmail() {
	return orgEmail;
}
public void enterOrgDetails(String Name,String PhnNum,String Email) {
	orgName.sendKeys(Name);
	orgPhnNum.sendKeys(PhnNum);
	orgEmail.sendKeys(Email);
	
}
public void clicksaveButton() {
	savebutton.click();
}


}
