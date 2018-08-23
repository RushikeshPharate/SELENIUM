package scripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg1 {

	public static WebDriver driver;
	private static String baseURL;
	
	@BeforeTest
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
	
	@AfterTest
    public void AfterTest1(){
		driver.quit();
		
	}
	
	
	
}
