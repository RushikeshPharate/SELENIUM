/**
 * 
 */
package scripts.modular;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author vshadmin
 *
 */
public class ATAPageObjectModel {

	By field1 = By.id("ID_nameField1");
	By field2 = By.id("ID_nameField2");
	By addOption = By.id("gwt-uid-1");
	By mulOption = By.id("gwt-uid-2");
	By sqrOption = By.id("gwt-uid-3");
	By compOption = By.id("gwt-uid-4");
	By sqrSubOption = By.id("gwt-uid-5");
	By euclidPlusOption = By.id("gwt-uid-6");
	By euclidMinusOption = By.id("gwt-uid-7");
	By calc = By.id("ID_calculator");
	By result = By.id("ID_nameField3");
	
	
	WebDriver driver;
	
	

	public ATAPageObjectModel(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String add(String val1, String val2) {
		driver.findElement(field1).clear();
		driver.findElement(field1).sendKeys(val1);
		driver.findElement(field2).clear();
		driver.findElement(field2).sendKeys(val2);
		driver.findElement(addOption).click();
		driver.findElement(calc).click();
		String res = driver.findElement(result).getAttribute("value");
		return res;

	}
	
	public String multiply(String val1, String val2) {
		driver.findElement(field1).clear();
		driver.findElement(field1).sendKeys(val1);
		driver.findElement(field2).clear();
		driver.findElement(field2).sendKeys(val2);
		driver.findElement(mulOption).click();
		driver.findElement(calc).click();
		String res = driver.findElement(result).getAttribute("value");
		return res;

	}
	
	public String sqr(String val1, String val2) {
		driver.findElement(field1).clear();
		driver.findElement(field1).sendKeys(val1);
		driver.findElement(field2).clear();
		driver.findElement(field2).sendKeys(val2);
		driver.findElement(sqrOption).click();
		driver.findElement(calc).click();
		String res = driver.findElement(result).getAttribute("value");
		return res;

	}
	
	public String comp(String val1, String val2) {
		driver.findElement(field1).clear();
		driver.findElement(field1).sendKeys(val1);
		driver.findElement(field2).clear();
		driver.findElement(field2).sendKeys(val2);
		driver.findElement(compOption).click();
		driver.findElement(calc).click();
		String res = driver.findElement(result).getAttribute("value");
		return res;

	}
	
	public String sqrSub(String val1, String val2) {
		driver.findElement(field1).clear();
		driver.findElement(field1).sendKeys(val1);
		driver.findElement(field2).clear();
		driver.findElement(field2).sendKeys(val2);
		driver.findElement(sqrSubOption).click();
		driver.findElement(calc).click();
		String res = driver.findElement(result).getAttribute("value");
		return res;

	}
	
	public String euclidPlus(String val1, String val2) {
		driver.findElement(field1).clear();
		driver.findElement(field1).sendKeys(val1);
		driver.findElement(field2).clear();
		driver.findElement(field2).sendKeys(val2);
		driver.findElement(euclidPlusOption).click();
		driver.findElement(calc).click();
		String res = driver.findElement(result).getAttribute("value");
		return res;

	}
	
	public String euclidMinus(String val1, String val2) {
		driver.findElement(field1).clear();
		driver.findElement(field1).sendKeys(val1);
		driver.findElement(field2).clear();
		driver.findElement(field2).sendKeys(val2);
		driver.findElement(euclidMinusOption).click();
		driver.findElement(calc).click();
		String res = driver.findElement(result).getAttribute("value");
		return res;

	}
	
	

}
