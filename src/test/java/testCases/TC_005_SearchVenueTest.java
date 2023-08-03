package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

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

		mp.searchVenue("Old State House");
		mp.search();

		sp = new SearchPage(driver);

		sp.DistanceDropDown();
		Thread.sleep(5000);

		// sp.SelectNoLimits();

	}

}
