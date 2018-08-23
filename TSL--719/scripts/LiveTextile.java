package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LiveTextile {

	public static void main(String[] args) {
		
		int i=0;
		int a=0;
	
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://205.147.102.59:9001/");
		
		driver.findElement(By.xpath("/html/body/section/div[2]/div/div[2]/div/div/div/div[9]/a/h6")).click();
		List<WebElement> lst = driver.findElements(By.className("product_category"));
		for(WebElement lst1:lst)
		{
			if(lst1.getText().equals("FILAMENT-FLAT YARN") || lst1.getText().equals("FIBRE-SYNTHETIC BLENDED") || lst1.getText().equals("FILAMENT-TEXTURE YARN") || lst1.getText().equals("SPUN YARN-VISCOSE") || lst1.getText().equals("FILAMENT-MONO FILAMENT") || lst1.getText().equals("SPUN YARN-COTTON") || lst1.getText().equals("FIBRE-POLYESTER") || lst1.getText().equals("FIBRE-VISCOSE")|| lst1.getText().equals("SPUN YARN-ACRYLIC"))
			{
				a++;
			}
			System.out.println(lst1.getText());
			i++;
		}
		System.out.println(i);
		System.out.println(a);
		if(a!=i)
		{
			System.out.println("Test Failed");
			
		}

	}

}
