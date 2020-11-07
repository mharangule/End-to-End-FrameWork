package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	public WebDriver driver;
	private By email = By.id("user_email");
	private By sendMeInstruction = By.cssSelector("input[type='submit']");

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getSendMeInstruction() {
		return driver.findElement(sendMeInstruction);
	}
}
