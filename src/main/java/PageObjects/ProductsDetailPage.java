package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsDetailPage extends AbstractComponents {
    WebDriver driver;
    public ProductsDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCart;
    @FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private WebElement confirmationMessage;

    public void addProductToCart(){
        addToCart.click();
    }
    public String getTheConfirmationMessage(){
        waitForElementToAppear(confirmationMessage);
        return confirmationMessage.getText();
    }




}
