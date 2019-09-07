package packageTest;

//By Itshak Hadok
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import finalTriviaTest.Method;

class FunctionalityTest extends Method{
	
	@BeforeAll
	public static void openChrome() {
		driver =new ChromeDriver();
	}

	@AfterAll
	public static void closeBrowser() {
		driver.close();
	}

	@Test
	@DisplayName("1. Test homepage open")
	void t1est1() {
		assertEquals("QA Test, to start the the test push the bottun below! good luck!",homePage());
	}
	
	@Test
	@DisplayName("2. Test START button")
	void t1est2() {
		assertEquals("Please type here your question :\n" + "question number: 1", startButton());
	}

	@Test
	@DisplayName("3. First answers page opens")
	void t1est3() {
		assertEquals("Please enter 4 possible answers and Mark the right one!\n" + "question number: 1", insertQuestion());
	}

	@Test
	@DisplayName("4. Back button Test - open 1st question page")
	public void t1est4(){
		assertEquals("Please type here your question :\n" + "question number: 1", backButton());
	}

	@RepeatedTest(3)
	@DisplayName("5. Enter 10/20/30 letter, test number 5+6+7")
	public void t1est5() {
		assertEquals(true, longAnswer());	
	}
	@Test
	@DisplayName("8. Second question page opens")
	public void t1est8() {
		assertEquals("Please type here your question :\n" + "question number: 2", insertAnswers1());
	}
	
	@Test
	@DisplayName("9. Page question3")
	public void t1est9() {
		assertEquals("Please type here your question :\n" + "question number: 3", pageQuestion3());

	}
	@Test

	@DisplayName("10. Page answer 3")
	public void test10() {
		assertEquals("Please enter 4 possible answers and Mark the right one!\n" + "question number: 3", pageAnswer3());
	}

	@Test
	@DisplayName("11. Back in answer 3")
	public void t1est11(){
		assertEquals("Please type here your question :\n" + "question number: 3", back3());
	}
	
	@Test
	@DisplayName("12 Quit button")
	public void t1est12(){
		assertTrue(quit());
	}	
	
	@Test
	@DisplayName("13. Button back in answer1")
	public void t1est13(){
		assertEquals("Play", backAnswer1());
	}
	
	@Test
	@DisplayName("14. Button back in answer2")
	public void t1est14(){
		assertEquals("c", backAnswer2());
	}

	@Test
	@DisplayName("15. Click next without mark any question answer 2")
	public void t1est15(){
		assertEquals(true, notMarkAnswer());
	}
	@Test
	@DisplayName("16. Button back in answer 3")
	public void t1est16(){
		assertEquals("b", backAnswer3());
	}
	@Test
	@DisplayName("17. Get failed in uncorrect all answer")
	public void t1est17(){
		assertEquals("Failed", checkResult());
	}
	@Test
	@DisplayName("18.Try again")
	public void t1est18(){
		assertEquals("c", tryAgainButton());
	}
	@Test
	@DisplayName("19. Test play game with 1 wrong answer")
	public void t1est19(){
		assertEquals("Failed", wrongAnswer());
	}
	@Test
	@DisplayName("20. Quit button")
	public void t2est20(){
		assertTrue(quitButton2());
	}


}



