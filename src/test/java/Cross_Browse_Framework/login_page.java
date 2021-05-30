package Cross_Browse_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login_page {
	
	WebDriver driver;
	public login_page(WebDriver driver) {

		super();
		this.driver = driver;
		driver.get("http://localhost:8080/login");
	}
@FindBy(id="name")
	private WebElement name;
@FindBy(id="password")
	 WebElement password;
@FindBy(id="submit")
	 WebElement submit;
     
	
	public void enter_name(String namee)
	{
		name.sendKeys(namee);
	}
	
	public void enter_password(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void submit_button()
	{
		submit.submit();
	}
	
	public void loginn(String name, String password)
	{
		enter_name(name);
		enter_password(password);
		submit_button();
	}
	}


