package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	// Elements
	@FindBy(xpath = "//i[@class='fa fa-sign-in']")
	WebElement signinBtn;

	@FindBy(xpath = "//img[@class='cbx-logo-image']")
	public WebElement logo;

	@FindBy(id = "textfield-1030-inputEl")
	WebElement searchBox;

	@FindBy(id = "//span[text()='Search']")
	WebElement searchBtn;

	// Action Methods
	public boolean validateLogo() {

		boolean status = logo.isDisplayed();

		return status;
	}

	public String getCBXtitle() {

		String cbxTitle = driver.getTitle();
		return cbxTitle;
	}

	public void clickLogin() {
		signinBtn.click();

	}

}
