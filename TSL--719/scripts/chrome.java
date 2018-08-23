package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class chrome {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.co.in");

		driver.manage().window().maximize();

		driver.get("https://www.google.co.in");
		WebElement webelement = driver.findElement(By.id("lst-ib"));
		webelement.sendKeys("Selenium");
		webelement.clear();
		Thread.sleep(3000);
		webelement.sendKeys("Neeraj");
		Thread.sleep(3000);
		webelement.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		webelement.sendKeys("j");
		Thread.sleep(3000);
		webelement.sendKeys(Keys.ENTER);

	}
}
