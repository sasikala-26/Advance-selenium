package product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {
@Test(dataProvider="readContactNames")
public void createContact(String firstName,String lastName) throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8888");
	driver.manage().window().maximize();
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.cssSelector("[alt=\"Create Contact...\"]")).click();
	driver.findElement(By.name("firstname")).sendKeys(firstName);
	driver.findElement(By.name("lastname")).sendKeys(lastName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
}
@DataProvider
public Object[][]readContactNames(){
	Object[][]objArr=new Object[2][2];
	objArr[0][0]="shoba";
	objArr[0][1]="rani";
	objArr[1][0]="sasi";
	objArr[1][1]="kala";
	
	return objArr;
	
}
}
