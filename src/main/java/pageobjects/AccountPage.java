package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="list-group-item")
	private WebElement Account;
	
	@FindBy(linkText="Logout")
	private WebElement LogoutButton;
	
	public WebElement Account() {
		return Account;
	}
	
	public WebElement LogoutButton() {
		return LogoutButton;
	}
	
}
