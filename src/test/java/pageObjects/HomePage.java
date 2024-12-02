package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath = "//a[@href='#subnav-search-desktop-top']")
	WebElement searchIcon;
	
	@FindBy(xpath ="//input[@id='search-field']")
	List<WebElement> searchTextBox;

	@FindBy(xpath = "//button[@type='submit']")
	List<WebElement> searchButton;
	
	@FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
	WebElement cookieAcceptButton;
	
	@FindBy(xpath="//*[@class='nav-shared txt-nav-hierarchy nav-top js-nav-shared js-nav-top']//a[contains(text(),'Find a Center')]")
	List <WebElement> findCenterButton;
	
	@FindBy(xpath="//*[@class='map-container']")
	WebElement mapContainer;
	
	@FindBy(xpath="//*[@id='mainContent']/section/div[1]/div/form/h4")
	WebElement findCenterTxt;
	
	public void acceptCookie()
	{
		cookieAcceptButton.click();
	}
	
	public void clickOnSearchIcon()
	{
		searchIcon.click();
	}
	
	
	public boolean verifySearchField()
	{
		try 
		{
			return( searchTextBox.get(1).isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	
	public void setSearchText(String textToSearch)
	{
		searchTextBox.get(1).sendKeys(textToSearch);
		
	}
	
	public void clickSearch()
	{
		searchButton.get(1).click();
	}
	
	public void clickFindCenterButton()
	{
		findCenterButton.get(1).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30)); 
		wait.until(ExpectedConditions.visibilityOf(mapContainer));
		wait.until(ExpectedConditions.visibilityOf(findCenterTxt));
	}
}
