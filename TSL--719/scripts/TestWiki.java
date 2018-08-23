package scripts;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TestWiki {

	public static void main(String[] args) {
		
		File pathToBinary = new File("C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
/*		driver.get("https://www.wikipedia.org");
		driver.findElement(By.id("js-link-box-en")).click();
		driver.findElement(By.name("search")).sendKeys("Selenium Software");
		driver.findElement(By.name("go")).click();
		driver.findElement(By.linkText("Selenium (software)")).click();
		String title = driver.getTitle();
		System.out.println("Title: " +title);
		String str2=driver.findElement(By.id("firstHeading")).getText();
		System.out.println("Heading: " +str2);
		*/
		driver.get("https://www.agiletestingalliance.org/");

		List<WebElement> allElements1 = driver
			    .findElement(By.xpath("//div[@class='soc-icons']"))
			    .findElements(By.tagName("a"));
		
		for (WebElement we:allElements1) {
			System.out.println(we.getAttribute("href"));
		}
		
		
	}

}
