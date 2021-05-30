package defaultpackage;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Login extends AbstractWebDriverTest {
  @Test
  @Ignore
  public void f() throws InterruptedException {
	  
	  driver.get("http://localhost:8080/login");
	
	  driver.findElement(By.tagName("a")).click();
	String href=  driver.findElement(By.tagName("a")).getAttribute("href");
	System.out.println(href);
	  
  }
  
  @Test
  @Ignore
  public void login() throws InterruptedException
  {
	   driver.get("http://localhost:8080/pages/login.html");
	  Thread.sleep(3);
	  driver.findElement(By.name("email")).sendKeys("in28minutes");
	  driver.findElement(By.name("password")).sendKeys("dummy");
	  driver.findElement(By.tagName("a")).click();
	  driver.findElement(By.partialLinkText("SB Admin ")).click();
	System.out.println( driver.findElement(By.partialLinkText("SB Admin ")).getAttribute("href")); 
	 
	WebElement title =driver.findElement(By.className("navbar-brand"));
	assertEquals("SB Admin v2.0",title.getText());
	List <WebElement> element=  driver.findElements(By.className("huge"));
	for(WebElement ele:element)
	{
		System.out.println(ele.getText());
	}
  }
  
  @Test
  @Ignore
  public void CSS_Selector() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/tables.html");
	 WebElement cell = driver.findElement(By.cssSelector("#dataTables-example > tbody > tr:nth-child(1) > td:nth-child(2)"));
	 assertEquals(cell.getText(),"Firefox 1.0");
	 WebElement cell1 = driver.findElement(By.xpath("//*[@id='dataTables-example']/thead/tr/th[2]"));
	 cell1.click();
	 Thread.sleep(5);
	 WebElement cell2 = driver.findElement(By.xpath("//*[@id='dataTables-example']/tbody/tr[1]/td[2]"));
	 
	 assertEquals(cell2.getText(),"All others");
	 
	  
  }
  
  @Test
  @Ignore
  public void CSS_selector1() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/tables.html");
	  Thread.sleep(3);
	 WebElement browser= driver.findElement(By.cssSelector("#dataTables-example > thead > tr > th:nth-child(2)"));
	 browser.click();
  }
  
  @Test
  public void Multiple_Elements()
  {
	  driver.get("http://localhost:8080/pages/tables.html");  
	  //#dataTables-example > tbody > tr:nth-child(1) > td:nth-child(2)
	  WebElement browser= driver.findElement(By.cssSelector("#dataTables-example > tbody"));
	  WebElement c1= browser.findElement(By.cssSelector(" tr:nth-child(1) > td:nth-child(2)"));
	  assertEquals(c1.getText(),"Firefox 1.0");
	  WebElement c2= browser.findElement(By.cssSelector(" tr:nth-child(2) > td:nth-child(2)"));
	  assertEquals(c2.getText(),"Firefox 1.5");
	  WebElement c3= browser.findElement(By.cssSelector(" tr:nth-child(3) > td:nth-child(2)"));
	  assertEquals(c3.getText(),"Firefox 2.0");
	  
	  
	  
  }
}
