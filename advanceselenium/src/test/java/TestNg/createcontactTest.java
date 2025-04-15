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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Excel_utility;
import generic_utilities.File_utility;
import generic_utilities.Java_utility;
import generic_utilities.Webdriver_utility;
import object_repo.ContactLookUpImg;
import object_repo.ContactValidationPage;
import object_repo.CreateContactPage;
import object_repo.HomePage;
import object_repo.LoginPage;

public class createcontactTest extends BaseClass {
	
@Test(groups="regerssionTest")
	

		public  void  createcontactTest() throws Throwable {
			
			
		    HomePage home = new HomePage(driver);
		    home.clickconLink();
		   
			
	ContactLookUpImg lookup = new ContactLookUpImg(driver);
	lookup.clickContactLookUp();
	CreateContactPage contactPage = new CreateContactPage(driver);
	contactPage.selectDropDOwnVAlue(driver);
			
			Excel_utility elib=new Excel_utility();
			String FirstName=elib.getExcelData("Contact", 0, 0);
			
			
			String LastName=elib.getExcelData("Contact", 1, 0);

			
	contactPage.enterContactDetails(FirstName,LastName);
			
	contactPage.clickSaveButton();
			
	ContactValidationPage validate = new ContactValidationPage(driver);
String actFirstname = validate.validateContactFirstNAme(driver,FirstName);

String actLastname=validate.validateContactLastNAme(driver,LastName);
Assert.assertEquals(actFirstname,FirstName);
Assert.assertEquals(actLastname,LastName);
System.out.println("assert pass");

		
		}

	}
	 



		




