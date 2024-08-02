package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Drivers.PageDriver;
import Pages.LoginPage;
import Utilities.CommonMethods;
import Utilities.ExtentFactory;

public class LoginPageTest extends CommonMethods {
	ExtentReports report;
	ExtentTest parrentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void openUrl() {
		driver.manage().window().maximize();
		PageDriver.getCurrentDriver().get(url);
		report= ExtentFactory.getReport();
		parrentTest=report.createTest("<p style=\"color:#FF6000;font-size:13px\"><b>Login Page</b></P>").assignAuthor("SQ Team").assignDevice("Laptop");
	}
	@Test(priority = 0)
	public void loginTest() throws InterruptedException, IOException {
		childTest=parrentTest.createNode("<p style=\"color:#3E96E7;font-size:13px\"><b>New User Login</b></p>");
		LoginPage loge=new LoginPage(childTest);
		loge.login();
		timeOut();
		loge.logOut();
		timeOut();
	}

	@AfterClass
	public void report() {
		report.flush();
	}

}
