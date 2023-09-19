package AbstractComponents;

import PageObjects.CreateAnAccountPage;
import PageObjects.SignInPage;
import TestData.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class AbstractComponents extends TestData {

    WebDriver driver;

    public AbstractComponents(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public By logo = By.cssSelector("a.logo");
    public By searchBox = By.cssSelector("input#search");
    public By menu = By.cssSelector("ul#ui-id-2");
    public By header = By.cssSelector("div.wrapper");
    public By footer = By.tagName("footer");

    @FindBy(linkText = "Create an Account")
    private WebElement createAnAccountHeader;
    @FindBy (xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    private WebElement arrow;
    @FindBy (xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
    private WebElement sigOutButton;
    @FindBy (xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]")
    private WebElement signInButton;

    public void waitForElementToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitForElementToAppear(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }
    public void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForURL(String url){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe(url));
    }
    public void waitForElementTextToAppear(WebElement findBy, String text){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(findBy, text));
    }
    public CreateAnAccountPage goToCreateAnAccountPage(){
        createAnAccountHeader.click();
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        return createAnAccountPage;
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
    public void clickOnSignOut(){
        waitForElementToAppear(arrow);
        arrow.click();
        sigOutButton.click();
    }
    public void clickOnBack(){
        driver.navigate().back();
    }

    public SignInPage clickOnSignIn(){
        signInButton.click();
        SignInPage signInPage = new SignInPage(driver);
        return signInPage;
    }

    public void menu(WebElement elementXpath1, WebElement elementXpath2){
        Actions actions = new Actions(driver);
        actions.moveToElement(elementXpath1).perform();
        AbstractComponents ac = new AbstractComponents(driver);
        ac.waitForElementToAppear(elementXpath2);
        elementXpath2.click();
    }
}
