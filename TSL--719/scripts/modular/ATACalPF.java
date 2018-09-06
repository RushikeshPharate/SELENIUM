package scripts.modular;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATACalPF {

	// By field1 = By.id("ID_nameField1");

	@FindBy(id = "ID_nameField1")
	WebElement field1;

	// By field2 = By.id("ID_nameField2");
	@FindBy(id = "ID_nameField2")
	WebElement field2;

	@FindBy(id = "gwt-uid-1")
	WebElement addOption;

	// By mulOption = By.id("gwt-uid-2");
	@FindBy(id = "gwt-uid-2")
	WebElement mulOption;

	@FindBy(id = "gwt-uid-3")
	WebElement sqrOption;

	@FindBy(id = "gwt-uid-4")
	WebElement compOption;

	@FindBy(id = "gwt-uid-5")
	WebElement sqrSubOption;

	@FindBy(id = "gwt-uid-6")
	WebElement euclidPlusOption;

	@FindBy(id = "gwt-uid-7")
	WebElement euclidMinusOption;

	// By calButton = By.id("ID_calculator");
	@FindBy(id = "ID_calculator")
	WebElement calButton;

	// By result = By.id("ID_nameField3");
	@FindBy(id = "ID_nameField3")
	WebElement result;

	WebDriver driver;

	ATACalPF(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public String add(String val1, String val2) {
		field1.clear();
		field1.sendKeys(val1);
		field2.clear();
		field2.sendKeys(val2);
		addOption.click();
		calButton.click();
		WebElement element = result;
		String strvalue = element.getAttribute("value");
		System.out.println("Multiplied value :" + strvalue);
		return strvalue;
	}

	public String multiply(String val1, String val2) {
		field1.clear();
		field1.sendKeys(val1);
		field2.clear();
		field2.sendKeys(val2);
		mulOption.click();
		calButton.click();
		WebElement element = result;
		String strvalue = element.getAttribute("value");
		System.out.println("Multiplied value :" + strvalue);
		return strvalue;
	}

	public String sqr(String val1, String val2) {
		field1.clear();
		field1.sendKeys(val1);
		field2.clear();
		field2.sendKeys(val2);
		sqrOption.click();
		calButton.click();
		WebElement element = result;
		String strvalue = element.getAttribute("value");
		System.out.println("Multiplied value :" + strvalue);
		return strvalue;
	}
	
	public String comp(String val1, String val2) {
		field1.clear();
		field1.sendKeys(val1);
		field2.clear();
		field2.sendKeys(val2);
		compOption.click();
		calButton.click();
		WebElement element = result;
		String strvalue = element.getAttribute("value");
		System.out.println("Multiplied value :" + strvalue);
		return strvalue;
	}

	public String sqrSub(String val1, String val2) {
		field1.clear();
		field1.sendKeys(val1);
		field2.clear();
		field2.sendKeys(val2);
		sqrSubOption.click();
		calButton.click();
		WebElement element = result;
		String strvalue = element.getAttribute("value");
		System.out.println("Multiplied value :" + strvalue);
		return strvalue;
	}

	public String euclidPlus(String val1, String val2) {
		field1.clear();
		field1.sendKeys(val1);
		field2.clear();
		field2.sendKeys(val2);
		euclidPlusOption.click();
		calButton.click();
		WebElement element = result;
		String strvalue = element.getAttribute("value");
		System.out.println("Multiplied value :" + strvalue);
		return strvalue;
	}
	
	public String euclidMinus(String val1, String val2) {
		field1.clear();
		field1.sendKeys(val1);
		field2.clear();
		field2.sendKeys(val2);
		euclidMinusOption.click();
		calButton.click();
		WebElement element = result;
		String strvalue = element.getAttribute("value");
		System.out.println("Multiplied value :" + strvalue);
		return strvalue;
	}
	
	

}
