package scripts.mocktest2;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class britannica {

	private static WebDriver driver;
	private static String baseURL;

	@Before
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseURL = "https://www.britannica.com//";
		driver.get(baseURL);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void test1() throws InterruptedException, IOException {

		driver.findElement(By.className("md-form-control search-query")).sendKeys("bit");
		
		List<WebElement> lst = driver.findElement(By.className("ui-autocomplete--list-item")).findElements(By.tagName("li"));

		for(WebElement lst1:lst)
		{
			System.out.println(lst1.getText());
			if(lst1.getText().equals("Bitcoin: The Rise of Virtual Currency "))
			{
				lst1.click();
				break;
			}
		}
	}
	
	

	@After
	public void afterTest() {
		driver.close();

	}

}
