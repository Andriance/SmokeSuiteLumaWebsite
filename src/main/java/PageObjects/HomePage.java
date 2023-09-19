package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends AbstractComponents {
    WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public By blockPromo = By.cssSelector("div.blocks-promo");
    public By blockList = By.cssSelector("div.block-products-list");

    @FindBy (css = "span.button")
    private WebElement shopNewYogaButton;

    @FindBy (xpath = "//*[@id=\"ui-id-6\"]")
    private WebElement gear;

    @FindBy (css = "a#ui-id-27")
    private WebElement watches;

    public void goTo(){
        driver.get(homeURL);
    }

    public boolean isDisplayed(By elementXpath){
        waitForElementToAppear(elementXpath);
        return driver.findElement(elementXpath).isDisplayed();
    }

    public void goToWatchesPage(){
        AbstractComponents AC = new AbstractComponents(driver);
        HomePage HP = new HomePage(driver);
        AC.menu(HP.gear,HP.watches);
    }
    public void clickOnShopNewYogaButton(){
        shopNewYogaButton.click();
    }


}
