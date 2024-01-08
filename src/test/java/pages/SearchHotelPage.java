package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage extends BasePage{
	
	public SearchHotelPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@name='location']")
	WebElement locationDropdown;
	
	@FindBy(xpath="//input[@name='datepick_in']")
	WebElement checkInDateTextbox;
	
	public void locationDropdown(String option)
	{
		new Select(locationDropdown).selectByVisibleText(option);
	}
	
	public void checkInDateTextbox(String text)
	{
		checkInDateTextbox.clear();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		checkInDateTextbox.sendKeys(text);
	}
	
}
