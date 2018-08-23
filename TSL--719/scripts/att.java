package scripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class att {

	public static void main(String[] args) {
		
		File pathToBinary = new File("C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
		
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//div[@id='hplogo']/a/img")).getAttribute("title");

		
		System.out.println(driver.findElement(By.xpath("//div[@id='hplogo']/a/img")).getAttribute("title"));
		
		
		
	}

}
