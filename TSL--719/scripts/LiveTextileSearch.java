package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LiveTextileSearch {

	public static void main(String[] args) {
		float i=0;
		float a=0;
		
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://205.147.102.59:9001/");
		
		driver.findElement(By.name("search")).sendKeys("cotton");
		driver.findElement(By.id("searchlisting")).click();
		List<WebElement> lst = driver.findElement(By.id("listing_conatiner")).findElements(By.className("product_category"));
		
		for(WebElement lst1 : lst)
		{
			System.out.println(lst1.getText());
			if(lst1.getText().contains("COTTON"))
			{
				a++;
			}
			i++;
		}
	
		System.out.println(((double)a/i)*100);
		
	}
}
