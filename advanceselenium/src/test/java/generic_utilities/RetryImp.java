package generic_utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImp implements IRetryAnalyzer{
int count=0;
int retryLimit=3;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<retryLimit) {
			count++;
		return true;
		}
		return false;
	}

}
