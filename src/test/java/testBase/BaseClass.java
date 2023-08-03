package testBase;

/**
 * This is the Base Class
 */

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;

	public Logger logger; // for logging

	public ResourceBundle rb; // for Load config.properties file

	@BeforeClass
	@Parameters("browser")
	public void setup(@Optional("edge") String br) {

		rb = ResourceBundle.getBundle("config"); // Load config.properties file

		logger = LogManager.getLogger(this.getClass()); // logging

		if (br.equalsIgnoreCase("chrome")) {
			// WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();

			System.setProperty("webdriver.chrome.driver",
					"C:\\Chrome v115.. for Automation\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.setBinary("C:\\Chrome v115.. for Automation\\chrome-win64\\chrome.exe");
			WebDriver driver = new ChromeDriver(co); // Chrome 115 version

			// option.setExperimentalOption("excludeSwitches", new String[] {//
			// "enable-automation" }); // To Disable Notification "Chrome is being
			// Controlled Automated Software"
		}

		else if (br.equalsIgnoreCase("edge")) {

			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);

		} else if (br.equalsIgnoreCase("firefox")) {
			// WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		}
		/*
		 * else if (br.equals("firefox")) { FirefoxOptions ops = new FirefoxOptions();
		 * ops.addArguments("--remote-allow-origins=*");
		 * ops.setBinary("/usr/lib/firefox/firefox"); driver = new FirefoxDriver(ops);
		 */

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get(rb.getString("url"));

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}

}
