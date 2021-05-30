package Webdriver_basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayingWithModalWindow extends AbstractWebDriverTest {
	//Inmplicit wait used 
	//WebDriverManager.firefoxdriver().setup();
	//ImplicitWait fails on Chrome and works on firefoxdriver 
	//driver = new FireFoxDriver();
  @Test
  @Ignore
  public void f() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://localhost:8080/pages/notifications.html");
	  //
	  //myModalLabel,myModalCloseButton,myModalBody
	  driver.findElement(By.id("modalButton")).click();
	 // sleep(2);
	  WebDriverWait webdriverwait = new WebDriverWait(driver,10);
	  webdriverwait.withMessage("Oops doesnt load even after 10s");

 WebElement element =	  webdriverwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("myModalLabel"))));
	  
	 System.out.println( element.getText());
	  driver.findElement(By.id("myModalCloseButton")).click();
	  }
  
  //Handling Alerts
  @Test
  @Ignore
  public void Handling_Alerts() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/notifications.html");
	  driver.findElement(By.id("alertButton")).click();
	  sleep(5);
	 
	 Alert alert = driver.switchTo().alert();
	 alert.sendKeys("Ranga");
	 alert.accept();
	  sleep(5);
	  
	  Alert alert1 = driver.switchTo().alert();
	  System.out.println(alert1.getText());
	  alert1.accept();
	  
	  driver.findElement(By.id("modalButton")).click();
	  
	 }
  
  //New Pages
  @Test
  @Ignore
  public void New_Page_Window_handle() throws InterruptedException
  {
	  driver.get("http://localhost:8080/pages/notifications.html");
	  String First_Window_handle= driver.getWindowHandle();
	  System.out.println(First_Window_handle);
	  
	  sleep(5);
	  System.out.println(driver.findElement(By.tagName("h1")).getText());
		System.out.println(driver.getCurrentUrl());  
	  driver.findElement(By.id("newPageButton")).click();
	   String Second_Window_Handle = extracted(First_Window_handle);
	  sleep(5);
	  
	  System.out.println(Second_Window_Handle);
	  driver.switchTo().window(Second_Window_Handle);
	  System.out.println(driver.findElement(By.tagName("h1")).getText());
	System.out.println(driver.getCurrentUrl()); 
	driver.close();
	  
  }

private String extracted(String First_Window_handle) {
	String Second_Window_Handle=null;
	  
	   for (String handle : driver.getWindowHandles()  )
	   {
			   if(!First_Window_handle.equals(handle))
	   {
		   Second_Window_Handle=handle;
	   }
	   }
	return Second_Window_Handle;
}

@Test
public void frames() throws InterruptedException, IOException
{
	driver.get("http://localhost:8080/pages/frames-example.html");
	 TakesScreenshot scrShot =((TakesScreenshot)driver);
	 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	 File DestFile=new File("C:\\1_html\\scrShot.png");
	 FileUtils.copyFile(SrcFile, DestFile);

	driver.switchTo().frame(0);
	System.out.println("0" + driver.findElement(By.tagName("h1")).getText());
	driver.switchTo().parentFrame();
	sleep(5);
	driver.switchTo().frame(1);
	System.out.println("1" + driver.findElement(By.tagName("h1")).getText());
	
}
}
