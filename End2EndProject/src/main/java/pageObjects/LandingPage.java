package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By title= By.xpath("//div[@class='text-center']/h2");
	private By navigationBar=By.xpath("//header/div[2]/div[1]/nav[1]");
	private By header= By.cssSelector("[class*='video-banner'] h3");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getSignIn() {
		driver.findElement(signIn).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavigationBar() {
		return driver.findElement(navigationBar);
	}
	public WebElement getHeader() {
		return driver.findElement(header);
	}

}
