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
	
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://205.147.102.59:9001/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@DataProvider(name = "AnyID")
	public Object[][] createData1() {
		Object[][] retObjArr = getTableArray("test\\resources\\data\\LiveTextileSample.xls",
				"AddProductCart", "AddToCartDelimiter");//method is defined below
		return (retObjArr);
	}
	
	@Test
	public void  Login(){
		driver.get(baseUrl);
		driver.findElement(By.id("show_login")).click();
		driver.findElement(By.id("login_email")).sendKeys(
				"tejal.ughade@gmail.com");
		driver.findElement(By.id("login_password")).sendKeys("tejalughade");
		driver.findElement(By.id("login_submit")).click();
	}
	@Test(dataProvider="AnyID")
	public void AddToCartTest(String cat,String subcat,String method,String mid,String qty,String transport,String freight,String transport1,String name ,String mobile,String email,String msg){
		driver.get(baseUrl);
		Actions action = new Actions(driver);
		List<String> categories= new ArrayList();
		//*[@id="menuwrapper"]/ul
		//*[@id="menuwrapper"]/ul/li[2]/a fibre
		//*[@id="menuwrapper"]/ul/li[3]/a filament
		//*[@id="menuwrapper"]/ul/li[1]/a spunyarn
		
			List <WebElement> list =driver.findElements(By.xpath("By.xpath(//*[@id='menuwrapper']"));
			
			for(WebElement l:list){
				System.out.println(l.getText());
			}
			
			//action.moveToElement(p);
			//categories.add(p.getText());
		//categories=driver.findElements(By.id("menuwrapper"));
		System.out.println("Categories:"+categories);
		

		
		
		
		
	}
	
	@AfterTest
	public void turnDown() {
		//driver.quit();

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
	
	
	
	/*public static void main(String[] args) {
		//id:-menuwrapper  Categories
			
	}*/

}
