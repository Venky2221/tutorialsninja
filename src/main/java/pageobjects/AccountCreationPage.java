package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {
	WebDriver driver;
	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Success")
	private WebElement successButton;
	
	public WebElement successButton() {
		return successButton;
	}
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement continueButton;
	
	public WebElement continueButton() {
		return continueButton;
	}
}
