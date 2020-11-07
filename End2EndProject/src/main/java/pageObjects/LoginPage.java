package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	private By email = By.id("user_email");
	private By password = By.id("user_password");
	private By loginButton = By.xpath("//input[contains(@class,'btn-md')]");
	private By forgotPassword = By.cssSelector("a[href*='password']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}

	public ForgotPasswordPage getForgotPassword() {
		driver.findElement(forgotPassword).click();
		ForgotPasswordPage fp=new ForgotPasswordPage(driver);
		return fp;
	}
}
