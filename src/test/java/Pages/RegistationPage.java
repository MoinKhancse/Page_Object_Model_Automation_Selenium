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

public class RegistationPage extends CommonMethods {
	
	ExtentTest test;
	
	public RegistationPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	@FindBys({
		@FindBy(xpath="//a[normalize-space()='My Account']")
	})
	WebElement myAccount;
	
	@FindBys({
		@FindBy(xpath="//input[@id='reg_email']")
	})
	WebElement email;
	
	@FindBys({
		@FindBy(xpath="//input[@id='reg_password']")
	})
	WebElement pass;
	
	@FindBys({
		@FindBy(xpath="//input[@name='register']")
	})
	WebElement regst;
	
	public void passCass(String message) {
		test.pass("<p style=\" color:#85BC63;font-size:13px\"><b>"+message+"</b></p>");		
	}
	@SuppressWarnings("unused")
	public void passCassWithSC(String message,String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63;font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath=GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest=System.getProperty("user.dir")+"\\Screen Shot\\"+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());	
	}
	@SuppressWarnings("unused")
	public void failCass(String message,String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353;font-size:13px\"><b>"+message+"</b></p>");
		Throwable t= new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath=GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest=System.getProperty("user.dir")+"\\Screen Shot\\"+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		//PageDriver.getCurrentDriver().quit();
	}
	
	public void registation() throws InterruptedException, IOException {
		myAccount.click();
		passCassWithSC("See Registation Form", "Registation Form");
		timeOut();
		try {
			if(email.isDisplayed()) {
				test.info("please enter email");
				email.sendKeys("moinkhan4363@gmail.com");
				passCass("You have successfully email");
				timeOut();
				if(pass.isDisplayed()) {
					test.info("please enter password");
					pass.sendKeys("01717511288");
					passCass("You have successfully password");
					timeOut();
					if(regst.isDisplayed()) {
						test.info("click registation button");
						regst.click();
						failCass("email already use", "Fail");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
