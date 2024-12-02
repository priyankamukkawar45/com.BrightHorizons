package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath = "//a[@href='#subnav-search-desktop-top']")
	WebElement searchLoop;
	
	//@FindBy(xpath ="//input[@class='js-nav-search-field nav-search-input form-control input-text txt-nav-search-input js-input-text'][1]")
	@FindBy(xpath = "/html/body/nav/div[3]/ul/li[10]/nav/div/div/div/div[3]/form/input")
	WebElement searchTextField;
	

	//@FindBy(xpath="//form[@class='js-nav-search-form']/button[1]")
	@FindBy(xpath = "//*[@id='subnav-search-desktop-top']/div/div/div/div[3]/form/button")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
	WebElement cookieAcceptButton;
	
	@FindBy(xpath="/html/body/nav/div[3]/ul/li[7]/a")
	WebElement findCenterButton;
	
	
	public void accpetCookie()
	{
		cookieAcceptButton.click();
	}
	
	public void clickOnSearchLoop()
	{
		searchLoop.click();
	}
	
	
	public boolean verifySearchField()
	{
		try 
		{
			return( searchTextField.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	
	public void setSearchText(String textToSearch)
	{
		searchTextField.click();
		searchTextField.sendKeys(textToSearch);
		
	}
	
	public void clickSearch()
	{
		searchButton.click();
	}
	
	public void clickFindCenterButton()
	{
		findCenterButton.click();
	}
}
