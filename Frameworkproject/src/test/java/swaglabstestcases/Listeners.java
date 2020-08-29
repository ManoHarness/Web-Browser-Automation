package swaglabstestcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.Extentreports;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent = Extentreports.getextentreport();
	ThreadLocal<ExtentTest> threadsafe =new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test =extent.createTest(result.getMethod().getMethodName());
		threadsafe.set(test);
	
	}  

	public void onTestSuccess(ITestResult result) {
		threadsafe.get().log(Status.PASS, "test passed");
	}

	public void onTestFailure(ITestResult result) {
		
		threadsafe.get().log(Status.FAIL, result.getThrowable());
		
		WebDriver driver =null;
		
		String MethodName =result.getMethod().getMethodName();
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
	
		try {
			threadsafe.get().addScreenCaptureFromPath(getscreenshot(MethodName, driver), result.getMethod().getMethodName());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	  	
		
	}

}
