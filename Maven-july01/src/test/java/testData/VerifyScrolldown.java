package testData;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Loginpage;
import setup.Base;
import utils.Utility;

public class VerifyScrolldown extends Base {
public static void main(String[]args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	//to verify scrolldown mesenger page
	
	Loginpage loginpage = new Loginpage(driver);
	loginpage.openMessengrpage();
	
	Thread.sleep(3000);
	
//	Messengerpage messengerpage = new Messengerpage(driver);
//	messengerpage.ClickonRoomsTab();
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,2000)"); 
}
}
