package generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import object_repo.HomePage;
import object_repo.LoginPage;

public class BaseClass {
 public WebDriver driver;
 public static WebDriver sdriver;
 @BeforeSuite(groups= {"smokeTest","regressionTest","sanityTest"})
 public void beforeSuite() {
	 System.out.println("database connection");
 }
 @BeforeTest(groups= {"smokeTest","regressionTest","sanityTest"})
 public void beforeTest() {
	 System.out.println("parallel execution");
 }
// @Parameters("BROWSER")
 @BeforeClass(groups= {"smokeTest","regressionTest","sanityTest"})
 public void beforeClass()throws Throwable{
	File_utility flib=new File_utility();
		String BROWSER=flib.getKeyAndValuePair("browser");
		System.out.println("launching browserS");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
 }
// @Parameters({"URL","USERNAME","PASSWORD"})
 @BeforeMethod(groups= {"smokeTest","regressionTest","sanityTest"})
 public void beforeMethod() throws Throwable {
	 Webdriver_utility wlib = new Webdriver_utility();

		File_utility flib = new File_utility();
		
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");
		    
		  
		    wlib.maximizeWindow(driver);
		    wlib.waitElementsToLoad(driver);
		    driver.get(URL);
		  
		LoginPage login=  new LoginPage(driver);
		   login.loginIntoApp(USERNAME,PASSWORD);
	
	 System.out.println("log into application");
 }
 @AfterMethod(groups= {"smokeTest","regressionTest","sanityTest"})
public void afterMethod() {
	HomePage home = new HomePage(driver);
	home.signOut();
	
	 System.out.println("logout from application");
 }
 @AfterClass(groups= {"smokeTest","regressionTest","sanityTest"})
 public void afterClass() {
	 System.out.println("close the browser");
 }
@AfterTest(groups= {"smokeTest","regressionTest","sanityTest"})
public void afterTest() {
	driver.quit();
	 System.out.println("close parallel execution");
}
@AfterSuite(groups= {"smokeTest","regressionTest","sanityTest"})
public void AfterSuite() {
	System.out.println("close the database");
}

 
}
