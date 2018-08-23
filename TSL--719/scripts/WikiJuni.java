package scripts;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WikiJuni {

	public static WebDriver driver;
	
	@Before
	public void BeforeTest2()
	{
		File pathToBinary = new File(
				"C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary, firefoxProfile);
		driver.get("https://www.wikipedia.org/");
		
	}
	
	@Test
	public void Test2()
	{
		driver.findElement(By.id("js-link-box-en")).click();
		driver.findElement(By.name("search")).sendKeys("Selenium software");
	    driver.findElement(By.id("searchButton")).click();
	    driver.findElement(By.linkText("Selenium (software)")).click();
	    try
	    {
	    	assertEquals(driver.getTitle(), "Selenium (software) - Wikipedia");
	    	assertEquals(driver.findElement(By.id("firstHeading")).getText(),"Selenium (software)");
	    }catch(Exception e)
	    {
	       
	    }
	    
	}
	@After
	public void AfterTest2()
	{
		driver.quit();
	}
	
	
}
