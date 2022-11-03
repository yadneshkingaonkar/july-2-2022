package testData;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNg {
	public class TestngClass {
		@BeforeClass
		public void beforeclass() {
			System.out.println("before class");
		}
		
		@BeforeMethod
		public void beforemethod() {
			System.out.println("before method");
		}
		
		
		
		@Test 
		public void test1() {
			System.out.println("test 1");
		}
		//test2 is excute if test3 AND Test4 passed are passed
		
		@Test  //2 sec = 2000
		public void test2()  {
			System.out.println("test 2");
			//Thread.sleep(5000);
			//System.out.println("hello");
			//Assert.fail(); //fail test case2
		}
		
		@Test 
		public void test3() {
			System.out.println("test 3");
			//Assert.fail();
			//actual result
			String url = "https://www.messenger.com/help" ;
			String Title = "Messenger Help Centre";
			
			SoftAssert soft = new SoftAssert();
			
			Assert.assertEquals(url, "https://www.messe.com/help" , "Url of page not found");
			System.out.println("Hello");
			soft.assertEquals(Title, "Messenger Help Centre");
			System.out.println("Hi");
			soft.assertAll();
		}
		
		@Test  
		public void test4() {
			System.out.println("test 4");
		}
		
		
		
		@AfterMethod
		public void aftermethod() {
			System.out.println("after method");
		}
		
		
		@AfterClass
		public void afterclass() {
			System.out.println("after class");
		}
		
	}
}
