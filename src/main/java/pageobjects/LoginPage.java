package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement clickLogin;
	
	public WebElement emailField() {
		return emailField;
	}
	
	public WebElement passwordField() {
		return passwordField;
	}
	
	public WebElement clickLogin() {
		return clickLogin;
	}
	
}
