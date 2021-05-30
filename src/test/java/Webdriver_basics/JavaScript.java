package Webdriver_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class JavaScript  extends AbstractWebDriverTest{
  @Test
  @Ignore
  public void f() throws InterruptedException {
	  driver.get("http://localhost:8080/pages/tables.html");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	 String title =(String) js.executeScript("return document.title");
	   js.executeScript("window.scrollBy(0,200)");
	   sleep(4);
	 System.out.println(title);
	 js.executeScript("window.scrollBy(0,400)");
	 sleep(4);
	 }
  
  @Test
  
  public void Read_Tables()
  {
	  driver.get("http://localhost:8080/pages/tables.html");
	  //> tr:nth-child(1) > td:nth-child(2)
	  //#dataTables-example > tbody > tr:nth-child(2) > td:nth-child(2)
	  TableReader reader = new TableReader(driver, "dataTables-example");
	System.out.println(reader.getData(1,2));  
	System.out.println(reader.getData(2,2));
	System.out.println(reader.getData(5,4));
	
	  TableReader reader1 = new TableReader(driver, "dataTables-example-2");
	  System.out.println(reader1.getData(1,2));
	  
	  
	  
	
	
	 }
  
  @Test
  @Ignore
  public void  FrameworkForTables()
  {
	  
  }
}
