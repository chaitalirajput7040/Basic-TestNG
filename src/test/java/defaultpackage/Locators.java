package defaultpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locators {
	
	WebDriver driver;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\java\\chromedriver.exe");
		 
	  driver = new ChromeDriver();
	  driver.get("http://localhost:8080/pages/login.html");
  }
  
  @Test
  public void Get_Attributes_by_name()
  {
	  WebElement nameElement=  driver.findElement(By.name("email"));
		System.out.println(nameElement.getTagName());
		System.out.println(nameElement.getAttribute("type"));
		System.out.println(nameElement.getAttribute("value"));
		  
  }
}
