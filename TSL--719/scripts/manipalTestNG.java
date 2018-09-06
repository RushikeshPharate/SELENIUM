package scripts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class manipalTestNG {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://manipal.edu/mu.html");
		Thread.sleep(4000);
	}

	@Test
	public void f() throws InterruptedException, IOException {

		Actions action = new Actions(driver);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		action.moveToElement(
				driver.findElement(By
						.xpath("//*[@id='primary-sticky']/div/ul/li[2]/a")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(
				driver.findElement(By
						.xpath("//*[@id='fat-menu']/div/ul/li[3]/a"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(
				driver.findElement(By
						.xpath("//*[@id='fat-menu']/div/div/ul[1]/li[7]/a[1]/span")))
				.build().perform();

		Thread.sleep(1000);
		action.moveToElement(
				driver.findElement(By
						.xpath("//*[@id='fat-menu']/div/div/ul[2]/li[1]/ul[1]/li[3]/a/span")))
				.click().build().perform();

		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		List<WebElement> alist = new ArrayList<WebElement>();
		alist.addAll(driver.findElements(By.xpath("//*[@id='quick-facts']")));

		int j = 1;
		String str = "";
		for (WebElement i : alist) {
			str = i.getText();
			System.out.println(str);
		}
		int i = Integer.parseInt(driver.findElement(
				By.xpath("//*[@id='quick-facts']/div[2]/div[2]/div/div[1]"))
				.getText())
				+ Integer
						.parseInt(driver
								.findElement(
										By.xpath("//*[@id='quick-facts']/div[2]/div[5]/div/div[1]"))
								.getText());

		System.out.println(i);

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(scrFile, new File("D:\\Screenshot\\Manipal.png"));

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

}