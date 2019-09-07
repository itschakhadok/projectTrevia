package finalTriviaTest;
//By Itshak Hadok
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Method {

	protected static WebDriver driver;
	
	//Enter questions and answers and click on play
	public static void enterQuestionAnswer() {
		driver.findElement(By.id("startB")).click();
		//Insert first question 	
		WebElement question1 =driver.findElement(By.name("question"));
		question1.sendKeys("A");
		//Click Next button
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		//Insert 4 answers
		insertAnswers();
		//Choose correct answer - Radio button 1
		WebElement radioA = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input"));
		radioA.click();
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		//Insert second question	
		WebElement question2 =driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input"));
		question2.sendKeys("B");
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		//Insert 4 answers
		insertAnswers();
		//Choose correct answer - Radio button 2
		WebElement radio2 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[1]"));
		radio2.click();
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		//Insert third question 
		WebElement question3 =driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input"));
		question3.sendKeys("C");
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		insertAnswers();
		WebElement boxC = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[1]/input"));
		boxC.click();
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		//		//Click on Play button after submitting all questions and answers
		driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
	}

	//All sanity steps method: insert questions and answers and playing Trivia game
	public static void sanityMethod() {
		enterQuestionAnswer();
		String a =driver.findElement(By.xpath("//*[@id=\"0\"]/h3")).getText();
		if ("A".equals(a)) {
			driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		String b =driver.findElement(By.xpath("//*[@id=\"1\"]/h3")).getText();
		if ("B".equals(b)) {
			driver.findElement(By.xpath("//*[@id=\"1\"]/input[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		String c =driver.findElement(By.xpath("//*[@id=\"2\"]/h3")).getText();
		if ("C".equals(c)) {
			driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		a =driver.findElement(By.xpath("//*[@id=\"0\"]/h3")).getText();
		if ("A".equals(a)) {
			driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		b =driver.findElement(By.xpath("//*[@id=\"1\"]/h3")).getText();
		if ("B".equals(b)) {
			driver.findElement(By.xpath("//*[@id=\"1\"]/input[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		c =driver.findElement(By.xpath("//*[@id=\"2\"]/h3")).getText();
		if ("C".equals(c)) {
			driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		a =driver.findElement(By.xpath("//*[@id=\"0\"]/h3")).getText();
		if ("A".equals(a)) {
			driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		b =driver.findElement(By.xpath("//*[@id=\"1\"]/h3")).getText();
		if ("B".equals(b)) {
			driver.findElement(By.xpath("//*[@id=\"1\"]/input[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		c =driver.findElement(By.xpath("//*[@id=\"2\"]/h3")).getText();
		if ("C".equals(c)) {
			driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
	}

	//Insert answers to text field
	public static void insertAnswers() {
		try {
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("a");
		} catch (Exception NoSuchElementException) {
			System.out.println("can't enter first answer");
		}
		try {

			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("b");
		} catch (Exception NoSuchElementException) {
			System.out.println("can't enter second answer");
		}
		try {
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("c");
		} catch (Exception NoSuchElementException) {
			System.out.println("can't enter therd answer");
		}
		try {
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("d");
		} catch (Exception NoSuchElementException) {
			System.out.println("can't enter forth answer");
		}
	}

	//Click on FaceBook button and return the URL --> integration test
	public static String facebook() {
		try {
			driver.findElement(By.xpath("//*[@id=\"fackBook2\"]/img")).click();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage()+ "Facebook button error");
		}
		driver.switchTo().alert().accept();
		String pageUrl = driver.getCurrentUrl();
		return pageUrl;
	}

	//Open home page of Trivia game 
	public static String homePage() {
		try {
			driver.get("https://svcollegetest.000webhostapp.com/");
		}
		catch (Exception e) {
			System.out.println(e.getMessage()+ "page canot open");
		}
		String start  =driver.findElement(By.xpath("//*[@id=\"headstart\"]/legend")).getText();
		return start;
	}

	//Click on START button
	public static String startButton() {
		try {
			driver.findElement(By.xpath("//*[@id=\"startB\"]")).click();
		}
		catch (Exception e) {
			System.out.println(e.getMessage()+ "can't click start");
		}
		String question1page= driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/legend")).getText();
		return question1page;
	}

	//Insert question and click on next button
	public static String insertQuestion() {
		try {
			WebElement question1 =driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input"));
			question1.sendKeys("A");
			driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		}
		catch (Exception e) {
			System.out.println(e.getMessage()+ "can't write question 1");
		}
		String ansewr1page =driver.findElement(By.xpath("//*[@id=\"answers\"]/legend")).getText();
		return ansewr1page;
	}

	//Click on Back button
	public static String backButton() {
		try {
			driver.findElement(By.xpath("//*[@id=\"backquest\"]")).click();
		}
		catch (Exception e) {
			System.out.println(e.getMessage()+ "bouton back not work");
		}
		String question1page  =driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/legend")).getText();
		return question1page;
	}
	// Enter in field answer 10 20 and 30 leter
	public static boolean longAnswer() {
		String[] answerArr = {  "aaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
		for(int i=0;i>4;i++) {
			driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
			WebElement ansewr1 =  driver.findElement(By.xpath("//*[@id=\\\"answers\\\"]/div[1]/div[2]/input//div[2]"));
			ansewr1.sendKeys(answerArr[i]);
		}
		return true;
	}

	//Insert answers in answer text field, choose the correct answers and click on Next button
	public static String insertAnswers1() {
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		insertAnswers();
		WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input"));
		radio1.click();
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		String questin2page  =driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/legend")).getText();
		return questin2page;
	}
	
	//Insert question 2 insert answer 2 
	public static String pageQuestion3() {
		WebElement question2 =driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input"));
		question2.sendKeys("b");
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		WebElement boxBb = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[1]/input"));
		boxBb.click();
		insertAnswers();
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		String question3  =driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/legend")).getText();
		return question3;
	}
	
	//Insert question 3
	public static String pageAnswer3() {
		WebElement question3 =driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input"));
		question3.sendKeys("c");
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		String ansewr3  =driver.findElement(By.xpath("//*[@id=\"answers\"]/legend")).getText();

		return ansewr3;
	}
	
	// Click on back button
	public static String back3() {
		driver.findElement(By.xpath("//*[@id=\"backquest\"]")).click();
		String question3  =driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/legend")).getText();
		return question3;
	}

	//Click on quit button
	public static boolean quit() {
		boolean quit = true;
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		insertAnswers();
		WebElement boxC = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[1]/input"));
		boxC.click();
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[2]")).click();
		if(driver.getPageSource().contains("Trivia")){
			quit=false;
		}
		if (quit==false) {
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
		}
		else {
			enterQuestionAnswer();
		}
		return quit;
	}

	//Choose right answer and click back button
	public static String backAnswer1() {
		driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnback\"]")).click();
		String back1= driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).getText();
		return back1;
	}

	//Click next and click back
	public static String backAnswer2() {
		driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"btnback\"]")).click();
		String back2= driver.findElement(By.xpath("//*[@id=\"2\"]/h3")).getText();
		return back2;
	}
	
	//Click next without marking any answer in question 2
	public static boolean notMarkAnswer() {
		driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		String back3= driver.findElement(By.xpath("//*[@id=\"1\"]/h3")).getText();
		if( back3=="b")
			return true;
		return false;
	}

	//Mark answer in question 2 and 3 and click on back button
	public static String backAnswer3() {
		driver.findElement(By.xpath("//*[@id=\"0\"]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnback\"]")).click();
		String back3= driver.findElement(By.xpath("//*[@id=\"1\"]/h3")).getText();
		return back3;
	}
	
	//Mark last question and get result of the game
	public static String checkResult()  {
		driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"0\"]/input[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		String result = driver.findElement(By.xpath("//*[@id=\"mark\"]")).getText();
		return result;
	}

	//Click try again button
	public static String tryAgainButton()  {
		driver.findElement(By.xpath("//*[@id=\"markpage\"]/center/button[1]")).click();
		String tryAgain= driver.findElement(By.xpath("//*[@id=\"2\"]/h3")).getText();
		return tryAgain;
	}

	//Play Trivia game with 1 wrong answer
	public static String wrongAnswer()  {
		driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"1\"]/input[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		String result = driver.findElement(By.xpath("//*[@id=\"mark\"]")).getText();
		return result;
	}

	//Click on quit button on the last page
	public static boolean quitButton2()  {
		boolean quit=true;
		driver.findElement(By.xpath("//*[@id=\"markpage\"]/center/button[2]")).click();
		if(driver.getPageSource().contains("Trivia")){
			quit=false;
		}
		return quit;





	}

}
