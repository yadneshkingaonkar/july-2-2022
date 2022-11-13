package testData;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
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
import utils.Utility;


	public class verifyRoomespage extends Base  {
		
		private WebDriver driver;   //var decleration
		private Loginpage loginpage;
		private Messengerpage messengerpage;
		private Roompages roompages;
		private SoftAssert soft;
		private int testID; //global var
		
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
			driver = openEdgebrowser();
			
			}
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		@BeforeClass
		public void createPOMobjects() throws EncryptedDocumentException, IOException {
			loginpage = new Loginpage(driver);
			
			String data = Utility.getdataFromExcelsheet("Data", 1, 1);
			loginpage.sendUsername(data);
			
		    data = Utility.getdataFromExcelsheet("Data", 1, 2);
			loginpage.sendpassword(data);
			
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
			testID=1234;
			System.out.println("test 1");
			roompages.returntoMessenger();
			
			//actual result
			String url = driver.getCurrentUrl();
			String title = driver.getTitle();
			//"https://www.messenger.com/"
			Assert.assertEquals(url, "https://www.messenger.com" );
			Assert.assertEquals(title,"Messenger" ); //Messenger
			
		}
		
		@Test
		public void verifyreturngobackbtn() throws InterruptedException {
			testID=7777;
			System.out.println("test 2");
			roompages.gobackHelpcenter();
			Thread.sleep(2000);
			//actual result
			String url = driver.getCurrentUrl();
			String title = driver.getTitle();
			//"https://www.messenger.com/help"  "Messenger Help Centre"
			soft.assertEquals(url, "https://www.messenger.com/help");
			soft.assertEquals(title, "Messenger Help");
			soft.assertAll();
			
		}
			
		
		@AfterMethod
		public void logouttoApplication(ITestResult result) throws IOException {
			
			if(ITestResult.FAILURE == result.getStatus()) {
				Utility.capcturescreenshot(testID, driver);  //faild testcase ss
			}
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

