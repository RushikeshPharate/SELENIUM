package scripts.keywordpractice;

import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GetByObjectAndAct1 {
	Hashtable<String, String> ht;
	
	
	public GetByObjectAndAct1() {
		ht = new Hashtable<>();
	}

	public void performAction(String operation, String variableName, String value)
			throws Exception {
		System.out.println("performing action");

	/*	System.out.println("Variable name :- "+variableName);
		
		
		System.out.println("Value :-"+value);
		
		*/
		
		

		switch (operation.toUpperCase()) {

		case "STOREVARIABLE":

			System.out.println("Entered store variable");
			ht.put(variableName, value);
			break;
		case "GETVARIABLE":
			
			System.out.println("Entered Get Variable");

			System.out.println("Variable name :- "+variableName+"value:- "+ht.get(variableName));

			break;

		default:
			break;
		}
	}
}