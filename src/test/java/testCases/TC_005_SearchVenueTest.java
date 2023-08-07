package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

import static org.testng.Assert.*;

public class TC_005_SearchVenueTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;
	SearchPage sp;

	@Test
	public void test_VenueSearch() throws InterruptedException {

		logger.info("*** Starting TC_005_SearchVenueTest ***");

		hp = new HomePage(driver);
		logger.info("User Clicked on Login Link");

		hp = new HomePage(driver);
		hp.clickLogin();

		logger.info("User enter valid Email & Password details");

		lp = new LoginPage(driver);
		lp.loginDetails(rb.getString("email"), rb.getString("pwd"));

		logger.info("User Clicked on Login Button");
		logger.info("User Successfully logged in My Account Page");

		mp = new MyAccountPage(driver);
		logger.info("Type any venue name in search box");

		//String venueName="Old State House";
		//String venueName="Shelburne Farm";


		mp.searchVenue(rb.getString("venueName"));


		logger.info("Click on Search button");
		mp.search();
		Thread.sleep(5000);
		logger.info("User navigated to search page result");
		logger.info("User clicked on Distance Dropdown");

		sp = new SearchPage(driver);

		sp.DistanceDropDown();

		logger.info("User clicked on No Limits value from Distance Dropdown");

		Thread.sleep(5000);

		logger.info("User is able to see the particular venue (1 0f 1) of search result page");

		sp.isVenueDisplayed();
		sp.isDisplayingOneofOneResult();

		//Assert.assertEquals(sp.isVenuesExist("Old State House"), true);
		//Assert.assertEquals(sp.isVenuesExist(rb.getString("venueName")), true);
		//Assert.assertEquals(sp.isVenuesExist(), true);
		Thread.sleep(5000);
		logger.info("User is clicked on the particular venue, After that it's navigate to view full venue detail page");


		logger.info("*** Finished TC_005_SearchVenueTest ***");


	}

}
