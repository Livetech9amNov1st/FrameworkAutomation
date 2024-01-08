package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class ValidateLoginUsingPOM extends BaseTest {
	
	
	@Test
	public void validateLoginTest1()
	{
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.usernameTextbox("reyaz009");
		
		loginPage.passwordTextbox("reyaz123");
		
		loginPage.loginButton();
		
		loginPage.validateTitle("Adactin.com - Search Hotel");
		
		
	}

}
