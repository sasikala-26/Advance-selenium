package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import object_repo.CreateOrganizationPage;
import object_repo.HomePage;
import object_repo.LoginPage;
import object_repo.OrgLookUpImg;
import object_repo.OrgValidate;

public class createoeganizations {

	public static void main(String[] args) throws Throwable {
		File_utility flib=new File_utility();
		String BROWSER=flib.getKeyAndValuePair("browser");
		String URL=flib.getKeyAndValuePair("url");
		String USERNAME=flib.getKeyAndValuePair("username");
		String PASSWORD=flib.getKeyAndValuePair("password");
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
		Webdriver_utility wlib=	new Webdriver_utility();
		wlib.waitElementsToLoad(driver);
		driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		LoginPage login=  new LoginPage(driver);
	    login.loginIntoApp(USERNAME,PASSWORD);
		//driver.findElement(By.linkText("Organizations")).click();
	    HomePage home = new HomePage(driver);
	    home.clickorgLink();
		//driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	    OrgLookUpImg lookup = new OrgLookUpImg(driver);
	    lookup.getorgLookUp().click();
		// To avoid Duplicates
	Java_utility jlib=	new Java_utility();
	int ranNum=jlib.getRandomNum();

		// step1:- path connection
		//FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

		// step2:-keeps the workbook/excelfile in read mode
		//Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating expected sheet
		//Sheet sheet = book.getSheet("Organization");

		// step4:- Navigating expected row--->row value starts from 0
		//Row row = sheet.getRow(0);

		// step5:- Navigating expected cell--->cell value starts from 0
		//Cell cell = row.getCell(0);
Excel_utility elib=new Excel_utility();
		String orgName = elib.getExcelData("Organization", 0, 0)+ ranNum;
		//System.out.println(orgName);
		//driver.findElement(By.name("accountname")).sendKeys(orgName);
		// -------------------------------------------------------------------------------------------------------
		// row1 = sheet.getRow(1);
		//Cell cell1 = row1.getCell(0);
		//DataFormatter format = new DataFormatter();
		String phnNum = elib.getExcelDataUsingFormatter("Organization", 1, 0);
		//driver.findElement(By.id("phone")).sendKeys(phnNum);
		// -------------------------------------------------------------------------------------------------------
		//Row row2 = sheet.getRow(2);
		//Cell cell2 = row2.getCell(0);
		//DataFormatter format1 = new DataFormatter();
		String emailId = elib.getExcelDataUsingFormatter("Organization",2,0);
		//driver.findElement(By.id("email1")).sendKeys(emailId);
CreateOrganizationPage org = new CreateOrganizationPage(driver);
org.enterOrgDetails(orgName, phnNum, emailId);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
org.clicksaveButton();
		Thread.sleep(2000);
		//String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	//if(actData.contains(orgName))
	//{
		//System.out.println("Organization name is created");
	//}
	//else
	//{
		//System.out.println("Organization name is not created");
	//}
		OrgValidate validate = new OrgValidate(driver);
		validate.validateOrg(driver, orgName);
		home.signOut();
	//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	//driver.findElement(By.linkText("Sign Out")).click();
	}

}
	


