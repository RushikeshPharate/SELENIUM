package scripts;

import static org.testng.Assert.fail;

import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.*;


//////////////////////////TestNG////////////////////////////////////

public class FlipkartNeeraj {

	private static WebDriver driver;
	private static String baseURL;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		selectChrome();
		selectFirefox();	
		baseURL = "https://www.flipkart.com/";

	}

	@Test
	public void testLowToHigh() {

	}

	@Test
	public void testHighToLow() {

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private String selectXPath() {
		String xpath = null;

		return xpath;
	}

	private boolean isElementPresent(By by) {

		return false;
	}

	private void selectFirefox() {
		File pathToBinary = new File(
				"C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary, firefoxProfile);
	}

	private void selectChrome() {
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	

}
