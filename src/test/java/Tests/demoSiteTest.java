package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Drivers.PageDriver;
import Pages.demoSite;
import Utilities.CommonMethods;
import Utilities.ExtentFactory;

public class demoSiteTest extends CommonMethods {
	
	ExtentReports report;
	ExtentTest parrentTest;
	ExtentTest childTest;
	
	@BeforeSuite
	public void openUrl() {
		PageDriver.getCurrentDriver().get(url);
		report=ExtentFactory.getReport();
		parrentTest=report.createTest("<p style=\"color:#FF6000;font-size:13px\"><b>Demo Site Registation</b></p>").assignAuthor("Moin Khan").assignDevice("Laptop");		
	}
	@Test(priority = 2)
	public void demoSiteRun() throws InterruptedException, IOException {
		childTest=parrentTest.createNode("<p style=\"color:#FF6000;font-size:13px\"><b>New Registation</b></p>");
		demoSite demo=new demoSite(childTest);
		demo.demoSiteRegister();
		timeOut();	
	}
	@AfterClass
	public void report() {
		report.flush();
	}

}
