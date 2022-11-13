package testData;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Loginpage;
import pages.Messengerpage;
import pages.Roompages;
import setup.Base;
import utils.Utility;

public class verifyreturntomessengerbutton extends Base   {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//To verify return to messenger.com
		Loginpage loginpage = new Loginpage(driver);
		loginpage.openMessengrpage();
		
		Messengerpage messengerpage = new Messengerpage(driver);
		messengerpage.ClickonRoomsTab();
		
		Roompages roompages = new Roompages(driver);
		roompages.returntoMessenger();
		//actual result
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if (url.equals("https://www.messenger.com/") && title.equals("Messenger")) {
			System.out.println("passed");
		}
			else {
				System.out.println("fail");
			}
		}
	}

//POM
//webdriver related



