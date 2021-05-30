package com.example.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;



import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
	   driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase()  {
    try 
    {driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("8857956365");
    driver.findElement(By.id("email")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("pass")).click();
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("12345678");
    driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
    }
    catch(StaleElementReferenceException ex)
	  {
		  ex.printStackTrace();
	  }
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
