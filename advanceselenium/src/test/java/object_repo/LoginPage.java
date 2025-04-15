package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//Element intialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Element declarations
	@FindBy(name="user_name")
	private WebElement UserTextField;
	@FindBy(name="user_password")
	private WebElement PassWordTextField;
	@FindBy(id="submitButton")
	private WebElement LoginButton;
	
	//getter methods
	public WebElement getUserTextField() {
		return UserTextField;
	}
	public WebElement getPassWordTextField() {
		return PassWordTextField;
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}
	//Business logics
	/**
	 * this method is used to login into application
	 * @param username
	 * @param password
	 * 
	 */
	public void loginIntoApp(String userName,String passWord) {
		UserTextField.sendKeys(userName);
		PassWordTextField.sendKeys(passWord);
		LoginButton.click();
	}
}

