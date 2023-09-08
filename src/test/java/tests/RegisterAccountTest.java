package tests;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountCreationPage;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.RegisterAccountPage;
import resources.Base;

public class RegisterAccountTest extends Base {
	WebDriver driver;
	
	@BeforeMethod
	public void initializeBrowser() throws IOException, InterruptedException {
		driver = initiliazeDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
	}
	
	@Test
	public void registerNewAccount() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.myAccountDropdown().click();
		hp.registerButton().click();
		Thread.sleep(5000);
		
		RegisterAccountPage rap = new RegisterAccountPage(driver);
		rap.firstName().sendKeys("venkat");
		rap.lastName().sendKeys("santhosh");
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		String email = generatedstring + "@gmail.com";
		rap.newEmail().sendKeys(email);
		String password = generatedstring+"@123";
		rap.newPassword().sendKeys(password);
		rap.newTelephone().sendKeys("1234567890");
		rap.confirmPassword().sendKeys(password);
		rap.privacyCheckbox().click();
		rap.submitButton().click();
		Thread.sleep(5000);
		
		AccountCreationPage acp = new AccountCreationPage(driver);
		Assert.assertTrue(acp.successButton().isDisplayed());
		acp.continueButton().click();
		Thread.sleep(5000);
		
		AccountPage ap = new AccountPage(driver);
		ap.LogoutButton().click();
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
