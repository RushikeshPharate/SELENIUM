package scripts.pack3;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

public class TestSkipping {

	public WebDriver driver;

	@Test
	public void First() {
		System.out.println("This is the Test Case number One");
	}

	@Test(enabled = false)
	public void Second() {
		System.out.println("This is the Test Case number Two");
	}

	@Test
	public void Third() {
		System.out.println("This is the Test Case number Three");
	}

	@Test
	public void Fourth() {
		System.out.println("This is the Test Case number Four");
	}
}
