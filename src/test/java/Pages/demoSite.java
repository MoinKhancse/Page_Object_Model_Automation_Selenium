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

public class demoSite extends CommonMethods {
	ExtentTest test;
	
	public demoSite(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test=test;
	}
	
	@FindBys({
		@FindBy(xpath="//a[normalize-space()='Demo Site']")
	})
	WebElement demoSite;
	
	@FindBys({
		@FindBy(xpath="//input[@placeholder='First Name']")
	})
	WebElement firstName;
	
	@FindBys({
		@FindBy(xpath="//input[@placeholder='Last Name']")
	})
	WebElement lastName;
	
	@FindBys({
		@FindBy(xpath="//textarea[@class='form-control ng-pristine ng-untouched ng-valid']")
	})
	WebElement address;
	
	@FindBys({
		@FindBy(xpath="//input[@type='email']")
	})
	WebElement email;
	
	@FindBys({
		@FindBy(xpath="//input[@type='tel']")
	})
	WebElement tel;
	
	@FindBys({
		@FindBy(xpath="//label[normalize-space()='Male']")
	})
	WebElement gender;
	
	@FindBys({
		@FindBy(xpath="//input[@id='checkbox1']")
	})
	WebElement hobby;
	
	@FindBys({
		@FindBy(xpath="//div[@id='msdd']")
	})
	WebElement languages;
	
	@FindBys({
		@FindBy(xpath="//a[normalize-space()='English']")
	})
	WebElement english;
	
	@FindBys({
		@FindBy(xpath="//select[@id='Skills']")
	})
	WebElement skills;
	
	@FindBys({
		@FindBy(xpath="//option[@value='Python']")
	})
	WebElement python;
	
	@FindBys({
		@FindBy(xpath="//select[@id='countries']")
	})
	WebElement countries;
	
	@FindBys({
		@FindBy(xpath="//input[@id='firstpassword']")
	})
	WebElement password;
	
	@FindBys({
		@FindBy(xpath="//input[@id='secondpassword']")
	})
	WebElement conpassword;
	
	@FindBys({
		@FindBy(xpath="//button[@id='submitbtn']")
	})
	WebElement submit;
	
	public void passCass(String message) {
		test.pass("<p style=\"color:#85BC63;font-size:13px\"><b>"+message+"</b></p>");
	}
	@SuppressWarnings("unused")
	public void passCassWithSC(String message,String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63;font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath=GetScreenShot.capture(PageDriver.getCurrentDriver(),""+scName+"");
		String dest=System.getProperty("user.dir")+"\\Screen Shot\\"+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	@SuppressWarnings("unused")
	public void failCass(String message,String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353;font-size:13px\"><b>"+message+"</b></p>");
		Throwable t=new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath=GetScreenShot.capture(PageDriver.getCurrentDriver(),""+scName+"");
		String dest=System.getProperty("user.dir")+"\\Screen Shot\\"+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void demoSiteRegister() throws InterruptedException, IOException {
		demoSite.click();
		timeOut();
		try {
			if(firstName.isDisplayed()) {
				test.info("Please Enter Fast Name");
				firstName.sendKeys("Moin");
				passCass("You have successfully fast name");
				timeOut();
				try {
					if(lastName.isDisplayed()) {
						test.info("Please Enter Fast Name");
						lastName.sendKeys("khan");
						passCass("You have successfully last name");
						timeOut();
						try {
							if(address.isDisplayed()) {
								test.info("Please Enter Address");
								address.sendKeys("Gulshan 01,Dhaka-1212");
								passCass("You have successfully address");
								timeOut();
								try {
									if(email.isDisplayed()) {
										test.info("Please Enter email");
										email.sendKeys("moinkhan4363@gmail.com");
										passCass("You have successfully email");
										timeOut();
										try {
											if(tel.isDisplayed()) {
												test.info("Please Enter Mobile Number");
												tel.sendKeys("+88029351759");
												passCass("You have successfully number");
												timeOut();
												try {
													if(gender.isDisplayed()) {
														test.info("Please click gender");
														gender.click();
														passCass("You have successfully click");
														timeOut();
														try {
															if(hobby.isDisplayed()) {
																test.info("Please click gender");
																hobby.click();
																passCass("You have successfully gender");
																timeOut();
																try {
																	if(languages.isDisplayed()) {
																		test.info("Please select language");
																		languages.click();
																		passCass("You have successfully language");
																		timeOut();
																		try {
																			if(english.isDisplayed()) {
																				english.click();
																				passCass("You have successfully english");
																				timeOut(3000);
																				try {
																					if(skills.isDisplayed()) {
																						skills.click();
																						timeOut(3000);
																						try {
																							if(python.isDisplayed()) {
																								python.click();
																								timeOut();
																								countries.click();
																								timeOut();
																								try {
																									if(password.isDisplayed()) {
																										password.sendKeys("01717511288");
																										timeOut();
																										conpassword.sendKeys("01717511288");
																										passCass("You have successfully password");
																										timeOut();
																										try {
																											if(submit.isDisplayed()) {
																												submit.click();
																												passCass("You have successfully click");																	
																											}
																										} catch (Exception e) {
																											// TODO: handle exception
																										}
																									}
																								} catch (Exception e) {
																									// TODO: handle exception
																								}
																								
																							}
																						} catch (Exception e) {
																							// TODO: handle exception
																						}
																					}
																				} catch (Exception e) {
																					// TODO: handle exception
																				}
																			}
																		} catch (Exception e) {
																			// TODO: handle exception
																		}
																	}
																} catch (Exception e) {
																	// TODO: handle exception
																}
															}
														} catch (Exception e) {
															// TODO: handle exception
														}
													}
												} catch (Exception e) {
													// TODO: handle exception
												}
											}
										} catch (Exception e) {
											// TODO: handle exception
										}
									}
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			failCass("Fast Name Not Found", "Fail Fast Name ");
		}
	}

}
