package packageTest;
//By Itshak Hadok
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import finalTriviaTest.Method;


class IntegrationTest extends Method {

	@BeforeAll
	public static void openChrome() {
		driver =new ChromeDriver();
		driver.get("https://svcollegetest.000webhostapp.com/");
	}

	@AfterAll
	public static void closeBrowser() {
		driver.close();
	}

	@Test
	@DisplayName("Integration with Facebook")
	void faceBookTest() {
		sanityMethod();
		assertEquals("https://he-il.facebook.com/", facebook(), "Integration test: ");
	}

}
