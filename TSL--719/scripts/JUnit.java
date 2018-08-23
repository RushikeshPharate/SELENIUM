package scripts;

import static org.testng.Assert.fail;

import java.io.File;

import org.junit.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

////////////////////////////JUnit//////////////////////////////

public class JUnit {

	private static WebDriver driver;
	private static String baseURL;
	
	@Before
	public void beforeTest() {
		File pathToBinary = new File(
				"C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary, firefoxProfile);
		baseURL = "https://www.google.co.in/";
		driver.get(baseURL);

	}

	@Test
	public void test1() {

		driver.findElement(By.id("lst-ib")).sendKeys("Selenium WebDriver");

		driver.findElement(By.name("btnK")).click();
	}

	@After
	public void afterTest() {
		driver.close();
		// differentiate with driver.quit();

		// driver.close and driver.quit are two different methods for closing
		// the browser session in Selenium WebDriver. Understanding both of them
		// and knowing when to use each method is important in your test
		// execution. Therefore, I have tried to shed some light on both of
		// these methods.
		//
		// driver.close - This method closes the browser window on which the
		// focus is set.
		//
		// driver.quit – This method basically calls driver.dispose a now
		// internal method which in turn closes all of the browser windows and
		// ends the WebDriver session gracefully.It is used to shut down the web
		// driver instance or destroy the web driver instance
		//
		// driver.dispose - As mentioned previously, is an internal method of
		// WebDriver which has been silently dropped according to another answer
		// - Verification needed. This method really doesn't have a use-case in
		// a normal test workflow as either of the previous methods should work
		// for most use cases.
		//
		// Explanation use case: You should use driver.quit whenever you want to
		// end the program. It will close all opened browser windows and
		// terminates the WebDriver session. If you do not use driver.quit at
		// the end of the program, the WebDriver session will not close properly
		// and files would not be cleared from memory. This may result in memory
		// leak errors.
		//
		// The above explanation should explain the difference between
		// driver.close and driver.quit methods in WebDriver. I hope you find it
		// useful.
		//
		// The following website has some good tips on selenium testing :
		// http://www.testingdiaries.com/
	}

}
