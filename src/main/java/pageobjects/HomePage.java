package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText="Login")
	private WebElement loginButton;
	
	@FindBy(linkText="Register")
	private WebElement registerButton;
	
	public WebElement myAccountDropdown() {
		return myAccountDropdown;
	}
	
	public WebElement loginButton() {
		return loginButton;
	}
	
	public WebElement registerButton() {
		return registerButton;
	}
}
