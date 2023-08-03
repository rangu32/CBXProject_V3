package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_ExistingUser_LoginTest extends BaseClass {
	@Test
	public void test_login()

	{
		try {
			logger.info("*** Starting TC_002_ExistingUser_LoginTest ***");

			HomePage hp = new HomePage(driver);
			hp.clickLogin();
			logger.info("User Clicked on Login Link");

			logger.info("User enter valid Email & Password details");
			LoginPage lp = new LoginPage(driver);

			lp.loginDetails(rb.getString("email"), rb.getString("pwd"));

			// lp.setEmail(rb.getString("email")); // valid email, get it from
			// config.properties
			// lp.setPassword(rb.getString("pwd")); // valid password, get it from
			// config.properties
			// lp.clickLogin();
			logger.info("User Clicked on Login Button");

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();

			Assert.assertEquals(targetpage, true);// To fail the test case change "false"
		} catch (Exception e) {
			Assert.fail();// If Login failed in this test case take screenshot in extent report
		}

		logger.info("Successfully User Logged In");

		logger.info("*** Finished TC_002_ExistingUser_LoginTest ***");

	}

}
