package packageTest;

// By Itshak Hadok

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import finalTriviaTest.Method;

class CompitabilityTest extends Method{

	@BeforeAll
	public static void openFireFox() {
		driver =new FirefoxDriver();
		driver.get("https://svcollegetest.000webhostapp.com/");
	}

	@AfterAll
	public static void closeBrowser() {
		driver.close();
	}
	
	@Test 
	public void sanityTest() {
		sanityMethod();
		String grade = driver.findElement(By.xpath("//*[@id=\"mark\"]")).getText();
		assertEquals("Sucsses", grade, "Compitability test: ");
	}
}
