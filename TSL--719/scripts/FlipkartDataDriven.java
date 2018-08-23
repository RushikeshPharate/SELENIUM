package scripts;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlipkartDataDriven {

	WebDriver driver;
	int i, price, price1, result, result1;
	String str, str1, str2, str3;

	@BeforeTest
	public void LogIn() {

	/*	System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
*/
		File pathToBinary = new File("C:\\Users\\AM101_PC15\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button"))
				.click();
		// System.out.println("1");

	}

	@DataProvider(name = "Cycle1")
	public Object[][] createData1() {
		Object[][] retObjArr = getTableArray(
				"test\\resources\\data\\Flipkart.xls", "FlipkartData",
				"ProductDelimiter");
		System.out.println("*****************  2 *************************");
		return (retObjArr);
	}

	@Test(dataProvider = "Cycle1")
	public void Test1(String ProductName) {

		driver.findElement(
				By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[2]/form/div/div[1]/div/input"))
				.clear();

		switch (ProductName) {

		case "sony":

			driver.findElement(
					By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[2]/form/div/div[1]/div/input"))
					.clear();
			driver.findElement(
					By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[2]/form/div/div[1]/div/input"))
					.sendKeys(ProductName);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(
					By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[2]/form/div/div[2]/button"))
					.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Before LTH");
			driver.findElement(
					By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/div[3]"))
					.click();
			System.out.println("After LTH");
			for (int i = 2; i < 6; i++) {
				String str = driver
						.findElement(
								By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div["
										+ i
										+ "]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]"))
						.getText();
				System.out.println(str);

				String splitString = driver
						.findElement(
								By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div["
										+ i
										+ "]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]"))
						.getText();

				String str2 = splitString.split("₹")[1];
				System.out.println(str2);

				result = Integer.parseInt(str2);

				if (i == 2) {
					result1 = Integer.parseInt(str2);

				} else {

					if (result >= result1) {
						System.out.println("TEST PASSED !!");
					} else {
						System.out.println("TEST FAILED !!");
					}

					result1 = result;

				}

			}
			/*
			 * driver.findElement( By.xpath(
			 * "//*[@id='container']/div/header/div[1]/div/div/div/div[2]/form/div/div[1]/div/input"
			 * )) .sendKeys(ProductName); // System.out.println("2");
			 * driver.findElement( By.xpath(
			 * "//*[@id='container']/div/header/div[1]/div/div/div/div[2]/form/div/div[2]/button"
			 * )) .click(); // System.out.println("3"); try {
			 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 * 
			 * driver.findElement( By.xpath(
			 * "//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]"
			 * )) .click(); System.out.println("AFTER RELEVENCE");
			 * 
			 * for (i = 2; i < 6; i++) {
			 * 
			 * try {
			 * 
			 * str = driver .findElement( By.xpath(
			 * "//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[" +
			 * i + "]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]"))
			 * .getText(); System.out.println("Inside TRY"); str1 =
			 * str.substring(1, 2); str2 = str.substring(3, 5); str3 = str1 +
			 * str2; price = Integer.parseInt(str3); System.out.println(price);
			 * price1 = price;
			 * 
			 * } catch (Exception e) { str = driver .findElement( By.xpath(
			 * "//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[" +
			 * i + "]/div/div/div/a/div[2]/div[2]/div[1]/div/div")) .getText();
			 * System.out.println("INSIDE CATCH"); str1 = str.substring(1, 2);
			 * str2 = str.substring(3, 5); str3 = str1 + str2; price =
			 * Integer.parseInt(str3); System.out.println(price);
			 * 
			 * }
			 * 
			 * }
			 */
			// *[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]
			// *[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]
			// *[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[4]/div/div/div/a/div[2]/div[2]/div[1]/div/div
			// *[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[5]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]
			// *[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[7]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]
			// *[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[7]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]
			// *[@id="container"]/div/div[1]/div[2]/div/div[1]/div[2]/div[8]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]
		}

	}

	@AfterTest
	public void End() {
		System.out.println("4");
		driver.quit();
	}

	public boolean verifyTextPresent(String value) {
		boolean x = driver.getPageSource().contains(value);
		return x;
	}

	public String[][] getTableArray(String xlFilePath, String sheetName,
			String tableName) {
		String[][] tabArray = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);

			int startRow, startCol, endRow, endCol, ci, cj;

			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1,
					startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();

			System.out.println("startRow=" + startRow + ", endRow=" + endRow
					+ ", " + "startCol=" + startCol + ", endCol=" + endCol);
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;

			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			System.out.println("error in getTableArray()");

		}

		return (tabArray);
	}

}
