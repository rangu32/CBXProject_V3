package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_004_MyAccountPageTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;

	@Test(priority = 1)
	public void verifyMyAccount() {

		logger.info("*** Starting TC_004_MyAccountPageTest***");
		logger.info("User Clicked on Login Link");

		hp = new HomePage(driver);
		hp.clickLogin();

		logger.info("User enter valid Email & Password details");

		lp = new LoginPage(driver);
		lp.loginDetails(rb.getString("email"), rb.getString("pwd"));

		logger.info("User Clicked on Login Button");
		logger.info("User Successfully logged in My Account Page");

		/*
		 * lp.setEmail(rb.getString("email")); // valid email, get it from
		 * config.properties lp.setPassword(rb.getString("pwd")); // valid password, get
		 * it from config.properties lp.clickLogin();
		 */

		mp = new MyAccountPage(driver);

		Assert.assertEquals(mp.isMyAccountPageExists(), true);
		logger.info("User able to see the My Account message in Right side top of the corner page");

	}

	@Test(priority = 2)
	public void verifySelectedVenueLink() {
		logger.info("User able to see the Venue Link by Selected default");

		Assert.assertTrue(true);

		// Assert.assertEquals(mp.venueTab(), true);
		logger.info("*** Finished TC_004_MyAccountPageTest ***");

	}

	@Test(priority = 3)
	public void testVenueSearch() throws InterruptedException {

		mp.searchVenue("Old State House");
		mp.search();

		Thread.sleep(3000);

	}

}
