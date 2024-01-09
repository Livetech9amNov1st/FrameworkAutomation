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
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentManager;

public class BaseTest {

	public static WebDriver driver;
	public static FileInputStream fis1;
	public static FileInputStream fis2;
	public static Properties configProp;
	public static ExtentReports reports;
	public static ExtentTest test;

	public static Properties locatorsProp;

	@BeforeTest
	public void beforeTest() {
		
		reports=ExtentManager.getReports();

		try {
			fis1 = new FileInputStream("src\\test\\resources\\Properties\\config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		configProp = new Properties();

		try {
			configProp.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis2 = new FileInputStream("src\\test\\resources\\Properties\\locators.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		locatorsProp = new Properties();

		try {
			locatorsProp.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeMethod

	public void setUp(ITestContext context) throws IOException {
		
		test=reports.createTest(context.getCurrentXmlTest().getName());

		fis1 = new FileInputStream("src\\test\\resources\\Properties\\config.properties");

		configProp = new Properties();

		configProp.load(fis1);

		String browserName = configProp.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			test.log(Status.INFO, "Started the browser " + browserName);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			test.log(Status.INFO, "Started the browser " + browserName);
		}
		if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			test.log(Status.INFO, "Started the browser " + browserName);
		}

		driver.get(configProp.getProperty("url"));
		
		test.log(Status.INFO, "Launched app using url  " + configProp.getProperty("url"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Long.parseLong(configProp.getProperty("implicitWaitTime")),
				TimeUnit.SECONDS);

	}

	@AfterMethod
	public void teardown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}
	
	@AfterTest
	public void closeReports()
	{
		if(reports!=null)
		{
			reports.flush();
		}
	}

}
