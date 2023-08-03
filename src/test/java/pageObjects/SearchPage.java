package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='cbx-combo-1031-trigger-picker']")
	List<WebElement> clickDropdown;

	@FindBy(xpath = "//div[@id='ext-404']")
	List<WebElement> noLimits;

	@FindBy(xpath = "//input[@id='cbx-suggest-1022-inputEl']")
	List<WebElement> venueSearchInSearchPage;

	@FindBy(xpath = "//input[@id='cbx-combo-1024-inputEl']")
	WebElement placeActivityDropdown;

	public boolean isVenuesExist(String venueName) {
		boolean flag = false;
		for (WebElement venue : venueSearchInSearchPage) {
			if (venue.getAttribute("title").equals(venueName)) {
				flag = true;
				break;
			}
		}

		return flag;

	}

	/*
	 * public void clickDropdown() { clickDropdown.click();
	 * 
	 * }
	 */

	public void DistanceDropDown() {

		/*
		 * int size = clickDropdown.size(); System.out.println(size); for (WebElement
		 * distanceDD : clickDropdown) { String text = distanceDD.getText(); if
		 * (text.contentEquals("No Limits")) { distanceDD.click(); break;
		 * 
		 * }
		 * 
		 * }
		 */

		String dpvalue = "No Limits";

		for (int i = 0; i < clickDropdown.size(); i++) {
			System.out.println(clickDropdown.get(i).getText());
			if (clickDropdown.get(i).getText().contains(dpvalue)) {
				clickDropdown.get(i).click();

			}

		}

		/*
		 * public void SelectNoLimits() {
		 * 
		 * noLimits.click();
		 * 
		 * }
		 */
	}
}
