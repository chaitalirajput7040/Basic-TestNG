package Cross_Browse_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class To_do {
	WebDriver driver;
	@FindBy(id="desc")
	WebElement description;
	@FindBy(id="targetDate")
	WebElement targetdate;
	@FindBy(id="save")
	WebElement Save;

	public To_do(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public void enter_description(String desc)
	{
		description.clear();
		description.sendKeys(desc);
	}
    
	public void enter_targetdate(String date)
	{
		targetdate.clear();
		targetdate.sendKeys(date);
	}
	
	public void submit()
	{
		Save.submit();
	}
	
	public void To_doo(String des, String da)
	{
		enter_description(des);
		enter_targetdate(da);
		submit();
	}
}
