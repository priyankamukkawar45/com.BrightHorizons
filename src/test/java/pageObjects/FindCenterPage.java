package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindCenterPage extends BasePage
{
	
	public FindCenterPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='addressInput']")
	WebElement findCenterSearchBox;
	
	@FindBy(xpath = "//span[@class='resultsNumber']")
	WebElement noOfCentersText;
	
	@FindBy(xpath="//div[@class='center-results-container']/div")
	List<WebElement> centerResultList;
	
	@FindBy(xpath="//*[@class='centerResult infoWindow track_center_select covidOpen']")
	List<WebElement> centerResultTable;
	
	@FindBy(xpath="//h3[@class='centerResult__name']")
	WebElement centerNameFromList;
	
	@FindBy(xpath = "//span[@class='centerResult__address']")
	WebElement centerAddressFromList;
	
	@FindBy(xpath = "//*[@id='1489']/span[1]")
	WebElement centerNameFromPopUp;
	
	@FindBy(xpath = "//*[@id='1489']/div[1]/div[1]")
	WebElement centerAddressFromPopUp;

		
	
	public String currentUrl = driver.getCurrentUrl();
	
	
	public boolean verifyCurrentURLContent(String urlContent)
	{
		
		boolean urlCon = currentUrl.contains(urlContent);
		return urlCon;
	}
	
	public void findCenter(String centerName) 
	{
		findCenterSearchBox.sendKeys(centerName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
		findCenterSearchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
	}
	
	public int getNoOfCentersCountFromText()
	{
			
		return Integer.parseInt(noOfCentersText.getText());
		 
		
	}
	
	public int getNoOfCentersFromResultList()
	{
		int centerNum = centerResultList.size();
		System.out.println(centerNum-1);
		return(centerNum-1);
		
	}
		
	
	public void getFirstResultFromListOfCenters()
	{
		centerResultTable.get(0).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	

	public String getCenterAdressFromList()
	{
		System.out.println(centerAddressFromList.getText().trim());
		return centerAddressFromList.getText().trim();
	}
	
	
	public String getCenterAddressFromPopUp()
	{
		return centerAddressFromPopUp.getText().replace("\n"," ").trim();
	}
	
	
	public String getCenterNameFromList()
	{
		System.out.println(centerNameFromList.getText().trim());
		return centerNameFromList.getText().trim();
	}
	
	public String getCenterNameFromPopUp()
	{
		System.out.println(centerNameFromPopUp.getText().trim());
		return centerNameFromPopUp.getText().trim();
	
	}
	
	
	
}
