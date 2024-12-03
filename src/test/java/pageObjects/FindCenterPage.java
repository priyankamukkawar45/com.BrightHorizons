package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
	
	@FindBy(xpath="//div[@class='mapTooltip']")
	WebElement mapToolTip;

	
	
	public String currentUrl = driver.getCurrentUrl();
	
	
	public boolean verifyCurrentURLContent(String urlContent)
	{
		
		boolean urlCon = currentUrl.contains(urlContent);
		return urlCon;
	}
	
	public static void waitForAjaxComplete(WebDriver driver) {
        String pageLoadStatus = null;
        do {
         
        	JavascriptExecutor js = (JavascriptExecutor) driver;
            pageLoadStatus = (String) js.executeScript("return document.readyState");
        } while (!pageLoadStatus.equals("complete"));
    }
	
	public void searchForCenter(String centerName) throws InterruptedException 
	{
			waitForAjaxComplete(driver);
			
			findCenterSearchBox.sendKeys(centerName);
						
			Actions actions = new Actions(driver);
			
	        actions.sendKeys(findCenterSearchBox, Keys.ARROW_DOWN).perform();    
	        
	     
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(findCenterSearchBox));
			
	        actions.sendKeys(findCenterSearchBox, Keys.RETURN).perform();
	        
	    
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait1.until(ExpectedConditions.elementToBeClickable(findCenterSearchBox));
				
	        actions.sendKeys(findCenterSearchBox,Keys.CLEAR).perform();
	        
	        actions.sendKeys(findCenterSearchBox, Keys.RETURN).perform();
	               
	}
	
	
		
	public WebElement findFirstCenter()
	{
		
		return centerResultTable.get(0);
		
	}
	
	public void getFirstResultFromListOfCenters() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(centerResultTable.get(0)));
		centerResultTable.get(0).click();
		
	}
	
	

	public String getCenterAdressFromList()
	{
		String centerAddressXPath = "//span[@class='centerResult__address']";
		String firstCenterAddressFromList = findFirstCenter().findElement(By.xpath(centerAddressXPath)).getText().trim();
		return firstCenterAddressFromList;
	
	}
	
	
	public String getCenterAddressFromPopUp()
	{
		return centerAddressFromPopUp.getText().replace("\n"," ").trim();
	}
	
	
	public String getCenterNameFromList()
	{
		String centerNameXPath = "//h3[@class='centerResult__name']";
		String firstCenterNameFromList = findFirstCenter().findElement(By.xpath(centerNameXPath)).getText().trim();
		return firstCenterNameFromList;
		
	}
	
	public String getCenterNameFromPopUp()
	{
		return centerNameFromPopUp.getText().trim();
	
	}
	
	public boolean verifyNoOfCenters()
	{
		int noOfCenterFromText = Integer.parseInt(noOfCentersText.getText());
		int noOfCentersFromResultList = centerResultList.size()-1;
		
		if(noOfCenterFromText == noOfCentersFromResultList)
		{
			System.out.println("No of centers match");
			return true;
		}
		
		else
			
		{
			System.out.println("No of centers does not match");
			return false;
		}
	}
	
	
	public boolean verifyCenterNameAndAddress()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(mapToolTip));
		wait.until(ExpectedConditions.visibilityOf(centerNameFromPopUp));
		wait.until(ExpectedConditions.visibilityOf(centerAddressFromPopUp));
	
		if(getCenterAdressFromList().equals(getCenterAddressFromPopUp())
			&& getCenterNameFromList().equals(getCenterNameFromPopUp()))
		{
			System.out.println("Name and address matches");
			return true;
		}
		else
		{
			System.out.println("Name and address does not match");
			return false;
		}
	}

	
	
}
