package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {

	WebDriver driver;
	public RegisterAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstName;
	
	public WebElement firstName() {
		return firstName;
	}
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	public WebElement lastName() {
		return lastName;
	}
	
	@FindBy(id="input-email")
	private WebElement newEmail;
	
	public WebElement newEmail() {
		return newEmail;
	}
	
	@FindBy(id="input-telephone")
	private WebElement newTelephone;
	
	public WebElement newTelephone() {
		return newTelephone;
	}
	
	@FindBy(id="input-password")
	private WebElement newPassword;
	
	public WebElement newPassword() {
		return newPassword;
	}
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	public WebElement confirmPassword() {
		return confirmPassword;
	}
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacyCheckbox;
	
	public WebElement privacyCheckbox() {
		return privacyCheckbox;
	}
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	public WebElement submitButton() {
		return submitButton;
	}
}
