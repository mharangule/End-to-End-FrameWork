package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName,String password,String text) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		LoginPage lp=l.getSignIn();
		lp.getEmail().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		System.out.println(text);
		lp.getLoginButton().click();
		log.info("Successfully verified");
		ForgotPasswordPage fp=lp.getForgotPassword();
		fp.getEmail().sendKeys("hjjhhjh@kjhiu");
		fp.getSendMeInstruction().click();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "nonre@user.com";
		data[0][1] = "123456";
		data[0][2] = "Non restricted user";
		data[1][0] = "restrictrd@user.com";
		data[1][1] = "123456";
		data[1][2] = "restricted user";
		return data;
	}
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
