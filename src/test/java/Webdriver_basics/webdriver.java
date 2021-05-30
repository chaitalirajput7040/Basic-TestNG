package Webdriver_basics;

import static org.testng.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class webdriver extends AbstractWebDriverTest {
	
	@Test
	@Ignore
	public void Warning_error() throws InterruptedException
	{
		driver.get("http://localhost:8080/pages/forms.html");
		sleep(4);
	WebElement error= 	driver.findElement(By.id("inputError"));
	System.out.println(error.getCssValue("color"));
	System.out.println(error.getCssValue("display"));
	System.out.println(error.getCssValue("border-color"));
	System.out.println(error.getCssValue("border"));
	System.out.println(error.getCssValue("height"));
	}
	
	@Test
	@Ignore
	public void Sucess() throws InterruptedException
	{
		driver.get("http://localhost:8080/pages/forms.html");
		sleep(4);
	WebElement error= 	driver.findElement(By.id("inputSuccess"));
	System.out.println(error.getCssValue("color"));
	System.out.println(error.getCssValue("display"));
	System.out.println(error.getCssValue("border-color"));
	System.out.println(error.getCssValue("border"));
	System.out.println(error.getCssValue("height"));
	}
	
	@Test
	@Ignore
	public void disabledFields() throws InterruptedException
	{
		driver.get("http://localhost:8080/pages/forms.html");
		sleep(4);
		WebElement error= 	driver.findElement(By.id("disabledInput"));
		System.out.println(error.isEnabled());
		assertFalse(error.isEnabled());
		
	}
	
	@Test
	
	public void checkIfAnElementIsEnabled() throws InterruptedException
	{
		driver.get("http://localhost:8080/pages/forms.html");
		sleep(4);
		WebElement error= 	driver.findElement(By.id("disabledInput"));
		System.out.println(error.getAttribute("placeholder"));
		System.out.println(error.getLocation());
		System.out.println(error.getSize());
		
		WebElement ele= 	driver.findElement(By.id("textElement"));
		System.out.println(ele.getAttribute("placeholder"));
		System.out.println(ele.getLocation());
		System.out.println(ele.getSize());
		
	}
	
	@Test
	@Ignore
	public void Tables() throws InterruptedException
	{
		driver.get("http://localhost:8080/pages/tables.html");
		sleep(4);
		List <WebElement> table =driver.findElements(By.xpath("//*[@id='dataTables-example']/thead/tr/th[2]"));
		for (WebElement tab : table)
		{
			
		}
		
	}
	

}
