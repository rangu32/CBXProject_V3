package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_HomePageTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	
	
	@Test(priority = 1)
	public void verifyLogo() throws Throwable {
		hp = new HomePage(driver);
		Assert.assertEquals(hp.validateLogo(), true);

	}

	@Test(priority = 2)
	public void verifyTitle() {
		hp = new HomePage(driver);

		String actTitle = hp.getCBXtitle();
		String expTitle = "Find, Book/Order Venue, Cake, Party Rentals, Entertainment and more for your Party Celebration - Celebratix";
		Assert.assertEquals(actTitle, expTitle);

	}

}
