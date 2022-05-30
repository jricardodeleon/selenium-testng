package test.Login;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import Driver.DriverType;
import pages.Login.LoginPage;

public class LoginPageTest extends BaseTest implements LoginConstants{
	
	LoginPage loginPage;
	
	@Override
	@BeforeMethod
	public void setupPages() {
		loginPage = new LoginPage(driver);	
	}
	
	@Override
	@BeforeTest
	public void startDriver() {
		getHome(DriverType.CHROME);
	}
	
	@Test
	public void CheckErrorUserNameIsRequired() {
		Assert.assertTrue(loginPage.isLoginVisible());
		loginPage.clickOnLoginBtn();
		Assert.assertTrue(loginPage.errorMsgIsVisible());
		Assert.assertEquals(ERROR_MSG,loginPage.getTextErrorMsg());
	}

	@AfterTest
	@Override
	public void tearDown() {
		quitDriver();
	}


}
