package testData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.Loginpage;
import pages.Messengerpage;
import pages.Roompages;
import setup.Base;

public class verifyHomepage extends Base {

		
		private WebDriver driver;   //var decleration
		private Loginpage loginpage;
		private Messengerpage messengerpage;
		private Roompages roompages;
		private SoftAssert soft;
		
		@Parameters ("browser")
		@BeforeTest
		public void lounchbrowser(String BrowserName) {
			 System.out.println(BrowserName);
			 
			if(BrowserName.equals("chrome"))
			{	
			driver = openChromebrowser();
			
			}
			
			if(BrowserName.equals("Edge"))
			{	
			System.setProperty("webdriver.edge.driver", "D:\\Selenium\\edgedriver_win64\\msedgedriver.exe");
			driver = openEdgebrowser();
			
			}
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		@BeforeClass
		public void createPOMobjects() {
			loginpage = new Loginpage(driver);
			messengerpage = new Messengerpage(driver);
			roompages = new Roompages(driver);
			
		}
		
		@BeforeMethod
		public void openRoomspage() throws InterruptedException {
			System.out.println("before method");
			driver.get("https://www.facebook.com/");  //driver variale used
			Thread.sleep(3000);
			//To verify return to messenger.com
			loginpage.openMessengrpage();
			Thread.sleep(3000);
			messengerpage.ClickonRoomsTab();
			soft = new SoftAssert();
		}
		
		
		
		
		
		@Test
		public void verifyreturntoMessengerbtn() {
			System.out.println("test 1");
			roompages.returntoMessenger();
			//actual result
			String url = driver.getCurrentUrl();
			String title = driver.getTitle();
			//"https://www.messenger.com/"
			Assert.assertEquals(url, "https://www.messenger.com/" );
			Assert.assertEquals(title,"Messenger" );
			
		}
		
		@Test
		public void verifyreturngobackbtn() throws InterruptedException {
			System.out.println("test 2");
			roompages.gobackHelpcenter();
			Thread.sleep(2000);
			//actual result
			String url = driver.getCurrentUrl();
			String title = driver.getTitle();
			//"https://www.messenger.com/help"  "Messenger Help Centre"
			soft.assertEquals(url, "https://www.messenger/help");
			soft.assertEquals(title, "Messenger Help");
			soft.assertAll();
			
		}
			
		
		@AfterMethod
		public void logouttoApplication() {
			System.out.println("after method");
			System.out.println("logout");
		}
		
		@AfterClass
		public void clearObject() {
			loginpage = null;
			messengerpage = null;
			roompages = null;
			
		}
		
		
		@AfterTest
		public void closeBrowser() {
			driver.close();
			driver=null;
			//to delete all object withought referance
			System.gc();
		}
	}

