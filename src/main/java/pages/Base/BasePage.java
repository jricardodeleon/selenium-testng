package pages.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	private static final int TIMEOUT = 5;
	private static final int MAX_TIMEOUT = 10;
	private static final int POLLING = 100;
	
	protected WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(driver, this);	
	}

	/** ========================== Waits until element enabled on the page ===========================================*/
	protected void waitForElementToBeDisplayed(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected boolean isElementDisplayed(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}

	protected void waitForElementToDisappear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	protected void waitForTextToDisappear(WebElement element, String text) {
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text)));
	}

	/** ====================================== Enter data ============================================================*/
	public void sendTextToField(WebElement element, String text){
		waitForElementToBeDisplayed(element);
		element.clear();
		element.click();
		element.sendKeys(text);
	}

	/** =============================== Perform actions on elements ==================================================*/
	protected void clickOnElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}

	/** ==================================== Get elements ============================================================*/
	protected String getTextOf(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}

	/** ====================================== Mouse Over ============================================================*/
	public void mouseOver(WebElement element){
		Actions actions = new Actions(driver);
		waitForElementToBeDisplayed(element);
		actions.moveToElement(element).perform();
	}

	/** ====================================== Scroll into Element View ==============================================*/
	public void scrollIntoElementView(WebElement element){
		String scrollElementIntoView = "arguments[0].scrollIntoView(true)";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoView, element);
	}
	
}
