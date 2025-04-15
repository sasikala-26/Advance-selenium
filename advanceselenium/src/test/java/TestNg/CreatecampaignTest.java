package TestNg;


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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Excel_utility;
import generic_utilities.File_utility;
import generic_utilities.Java_utility;
import generic_utilities.Webdriver_utility;
import object_repo.CampLookUpImg;
import object_repo.CampValidation;
import object_repo.ContactLookUpImg;
import object_repo.ContactValidationPage;
import object_repo.CreateCampPage;
import object_repo.CreateContactPage;
import object_repo.HomePage;
import object_repo.LoginPage;
@Listeners(generic_utilities.ExtendReportImp.class)

public class CreatecampaignTest extends BaseClass {
		
@Test(	)
		public void CreatecampaignTest() throws Throwable {
			Excel_utility elib = new Excel_utility();
			
			
		
			    HomePage home = new HomePage(driver);
			    home.clickCampLink();
	//driver.findElement(By.linkText("More")).click();

	//driver.findElement(By.name("Campaigns")).click();
	//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click(); 
			  CampLookUpImg lookUp = new CampLookUpImg(driver);
			  lookUp.clickCampLookUp();
			  
			  Assert.fail("im faling the script");
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
	
	Assert.assertEquals(true, false);
	camp.clickSaveButton();
	//String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();

	//if (actData.equals(camName)){
		//System.out.println("Campaign name is created");
	//} else {
		//System.out.println("Campaign name is not created");
	//}
	CampValidation validate = new CampValidation(driver);
	String actData = validate.validateCamp(driver, camName);
	Assert.assertEquals(actData, camName);
	System.out.println("assert pass");
	
	//validate.validateCamp(driver, camName);
		Thread.sleep(2000);
	//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	//driver.findElement(By.linkText("Sign Out")).click();
	//home.logOut(driver);

	}}


