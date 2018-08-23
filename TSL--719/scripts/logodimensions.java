package scripts;

import java.awt.Image;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class logodimensions {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.agiletestingalliance.org/");
		System.out.println("Image height is : " +driver.findElement(By.xpath("/html/body/header/div/div/h1/a/img")).getSize().getHeight());
		System.out.println("Image width is : " + driver.findElement(By.xpath("/html/body/header/div/div/h1/a/img")).getSize().getWidth());
	}

}
