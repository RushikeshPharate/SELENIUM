package scripts;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class Vodafone {

	public static void main(String[] args) throws InterruptedException {

		File pathToBinary = new File(
				"C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		driver.manage().window().maximize();

		driver.get("https://www.vodafone.in");
		driver.findElement(By.id("ctl00_TM_liLocator")).click();
		driver.findElement(By.name("ctl00$CU$ddlCircle")).click();
		Thread.sleep(1000);

		/*
		 * List<String> getAllOptions(By by) { List<String> options = new
		 * ArrayList<String>(); for (WebElement option : new
		 * Select(driver.findElement(by)).getOptions()) { String txt =
		 * option.getText(); if (option.getAttribute("value") != "")
		 * options.add(option.getText()); } }
		 * 
		 * 
		 * driver.findElement(By.xpath("//*[@id='ctl00_CU_ddlCircle']/option")).
		 * getText();
		 */

		/*
		 * List<WebElement> options =
		 * driver.findElements(By.xpath("//*[@id='ctl00_CU_ddlCircle']/option"
		 * ));
		 * 
		 * 
		 * 
		 * List<String> text = new ArrayList<>(); for(int i=1; i<options.size();
		 * i++) { text.add(options.get(i).getText());
		 * 
		 * }
		 * 
		 * for(String text1:text ) { System.out.println(text1); }
		 */
		Select opt = new Select(driver.findElement(By.xpath("//*[@id='ctl00_CU_ddlCircle']")));

		List<WebElement> names = opt.getOptions();
		for (WebElement text1 : names) {
			System.out.println(text1.getText());
		}

		opt.selectByValue("chennai");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.findElement(By.name("ctl00$CU$ddlCircle")).click();
		Thread.sleep(3000);
		opt = new Select(driver.findElement(By.xpath("//*[@id='ctl00_CU_ddlCircle']")));

		opt.selectByValue("haryana");
		Thread.sleep(3000);
		driver.navigate().back();
		
		driver.findElement(By.name("ctl00$CU$ddlCircle")).click();
		Thread.sleep(3000);
		opt = new Select(driver.findElement(By.xpath("//*[@id='ctl00_CU_ddlCircle']")));
		
		Thread.sleep(3000);
		opt.selectByValue("mumbai");
		Thread.sleep(3000);
		// System.out.println(driver.findElement(By.xpath("//*[@id='ctl00_CU_ddlCircle']/option[@value='Chennai']")));

	}
}
