package pages.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(id = "user-name")
	private WebElement usernameField;

	@FindBy(id = "password")
	private WebElement passwordField;
	@FindBy(className = "login_logo")
	private WebElement loginLogo;
	@FindBy(name = "login-button")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//button[@class = 'error-button']")
	private WebElement errorBtn;
	@FindBy(xpath = "//h3[@data-test = 'error']")
	private WebElement errorMsg;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void sentTextToUsernameField(String username){
		usernameField.sendKeys(username);
	}

	public void sentTextToPasswordField(String password){
		passwordField.sendKeys(password);
	}

	public boolean isLoginVisible() {
		waitForElementToBeDisplayed(loginLogo);
		return loginLogo.isDisplayed();
	}
	public void clickOnLoginBtn() {
		clickOnElement(loginBtn);
	}
	public boolean errorMsgIsVisible() {
		waitForElementToBeDisplayed(errorMsg);
		return errorMsg.isDisplayed();
	}
	public String getTextErrorMsg(){
		return getTextOf(errorMsg);
	}
}
