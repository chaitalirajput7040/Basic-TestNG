


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class First_Automation_Project {
	WebDriver driver;
	@BeforeTest
	public void Before()
	{
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
	}
	
	@Test
	public void Google_launch()
	{
		
		driver.get("https://www.google.com/");
	String title =	driver.getTitle();
		assertEquals(title, "Google");
	}
	
	@Ignore
	public void facebookLogin()
	{
		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		assertEquals(title, "Facebook – log in or sign up");
		
	}
	
	
	@AfterTest
	public void after()
	{
		driver.quit();
	}

}
