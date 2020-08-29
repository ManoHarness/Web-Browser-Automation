package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports {
	public static ExtentReports extent;
	
	public static ExtentReports getextentreport()
	{
		String path = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("selenium test report");
		reporter.config().setDocumentTitle("test results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Manohar");
		
		return extent;	
	}

}
