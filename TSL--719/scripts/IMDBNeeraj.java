package scripts;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IMDBNeeraj {
	private WebDriver driver;

	SoftAssert s_assert = new SoftAssert();

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		java.util.Date date = new java.util.Date();
		System.out.println("\n\nExecution Log - Start Time - "
				+ new Timestamp(date.getTime()));

	}

	@DataProvider(name = "Cycle1")
	public Object[][] createData1() {
		Object[][] retObjArr = getTableArray(
				"test\\resources\\data\\Movie.xls", "Movies", "MovieTestData1");
		System.out.println("*****************  2 *************************");
		return (retObjArr);
	}

	@Test(dataProvider = "Cycle1")
	public void testDataProviderExample(String booktitle, String authorname,String plot, String actorname)
			throws Exception {
		System.out.println("*****************  3 *************************");
		driver.get("https://www.imdb.com/");
		try {
			driver.findElement(By.className("icon-close-modal")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.out.println("popup did not appear");
		}
		System.out.println("*****************  3.1 *************************");
		driver.findElement(By.id("navbar-query")).clear();
		driver.findElement(By.id("navbar-query")).sendKeys(booktitle);
		driver.findElement(By.id("navbar-submit-button")).click();
		driver.findElement(By.linkText(booktitle)).click();
		Thread.sleep(2500);
		// s_assert.assertTrue(verifyTextPresent(authorname));
		Thread.sleep(1000);
		System.out.println(" Your dIRECTOR  Name: "
				+ driver.findElement(By.linkText(authorname)).getText());
		String name = driver.findElement(By.linkText(authorname)).getText();
		assertEquals(name, authorname);
		

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
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

}
