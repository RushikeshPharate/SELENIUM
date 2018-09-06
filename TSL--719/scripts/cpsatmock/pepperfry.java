package scripts.cpsatmock;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class pepperfry {

	public static WebDriver driver;
	private static String baseURL;
	int i, res, res1;
	String str, str1;

	@SuppressWarnings("deprecation")
	public static String[][] getExcelData(String fileName, String sheetName)
			throws IOException {
		String[][] arrayExcelData = null;
		Workbook wb = null;
		try {
			File file = new File(fileName);
			FileInputStream fs = new FileInputStream(file);
			// .xls
			if (fileName.substring(fileName.indexOf(".")).equals(".xlsx")) {

				// If it is xlsx file then create object of XSSFWorkbook class

				wb = new XSSFWorkbook(fs);
			} else if (fileName.substring(fileName.indexOf(".")).equals(".xls")) {
				// If it is xls file then create object of HSSFWorkbook class
				wb = new HSSFWorkbook(fs);
			}
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfRows = sh.getPhysicalNumberOfRows();
			int totalNoOfCols = sh.getRow(0).getPhysicalNumberOfCells();

			System.out.println("totalNoOfRows=" + totalNoOfRows + ","
					+ " totalNoOfCols=" + totalNoOfCols);
			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];
			for (int i = 1; i <= totalNoOfRows - 1; i++) {
				for (int j = 0; j <= totalNoOfCols - 1; j++) {
					sh.getRow(i).getCell(j).setCellType(1);
					arrayExcelData[i - 1][j] = sh.getRow(i).getCell(j)
							.getStringCellValue().toString();
				}
			}
		} catch (Exception e) {
			System.out.println("error in getExcelData()");
		}
		return arrayExcelData;
	}

	@BeforeTest
	public void BeforeTest1() {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://www.pepperfry.com/";
		driver.get(baseURL);
	}

	@DataProvider(name = "DP1")
	public Object[][] createData1() throws IOException {
		Object[][] retObjArr = getExcelData(
				"test\\resources\\data\\pepperfry.xls", "Sheet1");
		System.out.println("*****************  2 *************************");
		return (retObjArr);
	}

	@Test(dataProvider="DP1")
	public void testDataProviderExample(String Keywords) throws Exception {

		System.out.println("*****************  3 *************************");

		//driver.findElement(By.)
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement serachbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		driver.findElement(By.id("search")).clear();
		driver.findElement(By.id("search")).sendKeys(Keywords);
		driver.findElement(By.id("searchButton")).click();

		Select opt = new Select(driver.findElement(By
				.xpath("//*[@id='curSortType']")));

		List<WebElement> names = opt.getOptions();
		for (WebElement text1 : names) {
			System.out.println(text1.getText());
		}

		opt.selectByValue("Price: Low to High");
		Thread.sleep(3000);

		switch (Keywords.toUpperCase()) {

		case "BEDSHEETS":
			for (i = 1; i < 5; i++) {
				if (i == 1) {
					String res1 = driver.findElement(
							By.xpath("//*[@id='p_" + i
									+ "_1']/div/div[5]/div/span[1]")).getText();

				}

			}
			break;
		case "CLOCKS":
			break;
		case "PADLOCKS":
			break;
		}

	}

	@AfterTest
	public void AfterTest1() {
		driver.quit();

	}

}
