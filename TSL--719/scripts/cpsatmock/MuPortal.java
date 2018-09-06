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
import org.openqa.selenium.interactions.Actions;

public class MuPortal {

	public static WebDriver driver;
	private static String baseURL;
	
	@Before
	public void BeforeTest1()
	{
		
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "http://mu.ac.in/portal/";
		driver.get(baseURL);
	}
	
	@Test
	public void Test1() throws InterruptedException, IOException
	{
		Actions action = new Actions(driver);
		WebElement we =driver.findElement(By.xpath("//*[@id='menu-item-3694']/a/span/span"));
		
		action.moveToElement(we).build().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		we = driver.findElement(By.id("menu-item-3821"));
		action.moveToElement(we).click().build().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='post-3809']/div/div[1]/div[1]/div/div[1]/div/div[1]/div/ul/li[8]/h6/a")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='node-2']/div[1]/div/div/div/p[2]/span/strong")).getText());
		driver.findElement(By.xpath("//*[@id='main-menu-links']/li[10]/a")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='node-8']/div/div/div/div/p[4]/strong")).getText());
		//String str = driver.findElement(By.xpath("//*[@id='node-8']/div/div/div/div/p[4]/strong/text()[4]")).getText();
		//System.out.println(str);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:\\workspace-selenium_maven_jenkins\\TSL-719\\test\\resources\\screenshots\\screenshot1.png"));
		
	}
	
	@After
public void AfterTest1(){
		driver.quit();
		
	}
	
	
	
}
