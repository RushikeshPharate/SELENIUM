package scripts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class junit2 {

	public static WebDriver driver;
	private static String baseURL;
	
	@Before
	public void BeforeTest1()
	{
		
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://www.google.co.in/";
		driver.get(baseURL);
	}
	
	@Test
	public void Test1()
	{
		driver.findElement(By.id("lst-ib")).sendKeys("selenium WebDriver");
		driver.findElement(By.name("btnK")).click();
	}
	
	@After
public void AfterTest1(){
		driver.quit();
		
	}
	
	
	
}
