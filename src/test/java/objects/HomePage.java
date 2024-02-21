package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	By userarrowElement = By.id("userNav");
	By logOutElement = By.linkText("Logout");

	public void clickUserarrow() {
		clickButton(userarrowElement);
	}

	public void clickLogout() {
		clickButton(logOutElement);
	}
}
