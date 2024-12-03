package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FindCenterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC002_verifyNumberOfCenters extends BaseClass 
{

	@Test
	
	public void verify_center()
	{
	
		logger.info("******** Starting TC_002_verifyCenter********");
		
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			logger.info("******** clicking on find center button********");
			
			HomePage hp = new HomePage(driver);
			hp.acceptCookie();
			hp.clickFindCenterButton();
			
			
			logger.info("******** Verify that newly open page contains /child-care-locator as a part of its URL ********");
			
			FindCenterPage fc = new FindCenterPage(driver);
			
			if(fc.verifyCurrentURLContent("/child-care-locator") == true)
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed....");
				logger.debug("Debug logs...");
				Assert.assertTrue(false);
			}
			
			
			logger.info("*****Type New York into search box and press Enter ****");
			
			fc.searchForCenter("New York");
			
						
			logger.info("******** verify if a number of found centers is the same as a number of centers displayed on the below list ********");
			
			if(fc.verifyNoOfCenters()== true)
			{
				Assert.assertTrue(true);
			}
			else
			{	logger.error("No of centers does not match....");
				Assert.assertTrue(false);
			}
			
			logger.info("******** Click on the first center on the list ********");
			
			fc.getFirstResultFromListOfCenters();
			
			
			logger.info("******** Verify if center name and address are the same on the list and on the popup ********");
			
			if(fc.verifyCenterNameAndAddress()== true)
			{
				Assert.assertTrue(true, "Centrer name and address matches");
			}
			else
			{
				Assert.assertTrue(false, "Centrer name and address does not matches");
			}
						
			
			logger.info("******** completed TC_002_verifyCenter********");
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}

	}
}
