package objects;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	By usernameElement = By.id("username");
	By passwordElement = By.id("password");
	By loginButtonElement = By.id("Login");
	By errormessageElement = By.id("error");
	By checkboxElement = By.id("rememberUn");

	By forgotPasswordElement = By.id("forgot_password_link");
	By username2Element = By.id("un");
	By continueButtonElement = By.id("continue");

	By errorMessageElement = By.id("error");

	public void enterUserName(String input) {
		enterText(usernameElement, input, "Username Textbox");
	}

	public void enterPassword(String input) {
		enterText(passwordElement, input, "Username Textbox");
	}

	public void clickLoginBtn() {
		clickButton(loginButtonElement);

	}

	public String getAlertMessage() {
		String message = driver.findElement(errormessageElement).getText();
		return message;
	}

	public void clickCheckbox() {
		clickButton(checkboxElement);
	}

	public void forgotPassword() {
		clickButton(forgotPasswordElement);
	}

	public void enterUsername2(String input) {
		enterText(username2Element, input, "username2 textbox");
	}

	public void continueButton() {
		clickButton(continueButtonElement);
	}

}
