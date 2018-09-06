package scripts.mocktest2;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

////////////////////////////JUnit//////////////////////////////

public class imdb {

	private static WebDriver driver;
	private static String baseURL;

	@Before
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseURL = "https://www.imdb.com/";
		driver.get(baseURL);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void test1() throws InterruptedException, IOException {

		driver.findElement(By.id("navbar-query")).sendKeys("Gangs of New York");
		driver.findElement(By.id("navbar-submit-button")).click();
		driver.findElement(
				By.xpath("//*[@id='main']/div/div[2]/table/tbody/tr[1]/td[2]/a"))
				.click();
		String str = driver
				.findElement(
						By.xpath("//*[@id='title-overview-widget']/div[2]/div[2]/div/div[2]/div[2]/div/time"))
				.getText();
		System.out.println(str);

		driver.findElement(By.xpath("//*[@id='quicklinksMainSection']/a[3]"))
				.click();
		String str2 = driver
				.findElement(
						By.xpath("//*[@id='main']/section/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/a"))
				.getText();
		System.out.println(str2);

	}

	@After
	public void afterTest() {
		//driver.close();

	}

}
