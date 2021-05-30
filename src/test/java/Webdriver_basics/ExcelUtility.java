package Webdriver_basics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExcelUtility extends AbstractWebDriverTest{
	
	
	@DataProvider(name= "user-ids-excel-data-provider")
	public String[][] userIdsDataProvider()
	{
		return readExcelInto2DArray("C:\\1_html\\login-data.xlsx","Sheet1",3);
	}
	
	
	public static String[][] readExcelInto2DArray(String excelFilePath, String sheetName, int totalCols) {

	    File file = new File(excelFilePath);

	    String[][] tabArray = null;

	    try {
	      OPCPackage opcPackage = OPCPackage.open(file.getAbsolutePath());

	      Workbook wb = WorkbookFactory.create(opcPackage);

	      Sheet sheet = wb.getSheet(sheetName);

	      int totalRows = sheet.getLastRowNum() + 1;

	      tabArray = new String[totalRows][totalCols];

	      for (int i = 0; i < totalRows; i++) {
	        for (int j = 0; j < totalCols; j++) {
	          Cell cell = sheet.getRow(i).getCell(j);
	         // System.out.println(cell + " " + i + " " + j);

	          if (cell == null)
	            continue;

	          switch (cell.getCellType()) {
	          case Cell.CELL_TYPE_BOOLEAN:
	            tabArray[i][j] = String.valueOf(cell.getBooleanCellValue());
	            break;
	          case Cell.CELL_TYPE_NUMERIC:
	            tabArray[i][j] = String.valueOf(cell.getNumericCellValue());
	            break;
	          case Cell.CELL_TYPE_STRING:
	            tabArray[i][j] = cell.getStringCellValue();
	            break;
	          default:
	            tabArray[i][j] = "";
	            break;
	          }
	        }
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	      throw new RuntimeException(e);
	    }

	    return tabArray;
	  }

	
	@Test (dataProvider= "user-ids-excel-data-provider")
	 
	  
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
	@Ignore
	public void readFromExcel()
	{
	String[][] data= 	readExcelInto2DArray("C:\\1_html\\login-data.xlsx","Sheet1",3);
	System.out.println(Arrays.deepToString(data));
		
	}

}
