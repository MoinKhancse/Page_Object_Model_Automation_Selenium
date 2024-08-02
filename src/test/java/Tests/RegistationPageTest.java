package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Drivers.PageDriver;
import Pages.RegistationPage;
import Utilities.CommonMethods;
import Utilities.ExtentFactory;

public class RegistationPageTest extends CommonMethods {
	ExtentReports report;
	ExtentTest parrentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void openUrl() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		timeOut();
		report=ExtentFactory.getReport();
		parrentTest=report.createTest("<p style=\"color:#FF6000;font-size:13px\"><b>Create Register</b></p>").assignAuthor("Moin Khan").assignDevice("Laptop");
	}
	@Test(priority = 1)
	public void callRegitation() throws InterruptedException, IOException {
		childTest=parrentTest.createNode("<p style=\"color:#3E96E7;font-size:13px\"><b>New User Register</b></p>");
		RegistationPage regista= new RegistationPage(childTest);
		regista.registation();
		timeOut();		
	}
	@AfterClass
	public void report() {
		report.flush();
	}

}
