package scripts.mocktest2;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

////////////////////////////JUnit//////////////////////////////

public class ShoppersStop {

	private static WebDriver driver;
	private static String baseURL;

	@Before
	public void beforeTest() {
		File pathToBinary = new File(
				"C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary, firefoxProfile);
		driver.manage().window().maximize();
		baseURL = "https://www.shoppersstop.com/";
		driver.get(baseURL);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void test1() throws InterruptedException, IOException {

		driver.findElement(
				By.xpath("/html/body/main/nav/div[1]/div/ul/li[7]/a")).click();

		Actions action = new Actions(driver);
		WebElement we = driver
				.findElement(By
						.cssSelector(".container-mobile > div:nth-child(1) > div:nth-child(1) > ul:nth-child(3) > li:nth-child(1) > div:nth-child(1) > div:nth-child(2)"));

		action.moveToElement(we).build().perform();
		Thread.sleep(2000);
		we = driver
				.findElement(By
						.cssSelector(".container-mobile > div:nth-child(1) > div:nth-child(1) > ul:nth-child(3) > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > span:nth-child(2)"));
		action.moveToElement(we).click().build().perform();

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils
				.copyFile(
						scrFile,
						new File(
								"D:\\workspace-selenium_maven_jenkins\\TSL-719\\test\\resources\\screenshots\\shoppersstop.png"));

		String str = driver.getTitle();
		System.out.println(str);

		if (str.equals("Haute Curry | Shoppers Stop")) {
			System.out.println("TITLE IS SAME");

		}

		str = driver.findElement(By.xpath("/html/body/main/footer/div[1]/p"))
				.getText();
		System.out.println(str);

		if (str.equals("Start Something New")) {
			System.out.println("TEXT IS PRESENT");
		}

		System.out
				.println(driver
						.findElement(
								By.xpath("/html/body/main/footer/div[3]/div[1]/div/div/div/div[3]/ul/li[3]/a"))
						.getAttribute("href"));

	}

	@After
	public void afterTest() {
		driver.close();

	}

}
