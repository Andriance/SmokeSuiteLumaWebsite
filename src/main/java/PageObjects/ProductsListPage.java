package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsListPage extends AbstractComponents {
    WebDriver driver;
    public ProductsListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public By productsImages = By.cssSelector("img.product-image-photo");
    public By productsNames = By.cssSelector("a.product-item-link");
    public By productsPrices = By.cssSelector("span.price-container");

    @FindBy (css = "li.product")
    private List<WebElement> products;

    public void findTheProduct(String productName){
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            if (name.contains(productName)){
                products.get(i).click();
            }
        }
    }




}
