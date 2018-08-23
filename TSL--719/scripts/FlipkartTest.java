package scripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class FlipkartTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		// driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.flipkart.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[2]/div/div/button")).click();
		driver.findElement(By.xpath("//input[@name='q']")).clear();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("samsung");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		driver.findElement(
				By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/div[3]"))
				.click();
		System.out
				.println(driver
						.findElement(
								By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/div[3]"))
						.getText());

		String price1;
		String FinalPrice1;
		int FinalPr1;
		String price2;
		String FinalPrice2;
		int FinalPr2;

		for (int i = 2; i <= 4; i++) {
			int j = i + 1;

			if (isElementPresent(By
					.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div["
							+ i
							+ "]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]"))) {
				price1 = driver
						.findElement(
								By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div["
										+ i
										+ "]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]"))
						.getText();
				FinalPrice1 = price1.substring(1);
				System.out.println(FinalPrice1);
				FinalPr1 = Integer.parseInt(FinalPrice1);
				System.out.println("First Price in Int" + FinalPr1);
			} else {
				price1 = driver
						.findElement(
								By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div["+i+"]/div/div/div/a/div[2]/div[2]/div/div/div[1]"))
						.getText();
				FinalPrice1 = price1.substring(1);
				System.out.println(FinalPrice1);
				FinalPr1 = Integer.parseInt(FinalPrice1);
				System.out.println("First Price in Int" + FinalPr1);
			}

			if (isElementPresent(By
					.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div["
							+ j
							+ "]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]"))) {
				price2 = driver
						.findElement(
								By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div["
										+ j
										+ "]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]"))
						.getText();
				FinalPrice2 = price2.substring(1);
				System.out.println(FinalPrice2);
				FinalPr2 = Integer.parseInt(FinalPrice2);
				System.out.println("Second Price in Int" + FinalPr2);
			} else {
				price2 = driver
						.findElement(
								By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div["+j+"]/div/div/div/a/div[2]/div[2]/div/div/div[1]"))
						.getText();
				FinalPrice2 = price2.substring(1);
				System.out.println(FinalPrice2);
				FinalPr2 = Integer.parseInt(FinalPrice2);
				System.out.println("Second Price in Int" + FinalPr2);
			}
			if (FinalPr2 >= FinalPr1) {
				System.out.println("Price sorting is fine");
			} else {
				System.out.println("Price sorting not working fine");
			}

		}

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	
	
	//*[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]
	//*[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/div/div/div/a/div[2]/div[2]/div[1]/div/div
	//*[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[4]/div/div/div/a/div[2]/div[2]/div[1]/div/div[1]
	//*[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[5]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]


}