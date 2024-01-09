package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class LoginPage extends BasePage {
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginButton;
	
	public void usernameTextbox(String text)
	{
		usernameTextbox.sendKeys(text);
		test.log(Status.INFO, "Entered text"+text+"into text box "+usernameTextbox.toString());
	}
	
	public void passwordTextbox(String text)
	{
		passwordTextbox.sendKeys(text);
		test.log(Status.INFO, "Entered text"+text+"into text box "+passwordTextbox.toString());
	}
	
	public void loginButton()
	{
		loginButton.click();
		test.log(Status.INFO, "Clicked the button "+loginButton.toString());
	}
	

}
