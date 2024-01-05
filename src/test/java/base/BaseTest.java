package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public static FileInputStream fis1;
	public static FileInputStream fis2;
	public static Properties configProp;
	
	public static Properties locatorsProp;
	
	@BeforeTest
	public void beforeTest() 
	{
		
		try {
			fis1=new FileInputStream("src\\test\\resources\\Properties\\config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		configProp=new Properties();
		
		try {
			configProp.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fis2=new FileInputStream("src\\test\\resources\\Properties\\locators.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		locatorsProp=new Properties();
		
		try {
			locatorsProp.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//@BeforeMethod
	/*
	 * public void setUp() throws IOException {
	 * 
	 * fis1=new
	 * FileInputStream("src\\test\\resources\\Properties\\config.properties");
	 * 
	 * configProp=new Properties();
	 * 
	 * configProp.load(fis1);
	 * 
	 * String browserName=configProp.getProperty("browser");
	 * 
	 * if(browserName.equalsIgnoreCase("chrome")) {
	 * WebDriverManager.chromedriver().setup(); driver=new ChromeDriver(); } else
	 * if(browserName.equalsIgnoreCase("firefox")) {
	 * WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver(); }
	 * if(browserName.equalsIgnoreCase("edge")) {
	 * WebDriverManager.edgedriver().setup(); driver=new EdgeDriver(); }
	 * 
	 * driver.get(configProp.getProperty("url"));
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * driver.manage().timeouts().implicitlyWait(Long.parseLong(configProp.
	 * getProperty("implicitWaitTime")), TimeUnit.SECONDS);
	 * 
	 * 
	 * 
	 * }
	 */
	
	//@AfterMethod
	/*
	 * public void teardown() { try { Thread.sleep(3000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * driver.quit(); }
	 */
	
	
	
	
	
	
	
	
	
	
	

}
