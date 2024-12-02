package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import freemarker.cache.FirstMatchTemplateConfigurationFactory;

public class searchResultPage extends BasePage{
	
	
	public searchResultPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath= "//div[@class='hero -textOnly']/div")
	WebElement searchConfirmationMessage;
	
	
	//@FindBy(xpath = "//div[@class='results container']/a[@class='search-result'][1]")
	
	@FindBy(xpath ="//*[@id='mainContent']/section[2]/div[2]/a[1]/div/h3")
	WebElement firstSearchText;

	

	public String searchConfirmationMessage()
	{
		try
		{
			return(searchConfirmationMessage.getText());
		}
		
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	

	public String getFirstResult()
	{
		String firstSearchResult = firstSearchText.getText();
		return firstSearchResult;
	}
	
	
}
