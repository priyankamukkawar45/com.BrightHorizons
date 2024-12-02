package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindCenterPage extends BasePage
{
	
	public FindCenterPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='addressInput']")
	WebElement findCenterSearchBox;
	
	@FindBy(xpath = "//*[@id='centerLocator_list']/div[2]/span")
	WebElement noOfCenters;
	
	@FindBy(xpath="//div[@class='center-results-container']/div")
	List<WebElement> listOfCenters;
	
	@FindBy(xpath = "//div[@class='center-results-container']/div[2]/div/div/span[@class='centerResult__address']")
	WebElement adressFromList;
	
	@FindBy(xpath = "//*[@id=' 1489 ']/div[1]/div[1]")
	WebElement adressFromPopup;
	
	public String currentUrl = driver.getCurrentUrl();
	
	
	public boolean verifyCurrentURLContent(String urlContent)
	{
		
		boolean urlCon = currentUrl.contains(urlContent);
		return urlCon;
	}
	
	public void findCenter(String centerName) 
	{
		findCenterSearchBox.sendKeys(centerName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		findCenterSearchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}
	
	public String getNoOfCentersCountFromText()
	{
		/*String numMesg = noOfCentersMessage.getText();
		System.out.println("numof center"+ numMesg);
		return numMesg;
		//numMesg.split(" ");*/
		
		return noOfCenters.getText();
		
	}
	
	public int getNoOfCentersFromResultList()
	{
		return(listOfCenters.size()-1);
	}
	
	public WebElement getFirstResultFromListOfCenters()
	{
		
		return listOfCenters.get(1);
			
	}
	
	
	public void getCenterPopOnMap()
	{
		listOfCenters.get(1).click();
	}
	
	
	public String getCenterAdressFromList()
	{
		return ( adressFromList.getText());
	}
	
	public String getAddressFromPopUp()
	{
		return (adressFromPopup.getText());
	}
	
}
