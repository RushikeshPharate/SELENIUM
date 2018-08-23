//Data Driven Test Framework using Selenium2 and TestNG
//This Test performs search for the movie and looks for the attributes on the result page
//Data is read from the Excel SS - movie_data1.xls
package scripts;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import jxl.*;

public class DDT2_barnes1 {

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
		Object[][] retObjArr = getTableArray("test\\resources\\data\\book_data1.xls",
				"DataPool", "bookTestData1");
		System.out.println("*****************  2 *************************");
		return (retObjArr);
	}

	@Test(dataProvider = "Cycle1")
	public void testDataProviderExample(String booktitle, String authorname,String Overview)
			throws Exception {
		System.out.println("*****************  3 *************************");
		driver.get("http://www.barnesandnoble.com/");
		try {
			driver.findElement(By.className("icon-close-modal")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("popup did not appear");
		}
		System.out.println("*****************  3.1 *************************");

		driver.findElement(By.id("searchBarBN")).clear();
		driver.findElement(By.id("searchBarBN")).sendKeys(booktitle);
		driver.findElement(By.className("icon-search-2")).click();
		driver.findElement(By.linkText(booktitle)).click();
		s_assert.assertTrue(verifyTextPresent(authorname));
		driver.findElement(By.className("tab-highlight")).click();
		//driver.findElement(By.className("read-more show-more-pdp")).click();
		String str = driver.findElement(By.id("productInfo-overview")).getText();

		System.out.println("OVERVIEW");
		System.out.println(str);
		/*
		 * Assert.assertEquals(driver.findElement(By.xpath(
		 * "//*[@id='productInfoOverview']")).getText(), overview);
		 * //*[@id="productInfoOverview"] //*[@id="productInfoOverview"]
		 * 
		 * driver.findElement(By.linkText("Product Details")).click();
		 * Assert.assertEquals(driver.findElement
		 * (By.xpath("//div[@id='ProductDetailsTab']/table/tbody/tr/td"
		 * )).getText() , isbn);
		 */
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
