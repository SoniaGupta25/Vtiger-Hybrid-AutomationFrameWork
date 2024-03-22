package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener Interface of TestNG
 * Example for abstraction
 * @author Sonia
 */

public class ListenerImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		//ITestListener.super.onTestStart(result);
		String testScriptName = result.getMethod().getMethodName();
          //System.out.println(testScriptName+" ==== test script execution started ====");
		
		//create a test script - recognize each @Test
		test = report.createTest(testScriptName);
	
		
	}

	public void onTestSuccess(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		//System.out.println(testScriptName+" ==== Passed ====");
		
		//Log the success
		test.log(Status.PASS, testScriptName+" == PASS ==");
	}

	public void onTestFailure(ITestResult result) {
		
		//ScreenShot
		//Exception for failure
		
		String testScriptName = result.getMethod().getMethodName();
		//log for failure 
		
		//System.out.println(testScriptName+" ==== Failed ====");
		test.log(Status.FAIL, testScriptName+" == Fail ==");
		
		//Exception for failure
		
		//System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
	
	//Screenshot
		
		WebDriverUtility wu = new WebDriverUtility();
		 JavaUtility ju= new JavaUtility();
		String screenShotName = testScriptName + ju.getSystemDate();
		
			try {
			
			String path = wu.takeScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
			   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}             

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		
		//log for Skip
		//System.out.println(testScriptName+" ==== Skipped ====");
		test.log(Status.SKIP, testScriptName+" == skipped ==");
		
		//Exception for failure
		//System.out.println(result.getThrowable());
		
		test.log(Status.INFO, result.getThrowable());
	}
       
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// start of <suit> - @BeforeSuite
		
		System.out.println("==== Suite Execution Started ====");
		
       //Basic Report configuration //Report-17-10-2023-20-04-20.html //extent report config
 ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setDocumentTitle("Execution Report");
		htmlreport.config().setReportName("Vtiger execution Report");
		
		// report generation
	    report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Sonia");
		
		
	}
    
	public void onFinish(ITestContext context) {
		// end of </suit> - @AfterSuite
		
		System.out.println("==== Suite Execution Finished ====");
		
		//Report generation
		report.flush();
		
		
	}
	  
}                           
//ItestResult is an interface which is going to capture the result of your test annotation - pass,fail or skip .
   //and it is going to store in this variable (result).
           
      
