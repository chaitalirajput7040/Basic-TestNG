package Webdriver_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Mouse_Actions extends AbstractWebDriverTest {
  @Test
  @Ignore
  public void f() throws InterruptedException {
	  driver.get("http://localhost:8080/pages/forms.html");
	  WebElement element = driver.findElement(By.id("textElement"));
	  element.clear();
	  WebElement tables_link = driver.findElement(By.partialLinkText("Tables"));
	  Actions actions = new Actions(driver);
	  actions.sendKeys(element, "Dummy Text").perform();
	  sleep(5);
	  actions.click(tables_link).perform();
	   }
  @Test
  public void DragAndDrop() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/sortable.html");
	  WebElement element1 = driver.findElement(By.id("html"));
	  Actions actions = new Actions(driver);
	  actions.dragAndDropBy(element1, 50,200).perform();
	  sleep(5);
	  
  }
}
