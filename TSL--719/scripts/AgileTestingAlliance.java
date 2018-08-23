package scripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class AgileTestingAlliance {
	
	public static void main(String[] args) throws InterruptedException {
		
		File pathToBinary = new File("C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		
		driver.get("https://www.google.co.in/");
		
		/*driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
		driver.findElement(By.id("lst-ib")).clear();
		
		driver.findElement(By.id("lst-ib")).sendKeys("RUSHIKESH");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.id("lst-ib")).sendKeys("H");
		driver.findElement(By.name("btnK")).click();
		*/
		
		WebElement m=driver.findElement(By.id("lst-ib")); 
		m.sendKeys("Selenium");
		Thread.sleep(3000);
		m.clear();
		m.sendKeys("RUSHIKESH PHARATE");
		Thread.sleep(3000);
		m.sendKeys(Keys.BACK_SPACE);
		m.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		m.sendKeys("te");
		m.sendKeys(Keys.ENTER);
		
		m.sendKeys("te");
		m.sendKeys(Keys.ENTER);


		
	}

}
