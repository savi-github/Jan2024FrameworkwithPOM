package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterText(By usernameElement, String input, String msg) {
		driver.findElement(usernameElement).sendKeys(input);
	}
	
	public void clickButton(By loginButtonElement) {
		driver.findElement(loginButtonElement).click();
	}
}
