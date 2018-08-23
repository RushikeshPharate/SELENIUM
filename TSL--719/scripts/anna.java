package scripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class anna {

	public static void main(String[] args) throws InterruptedException, IOException {

		File pathToBinary = new File("C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		driver.manage().window().maximize();
		
		driver.get("https://www.annauniv.edu/");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td[5]/div/a")).click();
		
		Actions action = new Actions(driver);
		WebElement we =driver.findElement(By.cssSelector("#link3 > strong"));
		
		action.moveToElement(we).build().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		we = driver.findElement(By.id("menuItemHilite33"));
		action.moveToElement(we).build().perform();
		Thread.sleep(2000);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:\\workspace-selenium_maven_jenkins\\TSL-719\\test\\resources\\screenshots\\Day3Exercise1\\screenshot.png"));
		
		
	}

}
