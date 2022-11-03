package testData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.Loginpage;
import pages.Messengerpage;
import pages.Roompages;
import utils.Utility;

public class verifycontacttohelpbutton extends Utility  {
 public static void main(String[] args) {
	 System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//To verify contact to help button
		Loginpage loginpage = new Loginpage(driver);
		loginpage.openMessengrpage();
		
		Messengerpage messengerpage = new Messengerpage(driver);
		messengerpage.ClickonRoomsTab();
		
		Roompages roompages = new Roompages(driver);
		roompages.gobackHelpcenter();
		//actual result
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
//		Assert.assertEquals(url, "https://www.messenger.com/help" );
//		
//		Assert.assertNotEquals(url, "https://www.messenger.com/help");
//		boolean result = url.equals("https://www.messenger.com/help") && title.equals("Messenger Help Centre");
//		Assert.assertTrue(result);
		
		if (url.equals("https://www.messenger.com/help") && title.equals("Messenger Help Centre")) {
			System.out.println("passed");
		}
			else {
				System.out.println("fail");
			}
		
}
}
//Test class
//Webdrviver related or(Which webelemnt not required)