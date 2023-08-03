package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//input[@id='textfield-1026-inputEl']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='textfield-1027-inputEl']")
	WebElement txtPassWord;

	@FindBy(id = "login__loginForm-loginAction-btnInnerEl")
	public WebElement btnLogin;

	@FindBy(xpath = "//span[text()='Create an Account']")
	WebElement createAnAccountPage;

	// Action Methods

	/*
	 * public void setEmail(String email) { txtEmail.sendKeys(email); }
	 * 
	 * public void setPassword(String pwd) { txtPassWord.sendKeys(pwd); }
	 */
	public void loginDetails(String email, String pwd) {
		txtEmail.sendKeys(email);
		txtPassWord.sendKeys(pwd);
		btnLogin.click();

	}

	/*
	 * public MyAccountPage clickLogin() { btnLogin.click();
	 * 
	 * return new MyAccountPage(driver);
	 * 
	 * }
	 */

	public void keyActionEnter() throws AWTException {
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_ENTER);

		rt.keyRelease(KeyEvent.VK_ENTER);
	}

}
