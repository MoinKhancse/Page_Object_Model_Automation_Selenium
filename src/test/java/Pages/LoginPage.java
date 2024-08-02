package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Drivers.PageDriver;
import Utilities.CommonMethods;
import Utilities.GetScreenShot;

public class LoginPage extends CommonMethods {
	ExtentTest test;
	
	public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test=test;	
	}
	@FindBys({
		@FindBy(xpath="//a[normalize-space()='My Account']")
	})
	WebElement myAccount;
	
	@FindBys({
		@FindBy(xpath="//input[@id='username']")
	})
	WebElement username;
	
	@FindBys({
		@FindBy(xpath="//input[@id='password']")
	})
	WebElement password;
	
	@FindBys({
		@FindBy(xpath="//input[@name='login']")
	})
	WebElement login;
	
	@FindBys({
		@FindBy(xpath="//a[normalize-space()='Logout']")
	})
	WebElement logOut;
	
	public void passCass(String message) {
		test.pass("<p style=\"color:#85BC63;font-size:13px\"><b>"+message+"</b></p>");
	}
	@SuppressWarnings("unused")
	public void passCassWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63;font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath=GetScreenShot.capture(PageDriver.getCurrentDriver(),""+ scName +"");
		String dest=System.getProperty("user.dir")+"\\Screen Shot\\"+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	@SuppressWarnings("unused")
	public void failCassWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#FF5353;font-size:13px\"><b>"+message+"</b></p>");
		Throwable t= new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath=GetScreenShot.capture(PageDriver.getCurrentDriver(),""+ scName +"");
		String dest=System.getProperty("user.dir")+"\\Screen Shot\\"+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void login() throws InterruptedException, IOException {
		myAccount.click();
		timeOut();
		try {
			if(username.isDisplayed()) {
				test.info("Please Enter Email");
				username.sendKeys("moinkhan4363@gmail.com");
				passCass("You have successfully email");
				timeOut();
				if(password.isDisplayed()) {
					test.info("Please Enter Password");
					password.sendKeys("01717511288");
					passCass("You have successfully password");
					timeOut();
					login.click();
					test.info("Please click login button");
					passCassWithSC("You Have Successfully Login", "Login Page");
				}
			}
		} catch (Exception e) {
			test.info("Login Failed");
			failCassWithSC("You Have Not Successfully Login", "Login");
		}
	}
	public void logOut() {
		try {
			test.info("click logout");
			if(logOut.isDisplayed()) {
				logOut.click();
				passCass("You have successfully logout");
				timeOut();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
