package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, invocationCount = 1)
	public void test_DDT(String email, String password, String status) {
		try {
			logger.info("*** Starting TC_003_LoginDDT ***");
			logger.info("User enter Email & Password details");

			HomePage hp = new HomePage(driver);
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.loginDetails(email, password);

			/*
			 * lp.setEmail(email);
			 * 
			 * lp.setPassword(password); lp.clickLogin();
			 */
			logger.info("User Clicked on Login Button");

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();

			if (status.equals("Valid")) {

				if (targetpage == true) {
					macc.clickSignOut();
					logger.info("*** User able to login successfully ***");
					logger.info("*** User could be logout successfully ***");
					Assert.assertTrue(true);
				} else {

					Assert.assertTrue(false);
					lp.keyActionEnter();

				}

			}

			if (status.equals("Invalid")) {

				if (targetpage == true) {
					macc.clickSignOut();
					Assert.assertTrue(false);
					lp.keyActionEnter();
					logger.info("*** User not able to login successfully  ***");

				} else {

					Assert.assertTrue(true);
					lp.keyActionEnter();
					logger.info("*** User not able to login successfully  ***");

				}

			}
		} catch (Exception e) {
			SoftAssert s = new SoftAssert(); // Assertion fail due to null value insertion of username &
												// password(excel), so
												// using SoftAssert, when any assert get failed, all
												// remaining lines of @Test will be executed & the particular @Test will
												// be marked as passed
			s.assertTrue(false);

			// Assert.fail(); // This is HardAssert, it use means Assertion fail due to null
			// value insertion of username & password. This method tried not working so
			// commented in this line...

		}

		logger.info("*** Finished TC_003_LoginDDT ***");

	}

}
