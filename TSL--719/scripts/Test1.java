package scripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class Test1 {

	public static void main(String[] args) throws IOException {

		File pathToBinary = new File(
				"C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		/*
		 * driver.get("https://www.google.co.in");
		 * driver.findElement(By.id("lst-ib")).sendKeys("Selenium WebDriver");
		 * driver.findElement(By.name("btnK")).click();
		 * 
		 * driver.get("https://www.wikipedia.org/");
		 * driver.findElement(By.id("js-link-box-en")).click();
		 * driver.findElement(By.name("search")).sendKeys("Selenium software");
		 * driver.findElement(By.id("searchButton")).click();
		 * driver.findElement(By.linkText("Selenium (software)")).click();
		 * String title = driver.getTitle(); System.out.println("Title" +
		 * title); String heading =
		 * driver.findElement(By.id("firstHeading")).getText();
		 * System.out.println("Heading" + heading); String pageSource =
		 * driver.getPageSource(); System.out.println("Page Source :- \n" +
		 * pageSource); byte[] strToBytes = pageSource.getBytes();
		 * FileOutputStream outputStream; outputStream = new FileOutputStream(
		 * "C:\\Users\\AM101_PC15\\Desktop\\pagesource.txt");
		 * 
		 * outputStream.write(strToBytes); outputStream.close();
		 * driver.get("https://www.agiletestingalliance.org/");
		 * 
		 * List<WebElement> allElements1 = driver.findElement(
		 * By.xpath("//footer/div[@class='soc-icons']")).findElements(
		 * By.tagName("a"));
		 * 
		 * for (WebElement we : allElements1) {
		 * System.out.println(we.getAttribute("href")); }
		 * 
		 * driver.get("https://www.google.co.in/");
		 * System.out.println(driver.findElement(By.id("lst-ib")).getAttribute(
		 * "title"));
		 * 
		 * driver.get("https://www.google.co.in/");
		 * System.out.println(driver.findElement(
		 * By.xpath("//div[@id='hplogo']/a/img")).getAttribute("title"));
		 * 
		 * driver.manage().window().maximize(); Dimension n = new Dimension(592,
		 * 592); driver.manage().window().setSize(n);
		 * 
		 * driver.navigate().back(); driver.navigate().refresh();
		 * driver.navigate().to("guru99"); driver.navigate().forward();
		 * driver.manage().window().maximize();
		 */

		driver.get("https://www.google.co.in");
		WebElement webelement = driver.findElement(By.id("lst-ib"));
		webelement.sendKeys("Selenium");
		webelement.clear();
		webelement.sendKeys("Neeraj");
		webelement.sendKeys(Keys.BACK_SPACE);
		webelement.sendKeys("j");
		webelement.sendKeys(Keys.ENTER);
		
		driver.get("https://ata123456789123456789.appspot.com/");
		driver.findElement(By.id("ID_nameField1")).sendKeys("5");
		driver.findElement(By.id("ID_nameField2")).sendKeys("2");
		List<WebElement> list = driver.findElement(
				By.xpath("//*[@id='calModeRbContainer1']")).findElements(
				By.tagName("span"));
		for (WebElement l : list) {

			l.findElement(By.tagName("input")).click();
			driver.findElement(By.id("ID_calculator")).click();
			System.out.println("result : "
					+ driver.findElement(By.id("ID_nameField3")).getAttribute(
							"value"));
		}

		
		driver.get("https://www.annauniv.edu/");
		driver.findElement(
				By.xpath("/html/body/table/tbody/tr[1]/td[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td[5]/div/a"))
				.click();

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.cssSelector("#link3 > strong"));

		action.moveToElement(we).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		we = driver.findElement(By.id("menuItemHilite33"));
		action.moveToElement(we).click().build().perform();

	}

}
