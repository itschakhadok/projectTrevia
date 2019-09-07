
// By Itshak Hadok
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import finalTriviaTest.Method;



class FunctionalityRepeatedTest extends Method{

	static int i=0;
 	
	@BeforeAll
	public static void startRepeatedTest() {
		System.out.println("Functionality test - repeated (4) Test Case: 10 characters, 20 characters , 40 characters , 50  characters");
	}
	
	@AfterAll
	public static void browserClose() {
		driver.close();
		System.out.println("Repeated tests finished");
	}

	@BeforeEach
	void beforeTest() {
		driver =new ChromeDriver();
		driver.get("https://svcollegetest.000webhostapp.com/");
		driver.findElement(By.xpath("//*[@id=\"startB\"]")).click();
	}
	
	@AfterEach
	void afterTest() {
		i++;
		System.out.println("Test number : "+ i+ " finished");
	driver.close();
	}
	
	@RepeatedTest(4)
	
	public void testLongStringQuestion() {
		
		try {
		//Insert first question 
		WebElement question1 =driver.findElement(By.name("question"));
		//Insert question from array selected by i
		question1.sendKeys(q1[i]);
		//Click Next button
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click(); 
		//Insert 4 answers
		insertAnswers();
		//Choose correct answer - Radio button 1
		WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input"));
		radio1.click();
		//Click Next button
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click(); 
		//Insert second question 
		WebElement question2 =driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input"));
		question2.sendKeys(q2[i]);
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		insertAnswers();
		WebElement radio2 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[1]"));
		radio2.click();
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();

		//Insert third question 
		WebElement question3 =driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input"));
		question3.sendKeys(q3[i]);
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		insertAnswers();
		WebElement radio3 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[1]/input"));
		radio3.click();
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		
		//Click on Play button after submitting all questions and answers
		driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();

		//Trivia Game starts
		//Question 1 - select correct answer and click Next
		driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		
		//Question 2 - select correct answer and click Next
		driver.findElement(By.xpath("//*[@id=\"1\"]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		
		//Question 3 - select correct answer and click Next
		driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}catch (Exception NoSuchElementException) {
			System.out.println("can't enter repeat question "+ (++i));
		}
		//Last page with result
		String result = driver.findElement(By.xpath("//*[@id=\"mark\"]")).getText();
		assertEquals("Sucsses", result);
		
	}
	
	
	//Arrays for answers ==> Test Case: 10 characters, 20 characters , 40 characters , 50  characters
	String[] q1 = {"aaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
	String[] q2 = {"bbbbbbbbbb", "bbbbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb","bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"};
	String[] q3 = {"cccccccccc", "ccccccccccccccccccccc", "cccccccccccccccccccccccccccccccccccccccc","bbbbbbbbbbbbbbbbbbbbcbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"};


}
