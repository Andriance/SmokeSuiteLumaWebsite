package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".counter-number")
    private WebElement numberOfProductsInCart;
    @FindBy (css = "li[data-role='product-item']")
    private List<WebElement> productsInCart;
    @FindBy (css = "li[data-role='product-item']")
    private WebElement productInCart;
    @FindBy (css = ".showcart")
    private WebElement cart;
    @FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private WebElement confirmationMessage;
    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li[1]/div/div/div[1]/div[1]/span/span/span/span")
    private WebElement priceOfFirstProduct;
    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li[2]/div/div/div[1]/div[1]/span/span/span/span")
    private WebElement priceOfSecondProduct;
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[2]/div/span/span")
    private WebElement cartSubtotal;
    @FindBy(css = "button#top-cart-btn-checkout")
    private WebElement proceedToCheckout;


    public int getTheNumberOfProductsInCart(){
        cart.click();
        return productsInCart.size();
    }
    public int getTheNumberNextToTheCart(){
        int number= Integer.parseInt(numberOfProductsInCart.getText());
        return number;
    }
    public boolean numberOfProductInCart(){
        int productsInCart = getTheNumberOfProductsInCart();
        int numberNextToTheCart = getTheNumberNextToTheCart();
        if(productsInCart==numberNextToTheCart){
            return true;
        }
        return false;
    }
    public boolean presenceOfProductInCart(){
        waitForElementTextToAppear(confirmationMessage, correctConfirmationMessage);
        cart.click();
        if (productInCart.isDisplayed()){
            return true;
        }
        return false;
    }
    public boolean sumOfProductsPricesInCart(){
        String price1 = priceOfFirstProduct.getText();
        String justPrice1 = price1.substring(1, price1.length());
        String price2 = priceOfSecondProduct.getText();
        String justPrice2 = price2.substring(1, price1.length());
        double sum = Double.valueOf(justPrice1) + Double.valueOf(justPrice2);
        String totalPrice = cartSubtotal.getText();
        String totalPriceCart = totalPrice.substring(1,totalPrice.length());
        double totalPriceOfCart = Double.valueOf(totalPriceCart);
        if (sum==totalPriceOfCart){
            return true;
        }
        return false;
    }
    public void waitForMessageAndClickOnCart(){
        waitForElementToAppear(confirmationMessage);
        String message = confirmationMessage.getText();
        if(message.equals(correctConfirmationMessage)){
            cart.click();
        }else if (message.equals(correctConfirmationMessageForSecondProduct)){
            cart.click();
        }
    }
    public CheckOutPage goToCheckOut(){
        waitForElementToAppear(proceedToCheckout);
        proceedToCheckout.click();
        return new CheckOutPage(driver);
    }


}
