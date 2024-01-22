package testAndValidation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class temp {

	public static void main(String[] args) {
		
		//.d-inline a
System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://github.com/HackerEarth/fullstack-boilerplates/");
		
		List<WebElement> languages = driver.findElements(By.xpath("//li[@class='d-inline']//span"));
		
		for(WebElement l :languages)
		{
			System.out.println(l.getText());
		}
		
		System.out.println();
		
		List<WebElement> contributerNames = driver.findElements(By.xpath("//li[@class='mb-2 d-flex']/span/a"));
		
		for(int i =0;i<=contributerNames.size()-1;i++)
		{
			System.out.println(contributerNames.get(i).getText());
		}
	}
	
}
