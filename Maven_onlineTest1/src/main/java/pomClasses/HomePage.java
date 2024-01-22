package pomClasses;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//li[@class='d-inline']//span")
	private List<WebElement> languages;
	
	@FindBy(xpath="//li[@class='mb-2 d-flex']/span/a")
	private List<WebElement> contributerNames;
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor js =(JavascriptExecutor)driver;
	}
	
	public List<String> getLanugage()
	{
		 List<String> languageList = new ArrayList<String>();
		 for (WebElement l : languages) 
		 {
		        String lang = l.getText();
		        languageList.add(lang);
		 }
		return languageList;
	}
	
//	public List<String> getContributerNames()
//	{
//		List<String> allContributerNames = new ArrayList<String>();
//		for(int i =0;i<=contributerNames.size()-1;i++)
//		{
//			String names = contributerNames.get(i).getText();
//		}
//		return allContributerNames;
//	}
	
	public ArrayList<String> getContributerNames()
	{
		//List<String> allContributerNames = new ArrayList<String>();
		ArrayList<String> allContributerNames = new ArrayList<String>();
		for(int i =0;i<=contributerNames.size()-1;i++)
		{
			String names = contributerNames.get(i).getText();
		}
		return allContributerNames;
	}
	
}
