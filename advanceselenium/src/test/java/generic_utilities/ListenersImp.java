package generic_utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImp implements ITestListener{
//Listener:Listener is a feature available in TestNg which is used to capture 
	//run time events during the execution and perform appropriate action based on event type
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot takeScreenShot = (TakesScreenshot)BaseClass.sdriver;
		File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dst=new File("./FailedScripts.png");
		try {
			FileUtils.copyFile(src, dst);		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
