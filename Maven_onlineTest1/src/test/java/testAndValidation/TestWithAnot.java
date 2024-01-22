package testAndValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pomClasses.HomePage;

public class TestWithAnot {
	WebDriver driver;
	HomePage homePage;
	@BeforeTest
	public void openBrowser()
	{
		System.out.println("before test");
		System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void PomClass()
	{
		System.out.println("before class");
		homePage = new HomePage(driver);
	}
	
	@BeforeMethod
	public void openApplication()
	{
		System.out.println("before mehtod");
		driver.get("https://github.com/HackerEarth/fullstack-boilerplates/");
	}
	
	@Test
	public void checkLanguage()
	{
		System.out.println("test 1");
		List<String> expectedList = new ArrayList();
		expectedList.add("HTML");
		expectedList.add("57.4%");
		List<String> actualList = homePage.getLanugage();
		
		if(actualList.contains(expectedList))
		{
			System.out.println("true");
			System.out.println(actualList);
		}
		else
		{
			System.out.println("false");
			System.out.println(actualList);
		}
	}
	
	@Test
	public void checkPersonName()
	{
		System.out.println("test 2");
		ArrayList<String> expectedList = new ArrayList();
		expectedList.add("satheesh1997 Satheesh Kumar");
		expectedList.add("sachingupta006 Sachin Gupta");
		
		ArrayList<String> actualList = homePage.getContributerNames();
		
		if(actualList.equals(expectedList))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		System.out.println(actualList);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after method");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("after class");
		homePage = null;
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("after test");
		System.gc();
		driver.quit();
	}
	
}
