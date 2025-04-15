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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utilities.Excel_utility;
import generic_utilities.File_utility;
import generic_utilities.Java_utility;
import generic_utilities.Webdriver_utility;
import object_repo.CampValidation;
import object_repo.CreatePrdPage;
import object_repo.HomePage;
import object_repo.LoginPage;
import object_repo.PrdLookUpImg;

public class Createproduct {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		Excel_utility elib = new Excel_utility();
		Java_utility jlib = new Java_utility();
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
   // driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    //driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    //driver.findElement(By.id("submitButton")).click();
    LoginPage login=  new LoginPage(driver);
    login.loginIntoApp(USERNAME,PASSWORD);
   
    
    //driver.findElement(By.linkText("Products")).click();
    HomePage home = new HomePage(driver);
    home.clickprdLink();
    
   // driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
    PrdLookUpImg lookUp = new PrdLookUpImg(driver);
	lookUp.clickPrdLookUp();
   // FileInputStream fis1=new FileInputStream("./src/test/resources/Testdata.xlsx");
    //Workbook book=WorkbookFactory.create(fis1);
    //Sheet sheet=book.getSheet("Product");
    //Row row=sheet.getRow(0);
    //Cell cell=row.getCell(0);
   int ranNum=jlib.getRandomNum();
    String prdName=elib.getExcelData("Product", 0, 0)+ranNum;
    System.out.println(prdName);
    
    //driver.findElement(By.name("productname")).sendKeys(prdName);
    CreatePrdPage prdPage = new CreatePrdPage(driver);
	prdPage.enterPrdDetails(prdName);

    //driver.findElement(By.xpath("//input[@title='Save[Alt+S]']")).click();
 

	//String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

	//if (actData.contains(prdName)) {
		//System.out.println("Product Name is created");
	//} else {
		//System.out.println("Product Name is not created");
	//}
	CampValidation validate = new CampValidation(driver);
	validate.validatePrd(driver, prdName);

	//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	//driver.findElement(By.linkText("Sign Out")).click();
    home.signOut();
	}

}


