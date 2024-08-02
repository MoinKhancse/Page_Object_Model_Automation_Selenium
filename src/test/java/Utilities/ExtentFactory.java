package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentFactory {
	public static final ExtentReports extentReports = new ExtentReports();
	
	public synchronized static  ExtentReports getReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reporters/Report.html");
		reporter.config().setReportName("Automation Selenium");
		extentReports.attachReporter(reporter);
		return extentReports;
		
	}

}
