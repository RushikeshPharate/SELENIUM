package scripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class popups {

	public static void main(String[] args) throws InterruptedException {

		/*System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		*/
		
		File pathToBinary = new File("C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		driver.manage().window().maximize();
		
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.xpath("//*[@id='result']")).getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//*[@id='result']")).getText());	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//*[@id='result']")).getText());
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().sendKeys("selenium");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//*[@id='result']")).getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//*[@id='result']")).getText());
		Thread.sleep(1000);
		
		
		
		
	}

}
