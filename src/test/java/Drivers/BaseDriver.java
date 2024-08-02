package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	protected static String url ="https://practice.automationtesting.in/shop/";
		
	public  WebDriver driver;
	
	@BeforeSuite
	public void setBrowser() {
		String browser_name = "chrome";
		
		if(browser_name.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			driver=new ChromeDriver(option);
		}
		else if (browser_name.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		PageDriver.getInstance().setDriver(driver);
	}

}
