package scripts;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class jquery {

	public static void main(String[] args) throws IOException,
			InterruptedException {

		File pathToBinary = new File(
				"C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/");

		driver.findElement(By.xpath("//*[@id='sidebar']/aside[2]/ul/li[2]/a"))
				.click();
		/* driver.findElement(By.className("demo-frame")); */

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		driver.findElement(By.id("tags")).sendKeys("j");
		Thread.sleep(2000);
		
		List<WebElement> lst = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		
		for(WebElement lst1:lst)
		{
			System.out.println(lst1.getText());
			if(lst1.getText().equals("Java"))
			{
				lst1.click();
				break;
			}
		}
	
		/*
		 * List<WebElement> print =
		 * driver.findElements(By.xpath("//*[@id='tags']"));
		 * System.out.println(print.size()); for ( WebElement we: print) {
		 * System.out.println(we.getText()); }
		 */

		/*List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));

		for (int i = 0; i < allOptions.size(); i++) {
			String option = allOptions.get(i).getText();
			System.out.println(option);
		}

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,new File("D:\\workspace-selenium_maven_jenkins\\TSL-719\\test\\resources\\screenshots\\Day3Exercise3\\screenshot.png"));
		*/
		 
		
	}
}
