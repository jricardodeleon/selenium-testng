package pages.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	private static final int TIMEOUT = 5;
	private static final int POLLING = 100;
	
	protected WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(driver, this);	
	}
	
	protected void waitForElementToBeDisplayed(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected boolean isElementDisplayed(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}
	protected void clickOnElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}
	
	protected String getTextOf(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}

	protected void waitForElementToDisappear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	protected void waitForTextToDisappear(WebElement element, String text) {
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text)));
	}
	
}
