package scripts;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		/*
		 * File pathToBinary = new File(
		 * "C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe"
		 * ); FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		 * FirefoxProfile firefoxProfile = new FirefoxProfile(); WebDriver
		 * driver = new FirefoxDriver(ffBinary, firefoxProfile);
		 */
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		driver.findElement(
				By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[2]/form/div/div[1]/div/input"))
				.sendKeys("sony");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button"))
				.click();
		;

		driver.findElement(
				By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[2]/form/div/div[2]/button"))
				.click();
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement serachbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_1xHtJz")));
		
		driver.findElement(
				By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/div[3]"))
				.click();
		/*
		 * String str[] = new String[4]; // int j=0;
		 * 
		 * for (int i = 2; i < 6; i++) {
		 * 
		 * str[i - 2] = new String(); str[i - 2] = driver .findElement(
		 * By.xpath(
		 * "//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[" + i +
		 * "]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]")) .getText();
		 * 
		 * System.out.println(i);
		 * 
		 * // j++; }
		 * 
		 * List<Integer> string = new ArrayList<>();
		 * 
		 * 
		 * 
		 * for (String str1 : str) { System.out.println(str1);
		 * string.add(Integer.parseInt(str1.substring(1)));
		 * 
		 * }
		 * 
		 * int arr[] = new int[string.size()];
		 * 
		 * int arrayi = 0; for (Integer val : string) {
		 * 
		 * System.out.println(val);
		 * 
		 * arr[arrayi] = val.intValue(); arrayi++;
		 * 
		 * }
		 * 
		 * for (int i = 0; i < arr.length; i++) { for (int j = 0; j < arr.length
		 * - 1; j++) { if (arr[j] > arr[j + 1]) { int temp = arr[j]; arr[j] =
		 * arr[j + 1]; arr[j + 1] = temp; } } }
		 * 
		 * arrayi = 0; System.out.println("Check"); for (Integer val : string) {
		 * 
		 * 
		 * 
		 * System.out.println(val);
		 * 
		 * if (arr[arrayi] != val.intValue()) {
		 * 
		 * System.out.println("Not sorted properly");
		 * 
		 * break;
		 * 
		 * }
		 * 
		 * }
		 */

		int result,result1 = 0;
		
		for (int i = 2; i < 6; i++) {
			String str = driver
					.findElement(
							By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[" + i + "]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]")).getText();
			//System.out.println(str);
			
			String splitString = driver
					.findElement(
							By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[" + i + "]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]")).getText();
	
			String	str2 = splitString.split("₹")[1];
			System.out.println(str2);
	
			result = Integer.parseInt(str2);	
						
			if(i==2)
			{
				result1= Integer.parseInt(str2);
		
			}
			else
			{
				
				if(result>=result1)
				{
					System.out.println("TEST PASSED !!");
				}
				else
				{
					System.out.println("TEST FAILED !!");
				}
				
				result1=result;
				
			}
			

	}
		

	
	//*[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]
	//*[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]
	//*[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[4]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]
	
}
}
