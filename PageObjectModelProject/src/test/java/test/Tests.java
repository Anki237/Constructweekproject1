package test;


import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utility.Driverimported;
import Utility.Drivers;
import objectPages.Accountpage;
import objectPages.Loginpage;
import screenshots.Screenshot;


public class Tests {
	private WebDriver driver;
	private String baseUrl;
	private Loginpage loginpage;
	private Accountpage accountpage;
	private Screenshot screenShot;
	ExtentHtmlReporter htmlrptr;
	ExtentReports extnt;
	ExtentTest test;
	
	



	@BeforeTest
	public void setUp() throws Exception {
		driver = Driverimported.getDriver(Drivers.CHROME);
		loginpage = new Loginpage(driver);
		accountpage = new Accountpage(driver);
		screenShot = new Screenshot(driver);
	
		
		baseUrl = "https://tutorialsninja.com/demo/index.php?route=account/login";
		driver.get(baseUrl);
		 htmlrptr = new ExtentHtmlReporter("extent.html");
	        htmlrptr.config().setDocumentTitle("Test Report");
	        htmlrptr.config().setReportName("Automation Test Results");
	        htmlrptr.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);

	        extnt = new ExtentReports();
	        extnt.attachReporter(htmlrptr);
	        extnt.setSystemInfo("OS", "Windows 11");
	        extnt.setSystemInfo("Tester", "Ankita");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		extnt.flush();
	}
	@Test(priority = 1)
	public void loginPassTest() throws IOException, InterruptedException {
		test= extnt.createTest("Login using Registered email and password");
		loginpage.sendUserEmails("ankitavermasept14@gmail.com");
		test.info("Enter the registerd email");
		loginpage.sendPassword("Harry@24");
		test.info("Enter the registerd password");
		loginpage.clickLoginBtn();
		test.info("Click on login button");
		Thread.sleep(3000);
        screenShot.captureScreenShot("screenshotbeforechangepwd.png");
        test.pass("Screenshot after login is taken");
	}
	@Test(priority = 2,dependsOnMethods = {"loginPassTest"})
	public void changepasswordandlogoutTest() throws IOException, InterruptedException {
		test=extnt.createTest("Changing the password and logout");
		accountpage.goToChangePassword();
		test.info("Click on the password link to get change passwordpage");
        accountpage.changePassword("Hizu@24", "Hizu@24");
        test.info("Enter the new password and confirm the password");
        Thread.sleep(3000);
        screenShot.captureScreenShot("screenshotafterchangepassword2.png");
        test.pass("Screenshot after password change is taken");

        String expectedSuccessMessage = "Success: Your password has been successfully updated.";
        String actualSuccessMessage = accountpage.getSuccessMessage();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
        test.log(Status.INFO, "Password change success message is displayed correctly.");
        accountpage.logout();
        test.info("click on logout");

	}
	@Test(priority = 3,dependsOnMethods = {"changepasswordandlogoutTest"})
	public void reLoginwithChangedPassword() throws IOException, InterruptedException{
		test = extnt.createTest("Re-login with changed password");
		accountpage.login();
		test.info("Relogin");
		loginpage.sendUserEmails("ankitavermasept14@gmail.com");
		test.info("re-enter the registered email");
		loginpage.sendPassword("Hizu@24");
		test.info("enter the changed password");
		loginpage.clickLoginBtn();
		test.info("reclick on loginbtn");
		Thread.sleep(3000);
        screenShot.captureScreenShot("screenshotafterloginchangedpwd.png");
        test.pass("afterlogin screenshot taken");
		accountpage.assertPageTitle("My Account");
		test.log(Status.INFO, "Page title after re-login is correct.");
	}

}
