package product;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utilities.Excel_utility;
import generic_utilities.File_utility;
import generic_utilities.Java_utility;
import generic_utilities.Webdriver_utility;
import object_repo.CampLookUpImg;
import object_repo.CampValidation;
import object_repo.CreateCampPage;
import object_repo.CreatePrdPage;
import object_repo.HomePage;
import object_repo.LoginPage;
import object_repo.PrdLookUpImg;
import object_repo.SwitchingWindowPage;

public class Campaignproduct {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Excel_utility elib = new Excel_utility();
		Java_utility jlib = new Java_utility();
		Webdriver_utility wlib = new Webdriver_utility();
//eng1
		File_utility flib = new File_utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);

		driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		LoginPage login=  new LoginPage(driver);
	    login.loginIntoApp(USERNAME,PASSWORD);

	   
		//driver.findElement(By.linkText("Products")).click();
	    HomePage home = new HomePage(driver);
	    home.clickprdLink();
	    
	    
		//driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
	    PrdLookUpImg lookUp = new PrdLookUpImg(driver);
		lookUp.clickPrdLookUp();



		int ranNum = jlib.getRandomNum();

		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(prdName);

		//driver.findElement(By.name("productname")).sendKeys(prdName);

		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreatePrdPage prdPage = new CreatePrdPage(driver);
		
		prdPage.enterPrdDetails(prdName);
//------------------------------------------------------------------------------------------
		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(By.linkText("Campaigns")).click();
		home.clickCampLink();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		CampLookUpImg lookUpImg = new CampLookUpImg(driver);
		lookUpImg.clickCampLookUp();
		String CampName = elib.getExcelData("Product",1 , 0);

		System.out.println(CampName);

		//driver.findElement(By.name("campaignname")).sendKeys(CampName);
		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampDetails(CampName);

		//driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		campPage.clickPrdPlusSign();

		wlib.windowSwitching(driver, "Products&action");
		//driver.findElement(By.name("search_text")).sendKeys(prdName);
		//driver.findElement(By.cssSelector("[name=\"search\"]")).click();
		SwitchingWindowPage switching = new SwitchingWindowPage(driver);
		switching.searchPrdNAme(CampName);
		switching.dynamicXpath(driver, prdName);
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='Puma']")).click();
		// Dynamic Xpath
		//driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
		// -------------------------------------------------------------------------------------------------
		wlib.windowSwitching(driver, "Campaigns&action");
		campPage.clickSaveButton();
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();

		//if (actData.equals(CampName)) {
			//System.out.println("Campaign name is created");
		//} else {
			//System.out.println("Campaign name is not created");
		//}

		//String actPrd = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
		//if (actPrd.equals(prdName)) {
			//System.out.println("product name is created");
		//} else {
			//System.out.println("product name is not created");
		//}
		CampValidation validate = new CampValidation(driver);
		validate.validateCamp(driver, CampName);
		validate.validatePrd(driver, prdName);
//pull it
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		//home.logOut(driver);
	}
}
