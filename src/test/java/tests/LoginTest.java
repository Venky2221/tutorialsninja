package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	
	@BeforeMethod
	public void initializeBrowser() throws IOException, InterruptedException {
		driver = initiliazeDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
	}
	
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.myAccountDropdown().click();
		hp.loginButton().click();
		Thread.sleep(5000);
		
		LoginPage lp = new LoginPage(driver);
		lp.emailField().sendKeys(email);
		lp.passwordField().sendKeys(password);
		lp.clickLogin().click();
		Thread.sleep(5000);
		
		AccountPage ap = new AccountPage(driver);
		String actualResult = null;
		try {
			if(ap.LogoutButton().isDisplayed())
				actualResult = "Success";
		
		}catch(Exception e) {
			actualResult = "Failure";
		}
		//Assert.assertEquals(actualResult, expectedResult);
		Assert.assertTrue(false);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getLoginData(){
		Object[][] data = {{"venky2221@gmail.com","Test@123","Success"},{"venky22221@gmail.com","Test@123","Failure"}};
		return data;
	}
}
