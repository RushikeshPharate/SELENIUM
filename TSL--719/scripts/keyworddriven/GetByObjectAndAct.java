package scripts.keyworddriven;

import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetByObjectAndAct {

	WebDriver driver;
	OpenBrowser browserobj;
	Hashtable<String, String> ht;

	public GetByObjectAndAct(WebDriver driver) {
		this.driver = driver;
		ht = new Hashtable<>();
	}

	public void performAction(String operation, String objectName,
			String objectType, String value) throws Exception {
		System.out.println("performing action");
		switch (operation.toUpperCase()) {

		case "CLICK":
			// Perform click
			driver.findElement(this.getByObject(objectName, objectType))
					.click();
			break;
		case "SETTEXT":
			// Set text on control
			driver.findElement(this.getByObject(objectName, objectType))
					.sendKeys(value);
			break;

		case "GOTOURL":
			// Get url of application
			driver.get(value);
			break;
		case "GETTEXT":
			// Get text of an element
			String str = driver.findElement(
					this.getByObject(objectName, objectType)).getText();
			System.out.println(str);
			break;
		case "TIMEOUT":
			// Get url of application
			float sleeptime = Float.parseFloat(value);
			Thread.sleep((long) (sleeptime) * 1000);
			break;

		case "OPENBROWSER":
			OpenBrowser ob=new OpenBrowser(value);
			this.driver=ob.getDriver();
			
			break;
			
		case "STORE":
			System.out.println("Entered store variable");
			ht.put( value,objectName);
			break;
			
		case "ECHO":
			System.out.println("Entered Get Variable");

			System.out.println("-----------------------------------------------------");
			System.out.println("Variable name :- "+value+" Value:- "+ht.get(value));
			System.out.println("-----------------------------------------------------");

			break;
			
		default:
			break;
		}
	}


	private By getByObject(String objectName, String objectType)
			throws Exception {
		// Find by xpath
		if (objectType.equalsIgnoreCase("XPATH")) {

			return By.xpath(objectName);
		}
		// find by class
		else if (objectType.equalsIgnoreCase("CLASSNAME")) {

			return By.className(objectName);

		}
		// find by id
		else if (objectType.equalsIgnoreCase("ID")) {

			return By.id(objectName);

		}
		// find by name
		else if (objectType.equalsIgnoreCase("NAME")) {

			return By.name(objectName);

		}
		// Find by css
		else if (objectType.equalsIgnoreCase("CSS")) {

			return By.cssSelector(objectName);

		}
		// find by link
		else if (objectType.equalsIgnoreCase("LINK")) {

			return By.linkText(objectName);

		}
		// find by partial link
		else if (objectType.equalsIgnoreCase("PARTIALLINK")) {

			return By.partialLinkText(objectName);

		} else {
			throw new Exception("Wrong object type");
		}
	}
}
