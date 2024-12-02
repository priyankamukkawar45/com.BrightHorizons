package testCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.searchResultPage;
import testBase.BaseClass;

public class TC001_searchText extends BaseClass

{
	
	
	@Test(groups="Sanity")
	public void verify_search_result() throws InterruptedException
	{
		logger.info("******** Starting TC_001_searchText ********");
		
		try 
		{
			HomePage hp = new HomePage(driver);
			hp.acceptCookie();
			hp.clickOnSearchIcon();
			Thread.sleep(3000);
			
			logger.info("******** verify if search Text box is displayed on home page ********");
			Assert.assertEquals(hp.verifySearchField(), true,"Text box is not displayed");
			
			
			logger.info("****** Enter text to search and click on search button ******** ");
			hp.setSearchText("Employee Education in 2018: Strategies to Watch");
			hp.clickSearch();
			
			
			logger.info("****** verify you are searchResult page ******** ");
			
			searchResultPage sp = new searchResultPage(driver);
			Assert.assertEquals(sp.searchConfirmationMessage(), "YOUR SEARCH RESULTS","Search text on page is matching");
			
			
			logger.info("****** Verify if first search result is exact match of entered text******** ");
						
			if(sp.getFirstResult().equals("Employee Education in 2018: Strategies to Watch"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed....");
				logger.debug("Debug logs...");
				Assert.assertTrue(false);
			}
			
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("******** Finished TC_001_searchText ********");
	}
}
