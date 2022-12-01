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

public class TestngClass1 {
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("before suite TestngClass 1");
	}
	
	@BeforeTest
	public void beforetest() {
		System.out.println("before test TestngClass 1");
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("before class TestngClass 1");
	}
	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("before method TestngClass 1");
	}
	
	@Test
	public void testA() {
		System.out.println("testA TestngClass 1");
	}
	
	@Test
	public void testB() {
		System.out.println("testB TestngClass 1");
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
		System.out.println("after test TestngClass 1");
	}
	@AfterSuite
	public void aftertrsuite() {
		System.out.println("after suite TestngClass 1");
	}
	
}
