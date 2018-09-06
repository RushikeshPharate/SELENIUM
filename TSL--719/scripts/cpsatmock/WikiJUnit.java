package scripts.cpsatmock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikiJUnit {

	public static WebDriver driver;
	private static String baseURL;
	
	@Before
	public void BeforeTest1()
	{
		
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://www.wikipedia.org/";
		driver.get(baseURL);
	}
	
	@Test
	public void Test1()
	{
		String str = driver.findElement(By.xpath("//*[@id='js-link-box-en']/small/bdi")).getText();
		System.out.println("No. of articles in english: "+str);
		
		driver.findElement(By.xpath("//*[@id='js-link-box-en']/strong")).click();
		driver.findElement(By.xpath("//*[@id='searchInput']")).sendKeys("Anna University");
		driver.findElement(By.xpath("//*[@id='searchButton']")).click();
		String str2 =driver.findElement(By.xpath("//*[@id='mw-content-text']/div/table[2]/tbody/tr[2]/td")).getText();
		System.out.println(str2);
		if(str2.contains("Knowledge"))
			{
			System.out.println("TEST PASSED");
			}
			else
			{
				
				System.out.println("TEST FAILED !!");
			}
		
		
	
	}
	
	@After
public void AfterTest1(){
		driver.quit();
		
	}
	
	
	
}
