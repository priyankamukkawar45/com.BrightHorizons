package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FindCenterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC002_verifyNumberOfCenters extends BaseClass 
{

	@Test(groups={"Sanity","Master"})
	
	public void verify_center()
	{
	
		logger.info("******** Starting TC_002_verifyCenter********");
		
		try
		{
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
			
			fc.findCenter("New York");
			
						
			logger.info("******** verify if a number of found centers is the same as a number of centers displayed on the below list ********");
			
			Assert.assertEquals(fc.getNoOfCentersCountFromText(),fc.getNoOfCentersFromResultList(),"num same");
			//Assert.assertEquals(fc.getNoOfCentersCountFromText(),fc.getNoOfCentersFromResultList(),"Centers count in Result list and number of centers displayed are same");
			
			
			logger.info("******** Click on the first center on the list ********");
			
			fc.getFirstResultFromListOfCenters();
			
			
			logger.info("******** Verify if center name and address are the same on the list and on the popup ********");
			
			Assert.assertEquals(fc.getCenterNameFromList(), fc.getCenterNameFromPopUp(),"Center name from result list and pop up is same");
			Assert.assertEquals(fc.getCenterAdressFromList(), fc.getCenterAddressFromPopUp(),"Center address from result list and pop up is same");
			
			
			logger.info("******** completed TC_002_verifyCenter********");
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}

	}
}
