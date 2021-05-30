package Cross_Browse_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Crossbrowser {
	
	WebDriver driver=null ;
	
	
	@Parameters("browser")
	@Test
	@Ignore
	public void Chromebrowser( String browser)
	
	{
	   
		
		
		if(browser.equals("chrome"))
		{
		 WebDriverManager.chromedriver().driverVersion("90.0.4430.85").setup();
	 driver = new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(browser.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();
		}
		else
		{
			throw new RuntimeException("Oops does not support browser"+" " +  browser);
		}
		 driver.get("http://localhost:8080/pages/tables.html");
		 driver.quit();
		
	}
	
	@Test
	public void test()
	{
		Chromebrowser("chrome");
	}

	
}
