package scripts;

import java.io.File;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.IsEditable;

public class AmazonDataDriven {
	
	WebDriver driver;

	
	@BeforeTest
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		java.util.Date date = new java.util.Date();
		System.out.println("\n\nExecution Log - Start Time - "
				+ new Timestamp(date.getTime()));
	}
	
	@DataProvider(name = "Cycle1")
	public Object[][] createData1() {
		Object[][] retObjArr = getTableArray("test\\resources\\data\\Amazon.xls",
				"Amazon", "ProductDelimiter");
		System.out.println("*****************  2 *************************");
		return (retObjArr);
	}
	
	
	@Test(dataProvider = "Cycle1")
	public void Test1(String ProductName)
	{
		System.out.println("*****************  3 *************************");
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys(ProductName);
		driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
		
		Select opt = new Select(driver.findElement(By.xpath("//*[@id='sort']")));
		
		opt.selectByValue("price-asc-rank");
		
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		for(int i=0;i<4;i++)
		{
		
			String str;
			System.out.println("INSIDE FOR");
			
			if(i==0)
			{
				System.out.println("INSIDE IF");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				str = driver.findElement(By.xpath("//*[@id='result_"+i+"']/div/div[5]/div/a/span[2]")).getText();
				System.out.println(str);
				
			}
		if(i==1 || i==2)
			{
				System.out.println("INSIDE ELSE IF");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				str = driver.findElement(By.xpath("//*[@id='result_"+i+"']/div/div[5]/div/a/span[1]")).getText();
				System.out.println(str);
				
				//*[@id="result_2"]/div/div[5]/div/a/span[1]
			}
		if(i==3)
			{
				System.out.println("INSIDE ELSE");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				str = driver.findElement(By.xpath("//*[@id='result_"+i+"']/div/div[5]/div[1]/a/span[2]")).getText();
				System.out.println(str);
			}
			
/*			str = driver.findElement(By.xpath("//*[@id='result_"+i+"']/div/div[5]/div/a/span")).getText();
			System.out.println(str);*/
		}

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
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
