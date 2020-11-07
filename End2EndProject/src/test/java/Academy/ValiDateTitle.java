package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValiDateTitle extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage l;
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.error("Driver is initializes");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}

	@Test
	public void validateAppTitle() {
		l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully tiltle verified");

	}

	@Test
	public void validateHeader() {
		Assert.assertEquals(l.getHeader().getText(),"An Academy to learn Everything about Testing");
		log.info("Header Successfully verified");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		log.info("Browser is closed");
	}
}
