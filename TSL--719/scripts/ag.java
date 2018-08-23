package scripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class ag {

	public static void main(String[] args) {

		File pathToBinary = new File("C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		
		driver.get("https://www.agiletestingalliance.org/");
		
		for(int i=1;i<5;i++)
		{
		
			System.out.println(driver.findElement(By.xpath("/html/body/footer/div/a["+i+"]")).getAttribute("href"));
				
		}		
		
		
	}

}
