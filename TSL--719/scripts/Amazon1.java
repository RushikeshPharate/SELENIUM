
package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.*;

public class Amazon1 {
	

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
				"test\\resources\\data\\Amazon.xls", "Amazon", "ProductDelimiter");
		System.out.println("*****************  2 *************************");
		return (retObjArr);
	}

	@Test(dataProvider = "Cycle1")
	public void testUntitled(String ProductName) throws Exception {

		driver.get("https://www.amazon.in/");

		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))
				.sendKeys(ProductName);

		//*[@id="result_0"]/div/div[5]/div/a/span[2]
		//*[@id="result_1"]/div/div[5]/div/a/span[1]
		
		
		driver.findElement(
				By.xpath("//*[@id='nav-search']/form/div[2]/div/input"))
				.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//*[@id='sort']")).click();
		driver.findElement(By.xpath("//*[@id='sort']/option[3]")).click();
		
		Thread.sleep(2000);
		List<WebElement> mobile = driver.findElements(By.cssSelector(".a-size-base.a-color-price.s-price.a-text-bold"));
		int arr[]=new int[mobile.size()];

					for (int i = 0; i < mobile.size(); i++) {
			arr[i] = Integer.parseInt(mobile.get(i).getText().replaceAll("[ ,]",""));
			
			System.out.println("Price of " + i + " Product :-" + mobile.get(i).getText());//+"Array Elements "+arr[i]);
		}

		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length-i-1;i++){
				if(arr[i] <= arr[j]){
					System.out.println("Sorted");
				}
				else
					System.out.println("unsorted");
			}
		}
		}
					
					
					/*Arrays.sort(arr1);
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == arr1[i]) {
				System.out.println("Sorted");
			} else
				System.out.println("Unsorted");
*/


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
