package scripts;

import static org.testng.Assert.fail;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class AddProduct {
	private WebDriver driver;
	private String baseUrl;
	Actions action;
	WebElement we;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		baseUrl = "http://205.147.102.59:9001/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@DataProvider(name = "AnyID")
	public Object[][] createData1() {
		Object[][] retObjArr = getTableArray(
				"test\\resources\\data\\LiveTextile.xls", "AddProductCart",
				"AddToCartDelimiter");// method is defined
		// below
		return (retObjArr);
	}

	@Test
	public void Login() {
		try {
			driver.get(baseUrl);
			driver.findElement(By.id("show_login")).click();
			driver.findElement(By.id("login_email")).sendKeys(
					"tejal.ughade@gmail.com");
			driver.findElement(By.id("login_password")).sendKeys("tejalughade");
			driver.findElement(By.id("login_submit")).click();
		} catch (Exception e) {

			System.out.println("Already Logged in");
		}
	}

	public void loginFunction() {

		driver.findElement(By.id("show_login")).click();
		driver.findElement(By.id("login_email")).sendKeys(
				"tejal.ughade@gmail.com");
		driver.findElement(By.id("login_password")).sendKeys("tejalughade");
		driver.findElement(By.id("login_submit")).click();

	}

	@Test(dataProvider = "AnyID")
	public void AddToCartTest(String cat, String subcat, String method,
			String mid, String qty, String transport, String freight,
			String transport1, String name, String mobile, String email,
			String msg, String buynow) {
		try {
			driver.get(baseUrl);
			loginFunction();
		} catch (Exception e) {
			System.out.println("Already Logged in");
		}

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		switch (cat.toUpperCase()) {

		case "SPUN YARN":
			driver.findElement(By.xpath("//*[@id='menuwrapper']/ul/li[1]/a"))
					.click(); // action.moveToElement(we).build().perform();
			System.out.println("Entered");
			switch (subcat.toUpperCase()) {

			case "COTTON":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[1]/ul/li[1]/a"))
						.click();
				break;

			case "POLYESTER":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[1]/ul/li[2]/a"))
						.click();
				break;
			case "VISCOSE":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[1]/ul/li[3]/a"))
						.click();
				break;

			case "SYNTHETIC BLENDED":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[1]/ul/li[4]/a"))
						.click();
				break;
			case "ACRYLIC":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[1]/ul/li[5]/a"))
						.click();
				break;

			case "SPECIALITY YARN":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[1]/ul/li[6]/a"))
						.click();
				break;
			case "LINEN & BLENDS":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[1]/ul/li[7]/a"))
						.click();
				break;

			default:
				System.out.println("Invalid Sub-category");
				break;

			}

			break;
		case "FIBRE":
			driver.findElement(By.xpath("//*[@id='menuwrapper']/ul/li[2]/a"))
					.click();
			switch (subcat.toUpperCase()) {

			case "COTTON":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[2]/ul/li[1]/a"))
						.click();
				break;

			case "POLYESTER":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[2]/ul/li[2]/a"))
						.click();
				break;
			case "VISCOSE":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[2]/ul/li[3]/a"))
						.click();
				break;

			case "SYNTHETIC BLENDED":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[2]/ul/li[4]/a"))
						.click();
				break;
			case "ACRYLIC":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[2]/ul/li[5]/a"))
						.click();
				break;

			case "SPECIALITY YARN":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[2]/ul/li[6]/a"))
						.click();
				break;
			case "LINEN & BLENDS":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[2]/ul/li[7]/a"))
						.click();
				break;

			default:
				System.out.println("Invalid Sub-category");
				break;

			}
			break;

		case "FILAMENT":
			driver.findElement(By.xpath("//*[@id='menuwrapper']/ul/li[3]/a"))
					.click();
			switch (subcat.toUpperCase()) {

			case "POY YARN":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[3]/ul/li[1]/a"))
						.click();
				break;

			case "FLAT YARN":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[3]/ul/li[2]/a"))
						.click();

				break;
			case "TEXTURE YARN":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[3]/ul/li[3]/a"))
						.click();

				break;

			case "AIR TEXTURE YARN":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[3]/ul/li[4]/a"))
						.click();

				break;
			case "MONO FILAMENT":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[3]/ul/li[5]/a"))
						.click();

				break;

			case "DTY":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[3]/ul/li[6]/a"))
						.click();

				break;
			case "FDY":
				driver.findElement(
						By.xpath("//*[@id='menuwrapper']/ul/li[3]/ul/li[7]/a"))
						.click();

				break;

			default:
				System.out.println("Invalid Sub-category");
				break;

			}
			break;

		default:
			System.out.println("Invalid Category");
			break;

		}

		// *[@id="listing_conatiner"]/div[1]/a/

/*		if (driver.findElement(By
				.xpath("//*[@id='listing_conatiner']/div[1]/a")) != null) {
*/
			switch (method.toUpperCase()) {

			case "WEAVING":

				driver.findElement(By.id("weaving")).click();
				break;
			case "KNITTING":
				driver.findElement(By.id("knitting")).click();
				break;
			case "SINGLE":
				driver.findElement(By.id("single")).click();
				break;
			case "MULTI":
				driver.findElement(By.id("multi")).click();
				break;
			case "CORD":
				driver.findElement(By.id("cord")).click();
				break;
			default:
				break;

			}
			if (driver.findElement(By
					.xpath("//*[@id='listing_conatiner']/div[1]/a")) != null) {
				try {

					driver.findElement(
							By.xpath("//*[@id='listing_conatiner']/div[1]/a"))
							.click();

					if (mid.toUpperCase().equals("DEPOT")) {
						driver.findElement(By.xpath("//*[@id='depoprice']"))
								.click();
					}
					/*
					 * String qty, String transport, String freight, String
					 * transport1, String name, String mobile, String email,
					 * String msg
					 */

					driver.findElement(By.xpath("//*[@id='req_bags']"))
							.sendKeys(qty);
					if (transport.toUpperCase().equals("YES")) {

						driver.findElement(By.xpath("//*[@id='trans_yes']"))
								.click();
					} else {
						driver.findElement(By.xpath("//*[@id='trans_no']"))
								.click();
					}
					if (freight.toUpperCase().equals("YES")) {
						// *[@id='freight_yes']
						driver.findElement(By.xpath("//*[@id='freight_yes']"))
								.click();
					} else {
						// *[@id='freight_no']
						driver.findElement(By.xpath("//*[@id='freight_no']"))
								.click();
					}
					if (transport1.toUpperCase().equals("YES")) {

						// *[@id='fullname']
						driver.findElement(By.xpath("//*[@id='fullname']"))
								.sendKeys(name);

						// *[@id="mobile"]
						driver.findElement(By.xpath("//*[@id='mobile']"))
								.sendKeys(mobile);
						// *[@id="email"]
						driver.findElement(By.xpath("//*[@id='email']"))
								.sendKeys(email);
						// *[@id="message"]
						driver.findElement(By.xpath("//*[@id='message']"))
								.sendKeys(msg);
						// *[@id="tranportbyKT"]
						driver.findElement(By.xpath("//*[@id='tranportbyKT']"))
								.click();
					}
					if (buynow.toUpperCase().equals("YES")) {
						// *[@id='freight_yes']
						driver.findElement(By.xpath("//*[@id='buynow']"))
								.click();
					} else {
						// *[@id='freight_no']
						driver.findElement(By.xpath("//*[@id='addtocartid']"))
								.click();
					}
					driver.switchTo().alert().accept();

				} catch (Exception e) {
					System.out.println("Product not found");

				}
			//}
		}
	}

	@AfterTest
	public void turnDown() {
		// driver.quit();

		java.util.Date date = new java.util.Date();
		System.out.println("\n\nExecution Log - End Time - "
				+ new Timestamp(date.getTime()));
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

	/*
	 * public static void main(String[] args) { //id:-menuwrapper Categories
	 * 
	 * }
	 */

}