package APITest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_TestNG {
//before running any class or before running any test if you want to run then we can use before suit
	@BeforeSuite
	public void BS()
	{
		System.out.println("This is going to execute before any test");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("This will run after test suite");
	}
	
	@BeforeClass
	public void BC()
	{
		System.out.println("This will execute before class");
	}
	
	@BeforeMethod
	public void BM()
	{
		System.out.println("Before Each Method");
	}
	
	
	@Test
	public void testcase1()
	{
		System.out.println("Test is my first testcase");
	}
	
	@Test
	public void testcase2()
	{
		System.out.println("Test is my second testcase");
		Assert.assertEquals("Sunil","Sunil");
	}
	@AfterMethod
	public void AM()
	{
		System.out.println("After Each Method");
	}
	
	@AfterClass
	public void AC()
	{
		System.out.println("This will execute after class");
	}
	
	
}
