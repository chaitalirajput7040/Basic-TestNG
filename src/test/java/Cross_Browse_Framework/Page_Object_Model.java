package Cross_Browse_Framework;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page_Object_Model {
	WebDriver driver;
	
	@BeforeTest
	public void before()
	{
		WebDriverManager.chromedriver().driverVersion("90.0.4430.85").setup();
		driver = new ChromeDriver();
	}
	
	@Test
	
	public void login_page_object() throws InterruptedException
	{
	
	
	login_page login = PageFactory.initElements(driver,login_page.class);
	Thread.sleep(4*1000);
	//login.enter_name("in28minutes");
	//login.enter_password("dummy");
	//login.submit_button();
	login.loginn("in28minutes","dummy");
	Thread.sleep(4*1000);
	
	driver.findElement(By.linkText("Click here")).click();
	Thread.sleep(4*1000);
	
	To_do_list list =new  To_do_list(driver);
	
	//driver.findElement(By.linkText("Update")).click();
	list.click_Update(10001);
	Thread.sleep(4*1000);
	
    To_do page = PageFactory.initElements(driver,To_do.class);
	
	Thread.sleep(4*1000);
	page.To_doo("Learn Automation Testing with selenium and Java","28/04/2022");
	Thread.sleep(4*1000);
	
	System.out.println(list.getDescription(10001));
	System.out.println(list.gettargetdate(10001));
	
	assertEquals(list.getDescription(10001),"Learn Automation Testing with selenium and Java");
	assertEquals(list.gettargetdate(10001),"28/04/2022");
	

	
	//System.out.println(login.name.getAttribute("type"));
	//System.out.println(login.password.getAttribute("type"));
	}
	


	
	@Test
	@Ignore
	public void Update_todos() throws InterruptedException
	{
	driver.get("http://localhost:8080/login");
	
	login_page login = PageFactory.initElements(driver,login_page.class);
	driver.findElement(By.id("name")).sendKeys("in28minutes");
	driver.findElement(By.id("password")).sendKeys("dummy");
	driver.findElement(By.id("submit")).submit();
	Thread.sleep(4*1000);
	driver.findElement(By.linkText("Click here")).click();
	Thread.sleep(4*1000);
	driver.findElement(By.linkText("Update")).click();
	Thread.sleep(4*1000);
	WebElement ele =driver.findElement(By.id("desc"));
	ele.clear();
	Thread.sleep(4*1000);
	ele.sendKeys("Learn Automation Testing with selenium and Java");
	WebElement element =driver.findElement(By.id("targetDate"));
	element.clear();
	Thread.sleep(4*1000);
	element.sendKeys("28/04/2022");
	driver.findElement(By.id("save")).submit();
	//desc-10001
	String desc =driver.findElement(By.id("desc-10003")).getText();
	//targetdate-10001
	String target =driver.findElement(By.id("targetdate-10003")).getText();
	
	//assert.AssertEquals(desc,"Learn Automation Testing with selenium and Java" )
	System.out.println(desc);
	System.out.println(target);
	assertEquals(desc,"Learn Automation Testing with selenium and Java");
	assertEquals(target,"28/04/2022");
	
	}
	
	@AfterTest
	public void after()
	{
		driver.quit();
	}

}
