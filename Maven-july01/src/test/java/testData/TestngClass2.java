package testData;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngClass2 {
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("before suite TestngClass2");
	}
	
		
		@BeforeTest
		public void beforetest() {
			System.out.println("before test TestngClass2");
		}
		
		
		@BeforeClass
		public void beforeclass() {
			System.out.println("before class TestngClass2");
		}
		
		@BeforeMethod
		public void beforemethod() {
			System.out.println("before method TestngClass2");
		}
		
		@Test
		public void test3() {
			System.out.println("test3 TestngClass2");
		}
		
		@Test
		public void test4() {
			System.out.println("test4 TestngClass2");
		}
		
		
		
		@AfterMethod
		public void aftermethod() {
			System.out.println("after method");
		}
		
		
		@AfterClass
		public void afterclass() {
			System.out.println("after class");
		}
		
		@AfterTest
		public void aftertest() {
			System.out.println("after test TestngClass2");
		}
		
		@AfterSuite
		public void aftertrsuite() {
			System.out.println("after suite TestngClass2");
		}
	}


