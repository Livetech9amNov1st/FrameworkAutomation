package testscripts.regression;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ValidateSearchUsingPOMHybrid extends BaseTest {
	
	
	@Test(dataProvider = "getData")
	public void validateLoginTest1(HashMap<String,String> dataMap)
	{
		
		//LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		LoginPage loginPage=new LoginPage();
		
		loginPage.usernameTextbox(dataMap.get("username"));
		
		loginPage.passwordTextbox(dataMap.get("password"));
		
		loginPage.loginButton();
		
		loginPage.validateTitle(dataMap.get("expectedTitle"));
		
		SearchHotelPage searchHotelPage=new SearchHotelPage();
		
		searchHotelPage.locationDropdown(dataMap.get("Location"));
		
		searchHotelPage.checkInDateTextbox(dataMap.get("Check InDate"));
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestData("TC-104");
		
		return data;
		
	}

}
