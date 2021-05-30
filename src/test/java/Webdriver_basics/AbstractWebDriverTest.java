package Webdriver_basics;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstractWebDriverTest {

	protected WebDriver driver;

	public AbstractWebDriverTest() {
		super();
	}

	@BeforeTest
	public void Beforetest() {
		try {  System.setProperty("webdriver.chrome.driver","C:\\java\\chromedriver.exe");
		 
		  driver = new ChromeDriver();
		 
		}
		catch (InvalidArgumentException ex)
		{
			ex.printStackTrace();
		}
		
		
		  
	}
	
	
	public void sleep(int seconds) throws InterruptedException
	{
		Thread.sleep(seconds*1000);
	}

	@AfterTest
	public void close_browser() {
	  driver.quit();  }

}