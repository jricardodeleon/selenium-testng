package Base;


import java.util.concurrent.TimeUnit;

import Driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import Utils.dataProvider.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
	
	protected WebDriver driver;

	private static final int LONGTIME = 10;

	public BaseTest() {
	}
	
	public void browserType(DriverType type) {
		switch(type) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
	}

	public void getHome(DriverType type){
		browserType(type);
		driver.get(Constants.webURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(LONGTIME, TimeUnit.SECONDS);
	}
	
	public abstract void setupPages();
	public abstract void startDriver();
	public abstract void tearDown();
	
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	

}
