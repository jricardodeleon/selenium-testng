package test.Login;

import org.testng.Assert;
import org.testng.annotations.*;

import Base.BaseTest;
import Driver.DriverType;
import pages.Login.LoginPage;
import pages.Products.ProductsPage;

public class LoginPageTest extends BaseTest implements LoginConstants{
	
	LoginPage loginPage;
	ProductsPage productsPage;

	@Override
	@BeforeTest
	public void startDriver() {
		getHome(DriverType.CHROME);
	}
	
	@Override
	@BeforeMethod
	public void setupPages() {
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
	}

	@Test
	public void negativeCheckErrorUserNameIsRequired() {
		System.out.println("Negative Check Error");
		Assert.assertTrue(loginPage.isLoginVisible());
		loginPage.clickOnLoginBtn();
		Assert.assertTrue(loginPage.errorMsgIsVisible());
		Assert.assertEquals(ERROR_MSG,loginPage.getTextErrorMsg());
	}

	@Test
	public void positiveUserIsAbleToLogin() throws InterruptedException {
		System.out.println("Positive Check Error");
		loginPage.sentTextToUsernameField("standard_user");
		loginPage.sentTextToPasswordField("secret_sauce");
		loginPage.clickOnLoginBtn();
		Assert.assertTrue(productsPage.isProductTitleDisplayed());
	}

	@AfterTest
	@Override
	public void tearDown() {
		quitDriver();
	}


}
