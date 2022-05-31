package base;

import Utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;

    private static final int LONGTIME = 10;

    public BaseTest() {
    }

    @BeforeTest
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void getHomePage(){
        driver.get(Constants.webURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(LONGTIME, TimeUnit.SECONDS);
    }

    public abstract void initPages();

    @AfterTest
    public void quitDriver() {
        if(driver!=null) {
            driver.close();
            driver.quit();
        }
    }
}
