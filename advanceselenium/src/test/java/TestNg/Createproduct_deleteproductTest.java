package TestNg;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Excel_utility;
import generic_utilities.File_utility;
import generic_utilities.Java_utility;
import generic_utilities.Webdriver_utility;
import object_repo.CreatePrdPage;
import object_repo.DeleteProductPage;
import object_repo.HomePage;
import object_repo.HomePage1;
import object_repo.LoginPage;
import object_repo.ProductValidation;

public class Createproduct_deleteproductTest extends BaseClass {
	

@	Test

		public  void Createproduct_deleteproductTest()throws Throwable {
			// TODO Auto-generated method stub


	File_utility flib=new File_utility();
	//String BROWSER=flib.getKeyAndValuePair("browser");
	String URL=flib.getKeyAndValuePair("url");
	String USERNAME=flib.getKeyAndValuePair("username");
	String PASSWORD=flib.getKeyAndValuePair("password");
	//WebDriver driver;

	//if (BROWSER.equalsIgnoreCase("chrome")) {
		//driver = new ChromeDriver();
	//} else if (BROWSER.equalsIgnoreCase("firefox")) {
		//driver = new FirefoxDriver();
	//} else if (BROWSER.equalsIgnoreCase("edge")) {
		//driver = new EdgeDriver();
	//} else {
		//driver = new ChromeDriver();
	//}

	driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	//driver.findElement(By.id("submitButton")).click();
	LoginPage login = new LoginPage(driver);
	login.loginIntoApp(USERNAME, PASSWORD);
	//driver.findElement(By.linkText("Products")).click();
	HomePage1 home = new HomePage1(driver);
	home.clickPrdLink();
	//driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")
		//	).click();
	home.clickLookUp();
	Java_utility jlib=	new Java_utility();
	int ranNum=jlib.getRandomNum();
	Excel_utility elib=new Excel_utility();
	String prdName=elib.getExcelData("Product", 0, 0)+ranNum;
	//driver.findElement(By.name("productname")).sendKeys(prdName);
	CreatePrdPage prdPage = new CreatePrdPage(driver);
	prdPage.enterPrdDetails(prdName);
	home.clickPrdLink();

		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//ProductValidation prdvalidate = new ProductValidation(driver);
	//prdvalidate.validatePrd(driver, prdName);
		//driver.findElement(By.linkText("Products")).click();
	home.clickPrdLink();
		//table[@class="lvt small"]//a[text()='Product Name']/../preceding-sibling::td//input[@type="checkbox"]
		//driver.findElement(By.xpath("//table[@class=\"lvt small\"]//a[text()='"+prdName+"']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
		//driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
		DeleteProductPage deleteproduct = new DeleteProductPage(driver);
		deleteproduct.selectPrdCheckBox(driver, prdName);
		deleteproduct.clickDeletePrdButton();
		//driver.switchTo().alert().accept();
		Webdriver_utility wlib = new Webdriver_utility();
		wlib.alertAccept(driver);
		//List<WebElement> allNames = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
		//boolean flag=false;
		//for (WebElement name : allNames)
		//{
			//String actPrd = name.getText();
			//if(actPrd.equals(prdName))
			//{
			//flag=true;
			//break;
		//}
			//}
		//if(flag)
		//{
			//System.out.println("product name is deleted");
		//}
		//else
		//{
			//System.out.println("Product name is not deleted");
		//}
		deleteproduct.validatePrdDeleted(driver, prdName);
		HomePage home1 = new HomePage(driver);
		home1.logOut(driver);
		}}

		
			

