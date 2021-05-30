package defaultpackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Forms extends AbstractWebDriverTest{
  @Test
  @Ignore
  public void f() throws InterruptedException {
	  driver.get("http://localhost:8080/pages/forms.html");
WebElement element=  driver.findElement(By.id("textElement"));
	System.out.println(element.getAttribute("value"));
	Thread.sleep(4);
	element.clear();
	element.sendKeys("Chaitali");
	Thread.sleep(4);

//assertEquals(element.getAttribute("value"),"in28minutes");
   }
  
  @Test
  @Ignore
  public void TextArea() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/forms.html");
	  sleep(4);
	  WebElement element1=  driver.findElement(By.id("textAreaElement"));
	  element1.clear();
	  element1.sendKeys("NewValue");
	  element1.sendKeys("\n");
	  element1.sendKeys("SecondValue");
	  sleep(10);
	  assertEquals(element1.getAttribute("value"),"NewValue\nSecondValue");
	  
	  
  }
  
  @Test
  @Ignore
  public void checkbox() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/forms.html");
	  sleep(4);
	  WebElement element1=  driver.findElement(By.name("checkboxElement1"));
	  System.out.println("Value of Checkbox 1 "+element1.isSelected());
	  assertFalse(element1.isSelected());
	  WebElement element2=  driver.findElement(By.name("checkboxElement2"));
	  System.out.println("Value of Checkbox 2 "+element2.isSelected());
	  assertTrue(element2.isSelected());
	  WebElement element3=  driver.findElement(By.name("checkboxElement3"));
	  System.out.println("Value of Checkbox 3 "+element3.isSelected());
	  assertTrue(element3.isSelected());
	  
	  
  }
  
  @Test
  @Ignore
  public void SetValueInCheckbox() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/forms.html");
	  sleep(4);
	  WebElement element1=  driver.findElement(By.name("checkboxElement1"));
	  element1.click();
	  System.out.println("Value of Checkbox 1 "+element1.isSelected());
	  assertTrue(element1.isSelected());
	  
  }
  @Test
  @Ignore
  public void Checkbox() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/forms.html");
	  sleep(4);
	  uncheck_a_checkbox("checkboxElement1");
	  uncheck_a_checkbox("checkboxElement2");
	  uncheck_a_checkbox("checkboxElement3");
	  sleep(4);
	  
  }
  public void check_a_checkbox(String checkbox) 
  {
	  
	  WebElement element1=  driver.findElement(By.name(checkbox));
	  boolean value = element1.isSelected();
	  if (value==false)
	  {
		  element1.click();
	  }
	  
  }
  
  
  public void uncheck_a_checkbox(String checkbox) 
  {
	  
	  WebElement element1=  driver.findElement(By.name(checkbox));
	  boolean value = element1.isSelected();
	  if (value==true)
	  {
		  element1.click();
	  }
	  
  }
  
  
  
  public String Readfromradiobutton(String name) throws InterruptedException
  
  {
	  
	List <WebElement> radio = driver.findElements(By.name(name));
	for(WebElement element : radio)
	{
	if (element.isSelected())
	{
		return element.getAttribute("value");
	}
	
	}
	return null;
  }
  
  @Test
  @Ignore
  public void radiobutton() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/forms.html");
	  sleep(4);
	 System.out.println(Readfromradiobutton("optionsRadios"));  
	  
	  
  }
  
  @Test
  @Ignore
  public void setradiovalue() throws InterruptedException
  {
	  
	  driver.get("http://localhost:8080/pages/forms.html");
	  sleep(4);
	  
  }
  
  @Test
  @Ignore
  
  public void setvalue() throws InterruptedException
  
  {
	  driver.get("http://localhost:8080/pages/forms.html");
	  String name="optionsRadios";
	  String value ="option3";
	List <WebElement> radio = driver.findElements(By.name(name));
	for (WebElement ele : radio)
	{
		if(ele.getAttribute("value").equals(value))
		{
			ele.click();
		}
	}
	sleep(5);
	
  }
  
  @Test
  @Ignore
  public void Selectbox() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/forms.html");
	  sleep(4);
	WebElement select =  driver.findElement(By.id("selectElement1"));
	Select sel=new Select(select);
	System.out.println(sel.isMultiple());
	System.out.println(sel.getFirstSelectedOption().getText());
	sleep(4);
	  
  }
  
  @Test
  @Ignore
  public void MultiSelectElement() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/forms.html");
	  sleep(4); 
	  WebElement select =  driver.findElement(By.id("multiSelectElement"));
		Select sel=new Select(select);
		System.out.println(sel.isMultiple());
		System.out.println(sel.getFirstSelectedOption().getText());
		for (WebElement ele : sel.getAllSelectedOptions())
		{
			System.out.println(ele.getText());
			
		}
		 sleep(4); 
  }
  
  @Test
  public void Select_selectbox() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/forms.html");
	  sleep(4);
	WebElement select =  driver.findElement(By.id("selectElement1"));
	Select sel=new Select(select);
	sel.selectByValue("2");
	sleep(4);
	sel.selectByVisibleText("Five");
	sleep(4);
	sel.selectByIndex(3);
	sleep(4);
	
	  
  }
  
  
  
  
}
