package Cross_Browse_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class To_do_list {
	WebDriver driver;

	public To_do_list(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String getDescription(int id)
	{
		return driver.findElement(By.id("desc-"+id)).getText();
	}
   
	public String gettargetdate(int id)
	{
		return driver.findElement(By.id("targetdate-"+id)).getText();
	}
	
	public void click_Update(int id )
	{
		driver.findElement(By.id("update-"+id)).click();
	}
}
