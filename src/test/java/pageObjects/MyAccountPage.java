package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='  My Account ']") // My Account Page Heading
	WebElement msgHeading;

	@FindBy(xpath = "//a[text()=' Sign Out']")
	WebElement signoutBtn;

	@FindBy(xpath = "//span[text()='Venue']")
	WebElement venueModule;

	@FindBy(xpath = "//input[@id='textfield-1030-inputEl']")
	WebElement venueSearchBox;

	@FindBy(xpath = "//span[text()='Search']")
	WebElement searchBtn;

	public boolean isMyAccountPageExists() {

		try {

			return (msgHeading.isDisplayed());

		} catch (Exception e) {
			return (false);
		}

	}

	public void clickSignOut() {

		signoutBtn.click();

	}

	public boolean venueTab() {

		boolean venueTabSelected = venueModule.isSelected();

		return venueTabSelected;

	}

	public void searchVenue(String venueName) {
		boolean searchBox = venueSearchBox.isDisplayed();
		venueSearchBox.sendKeys(venueName);

	}

	public SearchPage search() {
		searchBtn.click();
		return new SearchPage(driver);

	}

}
