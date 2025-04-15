package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utilities.Excel_utility;
import generic_utilities.File_utility;
import generic_utilities.Java_utility;
import generic_utilities.Webdriver_utility;
import object_repo.CampLookUpImg;
import object_repo.CampValidation;
import object_repo.CreateCampPage;
import object_repo.HomePage;
import object_repo.LoginPage;

public class Createcampaign {

	public static void main(String[] args) throws Throwable {
		Excel_utility elib = new Excel_utility();
		
		Webdriver_utility wlib = new Webdriver_utility();

		File_utility flib = new File_utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");
		    
		    WebDriver driver;
		    if(BROWSER.equalsIgnoreCase("chrome")) {
		    	driver=new ChromeDriver();
		    	
		    }
		    else if(BROWSER.equalsIgnoreCase("firefox")) {
		    	driver=new FirefoxDriver();
		    	
		    }
		    else if(BROWSER.equalsIgnoreCase("edge")) {
		    	driver=new EdgeDriver();
		    	
		    }
		    else {
		    	driver=new ChromeDriver();
		    	
		    }
		    wlib.maximizeWindow(driver);
		    wlib.waitElementsToLoad(driver);
		    driver.get(URL);
		    //driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		   // driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		    //driver.findElement(By.id("submitButton")).click();
		    
		  //business logic
		LoginPage login=  new LoginPage(driver);
		    login.loginIntoApp(USERNAME,PASSWORD);
	
		    HomePage home = new HomePage(driver);
		    home.clickCampLink();
//driver.findElement(By.linkText("More")).click();

//driver.findElement(By.name("Campaigns")).click();
//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click(); 
		  CampLookUpImg lookUp = new CampLookUpImg(driver);
		  lookUp.clickCampLookUp();
//FileInputStream fis1=new FileInputStream("./src/test/resources/Testdata.xlsx");
//Workbook book=WorkbookFactory.create(fis1);
//Sheet sheet=book.getSheet("Product");
//Row row=sheet.getRow(1);
//Cell cell=row.getCell(0);
String camName=elib.getExcelData("Product",1,0 );
System.out.println(camName);

//driver.findElement(By.name("campaignname")).sendKeys(camName);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
CreateCampPage camp = new CreateCampPage(driver);
camp.enterCampDetails(camName);
//String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();

//if (actData.equals(camName)){
	//System.out.println("Campaign name is created");
//} else {
	//System.out.println("Campaign name is not created");
//}
CampValidation validate = new CampValidation(driver);
validate.validateCamp(driver, camName);
	Thread.sleep(2000);
//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//driver.findElement(By.linkText("Sign Out")).click();
home.logOut(driver);


	}

}
