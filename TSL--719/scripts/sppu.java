package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class sppu {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.unipune.ac.in/");
		//driver.findElement(By.xpath("//*[@id='stUI192_txt']"));
		
		Actions action = new Actions(driver);
		WebElement we =driver.findElement(By.xpath("//*[@id='stUI192_txt']"));
		action.moveToElement(we).build().perform();
		Thread.sleep(2000);
		we = driver.findElement(By.id("stUI196_cnt"));
		action.moveToElement(we).build().perform();
		we.click();
		Thread.sleep(2000);
		
		
		
	}

}
