package testscripts.regression;


import java.io.IOException;
import java.util.HashMap;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class ValidateSelectHotel extends BaseTest {
	
	@Test(dataProvider="getData")
	public void validateLoginTest1(HashMap<String,String> dataMap) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(dataMap.get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataMap.get("password"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(), dataMap.get("expectedTitle"));
		
		new Select(driver.findElement(By.xpath("//select[@name='location']"))).selectByVisibleText(dataMap.get("Location"));
		
		driver.findElement(By.xpath("//input[@name='datepick_in']")).clear();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='datepick_in']")).sendKeys(dataMap.get("Check InDate"));
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestData("TC-104");
			
		return data;
		
	}
	
	

}
