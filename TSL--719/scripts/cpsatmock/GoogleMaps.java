package scripts.cpsatmock;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMaps {

	public static WebDriver driver;
	private static String baseURL;

	@Before
	public void BeforeTest1() {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://www.google.com/maps/";
		driver.get(baseURL);
	}

	@Test
	public void Test1() throws IOException, InterruptedException {

		driver.findElement(By.xpath("//*[@id='searchboxinput']")).sendKeys(
				"Mandavgon Pharata");
		driver.findElement(By.xpath("//*[@id='searchbox-searchbutton']"))
				.click();
		/*
		 * String str = driver .findElement(
		 * By.xpath("//*[@id='pane']/div/div[1]/div/div/div[1]/div[3]/div[1]"))
		 * .getText(); System.out.println(str);
		 */

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils
				.copyFile(
						scrFile,
						new File(
								"D:\\workspace-selenium_maven_jenkins\\TSL-719\\test\\resources\\screenshots\\screenshot.png"));
		// driver.switchTo().frame(driver.findElement(By.className("//*[@id='pane']/div/div[1]/div/div")));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement serachbox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//*[@id='pane']/div/div[1]/div/div/div[1]/button[2]/div/div")));
		driver.findElement(
				By.xpath("//*[@id='pane']/div/div[1]/div/div/div[1]/button[2]/div/div"))
				.click();
		driver.findElement(By.xpath("//*[@id='sb_ifc51']/input")).sendKeys(
				"LTI,Mahape");
		driver.findElement(
				By.xpath("//*[@id='omnibox-directions']/div/div[2]/div/div/div[1]/div[1]/button/div[1]"))
				.click();

	}

	@After
	public void AfterTest1() {
		// driver.quit();

	}

}
