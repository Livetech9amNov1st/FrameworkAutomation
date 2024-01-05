package testscripts.regression;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateSelectHotelUsingHybrid extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void validateLoginTest(HashMap<String,String> dataMap)
	{
		ApplicationKeywords app=new ApplicationKeywords();
		
		app.openBrowser();
		
		app.launchApp();
		
		app.type("username_textbox", dataMap.get("username"));
		
		app.type("password_textbox", dataMap.get("password"));
		
		app.click("login_button");
		
		app.validateTitle(dataMap.get("expectedTitle"));
		
		app.selectOptionFromDropdown("location_dropdown_name", dataMap.get("Location"));
		
		app.clear("checkInDate_textbox");
		
		app.type("checkInDate_textbox", dataMap.get("Check InDate"));
		
		app.closeBrowser();
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestData("TC-104");
			
		return data;
		
	}
	

}
