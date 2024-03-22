package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {

	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class )
	public void analyserPractice()
	{
		Assert.fail();
		System.out.println("Hi");
	}


}
