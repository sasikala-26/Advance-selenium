package generic_utilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_utility {

			/**
			 * this method used to maximize the window
			 */
	public void maximizeWindow(WebDriver driver ) {
		driver.manage().window().maximize();
	}
public void waitElementsToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
/**
 * this method is used to switch windows
 */
public void windowSwitching(WebDriver driver,String partial_Title) {
	Set<String> allwins = driver.getWindowHandles();
	Iterator<String> it = allwins.iterator();
	while(it.hasNext()) {
		String win = it.next();
		driver.switchTo().window(win);
		String title = driver.getTitle();
		if(title.contains(partial_Title)) {
			break;
		}
	}
}
/**
 * this method used to handle the dropdown ele
 * @param ele
 * @param value
 */
public void dropDown(WebElement ele,String value)
{
	Select select = new Select(ele);
	select.selectByValue(value);
}
public void mouseHoverToEle(WebDriver driver, WebElement value) {
	// TODO Auto-generated method stub
	Actions act = new Actions(driver);
	act.moveToElement(value).perform();
	
}
public void alertAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}
public static String takeScreenShotEx(WebDriver driver,String screenShotName)throws Throwable{
	TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
	File dest=new File("./Screenshots/"+screenShotName+".png");
	FileUtils.copyFile(src,dest);
	
	return dest.getAbsolutePath();
	
}
}
