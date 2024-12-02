package pageObjects;

import java.util.List;

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
	
	
	@FindBy(xpath ="//h3[@class='title']")
	List<WebElement> searchResults;

	

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
		return searchResults.get(0).getText(); //get first result from the list
		
	}
	
	
}
