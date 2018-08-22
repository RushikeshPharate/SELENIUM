package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiveTextileLogin {

	public static void main(String[] args) {
		/*
		 * 
		 * File pathToBinary = new File(
		 * "C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe"
		 * ); FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		 * FirefoxProfile firefoxProfile = new FirefoxProfile(); WebDriver
		 * driver = new FirefoxDriver(ffBinary, firefoxProfile);
		 */
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().window().maximize();
		driver.get("http://205.147.102.59:9001/");
		driver.findElement(By.id("show_login")).click();
		driver.findElement(By.id("login_email")).sendKeys(
				"tejal.ughade@gmail.com");
		driver.findElement(By.id("login_password")).sendKeys("tejalughade");
		driver.findElement(By.id("login_submit")).click();
		
		/*WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement serachbox = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("/html/body/header/div/div/div[3]/a/label")));
		
		String cart = driver.findElement(
				By.xpath("/html/body/header/div/div/div[3]/a/label")).getText();
		int finalcart = Integer.parseInt(cart);

		WebDriverWait wait3 = new WebDriverWait(driver, 5);
		WebElement serachbox3 = wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//*[@id='menuwrapper']/ul/li[1]/a")));

		// driver.findElement(By.id("show_login")).click();
		// driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div/div/div/div[95]")).click();
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By
				.xpath("//*[@id='menuwrapper']/ul/li[1]/a"));

		action.moveToElement(we).click().build().perform();

		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		WebElement serachbox1 = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//*[@id='menuwrapper']/ul/li[1]/ul/li[1]/a")));

		driver.findElement(
				By.xpath("//*[@id='menuwrapper']/ul/li[1]/ul/li[1]/a")).click();
		// action.moveToElement(we).build().perform();

		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		WebElement serachbox2 = wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//*[@id='listing_conatiner']/div[2]/a")));

		driver.findElement(By.xpath("//*[@id='listing_conatiner']/div[2]/a"))
				.click();
		driver.findElement(By.id("depoprice")).click();
		driver.findElement(By.id("addtocartid")).click();
		driver.findElement(By.className("cont_btn")).click();
		String cart1 = driver.findElement(By.className("count")).getText();
		int finalcart1 = Integer.parseInt(cart1);
		if (finalcart1 == (finalcart + 1)) {
			System.out.println("product added successfully: test passed");
		}
		
		System.out.println("Number of items added to the cart :"+finalcart1);
		
		*/
	}
	
	
	
	

}
