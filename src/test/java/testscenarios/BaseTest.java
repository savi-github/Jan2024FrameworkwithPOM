package testscenarios;

//import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
// getTitle, switchToAlert acceptAlert DismissAlert getTextFromAlert
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver = null;
	protected Logger baseTestLog = (Logger) LogManager.getLogger();
	String url = "https://login.salesforce.com";

	@BeforeMethod
	public void setUpBeforeMethod() {
		//baseTestLog.info(" *** setUpBeforeMethod executed ...");
		System.out.println("*** setUpBeforeMethod executed ...");
		launchBrowser("chrome");
		goToUrl(url);
	}

	@AfterMethod
	public void tearDownAfterTestMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		baseTestLog.info(" *** tearDownAfterTestMethod executed ...");
	}

	public void launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("browser instance chrome created.");
			driver.manage().window().maximize();
			System.out.println("window is maximized");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			driver.manage().window().maximize();
			break;

		case "safari":
			// Safari does not require a separate driver setup, as it is included with macOS
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Unsupported browser: " + browserName);
		}

		// return driver;
	}

	public void goToUrl(String url) {
		driver.get(url);
		System.out.println(url + " is entered");

	}

	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("username data is entered in " + objectName + " textbox");
		} else {
			System.out.println(objectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			System.out.println(objectName + "button is clicked");

		} else {
			System.out.println(objectName + " element is not enabled");

		}
	}

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		System.out.println("text is extracted from " + objectName);
		return data;
	}

	public void closeBrowser() {
		driver.close();
		System.out.println("browser instance closed");
		driver = null;
	}

	public void successLogin_Salesforce() {
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "pandu@tekarch.com", "username");

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "chinnu@1", "password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "loginbutton");

		String expTitle = "Home Page ~ Salesforce - Developer Edition";

		String actTitle = driver.getTitle();

		if (actTitle.equals(expTitle)) {
			System.out.println("the title is as expected and Login success");
		} else {
			System.out.println("The title is not as expected and Login failed");
		}
	}

	public void Logout_Salesforce() {
		WebElement userarrow = driver.findElement(By.id("userNav"));
		userarrow.click();
		WebElement logOut = driver.findElement(By.linkText("Logout"));
		logOut.click();

	}

}
