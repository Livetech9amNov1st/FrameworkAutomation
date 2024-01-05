package keywords;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeywords extends BaseTest {
	
	public void openBrowser() 
	{
		
		
		String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
	}
	
	
	public void launchApp()
	{
		driver.get(configProp.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Long.parseLong(configProp.getProperty("implicitWaitTime")), TimeUnit.SECONDS);
	}
	
	public void type(String locatorKey,String text)
	{
		getElement(locatorKey).sendKeys(text);
	}
	
	public void click(String locatorKey)
	{
		getElement(locatorKey).click();
	}
	
	public void clear(String locatorKey)
	{
		getElement(locatorKey).clear();
	}
	
	public WebElement getElement(String locatorKey)
	{
		WebElement element=null;
		
		element=driver.findElement(getLocator(locatorKey));
		
		return element;
		
	}


	private By getLocator(String locatorKey) {
		By by=null;
		
		if(locatorKey.endsWith("id"))
		{
			by=By.id(locatorsProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("name"))
		{
			by=By.name(locatorsProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("linktext"))
		{
			by=By.linkText(locatorsProp.getProperty(locatorKey));
		}	
		else if(locatorKey.endsWith("xpath"))
		{
			by=By.xpath(locatorsProp.getProperty(locatorKey));
		}	
		else
		{
			by=By.xpath(locatorsProp.getProperty(locatorKey));
		}	
	
		return by;
	}
	
	public void selectOptionFromDropdown(String locatorKey,String option)
	{
		new Select(getElement(locatorKey)).selectByVisibleText(option);
	}
	
	public void closeBrowser()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
