package tests;

import java.io.IOException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.AccountCreationPage;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterAccountPage;
import resources.Base;

public class EndtoEnd extends Base{
	WebDriver driver;
	String generatedstring = RandomStringUtils.randomAlphabetic(8);
	String email = generatedstring + "@gmail.com";
	String password = generatedstring+"@123";
	Logger log;
	
	@BeforeTest
	public void initializeBrowser() throws IOException, InterruptedException {
		
		log = LogManager.getLogger(EndtoEnd.class.getName());
		
		driver = initiliazeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("url is entered");
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		log.debug("Browser closed");
	}
	
	@Test(priority=1)
	public void Register() throws InterruptedException {
		
		
		HomePage hp = new HomePage(driver);
		hp.myAccountDropdown().click();
		log.debug("account dropdown clicked");
		hp.registerButton().click();
		log.debug("registerbutton clicked");
		Thread.sleep(5000);
		
		RegisterAccountPage rap = new RegisterAccountPage(driver);
		rap.firstName().sendKeys("venkat");
		log.debug("first name entered");
		rap.lastName().sendKeys("santhosh");
		log.debug("last name entered");
		rap.newEmail().sendKeys(email);
		log.debug("email entered");
		rap.newPassword().sendKeys(password);
		log.debug("password entered");
		rap.newTelephone().sendKeys("1234567890");
		log.debug("telephone entered");
		rap.confirmPassword().sendKeys(password);
		log.debug("confirm password entered");
		rap.privacyCheckbox().click();
		log.debug("clicked on privacy checkbox");
		rap.submitButton().click();
		log.debug("clciked on submit button");
		Thread.sleep(5000);
		
		AccountCreationPage acp = new AccountCreationPage(driver);
		Assert.assertTrue(acp.successButton().isDisplayed());
		log.info("verification done for avaiability of successbutton");
		acp.continueButton().click();
		log.debug("clicked on continue button");
		Thread.sleep(5000);
		
		AccountPage ap = new AccountPage(driver);
		ap.LogoutButton().click();
		log.debug("clicked on logout button");
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void Login() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.myAccountDropdown().click();
		log.debug("clicked on account dropdown");
		hp.loginButton().click();
		log.debug("clicked on login button");
		Thread.sleep(5000);
		
		LoginPage lp = new LoginPage(driver);
		lp.emailField().sendKeys(email);
		log.debug("email entered");
		lp.passwordField().sendKeys(password);
		log.debug("password entered");
		lp.clickLogin().click();
		log.debug("clciked on login");
		Thread.sleep(5000);
		
		AccountPage ap = new AccountPage(driver);
		String expectedResult = "Success";
		String actualResult = null;
		try {
			if(ap.LogoutButton().isDisplayed())
				actualResult = "Success";
			log.info("logged in successfully");
		
		}catch(Exception e) {
			actualResult = "Failure";
			log.error("failed to login");
		}
		Assert.assertEquals(actualResult, expectedResult);
		log.info("verification done for avaiability of logout button");
	}
	
}
