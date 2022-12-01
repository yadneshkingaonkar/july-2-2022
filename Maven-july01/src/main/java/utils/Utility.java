package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
   
	public static void capcturescreenshot(int testID, WebDriver driver ) throws IOException {
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		//WebDriver driver1 = new ChromeDriver();
		Date d = new Date();
		String filename = d.toString().replace( ":", "_")+ " .jpeg "; 
		//String filename = d.toString().replace( ":", "_")+ " .jpeg "; 
		System.out.println(filename);
		
		TakesScreenshot t = (TakesScreenshot)driver;
		File src =t.getScreenshotAs(OutputType.FILE);
		File Screnshot = new File("C:\\Users\\YADNESH\\Documents\\New folder\\Test -"+ filename +" .jpeg ");
		FileHandler.copy(src, Screnshot);
	}
	
	
	
	public static String getdataFromExcelsheet(String Data, int row, int cell ) throws EncryptedDocumentException, IOException  {
		//Excel code
		
		String path = "C:\\Users\\YADNESH\\Desktop\\Amdocs Job Application Form .xlsx";
		FileInputStream file = new FileInputStream(path);
	  Sheet sheet	= WorkbookFactory.create(file).getSheet("Data");
	  
	  Row r = sheet.getRow(row);
	  Cell c = r.getCell(cell);
	  
	     
			  String data = "";
			try {
				 
				data = c.getStringCellValue();
			} 
			catch(IllegalStateException e) {
			
				double value1 = c.getNumericCellValue();
				
				String s=Double.toString(value1);  
				System.out.println(s);  
			}
			catch(Exception e) {
				e.printStackTrace();
				e.getMessage();
			}
	     return data;
	 }

	
	
	}

