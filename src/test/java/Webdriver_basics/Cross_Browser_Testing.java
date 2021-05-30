package Webdriver_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Cross_Browser_Testing {
	
	@Test
	@Ignore
	public void Chrome_Driver()
	{
		 WebDriverManager.chromedriver().driverVersion("90.0.4430.85").setup();
		ChromeDriver driver = new ChromeDriver();
		 driver.get("http://localhost:8080/pages/tables.html");
		 driver.quit();
		
	}
  @Test
  @Ignore
  
  public void Firefox_Driver() {
	  
	 WebDriverManager.firefoxdriver().setup();
	 FirefoxDriver driver = new FirefoxDriver();
	 driver.get("https://www.facebook.com/");
	 driver.quit();
	  
  }
  
  @Test
  @Ignore
  public void Internet_Explorer() {
	  WebDriverManager.iedriver().setup();
	  InternetExplorerDriver   driver = new InternetExplorerDriver();
	  driver.get("https://www.facebook.com/");
	  driver.quit();  
	  
  }
  
  @Test
  @Ignore
  public void Phantomjs()
  {
	  WebDriverManager.phantomjs().setup();
	  WebDriver driver = new PhantomJSDriver();
	  driver.get("https://www.facebook.com/");
	  driver.quit();
	  
  }
  
  @Test
  
	public void Chrome_Driver_Headless()
	{
		 WebDriverManager.chromedriver().driverVersion("90.0.4430.85").setup();
		 ChromeOptions options =new ChromeOptions();
		 options.addArguments("window-size=1400,800");
		 options.addArguments("headless")	;
		 WebDriver driver = new ChromeDriver(options);
		 driver.get("https://www.facebook.com");
		 System.out.println(driver.getTitle());
		 driver.quit();
		
	}
  
  @Test
  @Ignore

  
  
  public void Firefox_Driver_Headless() {
	  
	 WebDriverManager.firefoxdriver().setup();
	 FirefoxOptions options = new FirefoxOptions();
	 options.setHeadless(true);
	 WebDriver driver = new FirefoxDriver();
	 driver.get("https://www.facebook.com/");
	 driver.quit();
	  
  }
  
 
  
  
}
