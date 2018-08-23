package scripts;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class ata {

	public static void main(String[] args) {
		
		File pathToBinary = new File("C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		
		/*driver.get("https://ata123456789123456789.appspot.com/");
		driver.findElement(By.id("ID_nameField1")).sendKeys("5");
		driver.findElement(By.id("ID_nameField2")).sendKeys("2");
		driver.findElement(By.id("gwt-uid-2")).click();
		driver.findElement(By.id("ID_calculator")).click();
		System.out.println("result : "+driver.findElement(By.id("ID_nameField3")).getAttribute("value"));
		
		
		*/
		
		driver.get("https://ata123456789123456789.appspot.com/");
		driver.findElement(By.id("ID_nameField1")).sendKeys("5");
		driver.findElement(By.id("ID_nameField2")).sendKeys("2");
		
		List<WebElement> list=driver.findElement(By.xpath("//*[@id='calModeRbContainer1']")).findElements(By.tagName("span"));
		
		for(WebElement l:list){
			
			l.findElement(By.tagName("input")).click();
			driver.findElement(By.id("ID_calculator")).click();
			

			System.out.println("result : "+driver.findElement(By.id("ID_nameField3")).getAttribute("value"));
			
		}
		
		
		
		

	}

}
