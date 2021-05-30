package Webdriver_basics;

import org.openqa.selenium.Point;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import defaultpackage.AbstractWebDriverTest;

public class PlayingWithWindowScreen extends AbstractWebDriverTest {
  @Test
  @Ignore
  public void f() throws InterruptedException {
	  driver.get("http://localhost:8080/pages/forms.html"); 
	  System.out.println(driver.manage().window().getPosition());
	  System.out.println(driver.manage().window().getSize());
	  sleep(3);
	  driver.manage().window().fullscreen();
	sleep(3);
	  driver.manage().window().setPosition(new Point (200,200));
	  sleep(3);
	  driver.manage().window().maximize();
	  sleep(3);
	  }
  
  @Test
  public void Navigation() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/forms.html"); 
	  sleep(3);
	  driver.get("http://localhost:8080/pages/tables.html"); 
	  sleep(3);
	  driver.get("http://localhost:8080/pages/index.html");
	  sleep(3);
	  driver.navigate().back();
	  sleep(3);
	  driver.navigate().back();
	  sleep(3);
	  driver.navigate().forward();
	  sleep(3);
	  driver.navigate().refresh();
	  
	  
  }
}
