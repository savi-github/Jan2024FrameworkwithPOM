package testscenarios;

import static org.testng.Assert.assertEquals;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import io.github.bonigarcia.wdm.WebDriverManager;
import objects.HomePage;
import objects.LoginPage;

public class TestScripts extends BaseTest {

	// Test valid login scenario
	@Test
	public void validLogin() {
		LoginPage loginPage = new LoginPage(driver);

		String title = "Home Page ~ Salesforce - Developer Edition";
		loginPage.enterUserName("pandu@tekarch.com");
		loginPage.enterPassword("chinnu@1");
		loginPage.clickLoginBtn();
		assertEquals(title, "Home Page ~ Salesforce - Developer Edition");
		System.out.println("Login is success");
	}

	// Test invalid login scenario
	@Test
	public void invalidLogin() throws InterruptedException {
		String expectedAlertMessage = "Please enter your password.";

		LoginPage page = new LoginPage(driver);
		page.enterUserName("pandu@tekarch.com");
		page.enterPassword("");
		page.clickLoginBtn();
		assertEquals(page.getAlertMessage(), expectedAlertMessage);
		System.out.println("error message displayed - " + page.getAlertMessage());
		// Thread.sleep(5000);
	}

	// Remember me checkbox scenario
	@Test
	
	public void rememberMeCheckbox() {
		String usernameText = "pandu@tekarch.com";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("pandu@tekarch.com");
		loginPage.enterPassword("chinnu@1");
		loginPage.clickCheckbox();
		loginPage.clickLoginBtn();
		HomePage homePage = new HomePage(driver);
		homePage.clickUserarrow();
		
		homePage.clickLogout();
		assertEquals(usernameText, "pandu@tekarch.com");
		System.out.println("username text field matched");
	}

	// forgot password 4A scenario
	@Test
	public void forgotPassword() {
		String expTitle = "Check Your Email | Salesforce";
		LoginPage page = new LoginPage(driver);
		page.forgotPassword();
		page.enterUsername2("pandu@tekarch.com");
		page.continueButton();
		assertEquals(expTitle, "Check Your Email | Salesforce");
		System.out.println("Reset password page associated with email validated");
	}

	// forgot password validate login error message scenario
	@Test
	public void forgotPassword2() {
		String expAlertMessage = "Please check your username and password. If you still can't log in, "
				+ "contact your Salesforce administrator.";
		LoginPage page = new LoginPage(driver);
		page.enterUserName("123");
		page.enterPassword("12231");
		page.clickLoginBtn();
		assertEquals(page.getAlertMessage(), expAlertMessage);
		System.out.println("Test case passed");

	}
}
