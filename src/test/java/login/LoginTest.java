package login;

import base.BaseTest;
import Utils.logger.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import pages.products.ProductsPage;

public class LoginTest extends BaseTest implements LoginConstants {

    LoginPage loginPage;
    ProductsPage productsPage;

    @Override
    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void negativeCheckErrorUserNameIsRequired() {
        Log.info("Negative Check Error");
        Assert.assertTrue(loginPage.isLoginVisible());
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(loginPage.errorMsgIsVisible());
        Assert.assertEquals(ERROR_MSG,loginPage.getTextErrorMsg());
    }

    @Test
    public void positiveUserIsAbleToLogin() {
        Log.info("Positive User Is Able To Login");
        loginPage.sentTextToUsernameField(STANDARD_USER);
        loginPage.sentTextToPasswordField(CORRECT_PASSWD);
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(productsPage.isProductTitleDisplayed());
    }



}
