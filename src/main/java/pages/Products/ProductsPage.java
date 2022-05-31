package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'Products')]")
    private WebElement title;

    public boolean isProductTitleDisplayed(){
        return isElementDisplayed(title);
    }
}
