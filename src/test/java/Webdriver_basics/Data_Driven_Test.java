package Webdriver_basics;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class Data_Driven_Test extends AbstractWebDriverTest {
	
	
	
	/*@DataProvider(name= "user-ids-data-provider")
	public Object[] [] userIdsDataProvider()
	{
		return new Object[ ][]{ {"in28minutes","dummy",true},
				{"adam","adam@123",true},
				{"eve", "eve123",false}};
				}*/
	
	@DataProvider(name= "user-ids-csv-data-provider")
	public Iterator<String[]> userIdsDataProvider()
	{
		return Read_from_CSV("C:\\1_html\\logindata.csv").iterator();
	}
	
  @Test(dataProvider="user-ids-data-provider")
  @Ignore
 
  
  public void Successful_Login(String userId, String passwordd) throws InterruptedException {
	  driver.get("http://localhost:8080/login");
	WebElement username =  driver.findElement(By.id("name"));
	username.sendKeys(userId);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys(passwordd);
	driver.findElement(By.id("submit")).click();
	sleep(2);
	System.out.println(driver.findElement(By.id("welcome-message")).getText());	
	driver.findElement(By.linkText("Logout")).click();
	sleep(2);
//
sleep(4);
	   }
  
  @Test (dataProvider= "user-ids-csv-data-provider")
  @Ignore
  
  public void UnsuccessfulLogin(String userId, String passwordd, String loginexpectedString) throws InterruptedException
  
  {
	  
	  boolean loginexpected= Boolean.valueOf(loginexpectedString);
	  driver.get("http://localhost:8080/login");
	  driver.get("http://localhost:8080/login");
		WebElement username =  driver.findElement(By.id("name"));
		username.sendKeys(userId);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(passwordd);
		driver.findElement(By.id("submit")).click();
		
		
		if(loginexpected==true)
		{
			sleep(2);
			String message = driver.findElement(By.id("welcome-message")).getText();
			System.out.println(message);	
			driver.findElement(By.linkText("Logout")).click();
			assertTrue(message.contains("Welcome " + userId));
		}
		else {
			sleep(2);
			WebElement error=driver.findElement(By.id("error-message"));
			System.out.println(error.getText());
			assertEquals(error.getText(),"Invalid Credentials");
			
		}
	  
  }
  
  @Test
  
  
  public void Read_Data_from_CSV() throws IOException
  {
	  //src\test\resources\logindata.csv
	  
	  List<String[]> readAll = Read_from_CSV("C:\\1_html\\logindata.csv");
	  for (String [] row:readAll)
	  {
		  System.out.println(Arrays.toString(row));
	  }
  }

private List<String[]> Read_from_CSV(String Csv_path)  {
	CSVReader reader;
	try {
		reader = new CSVReader ( new FileReader(Csv_path));
		 List<String[]> readAll = reader.readAll();
			return readAll;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	 
}
  
}
