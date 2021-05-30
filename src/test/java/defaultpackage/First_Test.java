package defaultpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class First_Test extends AbstractWebDriverTest {
	
	@Test
  public void f() throws InterruptedException {
	  driver.get("http://localhost:8080/login");
	  sleep(4);
	  System.out.println(driver.getTitle());
		List<WebElement> linkElements =driver.findElements(By.tagName("input"));
		for (WebElement linkelement:linkElements)
		{
	System.out.println("the class type is "+linkelement.getAttribute("type"));
	System.out.println("the placeholder is "+linkelement.getAttribute("name"));
		} 

		driver.findElement(By.id("name")).sendKeys("in28minutes");
		driver.findElement(By.id("password")).sendKeys("dummy");
		driver.findElement(By.id("submit")).click();
		String element = driver.findElement(By.id("welcome-message")).getText();
		System.out.println(element);
		
	  
  }
	
	@Test
	public void Login()
	{
	}
	

  
  @Test
  @Ignore
  public void test_get_information_about_name()
  {
	WebElement nameElement=  driver.findElement(By.name("email"));
	System.out.println(nameElement.getTagName());
	System.out.println(nameElement.getAttribute("type"));
	System.out.println(nameElement.getAttribute("value"));
	  
  }
  
  @Test
  @Ignore
  public void test_get_information_about_checkbox()
  {
	WebElement nameElement=  driver.findElement(By.name("remember"));
	System.out.println(nameElement.getTagName());
	System.out.println(nameElement.getAttribute("type"));
	System.out.println(nameElement.getAttribute("value"));
	  
  }
}
